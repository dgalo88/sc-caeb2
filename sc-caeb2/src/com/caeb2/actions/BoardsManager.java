package com.caeb2.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.actions.bean.DwellingBasicData;
import com.caeb2.actions.bean.HomeBasicData;
import com.caeb2.actions.bean.PersonBasicDataMin;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.google.gson.Gson;

public class BoardsManager {

	//--------------------------------------------------------------------------------

	public static void loadAllDwellings(HttpServletRequest request, //
			HttpServletResponse response) throws Exception {

		String dwellingsJSON = loadAllDwellings();

		request.setAttribute("dwellingsJSON", dwellingsJSON);

		Controller.forward(request, response, "dwellingBoard.jsp", "Message");

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

	public static void loadAllPersons( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String homeId = (String) request.getParameter("homeId");

		request.setAttribute("homeId", homeId);

		Controller.forward(request, response, "personBoard.jsp", "Message");

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

	public static void loadAllHomes( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String dwellingId = (String) request.getParameter("dwellingId");

		request.setAttribute("dwellingId", dwellingId);

		Controller.forward(request, response, "homeBoard.jsp", "Message");

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
		Statement statement = null;

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT h.id, p.apellidos, p.nombres, h.numeroPersonas " //
					+ " FROM hogar h, persona p WHERE h.id = '" + String.valueOf(dwellingId) //
					+ "' AND h.id = p.hogarId AND p.parentescoJefeHogar like 'Jefe o jefa del Hogar'";
			statement.executeQuery(sql);

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {

				int homeId = resultSet.getInt(1);
				String headOfHousehold = resultSet.getString(2) + ", " + resultSet.getString(3);
				int numberPeople = resultSet.getInt(4);

				String crud = getButtonsCrud("Home", homeId);

				homes.add(new HomeBasicData(homeId, headOfHousehold, numberPeople, crud));

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
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default view" + type + "Btn\\\" aria-label=\\\"Ver\\\"" //
				+ /*	*/"data-" + type.toLowerCase() + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"top\\\" title=\\\"Ver\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-eye-open\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default edit" + type + "Btn\\\" aria-label=\\\"Editar\\\"" //
				+ /*	*/"data-" + type.toLowerCase() + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"top\\\" title=\\\"Editar\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-edit\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default delete" + type + "Btn\\\" aria-label=\\\"Eliminar\\\"" //
				+ /*	*/"data-" + type.toLowerCase() + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"top\\\" title=\\\"Eliminar\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-trash\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "</div>");

	}

	//--------------------------------------------------------------------------------

}
