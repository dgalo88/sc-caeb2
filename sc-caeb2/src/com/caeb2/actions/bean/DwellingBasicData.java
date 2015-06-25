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
import com.caeb2.util.TextUtils;
import com.google.gson.Gson;

public class DwellingBasicData {

	private int id;
	private String name;
	private String address;

	public DwellingBasicData(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public DwellingBasicData() {
		this(0, "", "");
	}

	public static void main(String[] args) {

		try {

			List<DwellingBasicData> dwellings = DwellingBasicData.getAllDwellings();
			System.out.println(getAllDwellingsJSON(dwellings));

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void loadAllDwellings( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<DwellingBasicData> dwellings = DwellingBasicData.getAllDwellings();
		String dwellingsJSON = getAllDwellingsJSON(dwellings);

		if (TextUtils.isEmptyOrNull(dwellingsJSON)) {
			Controller.sendErrorResponse(response, null);
		} else {
			Controller.sendJSONResponse(response, dwellingsJSON);
		}

	}

	public static List<DwellingBasicData> getAllDwellings() throws ClassNotFoundException, SQLException {

		List<DwellingBasicData> dwellings = new ArrayList<DwellingBasicData>();

		Connection connection = Controller.getConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT id, nombre, direccion FROM vivienda";
		statement.executeQuery(sql);

		ResultSet resultSet = statement.getResultSet();

		while (resultSet.next()) {

			int dwellingId = resultSet.getInt(1);
			String dwellingName = resultSet.getString(2);
			String dwellingAddress = resultSet.getString(3);

			dwellings.add(new DwellingBasicData(dwellingId, dwellingName, dwellingAddress));

		}

		resultSet.close();
		statement.close();
		connection.close();

		return dwellings;

	}

	public static String getAllDwellingsJSON(List<DwellingBasicData> dwellings) {

		if (dwellings.isEmpty()) {
			return null;
		}

		StringBuilder json = new StringBuilder();
		Gson gson = new Gson();

		json.append("\"data\": [\n");

		for (int i = 0; i < dwellings.size(); i++) {

			json.append(gson.toJson(dwellings.get(i)));

			if (i < dwellings.size() - 1) {
				json.append(",\n");
			}

		}

		json.append("\n],");

		json.append("\n\"columns\": [" //
				+ "\n{ \"data\": \"id\", \"title\": \"Id\"}," //
				+ "\n{ \"data\": \"name\", \"title\": \"Nombre o número\"}," //
				+ "\n{ \"data\": \"address\", \"title\": \"Dirección\"}" //
				+ "\n]");

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

}
