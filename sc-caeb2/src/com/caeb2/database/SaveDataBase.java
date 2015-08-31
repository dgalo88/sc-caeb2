package com.caeb2.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.caeb2.actions.IndividualCharacteristics;
import com.caeb2.actions.bean.MedicalData;
import com.caeb2.actions.bean.PersonBasicData;
import com.caeb2.actions.bean.PersonEducationData;
import com.caeb2.sections.EducationLevel;
import com.caeb2.sections.HomeData;
import com.caeb2.sections.HousingData;
import com.caeb2.sections.IdentifyingStructure;
import com.caeb2.util.Controller;

public class SaveDataBase {

	public static Long saveDwelling(){
		
		IdentifyingStructure identifyingStructure= new IdentifyingStructure();
		HousingData housingData= new HousingData();
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt3= null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();
			String sql = "INSERT INTO vivienda (id, callePasaje, nombre, telefono, tipoEstructura, materialParedes, materialPiso, "
					+ "materialTecho, tenencia, ubicacionCocina, numeroCuartos, servicioAgua, servicioSanitario, servicioElectrico, "
					+ "servicioRecoleccionBasura, seAjustaGrupoFamiliar, tipoSector, zonaRiesgo, posibilidadAmpliacion) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			long last_inserted_id=0;
            if(rs.next())
            {
                 last_inserted_id = rs.getLong(1);
            }

            rs.close();

            if(housingData.getUrgent_housing_improvements().equals("No"))
            	return last_inserted_id;
            
			String sql3 = "INSERT INTO mejorainfo (id, tipo, clave, valor, viviendaId) VALUES (NULL,?,?,?,?)";
			pstmt3 = connection.prepareStatement(sql3);
			processMap(housingData.getPart(), pstmt3, "parte", last_inserted_id);
			processMap(housingData.getRequired(), pstmt3, "queMejorar", last_inserted_id);
			processMap(housingData.getWorkNeeds(), pstmt3, "trabajo", last_inserted_id);
			pstmt3.executeBatch();

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
		return null;
	}
	
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
			pstmt.setString(1, type);
			pstmt.setString(2, string);
			pstmt.setString(3,value.get(string));
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
	
	
	public static boolean saveHome(long dwellingId){
		
		HomeData homeData=new HomeData();
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();

			String sql = "INSERT INTO hogar (id, numeroCuartos, numeroBanos, jefeTienePareja, dormitorioTresOMas, utilizaMercal, utilizaPdval, beneficioMercado, miembroParticipaOrganizacionComunitaria, viviendaId) VALUES (NULL,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
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
			
			pstmt.setLong(9, dwellingId);
						
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			long last_inserted_id=0;
            if(rs.next())
            {
                 last_inserted_id = rs.getLong(1);
            }
			
			String sql3 = "INSERT INTO principalesproblemascomunidad (id, descripcion, valor, hogarId) VALUES (NULL,?,?,?);";
			pstmt2 = connection.prepareStatement(sql3);
			processMap(homeData.getCommunity_problems(), pstmt2, last_inserted_id);
			pstmt2.executeBatch();

			return true;
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
		return false;
	}
	
