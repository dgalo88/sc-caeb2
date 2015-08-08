package com.caeb2.util;

public class Constants {

	// General constants
	public static final String CENSO_COMUNITARIO = "CENSO COMUNITARIO";
	public static final String CCAEB2 = "Consejo Comunal Andrés Eloy Blanco 2";
	public static final String SECTOR_AEB = "Sector Andrés Eloy Blanco";
	public static final String DIR_CCAEB2 = "Dirección del Consejo Comunal: calle principal, casa 2-32. Telf.: 0426-8288651 / 0416-3705229.";

	public static final String EXECUTE = "startup";
	public static final String ACTION = "action";
	public static final String EXEC_ACTION = EXECUTE + "?" + ACTION + "=";

	public static final String ACTION_EXIT = EXEC_ACTION + "logout";
	public static final String ACTION_PROFILE = EXEC_ACTION + "loadAdminProfile";
	public static final String ACTION_NEW_POLL = EXEC_ACTION + "newPoll";
	public static final String ACTION_SEARCH = "dwellingBoard.jsp";
	public static final String ACTION_HOME = "index.jsp";
	public static final String ACTION_GEN_FORMALITY = "formalityGenerator.jsp";
	public static final String ACTION_BACKUP = "#";

	public static final String PATH_SC_CAEB2 = "/sc-caeb2";
	public static final String PATH_JSP = PATH_SC_CAEB2 + "/jsp";
	public static final String PATH_CSS = PATH_SC_CAEB2 + "/css";
	public static final String PATH_REAL_PROJECT = System.getProperty("user.dir");
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	// Properties files names
	public static final String PROP_FILE_DWELLING = "dwelling.prop";
	public static final String PROP_FILE_HOME = "home.prop";
	public static final String PROP_FILE_PERSON = "C:\\Users\\Jose Hidalgo\\Desktop\\person.prop";

	// Attributes
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_ERROR = "error";
	public static final String ATT_SECTION = "section";
	public static final String ATT_PAGE_NUMBER = "pageNumber";
	public static final String ATT_USER = "user";
	public static final String ATT_ADMIN_PROFILE = "adminProfile";

	// Messages
	public static final String FORWARD = "[REENVIAR] ";
	public static final String RESPONSE = "[RESPUESTA] ";
	public static final String USER_LOGIN = "El usuario ''{0}'' ha iniciado sesión";
	public static final String SAVE_DATA_TO = "Guardando datos en el archivo \"{0}\"";
	public static final String LOAD_DATA_FROM = "Cargando datos desde el archivo \"{0}\"";
	public static final String PASS_CHANGED = "Contraseña cambiada con éxito";

	// Errors Messages
	public static final String ERROR = "Error";
	public static final String IT_CANNOT_ERROR = "No se puede realizar la acción solicitada.";
	public static final String CONTACT_ADMIN = "Contacte con el administrador.";
	public static final String GENERAL_ERROR = IT_CANNOT_ERROR + " " + CONTACT_ADMIN;
	public static final String SQL_ERROR = "No se puede establecer la conexión con la base de datos.";
	public static final String ACTION_ERROR = "La acción solicitada no existe.";
	public static final String LOGIN_ERROR = "Combinación usuario/contraseña inválida.";
	public static final String DRIVER_ERROR = "Driver JDBC no encontrado.";
	public static final String LOAD_PROP_ERROR = "No se puede cargar el archivo de propiedades.";
	public static final String CHANGE_PASS_ERROR = "No se pudo cambiar la contraseña.";
	public static final String CONFIRM_PASS_ERROR = "Debe confirmar su nueva contraseña.";
	public static final String EQUALS_PASS_ERROR = "Debe elegir una contraseña diferente a la actual.";
	public static final String NOT_FOUND_ERROR = "La persona con la cédula \"{0}\" no ha sido encuestada.";
	public static final String READING_DATA_ERROR = "No se pueden obtener los datos solicitados.";
	public static final String EMPTY_FIELD_ERROR = "El campo \"{0}\" no puede estar vacío.";
	public static final String EMPTY_CEDULA_ERROR = "La cédula no puede estar vacía.";

