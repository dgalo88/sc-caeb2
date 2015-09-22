package com.caeb2.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.actions.bean.Ability;
import com.caeb2.actions.bean.IdentificationDocument;
import com.caeb2.actions.bean.PersonBasicData;
import com.caeb2.actions.bean.PersonEducationData;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.Controller.PropFileRole;
import com.caeb2.util.TextUtils;

public class IndividualCharacteristics {

	//--------------------------------------------------------------------------------

	public static void savePersonBasicData( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		PropertiesConfiguration prop = Controller.getPropertiesFile( //
				Constants.PROP_FILE_PERSON, PropFileRole.SAVE);

		String lastnames = request.getParameter(Constants.SECTION5_LASTNAMES);
		String names = request.getParameter(Constants.SECTION5_NAMES);

		prop.setProperty(Constants.SECTION5_LASTNAMES, lastnames);
		prop.setProperty(Constants.SECTION5_NAMES, names);

		String cedType = request.getParameter(Constants.SECTION5_CEDULA_TYPE);
		String cedNumber = request.getParameter(Constants.SECTION5_CEDULA_NUM);

		if (!TextUtils.isEmptyOrNull(cedNumber)) {
			prop.setProperty(Constants.SECTION5_CEDULA_TYPE, cedType);
			prop.setProperty(Constants.SECTION5_CEDULA_NUM, Integer.valueOf(cedNumber));
		}

		String passportNumber = request.getParameter(Constants.SECTION5_PASSPORT);

		if (!TextUtils.isEmptyOrNull(passportNumber)) {
			prop.setProperty(Constants.SECTION5_PASSPORT, Integer.valueOf(passportNumber));
		}

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

		if (!TextUtils.isEmptyOrNull(phoneNumOptional)) {

			String phoneCodOptional = request.getParameter(Constants.SECTION5_PHONE_COD_OPTIONAL);

			prop.setProperty(Constants.SECTION5_PHONE_COD_OPTIONAL, phoneCodOptional);
			prop.setProperty(Constants.SECTION5_PHONE_NUM_OPTIONAL, phoneNumOptional);

		}

		String email = request.getParameter(Constants.SECTION5_EMAIL);

		prop.setProperty(Constants.SECTION5_EMAIL, email);

		String relationship = request.getParameter(Constants.SECTION5_RELATIONSHIP);

		prop.setProperty(Constants.SECTION5_RELATIONSHIP, relationship);

		String arrivalDate = request.getParameter(Constants.SECTION5_ARRIVAL_DATE);

		prop.setProperty(Constants.SECTION5_ARRIVAL_DATE, arrivalDate);

		prop.save();

		Controller.forward(request, response, "page_6.jsp");

	}

	public static PersonBasicData loadPersonBasicData() {

		PersonBasicData personBasicData = new PersonBasicData();

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			return personBasicData;
		}

		String lastnames = prop.getString(Constants.SECTION5_LASTNAMES, "");
		String names = prop.getString(Constants.SECTION5_NAMES, "");

		personBasicData.setLastnames(lastnames);
		personBasicData.setNames(names);

		String cedType = prop.getString(Constants.SECTION5_CEDULA_TYPE, "V");
		int cedNumber = prop.getInt(Constants.SECTION5_CEDULA_NUM, 0);

		IdentificationDocument cedula = new IdentificationDocument(cedType, cedNumber);

		personBasicData.setCedula(cedula);

		int passportNumber = prop.getInt(Constants.SECTION5_PASSPORT, 0);

		if (passportNumber != 0) {
			IdentificationDocument passport = new IdentificationDocument("P", passportNumber);
			personBasicData.setPassport(passport);
		}

		String sex = prop.getString(Constants.SECTION5_SEX, "M");

		personBasicData.setSex(sex);

		String birthdate = prop.getString(Constants.SECTION5_BIRTHDATE, "");

		personBasicData.setBirthdate(birthdate);

		String nationality = prop.getString(Constants.SECTION5_NATIONALITY, "");

		personBasicData.setNationality(nationality);

		int phoneCod = prop.getInt(Constants.SECTION5_PHONE_COD, 0);
		int phoneNum = prop.getInt(Constants.SECTION5_PHONE_NUM, 0);

		personBasicData.setPhoneCod(phoneCod);
		personBasicData.setPhoneNum(phoneNum);

		int phoneNumOptional = prop.getInt(Constants.SECTION5_PHONE_NUM_OPTIONAL, 0);

		if (phoneNumOptional != 0) {

			int phoneCodOptional = prop.getInt(Constants.SECTION5_PHONE_COD_OPTIONAL, 0);

			personBasicData.setPhoneCodOptional(phoneCodOptional);
			personBasicData.setPhoneNumOptional(phoneNumOptional);

		}

