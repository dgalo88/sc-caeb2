package com.caeb2.actions;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.servlet.Startup;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class PollManager {

	public static void setCurrentPage(HttpServletRequest request, //
			int currPage) throws Exception {

		HttpSession session = Startup.getSession();

		int prevPage = (int) session.getAttribute(Constants.ATT_CURR_PAGE);

		if (currPage > prevPage) {
			session.setAttribute(Constants.ATT_CURR_PAGE, currPage);
		}

	}

	public static void newPoll( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		PollManager.setCurrentPage(request, 1);

		Controller.forward(request, response, "page_1.jsp");

	}

	public static String getObservations() {

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			return "";
		}

		String observations = prop.getString(Constants.SECTION3_OBSERVATIONS, "");

		return observations;

	}

}
