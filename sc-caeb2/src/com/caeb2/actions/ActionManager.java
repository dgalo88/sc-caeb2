package com.caeb2.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caeb2.actions.bean.AdminProfile;
import com.caeb2.actions.bean.FormalityData;
import com.caeb2.actions.bean.IdentificationDocument;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;
import com.google.gson.Gson;

public class ActionManager {

	//--------------------------------------------------------------------------------

	public static void index(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		PollManager.cleanPropFiles(request.getRequestedSessionId());
		PollManager.setCurrentPage(request, new Integer(0));

		Controller.forward(request, response, "index.jsp");

	}

	//--------------------------------------------------------------------------------

	public static void login(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Connection connection = null;
		Statement statement = null;

		try {

			String user = request.getParameter(Constants.ATT_USERNAME);
			String pass = request.getParameter(Constants.ATT_PASSWORD);

			HttpSession session = request.getSession();

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT * FROM administrador WHERE usuario='" + user //
					+ "' AND clave=SHA1('" + pass + "')";

			if (statement.executeQuery(sql).first()) {

				Controller.getLogger().info(MessageFormat.format( //
						Constants.USER_LOGIN, new Object[] { user }));

				session.setAttribute(Constants.ATT_USER, user);

				PollManager.setCurrentPage(session, new Integer(0));

				Controller.forward(request, response, "main.jsp");

			} else {

				String params = Constants.ATT_MESSAGE + "=" + Constants.LOGIN_ERROR //
						+ "&" + Constants.ATT_NOTIFICATION + "=" + Constants.ALERT_DANGER;

				request.setAttribute(Constants.ATT_USERNAME, user);

				Controller.getLogger().severe(Constants.LOGIN_ERROR);

				Controller.forwardParams(request, response, "index.jsp", params);


			}

		} catch (ClassNotFoundException e) {

			Controller.putLogger(Level.SEVERE, //
					Constants.DRIVER_ERROR + " " + Constants.CONTACT_ADMIN, e);

			throw new Exception(e);

		} catch (SQLException e) {

			Controller.putLogger(Level.SEVERE, Constants.SQL_ERROR, e);

			throw new Exception(e);

		} finally {

			try {
				statement.close();
			} catch (SQLException e) {
				// ignore
			}

			try {
				connection.close();
			} catch (SQLException e) {
				// ignore
			}

		}

	}

	//--------------------------------------------------------------------------------

	public static void logout(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String user = (String) session.getAttribute(Constants.ATT_USER);

		PollManager.cleanPropFiles(request.getRequestedSessionId());

		session.removeAttribute(Constants.ATT_USER);
		session.removeAttribute(Constants.ATT_CURR_PAGE);

		session.invalidate();

		Controller.getLogger().info(MessageFormat.format( //
				Constants.USER_LOGOUT, new Object[] { user }));

		Controller.forward(request, response, "index.jsp");

	}

	//--------------------------------------------------------------------------------

	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	//--------------------------------------------------------------------------------

	public static boolean checkAntiquity(Date arrivalDate) throws ParseException {
		long diff = getDateDiff(arrivalDate, new Date(), TimeUnit.DAYS) / 30;
		return diff >= 6;
	}

	//--------------------------------------------------------------------------------

