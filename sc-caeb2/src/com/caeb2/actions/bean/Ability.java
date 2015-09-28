package com.caeb2.actions.bean;

import java.util.ArrayList;
import java.util.HashMap;

import com.caeb2.util.Constants;

public class Ability {

	public static final ArrayList<String> ARTISTIC_ABILITIES_OPTIONS;
	public static final ArrayList<String> ATHLETIC_ABILITIES_OPTIONS;

	static {

		ARTISTIC_ABILITIES_OPTIONS = new ArrayList<String>();

		ARTISTIC_ABILITIES_OPTIONS.add(Constants.CHORDS_INSTRUMENTS);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.KITCHEN);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.CUTTING_SEWING);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.CONFECTIONERY);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.PAINTING);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.THEATRE);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.EMBROIDERY);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.BARBER);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.COMPUTING);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.DANCE);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.CRAFTS);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.SINGING);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.MANICURE_PEDICURE);
		ARTISTIC_ABILITIES_OPTIONS.add(Constants.OTHER);

		ATHLETIC_ABILITIES_OPTIONS = new ArrayList<String>();

		ATHLETIC_ABILITIES_OPTIONS.add(Constants.BASKETBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(Constants.BASEBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(Constants.SOFTBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(Constants.FOOTBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(Constants.VOLLEYBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(Constants.SWIMMING);
		ATHLETIC_ABILITIES_OPTIONS.add(Constants.ATHLETICS);
		ATHLETIC_ABILITIES_OPTIONS.add(Constants.OTHER);

	}

	private HashMap<String, String> artisticAbilities;
	private HashMap<String, Boolean> artisticAbilitiesInstructor;
	private HashMap<String, String> artisticAbilitiesStudent;
	private String artisticAbilitiesInstructorOther;
	private String artisticAbilitiesStudentOther;
	private HashMap<String, String> athleticAbilities;
	private HashMap<String, Boolean> athleticAbilitiesInstructor;
	private HashMap<String, String> athleticAbilitiesStudent;
	private String athleticAbilitiesInstructorOther;
	private String athleticAbilitiesStudentOther;

	public Ability(HashMap<String, String> artisticAbilities, //
			HashMap<String, Boolean> artisticAbilitiesInstructor, //
			HashMap<String, String> artisticAbilitiesStudent, //
			String artisticAbilitiesInstructorOther, String artisticAbilitiesStudentOther, //
			HashMap<String, String> athleticAbilities, //
			HashMap<String, Boolean> athleticAbilitiesInstructor, //
			HashMap<String, String> athleticAbilitiesStudent, //
			String athleticAbilitiesInstructorOther, String athleticAbilitiesStudentOther) {
		this.artisticAbilities = artisticAbilities;
		this.artisticAbilitiesInstructor = artisticAbilitiesInstructor;
		this.artisticAbilitiesStudent = artisticAbilitiesStudent;
		this.artisticAbilitiesInstructorOther = artisticAbilitiesInstructorOther;
		this.artisticAbilitiesStudentOther = artisticAbilitiesStudentOther;
		this.athleticAbilities = athleticAbilities;
		this.athleticAbilitiesInstructor = athleticAbilitiesInstructor;
		this.athleticAbilitiesStudent = athleticAbilitiesStudent;
		this.athleticAbilitiesInstructorOther = athleticAbilitiesInstructorOther;
		this.athleticAbilitiesStudentOther = athleticAbilitiesStudentOther;
	}

	public Ability() {
		this(new HashMap<String, String>(), new HashMap<String, Boolean>(), //
				new HashMap<String, String>(), "", "", new HashMap<String, String>(), //
				new HashMap<String, Boolean>(), new HashMap<String, String>(), "", "");
	}

	public HashMap<String, String> getArtisticAbilities() {
		if(artisticAbilities.containsKey(Constants.OTHER)){
			artisticAbilities.put(Constants.OTHER, artisticAbilitiesInstructorOther);
		}
		return artisticAbilities;
	}

	public void setArtisticAbilities(HashMap<String, String> artisticAbilities) {
		this.artisticAbilities = artisticAbilities;
	}

	public HashMap<String, Boolean> getArtisticAbilitiesInstructor() {
		return artisticAbilitiesInstructor;
	}

	public void setArtisticAbilitiesInstructor(HashMap<String, Boolean> artisticAbilitiesInstructor) {
		this.artisticAbilitiesInstructor = artisticAbilitiesInstructor;
	}

	public HashMap<String, String> getArtisticAbilitiesStudent() {
		if(artisticAbilitiesStudent.containsKey(Constants.OTHER)){
			artisticAbilitiesStudent.put(Constants.OTHER, artisticAbilitiesStudentOther);
		}
		return artisticAbilitiesStudent;
	}

	public void setArtisticAbilitiesStudent(HashMap<String, String> artisticAbilitiesStudent) {
		this.artisticAbilitiesStudent = artisticAbilitiesStudent;
	}

	public String getArtisticAbilitiesInstructorOther() {
		return artisticAbilitiesInstructorOther;
	}

	public void setArtisticAbilitiesInstructorOther(String artisticAbilitiesInstructorOther) {
		this.artisticAbilitiesInstructorOther = artisticAbilitiesInstructorOther;
	}

	public String getArtisticAbilitiesStudentOther() {
		return artisticAbilitiesStudentOther;
	}

	public void setArtisticAbilitiesStudentOther(String artisticAbilitiesStudentOther) {
		this.artisticAbilitiesStudentOther = artisticAbilitiesStudentOther;
	}

	public HashMap<String, String> getAthleticAbilities() {
		if(athleticAbilities.containsKey(Constants.OTHER)){
			athleticAbilities.put(Constants.OTHER, athleticAbilitiesInstructorOther);
		}
		return athleticAbilities;
	}

	public void setAthleticAbilities(HashMap<String, String> athleticAbilities) {
		this.athleticAbilities = athleticAbilities;
	}

	public HashMap<String, Boolean> getAthleticAbilitiesInstructor() {
		return athleticAbilitiesInstructor;
	}

	public void setAthleticAbilitiesInstructor(HashMap<String, Boolean> athleticAbilitiesInstructor) {
		this.athleticAbilitiesInstructor = athleticAbilitiesInstructor;
	}

	public HashMap<String, String> getAthleticAbilitiesStudent() {
		if(athleticAbilitiesStudent.containsKey(Constants.OTHER)){
			athleticAbilitiesStudent.put(Constants.OTHER, athleticAbilitiesStudentOther);
		}
		return athleticAbilitiesStudent;
	}

	public void setAthleticAbilitiesStudent(HashMap<String, String> athleticAbilitiesStudent) {
		this.athleticAbilitiesStudent = athleticAbilitiesStudent;
	}

	public String getAthleticAbilitiesInstructorOther() {
		return athleticAbilitiesInstructorOther;
	}

	public void setAthleticAbilitiesInstructorOther(String athleticAbilitiesInstructorOther) {
		this.athleticAbilitiesInstructorOther = athleticAbilitiesInstructorOther;
	}

	public String getAthleticAbilitiesStudentOther() {
		return athleticAbilitiesStudentOther;
	}

	public void setAthleticAbilitiesStudentOther(String athleticAbilitiesStudentOther) {
		this.athleticAbilitiesStudentOther = athleticAbilitiesStudentOther;
	}

	public boolean getAbility(HashMap<String, Boolean> abilitiesMap, String key) {

		if ((abilitiesMap == null) || abilitiesMap.isEmpty() || (abilitiesMap.get(key) == null)) {
			return false;
		} else {
			return abilitiesMap.get(key);
		}

	}

}
