package com.caeb2.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Controller;

public class PollManager {

	public static void newPoll( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Controller.forward(request, response, "page_1.jsp");
	}

}