	// JSP
	public static final String JSP_OK = "Aceptar";
	public static final String JSP_CANCEL = "Cancelar";
	public static final String JSP_NEXT = "Siguiente";
	public static final String JSP_PREV = "Anterior";
	public static final String JSP_SAVE = "Guardar";
	public static final String JSP_RETURN = "Regresar";
	public static final String JSP_ERROR = "Ups algo ha salido mal!";
	public static final String JSP_LOGIN_TITLE = "Bienvenido";
	public static final String JSP_USER = "Usuario";
	public static final String JSP_PASS = "Contraseña";
	public static final String JSP_SIGN_IN = "Iniciar Sesión";
	public static final String JSP_SIGN_OUT = "Cerrar Sesión";
	public static final String JSP_MENU = "Menú";
	public static final String JSP_NEW_POLL = "Nueva Encuesta";
	public static final String JSP_PROFILE = "Perfil";
	public static final String JSP_EXIT = "Salir";
	public static final String JSP_SEARCH = "Buscar";
	public static final String JSP_GEN_FORMALITY = "Generar Constancias";
	public static final String JSP_HOME = "Inicio";
	public static final String JSP_BACKUP = "Respaldo de datos";
	public static final String JSP_IMPORT = "Importar";
	public static final String JSP_EXPORT = "Exportar";
	public static final String JSP_ABOUT = "Acerca de";

	// Documents types
	public static final String JSP_RES_PROOF = "Constancia de Residencia";
	public static final String JSP_RES_PROOF_LOW_INCOME = "Constancia de Residencia y Bajos Recursos Económicos";

	// Properties and ids Section 1
	public static final String SECTION1_IDENTIFYING_STRUCTURE = "section1_identifying_structure";
	public static final String SECTION1_STREET = "section1_street";
	public static final String SECTION1_NAME_HOUSING = "section1_name_housing";
	public static final String SECTION1_HOME_PHONE = "section1_home_phone";

	// Properties and ids Section 2
	public static final String SECTION2_STRUCTURE_TYPE = "section2_structure_type";
	public static final String SECTION2_HOLDING = "section2_holding";
	public static final String SECTION2_TOTAL_ROOMS = "section2_total_rooms";
	public static final String SECTION2_HOUSING_FITS_HOUSEHOLD = "section2_housing_fits_household";
	public static final String SECTION2_HOUSE_SECTOR = "section2_house_sector";
	public static final String SECTION2_HOUSE_SCALABILITY = "section2_house_scalability";
	public static final String SECTION2_WALLS_TYPE = "section2_walls_type";
	public static final String SECTION2_CEILING_TYPE = "section2_ceiling_type";
	public static final String SECTION2_FLAT_TYPE = "section2_flat_type";
	public static final String SECTION2_LOCATION_KITCHEN = "section2_location_kitchen";
	public static final String SECTION2_HOUSING_WATER = "section2_housing_water";
	public static final String SECTION2_OTHER_HOUSING_WATER = "section2_other_housing_water"; 
	public static final String SECTION2_SANITARY_SERVICE = "section2_sanitary_service";
	public static final String SECTION2_ELECTRICAL_SERVICE = "section2_electrical_service";
	public static final String SECTION2_GARBAGE_COLLECTION = "section2_garbage_collection";
	public static final String SECTION2_HOUSING_RISK = "section2_housing_risk";
	public static final String SECTION2_URGENT_HOUSING_IMPROVEMENTS = "section2_urgent_housing_improvements";

	public static final String SECTION2_COOKING = "section2_cooking"; 
	public static final String SECTION2_DINING_ROOM = "section2_dining_room";
	public static final String SECTION2_BEDROOM = "section2_bedroom";
	public static final String SECTION2_BATH = "section2_bath"; 
	public static final String SECTION2_PART_OTHER = "section2_part_other"; 
	public static final String SECTION2_PART = "section2_part"; 
	public static final String SECTION2_CEILING = "section2_ceiling"; 
	public static final String SECTION2_FLAT = "section2_flat";
	public static final String SECTION2_WALLS = "section2_walls";
	public static final String SECTION2_ELECTRIC_SYSTEM = "section2_electric_system"; 
	public static final String SECTION2_REQUIRED_OTHER = "section2_required_other";
	public static final String SECTION2_REQUIRED = "section2_required";
	public static final String SECTION2_FRIEZE = "section2_frieze"; 
	public static final String SECTION2_EXTENSION = "section2_extension";
	public static final String SECTION2_RESHUFFLE = "section2_reshuffle";
	public static final String SECTION2_REPAIR = "section2_repair";
	public static final String SECTION2_WORK_NEEDS_OTHER = "section2_work_needs_other";
	public static final String SECTION2_WORK_NEEDS = "section2_work_needs";
	public static final String SECTION2_PART_OTHER_RESPONSE = "section2_part_other_response";
	public static final String SECTION2_REQUIRED_OTHER_RESPONSE = "section2_required_other_response";
	public static final String SECTION2_WORK_NEEDS_OTHER_RESPONSE = "section2_work_needs_other_response";

