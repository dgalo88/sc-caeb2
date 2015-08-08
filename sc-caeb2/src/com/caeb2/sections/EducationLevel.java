package com.caeb2.sections;

import com.caeb2.util.Constants;

public class EducationLevel extends DataBase{
	
	private String degree_approved_text;
	private String degree_approved_level;
	private String you_are;
	private String occupation;
	private String occupation_value;
	private String work_performed;
	private String skills_activity;
	private String skills_activity_option;
	
	private String profession;
	private String main_job;
	private String body_works;
	private String monthly_income;
	private String received_credit;
	private String received_credit_value;
	private String received_credit_value_other;
	
	public EducationLevel() {
		super();
		loadData();
	}
	
	private void loadData(){
		setDegree_approved_text(prop.getString(Constants.SECTION7_DEGREE_APPROVED_TEXT,""));
		setDegree_approved_level(prop.getString(Constants.SECTION7_DEGREE_APPROVED_LEVEL,""));
		setYou_are(prop.getString(Constants.SECTION7_YOU_ARE,""));
		setOccupation(prop.getString(Constants.SECTION7_OCCUPATION,""));
		setOccupation_value(prop.getString(Constants.SECTION7_OCCUPATION_VALUE,""));
		setWork_performed(prop.getString(Constants.SECTION7_WORK_PERFORMED,""));
		setSkills_activity(prop.getString(Constants.SECTION7_SKILLS_ACTIVITY,""));
		setSkills_activity_option(prop.getString(Constants.SECTION7_SKILLS_ACTIVITY_OPTION,""));
		
		setProfession(prop.getString(Constants.SECTION7_PROFESSION,""));
		setMain_job(prop.getString(Constants.SECTION7_MAIN_JOB,""));
		setBody_works(prop.getString(Constants.SECTION7_BODY_WORKS,""));
		setMonthly_income(prop.getString(Constants.SECTION7_MONTHLY_INCOME,""));
		setReceived_credit(prop.getString(Constants.SECTION7_RECEIVED_CREDIT,""));
		setReceived_credit_value(prop.getString(Constants.SECTION7_RECEIVED_CREDIT_VALUE,""));
		setReceived_credit_value_other(prop.getString(Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER,""));
	}

	public String getDegree_approved_text() {
		return degree_approved_text;
	}

	public void setDegree_approved_text(String degree_approved_text) {
		this.degree_approved_text = degree_approved_text;
	}

	public String getDegree_approved_level() {
		return degree_approved_level;
	}

	public void setDegree_approved_level(String degree_approved_level) {
		this.degree_approved_level = degree_approved_level;
	}

	public String getYou_are() {
		return you_are;
	}

	public void setYou_are(String you_are) {
		this.you_are = you_are;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOccupation_value() {
		return occupation_value;
	}

	public void setOccupation_value(String occupation_value) {
		this.occupation_value = occupation_value;
	}

	public String getWork_performed() {
		return work_performed;
	}

	public void setWork_performed(String work_performed) {
		this.work_performed = work_performed;
	}

	public String getSkills_activity() {
		return skills_activity;
	}

	public void setSkills_activity(String skills_activity) {
		this.skills_activity = skills_activity;
	}

	public String getSkills_activity_option() {
		return skills_activity_option;
	}

	public void setSkills_activity_option(String skills_activity_option) {
		this.skills_activity_option = skills_activity_option;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMain_job() {
		return main_job;
	}

	public void setMain_job(String main_job) {
		this.main_job = main_job;
	}

	public String getBody_works() {
		return body_works;
	}

	public void setBody_works(String body_works) {
		this.body_works = body_works;
	}

	public String getMonthly_income() {
		return monthly_income;
	}

	public void setMonthly_income(String monthly_income) {
		this.monthly_income = monthly_income;
	}

	public String getReceived_credit() {
		return received_credit;
	}

	public void setReceived_credit(String received_credit) {
		this.received_credit = received_credit;
	}

	public String getReceived_credit_value() {
		return received_credit_value;
	}

	public void setReceived_credit_value(String received_credit_value) {
		this.received_credit_value = received_credit_value;
	}

	public String getReceived_credit_value_other() {
		return received_credit_value_other;
	}

	public void setReceived_credit_value_other(
			String received_credit_value_other) {
		this.received_credit_value_other = received_credit_value_other;
	}

}
