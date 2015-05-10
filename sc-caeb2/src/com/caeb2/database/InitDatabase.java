package com.caeb2.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.caeb2.util.Controller;

/**
 * @author D. Galo
 *
 */
public class InitDatabase {

	private static final String SEPARATOR = ";";
	private static final String COMMENT1 = "--";
	private static final String COMMENT2 = "/*";

	public InitDatabase() {

		try {
			createDatabaseUser("censoaeb2", "123456");
			createDatabase("censoaeb2");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void readSqlFile(String fileName) //
	throws IOException, SQLException, ClassNotFoundException {

		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line = new String();
		StringBuffer buffer = new StringBuffer();

		while ((line = bufferedReader.readLine()) != null) {

			if ((line.startsWith(COMMENT1)) || (line.startsWith(COMMENT2)) //
					|| (line.equals(""))) {
				continue;
			}

			buffer.append(line);

		}

		bufferedReader.close();

		String[] querys = buffer.toString().split(SEPARATOR);

		Connection connection = Controller.getConnection();

		for (String query : querys) {

			if (query.equals("")) {
				continue;
			}

			System.out.println(query + "\n");

			Statement statement = connection.createStatement();
			statement.execute(query);

		}

	}

	public static void createDatabaseUser(String user, String pass) //
	throws SQLException {

		String url = "jdbc:mysql://" + Controller.getDBHost();

		Connection connection = DriverManager.getConnection( //
				url, "root", "");
		Statement statement = connection.createStatement();

		String sql = "CREATE USER " + user + "@localhost IDENTIFIED BY '" + pass + "'";

		statement.execute(sql);
		
		sql = "GRANT ALL PRIVILEGES ON *.* TO " + user + "@localhost";

		statement.execute(sql);

		Controller.setDBUser(user);
		Controller.setDBPass(pass);

	}

	public static void createDatabase(String dbName) throws SQLException {

		String url = "jdbc:mysql://" + Controller.getDBHost();

		Connection connection = DriverManager.getConnection(url, //
				Controller.getDBUser(), Controller.getDBPass());

		String sql = "CREATE DATABASE IF NOT EXISTS " + dbName //
				+ " DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci";

		Statement statement = connection.createStatement();
		statement.execute(sql);

		Controller.setDBName(dbName);

	}

	public static void main(String[] args) {

		InitDatabase initDatabase = new InitDatabase();

		try {
			initDatabase.readSqlFile("censoaeb2.sql");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
