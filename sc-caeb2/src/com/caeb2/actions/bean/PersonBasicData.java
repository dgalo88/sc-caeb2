package com.caeb2.actions.bean;

public class PersonBasicData {

	private String lastnames;
	private String names;
	private IdentificationDocument cedula;
	private IdentificationDocument passport;
	private boolean _hasBirthCertificate;
	private String sex;
	private String birthdate;
	private String nationality;
	private int phoneCod;
	private int phoneNum;
	private int phoneCodOptional;
	private int phoneNumOptional;
	private String email;
	private String relationship;

	public PersonBasicData(String lastnames, String names, //
			IdentificationDocument cedula, IdentificationDocument passport, //
			boolean _hasBirthCertificate, String sex, //
			String birthdate, String nationality, //
			int phoneCod, int phoneNum, int phoneCodOptional, int phoneNumOptional, //
			String email, String relationship) {

		this.lastnames = lastnames;
		this.names = names;
		this.cedula = cedula;
		this.passport = passport;
		this._hasBirthCertificate = _hasBirthCertificate;
		this.sex = sex;
		this.birthdate = birthdate;
		this.nationality = nationality;
		this.phoneCod = phoneCod;
		this.phoneNum = phoneNum;
		this.phoneCodOptional = phoneCodOptional;
		this.phoneNumOptional = phoneNumOptional;
		this.email = email;
		this.relationship = relationship;

	}

	public PersonBasicData(String lastnames, String names, //
			IdentificationDocument cedula, //
			boolean _hasBirthCertificate, String sex, //
			String birthdate, String nationality, //
			int phoneCod, int phoneNum, //
			String email, String relationship) {

		this(lastnames, names, cedula, new IdentificationDocument("P", 0), //
				_hasBirthCertificate, sex, birthdate, nationality, //
				phoneCod, phoneNum, 0, 0, email, relationship);

	}

	public PersonBasicData() {

		this("", "", new IdentificationDocument(), new IdentificationDocument("P", 0), //
				false, "", "", "", 0, 0, 0, 0, "", "");

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

	public IdentificationDocument getPassport() {
		return passport;
	}

	public void setPassport(IdentificationDocument passport) {
		this.passport = passport;
	}

	public boolean hasBirthCertificate() {
		return _hasBirthCertificate;
	}

	public void setHasBirthCertificate(boolean hasBirthCertificate) {
		this._hasBirthCertificate = hasBirthCertificate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {

		String ret = "IndividualCharacteristics {\n" //
				+ "  Apellidos = " + lastnames + "\n" //
				+ "  Nombres = " + names + "\n";

		if ((cedula != null) && (cedula.getNumber() != 0)) {
			ret += "  Cédula = " + cedula.toString() + "\n";
		}

		if ((passport != null) && (passport.getNumber() != 0)) {
			ret += "  Pasaporte = " + passport.toString() + "\n";
		}

		ret += (_hasBirthCertificate ? "  " : "  No ") //
				+ "Tiene Partida Nacimiento" + "\n" //
				+ "  Sexo = " + sex + "\n" //
				+ "  Fecha de nacimiento = " + birthdate + "\n" //
				+ "  Nacionalidad = " + nationality + "\n" //
				+ "  Teléfono celular = " + phoneCod + "-" + phoneNum + "\n";

		if (phoneNumOptional != 0) {
			ret += "  Teléfono celular (opcional) = " + phoneCodOptional + "-" + phoneNumOptional + "\n";
		}

		ret += "  Correo electrónico = " + email + "\n" //
				+ "  Relación con el jefe del hogar = " + relationship + "\n" //
				+ "}";

		return ret;

	}

}
