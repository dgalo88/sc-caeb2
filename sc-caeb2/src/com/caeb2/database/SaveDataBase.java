package com.caeb2.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.caeb2.actions.IndividualCharacteristics;
import com.caeb2.actions.PollManager;
import com.caeb2.actions.bean.Ability;
import com.caeb2.actions.bean.MedicalData;
import com.caeb2.actions.bean.PersonBasicData;
import com.caeb2.actions.bean.PersonEducationData;
import com.caeb2.actions.bean.PersonMissions;
import com.caeb2.sections.EducationLevel;
import com.caeb2.sections.HomeData;
import com.caeb2.sections.HousingData;
import com.caeb2.sections.IdentifyingStructure;
import com.caeb2.util.Controller;

public class SaveDataBase {

	private static byte parseByte(String value){
		if(value.equals("No")){
			return 0;
		}else{
			return 1;
		}
		
	}
	
	private static byte parseByte(boolean value){
		if(!value){
			return 0;
		}else{
			return 1;
		}
		
	}
	
	private static void processMap(HashMap<String, String> value,PreparedStatement pstmt,String type, long idReference) throws SQLException{
	
		Set<String> set=value.keySet();
		
		for (String string : set) {
			pstmt.setString(1, 	type);
			pstmt.setString(2, string);
			pstmt.setString(3,value.get(string));
			pstmt.setLong(4, idReference);
			pstmt.addBatch();
		}
	}
	
	private static void processMapAbility(HashMap<String, String> abilities,HashMap<String, Boolean> abilitiesInstructor,PreparedStatement pstmt, long idReference) throws SQLException{
		Set<String> abilitiesSet=abilities.keySet();
		for (String key : abilitiesSet) {
			if(abilitiesInstructor.containsKey(key)&&abilitiesInstructor.get(key)){
				pstmt.setString(1, "I"); 
			}else{
				pstmt.setString(1, "N"); 
			}
			pstmt.setString(2, key);
			pstmt.setString(3, abilities.get(key));
			pstmt.setLong(4, idReference);
			pstmt.addBatch();
		}
	}
	
	private static void processMap(HashMap<String, String> value,PreparedStatement pstmt, long idReference) throws SQLException{
		
		Set<String> set=value.keySet();
		
		for (String string : set) {
			pstmt.setString(1, string);
			pstmt.setString(2,value.get(string));
			pstmt.setLong(3, idReference);
			pstmt.addBatch();
		}
	}
	
	private static void processIndividualMap(HashMap<String, String> value,PreparedStatement pstmt, long idReference) throws SQLException{
		
		Set<String> set=value.keySet();
		
		for (String string : set) {
			pstmt.setString(1, string);
			pstmt.setLong(2, idReference);
			pstmt.addBatch();
		}
	}
	
	private static void processIndividualMap(HashMap<String, String> value,PreparedStatement pstmt, long idReference, String type) throws SQLException{
		
		Set<String> set=value.keySet();
		
		for (String string : set) {
			pstmt.setString(1, string);
			pstmt.setString(2, type);
			pstmt.setLong(3, idReference);
			pstmt.addBatch();
		}
	}

