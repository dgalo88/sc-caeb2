package com.caeb2.actions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.sections.IdentifyingStructure;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;

public class Form {

	public static void saveProcessPage1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String callePaseje=request.getParameter(Constants.SECTION1_STREET);
		String nombreVivienda=request.getParameter(Constants.SECTION1_NAME_HOUSING);
		String telefono=request.getParameter(Constants.SECTION1_HOME_PHONE);
		
		FileOutputStream filePro = null;
		try {
			filePro = new FileOutputStream("C:\\Users\\Jose Hidalgo\\Desktop\\fichero.prop");
			Properties properties = new Properties();
			properties.setProperty(Constants.SECTION1_STREET,callePaseje);
			properties.setProperty(Constants.SECTION1_NAME_HOUSING,nombreVivienda);
			properties.setProperty(Constants.SECTION1_HOME_PHONE,telefono);
			
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

		try {
			Controller.forward(request, response, "jsp/page_2.jsp");
		} catch (Exception e) {
			Controller.putLogger(Level.SEVERE, Constants.ERROR, e);
			throw new Exception(e);
		}

	}
	
	public static void openProcessPage1(HttpServletRequest request, HttpServletResponse response){
		Properties properties = new Properties();
		InputStream filePro = null;
		try {
			
			filePro = new FileInputStream("C:\\Users\\Jose Hidalgo\\Desktop\\fichero.prop");
			properties.load(filePro);
			IdentifyingStructure identifyingStructure = new IdentifyingStructure(
					properties.getProperty(Constants.SECTION1_STREET),
					properties.getProperty(Constants.SECTION1_NAME_HOUSING),
					properties.getProperty(Constants.SECTION1_HOME_PHONE));
			
			request.setAttribute(Constants.SECTION1_IDENTIFYING_STRUCTURE, identifyingStructure);
			
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
	public static void openProcessPage2(HttpServletRequest request, HttpServletResponse response){
//		Configuration configuration = new PropertiesConfiguration(filename);
		try {
			Configuration config = new PropertiesConfiguration("prop.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
