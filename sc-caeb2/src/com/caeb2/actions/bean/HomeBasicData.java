package com.caeb2.actions.bean;

public class HomeBasicData {

	private int id;
	private String headOfHousehold;
	private int numberPeople;
	private String crud;

	public HomeBasicData(int id, String headOfHousehold, int numberPeople, String crud) {
		this.id = id;
		this.setHeadOfHousehold(headOfHousehold);
		this.numberPeople = numberPeople;
		this.crud = crud;
	}

	public HomeBasicData() {
		this(0, "", 0, "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadOfHousehold() {
		return headOfHousehold;
	}

	public void setHeadOfHousehold(String headOfHousehold) {
		this.headOfHousehold = headOfHousehold;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

	public void setNumberPeople(int numberPeople) {
		this.numberPeople = numberPeople;
	}

	public String getCrud() {
		return crud;
	}

	public void setCrud(String crud) {
		this.crud = crud;
	}

}
