package com.caeb2.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;
import com.google.gson.Gson;

public class FormalityData {

	private String lastnames;
	private String names;
	private String sex;
	private String direction;

	public FormalityData(String lastnames, String names, String sex, String direction) {
		this.lastnames = lastnames;
		this.names = names;
		this.sex = sex;
		this.direction = direction;
	}

	public FormalityData() {
		this(null, null, null, null);
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

	public static void loadFormalityData( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Gson gson = new Gson();
		FormalityData formalityData = new FormalityData("Perez", "Pedro", "M", "Casa 2-22");
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
//		sql = "SELECT apellidos, nombres, sexo FROM persona WHERE cedulaId='" + cedulaId + "'";
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
//
//		FormalityData formalityData = new FormalityData(lastnames, names, sex, "Casa 2-22");
//
//		Gson gson = new Gson();
//
//		String jsonResponse = gson.toJson(formalityData);
//
//		Controller.sendTextResponse(response, jsonResponse);
//
//		resultSet.close();
//		statement.close();
//		connection.close();

	}

	public static void main(String[] args) {

		Gson gson = new Gson();
		FormalityData formalityData = new FormalityData("Perez", "Pedro", "M", "Casa 2-22");
		String jsonResponse = gson.toJson(formalityData);

		System.out.println(jsonResponse);

	}

}
