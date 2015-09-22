package com.caeb2.actions.bean;

import java.util.ArrayList;
import java.util.HashMap;

public class Ability {

	public static final String NONE = "Ninguna";
	public static final String OTHER = "Otra ¿Cuál?";

	public static final String CHORDS_INSTRUMENTS = "Instrumentos de cuerda";
	public static final String KITCHEN = "Cocina";
	public static final String CUTTING_SEWING = "Corte y costura";
	public static final String CONFECTIONERY = "Repostería";
	public static final String PAINTING = "Pintura";
	public static final String THEATRE = "Teatro";
	public static final String EMBROIDERY = "Bordado";
	public static final String BARBER = "Peluquería";
	public static final String COMPUTING = "Computación";
	public static final String DANCE = "Danza";
	public static final String CRAFTS = "Artesanía";
	public static final String SINGING = "Canto";
	public static final String MANICURE_PEDICURE = "Manicura y pedicura";

	public static final String BASKETBALL = "Básquetbol";
	public static final String BASEBALL = "Béisbol";
	public static final String SOFTBALL = "Softbol";
	public static final String FOOTBALL = "Fútbol";
	public static final String VOLLEYBALL = "Voleibol";
	public static final String SWIMMING = "Natación";
	public static final String ATHLETICS = "Atletismo";

	public static final ArrayList<String> ARTISTIC_ABILITIES_OPTIONS;
	public static final ArrayList<String> ATHLETIC_ABILITIES_OPTIONS;

	static {

		ARTISTIC_ABILITIES_OPTIONS = new ArrayList<String>();

		ARTISTIC_ABILITIES_OPTIONS.add(CHORDS_INSTRUMENTS);
		ARTISTIC_ABILITIES_OPTIONS.add(KITCHEN);
		ARTISTIC_ABILITIES_OPTIONS.add(CUTTING_SEWING);
		ARTISTIC_ABILITIES_OPTIONS.add(CONFECTIONERY);
		ARTISTIC_ABILITIES_OPTIONS.add(PAINTING);
		ARTISTIC_ABILITIES_OPTIONS.add(THEATRE);
		ARTISTIC_ABILITIES_OPTIONS.add(EMBROIDERY);
		ARTISTIC_ABILITIES_OPTIONS.add(BARBER);
		ARTISTIC_ABILITIES_OPTIONS.add(COMPUTING);
		ARTISTIC_ABILITIES_OPTIONS.add(DANCE);
		ARTISTIC_ABILITIES_OPTIONS.add(CRAFTS);
		ARTISTIC_ABILITIES_OPTIONS.add(SINGING);
		ARTISTIC_ABILITIES_OPTIONS.add(MANICURE_PEDICURE);
		ARTISTIC_ABILITIES_OPTIONS.add(OTHER);

		ATHLETIC_ABILITIES_OPTIONS = new ArrayList<String>();

		ATHLETIC_ABILITIES_OPTIONS.add(BASKETBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(BASEBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(SOFTBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(FOOTBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(VOLLEYBALL);
		ATHLETIC_ABILITIES_OPTIONS.add(SWIMMING);
		ATHLETIC_ABILITIES_OPTIONS.add(ATHLETICS);
		ATHLETIC_ABILITIES_OPTIONS.add(OTHER);

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
