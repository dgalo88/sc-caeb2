package com.caeb2.actions.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Controller;
import com.google.gson.Gson;

public class DwellingBasicData {

	private int id;
	private String name;
	private String address;
	private int pollNumber;

	public DwellingBasicData(int id, String name, String address, int pollNumber) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.pollNumber = pollNumber;
	}

	public DwellingBasicData() {
		this(0, "", "", 0);
	}

	public static void loadAllDwellings( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<DwellingBasicData> dwellings = DwellingBasicData.getAllDwellings();
		String dwellingsJSON = dwellingsToJSON(dwellings);

		if (dwellingsJSON == null) {
			Controller.sendErrorResponse(response, null);
		} else {
			Controller.sendTextResponse(response, dwellingsJSON);
		}

	}

	public static List<DwellingBasicData> getAllDwellings() {

		List<DwellingBasicData> dwellings = new ArrayList<DwellingBasicData>();

		Connection connection = null;
		Statement statement = null;

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT v.id, v.nombre, v.direccion, e.viviendaId FROM vivienda v, encuesta e WHERE v.id=e.viviendaId";
			statement.executeQuery(sql);

			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {

				int dwellingId = resultSet.getInt(1);
				String dwellingName = resultSet.getString(2);
				String dwellingAddress = resultSet.getString(3);
				int dwellingPollNumber = resultSet.getInt(4);

				dwellings.add(new DwellingBasicData(dwellingId, dwellingName, dwellingAddress, dwellingPollNumber));

			}

			resultSet.close();

		} catch (ClassNotFoundException | SQLException e) {

//			Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e);
			System.out.println("dwellings size = " + dwellings.size());

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

		json.append("{\"data\":[\n");

		for (int i = 0; i < dwellings.size(); i++) {

			json.append(gson.toJson(dwellings.get(i)));

			if (i < dwellings.size() - 1) {
				json.append(",\n");
			}

		}

		json.append("\n]");

		json.append(",\n\"columns\":[" //
				+ "\n{ \"data\": \"id\", \"title\": \"Id\"}," //
				+ "\n{ \"data\": \"name\", \"title\": \"Nombre o número\"}," //
				+ "\n{ \"data\": \"address\", \"title\": \"Dirección\"}," //
				+ "\n{ \"data\": \"pollNumber\", \"title\": \"Número de encuesta\"}" //
				+ "\n]}");

		return json.toString();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPollNumber() {
		return pollNumber;
	}

	public void setPollNumber(int pollNumber) {
		this.pollNumber = pollNumber;
	}

}
