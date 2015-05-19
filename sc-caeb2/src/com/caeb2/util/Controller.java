package com.caeb2.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String dbHost = "localhost";
	private static String dbName = "censoaeb2";
	private static String dbUser = "censoaeb2";
	private static String dbPass = "123456";

	private Controller() {
		// empty
	}

	public static Logger getLogger() {
		return Logger.getLogger("CAEB2Logger");
	}

	public static Connection getConnection() //
			throws SQLException, ClassNotFoundException {

		Class.forName(driver);
		String url = "jdbc:mysql://" + dbHost + "/" + dbName;
		return DriverManager.getConnection(url, dbUser, dbPass);

	}

	public static String getDBHost() {
		return dbHost;
	}

	public static void setDBHost(String dbHost) {
		Controller.dbHost = dbHost;
	}

	public static String getDBName() {
		return dbName;
	}

	public static void setDBName(String dbName) {
		Controller.dbName = dbName;
	}

	public static String getDBUser() {
		return dbUser;
	}

	public static void setDBUser(String dbUser) {
		Controller.dbUser = dbUser;
	}

	public static String getDBPass() {
		return dbPass;
	}

	public static void setDBPass(String dbPass) {
		Controller.dbPass = dbPass;
	}

	public static void forward(HttpServletRequest request, HttpServletResponse response, //
			String page) throws ServletException, IOException {

		getLogger().info(Constants.FORWARD + page);

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

	public static void forward(HttpServletRequest request, HttpServletResponse response, //
			String page, String message) throws ServletException, IOException {

		request.setAttribute(Constants.ATT_MESSAGE, message);

		forward(request, response, page);

	}

	public static void forwardParams(HttpServletRequest request, HttpServletResponse response, //
			String page, String params) throws ServletException, IOException {

		forward(request, response, page + "?" + params);

	}

	public static void forwardParams(HttpServletRequest request, HttpServletResponse response, //
			String page, String params, String message) throws ServletException, IOException {

		request.setAttribute(Constants.ATT_MESSAGE, message);

		forward(request, response, page + "?" + params);

	}

}