	// Properties and ids Section 4
	public static final String SECTION4_HOME = "section4_home";
	public static final String SECTION4_TO = "section4_to";
	public static final String SECTION4_ROOMS = "section4_rooms";
	public static final String SECTION4_CHIEF_COUPLE = "section4_chief_couple";
	public static final String SECTION4_USED_MERCAL = "section4_used_mercal";
	public static final String SECTION4_USED_MERCAL_SELECTED = "section4_used_mercal_selected";
	public static final String SECTION4_FOOD_MARKETS = "section4_food_markets";
	public static final String SECTION4_FOOD_MARKETS_RESPONSE = "section4_food_markets_response";
	public static final String SECTION4_NUMBER_BATHROOMS = "section4_number_bathrooms";
	public static final String SECTION4_TOTAL_PERSONS = "section4_total_persons";
	public static final String SECTION4_SLEEPS_3_OR_MORE = "section4_sleeps_3_or_more";
	public static final String SECTION4_USED_PDVAL = "section4_used_pdval";
	public static final String SECTION4_USED_PDVALL_SELECTED = "section4_used_pdval_selected";
	public static final String SECTION4_COMMUNITY_ORGANIZATIO = "section4_community_organization";
	public static final String SECTION4_COMMUNITY_ORGANIZATION_WHICH = "section4_community_organization_which";
	public static final String SECTION4_COMMUNITY_PROBLEMS = "section4_community_problems";
	public static final String SECTION4_COMMUNITY_PROBLEMS_OTHER = "section4_community_problems_other";

	// Properties and ids Section 5
	public static final String SECTION5_LASTNAMES = "section5_lastnames";
	public static final String SECTION5_NAMES = "section5_names";
	public static final String SECTION5_SEX = "section5_sex";
	public static final String SECTION5_BIRTHDATE = "section5_birthdate";
	public static final String SECTION5_PHONE_COD = "section5_phone_cod";
	public static final String SECTION5_PHONE_NUM = "section5_phone_num";
	public static final String SECTION5_PHONE = "section5_phone";
	public static final String SECTION5_PHONE_COD_OPTIONAL = "section5_phone_cod_optional";
	public static final String SECTION5_PHONE_NUM_OPTIONAL = "section5_phone_num_optional";
	public static final String SECTION5_PHONE_OPTIONAL = "section5_phone_optional";
	public static final String SECTION5_RELATIONSHIP = "section5_relationship";
	public static final String SECTION5_CEDULA_TYPE = "section5_cedula_type";
	public static final String SECTION5_CEDULA_NUM = "section5_cedula_num";
	public static final String SECTION5_CEDULA = "section5_cedula";
	public static final String SECTION5_PASSPORT = "section5_passport";
	public static final String SECTION5_NATIONALITY = "section5_nationality";
	public static final String SECTION5_EMAIL = "section5_email";
		
	// Properties and ids Section 6
	public static final String SECTION6_ILLITERATE = "section6_illiterate";
	public static final String SECTION6_ATTEND_EDUC_ESTABLISHMENT = "section6_attend_educ_establishment";
	public static final String SECTION6_ANSWER_EDUC_ESTABLISHMENT = "section6_answer_educ_establishment";
	public static final String SECTION6_WHICH_EDUC_ESTABLISHMENT = "section6_which_educ_establishment";
	public static final String SECTION6_WHYNOT_EDUC_ESTABLISHMENT = "section6_whynot_educ_establishment";
	public static final String SECTION6_TRAINING_COURSE = "section6_training_course";
	public static final String SECTION6_WHICH_TRAINING_COURSE = "section6_which_training_course";
	public static final String SECTION6_RECEIVES_SCHOLARSHIP = "section6_receives_scholarship";
	public static final String SECTION6_SCHOLARSHIP_DESCRIPTION = "section6_scholarship_description";
	public static final String SECTION6_NONE_MISION = "section6_none_mision";
	public static final String SECTION6_EDUCATIONAL_MISIONS = "section6_educational_misions";

