package com.caeb2.sections;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class HousingData {
	
	private PropertiesConfiguration prop;
	
	private String structure_type="";
	private String holding="";
	private String total_rooms="";
	
	private String housing_fits_household="";
	private String house_sector="";
	private String house_scalability="";
	private String walls_type="";
	private String ceiling_type="";
	private String flat_type="";
	private String location_kitchen="";
	private String housing_water="";
	private String other_housing_water=""; 
	private String sanitary_service="";
	private String electrical_service="";
	private String garbage_collection="";
	private String housing_risk="";
	private String urgent_housing_improvements="";
	private HashMap<String, String> part=new HashMap<String, String>();
	private HashMap<String, String> required=new HashMap<String, String>();
	private HashMap<String, String> workNeeds=new HashMap<String, String>();
	
	private String part_other_response="";
	private String required_other_response="";
	private String work_needs_other_response="";
	
	public HousingData(String sessionId) {
		try {
			prop = Controller.getPropertiesFile( //
					Constants.PROP_FILE_DWELLING, PropFileRole.LOAD, sessionId);
			prop.setEncoding("UTF-8");
			loadData();
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.WARNING, Constants.LOAD_PROP_ERROR, e);
			e.printStackTrace();
		}
	}
	
	private void loadData(){
		structure_type=prop.getString(Constants.SECTION2_STRUCTURE_TYPE,"");
		holding=prop.getString(Constants.SECTION2_HOLDING,"");
		total_rooms=prop.getString(Constants.SECTION2_TOTAL_ROOMS,"");
		housing_fits_household=prop.getString(Constants.SECTION2_HOUSING_FITS_HOUSEHOLD,"");
		house_sector=prop.getString(Constants.SECTION2_HOUSE_SECTOR,"");
		house_scalability=prop.getString(Constants.SECTION2_HOUSE_SCALABILITY,"");
		walls_type=prop.getString(Constants.SECTION2_WALLS_TYPE,"");
		ceiling_type=prop.getString(Constants.SECTION2_CEILING_TYPE,"");
		flat_type=prop.getString(Constants.SECTION2_FLAT_TYPE,"");
		location_kitchen=prop.getString(Constants.SECTION2_LOCATION_KITCHEN,"");
		housing_water=prop.getString(Constants.SECTION2_HOUSING_WATER,"");

		other_housing_water=prop.getString(Constants.SECTION2_OTHER_HOUSING_WATER,""); 
		sanitary_service=prop.getString(Constants.SECTION2_SANITARY_SERVICE,"");
		electrical_service=prop.getString(Constants.SECTION2_ELECTRICAL_SERVICE,"");
		garbage_collection=prop.getString(Constants.SECTION2_GARBAGE_COLLECTION,"");
		housing_risk=prop.getString(Constants.SECTION2_HOUSING_RISK,"");
		urgent_housing_improvements=prop.getString(Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS,"");
		
		part=processArray(Constants.SECTION2_PART);
		required=processArray(Constants.SECTION2_REQUIRED);
		workNeeds=processArray(Constants.SECTION2_WORK_NEEDS);
		
		part_other_response=prop.getString(Constants.SECTION2_PART_OTHER_RESPONSE,"");
		required_other_response=prop.getString(Constants.SECTION2_REQUIRED_OTHER_RESPONSE,"");
		work_needs_other_response=prop.getString(Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE,"");
		
		if(part.containsKey("Otra ¿Cuál?"))
			part.put("Otra ¿Cuál?", part_other_response);
		
		if(required.containsKey("Otra ¿Cuál?"))
			required.put("Otra ¿Cuál?", required_other_response);
		
		if(workNeeds.containsKey("Otra ¿Cuál?"))
			workNeeds.put("Otra ¿Cuál?", work_needs_other_response);
		
	}
	
	private HashMap<String, String> processArray(String filter){
		HashMap<String, String> result=new HashMap<String, String>();
		String[] data=prop.getStringArray(filter);
		for (String string : data) {
			result.put(string, string);
		}
		return result;
	}

	public String getStructure_type() {
		return structure_type;
	}

	public void setStructure_type(String structure_type) {
		this.structure_type = structure_type;
	}

	public String getHolding() {
		return holding;
	}

	public void setHolding(String holding) {
		this.holding = holding;
	}

	public String getTotal_rooms() {
		return total_rooms;
	}

	public void setTotal_rooms(String total_rooms) {
		this.total_rooms = total_rooms;
	}

	public String getHousing_fits_household() {
		return housing_fits_household;
	}

	public void setHousing_fits_household(String housing_fits_household) {
		this.housing_fits_household = housing_fits_household;
	}

	public String getHouse_scalability() {
		return house_scalability;
	}

	public void setHouse_scalability(String house_scalability) {
		this.house_scalability = house_scalability;
	}

	public String getHouse_sector() {
		return house_sector;
	}

	public void setHouse_sector(String house_sector) {
		this.house_sector = house_sector;
	}

	public String getWalls_type() {
		return walls_type;
	}

	public void setWalls_type(String walls_type) {
		this.walls_type = walls_type;
	}

	public String getCeiling_type() {
		return ceiling_type;
	}

	public void setCeiling_type(String ceiling_type) {
		this.ceiling_type = ceiling_type;
	}

	public String getFlat_type() {
		return flat_type;
	}

	public void setFlat_type(String flat_type) {
		this.flat_type = flat_type;
	}

	public String getLocation_kitchen() {
		return location_kitchen;
	}

	public void setLocation_kitchen(String location_kitchen) {
		this.location_kitchen = location_kitchen;
	}

	public String getHousing_water() {
		return housing_water;
	}

	public void setHousing_water(String housing_water) {
		this.housing_water = housing_water;
	}

	public String getOther_housing_water() {
		if(!housing_water.equals("Otros medios, especifique"))
			return housing_water;
		return other_housing_water;
	}

	public void setOther_housing_water(String other_housing_water) {
		this.other_housing_water = other_housing_water;
	}

	public String getSanitary_service() {
		return sanitary_service;
	}

	public void setSanitary_service(String sanitary_service) {
		this.sanitary_service = sanitary_service;
	}

	public String getElectrical_service() {
		return electrical_service;
	}

	public void setElectrical_service(String electrical_service) {
		this.electrical_service = electrical_service;
	}

	public String getGarbage_collection() {
		return garbage_collection;
	}

	public void setGarbage_collection(String garbage_collection) {
		this.garbage_collection = garbage_collection;
	}

	public String getHousing_risk() {
		return housing_risk;
	}

	public void setHousing_risk(String housing_risk) {
		this.housing_risk = housing_risk;
	}

	public String getUrgent_housing_improvements() {
		return urgent_housing_improvements;
	}

	public void setUrgent_housing_improvements(
			String urgent_housing_improvements) {
		this.urgent_housing_improvements = urgent_housing_improvements;
	}

	public String getPart_other_response() {
		return part_other_response;
	}

	public void setPart_other_response(String part_other_response) {
		this.part_other_response = part_other_response;
	}

	public String getRequired_other_response() {
		return required_other_response;
	}

	public void setRequired_other_response(String required_other_response) {
		this.required_other_response = required_other_response;
	}

	public String getWork_needs_other_response() {
		return work_needs_other_response;
	}

	public void setWork_needs_other_response(String work_needs_other_response) {
		this.work_needs_other_response = work_needs_other_response;
	}

	public HashMap<String, String> getPart() {
		return part;
	}

	public void setPart(HashMap<String, String> part) {
		this.part = part;
	}

	public HashMap<String, String> getRequired() {
		return required;
	}

	public void setRequired(HashMap<String, String> required) {
		this.required = required;
	}

	public HashMap<String, String> getWorkNeeds() {
		return workNeeds;
	}

	public void setWorkNeeds(HashMap<String, String> workNeeds) {
		this.workNeeds = workNeeds;
	}

}
