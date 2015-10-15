package com.caeb2.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;
import com.oreilly.servlet.MultipartRequest;

/**
 * @author D. Galo
 *
 */
public class InitDatabase {

	private static final String SEPARATOR = ";";
	private static final String COMMENT1 = "--";
	private static final String COMMENT2 = "/*";

	private static final String DB_CONFIG_FILE = "censoaeb2.sql";

	public static void initDatabase(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String html = "<html><head><title>{0}</title></head>" //
				+ "<body><div align=\"center\"><br><h2>{1}</h2><p></div></body></html>";

		String uploadDir = Constants.PATH_REAL_PROJECT + Constants.PATH_SC_CAEB2;

		File file = new File(uploadDir);

		if (!file.exists()) {
			if (file.mkdir()) {
				Controller.getLogger().info("Directory '" + uploadDir + "' is created.");
			} else {
				Controller.getLogger().info("Failed to create directory '" + uploadDir + "'.");
			}
		}

		MultipartRequest multipartRequest = new MultipartRequest(request, uploadDir);

		String fileName = multipartRequest.getFilesystemName("file");
		String password = multipartRequest.getParameter(Constants.ATT_PASSWORD);

		if (TextUtils.isEmptyOrNull(password) || //
				!password.equals(Controller.getSuperAdminPass())) {

			Controller.sendErrorResponse(response, TextUtils.getFormattedMessage( //
					html, new Object[] {Constants.ERROR, Constants.INVALID_PASSWORD}));

			return;

		}

		if (TextUtils.isEmptyOrNull(fileName)) {

			Controller.sendErrorResponse(response, TextUtils.getFormattedMessage( //
					html, new Object[] {Constants.ERROR, Constants.IT_CANNOT_ERROR}));

			return;

		}

		String pathname = uploadDir + File.separator + fileName;

		try {
			InitDatabase.createDatabaseUser( //
					Controller.getDBUser(), Controller.getDBPass());
		} catch (SQLException | ClassNotFoundException e) {
			Controller.putLogger(Level.SEVERE, "Failed creating user", e);
		}

		try {
			InitDatabase.createDatabase(Controller.getDBName());
		} catch (SQLException | ClassNotFoundException e) {
			Controller.putLogger(Level.SEVERE, "Failed creating database", e);
		}

		try {

			Controller.getLogger().info("Loading database configuration from: " + pathname);

			InitDatabase.loadData(pathname);

			Controller.sendTextResponse(response, TextUtils.getFormattedMessage( //
					html, new Object[] {Constants.DB_INIT, Constants.DB_SUCCESSFUL_INIT}));

		} catch (IOException | SQLException | ClassNotFoundException e) {

			Controller.putLogger(Level.SEVERE, Constants.IT_CANNOT_ERROR, e);

			Controller.sendErrorResponse(response, TextUtils.getFormattedMessage( //
					html, new Object[] {Constants.ERROR, Constants.IT_CANNOT_ERROR}));

		}

	}

	public static void init(String fileName) {

		try {
			InitDatabase.createDatabaseUser(Controller.getDBUser(), Controller.getDBPass());
		} catch (SQLException | ClassNotFoundException e) {
			Controller.putLogger(Level.SEVERE, "Failed creating user", e);
		}

		try {
			InitDatabase.createDatabase(Controller.getDBName());
		} catch (SQLException | ClassNotFoundException e) {
			Controller.putLogger(Level.SEVERE, "Failed creating database", e);
		}

		try {
			InitDatabase.loadData(fileName);
		} catch (IOException | SQLException | ClassNotFoundException e) {
			Controller.putLogger(Level.SEVERE, "Failed loading database data", e);
		}

	}

	private static void loadData(String pathname) //
			throws IOException, SQLException, ClassNotFoundException {

		File file = new File(pathname);
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

	public static void createDatabaseUser(String user, String pass) //
			throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://" + Controller.getDBHost();

		Connection connection = Controller.getConnection( //
				url, Controller.getDbRootUser(), Controller.getDbRootPass());

		Statement statement = connection.createStatement();

		String sql = "CREATE USER " + user + "@" //
				+ Controller.getDBHost() + " IDENTIFIED BY '" + pass + "'";

		statement.executeUpdate(sql);

		sql = "GRANT ALL PRIVILEGES ON *.* TO " + user + "@" + Controller.getDBHost() + "";

		statement.execute(sql);

		statement.close();
		connection.close();

	}

	public static void createDatabase(String dbName) //
			throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://" + Controller.getDBHost();

		Connection connection = Controller.getConnection(url, //
				Controller.getDBUser(), Controller.getDBPass());

		String sql = "CREATE DATABASE IF NOT EXISTS " + dbName //
				+ " DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);

		statement.close();
		connection.close();

	}

	private static void createSuperAdmin() throws ClassNotFoundException, SQLException {

		Connection connection = Controller.getConnection();

		String sql = "INSERT INTO administrador (usuario, clave) VALUES ('" //
				+ Controller.getSuperAdminName() //
				+ "', SHA1('" + Controller.getSuperAdminPass() + "'))";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);

		statement.close();
		connection.close();

	}

	public static void main(String[] args) {
		InitDatabase.init(DB_CONFIG_FILE);
	}

}