	public static boolean deletePersonComponents(long personId){
	
		Connection connection = null;
		PreparedStatement pstmt= null;
		try {
			connection = Controller.getConnection();
            
			String sql = "DELETE FROM empleo WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM mision WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM habilidadArtisticaManual WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM deporte WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM enfermedadPadecida WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM vacuna WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM aparatoMedico WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM sistemaPrevencionSocial WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
			
			sql = "DELETE FROM discapacidad WHERE personaId = "+personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static Long updateAndInsertPerson(Long homeId, Long personId, String sql, String sessionId) {

		PersonBasicData personBasicData = IndividualCharacteristics.loadPersonBasicData(sessionId);
		PersonEducationData personEducationData = IndividualCharacteristics.loadPersonEducationData(sessionId);
		
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		PreparedStatement pstmtEmployee= null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();
			if (personId==null) {
				pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			} else {
				pstmt = connection.prepareStatement(sql);
			}
			
			pstmt.setString(1,personBasicData.getLastnames());
			pstmt.setString(2,personBasicData.getNames());
			pstmt.setString(3,personBasicData.getRelationship());
			pstmt.setString(4,personBasicData.getSex());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(personBasicData.getBirthdate());
			
			pstmt.setDate(5,new java.sql.Date(date.getTime()));
			pstmt.setString(6,personBasicData.getNationality());
			pstmt.setString(7,personBasicData.getCedula().getType()+personBasicData.getCedula().getNumber());
			pstmt.setString(8,personBasicData.getPassport().getType()+personBasicData.getPassport().getNumber());
			pstmt.setString(9,personBasicData.getEmail());
			pstmt.setString(10,"0"+personBasicData.getPhoneCod()+"-"+personBasicData.getPhoneNum());
			pstmt.setString(11,"0"+personBasicData.getPhoneCodOptional()+"-"+personBasicData.getPhoneNumOptional());
			
			pstmt.setByte(12,parseByte(personEducationData.isIlliterate()));
			pstmt.setByte(13,parseByte(personEducationData.hasAttendEducEstablishment()));
			pstmt.setString(14,personEducationData.getAnswerEducEstablishment());
			pstmt.setString(15,personEducationData.getScholarshipDescription());
			pstmt.setString(16,personEducationData.getTrainingCourse());
			
			
			EducationLevel educationLevel= new EducationLevel(sessionId);
			pstmt.setString(17,educationLevel.getDegree_approved_text());
			pstmt.setLong(18, (educationLevel.getDegree_approved_level()==null||educationLevel.getDegree_approved_level().equals("")||educationLevel.getDegree_approved_level().equals("Ninguno")) ? -1 :  Long.parseLong(educationLevel.getDegree_approved_level()));
			pstmt.setString(19, educationLevel.getProfession());
			pstmt.setString(20,educationLevel.getMonthly_income());
			pstmt.setString(21,educationLevel.getSkills_activity_option());
			pstmt.setString(22,educationLevel.getReceived_credit_value());
			
			MedicalData medicalData=new MedicalData(sessionId);
			pstmt.setByte(23,parseByte(medicalData.getPregnant()));
			pstmt.setByte(24,parseByte(medicalData.getPrenatal()));
			
			pstmt.setString(25,medicalData.getMedical_assistance());
			pstmt.setString(26,medicalData.getMedical_assistance_has());
            date = sdf.parse(personBasicData.getArrivalDate());
            
            pstmt.setDate(27,new java.sql.Date(date.getTime()));
            pstmt.setString(28,educationLevel.getReceived_credit_value_other());
            
//            pstmt.setString(30,personBasicData.getCedula().getType()+"");
//			pstmt.setString(31,personBasicData.getPassport().getType()+"");
			
			
			long last_inserted_id=0;
			
			if(personId==null){
				pstmt.setLong(29, homeId);
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
	            if(rs.next())
	            {
	                 last_inserted_id = rs.getLong(1);
	            }
			}else{
				last_inserted_id=personId;
				pstmt.execute();
			}

            //..........Procesando Empleo
			String sqlEmployee = "INSERT INTO empleo (id, situacion, oficio, tipo, tipo_seleccion, tipoNegocio, lugarTrabajo, personaId) VALUES (NULL, ?,?,?,?,?,?,?)";
			pstmtEmployee = connection.prepareStatement(sqlEmployee);
			pstmtEmployee.setString(1,educationLevel.getYou_are());
			pstmtEmployee.setString(2,educationLevel.getMain_job());
			pstmtEmployee.setString(3,educationLevel.getOccupation());
			pstmtEmployee.setString(4,educationLevel.getOccupation_value());
			pstmtEmployee.setString(5,educationLevel.getBody_works());
			pstmtEmployee.setString(6,educationLevel.getWork_performed());
			pstmtEmployee.setLong(7, last_inserted_id);
			pstmtEmployee.execute();
			
            //..........Procesar Misiones del tipo educativas 
			String sql2 = "INSERT INTO mision (id, mision, tipo, personaId) VALUES (NULL,?,?,?)";
			pstmt2 = connection.prepareStatement(sql2);
			processIndividualMap(personEducationData.getEducationalMisions(), pstmt2, last_inserted_id, "E");
			pstmt2.executeBatch();
			
			//..........Procesar Discapacidades
			pstmt2.close();
			String sqlDisabilities = "INSERT INTO discapacidad (id, descripcion, personaId) VALUES (NULL,?,?)";
			pstmt2 = connection.prepareStatement(sqlDisabilities);
			processIndividualMap(medicalData.getDisabilities(), pstmt2, last_inserted_id);
			pstmt2.executeBatch();
			
			//..........Procesar sistemas de previsión social
			pstmt2.close();
			String sqlSecuritySystems = "INSERT INTO sistemaPrevencionSocial (id, descripcion, personaId) VALUES (NULL,?,?)";
			pstmt2 = connection.prepareStatement(sqlSecuritySystems);
			processIndividualMap(medicalData.getSecurity_systems(), pstmt2, last_inserted_id);
			pstmt2.executeBatch();
			
			//..........Procesar sistemas de previsión social
			pstmt2.close();
			String sqlMedicalEquipment = "INSERT INTO aparatoMedico (id, nombre, descripcion, loTiene, personaId) VALUES (NULL,?,?,?,?)";
			pstmt2 = connection.prepareStatement(sqlMedicalEquipment);
			pstmt2.setString(1,medicalData.getMedical_equipment_which());
			pstmt2.setString(2,medicalData.getMedical_equipment_other());
			pstmt2.setByte(3,parseByte(medicalData.getMedical_equipment_has()));
			pstmt2.setLong(4, last_inserted_id);
			pstmt2.execute();
			
			//..........Procesar Vacunas
			pstmt2.close();
			String sqlVaccines = "INSERT INTO vacuna (id, nombre, numeroDosis, personaId) VALUES (NULL,?,?,?)";
			pstmt2 = connection.prepareStatement(sqlVaccines);
			HashMap<String, String> vaccines=medicalData.getVaccines();
			Set<String> vaccinesSet=vaccines.keySet();
			for (String key : vaccinesSet) {
				pstmt2.setString(1, key);
				pstmt2.setLong(2, Long.parseLong(vaccines.get(key)));
				pstmt2.setLong(3, last_inserted_id);
				pstmt2.addBatch();
			}
			pstmt2.executeBatch();
			
			//..........Procesando habilidades artística
			pstmt2.close();
			String sqlArtisticAbilities = "INSERT INTO habilidadArtisticaManual (id, participacion, clave, valor, personaId) VALUES (NULL,?,?,?,?)";
			pstmt2 = connection.prepareStatement(sqlArtisticAbilities);
			Ability ability = IndividualCharacteristics.loadAbilitiesData(sessionId);
			HashMap<String, String> artisticAbilities=ability.getArtisticAbilities();
			HashMap<String, Boolean> artisticAbilitiesInstructor=ability.getArtisticAbilitiesInstructor();
			processMapAbility(artisticAbilities, artisticAbilitiesInstructor, pstmt2, last_inserted_id);
			HashMap<String, String> artisticAbilitiesStudent=ability.getArtisticAbilitiesStudent();
			processMap(artisticAbilitiesStudent, pstmt2, "E", last_inserted_id);
			pstmt2.executeBatch();			
		
			//..........Procesando habilidades deportivas 
			
			pstmt2.close();
			String sqlAthleticAbilities = "INSERT INTO deporte (id, participacion, clave, valor, personaId) VALUES (NULL,?,?,?,?)";
			pstmt2 = connection.prepareStatement(sqlAthleticAbilities);
		
			HashMap<String, String> athleticAbilities=ability.getAthleticAbilities();
			HashMap<String, Boolean> athleticAbilitiesInstructor=ability.getAthleticAbilitiesInstructor();
			processMapAbility(athleticAbilities, athleticAbilitiesInstructor, pstmt2, last_inserted_id);
			
			HashMap<String, String> athleticAbilitiesStudent=ability.getAthleticAbilitiesStudent();
			processMap(athleticAbilitiesStudent, pstmt2, "E", last_inserted_id);			
			pstmt2.executeBatch();
			
			//..........Procesar Misiones del tipo Otras 
			pstmt2.close();
			PersonMissions personMissions = IndividualCharacteristics.loadMissions(sessionId);
			HashMap<String, String> missions = personMissions.getMissions();
			String sqlMissions = "INSERT INTO mision (id, mision, tipo, personaId) VALUES (NULL,?,?,?)";
			pstmt2 = connection.prepareStatement(sqlMissions);
			processIndividualMap(missions, pstmt2, last_inserted_id, "O");
			pstmt2.executeBatch();
			
			//..........Procesar enfermedad Padecida
			pstmt2.close();
			HashMap<String, String> diseases = medicalData.getDiseases();
			String sqlDiseases = "INSERT INTO enfermedadPadecida (id, descripcion,valor,personaId) VALUES (NULL,?,?,?)";
			pstmt2 = connection.prepareStatement(sqlDiseases);
			processMap(diseases, pstmt2, last_inserted_id);
			pstmt2.executeBatch();
			
			return last_inserted_id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				pstmt2.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				pstmtEmployee.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	
	public static Long updatePerson(Long personId, String sessionId) {
		deletePersonComponents(personId);
		String sql = "UPDATE persona SET apellidos=?, nombres=?, parentescoJefeHogar=?, "
				+ "sexo=?, fechaNacimiento=?, nacionalidad=?, cedula=?, pasaporte=?, correoElectronico=?, celular=?, "
				+ "celularOpcional=?, esAnalfabeta=?, asisteEstablecimientoEducacion=?, respEstablecimientoEducacion=?, "
				+ "recibeBeca=?, cursoCapacitacion=?, nivelEducativo=?, ultimoGradoAprobado=?, profesion=?, ingresoMensual=?, "
				+ "otrasHabilidades=?, credito=?, seEncuentraEmbarazada=?, asisteControlMedicoParental=?, lugarAsistenciaMedica=?, "
				+ "razonAsistenciaMedica=?, fechaLlegada=?, creditoOtros=? WHERE id = "+personId;
		return updateAndInsertPerson(null, personId, sql, sessionId);
	}

	public static Long insertPerson(Long homeId, String sessionId) {
		String sql = "INSERT INTO persona (id, apellidos, nombres, parentescoJefeHogar, "
				+ "sexo, fechaNacimiento, nacionalidad, cedula, pasaporte, correoElectronico, celular, "
				+ "celularOpcional, esAnalfabeta, asisteEstablecimientoEducacion, respEstablecimientoEducacion, "
				+ "recibeBeca, cursoCapacitacion, nivelEducativo, ultimoGradoAprobado, profesion, ingresoMensual, "
				+ "otrasHabilidades, credito, seEncuentraEmbarazada, asisteControlMedicoParental, lugarAsistenciaMedica, "
				+ "razonAsistenciaMedica, fechaLlegada, creditoOtros,hogarId) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return updateAndInsertPerson(homeId, null, sql, sessionId);
	}
	
	public static boolean deleteHomeComponents(long homeId) {
		
		Connection connection = null;
		PreparedStatement pstmt= null;
		try {
			connection = Controller.getConnection();
			
			String sql = "DELETE FROM principalesProblemasComunidad WHERE hogarId = "+homeId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static Long updateHome(Long homeId, String sessionId) {
		deleteHomeComponents(homeId);
		String sql = "UPDATE hogar SET numeroCuartos=?, numeroBanos=?, jefeTienePareja=?, "
				+ "dormitorioTresOMas=?, utilizaMercal=?, utilizaPdval=?, beneficioMercado=?, "
				+ "miembroParticipaOrganizacionComunitaria=? WHERE id = "+homeId;
		return updateAndInserHome(null, homeId, sql, sessionId);
	}

	public static Long insertHome(Long dwellingId, String sessionId) {
		String sql = "INSERT INTO hogar (id, numeroCuartos, numeroBanos, jefeTienePareja, dormitorioTresOMas, utilizaMercal, utilizaPdval, beneficioMercado, miembroParticipaOrganizacionComunitaria, viviendaId) VALUES (NULL,?,?,?,?,?,?,?,?,?)";
		return updateAndInserHome(dwellingId, null, sql, sessionId);
	}
	
	public static Long updateAndInserHome(Long dwellingId, Long homeId, String sql, String sessionId) {
		
		HomeData homeData=new HomeData(sessionId);
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();

//			String sql = "INSERT INTO hogar (id, numeroCuartos, numeroBanos, jefeTienePareja, dormitorioTresOMas, utilizaMercal, utilizaPdval, beneficioMercado, miembroParticipaOrganizacionComunitaria, viviendaId) VALUES (NULL,?,?,?,?,?,?,?,?,?)";
			if (homeId==null) {
				pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			} else {
				pstmt = connection.prepareStatement(sql);
			}
			
			pstmt.setLong(1, Long.parseLong(homeData.getRooms()));
			pstmt.setLong(2, Long.parseLong(homeData.getNumber_bathrooms()));
			pstmt.setByte(3,parseByte(homeData.getChief_couple()));
			pstmt.setByte(4,parseByte(homeData.getSleeps_3_or_more()));
			
			if(homeData.getUsed_mercal().equals("No")){
				pstmt.setString(5,"No");
			}else{
				pstmt.setString(5,homeData.getUsed_mercal_selected());
			}
			
			if(homeData.getUsed_pdval().equals("No")){
				pstmt.setString(6,"No");
			}else{
				pstmt.setString(6,homeData.getUsed_pdval_selected());
			}
			
			if(homeData.getFood_markets().equals("No")){
				pstmt.setString(7,"No");
			}else{
				pstmt.setString(7,homeData.getFood_markets_response());
			}
			
			if(homeData.getCommunity_organization().equals("No")){
				pstmt.setString(8,"No");
			}else{
				pstmt.setString(8,homeData.getCommunity_organization_which());
			}
			
//			pstmt.setLong(9, dwellingId);
//						
//			pstmt.executeUpdate();
			
			long last_inserted_id=0;
			
			if(homeId==null){
				pstmt.setLong(9, dwellingId);
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				
	            if(rs.next())
	            {
	                 last_inserted_id = rs.getLong(1);
	            }
			}else{
				last_inserted_id=homeId;
				pstmt.execute();
			}
			
			String sql3 = "INSERT INTO principalesProblemasComunidad (id, descripcion, valor, hogarId) VALUES (NULL,?,?,?);";
			pstmt2 = connection.prepareStatement(sql3);
			processMap(homeData.getCommunity_problems(), pstmt2, last_inserted_id);
			pstmt2.executeBatch();

			return last_inserted_id;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				pstmt2.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
	
	public static boolean deleteDwellingComponents(long viviendaId){
		
		Connection connection = null;
		PreparedStatement pstmt= null;
		try {
			connection = Controller.getConnection();
			
			String sql = "DELETE FROM mejoraInfo WHERE viviendaId = "+viviendaId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static Long updateDwelling(Long dwellingId, String sessionId) {
		deleteDwellingComponents(dwellingId);
		String sql = "UPDATE vivienda SET callePasaje=?, nombre=?, telefono=?, tipoEstructura=?, materialParedes=?, materialPiso=?, "
				+ "materialTecho=?, tenencia=?, ubicacionCocina=?, numeroCuartos=?, servicioAgua=?, servicioSanitario=?, servicioElectrico=?, "
				+ "servicioRecoleccionBasura=?, seAjustaGrupoFamiliar=?, tipoSector=?, zonaRiesgo=?, posibilidadAmpliacion=? WHERE id = "+dwellingId;
		return updateAndInserDwelling(dwellingId, sql, sessionId);
	}

	public static Long insertDwelling(String sessionId) {
		String sql = "INSERT INTO vivienda (id, callePasaje, nombre, telefono, tipoEstructura, materialParedes, materialPiso, "
				+ "materialTecho, tenencia, ubicacionCocina, numeroCuartos, servicioAgua, servicioSanitario, servicioElectrico, "
				+ "servicioRecoleccionBasura, seAjustaGrupoFamiliar, tipoSector, zonaRiesgo, posibilidadAmpliacion) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return updateAndInserDwelling(null, sql, sessionId);
	}
	
	public static Long updateAndInserDwelling(Long dwellingId, String sql, String sessionId) {
		
		IdentifyingStructure identifyingStructure= new IdentifyingStructure(sessionId);
		HousingData housingData= new HousingData(sessionId);
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt3= null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();
			if (dwellingId==null) {
				pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			} else {
				pstmt = connection.prepareStatement(sql);
			}
			pstmt.setString(1,identifyingStructure.getStreet());
			pstmt.setString(2,identifyingStructure.getNameHousing());
			pstmt.setString(3,identifyingStructure.getHomePhone());
			pstmt.setString(4,housingData.getStructure_type());
			pstmt.setString(5,housingData.getWalls_type());
			pstmt.setString(6,housingData.getFlat_type());
			pstmt.setString(7,housingData.getCeiling_type());
			pstmt.setString(8,housingData.getHolding());
			pstmt.setString(9,housingData.getLocation_kitchen());
			pstmt.setLong(10, Long.parseLong(housingData.getTotal_rooms()));
			pstmt.setString(11,housingData.getOther_housing_water());
			pstmt.setString(12,housingData.getSanitary_service());
			pstmt.setByte(13,parseByte(housingData.getElectrical_service()));
			pstmt.setString(14,housingData.getGarbage_collection());
			pstmt.setByte(15,parseByte(housingData.getHousing_fits_household()));
			pstmt.setString(16,housingData.getHouse_sector());
			pstmt.setString(17,housingData.getHousing_risk());
			pstmt.setByte(18,parseByte(housingData.getHouse_scalability()));
			
			long last_inserted_id=0;
			
			if(dwellingId==null){
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				
	            if(rs.next())
	            {
	                 last_inserted_id = rs.getLong(1);
	            }
	            if(insertPoll(last_inserted_id, sessionId)==null){
	            	return null;
	            }
			}else{
				last_inserted_id=dwellingId;
				pstmt.execute();
				updatePoll(dwellingId, sessionId);
			}

            if(housingData.getUrgent_housing_improvements().equals("No"))
            	return last_inserted_id;
            
			String sql3 = "INSERT INTO mejoraInfo (id, tipo, clave, valor, viviendaId) VALUES (NULL,?,?,?,?)";
			pstmt3 = connection.prepareStatement(sql3);
			processMap(housingData.getPart(), pstmt3, "parte", last_inserted_id);
			processMap(housingData.getRequired(), pstmt3, "queMejorar", last_inserted_id);
			processMap(housingData.getWorkNeeds(), pstmt3, "trabajo", last_inserted_id);
			pstmt3.executeBatch();

			return last_inserted_id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				pstmt3.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
		
	public static boolean deleteDwelling(long dwellingId){
		
		Connection connection = null;
		PreparedStatement pstmt= null;
		try {
			connection = Controller.getConnection();
			
			String sql = "DELETE FROM vivienda WHERE id = "+dwellingId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static boolean deleteHome(long homeId){
		
		Connection connection = null;
		PreparedStatement pstmt= null;
		try {
			connection = Controller.getConnection();
			
			String sql = "DELETE FROM hogar WHERE id = "+homeId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static boolean deletePerson(long personId) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = Controller.getConnection();

			String sql = "DELETE FROM persona WHERE id = " + personId;
			pstmt = connection.prepareStatement(sql);
			pstmt.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static Long insertPoll(Long dwellingId, String sessionId) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();

			String sql = "INSERT INTO encuesta (numeroPlanilla, fechaEntrevista, nombreEmpadronador, observaciones, viviendaId) VALUES (NULL,?,?,?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1,new java.sql.Date(new Date().getTime()));
			pstmt.setString(2,PollManager.getUser(sessionId));
			pstmt.setString(3,PollManager.getObservations(sessionId));
			pstmt.setLong(4,dwellingId);
			
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			long last_inserted_id=0;
            if(rs.next())
            {
                 last_inserted_id = rs.getLong(1);
            }

			return last_inserted_id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static Long updatePoll(Long dwellingId, String sessionId) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = Controller.getConnection();

			String sql = "UPDATE encuesta SET observaciones=? where viviendaId="+dwellingId;
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,PollManager.getObservations(sessionId));
			
			pstmt.execute();

			return dwellingId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
