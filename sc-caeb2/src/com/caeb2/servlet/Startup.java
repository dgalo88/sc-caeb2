package com.caeb2.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.actions.Actions;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;
import com.caeb2.util.TextUtils;

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

		this.actions = new Actions();

		try {

			String sccaeb2Dir = Constants.PATH_REAL_PROJECT //
					+ Constants.FILE_SEPARATOR + Constants.SC_CAEB2;

			File file = new File(sccaeb2Dir);

			if (!file.exists()) {
				if (file.mkdir()) {
					Controller.getLogger().info("Directory '" + sccaeb2Dir + "' was created.");
				} else {
					Controller.getLogger().severe("Failed to create directory '" + sccaeb2Dir + "'.");
				}
			}

			String contextPath = config.getServletContext().getRealPath(File.separator);

			PropertiesConfiguration prop = Controller.getPropertiesFile( //
					contextPath + Constants.PROP_FILE_CONFIG, PropFileRole.LOAD);

			String dbHost = prop.getString(Constants.CONFIG_DB_HOST);
			String dbRootUser = prop.getString(Constants.CONFIG_DB_ROOT_USER);
			String dbRootPass = prop.getString(Constants.CONFIG_DB_ROOT_PASS);
			String dbName = prop.getString(Constants.CONFIG_DB_NAME);
			String dbUser = prop.getString(Constants.CONFIG_DB_USER);
			String dbPass = prop.getString(Constants.CONFIG_DB_PASS);

			Controller.setDBHost(dbHost);
			Controller.setDBRootUser(dbRootUser);
			Controller.setDBRootPass(dbRootPass);
			Controller.setDBName(dbName);
			Controller.setDBUser(dbUser);
			Controller.setDBPass(dbPass);

		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
		}

	}

	// Destroys the servlet.
	public void destroy() {

		// This manually deregisters JDBC driver, which prevents Tomcat
		// from complaining about memory leaks wrto this class
		Enumeration<Driver> drivers = DriverManager.getDrivers();

		while (drivers.hasMoreElements()) {

			Driver driver = drivers.nextElement();

			try {

				DriverManager.deregisterDriver(driver);

				Controller.getLogger().info(TextUtils.getFormattedMessage( //
						"Deregistering JDBC Driver: {0}", new Object[] {driver}));

			} catch (SQLException e) {
				Controller.putLogger(Level.SEVERE, TextUtils.getFormattedMessage( //
						"Error Deregistering JDBC Driver: {0}", new Object[] {driver}), e);
			}

		}

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
				Controller.forwardError(request, response, Constants.ACTION_ERROR);
				return;
			}

			actionClass = actions.getActionClass(actionName);

			method = actionClass.getMethod(actionName, //
					HttpServletRequest.class, HttpServletResponse.class);

		} catch (Exception e) {

			Controller.putLogger(Level.SEVERE, Constants.ACTION_ERROR, e);

			try {
				Controller.forwardError(request, response, Constants.ACTION_ERROR);
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
				Controller.forwardError(request, response, Constants.GENERAL_ERROR);
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
