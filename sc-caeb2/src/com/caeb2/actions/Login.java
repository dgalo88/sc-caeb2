package com.caeb2.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Controller;

public class Login {

	public static String login(HttpServletRequest request, HttpServletResponse response) {

		String page = null;

		Connection connection = null;
		Statement statement = null;

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		Controller.getLogger().info(user + "/" + pass);

		try {

			connection = Controller.getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM administrador WHERE usuario='" + user //
					+ "' AND clave='" + pass + "'");

			while (rs.next()) {
				Controller.getLogger().info("excelente");
				page = "page_1.jsp";
			}

		} catch (ClassNotFoundException | SQLException e) {
			Controller.getLogger().severe(e.getLocalizedMessage());
		} finally {

			try {
				statement.close();
			} catch (SQLException e) {
				Controller.getLogger().severe(e.getLocalizedMessage());
			}

			try {
				connection.close();
			} catch (SQLException e) {
				Controller.getLogger().severe(e.getLocalizedMessage());
			}

		}

		try {
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

		return page;

	}

}
