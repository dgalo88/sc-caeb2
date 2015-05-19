package com.caeb2.util;

public class Constants {

	public static final String ACTION = "action";

	// Attributes
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_SECTION = "section";
	public static final String ATT_PAGE_NUMBER = "pageNumber";

	// Messages
	public static final String FORWARD = "[REENVIAR] ";
	public static final String USER_LOGIN = "El usuario '0' ha iniciado sesión";

	// Errors Messages
	public static final String GENERAL_ERROR = "No se puede realizar la acción solicitada.";
	public static final String CONTACT_ADMIN = "Contacte con el administrador.";
	public static final String SQL_ERROR = "No se puede establecer la conexión con la base de datos.";
	public static final String ACTION_ERROR = "La acción solicitada no existe.";
	public static final String LOGIN_ERROR = "Combinación usuario/contraseña inválida.";

	public static void main(String[] args) {

		System.out.println(USER_LOGIN.replace("0", "usuario"));

	}

}
