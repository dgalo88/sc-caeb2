package com.caeb2.actions;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caeb2.actions.bean.AdminProfile;
import com.caeb2.actions.bean.FormalityData;
import com.caeb2.actions.bean.IdentificationDocument;
import com.caeb2.actions.bean.PersonMinimalData;
import com.caeb2.actions.bean.Phone;
import com.caeb2.sync.Sincronizer;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;
import com.google.gson.Gson;

public class ActionManager {

	//--------------------------------------------------------------------------------

	public static void index(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		PollManager.cleanPropFiles(request.getRequestedSessionId());
		PollManager.forceCurrentPage(request, new Integer(0));

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

				PollManager.forceCurrentPage(request, new Integer(0));

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

	public static void initDB(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Controller.forward(request, response, "initDatabase.jsp");

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

	public static void generateFormality(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		PollManager.cleanPropFiles(request.getRequestedSessionId());
		PollManager.forceCurrentPage(request, new Integer(0));

		Controller.forward(request, response, "formalityGenerator.jsp");

	}

	//--------------------------------------------------------------------------------

	public static void createBackup(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Controller.forward(request, response, "createBackup.jsp");

	}

	//--------------------------------------------------------------------------------

	public static void prepararConexion(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String e_principal = request.getParameter("radio");

		if (e_principal.equals("equipo_temporal")) {
			request.setAttribute("messageBackup", //
					"Su equipo fue configurado como Temporal, presione siguiente para iniciar el proceso");
			request.setAttribute("type", "0");
			Controller.forward(request, response, "stateBackup.jsp");
		} else {
			request.setAttribute("messageBackup", //
					"Su equipo fue configurado como Principal, Espere a que el equipo temporal iniciel el proceso");
			request.setAttribute("type", "1");
			Controller.forward(request, response, "stateBackup.jsp");
		}

	}

	//--------------------------------------------------------------------------------

	public static void ejecutarCopiado(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Sincronizer sc =new Sincronizer();
		sc.enviarDatos();
		sc.reestablecerAdactador();
		request.setAttribute("messageBackup", "El proceso de copiado ha finalizado correctamente. Presione Inicio en el Menu para regresar a la pantalla principal");
		request.setAttribute("type", "1");
		URL url = new URL("http://"+sc.getDireccionServidor()+":8080/sc-caeb2/reset");
		url.openStream();
		Controller.forward(request, response, "stateBackup.jsp");

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

		if (TextUtils.isEmptyOrNull(directivaCCId)) {

			statement.close();
			connection.close();

			return new AdminProfile("Admin", "Super", //
					new IdentificationDocument(), new Phone(), new Phone(), "");

		}

		sql = "SELECT p.apellidos, p.nombres, p.cedula, p.celular, p.celularOpcional, p.correoElectronico " //
				+ " FROM persona p, directivaCC d WHERE p.id=d.personaId AND d.id='" + directivaCCId + "'";

		statement.executeQuery(sql);
		resultSet = statement.getResultSet();

		if (!resultSet.next()) {
			resultSet.close();
			statement.close();
			connection.close();
			return null;
		}

		String lastnames = resultSet.getString(1);
		String names = resultSet.getString(2);
		String cedulaDB = resultSet.getString(3);
		String phoneDB = resultSet.getString(4);
		String optionalPhoneDB = resultSet.getString(5);
		String email = resultSet.getString(6);

		IdentificationDocument cedula = new IdentificationDocument(cedulaDB);

		Phone phone = new Phone(phoneDB);

		Phone optionalPhone = new Phone();

		if (TextUtils.isEmptyOrNull(optionalPhoneDB)) {
			optionalPhone = new Phone(optionalPhoneDB);
		}

		resultSet.close();
		statement.close();
		connection.close();

		return new AdminProfile(lastnames, names, cedula, phone, optionalPhone, email);

	}

	//--------------------------------------------------------------------------------

	public static void loadAdminProfile( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user = (String) request.getSession(false).getAttribute(Constants.ATT_USER);

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

	public static String getPersons() {

		Controller.getLogger().info(" + Get Persons");

		List<PersonMinimalData> persons = new ArrayList<PersonMinimalData>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT id, apellidos, nombres, cedula FROM persona";

			statement.executeQuery(sql);

			resultSet = statement.getResultSet();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String lastnames = resultSet.getString(2);
				String names = resultSet.getString(3);

				IdentificationDocument cedula = new IdentificationDocument(resultSet.getString(4));

				persons.add(new PersonMinimalData(id, lastnames, names, cedula));

			}

		} catch (ClassNotFoundException | SQLException e) {

			Controller.putLogger(Level.SEVERE, Constants.LOAD_DATA_ERROR, e);

			return "[]";

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

		Controller.getLogger().info(" - Get Persons");

		return new Gson().toJson(persons);

	}

	//--------------------------------------------------------------------------------

	public static void saveNewUser(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		Controller.getLogger().info(" + Save new user");

		Connection connection = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		ResultSet resultSet = null;

		try {

			connection = Controller.getConnection();

			String personaId = request.getParameter(Constants.ATT_PERSON_ID);
			String user = request.getParameter(Constants.PROFILE_USER);
			String pass = request.getParameter(Constants.PROFILE_NEW_PASS);
			String directivaCCId = null;

			String sql = "INSERT INTO directivaCC (personaId) VALUES (?)";

			statement1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement1.setInt(1, Integer.parseInt(personaId));

			statement1.executeUpdate();

			resultSet = statement1.getGeneratedKeys();

			if (resultSet.next()) {
				directivaCCId = resultSet.getString(1);
			}

			sql = "INSERT INTO administrador (usuario, clave, directivaCCId) VALUES (?, SHA1(?), ?)";

			statement2 = connection.prepareStatement(sql);

			statement2.setString(1, user);
			statement2.setString(2, pass);
			statement2.setString(3, directivaCCId);

			statement2.executeUpdate();

			String msg = TextUtils.getFormattedMessage( //
					Constants.USER_SUCCESSFUL_CREATED, new Object[] {user});

			Controller.sendTextResponse(response, msg);

			Controller.getLogger().info(msg);

		} catch (ClassNotFoundException | SQLException e) {

			Controller.putLogger(Level.SEVERE, Constants.NEW_USER_ERROR, e);

			Controller.sendErrorResponse(response, Constants.NEW_USER_ERROR);

		} finally {

			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// ignore
			}

			try {
				if (statement1 != null) {
					statement1.close();
				}
			} catch (SQLException e) {
				// ignore
			}

			try {
				if (statement2 != null) {
					statement2.close();
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

		Controller.getLogger().info(" - Save new user");

	}

	//--------------------------------------------------------------------------------

}
