package com.caeb2.actions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;

public class Login {

	public static void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connection = null;
		Statement statement = null;

		try {

			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			HttpSession session = request.getSession();

			connection = Controller.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT * FROM administrador WHERE usuario='" + user //
					+ "' AND clave=SHA1('" + pass + "')";

			if (statement.executeQuery(sql).first()) {

				Controller.getLogger().info(MessageFormat.format( //
						Constants.USER_LOGIN, new Object[] { user }));

				session.setAttribute(Constants.ATT_USER, user);

				Controller.forward(request, response, "main.jsp");

			} else {

				Controller.getLogger().severe(Constants.LOGIN_ERROR);
				Controller.forward(request, response, "error.jsp", Constants.LOGIN_ERROR);

			}

		} catch (ClassNotFoundException e) {

			Controller.putLogger(Level.SEVERE, //
					Constants.DRIVER_ERROR + Constants.CONTACT_ADMIN, e);

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

	public static void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		session.removeAttribute(Constants.ATT_USER);

		Controller.forward(request, response, "index.jsp");

	}

}
