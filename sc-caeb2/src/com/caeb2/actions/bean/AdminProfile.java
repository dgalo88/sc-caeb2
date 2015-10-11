package com.caeb2.actions.bean;

public class AdminProfile {

	private String lastnames;
	private String names;
	private IdentificationDocument cedula;
	private Phone phone;
	private Phone optionalPhone;
	private String email;

	public AdminProfile(String lastnames, String names, //
			IdentificationDocument cedula, Phone phone, //
			Phone optionalPhone, String email) {

		this.lastnames = lastnames;
		this.names = names;
		this.cedula = cedula;
		this.phone = phone;
		this.optionalPhone = optionalPhone;
		this.email = email;

	}

	public AdminProfile(String lastnames, String names, //
			IdentificationDocument cedula, //
			Phone phone, String email) {

		this(lastnames, names, cedula, phone, new Phone(), email);

	}

	public AdminProfile() {
		this("", "", new IdentificationDocument(), new Phone(), new Phone(), "");
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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Phone getOptionalPhone() {
		return optionalPhone;
	}

	public void setOptionalPhone(Phone optionalPhone) {
		this.optionalPhone = optionalPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {

		return "Admin Profile {\n" //
				+ "  Apellidos = " + lastnames + "\n" //
				+ "  Nombres = " + names + "\n" //
				+ (cedula.isValid() ? "  Cédula = " + cedula.toString() + "\n" : "") //
				+ (phone.isValid() ? "  Teléfono celular = " + phone + "\n" : "") //
				+ (optionalPhone.isValid() ? "  Teléfono celular = " + optionalPhone + "\n" : "") //
				+ "  Correo electrónico = " + email + "\n}";

	}

}
