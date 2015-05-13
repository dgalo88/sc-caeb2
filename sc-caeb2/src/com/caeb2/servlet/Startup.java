package com.caeb2.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.actions.Actions;
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

//		String page = null;

		/**ApplicationResources provides a simple API 
		 * for retrieving constants and other 
		 * preconfigured values**/
//		ApplicationResources resource = ApplicationResources.getInstance();

		try {

			// Use a helper object to gather parameter 
			// specific information.
//			RequestHelper helper = new RequestHelper(request);

//			Command cmdHelper= helper.getCommand();

			// Command helper perform custom operation
//			page = cmdHelper.execute(request, response);

			String actionName = request.getParameter(Actions.ACTION);

			System.out.println("action = " + actionName);
			Class c = Class.forName(actions.getActionsMapping().get(actionName));
			Object o = c.newInstance();

			Method method = c.getMethod(actionName, HttpServletRequest.class, HttpServletResponse.class);

			method.invoke(null, request, response);
//			page = Login.login(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			Controller.getLogger().severe("EmployeeController:exception: " + e.getMessage());
//			request.setAttribute(resource.getMessageAttr(), "Exception occurred : " + e.getMessage());
//			page = resource.getErrorPage(e);

		}

		// dispatch control to view
//		dispatch(request, response, page);

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

	protected void dispatch(HttpServletRequest request, HttpServletResponse response, //
			String page) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
