package com.caeb2.actions;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.actions.bean.IdentificationDocument;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;

public class IndividualCharacteristics {

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

	public IndividualCharacteristics(String lastnames, String names, //
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

	public IndividualCharacteristics(String lastnames, String names, //
			IdentificationDocument cedula, //
			boolean _hasBirthCertificate, String sex, //
			String birthdate, String nationality, //
			int phoneCod, int phoneNum, //
			String email, String relationship) {

		this(lastnames, names, cedula, new IdentificationDocument("P", 0), //
				_hasBirthCertificate, sex, birthdate, nationality, //
				phoneCod, phoneNum, 0, 0, email, relationship);

	}

	public IndividualCharacteristics() {

		this("", "", new IdentificationDocument(), new IdentificationDocument("P", 0), //
				false, "", "", "", 0, 0, 0, 0, "", "");

	}

	public static void saveIndividualCharacteristics( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		PropertiesConfiguration prop = Controller.getPropertiesFile( //
				Constants.PROP_FILE_PERSON, PropFileRole.SAVE);

		String lastnames = request.getParameter(Constants.SECTION5_LASTNAMES);
		String names = request.getParameter(Constants.SECTION5_NAMES);

		prop.setProperty(Constants.SECTION5_LASTNAMES, lastnames);
		prop.setProperty(Constants.SECTION5_NAMES, names);

		String cedType = request.getParameter(Constants.SECTION5_CEDULA_TYPE);
		int cedNumber = Integer.valueOf(request.getParameter(Constants.SECTION5_CEDULA_NUM));

		prop.setProperty(Constants.SECTION5_CEDULA_NUM, cedNumber);
		prop.setProperty(Constants.SECTION5_CEDULA_TYPE, cedType);

		String[] idDocs = request.getParameterValues(Constants.SECTION5_ID_DOCS);

		boolean _hasBirthCertificate = false;

		if (idDocs != null) {

			for (String idDoc : idDocs) {

				if (idDoc.equals(Constants.JSP_PASSPORT)) {

					int passportNumber = Integer.valueOf( //
							request.getParameter(Constants.SECTION5_PASSPORT_NUM));

					prop.setProperty(Constants.SECTION5_PASSPORT_NUM, passportNumber);

				} else if (idDoc.equals(Constants.JSP_BIRTH_CERTIFICATE)) {
					_hasBirthCertificate = true;
				}

			}

		}

		prop.setProperty(Constants.SECTION5_HAS_BIRTH_CERTIFICATE, _hasBirthCertificate);

		String sex = request.getParameter(Constants.SECTION5_SEX);

		prop.setProperty(Constants.SECTION5_SEX, sex);

		String birthdate = request.getParameter(Constants.SECTION5_BIRTHDATE);

		prop.setProperty(Constants.SECTION5_BIRTHDATE, birthdate);

		String nationality = request.getParameter(Constants.SECTION5_NATIONALITY);

		prop.setProperty(Constants.SECTION5_NATIONALITY, nationality);

		String phoneCod = request.getParameter(Constants.SECTION5_PHONE_COD);
		String phoneNum = request.getParameter(Constants.SECTION5_PHONE_NUM);

		prop.setProperty(Constants.SECTION5_PHONE_COD, phoneCod);
		prop.setProperty(Constants.SECTION5_PHONE_NUM, phoneNum);

		String phoneNumOptional = request.getParameter(Constants.SECTION5_PHONE_NUM_OPTIONAL);

		if ((phoneNumOptional != null) && (!phoneNumOptional.isEmpty())) {

			String phoneCodOptional = request.getParameter(Constants.SECTION5_PHONE_COD_OPTIONAL);

			prop.setProperty(Constants.SECTION5_PHONE_COD_OPTIONAL, phoneCodOptional);
			prop.setProperty(Constants.SECTION5_PHONE_NUM_OPTIONAL, phoneNumOptional);

		}

		String email = request.getParameter(Constants.SECTION5_EMAIL);

		prop.setProperty(Constants.SECTION5_EMAIL, email);

		String relationship = request.getParameter(Constants.SECTION5_RELATIONSHIP);

		prop.setProperty(Constants.SECTION5_RELATIONSHIP, relationship);

		prop.save();

		Controller.forward(request, response, "page_6.jsp");

	}

	public static IndividualCharacteristics loadIndividualCharacteristics() {

		IndividualCharacteristics individualCharacteristics = new IndividualCharacteristics();

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.WARNING, Constants.LOAD_PROP_ERROR, e);
			return individualCharacteristics;
		}

		String lastnames = prop.getString(Constants.SECTION5_LASTNAMES, "");
		String names = prop.getString(Constants.SECTION5_NAMES, "");

		individualCharacteristics.setLastnames(lastnames);
		individualCharacteristics.setNames(names);

		String cedType = prop.getString(Constants.SECTION5_CEDULA_TYPE, "V");
		int cedNumber = prop.getInt(Constants.SECTION5_CEDULA_NUM, 0);

		IdentificationDocument cedula = new IdentificationDocument(cedType, cedNumber);

		individualCharacteristics.setCedula(cedula);

		int passportNumber = prop.getInt(Constants.SECTION5_PASSPORT_NUM, 0);

		if (passportNumber != 0) {
			IdentificationDocument passport = new IdentificationDocument("P", passportNumber);
			individualCharacteristics.setPassport(passport);
		}

		boolean _hasBirthCertificate = prop.getBoolean(Constants.SECTION5_HAS_BIRTH_CERTIFICATE, false);

		individualCharacteristics.setHasBirthCertificate(_hasBirthCertificate);

		String sex = prop.getString(Constants.SECTION5_SEX, "M");

		individualCharacteristics.setSex(sex);

		String birthdate = prop.getString(Constants.SECTION5_BIRTHDATE, "");

		individualCharacteristics.setBirthdate(birthdate);

		String nationality = prop.getString(Constants.SECTION5_NATIONALITY, "");

		individualCharacteristics.setNationality(nationality);

		int phoneCod = prop.getInt(Constants.SECTION5_PHONE_COD, 0);
		int phoneNum = prop.getInt(Constants.SECTION5_PHONE_NUM, 0);

		individualCharacteristics.setPhoneCod(phoneCod);
		individualCharacteristics.setPhoneNum(phoneNum);

		int phoneNumOptional = prop.getInt(Constants.SECTION5_PHONE_NUM_OPTIONAL, 0);

		if (phoneNumOptional != 0) {

			int phoneCodOptional = prop.getInt(Constants.SECTION5_PHONE_COD_OPTIONAL);

			individualCharacteristics.setPhoneCodOptional(phoneCodOptional);
			individualCharacteristics.setPhoneNumOptional(phoneNumOptional);

		}

		String email = prop.getString(Constants.SECTION5_EMAIL, "");

		individualCharacteristics.setEmail(email);

		String relationship = prop.getString(Constants.SECTION5_RELATIONSHIP);

		individualCharacteristics.setRelationship(relationship);

		return individualCharacteristics;

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
