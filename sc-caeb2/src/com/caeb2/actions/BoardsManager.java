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
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.google.gson.Gson;

public class BoardsManager {

	//--------------------------------------------------------------------------------

	public static void loadAllDwellings( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

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

			String sql = "SELECT v.id, v.callePasaje, v.nombre, e.viviendaId FROM vivienda v, encuesta e WHERE v.id=e.viviendaId";
			statement.executeQuery(sql);

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {

				int dwellingId = resultSet.getInt(1);
				String dwellingAddress = resultSet.getString(2);
				String dwellingName = resultSet.getString(3);
				int dwellingPollNumber = resultSet.getInt(4);

				String crud = getButtonsCrud("dwelling", dwellingId);

				dwellings.add(new DwellingBasicData(dwellingId, dwellingName, dwellingAddress, dwellingPollNumber, crud));

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

	public static String getButtonsCrud(String type, int id) {

		return new String("<div class=\\\"btn-group\\\" style=\\\"z-index: 9999;\\\">" //
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default viewDwellingBtn\\\" aria-label=\\\"Ver\\\"" //
				+ /*	*/"data-" + type + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"top\\\" title=\\\"Ver\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-eye-open\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default editDwellingBtn\\\" aria-label=\\\"Editar\\\"" //
				+ /*	*/"data-" + type + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"top\\\" title=\\\"Editar\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-edit\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "<button type=\\\"button\\\" class=\\\"btn btn-default deleteDwellingBtn\\\" aria-label=\\\"Eliminar\\\"" //
				+ /*	*/"data-" + type + "-id=\\\"" + id //
				+ /*	*/"\\\" data-toggle=\\\"tooltip\\\" data-placement=\\\"top\\\" title=\\\"Eliminar\\\">" //
				+ /**/"<span class=\\\"glyphicon glyphicon-trash\\\" aria-hidden=\\\"true\\\"></span>" //
				+ "</button>" //
				+ "</div>");

	}

	//--------------------------------------------------------------------------------

}
