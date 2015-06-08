package com.caeb2.util;

import java.text.MessageFormat;

public class TextUtils {

	public static String getFormattedMessage(String message, Object[] params) {
		return MessageFormat.format(message, params);
	}

	public static boolean isEmptyOrNull(String text) {
		return ((text == null) || (text.isEmpty()) || (text.trim().isEmpty()));
	}

}