	// Properties and ids Section 7
	public static final String SECTION7_DEGREE_APPROVED_TEXT = "section7_degree_approved_text";
	public static final String SECTION7_DEGREE_APPROVED_LEVEL = "section7_degree_approved_level";
	public static final String SECTION7_YOU_ARE = "section7_you_are";
	public static final String SECTION7_OCCUPATION = "section7_occupation";
	public static final String SECTION7_OCCUPATION_VALUE = "section7_occupation_value";
	public static final String SECTION7_WORK_PERFORMED = "section7_work_performed";
	public static final String SECTION7_SKILLS_ACTIVITY = "section7_skills_activity";
	public static final String SECTION7_SKILLS_ACTIVITY_OPTION = "section7_skills_activity_option";
	
	public static final String SECTION7_PROFESSION = "section7_profession";
	public static final String SECTION7_MAIN_JOB = "section7_main_job";
	public static final String SECTION7_BODY_WORKS = "section7_body_works";
	public static final String SECTION7_MONTHLY_INCOME = "section7_monthly_income";
	public static final String SECTION7_RECEIVED_CREDIT = "section7_received_credit";
	public static final String SECTION7_RECEIVED_CREDIT_VALUE = "section7_received_credit_value";
	public static final String SECTION7_RECEIVED_CREDIT_VALUE_OTHER = "section7_received_credit_value_other";
	
	// Properties and ids Section 8
	public static final String SECTION8_DISABILITIES = "section8_disabilities";
	public static final String SECTION8_MEDICAL_ASSISTANCE = "section8_medical_assistance";
	public static final String SECTION8_MEDICAL_EQUIPMENT_REQUIRED = "section8_medical_equipment_required";
	public static final String SECTION8_MEDICAL_EQUIPMENT_WHICH = "section8_medical_equipment_which";
	public static final String SECTION8_MEDICAL_EQUIPMENT_HAS = "section8_medical_equipment_has";
	public static final String SECTION8_MEDICAL_EQUIPMENT_OTHER = "section8_medical_equipment_other";
	public static final String SECTION8_MEDICAL_ASSISTANCE_HAS = "section8_medical_assistance_has";
	public static final String SECTION8_PREGNANT = "section8_pregnant";

	public static final String SECTION8_SECURITY_SYSTEMS = "section8_security_systems";
	public static final String SECTION8_DISEASES = "section8_diseases";
	public static final String SECTION8_DISEASES_OTHER = "section8_diseases_other";

	public static final String SECTION8_VACCINES_BCG = "section8_vaccines_BCG";
	public static final String SECTION8_VACCINES_TRIPLE = "section8_vaccines_Triple";
	public static final String SECTION8_VACCINES_TRIVALENTE = "section8_vaccines_Trivalente";
	public static final String SECTION8_VACCINES_POLIO = "section8_vaccines_Polio";
	public static final String SECTION8_VACCINES_HEPATITISA = "section8_vaccines_HepatitisA";
	public static final String SECTION8_VACCINES_HEPATITISB = "section8_vaccines_HepatitisB";
	public static final String SECTION8_VACCINES_MENINGITIS = "section8_vaccines_Meningitis";
	public static final String SECTION8_VACCINES_SARAMPION = "section8_vaccines_Sarampion";

	public static final String SECTION8_PRENATAL = "section8_prenatal";

	// Properties and ids Section 9
	public static final String SECTION9_ARTISTIC_ABILITY = "section9_artistic_ability";
	public static final String SECTION9_ARTISTIC_ABILITY_OTHER = "section9_artistic_ability_other";
	public static final String SECTION9_TRAINING_COURSES = "section9_training_courses";
	public static final String SECTION9_TRAINING_COURSES_WHICH = "section9_training_courses_which";
	public static final String SECTION9_TRAINING_COURSES_OPTIONS = "section9_training_courses_options";
	public static final String SECTION9_PLAY_SPORTS = "section9_play_sports";
	public static final String SECTION9_PLAY_SPORTS_OTHER = "section9_play_sports_other";
	public static final String SECTION9_PARTICIPATE_ATHLETICALLY = "section9_participate_athletically";
	public static final String SECTION9_PARTICIPATE_WHICH = "section9_participate_which";

	// Properties and ids Profile
	public static final String PROFILE_CURR_PASS = "profile_curr_pass";
	public static final String PROFILE_NEW_PASS = "profile_new_pass";
	public static final String PROFILE_CONFIRM_PASS = "profile_confirm_pass";

}