	public static Long savePerson(long homeId) throws ParseException{
		
//		IdentifyingStructure identifyingStructure= new IdentifyingStructure();
//		HousingData housingData= new HousingData();
		
		PersonBasicData personBasicData = IndividualCharacteristics.loadPersonBasicData();
		PersonEducationData personEducationData = IndividualCharacteristics.loadPersonEducationData();
		
		String sql = "INSERT INTO persona (id, apellidos, nombres, parentescoJefeHogar, sexo, "
				+ "fechaNacimiento, nacionalidad, cedula, pasaporte, correoElectronico, celular, "
				+ "celularOpcional, esAnalfabeta, asisteEstablecimientoEducacion, respEstablecimientoEducacion, "
				+ "recibeBeca, cursoCapacitacion, nivelEducativo, ultimoGradoAprobado, profesion, ingresoMensual, "
				+ "otrasHabilidades, credito, seEncuentraEmbarazada, asisteControlMedicoParental, empleoId, hogarId) "
				+ "VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		PreparedStatement pstmtEmployee= null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,personBasicData.getLastnames());
			pstmt.setString(2,personBasicData.getNames());
			pstmt.setString(3,personBasicData.getRelationship());
			pstmt.setString(4,personBasicData.getSex());
			
			SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-yyyy");
			String strDate = personBasicData.getBirthdate();
			Date date = null;
			date = sdf.parse(strDate);
			
			pstmt.setDate(5,new java.sql.Date(date.getTime()));
			pstmt.setString(6,personBasicData.getNationality());
			pstmt.setString(7,personBasicData.getCedula()+"");
			pstmt.setString(8,personBasicData.getPassport()+"");
			pstmt.setString(9,personBasicData.getEmail());
			pstmt.setString(10,personBasicData.getPhoneCod()+""+personBasicData.getPhoneNum());
			pstmt.setString(11,personBasicData.getPhoneCodOptional()+""+personBasicData.getPhoneNumOptional());
			
			pstmt.setByte(12,parseByte(personEducationData.isIlliterate()));
			pstmt.setByte(13,parseByte(personEducationData.hasAttendEducEstablishment()));
			pstmt.setString(14,personEducationData.getAnswerEducEstablishment());
			pstmt.setString(15,personEducationData.getScholarshipDescription());
			pstmt.setString(16,personEducationData.getTrainingCourse());
			
			
			EducationLevel educationLevel= new EducationLevel();
			pstmt.setString(17,educationLevel.getDegree_approved_text());
			pstmt.setLong(18, Long.parseLong(educationLevel.getDegree_approved_level()));
			pstmt.setString(19, educationLevel.getProfession());
			pstmt.setString(20,educationLevel.getMonthly_income());
			pstmt.setString(21,educationLevel.getSkills_activity_option());
			pstmt.setString(22,educationLevel.getReceived_credit_value_other());
			
			MedicalData medicalData=new MedicalData();
			pstmt.setByte(23,parseByte(medicalData.getPregnant()));
			pstmt.setByte(24,parseByte(medicalData.getPrenatal()));
			
			pstmt.setString(25,medicalData.getMedical_assistance());
			pstmt.setString(26,medicalData.getMedical_assistance_has());
			
			String sqlEmployee = "INSERT INTO empleo ('id', 'situacion', 'oficio', 'tipo', 'tipo_seleccion', 'tipoNegocio', 'lugarTrabajo') VALUES (NULL, ?,?,?,?,?,?);";
			pstmtEmployee = connection.prepareStatement(sqlEmployee, Statement.RETURN_GENERATED_KEYS);
			pstmtEmployee.setString(1,educationLevel.getYou_are());
			pstmtEmployee.setString(2,educationLevel.getMain_job());
			pstmtEmployee.setString(3,educationLevel.getOccupation());
			pstmtEmployee.setString(4,educationLevel.getOccupation_value());
			pstmtEmployee.setString(5,educationLevel.getBody_works());
			pstmtEmployee.setString(6,educationLevel.getWork_performed());
			
			rs = pstmtEmployee.getGeneratedKeys();
			long employee_id=0;
            if(rs.next())
            {
            	employee_id = rs.getLong(1);
            }
            rs.close();
            pstmt.setDate(27,new java.sql.Date(new Date().getTime()));
            pstmt.setLong(28, employee_id);
            pstmt.setLong(29, homeId);
            
			rs = pstmt.getGeneratedKeys();
			long last_inserted_id=0;
            if(rs.next())
            {
                 last_inserted_id = rs.getLong(1);
            }
            
			String sql2 = "INSERT INTO personamision ('id','mision', 'personaId') VALUES (NULL,?,?)";
			pstmt2 = connection.prepareStatement(sql2);
			processIndividualMap(personEducationData.getEducationalMisions(), pstmt2, last_inserted_id);
			pstmt2.executeBatch();
			
			pstmt2.close();
			String sqlDisabilities = "INSERT INTO discapacidad ('id', 'descripcion', 'personaId') VALUES (NULL,?,?)";
			pstmt2 = connection.prepareStatement(sqlDisabilities);
			processIndividualMap(medicalData.getDisabilities(), pstmt2, last_inserted_id);
			pstmt2.executeBatch();
			
			pstmt2.close();
			String sqlSecuritySystems = "INSERT INTO sistemaprevencionsocial ('id', 'descripcion', 'personaId') VALUES (NULL,?,?)";
			pstmt2 = connection.prepareStatement(sqlSecuritySystems);
			processIndividualMap(medicalData.getSecurity_systems(), pstmt2, last_inserted_id);
			pstmt2.executeBatch();
			
			pstmt2.close();
			String sqlMedicalEquipment = "INSERT INTO aparatomedico ('id', 'nombre', 'descripcion', 'loTiene', 'personaId') VALUES (NULL,?,?,?,?)";
			pstmt2 = connection.prepareStatement(sqlMedicalEquipment);
			pstmtEmployee.setString(1,medicalData.getMedical_equipment_which());
			pstmtEmployee.setString(2,medicalData.getMedical_equipment_other());
			pstmt.setByte(3,parseByte(medicalData.getMedical_equipment_has()));
			pstmt.setLong(4, last_inserted_id);
			pstmt2.execute();
			
			pstmt2.close();
			String sqlVaccines = "INSERT INTO vacuna ('id', 'nombre', 'numeroDosis', 'personaId') VALUES (NULL,?,?,?)";
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
			
			

			return last_inserted_id;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

}
