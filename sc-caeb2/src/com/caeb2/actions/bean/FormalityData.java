package com.caeb2.actions.bean;

public class FormalityData {

	private String lastnames;
	private String names;
	private String sex;
	private String direction;
	private String nationality;

	public FormalityData(String lastnames, String names, //
			String sex, String direction, String nationality) {
		this.lastnames = lastnames;
		this.names = names;
		this.sex = sex;
		this.direction = direction;
		this.nationality = nationality;
	}

	public FormalityData() {
		this(null, null, null, null, null);
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