		String email = prop.getString(Constants.SECTION5_EMAIL, "");

		personBasicData.setEmail(email);

		String relationship = prop.getString(Constants.SECTION5_RELATIONSHIP, "");

		personBasicData.setRelationship(relationship);

		String arrivalDate = prop.getString(Constants.SECTION5_ARRIVAL_DATE, "");

		personBasicData.setBirthdate(arrivalDate);

		return personBasicData;

	}

	//--------------------------------------------------------------------------------

	public static void savePersonEducationData( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		PropertiesConfiguration prop = Controller.getPropertiesFile( //
				Constants.PROP_FILE_PERSON, PropFileRole.SAVE);

		String illiterate = TextUtils.escaparString( //
				request.getParameter(Constants.SECTION6_ILLITERATE));

		prop.setProperty(Constants.SECTION6_ILLITERATE, illiterate);

		String trainingCourse = TextUtils.escaparString( //
				request.getParameter(Constants.SECTION6_TRAINING_COURSE));
		String whichTrainingCourse = TextUtils.escaparString( //
				request.getParameter(Constants.SECTION6_WHICH_TRAINING_COURSE));

		prop.setProperty(Constants.SECTION6_TRAINING_COURSE, trainingCourse.equalsIgnoreCase("No") ? //
				trainingCourse : whichTrainingCourse);

		String attendEducEstablishment = TextUtils.escaparString( //
				request.getParameter(Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT));

		prop.setProperty(Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT, attendEducEstablishment);

		String answerEducEstablishment = TextUtils.escaparString( //
				attendEducEstablishment.equalsIgnoreCase("No") ? //
						request.getParameter(Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT) : //
							request.getParameter(Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT));

		prop.setProperty(Constants.SECTION6_ANSWER_EDUC_ESTABLISHMENT, answerEducEstablishment);

		String receivesScholarship = TextUtils.escaparString( //
				request.getParameter(Constants.SECTION6_RECEIVES_SCHOLARSHIP));

		String scholarshipDescription = TextUtils.escaparString( //
				receivesScholarship.equalsIgnoreCase("No") ? //
						receivesScholarship : request.getParameter( //
								Constants.SECTION6_SCHOLARSHIP_DESCRIPTION));

		prop.setProperty(Constants.SECTION6_SCHOLARSHIP_DESCRIPTION, scholarshipDescription);

		String[] educationalMisions = TextUtils.escaparArray( //
				request.getParameterValues(Constants.SECTION6_EDUCATIONAL_MISIONS));

		prop.setProperty(Constants.SECTION6_EDUCATIONAL_MISIONS, educationalMisions);

		prop.save();

		Controller.forward(request, response, "page_6.jsp");

	}

	public static PersonEducationData loadPersonEducationData() {

		PersonEducationData personEducationData = new PersonEducationData();

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			return personEducationData;
		}

		String illiterate = prop.getString(Constants.SECTION6_ILLITERATE, "");

		personEducationData.setIlliterate(illiterate.equalsIgnoreCase("No") ? false : true);

		String trainingCourse = prop.getString(Constants.SECTION6_TRAINING_COURSE, "");

		personEducationData.setTrainingCourse(trainingCourse);

		String attendEducEstablishment = prop.getString( //
				Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT, "");

		personEducationData.setAttendEducEstablishment( //
				attendEducEstablishment.equalsIgnoreCase("No") ? false : true);

		String answerEducEstablishment = prop.getString( //
				Constants.SECTION6_ANSWER_EDUC_ESTABLISHMENT, "");

		personEducationData.setAnswerEducEstablishment(answerEducEstablishment);

		String scholarshipDescription = prop.getString( //
				Constants.SECTION6_SCHOLARSHIP_DESCRIPTION, "");

		personEducationData.setScholarshipDescription(scholarshipDescription);

		HashMap<String, String> educationalMisions = Controller.arrayToHashMap( //
				prop, Constants.SECTION6_EDUCATIONAL_MISIONS);

		personEducationData.setEducationalMisions(educationalMisions);

		return personEducationData;

	}

	//--------------------------------------------------------------------------------

	public static void saveAbilitiesData( //
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		PropertiesConfiguration prop = Controller.getPropertiesFile( //
				Constants.PROP_FILE_PERSON, PropFileRole.SAVE);

		String[] artisticAbilities = TextUtils.escaparArray( //
				request.getParameterValues(Constants.SECTION9_ARTISTIC_ABILITY));

		if (artisticAbilities != null) {

			prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY, artisticAbilities);

			String[] artisticAbilitiesInstructor = new String[artisticAbilities.length];

			for (int i = 0; i < artisticAbilities.length; i++) {

				if (artisticAbilities[i].equals(Ability.OTHER)) {

					prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER, //
							request.getParameter(Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER));

				}

				artisticAbilitiesInstructor[i] = TextUtils.getBooleanString(request.getParameter( //
						TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbilities[i])));

			}

			prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR, artisticAbilitiesInstructor);

		}

		String[] artisticAbilitiesStudent = TextUtils.escaparArray( //
				request.getParameterValues(Constants.SECTION9_ARTISTIC_ABILITY_STUDENT));

		if (artisticAbilitiesStudent != null) {

			prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_STUDENT, artisticAbilitiesStudent);

			for (String curr : artisticAbilitiesStudent) {
				if (curr.equals(Ability.OTHER)) {
					prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER, //
							request.getParameter(Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER));
				}
			}

		}

		String[] athleticAbilities = TextUtils.escaparArray( //
				request.getParameterValues(Constants.SECTION9_ATHLETIC_ABILITY));

		if (athleticAbilities != null) {

			prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY, athleticAbilities);

			String[] athleticAbilitiesInstructor = new String[athleticAbilities.length];

			for (int i = 0; i < athleticAbilities.length; i++) {

				if (athleticAbilities[i].equals(Ability.OTHER)) {

					prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER, //
							request.getParameter(Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER));

				}

				athleticAbilitiesInstructor[i] = TextUtils.getBooleanString(request.getParameter( //
						TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbilities[i])));

			}

			prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR, athleticAbilitiesInstructor);

		}

		String[] athleticAbilitiesStudent = TextUtils.escaparArray( //
				request.getParameterValues(Constants.SECTION9_ATHLETIC_ABILITY_STUDENT));

		if (athleticAbilitiesStudent != null) {

			prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_STUDENT, athleticAbilitiesStudent);

			for (String curr : athleticAbilitiesStudent) {
				if (curr.equals(Ability.OTHER)) {
					prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER, //
							request.getParameter(Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER));
				}
			}

		}

		prop.save();

		Controller.forward(request, response, "page_10.jsp");

	}

	public static Ability loadAbilitiesData() {

		Ability ability = new Ability();

		PropertiesConfiguration prop = null;

		try {
			prop = Controller.getPropertiesFile(Constants.PROP_FILE_PERSON, PropFileRole.LOAD);
		} catch (ConfigurationException | IOException e) {
			Controller.putLogger(Level.SEVERE, Constants.LOAD_PROP_ERROR, e);
			return ability;
		}

		HashMap<String, String> artisticAbilities = Controller.arrayToHashMap( //
				prop, Constants.SECTION9_ARTISTIC_ABILITY);

		ability.setArtisticAbilities(artisticAbilities);

		HashMap<String, Boolean> artisticAbilitiesInstructor = Controller.arrayToBooleanHashMap( //
				prop, Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR, Constants.SECTION9_ARTISTIC_ABILITY);

		ability.setArtisticAbilitiesInstructor(artisticAbilitiesInstructor);

		HashMap<String, String> artisticAbilitiesStudent = Controller.arrayToHashMap( //
				prop, Constants.SECTION9_ARTISTIC_ABILITY_STUDENT);

		ability.setArtisticAbilitiesStudent(artisticAbilitiesStudent);

		String artisticAbilitiesInstructorOther = prop.getString( //
				Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER, "");

		ability.setArtisticAbilitiesInstructorOther(artisticAbilitiesInstructorOther);

		String artisticAbilitiesStudentOther = prop.getString( //
				Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER, "");

		ability.setArtisticAbilitiesStudentOther(artisticAbilitiesStudentOther);

		HashMap<String, String> athleticAbilities = Controller.arrayToHashMap( //
				prop, Constants.SECTION9_ATHLETIC_ABILITY);

		ability.setAthleticAbilities(athleticAbilities);

		HashMap<String, Boolean> athleticAbilitiesInstructor = Controller.arrayToBooleanHashMap( //
				prop, Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR, Constants.SECTION9_ATHLETIC_ABILITY);

		ability.setAthleticAbilitiesInstructor(athleticAbilitiesInstructor);

		HashMap<String, String> athleticAbilitiesStudent = Controller.arrayToHashMap( //
				prop, Constants.SECTION9_ATHLETIC_ABILITY_STUDENT);

		ability.setAthleticAbilitiesStudent(athleticAbilitiesStudent);

		String athleticAbilitiesInstructorOther = prop.getString( //
				Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER, "");

		ability.setAthleticAbilitiesInstructorOther(athleticAbilitiesInstructorOther);

		String athleticAbilitiesStudentOther = prop.getString( //
				Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER, "");

		ability.setAthleticAbilitiesStudentOther(athleticAbilitiesStudentOther);

		return ability;

	}

	//--------------------------------------------------------------------------------
}
