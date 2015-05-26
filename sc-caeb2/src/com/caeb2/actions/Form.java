package com.caeb2.actions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Controller;

public class Form {

	public static void saveProcessPage1(HttpServletRequest request, HttpServletResponse response){
		
		String callePaseje=request.getParameter("calle_OP");
		String nombreVivienda=request.getParameter("nombre_NDV");
		String telefono=request.getParameter("telefono_R");
		
		FileOutputStream filePro = null;
		try {
			filePro = new FileOutputStream("C:\\Users\\Jose Hidalgo\\Desktop\\fichero.prop");
			Properties properties = new Properties();
			properties.setProperty("section1_calle_OP",callePaseje);
			properties.setProperty("section1_nombre_NDV",nombreVivienda);
			properties.setProperty("section1_telefono_R",telefono);
			
			properties.store(filePro, "Fichero de Propiedades de la Web");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				filePro.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		openProcessPage1(request, response);
	}
	
	public static void openProcessPage1(HttpServletRequest request, HttpServletResponse response){
		Properties properties = new Properties();
		InputStream filePro = null;
		try {
			
			filePro = new FileInputStream("C:\\Users\\Jose Hidalgo\\Desktop\\fichero.prop");
			properties.load(filePro);
			String callePaseje=properties.getProperty("section1_calle_OP");
			String nombreVivienda=properties.getProperty("section1_nombre_NDV");
			String telefono=properties.getProperty("section1_telefono_R");
			
			request.setAttribute("calle_OP", callePaseje);
			request.setAttribute("nombre_NDV", nombreVivienda);
			request.setAttribute("telefono", telefono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				filePro.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
			try {
				Controller.forward(request, response, "jsp/page_1.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
		
	}
}
