package com.caeb2.util;

public class Parameters {

	private static String title = "";
	private static int pageNumber = 0;

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Parameters.title = title;
	}

	public static int getPageNumber() {
		return pageNumber;
	}

	public static void setPageNumber(int pageNumber) {
		Parameters.pageNumber = pageNumber;
	}

}
