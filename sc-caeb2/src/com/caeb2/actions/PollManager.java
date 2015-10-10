package com.caeb2.actions;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.database.LoadDataBase;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;
import com.caeb2.util.TextUtils;

public class PollManager {

	//--------------------------------------------------------------------------------

	public static void setCurrentPage(HttpServletRequest request, //
			Integer currPage) throws Exception {

		HttpSession session = request.getSession(false);
		setCurrentPage(session, currPage);

	}

	public static void setCurrentPage(HttpSession session, //
			Integer currPage) throws Exception {

		Integer prevPage = session.getAttribute(Constants.ATT_CURR_PAGE) == null ? //
				0 : (Integer) session.getAttribute(Constants.ATT_CURR_PAGE);

		if (currPage > prevPage) {
			session.setAttribute(Constants.ATT_CURR_PAGE, currPage);
		}

	}

	//--------------------------------------------------------------------------------

	public static void newPoll(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Controller.getLogger().info(" + New Poll");

		Controller.forwardToPage(request, response, new Integer(1));

		Controller.getLogger().info(" - New Poll");

	}

	//--------------------------------------------------------------------------------

	public static void newHome(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Controller.getLogger().info(" + New Home");

		Long dwellingId = request.getParameter(Constants.ATT_DWELLING_ID) == null ? //
				null : Long.parseLong(request.getParameter(Constants.ATT_DWELLING_ID));

		if (dwellingId == null) {
			sendLoadingError(request, response, "dwelling (null)");
			return;
		}

		String sessionId = request.getRequestedSessionId();

		boolean loadDwellingResult = LoadDataBase.loadDwelling(dwellingId, sessionId);

		if (!loadDwellingResult) {
			sendLoadingError(request, response, "dwelling (from database)");
			return;
		}

		Controller.forwardToPage(request, response, new Integer(4));

		Controller.getLogger().info(" - New Home");

	}

	//--------------------------------------------------------------------------------

	public static void newPerson(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Controller.getLogger().info(" + New Person");

		Long dwellingId = request.getParameter(Constants.ATT_DWELLING_ID) == null ? //
				null : Long.parseLong(request.getParameter(Constants.ATT_DWELLING_ID));

		if (dwellingId == null) {
			sendLoadingError(request, response, "dwelling (null)");
			return;
		}

		String sessionId = request.getRequestedSessionId();

		boolean loadDwellingResult = LoadDataBase.loadDwelling(dwellingId, sessionId);

		if (!loadDwellingResult) {
			sendLoadingError(request, response, "dwelling (from database)");
			return;
		}

		Long homeId = request.getParameter(Constants.ATT_HOME_ID) == null ? //
				null : Long.parseLong(request.getParameter(Constants.ATT_HOME_ID));

		if (homeId == null) {
			sendLoadingError(request, response, "home (null)");
			return;
		}

		boolean loadHomeResult = LoadDataBase.loadHome(homeId.longValue(), sessionId);

		if (!loadHomeResult) {
			sendLoadingError(request, response, "home (from database)");
			return;
		}

		Controller.forwardToPage(request, response, new Integer(5));

		Controller.getLogger().info(" - New Person");

	}

	//--------------------------------------------------------------------------------

	private static void sendLoadingError(HttpServletRequest request, //
			HttpServletResponse response, String fail) throws Exception {

		Controller.getLogger().severe("Failed loading " + fail);
		Controller.forwardError(request, response, Constants.GENERAL_ERROR);

	}

	//--------------------------------------------------------------------------------

	public static String getPollsterName(String user) {

		String pollsterName = null;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT p.nombres, p.apellidos " //
					+ " FROM administrador a, directivaCC d, persona p " //
					+ " WHERE a.usuario='" + user //
					+ "' AND a.directivaCCId=d.id AND d.personaId=p.id";
			statement.executeQuery(sql);

			resultSet = statement.getResultSet();

			while (resultSet.next()) {

				String names = resultSet.getString(1);
				String lastNames = resultSet.getString(2);

				pollsterName = names + " " + lastNames;

			}

		} catch (ClassNotFoundException | SQLException e) {

			Controller.putLogger(Level.SEVERE, //
					Constants.GENERAL_ERROR + e.getMessage(), e);

		} finally {

			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// ignore
			}

			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// ignore
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// ignore
			}

		}

		return pollsterName;

	}

	//--------------------------------------------------------------------------------

	public static String getObservations(String sessionId) {

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile( //
					Constants.PROP_FILE_PERSON, PropFileRole.LOAD, sessionId);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, //
					Constants.LOAD_PROP_ERROR + e.getMessage(), e);
			return "";
		}

		String observations = prop.getString(Constants.SECTION3_OBSERVATIONS, "");

		return observations;

	}

	//--------------------------------------------------------------------------------

	public static String getUser(String sessionId) {

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile( //
					Constants.PROP_FILE_DWELLING, PropFileRole.LOAD, sessionId);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, //
					Constants.LOAD_PROP_ERROR + e.getMessage(), e);
			return "";
		}

		String user = prop.getString(Constants.SECTION3_USER, "");

		return getPollsterName(user);

	}

	//--------------------------------------------------------------------------------

	public static void cleanPropFiles(String sessionId) {

		cleanPropFile(Constants.PROP_FILE_DWELLING, sessionId);
		cleanPropFile(Constants.PROP_FILE_HOME, sessionId);
		cleanPropFile(Constants.PROP_FILE_PERSON, sessionId);

	}

	//--------------------------------------------------------------------------------

	public static void cleanPropFile(String propFile, String sessionId) {

		String prefix = Constants.PATH_REAL_PROJECT + Constants.FILE_SEPARATOR //
				+ Constants.SC_CAEB2 + Constants.FILE_SEPARATOR;

		propFile = prefix + sessionId + "-" + propFile;

		File file = new File(propFile);

		String message;
		Level level;

		if (file.delete()) {
			level = Level.INFO;
			message = Constants.FILE_DELETED;
		} else {
			level = Level.SEVERE;
			message = Constants.FILE_NOT_DELETED;
		}

		Controller.getLogger().log(level, TextUtils.getFormattedMessage( //
				message, new Object[] {propFile}));

	}

	//--------------------------------------------------------------------------------

}
