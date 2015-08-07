package com.caeb2.actions.bean;

import java.util.HashMap;

public class PersonEducationData {

	private boolean illiterate;
	private String trainingCourse;
	private boolean attendEducEstablishment;
	private String answerEducEstablishment;
	private String scholarshipDescription;
	private HashMap<String, String> educationalMisions;

	public boolean isIlliterate() {
		return illiterate;
	}

	public void setIlliterate(boolean illiterate) {
		this.illiterate = illiterate;
	}

	public String getTrainingCourse() {
		return trainingCourse;
	}

	public void setTrainingCourse(String trainingCourse) {
		this.trainingCourse = trainingCourse;
	}

	public boolean hasAttendEducEstablishment() {
		return attendEducEstablishment;
	}

	public void setAttendEducEstablishment(boolean attendEducEstablishment) {
		this.attendEducEstablishment = attendEducEstablishment;
	}

	public String getAnswerEducEstablishment() {
		return answerEducEstablishment;
	}

	public void setAnswerEducEstablishment(String answerEducEstablishment) {
		this.answerEducEstablishment = answerEducEstablishment;
	}

	public String getScholarshipDescription() {
		return scholarshipDescription;
	}

	public void setScholarshipDescription(String scholarshipDescription) {
		this.scholarshipDescription = scholarshipDescription;
	}

	public HashMap<String, String> getEducationalMisions() {
		return educationalMisions;
	}

	public void setEducationalMisions(HashMap<String, String> educationalMisions) {
		this.educationalMisions = educationalMisions;
	}

}
