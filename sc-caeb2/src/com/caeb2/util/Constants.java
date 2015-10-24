package com.caeb2.util;

import java.io.File;

public class Constants {

	// General constants
	public static final String CENSO_COMUNITARIO = "CENSO COMUNITARIO";
	public static final String CCAEB2 = "Consejo Comunal Andrés Eloy Blanco 2";
	public static final String SECTOR_AEB = "Sector Andrés Eloy Blanco";
	public static final String DIR_CCAEB2 = "Dirección del Consejo Comunal: " //
			+ "calle principal, casa 2-32. Telf.: 0426-8288651 / 0416-3705229.";

	public static final String EXECUTE = "startup";
	public static final String ACTION = "action";
	public static final String EXEC_ACTION = EXECUTE + "?" + ACTION + "=";

	public static final String ACTION_EXIT = EXEC_ACTION + "logout";
	public static final String ACTION_PROFILE = EXEC_ACTION + "loadAdminProfile";
	public static final String ACTION_NEW_POLL = EXEC_ACTION + "newPoll";
	public static final String ACTION_NEW_HOME = EXEC_ACTION + "newHome";
	public static final String ACTION_NEW_PERSON = EXEC_ACTION + "newPerson";
	public static final String ACTION_VIEW_DWELLINGS = EXEC_ACTION + "loadAllDwellings";
	public static final String ACTION_HOME = EXEC_ACTION + "index";
	public static final String ACTION_GEN_FORMALITY = EXEC_ACTION + "generateFormality";
	public static final String ACTION_BACKUP = EXEC_ACTION + "createBackup";
	public static final String ACTION_INFO = "http://localhost/serviciocomunitario/public/";

	public static final String SC_CAEB2 = "sc-caeb2";
	public static final String PATH_SC_CAEB2 = File.separator + SC_CAEB2;
	public static final String PATH_JSP = PATH_SC_CAEB2 + File.separator + "jsp";
	public static final String PATH_CSS = PATH_SC_CAEB2 + File.separator + "css";
	public static final String PATH_IMAGES = PATH_SC_CAEB2 + File.separator + "images";
	public static final String PATH_TEMP = PATH_SC_CAEB2 + File.separator + "temp";
	public static final String PATH_REAL_PROJECT = System.getProperty("user.dir");
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	public static final String LOGO_CCAEB2 = PATH_IMAGES + File.separator + "logoccaeb2.png";

	// Properties files names
	public static final String PROP_FILE_DWELLING = "dwelling.prop";
	public static final String PROP_FILE_HOME = "home.prop";
	public static final String PROP_FILE_PERSON = "person.prop";
	public static final String PROP_FILE_CONFIG = "config.prop";

	// Attributes
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_ERROR = "error";
	public static final String ATT_SECTION = "section";
	public static final String ATT_PAGE_NUMBER = "pageNumber";
	public static final String ATT_USER = "user";
	public static final String ATT_ADMIN_PROFILE = "adminProfile";
	public static final String ATT_CURR_PAGE = "currPage";
	public static final String ATT_ADD_PERSON = "addPerson";
	public static final String ATT_ADD_HOME = "addHome";
	public static final String ATT_NOTIFICATION = "notification";
	public static final String ATT_USERNAME = "username";
	public static final String ATT_PASSWORD = "password";
	public static final String ATT_DWELLING_ID = "dwellingId";
	public static final String ATT_HOME_ID = "homeId";
	public static final String ATT_PERSON_ID = "personId";
	public static final String ATT_DWELLING_OP = "dwellingOp";
	public static final String ATT_HOME_OP = "homeOp";
	public static final String ATT_PERSON_OP = "personOp";

	// OP Types
	public static final String OP_INSERT = "insert";
	public static final String OP_UPDATE = "update";
	public static final String OP_IGNORE = "ignore";

	// Notifications types
	public static final String ALERT_SUCCESS = "alert-success";
	public static final String ALERT_INFO = "alert-info";
	public static final String ALERT_WARNING = "alert-warning";
	public static final String ALERT_DANGER = "alert-danger";

	// Messages
	public static final String FORWARD = "[REENVIAR] ";
	public static final String RESPONSE = "[RESPUESTA] ";
	public static final String USER_LOGIN = "El usuario ''{0}'' ha iniciado sesión";
	public static final String USER_LOGOUT = "El usuario ''{0}'' ha cerrado sesión";
	public static final String SAVE_DATA_TO = "Guardando datos en el archivo \"{0}\"";
	public static final String LOAD_DATA_FROM = "Cargando datos desde el archivo \"{0}\"";
	public static final String PASS_CHANGED = "Contraseña cambiada exitosamente";
	public static final String FILE_DELETED = "El archivo \"{0}\" ha sido eliminado exitosamente.";
	public static final String FILE_NOT_DELETED = "Falló la eliminación del archivo \"{0}\".";
	public static final String TRY_AGAIN = "Por favor vuelva a intentarlo.";
	public static final String DATA_SAVED = "La encuesta se ha guardado exitosamente.";
	public static final String SUCCESSFUL_DELETED = "{0} eliminad{1} exitosamente.";
	public static final String SUCCESSFUL_LOADED = "Datos cargados exitosamente.";
	public static final String USER_SUCCESSFUL_CREATED = "Usuario ''{0}'' creado exitosamente.";
	public static final String DB_INIT = "Base de datos inicializada";
	public static final String DB_SUCCESSFUL_INIT = "La base de datos se ha inicializado exitosamente.";

