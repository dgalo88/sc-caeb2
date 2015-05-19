package com.caeb2.util;

import java.text.MessageFormat;

public class Constants {

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
	public static final String GENERAL_ERROR = "No se puede realizar la acción solicitada.";
	public static final String CONTACT_ADMIN = "Contacte con el administrador.";
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
	public static final String JSP_ERROR = "Oops algo ha salido mal!";

	public static String getFormattedMessage(String message, Object[] params) {
		return MessageFormat.format(message, params);
	}

	public static void main(String[] args) {

		System.out.println(MessageFormat.format(USER_LOGIN, new Object[] { new String("user") }));

		System.out.println(getFormattedMessage(USER_LOGIN, new Object[] { new String("otro") }));

	}

}
