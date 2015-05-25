package com.caeb2.actions;

import java.util.HashMap;
import java.util.Map;

public class Actions {

	private Map<String, String> actionsMapping;

	public Actions() {

		actionsMapping = new HashMap<String, String>();

		actionsMapping.put("login", "com.caeb2.actions.Login");
		actionsMapping.put("identifyingStructure", "com.caeb2.actions.ActVivienda");

	}

	public Map<String, String> getActionsMapping() {
		return actionsMapping;
	}

	public void setActionsMapping(Map<String, String> actionsMapping) {
		this.actionsMapping = actionsMapping;
	}

	public void addActionMapping(String methodName, String className) {
		actionsMapping.put(methodName, className);
	}

	public String getActionClass(String methodName) {
		return actionsMapping.get(methodName);
	}

}
