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
	
	public static String escaparString(String data) throws UnsupportedEncodingException{
		
		if(data==null){
			return null;
		}
		
		String newData=new String(data.getBytes("ISO-8859-1"),"UTF-8");
		newData=newData.replace(",","\\,");
		return newData;
	}
	
	public static String[] escaparArray(String[] data) throws UnsupportedEncodingException{
		
		if(data==null){
			return null;
		}
		
		String newData[]= new String[data.length];
		
		for (int i = 0; i < data.length; i++) {
			String string=new String(data[i].getBytes("ISO-8859-1"),"UTF-8").replace(",","\\,");
			newData[i]=string;
		}

		return newData;
	}
	

}
