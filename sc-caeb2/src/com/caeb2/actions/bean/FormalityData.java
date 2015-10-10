package com.caeb2.actions.bean;

public class FormalityData {

	private String lastnames;
	private String names;
	private String sex;
	private String address;
	private String nationality;
	private String arrivalDate;

	public FormalityData(String lastnames, String names, //
			String sex, String address, String nationality, //
			String arrivalDate) {
		this.lastnames = lastnames;
		this.names = names;
		this.sex = sex;
		this.address = address;
		this.nationality = nationality;
		this.arrivalDate = arrivalDate;
	}

	public FormalityData() {
		this(null, null, null, null, null, null);
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

}
