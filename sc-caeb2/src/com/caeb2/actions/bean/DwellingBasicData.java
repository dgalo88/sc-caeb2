package com.caeb2.actions.bean;

public class DwellingBasicData {

	private int id;
	private String name;
	private String address;
	private int pollNumber;
	private String crud;

	public DwellingBasicData(int id, String name, String address, int pollNumber, String crud) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.pollNumber = pollNumber;
		this.crud = crud;
	}

	public DwellingBasicData() {
		this(0, "", "", 0, "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPollNumber() {
		return pollNumber;
	}

	public void setPollNumber(int pollNumber) {
		this.pollNumber = pollNumber;
	}

	public String getCrud() {
		return crud;
	}

	public void setCrud(String crud) {
		this.crud = crud;
	}

}
