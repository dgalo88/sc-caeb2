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
import javax.servlet.http.HttpSession;

import com.caeb2.actions.Actions;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;

/**
 * Servlet implementation class Startup
 */
@WebServlet("/Startup")
public class Startup extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Actions actions;
	private static HttpSession session;

	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession session) {
		Startup.session = session;
	}

	public static void invalidateSession() {

		if (Startup.session != null) {
			Startup.session.removeAttribute(Constants.ATT_USER);
			Startup.session.invalidate();
		}

		Startup.session = null;

	}

	// Initializes the servlet.
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		this.actions = new Actions();
		Startup.session = null;

	}

	// Destroys the servlet.
	public void destroy() {
		invalidateSession();
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

		try {

			String actionName = request.getParameter(Constants.ACTION);

			if (TextUtils.isEmptyOrNull(actionName)) {
				Controller.getLogger().severe(Constants.IT_CANNOT_ERROR);
				Controller.forward(request, response, "error.jsp", Constants.ACTION_ERROR);
				return;
			}

			actionClass = actions.getActionClass(actionName);

			method = actionClass.getMethod(actionName, //
					HttpServletRequest.class, HttpServletResponse.class);

		} catch (Exception e) {

			Controller.putLogger(Level.SEVERE, Constants.ACTION_ERROR, e);

			try {
				Controller.forward(request, response, "error.jsp", Constants.ACTION_ERROR);
			} catch (Exception e1) {
				Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e1);
			}

			return;

		}

		try {
			method.invoke(null, request, response);
		} catch (Exception e) {

			Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e);

			try {
				Controller.forward(request, response, "error.jsp", Constants.GENERAL_ERROR);
			} catch (Exception e1) {
				Controller.putLogger(Level.SEVERE, Constants.GENERAL_ERROR, e1);
			}

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
