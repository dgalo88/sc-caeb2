package com.caeb2.actions.bean;

public class PersonBasicData {

	private String lastnames;
	private String names;
	private IdentificationDocument cedula;
	private IdentificationDocument passport;
	private String sex;
	private String birthdate;
	private String nationality;
	private Phone phone;
	private Phone optionalPhone;
	private String email;
	private String relationship;
	private String arrivalDate;

	public PersonBasicData(String lastnames, String names, //
			IdentificationDocument cedula, IdentificationDocument passport, 
			String sex, String birthdate, String nationality, //
			Phone phone, Phone optionalPhone, String email, //
			String relationship, String arrivalDate) {

		this.lastnames = lastnames;
		this.names = names;
		this.cedula = cedula;
		this.passport = passport;
		this.sex = sex;
		this.birthdate = birthdate;
		this.nationality = nationality;
		this.phone = phone;
		this.optionalPhone = optionalPhone;
		this.email = email;
		this.relationship = relationship;
		this.arrivalDate = arrivalDate;

	}

	public PersonBasicData(String lastnames, String names, //
			IdentificationDocument cedula, String sex, //
			String birthdate, String nationality, Phone phone, //
			String email, String relationship, String arrivalDate) {

		this(lastnames, names, cedula, new IdentificationDocument("P", ""), //
				sex, birthdate, nationality, phone, new Phone(), email, //
				relationship, arrivalDate);

	}

	public PersonBasicData() {

		this("", "", new IdentificationDocument(), new IdentificationDocument("P", ""), //
				"", "", "", new Phone(), new Phone(), "", "", "");

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

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {

		return "PersonBasicData {\n" //
				+ "  Apellidos = " + lastnames + "\n" //
				+ "  Nombres = " + names + "\n" //
				+ (cedula.isValid() ? "  Cédula = " + cedula.toString() + "\n" : "") //
				+ (passport.isValid() ? "  Pasaporte = " + passport.toString() + "\n" : "") //
				+ "  Sexo = " + sex + "\n" //
				+ "  Fecha de nacimiento = " + birthdate + "\n" //
				+ "  Nacionalidad = " + nationality + "\n" //
				+ (phone.isValid() ? "  Teléfono celular = " + phone + "\n" : "") //
				+ (optionalPhone.isValid() ? "  Teléfono celular = " + optionalPhone + "\n" : "") //
				+ "  Correo electrónico = " + email + "\n" //
				+ "  Relación con el jefe del hogar = " + relationship + "\n" //
				+ "  Fecha de llegada a la comunidad = " + arrivalDate + "\n" //
				+ "}";

	}

}
