package com.caeb2.actions;

import java.util.HashMap;
import java.util.Map;

public class Actions {

	public static final String ACTION = "action";

	private Map<String, String> actionsMapping;

	public Actions() {

		actionsMapping = new HashMap<String, String>();

		actionsMapping.put("login", "com.caeb2.actions.Login");

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

}
