package com.caeb2.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.actions.bean.IdentificationDocument;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;

public class AdminProfile {

	private String lastnames;
	private String names;
	private IdentificationDocument cedula;
	private int phoneCod;
	private int phoneNum;
	private int phoneCodOptional;
	private int phoneNumOptional;
	private String email;

	public AdminProfile(String lastnames, String names, //
			IdentificationDocument cedula, int phoneCod, int phoneNum, //
			int phoneCodOptional, int phoneNumOptional, String email) {

		this.lastnames = lastnames;
		this.names = names;
		this.cedula = cedula;
		this.phoneCod = phoneCod;
		this.phoneNum = phoneNum;
		this.phoneCodOptional = phoneCodOptional;
		this.phoneNumOptional = phoneNumOptional;
		this.email = email;

	}

	public AdminProfile(String lastnames, String names, //
			IdentificationDocument cedula, //
			int phoneCod, int phoneNum, String email) {

		this(lastnames, names, cedula, phoneCod, phoneNum, 0, 0, email);

	}

	public AdminProfile() {
		this("", "", new IdentificationDocument(), 0, 0, 0, 0, "");
	}

	public static AdminProfile loadAdminProfileFromDB(String adminUser) throws Exception {

		Connection connection = Controller.getConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT directivaCCId FROM administrador WHERE usuario='" + adminUser + "'";
		statement.executeQuery(sql);
		ResultSet resultSet = statement.getResultSet();

		if (!resultSet.first()) {
			statement.close();
			connection.close();
			return null;
		}

		String directivaCCId = resultSet.getString(1);

		resultSet.close();

		if (directivaCCId == null) {

			statement.close();
			connection.close();

			return new AdminProfile("Vaca", "Super", //
					new IdentificationDocument(), 0, 0, "");

		}

		sql = "SELECT personaId FROM directivaCC WHERE id='" + directivaCCId + "'";
		statement.executeQuery(sql);
		resultSet = statement.getResultSet();

		String personaId = resultSet.getString(1);

		resultSet.close();

		sql = "SELECT apellidos, nombres, cedulaId, celularId, celularOpcionalId, correoElectronico FROM persona WHERE id='" //
				+ personaId + "'";

		statement.executeQuery(sql);
		resultSet = statement.getResultSet();

		String lastnames = resultSet.getString(1);
		String names = resultSet.getString(2);
		String cedulaId = resultSet.getString(3);
		String phoneId = resultSet.getString(4);
		String phoneOptionalId = resultSet.getString(5);
		String email = resultSet.getString(6);

		resultSet.close();

		sql = "SELECT tipo, numero FROM documentoIdentificacion WHERE id='" + cedulaId + "'";
		statement.executeQuery(sql);
		resultSet = statement.getResultSet();

		String cedType = resultSet.getString(1);
		int cedNumber = resultSet.getInt(2);

		IdentificationDocument cedula = new IdentificationDocument(cedType, cedNumber);

		resultSet.close();

		sql = "SELECT codigoArea, numero FROM telefono WHERE id='" + phoneId + "'";
		statement.executeQuery(sql);
		resultSet = statement.getResultSet();

		int phoneCod = resultSet.getInt(1);
		int phoneNum = resultSet.getInt(2);

		resultSet.close();

		int phoneCodOptional = 0;
		int phoneNumOptional = 0;

		if (phoneOptionalId != null) {

			sql = "SELECT codigoArea, numero FROM telefono WHERE id='" + phoneOptionalId + "'";
			statement.executeQuery(sql);
			resultSet = statement.getResultSet();

			phoneCodOptional = resultSet.getInt(1);
			phoneNumOptional = resultSet.getInt(2);

			resultSet.close();

		}

		statement.close();
		connection.close();

		return new AdminProfile(lastnames, names, cedula, //
				phoneCod, phoneNum, phoneCodOptional, phoneNumOptional, email);

	}

	public static void loadAdminProfile( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String user = (String) request.getSession().getAttribute(Constants.ATT_USER);

		AdminProfile adminProfile = loadAdminProfileFromDB(user);

		if (adminProfile != null) {
			request.setAttribute(Constants.ATT_ADMIN_PROFILE, adminProfile);
			Controller.forward(request, response, "profile.jsp");
		} else {
			Controller.getLogger().severe(Constants.LOGIN_ERROR);
			Controller.forward(request, response, "error.jsp", Constants.GENERAL_ERROR);
		}

	}

	public static void updateAdminProfile( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String currPass = request.getParameter(Constants.PROFILE_CURR_PASS);
		String newPass = request.getParameter(Constants.PROFILE_NEW_PASS);
		String confirmPass = request.getParameter(Constants.PROFILE_CONFIRM_PASS);

		response.setContentType("text/html;charset=UTF-8");

		if ((TextUtils.isEmptyOrNull(currPass)) //
				|| (TextUtils.isEmptyOrNull(newPass)) //
				|| (TextUtils.isEmptyOrNull(confirmPass)) //
				|| (!newPass.equals(confirmPass))) {

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(Constants.CHANGE_PASS_ERROR);

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

			response.setStatus(status);
			response.getWriter().print(msg);

		}

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

	public IdentificationDocument getCedula() {
		return cedula;
	}

	public void setCedula(IdentificationDocument cedula) {
		this.cedula = cedula;
	}

	public int getPhoneCod() {
		return phoneCod;
	}

	public void setPhoneCod(int phoneCod) {
		this.phoneCod = phoneCod;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getPhoneCodOptional() {
		return phoneCodOptional;
	}

	public void setPhoneCodOptional(int phoneCodOptional) {
		this.phoneCodOptional = phoneCodOptional;
	}

	public int getPhoneNumOptional() {
		return phoneNumOptional;
	}

	public void setPhoneNumOptional(int phoneNumOptional) {
		this.phoneNumOptional = phoneNumOptional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {

		String ret = "IndividualCharacteristics {\n" //
				+ "  Apellidos = " + lastnames + "\n" //
				+ "  Nombres = " + names + "\n";

		if ((cedula != null) && (cedula.getNumber() != 0)) {
			ret += "  Cédula = " + cedula.toString() + "\n";
		}

		ret += "  Teléfono celular = " + phoneCod + "-" + phoneNum + "\n";

		if (phoneNumOptional != 0) {
			ret += "  Teléfono celular (opcional) = " + phoneCodOptional + "-" + phoneNumOptional + "\n";
		}

		ret += "  Correo electrónico = " + email + "\n}";

		return ret;

	}

}
