package com.caeb2.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Controller;

/**
 * Servlet implementation class Startup
 */
@WebServlet("/Startup")
public class Startup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public Startup() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) //
	throws ServletException, IOException {

		System.out.println("2.........................");
		Connection connection = null;
		Statement statement = null;
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		
		System.out.println(user+"/"+pass);
		
		try {
			connection = Controller.getConnection();
			ResultSet rs;
			statement = connection.createStatement();
			rs=statement.executeQuery("SELECT * FROM administrador WHERE usuario='"+user+"' AND clave='"+pass+"'");
			while (rs.next()) {
				System.out.println("excelente");
				response.sendRedirect("http://localhost:8080/sc-caeb2/page_1.jsp");
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) //
	throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
