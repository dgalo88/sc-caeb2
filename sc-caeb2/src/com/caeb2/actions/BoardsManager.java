package com.caeb2.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caeb2.actions.bean.DwellingBasicData;
import com.caeb2.actions.bean.HomeBasicData;
import com.caeb2.actions.bean.PersonBasicDataMin;
import com.caeb2.database.LoadDataBase;
import com.caeb2.database.SaveDataBase;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;
import com.google.gson.Gson;

public class BoardsManager {

	//--------------------------------------------------------------------------------

	public static void loadAllDwellings(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String dwellingsJSON = loadAllDwellings();

		request.setAttribute("dwellingsJSON", dwellingsJSON);

		PollManager.forceCurrentPage(request, new Integer(0));

		Controller.forward(request, response, "dwellingBoard.jsp");

	}

	public static String loadAllDwellings() throws Exception {

		List<DwellingBasicData> dwellings = getAllDwellings();

		return dwellingsToJSON(dwellings);

	}

	public static List<DwellingBasicData> getAllDwellings() {

		List<DwellingBasicData> dwellings = new ArrayList<DwellingBasicData>();

		Connection connection = null;
		Statement statement = null;

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT v.id, v.callePasaje, v.nombre, e.viviendaId " //
					+ " FROM vivienda v, encuesta e WHERE v.id=e.viviendaId";
			statement.executeQuery(sql);

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {

				int dwellingId = resultSet.getInt(1);
				String dwellingAddress = resultSet.getString(2);
				String dwellingName = resultSet.getString(3);
				int dwellingPollNumber = resultSet.getInt(4);

				String crud = getButtonsCrud("Dwelling", dwellingId);

				dwellings.add(new DwellingBasicData(dwellingId, dwellingName, //
						dwellingAddress, dwellingPollNumber, crud));

			}

			resultSet.close();

		} catch (ClassNotFoundException | SQLException e) {

			Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e);

		} finally {

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

		return dwellings;

	}

	public static String dwellingsToJSON(List<DwellingBasicData> dwellings) {

		if (dwellings.isEmpty()) {
			return null;
		}

		StringBuilder json = new StringBuilder();
		Gson gson = new Gson();

		json.append("{\"data\":[ ");

		for (int i = 0; i < dwellings.size(); i++) {

			json.append(gson.toJson(dwellings.get(i)));

			if (i < dwellings.size() - 1) {
				json.append(", ");
			}

		}

		json.append(" ]");

		json.append(", \"columns\":[" //
				+ " { \"data\": \"id\", \"title\": \"Id\"}," //
				+ " { \"data\": \"name\", \"title\": \"Nombre o número\"}," //
				+ " { \"data\": \"address\", \"title\": \"Dirección\"}," //
				+ " { \"data\": \"pollNumber\", \"title\": \"Número de encuesta\"}," //
				+ " { \"data\": \"crud\", \"title\": \"Tareas\"}" //
				+ " ]}");

		return json.toString();

	}

	//--------------------------------------------------------------------------------

	public static void loadAllPersons(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String homeId = (String) request.getParameter(Constants.ATT_HOME_ID);

		request.setAttribute(Constants.ATT_HOME_ID, homeId);

		Controller.forward(request, response, "personBoard.jsp");

	}

	public static String loadAllPersons(int dwellingId) throws Exception {

		List<PersonBasicDataMin> dwellings = getAllPersons(dwellingId);

		return personsToJSON(dwellings);

	}

	public static List<PersonBasicDataMin> getAllPersons(int homeId) {

		List<PersonBasicDataMin> homes = new ArrayList<PersonBasicDataMin>();

		if (homeId <= 0) {
			return homes;
		}

		Connection connection = null;
		Statement statement = null;

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT p.id, p.apellidos, p.nombres, p.cedula, p.celular, p.parentescoJefeHogar " //
					+ " FROM persona p WHERE p.hogarId = '" + String.valueOf(homeId) + "'";
			statement.executeQuery(sql);

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {

				int personId = resultSet.getInt(1);
				String lastnames = resultSet.getString(2);
				String names = resultSet.getString(3);
				String cedula = resultSet.getString(4);
				String phone = resultSet.getString(5);
				String relationship = resultSet.getString(6);

				String crud = getButtonsCrud("Person", personId);

				homes.add(new PersonBasicDataMin(personId, lastnames, //
						names, cedula, phone, relationship, crud));

			}

			resultSet.close();

		} catch (ClassNotFoundException | SQLException e) {

			Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e);

		} finally {

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

		return homes;

	}

	public static String personsToJSON(List<PersonBasicDataMin> homes) {

		if (homes.isEmpty()) {
			return null;
		}

		StringBuilder json = new StringBuilder();
		Gson gson = new Gson();

		json.append("{\"data\":[ ");

		for (int i = 0; i < homes.size(); i++) {

			json.append(gson.toJson(homes.get(i)));

			if (i < homes.size() - 1) {
				json.append(", ");
			}

		}

		json.append(" ]");

		json.append(", \"columns\":[" //
				+ " { \"data\": \"id\", \"title\": \"Id\"}," //
				+ " { \"data\": \"lastnames\", \"title\": \"Apellidos\"}," //
				+ " { \"data\": \"names\", \"title\": \"Nombres\"}," //
				+ " { \"data\": \"cedula\", \"title\": \"Cédula\"}," //
				+ " { \"data\": \"phone\", \"title\": \"Teléfono\"}," //
				+ " { \"data\": \"relationship\", \"title\": \"Parentesco\"}," //
				+ " { \"data\": \"crud\", \"title\": \"Tareas\"}" //
				+ " ]}");

		return json.toString();

	}

	//--------------------------------------------------------------------------------

	public static void loadAllHomes(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String dwellingId = (String) request.getParameter(Constants.ATT_DWELLING_ID);

		request.setAttribute(Constants.ATT_DWELLING_ID, dwellingId);

		Controller.forward(request, response, "homeBoard.jsp");

	}

	public static String loadAllHomes(int dwellingId) throws Exception {

		List<HomeBasicData> dwellings = getAllHomes(dwellingId);

		return homesToJSON(dwellings);

	}

	public static List<HomeBasicData> getAllHomes(int dwellingId) {

		List<HomeBasicData> homes = new ArrayList<HomeBasicData>();

		if (dwellingId <= 0) {
			return homes;
		}

		Connection connection = null;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;

		try {

			connection = Controller.getConnection();

			String sql = "SELECT id FROM hogar WHERE viviendaId=?";

			statement1 = connection.prepareStatement(sql);

			statement1.setInt(1, dwellingId);

			statement1.executeQuery();

			ResultSet resultSet1 = statement1.getResultSet();

			while (resultSet1.next()) {

				int homeId = resultSet1.getInt(1);

				sql = "SELECT apellidos, nombres, COUNT(*) FROM persona WHERE hogarId=?";

				statement2 = connection.prepareStatement(sql);

				statement2.setInt(1, homeId);

				statement2.executeQuery();

				ResultSet resultSet2 = statement2.getResultSet();

				if (resultSet2.first()) {

					String headOfHousehold = resultSet2.getString(1) + ", " + resultSet2.getString(2);
					int numberPeople = resultSet2.getInt(3);

					String crud = getButtonsCrud("Home", homeId);

					homes.add(new HomeBasicData(homeId, headOfHousehold, numberPeople, crud));

				}

				resultSet2.close();

			}

			resultSet1.close();

		} catch (ClassNotFoundException | SQLException e) {

			Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e);

		} finally {

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

		return homes;

	}

	public static String homesToJSON(List<HomeBasicData> homes) {

		if (homes.isEmpty()) {
			return null;
		}

		StringBuilder json = new StringBuilder();
		Gson gson = new Gson();

		json.append("{\"data\":[ ");

		for (int i = 0; i < homes.size(); i++) {

			json.append(gson.toJson(homes.get(i)));

			if (i < homes.size() - 1) {
				json.append(", ");
			}

		}

		json.append(" ]");

		json.append(", \"columns\":[" //
				+ " { \"data\": \"id\", \"title\": \"Id\"}," //
				+ " { \"data\": \"headOfHousehold\", \"title\": \"Jefe del hogar\"}," //
				+ " { \"data\": \"numberPeople\", \"title\": \"Número de personas\"}," //
				+ " { \"data\": \"crud\", \"title\": \"Tareas\"}" //
				+ " ]}");

		return json.toString();

	}

	//--------------------------------------------------------------------------------

	public static String getButtonsCrud(String type, int id) {

		return new String("<div class=\\\"btn-group\\\" style=\\\"z-index: 9999;\\\">" //
				+ (type.equalsIgnoreCase("person") ? "" //
						: ("<button type=\\\"button\\\" class=\\\"btn btn-default view" + type + "Btn\\\" aria-label=\\\"Ver\\\"" //
								+ /*	*/"data-" + type.toLowerCase() + "-id=\\\"" + id //
								+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"right\\\" title=\\\"Ver\\\">" //
								+ /**/"<span class=\\\"glyphicon glyphicon-eye-open\\\" aria-hidden=\\\"true\\\"></span>" //
								+ "</button>")) //
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default edit" + type + "Btn\\\" aria-label=\\\"Editar\\\"" //
				+ /*	*/"data-" + type.toLowerCase() + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"right\\\" title=\\\"Editar\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-edit\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default delete" + type + "Btn\\\" aria-label=\\\"Eliminar\\\"" //
				+ /*	*/"data-" + type.toLowerCase() + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"left\\\" title=\\\"Eliminar\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-trash\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "</div>");

	}

	//--------------------------------------------------------------------------------

	public static void deleteDwelling(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		long dwellingId = Long.parseLong(request.getParameter(Constants.ATT_DWELLING_ID));

		boolean result = SaveDataBase.deleteDwelling(dwellingId);

		if (result) {
			Controller.sendTextResponse(response, TextUtils.getFormattedMessage( //
					Constants.SUCCESSFUL_DELETED, //
					new Object[] {new String("Vivienda"), new String("a")}));
		} else {
			Controller.sendErrorResponse(response, TextUtils.getFormattedMessage( //
					Constants.DELETE_ERROR, new Object[] {new String("Vivienda")}));
		}

	}

	//--------------------------------------------------------------------------------

	public static void deleteHome(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		long homeId = Long.parseLong(request.getParameter(Constants.ATT_HOME_ID));

		boolean result = SaveDataBase.deleteHome(homeId);

		if (result) {
			Controller.sendTextResponse(response, TextUtils.getFormattedMessage( //
					Constants.SUCCESSFUL_DELETED, //
					new Object[] {new String("Hogar"), new String("o")}));
		} else {
			Controller.sendErrorResponse(response, TextUtils.getFormattedMessage( //
					Constants.DELETE_ERROR, new Object[] {new String("Hogar")}));
		}

	}

	//--------------------------------------------------------------------------------

	public static void deletePerson(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		long personId = Long.parseLong(request.getParameter(Constants.ATT_PERSON_ID));

		boolean result = SaveDataBase.deletePerson(personId);

		if (result) {
			Controller.sendTextResponse(response, TextUtils.getFormattedMessage( //
					Constants.SUCCESSFUL_DELETED, //
					new Object[] {new String("Persona"), new String("a")}));
		} else {
			Controller.sendErrorResponse(response, TextUtils.getFormattedMessage( //
					Constants.DELETE_ERROR, new Object[] {new String("Persona")}));
		}

	}

	//--------------------------------------------------------------------------------

	private static void loadPollData(HttpServletRequest request, //
			HttpServletResponse response, Integer currPage) throws Exception {

		Logger logger = Controller.getLogger();

		logger.info(" + Load Poll Data");

		PollManager.forceCurrentPage(request, new Integer(0));

		String sessionId = request.getRequestedSessionId();

		PollManager.cleanPropFiles(sessionId);

		Long dwellingId = request.getParameter(Constants.ATT_DWELLING_ID) == null ? //
				null : Long.parseLong(request.getParameter(Constants.ATT_DWELLING_ID));

		if (dwellingId == null) {
			sendLoadDataError(response, sessionId, "dwelling");
			return;
		}

		logger.info("Load Dwelling: " + dwellingId);

		boolean loadDwellingResult = LoadDataBase.loadDwelling(dwellingId, sessionId);

		if (!loadDwellingResult) {
			sendLoadDataError(response, sessionId, "dwelling");
			return;
		}

		Controller.addId(Constants.PROP_FILE_DWELLING, sessionId, //
				Constants.ATT_DWELLING_ID, dwellingId);

		Long homeId = (request.getParameter(Constants.ATT_HOME_ID) == null ? //
				LoadDataBase.getPrimaryHome(dwellingId) //
				: Long.parseLong(request.getParameter(Constants.ATT_HOME_ID)));

		String fail = "home";

		if (homeId != null) {

			logger.info("Load Home: " + homeId);

			boolean loadHomeResult = LoadDataBase.loadHome(homeId.longValue(), sessionId);

			if (loadHomeResult) {

				Controller.addId(Constants.PROP_FILE_HOME, sessionId, //
						Constants.ATT_HOME_ID, homeId);

				Long personId = (request.getParameter(Constants.ATT_PERSON_ID) == null ? //
						LoadDataBase.getPrimaryPerson(homeId.longValue()) //
						: Long.parseLong(request.getParameter(Constants.ATT_PERSON_ID)));

				if (personId != null) {

					logger.info("Load Person: " + personId);

					boolean loadPersonResult = LoadDataBase.loadPerson(personId.longValue(), sessionId);

					if (loadPersonResult) {

						Controller.addId(Constants.PROP_FILE_PERSON, sessionId, //
								Constants.ATT_PERSON_ID, personId);

						PollManager.setCurrentPage(request, currPage);

						Controller.sendTextResponse(response, Constants.SUCCESSFUL_LOADED);

						logger.info(" - Load Poll Data");

						return;

					} else {
						fail = "person";
					}

				}

			} else {
				fail = "home";
			}

		}

		sendLoadDataError(response, sessionId, fail);

	}

	//--------------------------------------------------------------------------------

	public static void editDwelling(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);

		session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_UPDATE);
		session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_UPDATE);
		session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_UPDATE);

		loadPollData(request, response, new Integer(1));

	}

	//--------------------------------------------------------------------------------

	public static void editHome(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);

		session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_IGNORE);
		session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_UPDATE);
		session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_UPDATE);

		loadPollData(request, response, new Integer(4));

	}

	//--------------------------------------------------------------------------------

	public static void editPerson(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);

		session.setAttribute(Constants.ATT_DWELLING_OP, Constants.OP_IGNORE);
		session.setAttribute(Constants.ATT_HOME_OP, Constants.OP_IGNORE);
		session.setAttribute(Constants.ATT_PERSON_OP, Constants.OP_UPDATE);

		loadPollData(request, response, new Integer(5));

	}

	//--------------------------------------------------------------------------------

	private static void sendLoadDataError(HttpServletResponse response, //
			String sessionId, String fail) throws Exception {

		PollManager.cleanPropFiles(sessionId);
		Controller.getLogger().severe("Failed loading " + fail);
		Controller.sendErrorResponse(response, Constants.LOAD_DATA_ERROR);

	}

	//--------------------------------------------------------------------------------

}
