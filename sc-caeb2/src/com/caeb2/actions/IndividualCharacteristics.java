package com.caeb2.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndividualCharacteristics {

	public static void saveIndividualCharacteristics( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String[] docId = request.getParameterValues("docId");

		for (int i = 0; i < docId.length; i++) {
			System.out.println(docId[i]);
		}

//		Controller.forward(request, response, "jsp/page_6");

	}

}
