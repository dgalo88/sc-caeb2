package com.caeb2.sections;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class HomeData {
	private PropertiesConfiguration prop;
	
	private String home = "";
	private String to = "";
	private String rooms = "";
	private String chief_couple = "";
	private String used_mercal = "";
	private String used_mercal_selected = "";
	private String food_markets = "";
	private String food_markets_response = "";
	private String number_bathrooms = "";
	private String total_persons = "";
	private String sleeps_3_or_more = "";
	private String used_pdval = "";
	private String used_pdval_selected = "";
	private String community_organization = "";
	private String community_organization_which = "";
	private String community_problems_other = "";
	private HashMap<String, String> community_problems=new HashMap<String, String>();
	
	public HomeData() {
		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
			loadData();
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.WARNING, Constants.LOAD_PROP_ERROR, e);
			e.printStackTrace();
		}
	}
	
	private void loadData(){
		
		home = prop.getString(Constants.SECTION4_HOME,"");
		to = prop.getString(Constants.SECTION4_TO,"");
		rooms = prop.getString(Constants.SECTION4_ROOMS,"");
		chief_couple = prop.getString(Constants.SECTION4_CHIEF_COUPLE,"");
		used_mercal = prop.getString(Constants.SECTION4_USED_MERCAL,"");
		used_mercal_selected = prop.getString(Constants.SECTION4_USED_MERCAL_SELECTED,"");
		food_markets = prop.getString(Constants.SECTION4_FOOD_MARKETS,"");
		food_markets_response = prop.getString(Constants.SECTION4_FOOD_MARKETS_RESPONSE,"");
		number_bathrooms = prop.getString(Constants.SECTION4_NUMBER_BATHROOMS,"");
		total_persons = prop.getString(Constants.SECTION4_TOTAL_PERSONS,"");
		sleeps_3_or_more = prop.getString(Constants.SECTION4_SLEEPS_3_OR_MORE,"");
		used_pdval = prop.getString(Constants.SECTION4_USED_PDVAL,"");
		used_pdval_selected = prop.getString(Constants.SECTION4_USED_PDVALL_SELECTED,"");
		community_organization = prop.getString(Constants.SECTION4_COMMUNITY_ORGANIZATIO,"");
		community_organization_which = prop.getString(Constants.SECTION4_COMMUNITY_ORGANIZATION_WHICH,"");
		community_problems=processArray(Constants.SECTION4_COMMUNITY_PROBLEMS);
		community_problems_other = prop.getString(Constants.SECTION4_COMMUNITY_PROBLEMS_OTHER,"");
		
	}
	
	private HashMap<String, String> processArray(String filter){
		HashMap<String, String> result=new HashMap<String, String>();
		String[] data=prop.getStringArray(filter);
		for (String string : data) {
			result.put(string, string);
		}
		return result;
	}

	public String getHome() {
		return home;
	}

	public String getTo() {
		return to;
	}

	public String getRooms() {
		return rooms;
	}

	public String getChief_couple() {
		return chief_couple;
	}

	public String getUsed_mercal() {
		return used_mercal;
	}

	public String getUsed_mercal_selected() {
		return used_mercal_selected;
	}

	public String getFood_markets() {
		return food_markets;
	}

	public String getFood_markets_response() {
		return food_markets_response;
	}

	public String getNumber_bathrooms() {
		return number_bathrooms;
	}

	public String getTotal_persons() {
		return total_persons;
	}

	public String getSleeps_3_or_more() {
		return sleeps_3_or_more;
	}

	public String getUsed_pdval_selected() {
		return used_pdval_selected;
	}

	public String getUsed_pdval() {
		return used_pdval;
	}

	public String getCommunity_organization() {
		return community_organization;
	}
	
	public String getCommunity_organization_which() {
		return community_organization_which;
	}

	public HashMap<String, String> getCommunity_problems() {
		return community_problems;
	}

	public String getCommunity_problems_other() {
		return community_problems_other;
	}

	public void setCommunity_problems_other(String community_problems_other) {
		this.community_problems_other = community_problems_other;
	}

}
