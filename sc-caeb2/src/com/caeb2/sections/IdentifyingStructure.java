package com.caeb2.sections;

import java.io.IOException;
import java.util.logging.Level;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class IdentifyingStructure {
	private String street;
	private String nameHousing;
	private String homePhone;
	
	private PropertiesConfiguration prop;
	
	public IdentifyingStructure(String sessionId) {
		try {
			prop = Controller.getPropertiesFile( //
					Constants.PROP_FILE_DWELLING, PropFileRole.LOAD, sessionId);
			loadData();
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.WARNING, Constants.LOAD_PROP_ERROR, e);
			e.printStackTrace();
		}
	}
	
	private void loadData(){
		
		street = prop.getString(Constants.SECTION1_STREET,"");
		nameHousing = prop.getString(Constants.SECTION1_NAME_HOUSING,"");
		homePhone = prop.getString(Constants.SECTION1_HOME_PHONE,"");
		
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNameHousing() {
		return nameHousing;
	}

	public void setNameHousing(String nameHousing) {
		this.nameHousing = nameHousing;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

}
