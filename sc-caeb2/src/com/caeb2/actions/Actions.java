package com.caeb2.actions;

import java.util.HashMap;
import java.util.Map;

public class Actions {

	private Map<String, String> actionsMapping;

	public Actions() {

		actionsMapping = new HashMap<String, String>();

		actionsMapping.put("index", "com.caeb2.actions.ActionManager");
		actionsMapping.put("login", "com.caeb2.actions.ActionManager");
		actionsMapping.put("logout", "com.caeb2.actions.ActionManager");
		actionsMapping.put("saveProcessPage1", "com.caeb2.actions.Form");
		actionsMapping.put("saveProcessPage2", "com.caeb2.actions.Form");
		actionsMapping.put("saveProcessPage3", "com.caeb2.actions.Form");
		actionsMapping.put("saveProcessPage4", "com.caeb2.actions.Form");
		actionsMapping.put("saveProcessPage7", "com.caeb2.actions.Form");
		actionsMapping.put("saveProcessPage8", "com.caeb2.actions.Form");
		actionsMapping.put("savePersonBasicData", "com.caeb2.actions.IndividualCharacteristics");
		actionsMapping.put("savePersonEducationData", "com.caeb2.actions.IndividualCharacteristics");
		actionsMapping.put("saveAbilitiesData", "com.caeb2.actions.IndividualCharacteristics");
		actionsMapping.put("saveMissions", "com.caeb2.actions.IndividualCharacteristics");
		actionsMapping.put("loadAdminProfile", "com.caeb2.actions.ActionManager");
		actionsMapping.put("updateAdminProfile", "com.caeb2.actions.ActionManager");
		actionsMapping.put("loadFormalityData", "com.caeb2.actions.ActionManager");
		actionsMapping.put("newPoll", "com.caeb2.actions.PollManager");
		actionsMapping.put("newHome", "com.caeb2.actions.PollManager");
		actionsMapping.put("newPerson", "com.caeb2.actions.PollManager");
		actionsMapping.put("loadAllDwellings", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("loadAllHomes", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("loadAllPersons", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("deleteDwelling", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("deleteHome", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("deletePerson", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("editDwelling", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("editHome", "com.caeb2.actions.BoardsManager");
		actionsMapping.put("editPerson", "com.caeb2.actions.BoardsManager");

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
