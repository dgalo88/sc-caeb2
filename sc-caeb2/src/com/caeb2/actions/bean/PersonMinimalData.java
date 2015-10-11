package com.caeb2.actions.bean;

public class PersonMinimalData {

	private int id;
	private String lastnames;
	private String names;
	private IdentificationDocument cedula;

	public PersonMinimalData(int id, String lastnames, //
			String names, IdentificationDocument cedula) {
		this.id = id;
		this.lastnames = lastnames;
		this.names = names;
		this.cedula = cedula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public IdentificationDocument getCedula() {
		return cedula;
	}

	public void setCedula(IdentificationDocument cedula) {
		this.cedula = cedula;
	}

}
