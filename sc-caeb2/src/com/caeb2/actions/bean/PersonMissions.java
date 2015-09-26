package com.caeb2.actions.bean;

import java.util.HashMap;

public class PersonMissions {

	private HashMap<String, String> missions;

	public PersonMissions(HashMap<String, String> missions) {
		this.missions = missions;
	}

	public PersonMissions() {
		this(new HashMap<String, String>());
	}

	public HashMap<String, String> getMissions() {
		return missions;
	}

	public void setMissions(HashMap<String, String> missions) {
		this.missions = missions;
	}

}
