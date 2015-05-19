package com.caeb2.util;

public class Constants {

	public static final String ACTION = "action";

	// Attributes
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_SECTION = "section";
	public static final String ATT_PAGE_NUMBER = "pageNumber";

	// Messages
	public static final String FORWARD = "[REENVIAR] ";
	public static final String USER_LOGIN = "El usuario '0' ha iniciado sesi�n";

	// Errors Messages
	public static final String GENERAL_ERROR = "No se puede realizar la acci�n solicitada.";
	public static final String CONTACT_ADMIN = "Contacte con el administrador.";
	public static final String SQL_ERROR = "No se puede establecer la conexi�n con la base de datos.";
	public static final String ACTION_ERROR = "La acci�n solicitada no existe.";
	public static final String LOGIN_ERROR = "Combinaci�n usuario/contrase�a inv�lida.";

	public static void main(String[] args) {

		System.out.println(USER_LOGIN.replace("0", "usuario"));

	}

}
