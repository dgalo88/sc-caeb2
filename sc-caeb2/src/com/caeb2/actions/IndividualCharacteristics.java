package com.caeb2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;

public class IndividualCharacteristics {

	public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

	private String lastnames;
	private String names;
	private IdentificationDocument cedula;
	private IdentificationDocument passport;
	private boolean _tienePartidaNacimiento;
	private String sex;
	private Date dateOfBirth;
	private String nationality;
	private String phoneCod;
	private String phoneNum;
	private String phoneCodOpt;
	private String phoneNumOpt;
	private String email;
	private String relationship;

	public static void saveIndividualCharacteristics( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String lastnames = request.getParameter(Constants.SECTION5_LASTNAMES);
		String names = request.getParameter(Constants.SECTION5_NAMES);

		System.out.println(names + " " + lastnames);

		int cedNumber = Integer.valueOf(request.getParameter(Constants.SECTION5_CEDULA_NUM));
		String cedType = request.getParameter(Constants.SECTION5_CEDULA_TYPE);
		IdentificationDocument cedula = new IdentificationDocument(cedNumber, cedType);

		System.out.println("cedula = " + cedula.toString());

		String[] idDocs = request.getParameterValues(Constants.SECTION5_ID_DOCS);

		boolean _tienePartidaNacimiento = false;

		if (idDocs != null) {

			for (String idDoc : idDocs) {

				if (idDoc.equals(Constants.JSP_PASSPORT)) {

					int passportNumber = Integer.valueOf(request.getParameter(Constants.SECTION5_PASSPORT_NUM));
					IdentificationDocument passport = new IdentificationDocument(passportNumber, "P");

					System.out.println("passport = " + passport.toString());

				} else if (idDoc.equals(Constants.JSP_BIRTH_CERTIFICATE)) {
					_tienePartidaNacimiento = true;
				}

			}

		}

		if (!_tienePartidaNacimiento) {
			System.out.print("No ");
		}
		System.out.print("Tiene Partida Nacimiento\n");

		String sex = request.getParameter(Constants.SECTION5_SEX);

		System.out.println("sex = " + sex);

		String dateOfBirthString = request.getParameter(Constants.SECTION5_BIRTHDATE);
		Date dateOfBirth = FORMATTER.parse(dateOfBirthString);

		System.out.println("date of birth = " + dateOfBirth);

		String nationality = request.getParameter(Constants.SECTION5_NATIONALITY);

		System.out.println("nationality = " + nationality);

		String phoneCod = request.getParameter(Constants.SECTION5_PHONE_COD);
		String phoneNum = request.getParameter(Constants.SECTION5_PHONE_NUM);

		System.out.println("phone = " + phoneCod + "-" + phoneNum);

		String phoneCodOpt = request.getParameter(Constants.SECTION5_PHONE_OPTIONAL_COD);
		String phoneNumOpt = request.getParameter(Constants.SECTION5_PHONE_OPTIONAL_NUM);

		System.out.println("optional phone = " + phoneCodOpt + "-" + phoneNumOpt);

		String email = request.getParameter(Constants.SECTION5_EMAIL);

		System.out.println("email = " + email);

		String relationship = request.getParameter(Constants.SECTION5_RELATIONSHIP);

		System.out.println("relationship = " + relationship);

		Controller.forward(request, response, "page_6.jsp");

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

	public boolean tienePartidaNacimiento() {
		return _tienePartidaNacimiento;
	}

	public void setTienePartidaNacimiento(boolean tienePartidaNacimiento) {
		this._tienePartidaNacimiento = tienePartidaNacimiento;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneCod() {
		return phoneCod;
	}

	public void setPhoneCod(String phoneCod) {
		this.phoneCod = phoneCod;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhoneCodOpt() {
		return phoneCodOpt;
	}

	public void setPhoneCodOpt(String phoneCodOpt) {
		this.phoneCodOpt = phoneCodOpt;
	}

	public String getPhoneNumOpt() {
		return phoneNumOpt;
	}

	public void setPhoneNumOpt(String phoneNumOpt) {
		this.phoneNumOpt = phoneNumOpt;
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

}
