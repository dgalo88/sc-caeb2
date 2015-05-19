package com.caeb2.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Level;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.actions.Actions;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;

/**
 * Servlet implementation class Startup
 */
@WebServlet("/Startup")
public class Startup extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Actions actions;

	// Initializes the servlet.
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		actions = new Actions();

	}

	// Destroys the servlet.
	public void destroy() {
		// empty
	}

	/** Processes requests for both HTTP  
	 * <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {

		Class<?> actionClass = null;
		Method method = null;

		String actionName = request.getParameter(Constants.ACTION);

		try {

			actionClass = Class.forName(actions.getActionClass(actionName));

			method = actionClass.getMethod(actionName, //
					HttpServletRequest.class, HttpServletResponse.class);

		} catch (Exception e) {
			Controller.getLogger().log(Level.SEVERE, Constants.ACTION_ERROR, e);
		}

		try {
			method.invoke(null, request, response);
		} catch (Exception e) {
			Controller.getLogger().log(Level.SEVERE, Constants.GENERAL_ERROR, e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
