package com.caeb2.util;

public class Parameters {
	private static String title="titulo";
	private static  int inpageNumber=0;
	
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		Parameters.title = title;
	}
	public static int getInpageNumber() {
		return inpageNumber;
	}
	public static void setInpageNumber(int inpageNumber) {
		Parameters.inpageNumber = inpageNumber;
	}
}
