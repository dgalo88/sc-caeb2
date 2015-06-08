package com.caeb2.actions;

import java.util.HashMap;
import java.util.Map;

public class Actions {

	private Map<String, String> actionsMapping;

	public Actions() {

		actionsMapping = new HashMap<String, String>();

		actionsMapping.put("login", "com.caeb2.actions.Login");
		actionsMapping.put("logout", "com.caeb2.actions.Login");
		actionsMapping.put("identifyingStructure", "com.caeb2.actions.ActVivienda");
		actionsMapping.put("saveProcessPage1", "com.caeb2.actions.Form");

		actionsMapping.put("saveIndividualCharacteristics", "com.caeb2.actions.IndividualCharacteristics");
		actionsMapping.put("loadAdminProfile", "com.caeb2.actions.AdminProfile");
		actionsMapping.put("updateAdminProfile", "com.caeb2.actions.AdminProfile");

	}

	public Map<String, String> getActionsMapping() {
		return actionsMapping;
	}

	public void setActionsMapping(Map<String, String> actionsMapping) {
		this.actionsMapping = actionsMapping;
	}

	public void addActionMapping(String actionName, String className) {
		actionsMapping.put(actionName, className);
	}

	public String getActionClassName(String actionName) {
		return actionsMapping.get(actionName);
	}

	public Class<?> getActionClass(String actionName) throws ClassNotFoundException {
		return Class.forName(actionsMapping.get(actionName));
	}

}
