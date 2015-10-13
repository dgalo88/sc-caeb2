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
import com.caeb2.database.SaveDataBase;
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

		PollManager.cleanPropFiles(request.getRequestedSessionId());

		HttpSession session = request.getSession(false);

		session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_INSERT);
		session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_INSERT);
		session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_INSERT);

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

		HttpSession session = request.getSession(false);

		session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_IGNORE);
		session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_INSERT);
		session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_INSERT);

		Controller.addId(Constants.PROP_FILE_DWELLING, sessionId, //
				Constants.ATT_DWELLING_ID, dwellingId);

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

		HttpSession session = request.getSession(false);

		session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_IGNORE);
		session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_IGNORE);
		session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_INSERT);

		Controller.addId(Constants.PROP_FILE_DWELLING, sessionId, //
				Constants.ATT_DWELLING_ID, dwellingId);

		Controller.addId(Constants.PROP_FILE_HOME, sessionId, //
				Constants.ATT_HOME_ID, homeId);

		Controller.forwardToPage(request, response, new Integer(5));

		Controller.getLogger().info(" - New Person");

	}

	//--------------------------------------------------------------------------------

	public static void savePoll(HttpServletRequest request, //
			HttpServletResponse response, String sessionId) throws Exception {

		HttpSession session = request.getSession(false);

		boolean addPerson = TextUtils.stringToBoolean( //
				request.getParameter(Constants.ATT_ADD_PERSON));

		boolean addHome = TextUtils.stringToBoolean( //
				request.getParameter(Constants.ATT_ADD_HOME));

		String dwellingOp = (String) session.getAttribute(Constants.ATT_DWELLING_OP);
		String homeOp = (String) session.getAttribute(Constants.ATT_HOME_OP);
		String personOp = (String) session.getAttribute(Constants.ATT_PERSON_OP);

		Long dwellingId = null;

		if (dwellingOp.equals(Constants.OP_INSERT)) {

			Controller.getLogger().info("Insert Dwelling");

			dwellingId = SaveDataBase.insertDwelling(sessionId);

		} else {

			dwellingId = Controller.getId(Constants.PROP_FILE_DWELLING, //
					sessionId, Constants.ATT_DWELLING_ID);

			if (dwellingOp.equals(Constants.OP_UPDATE)) {

				Controller.getLogger().info("Update Dwelling");

				dwellingId = SaveDataBase.updateDwelling(dwellingId, sessionId);

			}

		}

		if (dwellingId == null) {
			Controller.sendErrorResponse(response, //
					Constants.INSERT_DWELLING_ERROR + " " + Constants.TRY_AGAIN);
			return;
		}

		Long homeId = null;

		if (homeOp.equals(Constants.OP_INSERT)) {

			Controller.getLogger().info("Insert Home - DwellingId = " + dwellingId.longValue());

			homeId = SaveDataBase.insertHome(dwellingId, sessionId);

		} else {

			homeId = Controller.getId(Constants.PROP_FILE_HOME, //
					sessionId, Constants.ATT_HOME_ID);

			if (homeOp.equals(Constants.OP_UPDATE)) {

				Controller.getLogger().info("Update Home - DwellingId = " + dwellingId.longValue());

				homeId = SaveDataBase.updateHome(homeId, sessionId);

			}

		}

		if (homeId == null) {

			SaveDataBase.deleteDwelling(dwellingId.longValue());

			Controller.sendErrorResponse(response, //
					Constants.INSERT_HOME_ERROR + " " + Constants.TRY_AGAIN);

			return;

		}

		Long personId = null;

		if (personOp.equals(Constants.OP_INSERT)) {

			Controller.getLogger().info("Insert Person - HomeId = " + homeId.longValue());

			personId = SaveDataBase.insertPerson(homeId, sessionId);

		} else {

			personId = Controller.getId(Constants.PROP_FILE_PERSON, //
					sessionId, Constants.ATT_PERSON_ID);

			if (personOp.equals(Constants.OP_UPDATE)) {

				Controller.getLogger().info("Update Person - HomeId = " + homeId.longValue());

				personId = SaveDataBase.updatePerson(personId, sessionId);

			}

		}

		if (personId == null) {

			SaveDataBase.deleteHomeComponents(homeId.longValue());
			SaveDataBase.deleteDwelling(dwellingId.longValue());

			Controller.sendErrorResponse(response, //
					Constants.INSERT_PERSON_ERROR + " " + Constants.TRY_AGAIN);

			return;

		}

		String target = "";

		if (addPerson) {

			target = "page_5.jsp?";

			session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_IGNORE);
			session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_IGNORE);
			session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_INSERT);

			Controller.addId(Constants.PROP_FILE_DWELLING, sessionId, //
					Constants.ATT_DWELLING_ID, dwellingId);

			Controller.addId(Constants.PROP_FILE_HOME, sessionId, //
					Constants.ATT_HOME_ID, homeId);

			PollManager.cleanPropFile(Constants.PROP_FILE_PERSON, sessionId);

		} else if (addHome) {

			target = "page_4.jsp?";

			session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_IGNORE);
			session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_INSERT);
			session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_INSERT);

			Controller.addId(Constants.PROP_FILE_DWELLING, sessionId, //
					Constants.ATT_DWELLING_ID, dwellingId);

			PollManager.cleanPropFile(Constants.PROP_FILE_PERSON, sessionId);
			PollManager.cleanPropFile(Constants.PROP_FILE_HOME, sessionId);

		} else {

			target = Constants.ACTION_HOME;

			session.removeAttribute(Constants.ATT_DWELLING_OP);
			session.removeAttribute(Constants.ATT_HOME_OP);
			session.removeAttribute(Constants.ATT_PERSON_OP);

			PollManager.cleanPropFiles(sessionId);

		}

		String jsonResponse = "{ \"response\":\"" + Constants.DATA_SAVED //
				+ "\", \"target\":\"" + target + "\" }";

		Controller.sendTextResponse(response, jsonResponse);

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
