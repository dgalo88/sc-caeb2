package com.caeb2.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;

public class Login {

	public static void login(HttpServletRequest request, HttpServletResponse response) {

		String page = null;

		Connection connection = null;
		Statement statement = null;

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT * FROM administrador WHERE usuario='" + user //
					+ "' AND clave=SHA1('" + pass + "')";

			if (statement.executeQuery(sql).first()) {
				Controller.getLogger().info(Constants.USER_LOGIN.replace("0", user));
				page = "jsp/main.jsp";
			} else {
				Controller.getLogger().severe(Constants.LOGIN_ERROR);
				page = "jsp/error.jsp";
			}

		} catch (ClassNotFoundException e) {
			Controller.getLogger().log(Level.SEVERE, //
					Constants.DRIVER_ERROR + Constants.CONTACT_ADMIN, e);
		} catch (SQLException e) {
			Controller.getLogger().log(Level.SEVERE, Constants.SQL_ERROR, e);
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

		try {
			Controller.forward(request, response, page);
		} catch (ServletException | IOException e) {
			Controller.getLogger().log(Level.SEVERE, //
					Constants.GENERAL_ERROR + Constants.CONTACT_ADMIN, e);
		}

	}

}