	// Errors Messages
	public static final String ERROR = "Ha ocurrido un problema.";
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
	public static final String ARRIVAL_DATE_ERROR = "La persona debe tener al menos seis meses viviendo en la comunidad.";
	public static final String EMPTY_FIELD_ERROR = "El campo \"{0}\" no puede estar vacío.";
	public static final String EMPTY_CEDULA_ERROR = "La cédula no puede estar vacía.";
	public static final String NO_DATA_ERROR = "No existen datos para su solicitud.";
	public static final String LOAD_DATA_ERROR = "No se pueden cargar los datos.";
	public static final String FORWARD_ERROR = "Error redirigiendo a la página \"{0}\".";
	public static final String INSERT_ERROR = "No se pudieron guardar los datos";
	public static final String INSERT_DWELLING_ERROR = INSERT_ERROR + " de la vivienda.";
	public static final String INSERT_HOME_ERROR = INSERT_ERROR + " del hogar.";
	public static final String INSERT_PERSON_ERROR = INSERT_ERROR + " de la persona.";
	public static final String MAX_SIGNERS_ERROR = "Debe seleccionar dos (2) firmantes.";
	public static final String DELETE_ERROR = "Falló eliminación de {0}.";
	public static final String NEW_USER_ERROR = "No se pudo crear el nuevo usuario.";
	public static final String NOT_SEL_CEDULA_ERROR = "Debe seleccionar una cédula.";
	public static final String FILE_EMPTY = "Debe seleccionar un archivo.";
	public static final String INVALID_PASSWORD = "Contraseña incorrecta.";
	public static final String CANNOT_ACCESS_ERROR = "No tiene permisos para realizar la acción solicitada.";

	// JSP
	public static final String JSP_OK = "Aceptar";
	public static final String JSP_CANCEL = "Cancelar";
	public static final String JSP_NEXT = "Siguiente";
	public static final String JSP_PREV = "Anterior";
	public static final String JSP_SAVE = "Guardar";
	public static final String JSP_RETURN = "Regresar";
	public static final String JSP_ERROR = "Algo ha salido mal!";
	public static final String JSP_LOGIN_TITLE = "Bienvenido";
	public static final String JSP_USER = "Usuario";
	public static final String JSP_PASS = "Contraseña";
	public static final String JSP_SIGN_IN = "Iniciar Sesión";
	public static final String JSP_SIGN_OUT = "Cerrar Sesión";
	public static final String JSP_MENU = "Menú";
	public static final String JSP_NEW_POLL = "Nueva Encuesta";
	public static final String JSP_PROFILE = "Perfil";
	public static final String JSP_EXIT = "Salir";
	public static final String JSP_VIEW_DWELLINGS = "Ver viviendas";
	public static final String JSP_GEN_FORMALITY = "Generar Constancias";
	public static final String JSP_HOME = "Inicio";
	public static final String JSP_BACKUP = "Respaldo de datos";
	public static final String JSP_IMPORT = "Importar";
	public static final String JSP_EXPORT = "Exportar";
	public static final String JSP_ABOUT = "Acerca de";
	public static final String JSP_FINISH = "Finalizar";
	public static final String JSP_PRINT = "Imprimir";
	public static final String JSP_CLOSE = "Cerrar";
	public static final String JSP_COMEBACK = "Volver";
	public static final String JSP_GENERATE = "Generar";
	public static final String JSP_YES = "Si";
	public static final String JSP_NO = "No";
	public static final String JSP_NEW_DWELLING = "Nueva Vivienda";
	public static final String JSP_NEW_HOME = "Nuevo Hogar";
	public static final String JSP_NEW_PERSON = "Nueva Persona";
	public static final String JSP_ADD_USER = "Agregar Usuario";
	public static final String JSP_CONTINUE = "Continuar";
	public static final String JSP_SEND = "Enviar";
	public static final String JSP_INFO = "Mostrar Datos";
	public static final String JSP_DWELLINGS = "Viviendas";
	public static final String JSP_HOMES = "Hogares";
	public static final String JSP_PERSONS = "Personas";

	public static final String NONE = "Ninguna";
	public static final String OTHER = "Otra ¿Cuál?";

	// Abilities
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

