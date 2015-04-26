package com.caeb2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller {
	
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/basededatos";
		return  DriverManager.getConnection(url, "usuario","contraseña");
	}

}
