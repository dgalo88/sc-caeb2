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

	private static final String DB_CONFIG_FILE = "censoaeb2.sql";
	private static final String DB_HOST = "localhost";

	private static final String DB_ROOT_PASS = "123456";
	private static final String DB_ROOT_USER = "root";
	private static final String DB_NAME = "censoaeb2";
	private static final String DB_PASS = "123456";

	private static final String SUPER_ADMIN_NAME = "admin";
	private static final String SUPER_ADMIN_PASS = "1234";

	public InitDatabase() {

		try {
			createDatabaseUser(DB_NAME, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			createDatabase(DB_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void init(String fileName) throws IOException, SQLException, ClassNotFoundException {

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
			statement.close();

		}

		connection.close();

		createSuperAdmin();

	}

	public void createDatabaseUser(String user, String pass) throws SQLException {

		String url = "jdbc:mysql://" + Controller.getDBHost();

		Connection connection = DriverManager.getConnection( //
				url, DB_ROOT_USER, DB_ROOT_PASS);
		Statement statement = connection.createStatement();

		String sql = "CREATE USER " + user + "@" + DB_HOST + " IDENTIFIED BY '" + pass + "'";

		statement.execute(sql);

		sql = "GRANT ALL PRIVILEGES ON *.* TO " + user + "@" + DB_HOST + "";

		statement.execute(sql);

		Controller.setDBUser(user);
		Controller.setDBPass(pass);

		statement.close();
		connection.close();

	}

	public void createDatabase(String dbName) throws SQLException {

		String url = "jdbc:mysql://" + Controller.getDBHost();

		Connection connection = DriverManager.getConnection(url, //
				Controller.getDBUser(), Controller.getDBPass());

		String sql = "CREATE DATABASE IF NOT EXISTS " + dbName //
				+ " DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci";

		Statement statement = connection.createStatement();
		statement.execute(sql);

		Controller.setDBName(dbName);

		statement.close();
		connection.close();

	}

	public void createSuperAdmin() throws ClassNotFoundException, SQLException {

		Connection connection = Controller.getConnection();

		String sql = "INSERT INTO administrador (usuario, clave) VALUES ('" //
				+ SUPER_ADMIN_NAME + "', SHA1('" + SUPER_ADMIN_PASS + "'))";

		Statement statement = connection.createStatement();
		statement.execute(sql);

		statement.close();
		connection.close();

	}

	public static void main(String[] args) {

		InitDatabase initDatabase = new InitDatabase();

		try {
			initDatabase.init(DB_CONFIG_FILE);
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
