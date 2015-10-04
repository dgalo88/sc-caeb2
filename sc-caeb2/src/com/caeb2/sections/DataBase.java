package com.caeb2.sections;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class DataBase {
	
	protected PropertiesConfiguration prop;
	
	public DataBase() {
		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
		}
	}
	
	protected HashMap<String, String> processArray(String filter){
		HashMap<String, String> result=new HashMap<String, String>();
		String[] data=prop.getStringArray(filter);
		for (String string : data) {
			result.put(string, string);
		}
		return result;
	}

}
