package com.caeb2.util;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

public class TextUtils {

	public static String getFormattedMessage(String message, Object[] params) {
		return MessageFormat.format(message, params);
	}

	public static boolean isEmptyOrNull(String text) {
		return ((text == null) || (text.isEmpty()) || (text.trim().isEmpty()));
	}

	public static String escaparString(String data) throws UnsupportedEncodingException {

		if (data == null) {
			return null;
		}

		String newData = new String(data.getBytes("ISO-8859-1"), "UTF-8");
		newData = newData.replace(",", "\\,");
		return newData;
	}

	public static String caparComma(String data) throws UnsupportedEncodingException {

		if (data == null) {
			return null;
		}

		String newData = data.replace(",", "\\,");
		return newData;
	}
	
	public static String[] escaparArray(String[] data) throws UnsupportedEncodingException {

		if (data == null) {
			return null;
		}

		String newData[] = new String[data.length];

		for (int i = 0; i < data.length; i++) {
			String string = new String(data[i].getBytes("ISO-8859-1"), "UTF-8").replace(",", "\\,");
			newData[i] = string;
		}

		return newData;
	}
	
	public static String[] caparCommaArray(String[] data) throws UnsupportedEncodingException {

		if (data == null) {
			return null;
		}

		String newData[] = new String[data.length];

		for (int i = 0; i < data.length; i++) {
			String string = new String(data[i].replace(",", "\\,"));
			newData[i] = string;
		}

		return newData;
	}

	public static String replaceBlankSpaces(String text) {
		return text.replace(" ", "_");
	}

	/**
	 * Función que elimina acentos y caracteres especiales de una cadena de texto.
	 *
	 * Tomada de:
	 * <a href="http://www.v3rgu1.com/blog/231/2010/programacion/eliminar-acentos-y-caracteres-especiales-en-java">
	 *   http://www.v3rgu1.com/blog/231/2010/programacion/eliminar-acentos-y-caracteres-especiales-en-java
	 * </a>
	 *
	 * @param text
	 * @return cadena de texto limpia de acentos y caracteres especiales.
	 */
	public static String replaceRareSymbols(String text) {

		// Cadena de caracteres original a sustituir.
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ¡!¿?";

		// Cadena de caracteres ASCII que reemplazarán los originales.
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC____";

		String output = text;

		for (int i = 0; i < original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			output = output.replace(original.charAt(i), ascii.charAt(i));
		}

		return output;

	}

	public static String replaceRareSymbolsAndBlankSpaces(String text) {
		return replaceBlankSpaces(replaceRareSymbols(text));
	}

	public static boolean stringToBoolean(String text) {
		return ((text != null) && (text.equalsIgnoreCase("true") //
				|| text.equalsIgnoreCase("si") || text.equalsIgnoreCase("sí")));
	}

	public static String getBooleanString(String text) {
		return Boolean.toString(((text != null) && (text.equalsIgnoreCase("true") //
				|| text.equalsIgnoreCase("si") || text.equalsIgnoreCase("sí"))));
	}

}
