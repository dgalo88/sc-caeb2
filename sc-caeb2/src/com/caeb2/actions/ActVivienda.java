package com.caeb2.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Controller;

public class ActVivienda {

	public static void identifyingStructure(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String urbanizacionPar = request.getParameter("urbanizacion");
		String nombreVivienda = request.getParameter("nombreVivienda");

		System.out.println("urbanizacionPar = " + urbanizacionPar);
		System.out.println("nombreVivienda = " + nombreVivienda);

		Controller.forward(request, response, "jsp/page_1.jsp");

	}

}
