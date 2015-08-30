package com.caeb2.actions.bean;

public class PersonBasicDataMin {

	private int id;
	private String lastnames;
	private String names;
	private String cedula;
	private String phone;
	private String relationship;
	private String crud;

	public PersonBasicDataMin(int id, String lastnames, String names, //
			String cedula, String phone, String relationship, String crud) {

		this.id = id;
		this.lastnames = lastnames;
		this.names = names;
		this.cedula = cedula;
		this.phone = phone;
		this.relationship = relationship;
		this.crud = crud;

	}

	public PersonBasicDataMin() {
		this(0, "", "", "", "", "", "");
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getCrud() {
		return crud;
	}

	public void setCrud(String crud) {
		this.crud = crud;
	}

	@Override
	public String toString() {

		String ret = "PersonBasicDataMin {\n" //
				+ "  Apellidos = " + lastnames + "\n" //
				+ "  Nombres = " + names + "\n";

		if (cedula != null) {
			ret += "  Cédula = " + cedula + "\n";
		}

		ret += "  Teléfono celular = " + phone + "\n" //
				+ "  Relación con el jefe del hogar = " + relationship + "\n" //
				+ "}";

		return ret;

	}

}
