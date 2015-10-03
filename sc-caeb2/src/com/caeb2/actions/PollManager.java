package com.caeb2.actions;

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

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class PollManager {

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

	public static void newPoll( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		PollManager.setCurrentPage(request, 1);

		Controller.forward(request, response, "page_1.jsp");

	}

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

			Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e);

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

	public static String getObservations() {

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			return "";
		}

		String observations = prop.getString(Constants.SECTION3_OBSERVATIONS, "");

		return observations;

	}
	
	public static String getUser() {

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			return "";
		}

		String user = prop.getString(Constants.SECTION3_USER, "");

		return getPollsterName(user);

	}

}
