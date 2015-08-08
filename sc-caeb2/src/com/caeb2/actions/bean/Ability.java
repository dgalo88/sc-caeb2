package com.caeb2.actions.bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;


public class Ability {
	
	private HashMap<String, String> artistic_ability = new HashMap<String, String>();
	private String artistic_ability_other = "";
	private String training_courses = "";
	private String training_courses_which = "";
	private String training_courses_options = "";
	private HashMap<String, String> play_sports = new HashMap<String, String>();
	private String play_sports_other = "";
	private String participate_athletically = "";
	private String participate_which = "";
	
	private PropertiesConfiguration prop;
	
	public Ability() {
		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
			loadData();
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.WARNING, Constants.LOAD_PROP_ERROR, e);
			e.printStackTrace();
		}
	}
	
	private void loadData(){
		
		setArtistic_ability(processArray(Constants.SECTION9_ARTISTIC_ABILITY));
		
		setArtistic_ability_other(prop.getString(Constants.SECTION9_ARTISTIC_ABILITY_OTHER,""));
		setTraining_courses(prop.getString(Constants.SECTION9_TRAINING_COURSES,""));
		setTraining_courses_which(prop.getString(Constants.SECTION9_TRAINING_COURSES_WHICH,""));
		setTraining_courses_options(prop.getString(Constants.SECTION9_TRAINING_COURSES_OPTIONS,""));
		setPlay_sports(processArray(Constants.SECTION9_PLAY_SPORTS));
		setPlay_sports_other(prop.getString(Constants.SECTION9_PLAY_SPORTS_OTHER,""));
		setParticipate_athletically(prop.getString(Constants.SECTION9_PARTICIPATE_ATHLETICALLY,""));
		setParticipate_which(prop.getString(Constants.SECTION9_PARTICIPATE_WHICH,""));
		
	}
	
	private HashMap<String, String> processArray(String filter){
		HashMap<String, String> result=new HashMap<String, String>();
		String[] data=prop.getStringArray(filter);
		for (String string : data) {
			result.put(string, string);
		}
		return result;
	}

	public HashMap<String, String> getArtistic_ability() {
		return artistic_ability;
	}

	public void setArtistic_ability(HashMap<String, String> artistic_ability) {
		this.artistic_ability = artistic_ability;
	}

	public String getTraining_courses() {
		return training_courses;
	}

	public void setTraining_courses(String training_courses) {
		this.training_courses = training_courses;
	}

	public String getParticipate_which() {
		return participate_which;
	}

	public void setParticipate_which(String participate_which) {
		this.participate_which = participate_which;
	}

	public String getParticipate_athletically() {
		return participate_athletically;
	}

	public void setParticipate_athletically(String participate_athletically) {
		this.participate_athletically = participate_athletically;
	}

	public String getPlay_sports_other() {
		return play_sports_other;
	}

	public void setPlay_sports_other(String play_sports_other) {
		this.play_sports_other = play_sports_other;
	}

	public HashMap<String, String> getPlay_sports() {
		return play_sports;
	}

	public void setPlay_sports(HashMap<String, String> play_sports) {
		this.play_sports = play_sports;
	}

	public String getTraining_courses_options() {
		return training_courses_options;
	}

	public void setTraining_courses_options(String training_courses_options) {
		this.training_courses_options = training_courses_options;
	}

	public String getTraining_courses_which() {
		return training_courses_which;
	}

	public void setTraining_courses_which(String training_courses_which) {
		this.training_courses_which = training_courses_which;
	}

	public String getArtistic_ability_other() {
		return artistic_ability_other;
	}

	public void setArtistic_ability_other(String artistic_ability_other) {
		this.artistic_ability_other = artistic_ability_other;
	}

}
