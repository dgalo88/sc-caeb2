package com.caeb2.util;

import java.text.MessageFormat;

public class Constants {

	public static final String EXECUTE = "startup";
	public static final String ACTION = "action";

	// Attributes
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_ERROR = "error";
	public static final String ATT_SECTION = "section";
	public static final String ATT_PAGE_NUMBER = "pageNumber";

	// Messages
	public static final String FORWARD = "[REENVIAR] ";
	public static final String USER_LOGIN = "El usuario ''{0}'' ha iniciado sesión";

	// Errors Messages
	public static final String ERROR = "Error";
	public static final String IT_CANNOT_ERROR = "No se puede realizar la acción solicitada.";
	public static final String CONTACT_ADMIN = "Contacte con el administrador.";
	public static final String GENERAL_ERROR = IT_CANNOT_ERROR + " " + CONTACT_ADMIN;
	public static final String SQL_ERROR = "No se puede establecer la conexión con la base de datos.";
	public static final String ACTION_ERROR = "La acción solicitada no existe.";
	public static final String LOGIN_ERROR = "Combinación usuario/contraseña inválida.";
	public static final String DRIVER_ERROR = "Driver JDBC no encontrado.";

	// JSP
	public static final String JSP_OK = "Aceptar";
	public static final String JSP_CANCEL = "Cancelar";
	public static final String JSP_NEXT = "Siguiente";
	public static final String JSP_PREV = "Anterior";
	public static final String JSP_SAVE = "Guardar";
	public static final String JSP_RETURN = "Regresar";
	public static final String JSP_ERROR = "Ups algo ha salido mal!";
	public static final String JSP_LOGIN_TITLE = "Bienvenido";
	public static final String JSP_USER = "Usuario";
	public static final String JSP_PASS = "Contraseña";
	public static final String JSP_SIGN_IN = "Iniciar Sesión";
	public static final String JSP_SIGN_OUT = "Cerrar Sesión";
	public static final String JSP_MENU = "Menú";
	public static final String JSP_NEW_POLL = "Nueva Encuesta";
	public static final String JSP_PROFILE = "Perfil";
	public static final String JSP_EXIT = "Salir";
	
	
	public static final String SECTION1_IDENTIFYING_STRUCTURE = "section1_identifying_structure";
	public static final String SECTION1_STREET = "section1_street";
	public static final String SECTION1_NAME_HOUSING = "section1_name_housing";
	public static final String SECTION1_HOME_PHONE = "section1_home_phone";
	
	public static final String SECTION2_STRUCTURE_TYPE = "section2_structure_type";
	public static final String SECTION2_HOLDING = "section2_holding";
	public static final String SECTION2_TOTAL_ROOMS = "section2_total_rooms";
	public static final String SECTION2_HOUSING_FITS_HOUSEHOLD = "section2_housing_fits_household";
	public static final String SECTION2_HOUSE_SECTOR = "section2_house_sector";
	public static final String SECTION2_HOUSE_SCALABILITY = "section2_house_scalability";
	public static final String SECTION2_WALLS = "section2_walls";
	public static final String SECTION2_CEILING = "section2_ceiling";
	public static final String SECTION2_FLAT = "section2_flat";
	public static final String SECTION2_LOCATION_KITCHEN = "section2_location_kitchen";
	public static final String SECTION2_HOUSING_WATER = "section2_housing_water";
	
	public static final String SECTION2_OTHER_HOUSING_WATER = "section2_other_housing_water"; 
	public static final String SECTION2_SANITARY_SERVICE = "section2_sanitary_service";
	public static final String SECTION2_ELECTRICAL_SERVICE = "section2_electrical_service";
	
	public static final String SECTION2_GARBAGE_COLLECTION = "section2_garbage_collection";
	public static final String SECTION2_HOUSING_RISK = "section2_housing_risk";
	public static final String SECTION2_URGENT_HOUSING_IMPROVEMENTS = "section2_urgent_housing_improvements";

	public static String getFormattedMessage(String message, Object[] params) {
		return MessageFormat.format(message, params);
	}

	public static void main(String[] args) {

		System.out.println(MessageFormat.format(USER_LOGIN, new Object[] { new String("user") }));

		System.out.println(getFormattedMessage(USER_LOGIN, new Object[] { new String("otro") }));

	}

}
