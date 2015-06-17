package com.caeb2.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Controller;
import com.google.gson.Gson;

public class FormalityData {

	private String lastnames;
	private String names;
	private String sex;
	private String direction;
	private String nationality;

	public FormalityData(String lastnames, String names, //
			String sex, String direction, String nationality) {
		this.lastnames = lastnames;
		this.names = names;
		this.sex = sex;
		this.direction = direction;
		this.nationality = nationality;
	}

	public FormalityData() {
		this(null, null, null, null, null);
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public static void loadFormalityData( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Gson gson = new Gson();
		FormalityData formalityData = new FormalityData("Perez", "Pedro", "M", "Casa 2-22", "Venezolano");
		String jsonResponse = gson.toJson(formalityData);

		Controller.sendTextResponse(response, jsonResponse);

		return;

//		String cedulaType = request.getParameter(Constants.SECTION5_CEDULA_TYPE);
//		String cedulaNum = request.getParameter(Constants.SECTION5_CEDULA_NUM);
//
//		Connection connection = Controller.getConnection();
//		Statement statement = connection.createStatement();
//
//		String sql = "SELECT id FROM documentoIdentificacion WHERE tipo='" //
//				+ cedulaType + "' AND numero='" + cedulaNum + "'";
//		statement.executeQuery(sql);
//
//		ResultSet resultSet = statement.getResultSet();
//
//		if (!resultSet.first()) {
//
//			resultSet.close();
//			statement.close();
//			connection.close();
//
//			Controller.sendErrorResponse(response, TextUtils.getFormattedMessage( //
//					Constants.NOT_FOUND_ERROR, new Object[] { cedulaType + "-" + cedulaNum }));
//
//			return;
//
//		}
//
//		String cedulaId = resultSet.getString(1);
//
//		resultSet.close();
//
//		if (TextUtils.isEmptyOrNull(cedulaId)) {
//
//			statement.close();
//			connection.close();
//
//			Controller.sendErrorResponse(response, Constants.GENERAL_ERROR);
//
//			return;
//
//		}
//
//		sql = "SELECT apellidos, nombres, sexo, hogarId, nacionalidad FROM persona WHERE cedulaId='" + cedulaId + "'";
//		statement.executeQuery(sql);
//
//		resultSet = statement.getResultSet();
//
//		if (!resultSet.first()) {
//
//			resultSet.close();
//			statement.close();
//			connection.close();
//
//			Controller.sendErrorResponse(response, Constants.READING_DATA_ERROR);
//
//			return;
//
//		}
//
//		String lastnames = resultSet.getString(1);
//		String names = resultSet.getString(2);
//		String sex = resultSet.getString(3);
//		String hogarId = resultSet.getString(4);
//		String nationality = resultSet.getString(5);
//
//		sql = "SELECT v.direccion FROM vivienda v WHERE v.id IN " //
//				+ "(SELECT h.viviendaId FROM hogar h WHERE h.id='" + hogarId + "')";
//
//		resultSet = statement.getResultSet();
//
//		if (!resultSet.first()) {
//
//			resultSet.close();
//			statement.close();
//			connection.close();
//
//			Controller.sendErrorResponse(response, Constants.READING_DATA_ERROR);
//
//			return;
//
//		}
//
//		String direction = resultSet.getString(1);
//
//		FormalityData formalityData = new FormalityData(lastnames, names, sex, direction, nationality);
//
//		Gson gson = new Gson();
//		String jsonResponse = gson.toJson(formalityData);
//
//		Controller.sendTextResponse(response, jsonResponse);
//
//		resultSet.close();
//		statement.close();
//		connection.close();

	}

}
