package com.caeb2.actions.bean;

public class AdminProfile {

	private String lastnames;
	private String names;
	private IdentificationDocument cedula;
	private int phoneCod;
	private int phoneNum;
	private int phoneCodOptional;
	private int phoneNumOptional;
	private String email;

	public AdminProfile(String lastnames, String names, //
			IdentificationDocument cedula, int phoneCod, int phoneNum, //
			int phoneCodOptional, int phoneNumOptional, String email) {

		this.lastnames = lastnames;
		this.names = names;
		this.cedula = cedula;
		this.phoneCod = phoneCod;
		this.phoneNum = phoneNum;
		this.phoneCodOptional = phoneCodOptional;
		this.phoneNumOptional = phoneNumOptional;
		this.email = email;

	}

	public AdminProfile(String lastnames, String names, //
			IdentificationDocument cedula, //
			int phoneCod, int phoneNum, String email) {

		this(lastnames, names, cedula, phoneCod, phoneNum, 0, 0, email);

	}

	public AdminProfile() {
		this("", "", new IdentificationDocument(), 0, 0, 0, 0, "");
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

	public int getPhoneCod() {
		return phoneCod;
	}

	public void setPhoneCod(int phoneCod) {
		this.phoneCod = phoneCod;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getPhoneCodOptional() {
		return phoneCodOptional;
	}

	public void setPhoneCodOptional(int phoneCodOptional) {
		this.phoneCodOptional = phoneCodOptional;
	}

	public int getPhoneNumOptional() {
		return phoneNumOptional;
	}

	public void setPhoneNumOptional(int phoneNumOptional) {
		this.phoneNumOptional = phoneNumOptional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {

		String ret = "IndividualCharacteristics {\n" //
				+ "  Apellidos = " + lastnames + "\n" //
				+ "  Nombres = " + names + "\n";

		if ((cedula != null) && (cedula.getNumber() != 0)) {
			ret += "  Cédula = " + cedula.toString() + "\n";
		}

		ret += "  Teléfono celular = " + phoneCod + "-" + phoneNum + "\n";

		if (phoneNumOptional != 0) {
			ret += "  Teléfono celular (opcional) = " + phoneCodOptional + "-" + phoneNumOptional + "\n";
		}

		ret += "  Correo electrónico = " + email + "\n}";

		return ret;

	}

}