	public static void loadFormalityData(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String cedulaType = request.getParameter(Constants.SECTION5_CEDULA_TYPE);
		String cedulaNum = request.getParameter(Constants.SECTION5_CEDULA_NUM);

		Connection connection = Controller.getConnection();
		Statement statement = connection.createStatement();

		if (TextUtils.isEmptyOrNull(cedulaType) || TextUtils.isEmptyOrNull(cedulaNum)) {

			statement.close();
			connection.close();

			Controller.sendErrorResponse(response, Constants.EMPTY_CEDULA_ERROR);

			return;

		}

		String cedula = cedulaType + cedulaNum;

		String sql = "SELECT apellidos, nombres, sexo, hogarId, nacionalidad, fechaLlegada " //
				+ " FROM persona WHERE cedula='" + cedula + "'";

		statement.executeQuery(sql);

		ResultSet resultSet = statement.getResultSet();

		if (!resultSet.first()) {

			resultSet.close();
			statement.close();
			connection.close();

			Controller.sendErrorResponse(response, Constants.READING_DATA_ERROR);

			return;

		}

		String lastnames = resultSet.getString(1);
		String names = resultSet.getString(2);
		String sex = resultSet.getString(3);
		String hogarId = resultSet.getString(4);
		String nationality = resultSet.getString(5);
		Date arrivalDate = resultSet.getDate(6);

		resultSet.close();

		if (!checkAntiquity(arrivalDate)) {

			statement.close();
			connection.close();

			Controller.sendErrorResponse(response, Constants.ARRIVAL_DATE_ERROR);

			return;

		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		sql = "SELECT v.callePasaje, v.nombre FROM hogar h, vivienda v WHERE h.id='" //
				+ hogarId + "' AND h.viviendaId=v.id";

		statement.executeQuery(sql);

		resultSet = statement.getResultSet();

		if (!resultSet.first()) {

			resultSet.close();
			statement.close();
			connection.close();

			Controller.sendErrorResponse(response, Constants.READING_DATA_ERROR);

			return;

		}

		String street = resultSet.getString(1);
		String houseName = resultSet.getString(2);

		String address = street + (TextUtils.isEmptyOrNull(houseName) ? //
				"" : ", Casa " + houseName);

		FormalityData formalityData = new FormalityData(lastnames, //
				names, sex, address, nationality, sdf.format(arrivalDate));

		Gson gson = new Gson();
		String jsonResponse = gson.toJson(formalityData);

		Controller.sendTextResponse(response, jsonResponse);

		resultSet.close();
		statement.close();
		connection.close();

	}

	//--------------------------------------------------------------------------------

	public static AdminProfile loadAdminProfileFromDB(String adminUser) throws Exception {

		Connection connection = Controller.getConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT directivaCCId FROM administrador WHERE usuario='" + adminUser + "'";
		statement.executeQuery(sql);
		ResultSet resultSet = statement.getResultSet();

		if (!resultSet.first()) {
			resultSet.close();
			statement.close();
			connection.close();
			return null;
		}

		String directivaCCId = resultSet.getString(1);

		resultSet.close();

		if (directivaCCId == null) {

			statement.close();
			connection.close();

			return new AdminProfile("Admin", "Super", //
					new IdentificationDocument(), 0, 0, "");

		}

		sql = "SELECT personaId FROM directivaCC WHERE id='" + directivaCCId + "'";
		statement.executeQuery(sql);
		resultSet = statement.getResultSet();

		String personaId = resultSet.getString(1);

		resultSet.close();

		sql = "SELECT apellidos, nombres, cedula, celular, celularOpcional, correoElectronico " //
				+ " FROM persona WHERE id='" + personaId + "'";

		statement.executeQuery(sql);
		resultSet = statement.getResultSet();

		String lastnames = resultSet.getString(1);
		String names = resultSet.getString(2);
		String cedulaBD = resultSet.getString(3);
		String phone = resultSet.getString(4);
		String phoneOptional = resultSet.getString(5);
		String email = resultSet.getString(6);

		String cedType = cedulaBD.substring(0, 1);
		int cedNumber = Integer.parseInt(cedulaBD.substring(1));

		IdentificationDocument cedula = new IdentificationDocument(cedType, cedNumber);

		int phoneCod = Integer.parseInt(phone.substring(0, 4));
		int phoneNum = Integer.parseInt(phone.substring(4));

		int phoneCodOptional = 0;
		int phoneNumOptional = 0;

		if (phoneOptional != null) {

			phoneCodOptional = Integer.parseInt(phoneOptional.substring(0, 4));
			phoneNumOptional = Integer.parseInt(phoneOptional.substring(4));

		}

		resultSet.close();
		statement.close();
		connection.close();

		return new AdminProfile(lastnames, names, cedula, //
				phoneCod, phoneNum, phoneCodOptional, phoneNumOptional, email);

	}

	//--------------------------------------------------------------------------------

	public static void loadAdminProfile( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user = (String) request.getSession().getAttribute(Constants.ATT_USER);

		AdminProfile adminProfile = loadAdminProfileFromDB(user);

		if (adminProfile != null) {
			request.setAttribute(Constants.ATT_ADMIN_PROFILE, adminProfile);
			Controller.forward(request, response, "profile.jsp");
		} else {
			Controller.getLogger().severe(Constants.LOGIN_ERROR);
			Controller.forwardError(request, response, Constants.GENERAL_ERROR);
		}

	}

	//--------------------------------------------------------------------------------

	public static void updateAdminProfile(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String currPass = request.getParameter(Constants.PROFILE_CURR_PASS);
		String newPass = request.getParameter(Constants.PROFILE_NEW_PASS);
		String confirmPass = request.getParameter(Constants.PROFILE_CONFIRM_PASS);

		if ((TextUtils.isEmptyOrNull(currPass)) //
				|| (TextUtils.isEmptyOrNull(newPass)) //
				|| (TextUtils.isEmptyOrNull(confirmPass)) //
				|| (!newPass.equals(confirmPass))) {

			Controller.sendErrorResponse(response, Constants.CHANGE_PASS_ERROR);

		}

		int status = HttpServletResponse.SC_BAD_REQUEST;
		String msg = Constants.IT_CANNOT_ERROR;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			String sessionUser = (String) request.getSession(false).getAttribute(Constants.ATT_USER);

			if (TextUtils.isEmptyOrNull(sessionUser)) {

				status = HttpServletResponse.SC_BAD_REQUEST;
				msg = Constants.CHANGE_PASS_ERROR;

				return;

			}

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT usuario FROM administrador WHERE clave=SHA1('" + currPass + "')";

			if (!statement.executeQuery(sql).first()) {

				status = HttpServletResponse.SC_BAD_REQUEST;
				msg = Constants.CHANGE_PASS_ERROR;

				return;

			}

			resultSet = statement.getResultSet();
			String dbUser = resultSet.getString(1);

			if (TextUtils.isEmptyOrNull(dbUser) || (!dbUser.equals(sessionUser))) {

				status = HttpServletResponse.SC_BAD_REQUEST;
				msg = Constants.CHANGE_PASS_ERROR;

				return;

			}

			sql = "UPDATE administrador SET clave=SHA1('" + newPass + "') WHERE usuario='" + dbUser + "'";

			statement.executeUpdate(sql);

			status = HttpServletResponse.SC_OK;
			msg = Constants.PASS_CHANGED;

			Controller.getLogger().info(msg);

		} catch (ClassNotFoundException e) {

			status = HttpServletResponse.SC_BAD_REQUEST;
			msg = Constants.DRIVER_ERROR + " " + Constants.CONTACT_ADMIN;

			Controller.putLogger(Level.SEVERE, msg, e);

		} catch (SQLException e) {

			status = HttpServletResponse.SC_BAD_REQUEST;
			msg = Constants.SQL_ERROR;

			Controller.putLogger(Level.SEVERE, msg, e);

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

			Controller.sendTextResponse(response, status, msg);

		}

	}

	//--------------------------------------------------------------------------------

}