	// Missions
	public static final String MISION_VUELVAN_CARAS = "Misión Vuelvan Caras";
	public static final String MISION_BARRIO_ADENTRO_I = "Misión Barrio Adentro I";
	public static final String MISION_BARRIO_ADENTRO_II = "Misión Barrio Adentro II";
	public static final String MERCAL_TIPO_I = "Mercal Tipo I";
	public static final String MERCAL_TIPO_II = "Mercal Tipo II";
	public static final String SUPER_MERCAL = "Super Mercal";
	public static final String MERCALITOS = "Mercalitos";
	public static final String COMEDOR_POPULAR = "Comedor Popular";
	public static final String COMEDOR_ESCOLAR = "Comedor Escolar";
	public static final String COCINA_COMUNITARIA = "Cocina Comunitaria";
	public static final String FOGON_COMUNITARIO = "Fogón Comunitario";
	public static final String CASA_DE_ALIMENTACION = "Casa de Alimentación";
	public static final String CASA_COMUNITARIA = "Casa Comunitaria";
	public static final String MADRES_DEL_BARRIO = "Madres del barrio";
	public static final String BOTICAS_POPULARES = "Boticas Populares";
	public static final String MISION_CULTURA = "Misión Cultura";
	public static final String MISION_HABITAT = "Misión Hábitat";
	public static final String MISION_DEPORTE_ADENTRO = "Misión Deporte Adentro";
	public static final String MISION_ZAMORA = "Misión Zamora";
	public static final String MISION_GUAICAIPURO = "Misión Guaicaipuro";
	public static final String HIJOS_DE_VENEZUELA = "Hijos de Venezuela";
	public static final String MISION_IDENTIDAD = "Misión Identidad";
	public static final String MISION_PIAR = "Misión Piar";
	public static final String MISION_MIRANDA = "Misión Miranda";
	public static final String MISION_MILAGRO = "Misión Milagro";
	public static final String MISION_NEGRA_HIPOLITA = "Misión Negra Hipólita";
	public static final String MISION_SIMONCITO = "Misión Simoncito";

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

	// Properties and ids Section 3
	public static final String SECTION3_OBSERVATIONS = "section3_observations";
	public static final String SECTION3_USER = "section3_user";

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
	public static final String SECTION5_ARRIVAL_DATE = "section5_arrival_date";

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
	public static final String SECTION9_ARTISTIC_ABILITY_INSTRUCTOR = SECTION9_ARTISTIC_ABILITY + "_instructor";
	public static final String SECTION9_ARTISTIC_ABILITY_STUDENT = SECTION9_ARTISTIC_ABILITY + "_student";
	public static final String SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_NONE = SECTION9_ARTISTIC_ABILITY_INSTRUCTOR + "_none";
	public static final String SECTION9_ARTISTIC_ABILITY_STUDENT_NONE = SECTION9_ARTISTIC_ABILITY_STUDENT + "_none";
	public static final String SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER = SECTION9_ARTISTIC_ABILITY_INSTRUCTOR + "_other";
	public static final String SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER = SECTION9_ARTISTIC_ABILITY_STUDENT + "_other";

	public static final String SECTION9_ATHLETIC_ABILITY = "section9_athletic_ability";
	public static final String SECTION9_ATHLETIC_ABILITY_INSTRUCTOR = SECTION9_ATHLETIC_ABILITY + "_instructor";
	public static final String SECTION9_ATHLETIC_ABILITY_STUDENT = SECTION9_ATHLETIC_ABILITY + "_student";
	public static final String SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_NONE = SECTION9_ATHLETIC_ABILITY_INSTRUCTOR + "_none";
	public static final String SECTION9_ATHLETIC_ABILITY_STUDENT_NONE = SECTION9_ATHLETIC_ABILITY_STUDENT + "_none";
	public static final String SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER = SECTION9_ATHLETIC_ABILITY_INSTRUCTOR + "_other";
	public static final String SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER = SECTION9_ATHLETIC_ABILITY_STUDENT + "_other";

	// Properties and ids Section 10
	public static final String SECTION10_MISSIONS = "section10_missions";

	// Properties and ids Profile
	public static final String PROFILE_CURR_PASS = "profile_curr_pass";
	public static final String PROFILE_NEW_PASS = "profile_new_pass";
	public static final String PROFILE_CONFIRM_PASS = "profile_confirm_pass";
	public static final String PROFILE_CEDULA = "profile_cedula";
	public static final String PROFILE_USER = "profile_user";
	public static final String PROFILE_PASS = "profile_pass";

	// Properties config file
	public static final String CONFIG_DB_HOST = "config_db_host";
	public static final String CONFIG_DB_NAME = "config_db_name";
	public static final String CONFIG_DB_USER = "config_db_user";
	public static final String CONFIG_DB_PASS = "config_db_pass";
	public static final String CONFIG_DB_ROOT_USER = "config_db_root_user";
	public static final String CONFIG_DB_ROOT_PASS = "config_db_root_pass";
	public static final String CONFIG_SUP_ADMIN_NAME = "config_sup_admin_name";
	public static final String CONFIG_SUP_ADMIN_PASS = "config_sup_admin_pass";

}
