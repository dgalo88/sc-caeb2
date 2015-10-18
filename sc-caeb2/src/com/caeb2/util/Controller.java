package com.caeb2.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.actions.PollManager;

public class Controller {

	public enum PropFileRole {
		SAVE, LOAD
	}

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

	private static String driver = "com.mysql.jdbc.Driver";
	private static String dbHost = "localhost";
	private static String dbName = "censoaeb2";
	private static String dbUser = "censoaeb2";
	private static String dbPass = "123456";

	private static String dbRootPass = "123456";
	private static String dbRootUser = "root";

	private static String superAdminName = "admin";
	private static String superAdminPass = "1234";

	private static Logger logger = Logger.getLogger("CAEB2Logger");

	private Controller() {
		// empty
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void putLogger(Level level, String msg, Throwable thrown) {
		logger.log(level, msg, thrown);
	}

	public static Connection getConnection() //
			throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://" + dbHost + "/" + dbName;
		return getConnection(url, dbUser, dbPass);

	}

	public static Connection getConnection(String url, String user, String pass) //
			throws SQLException, ClassNotFoundException {

		Class.forName(driver);
		return DriverManager.getConnection(url, user, pass);

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

	public static String getDbRootPass() {
		return dbRootPass;
	}

	public static void setDBRootPass(String dbRootPass) {
		Controller.dbRootPass = dbRootPass;
	}

	public static String getDbRootUser() {
		return dbRootUser;
	}

	public static void setDBRootUser(String dbRootUser) {
		Controller.dbRootUser = dbRootUser;
	}

	public static String getSuperAdminName() {
		return superAdminName;
	}

	public static void setSuperAdminName(String superAdminName) {
		Controller.superAdminName = superAdminName;
	}

	public static String getSuperAdminPass() {
		return superAdminPass;
	}

	public static void setSuperAdminPass(String superAdminPass) {
		Controller.superAdminPass = superAdminPass;
	}

	public static void forward(HttpServletRequest request, //
			HttpServletResponse response, String page) throws Exception {

		try {

			getLogger().info(Constants.FORWARD + page);

			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);

		} catch (ServletException | IOException e) {

			putLogger(Level.SEVERE, TextUtils.getFormattedMessage(//
					Constants.FORWARD_ERROR, new Object[] {page}), e);

			throw new Exception(e);

		}

	}

	public static void forward(HttpServletRequest request, //
			HttpServletResponse response, String page, //
			String message) throws Exception {

		request.setAttribute(Constants.ATT_MESSAGE, message);

		forward(request, response, page);

	}

	public static void forwardParams(HttpServletRequest request, //
			HttpServletResponse response, String page, //
			String params) throws Exception {

		forward(request, response, page + "?" + params);

	}

	public static void forwardParams(HttpServletRequest request, //
			HttpServletResponse response, String page, //
			String params, String message) throws Exception {

		request.setAttribute(Constants.ATT_MESSAGE, message);

		forward(request, response, page + "?" + params);

	}

	public static void forwardToPage(HttpServletRequest request, //
			HttpServletResponse response, String pageNum) throws Exception {

		PollManager.setCurrentPage(request, Integer.valueOf(pageNum));

		forward(request, response, "page_" + pageNum + ".jsp");

	}

	public static void forwardToTgtPage(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String pageNum = request.getParameter("tgt");

		PollManager.setCurrentPage(request, Integer.valueOf(pageNum));

		forward(request, response, "page_" + pageNum + ".jsp");

	}

	public static void forwardError(HttpServletRequest request, //
			HttpServletResponse response, String errorMessage) throws Exception {

		request.setAttribute(Constants.ATT_ERROR, errorMessage);

		forward(request, response, "error.jsp");

	}

	public static void sendResponse(HttpServletResponse response, //
			int status, String text, String contentType) throws Exception {

		try {

			getLogger().info(Constants.RESPONSE + text);

			response.setContentType(contentType);
			response.setStatus(status);
			response.getWriter().print(text);

		} catch (Exception e) {

			putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e);

			throw new Exception(e);

		}

	}

	public static void sendTextResponse(HttpServletResponse response, //
			int status, String text) throws Exception {

		sendResponse(response, status, text, "text/html;charset=UTF-8");

	}

	public static void sendTextResponse(HttpServletResponse response, //
			String text) throws Exception {

		sendResponse(response, HttpServletResponse.SC_OK, //
				text, "text/html;charset=UTF-8");

	}

	public static void sendJSONResponse(HttpServletResponse response, //
			int status, String text) throws Exception {

		sendResponse(response, status, text, "application/json;charset=UTF-8");

	}

	public static void sendJSONResponse(HttpServletResponse response, //
			String text) throws Exception {

		sendResponse(response, HttpServletResponse.SC_OK, //
				text, "application/json;charset=UTF-8");

	}

	public static void sendErrorResponse(HttpServletResponse response, //
			String text) throws Exception {

		sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, //
				text, "text/html;charset=UTF-8");

	}

	public static PropertiesConfiguration getPropertiesFile( //
			String propFileName, PropFileRole propFileType, String sessionId) //
					throws ConfigurationException, IOException {

		String prefix = Constants.PATH_REAL_PROJECT + Constants.FILE_SEPARATOR //
				+ Constants.SC_CAEB2 + Constants.FILE_SEPARATOR;

		propFileName = prefix + sessionId + "-" + propFileName;

		return getPropertiesFile(propFileName, propFileType);

	}

	public static PropertiesConfiguration getPropertiesFile( //
			String propFileName, PropFileRole propFileType) //
					throws ConfigurationException, IOException {

		switch (propFileType) {
		case SAVE:
			Controller.getLogger().info(MessageFormat.format( //
					Constants.SAVE_DATA_TO, new Object[] { propFileName }));
			break;
		case LOAD:
			Controller.getLogger().info(MessageFormat.format( //
					Constants.LOAD_DATA_FROM, new Object[] { propFileName }));
		default:
			break;
		}

		return new PropertiesConfiguration(new File(propFileName));

	}

	public static Long getId(String propFileName, String sessionId, String att) {

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile( //
					propFileName, PropFileRole.LOAD, sessionId);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			return null;
		}

		return prop.getLong(att, null);

	}

	public static void addId(String propFileName, String sessionId, String att, Long id) {

		PropertiesConfiguration prop = null;

		try {

			prop = Controller.getPropertiesFile( //
					propFileName, PropFileRole.SAVE, sessionId);

			prop.setProperty(att, id);

			prop.save();

		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
		}

	}

	public static HashMap<String, String> arrayToHashMap( //
			PropertiesConfiguration prop, String filter) {

		HashMap<String, String> result = new HashMap<String, String>();

		String[] data = prop.getStringArray(filter);

		for (String string : data) {
			result.put(string, string);
		}

		return result;

	}

	public static HashMap<String, Boolean> arrayToBooleanHashMap( //
			PropertiesConfiguration prop, String filter, String keysFilter) {

		HashMap<String, Boolean> result = new HashMap<String, Boolean>();

		String[] data = prop.getStringArray(filter);
		String[] keys = prop.getStringArray(keysFilter);

		for (int i = 0; i < keys.length; i++) {
			result.put(keys[i], Boolean.parseBoolean(data[i]));
		}

		return result;

	}

}
