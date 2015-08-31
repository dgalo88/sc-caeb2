package com.caeb2.actions.bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class MedicalData {
	
	private PropertiesConfiguration prop;
	
	private HashMap<String, String> disabilities = new HashMap<String, String>();
	private HashMap<String, String> security_systems = new HashMap<String, String>();
	private String medical_assistance = "";
	private String medical_equipment_required = "";
	private String medical_equipment_which = "";
	private String medical_equipment_has = "";
	private String medical_equipment_other = "";
	
	private String medical_assistance_has = "";
	private String pregnant = "";
	
	private HashMap<String, String> diseases = new HashMap<String, String>();
	private String diseases_other = "";
	
	private String vaccines_BCG = "";
	private String vaccines_Triple = "";
	private String vaccines_Trivalente = "";
	private String vaccines_Polio = "";
	private String vaccines_HepatitisA = "";
	private String vaccines_HepatitisB = "";
	private String vaccines_Meningitis = "";
	private String vaccines_Sarampion = "";
	
	private String prenatal = "";
	
	public MedicalData() {
		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
			loadData();
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.WARNING, Constants.LOAD_PROP_ERROR, e);
			e.printStackTrace();
		}
	}
	
	private void loadData(){
		
		setDisabilities(processArray(Constants.SECTION8_DISABILITIES));
		setSecurity_systems(processArray(Constants.SECTION8_SECURITY_SYSTEMS));
		setMedical_assistance(prop.getString(Constants.SECTION8_MEDICAL_ASSISTANCE,""));
		setMedical_equipment_required(prop.getString(Constants.SECTION8_MEDICAL_EQUIPMENT_REQUIRED,""));
		setMedical_equipment_which(prop.getString(Constants.SECTION8_MEDICAL_EQUIPMENT_WHICH,""));
		setMedical_equipment_has(prop.getString(Constants.SECTION8_MEDICAL_EQUIPMENT_HAS,""));
		setMedical_equipment_other(prop.getString(Constants.SECTION8_MEDICAL_EQUIPMENT_OTHER,""));
		setMedical_assistance_has(prop.getString(Constants.SECTION8_MEDICAL_ASSISTANCE_HAS,""));
		setPregnant(prop.getString(Constants.SECTION8_PREGNANT,""));
		
		setDiseases(processArray(Constants.SECTION8_DISEASES));
		setDiseases_other(prop.getString(Constants.SECTION8_DISEASES_OTHER,""));
		
		setVaccines_BCG(prop.getString(Constants.SECTION8_VACCINES_BCG,""));
		setVaccines_Triple(prop.getString(Constants.SECTION8_VACCINES_TRIPLE,""));
		setVaccines_Trivalente(prop.getString(Constants.SECTION8_VACCINES_TRIVALENTE,""));
		setVaccines_Polio(prop.getString(Constants.SECTION8_VACCINES_POLIO,""));
		setVaccines_HepatitisA(prop.getString(Constants.SECTION8_VACCINES_HEPATITISA,""));
		setVaccines_HepatitisB(prop.getString(Constants.SECTION8_VACCINES_HEPATITISB,""));
		setVaccines_Meningitis(prop.getString(Constants.SECTION8_VACCINES_MENINGITIS,""));
		setVaccines_Sarampion(prop.getString(Constants.SECTION8_VACCINES_SARAMPION,""));
		setPrenatal(prop.getString(Constants.SECTION8_PRENATAL,""));
		
	}
	
	private HashMap<String, String> processArray(String filter){
		HashMap<String, String> result=new HashMap<String, String>();
		String[] data=prop.getStringArray(filter);
		for (String string : data) {
			result.put(string, string);
		}
		return result;
	}

	public HashMap<String, String> getDisabilities() {
		return disabilities;
	}

	public void setDisabilities(HashMap<String, String> disabilities) {
		this.disabilities = disabilities;
	}

	public HashMap<String, String> getSecurity_systems() {
		return security_systems;
	}

	public void setSecurity_systems(HashMap<String, String> security_systems) {
		this.security_systems = security_systems;
	}

	public String getMedical_assistance() {
		return medical_assistance;
	}

	public void setMedical_assistance(String medical_assistance) {
		this.medical_assistance = medical_assistance;
	}

	public String getMedical_assistance_has() {
		return medical_assistance_has;
	}

	public void setMedical_assistance_has(String medical_assistance_has) {
		this.medical_assistance_has = medical_assistance_has;
	}

	public String getVaccines_BCG() {
		return vaccines_BCG;
	}

	public void setVaccines_BCG(String vaccines_BCG) {
		this.vaccines_BCG = vaccines_BCG;
	}

	public String getMedical_equipment_which() {
		if(medical_equipment_required.equals("No"))
			return "No";
		return medical_equipment_which;
	}

	public void setMedical_equipment_which(String medical_equipment_which) {
		this.medical_equipment_which = medical_equipment_which;
	}

	public String getPregnant() {
		return pregnant;
	}

	public void setPregnant(String pregnant) {
		this.pregnant = pregnant;
	}

	public String getVaccines_Sarampion() {
		return vaccines_Sarampion;
	}

	public void setVaccines_Sarampion(String vaccines_Sarampion) {
		this.vaccines_Sarampion = vaccines_Sarampion;
	}

	public String getPrenatal() {
		return prenatal;
	}

	public void setPrenatal(String prenatal) {
		this.prenatal = prenatal;
	}

	public String getVaccines_Meningitis() {
		return vaccines_Meningitis;
	}

	public void setVaccines_Meningitis(String vaccines_Meningitis) {
		this.vaccines_Meningitis = vaccines_Meningitis;
	}

	public String getVaccines_Trivalente() {
		return vaccines_Trivalente;
	}

	public void setVaccines_Trivalente(String vaccines_Trivalente) {
		this.vaccines_Trivalente = vaccines_Trivalente;
	}

	public String getDiseases_other() {
		return diseases_other;
	}

	public void setDiseases_other(String diseases_other) {
		this.diseases_other = diseases_other;
	}

	public HashMap<String, String> getDiseases() {
		return diseases;
	}

	public void setDiseases(HashMap<String, String> diseases) {
		this.diseases = diseases;
	}

	public String getVaccines_Triple() {
		return vaccines_Triple;
	}

	public void setVaccines_Triple(String vaccines_Triple) {
		this.vaccines_Triple = vaccines_Triple;
	}

	public String getVaccines_Polio() {
		return vaccines_Polio;
	}

	public void setVaccines_Polio(String vaccines_Polio) {
		this.vaccines_Polio = vaccines_Polio;
	}

	public String getVaccines_HepatitisA() {
		return vaccines_HepatitisA;
	}

	public void setVaccines_HepatitisA(String vaccines_HepatitisA) {
		this.vaccines_HepatitisA = vaccines_HepatitisA;
	}

	public String getVaccines_HepatitisB() {
		return vaccines_HepatitisB;
	}

	public void setVaccines_HepatitisB(String vaccines_HepatitisB) {
		this.vaccines_HepatitisB = vaccines_HepatitisB;
	}

	public String getMedical_equipment_required() {
		return medical_equipment_required;
	}

	public void setMedical_equipment_required(String medical_equipment_required) {
		this.medical_equipment_required = medical_equipment_required;
	}

	public String getMedical_equipment_has() {
		return medical_equipment_has;
	}

	public void setMedical_equipment_has(String medical_equipment_has) {
		this.medical_equipment_has = medical_equipment_has;
	}

	public String getMedical_equipment_other() {
		if(!medical_equipment_which.equals("Otro ¿Cuál?"))
			return medical_equipment_which;
		return medical_equipment_other;
	}

	public void setMedical_equipment_other(String medical_equipment_other) {
		this.medical_equipment_other = medical_equipment_other;
	}
	
	public HashMap<String, String> getVaccines(){
		HashMap<String, String> vaccines = new HashMap<String, String>();
		vaccines.put("BCG", vaccines_BCG);
		vaccines.put("HepatitisA", vaccines_HepatitisA);
		vaccines.put("HepatitisB", vaccines_HepatitisB);
		vaccines.put("Meningitis", vaccines_Meningitis);
		vaccines.put("Polio", vaccines_Polio);
		vaccines.put("Sarampion", vaccines_Sarampion);
		vaccines.put("Triple", vaccines_Triple);
		vaccines.put("Trivalente", vaccines_Trivalente);
		return vaccines;
		
	}
	

}
