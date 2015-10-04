//				apellidos
//				nombres
//				parentescoJefeHogar
//				sexo
//				fechaNacimiento
//				nacionalidad
//				cedula
//				pasaporte
//				correoElectronico
//				celular
//				celularOpcional
//				esAnalfabeta
//				asisteEstablecimientoEducacion
//				respEstablecimientoEducacion
//				recibeBeca
//				cursoCapacitacion
//				nivelEducativo
//				ultimoGradoAprobado
//				profesion
//				ingresoMensual
//				otrasHabilidades
//				credito
//				seEncuentraEmbarazada
//				asisteControlMedicoParental
//				lugarAsistenciaMedica
//				razonAsistenciaMedica
//				fechaLlegada
//				empleoId
//				hogarId
//				cedulaTipo
//				pasaporteTipo
package com.caeb2.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.actions.bean.IdentificationDocument;
import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;
import com.caeb2.util.Controller.PropFileRole;

public class LoadDataBase {

	public static boolean loadDwelling(long idDwelling, String sessionId) {
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		ResultSet rs = null;
		try {
			
			connection = Controller.getConnection();
			String sql = "SELECT callePasaje, nombre, telefono, tipoEstructura, materialParedes, materialPiso, materialTecho, "
					+ "tenencia, ubicacionCocina, numeroCuartos, servicioAgua, servicioSanitario, servicioElectrico, "
					+ "servicioRecoleccionBasura, seAjustaGrupoFamiliar, tipoSector, zonaRiesgo, posibilidadAmpliacion FROM "
					+ "vivienda WHERE id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, idDwelling);
			rs=pstmt.executeQuery();
            if(rs.next())
            {
            	PropertiesConfiguration prop = Controller.getPropertiesFile( //
            			Constants.PROP_FILE_DWELLING, PropFileRole.LOAD, sessionId);
        		String street =rs.getString(1);
        		String name_housing =rs.getString(2);
        		String home_phone=rs.getString(3);
        		
        		prop.setProperty(Constants.SECTION1_STREET, street);
        		prop.setProperty(Constants.SECTION1_NAME_HOUSING, name_housing);
        		prop.setProperty(Constants.SECTION1_HOME_PHONE, home_phone);
        		
        		String structure_type=rs.getString(4);
        		String walls_type=rs.getString(5);
        		String flat_type=rs.getString(6);
        		String ceiling_type=rs.getString(7);
        		String holding=rs.getString(8);
        		String location_kitchen=rs.getString(9);
        		String total_rooms=rs.getLong(10)+"";
        		String housing_water=rs.getString(11);
        		String other_housing_water = null; 
        		if(!housing_water.equals("Acueducto o tubería")&&!housing_water.equals("Camión cisterna")&&!housing_water.equals("Pila pública o estanque")){
        			other_housing_water=housing_water; 
        			housing_water="Otros medios, especifique";
        		}
        		
        		String sanitary_service=rs.getString(12);
        		String electrical_service=rs.getByte(13)==0 ? "No" : "Sí";
        		String garbage_collection=rs.getString(14);
        		String housing_fits_household=rs.getByte(15)==0 ? "No" : "Sí";
        		String house_sector=rs.getString(16);
        		String housing_risk=rs.getString(17);
        		String house_scalability=rs.getByte(18)==0 ? "No" : "Sí";
        		
        		
        		String part_other_response = null;
        		String required_other_response = null;
        		String work_needs_other_response = null;
        		
        		rs.close();
        		String urgent_housing_improvements="No";
    			pstmt2 = connection.prepareStatement("SELECT tipo, clave, valor FROM mejorainfo WHERE viviendaId=?");
    			pstmt2.setLong(1, idDwelling);
    			rs=pstmt2.executeQuery();
    			ArrayList<String> partList=new ArrayList<String>();
    			ArrayList<String> requiredList=new ArrayList<String>();
    			ArrayList<String> workNeedsList=new ArrayList<String>();
                if(rs.next())
                {
                	String type=rs.getString("tipo");
                	String clave=rs.getString("clave");
                	String value=rs.getString("clave");
                	if(type.equals("parte")){
                		partList.add(clave);
                		if(clave.equals("Otra ¿Cuál?")){
                			part_other_response=value;
                		}
                	}else if(type.equals("queMejorar")){
                		requiredList.add(clave);
                		if(clave.equals("Otra ¿Cuál?")){
                			required_other_response=value;
                		}
                	}else if(type.equals("trabajo")){
                		workNeedsList.add(clave);
                		if(clave.equals("Otra ¿Cuál?")){
                			work_needs_other_response=value;
                		}
                	}
                	urgent_housing_improvements="Sí";
                }
        		
        		String part[]=partList.toArray(new String[partList.size()]);
        		String required[]=requiredList.toArray(new String[requiredList.size()]);
        		String workNeeds[]=workNeedsList.toArray(new String[workNeedsList.size()]);

        		prop.setProperty(Constants.SECTION2_STRUCTURE_TYPE,structure_type);
        		prop.setProperty(Constants.SECTION2_HOLDING,holding);
        		prop.setProperty(Constants.SECTION2_TOTAL_ROOMS,total_rooms);
        		prop.setProperty(Constants.SECTION2_HOUSING_FITS_HOUSEHOLD,housing_fits_household);
        		prop.setProperty(Constants.SECTION2_HOUSE_SECTOR,house_sector);
        		prop.setProperty(Constants.SECTION2_HOUSE_SCALABILITY,house_scalability);
        		prop.setProperty(Constants.SECTION2_WALLS_TYPE,walls_type);
        		prop.setProperty(Constants.SECTION2_CEILING_TYPE,ceiling_type);
        		prop.setProperty(Constants.SECTION2_FLAT_TYPE,flat_type);
        		prop.setProperty(Constants.SECTION2_LOCATION_KITCHEN,location_kitchen);
        		prop.setProperty(Constants.SECTION2_HOUSING_WATER,housing_water);
        		prop.setProperty(Constants.SECTION2_OTHER_HOUSING_WATER,other_housing_water); 
        		prop.setProperty(Constants.SECTION2_SANITARY_SERVICE,sanitary_service);
        		prop.setProperty(Constants.SECTION2_ELECTRICAL_SERVICE,electrical_service);
        		prop.setProperty(Constants.SECTION2_GARBAGE_COLLECTION,garbage_collection);
        		prop.setProperty(Constants.SECTION2_HOUSING_RISK,housing_risk);
        		prop.setProperty(Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS,urgent_housing_improvements);
        		
        		prop.setProperty(Constants.SECTION2_PART,part);
        		prop.setProperty(Constants.SECTION2_REQUIRED,required);
        		prop.setProperty(Constants.SECTION2_WORK_NEEDS,workNeeds);
        		
        		prop.setProperty(Constants.SECTION2_PART_OTHER_RESPONSE,part_other_response);
        		prop.setProperty(Constants.SECTION2_REQUIRED_OTHER_RESPONSE,required_other_response);
        		prop.setProperty(Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE,work_needs_other_response);
        		
        		prop.save();
        		return true;
            }
			
		} catch (Exception e) {
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
	
	public static boolean loadHome(long homeId, String sessionId) {
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		ResultSet rs = null;
		try {
			
			PropertiesConfiguration prop = Controller.getPropertiesFile( //
					Constants.PROP_FILE_HOME, PropFileRole.LOAD, sessionId);
			connection = Controller.getConnection();			
			String sql = "SELECT * FROM hogar WHERE id=?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, homeId);
			rs=pstmt.executeQuery();
            if(rs.next())
            {
            	
            	String section4_rooms=rs.getString("numeroCuartos");
            	String section4_number_bathrooms=rs.getString("numeroBanos");
        		String section4_chief_couple=rs.getByte("jefeTienePareja")==0 ? "No" : "Sí";
        		String section4_sleeps_3_or_more=rs.getByte("dormitorioTresOMas")==0 ? "No" : "Sí";
        		multipleProcessesCases(prop, Constants.SECTION4_USED_MERCAL, Constants.SECTION4_USED_MERCAL_SELECTED, rs.getString("utilizaMercal"));
        		multipleProcessesCases(prop, Constants.SECTION4_USED_PDVAL, Constants.SECTION4_USED_PDVALL_SELECTED, rs.getString("utilizaPdval"));
        		multipleProcessesCases(prop, Constants.SECTION4_FOOD_MARKETS, Constants.SECTION4_FOOD_MARKETS_RESPONSE, rs.getString("beneficioMercado"));
        		multipleProcessesCases(prop, Constants.SECTION4_COMMUNITY_ORGANIZATIO, Constants.SECTION4_COMMUNITY_ORGANIZATION_WHICH, rs.getString("beneficioMercado"));
        		
        		prop.setProperty(Constants.SECTION4_ROOMS,section4_rooms);
        		prop.setProperty(Constants.SECTION4_CHIEF_COUPLE,section4_chief_couple);
        		prop.setProperty(Constants.SECTION4_NUMBER_BATHROOMS,section4_number_bathrooms);
        		prop.setProperty(Constants.SECTION4_SLEEPS_3_OR_MORE,section4_sleeps_3_or_more);
        	
        		rs.close();
        		
        		String section4_community_problems_other = null;
        		
    			pstmt2 = connection.prepareStatement("SELECT id, descripcion, valor FROM principalesproblemascomunidad WHERE hogarId=?");
    			pstmt2.setLong(1, homeId);
    			rs=pstmt2.executeQuery();
    			ArrayList<String> communityProblems=new ArrayList<String>();
                if(rs.next())
                {
                	String clave=rs.getString("descripcion");
                	String value=rs.getString("valor");
                	communityProblems.add(clave);
                	if(clave.equals("Otra ¿Cuál?")){
                		section4_community_problems_other=value;
                	}
                }
                	
                String section4_community_problems[]=communityProblems.toArray(new String[communityProblems.size()]);
                
                prop.setProperty(Constants.SECTION4_COMMUNITY_PROBLEMS,section4_community_problems);
        		prop.setProperty(Constants.SECTION4_COMMUNITY_PROBLEMS_OTHER,section4_community_problems_other);
        		
        		prop.save();      		
        		
        		
            }
        	
		} catch (Exception e) {
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
	private static void multipleProcessesCases(PropertiesConfiguration prop,String constants1,String constants2, String key) {
		if(key.equals("No")){
			prop.setProperty(constants1,"No");
		}else{
			prop.setProperty(constants1,"Sí");
			prop.setProperty(constants2,key);
		}
		
	}
	
	public static boolean loadPerson(long personId, String sessionId) {
		
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			PropertiesConfiguration prop = Controller.getPropertiesFile( //
					Constants.PROP_FILE_HOME, PropFileRole.LOAD, sessionId);
			connection = Controller.getConnection();			
			String sql = "SELECT * FROM persona WHERE id= ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, personId);
			rs=pstmt.executeQuery();
			if(rs.next())
            {
				String lastnames = rs.getString("apellidos");
				String names = rs.getString("nombres");
				prop.setProperty(Constants.SECTION5_LASTNAMES, lastnames);
				prop.setProperty(Constants.SECTION5_NAMES, names);
				String document = rs.getString("cedula");
				IdentificationDocument documentI=new IdentificationDocument(document);
				prop.setProperty(Constants.SECTION5_CEDULA_TYPE, documentI.getType());
				prop.setProperty(Constants.SECTION5_CEDULA_NUM, documentI.getNumber());
				String passportNumber = rs.getString("pasaporte");
				if (!TextUtils.isEmptyOrNull(passportNumber)) {
					IdentificationDocument passportI=new IdentificationDocument(passportNumber);
					prop.setProperty(Constants.SECTION5_PASSPORT, Integer.valueOf(passportI.getNumber()));
				}
				String sex = rs.getString("sexo");
				prop.setProperty(Constants.SECTION5_SEX, sex);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date = rs.getDate("fechaNacimiento");
				String birthdate = sdf.format(date);
				prop.setProperty(Constants.SECTION5_BIRTHDATE, birthdate);
				String nationality = rs.getString("nacionalidad");
				prop.setProperty(Constants.SECTION5_NATIONALITY, nationality);
				HashMap<String, String> phoneMap=processPhone(rs.getString("celular"));
				String phoneCod = phoneMap.get("param1");
				String phoneNum = phoneMap.get("param2");
				prop.setProperty(Constants.SECTION5_PHONE_COD, phoneCod);
				prop.setProperty(Constants.SECTION5_PHONE_NUM, phoneNum);
				String phoneNumOptional = rs.getString("celularOpcional");
				if (!TextUtils.isEmptyOrNull(phoneNumOptional)) {
					HashMap<String, String> phoneMapOptional=processPhone(phoneNumOptional);
					prop.setProperty(Constants.SECTION5_PHONE_COD_OPTIONAL, phoneMapOptional.get("param1"));
					prop.setProperty(Constants.SECTION5_PHONE_NUM_OPTIONAL, phoneMapOptional.get("param2"));
				}
				String email = rs.getString("correoElectronico");
				prop.setProperty(Constants.SECTION5_EMAIL, email);
				String relationship = rs.getString("parentescoJefeHogar");
				prop.setProperty(Constants.SECTION5_RELATIONSHIP, relationship);
				date = rs.getDate("fechaLlegada");
				String arrivalDate = sdf.format(date);
				prop.setProperty(Constants.SECTION5_ARRIVAL_DATE, arrivalDate);
				
				//........... PersonEducationData
				
				String illiterate = rs.getByte("esAnalfabeta")==0 ? "No" : "Sí";
				prop.setProperty(Constants.SECTION6_ILLITERATE, illiterate);
				prop.setProperty(Constants.SECTION6_TRAINING_COURSE, rs.getString("cursoCapacitacion"));	
				String attendEducEstablishment = rs.getByte("asisteEstablecimientoEducacion")==0 ? "No" : "Sí";
				prop.setProperty(Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT, attendEducEstablishment);
				String answerEducEstablishment = rs.getString("respEstablecimientoEducacion");
				prop.setProperty(Constants.SECTION6_ANSWER_EDUC_ESTABLISHMENT, answerEducEstablishment);
				String scholarshipDescription = rs.getString("recibeBeca");
				prop.setProperty(Constants.SECTION6_SCHOLARSHIP_DESCRIPTION, scholarshipDescription);

				ArrayList<String> educationalMisionsList=new ArrayList<String>();
				ArrayList<String> otherMisionsList=new ArrayList<String>();
				
				sql = "SELECT * FROM mision WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				String missionType;
				String missionName;
				if(rs2.next())
	            {
					missionType=rs2.getString("tipo");
					missionName=rs2.getString("mision");
					if(missionType.equals("E")){
						educationalMisionsList.add(missionName);
					}else{
						otherMisionsList.add(missionName);
					}
					
	            }
				String[] educationalMisions = educationalMisionsList.toArray(new String[educationalMisionsList.size()]);
				prop.setProperty(Constants.SECTION6_EDUCATIONAL_MISIONS, educationalMisions);
				
				String[] otherMisions = otherMisionsList.toArray(new String[otherMisionsList.size()]);
				prop.setProperty(Constants.SECTION10_MISSIONS, otherMisions);
				
				//........... Empleo
				
				String degree_approved_text=rs.getString("nivelEducativo");
				String degree_approved_level=rs.getInt("ultimoGradoAprobado")+"";
				String profession=rs.getString("profesion");
				String skills_activity=rs.getString("otrasHabilidades");
				String skills_activity_option = "";
				
				if(!skills_activity.equals("No")){
					skills_activity_option=skills_activity;
					skills_activity="Sí ¿Cuál?";	
				}
				
				
				pstmt2.close();
				rs2.close();
				
				sql = "SELECT * FROM empleo WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				
				String you_are = "";
				String occupation = "";
				String occupation_value = "";
				String work_performed = "";
				String main_job="";
				String body_works="";
				
				if(rs2.next())
	            {
					you_are=rs2.getString("situacion");
					occupation=rs2.getString("tipo");
					occupation_value=rs2.getString("tipo_seleccion");
					work_performed=rs2.getString("lugarTrabajo");
					main_job=rs2.getString("oficio");
					body_works=rs2.getString("tipoNegocio");
	            }
				
				String monthly_income=rs.getString("ingresoMensual");
				String received_credit=rs.getString("credito");
				String received_credit_value = "";
				String received_credit_value_other = "";
				
				if(!received_credit.equals("No")){
					received_credit_value=received_credit;
					received_credit="Sí ¿Cuál instituto lo otorgo?";	
					received_credit_value_other=rs.getString("creditoOtros");
				}

				prop.setProperty(Constants.SECTION7_DEGREE_APPROVED_LEVEL,degree_approved_text);
				prop.setProperty(Constants.SECTION7_DEGREE_APPROVED_TEXT,degree_approved_level);
				prop.setProperty(Constants.SECTION7_YOU_ARE,you_are);
				prop.setProperty(Constants.SECTION7_OCCUPATION,occupation);
				prop.setProperty(Constants.SECTION7_OCCUPATION_VALUE,occupation_value);
				prop.setProperty(Constants.SECTION7_WORK_PERFORMED,work_performed);
				prop.setProperty(Constants.SECTION7_SKILLS_ACTIVITY,skills_activity);
				prop.setProperty(Constants.SECTION7_SKILLS_ACTIVITY_OPTION,skills_activity_option);

				prop.setProperty(Constants.SECTION7_PROFESSION,profession);
				prop.setProperty(Constants.SECTION7_MAIN_JOB,main_job);
				prop.setProperty(Constants.SECTION7_BODY_WORKS,body_works);
				prop.setProperty(Constants.SECTION7_MONTHLY_INCOME,monthly_income);
				prop.setProperty(Constants.SECTION7_RECEIVED_CREDIT,received_credit);
				prop.setProperty(Constants.SECTION7_RECEIVED_CREDIT_VALUE,received_credit_value);
				prop.setProperty(Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER,received_credit_value_other);
				
				//........... Salu
				
				pstmt2.close();
				rs2.close();
				sql = "SELECT * FROM discapacidad WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				ArrayList<String> disabilitiesList=new ArrayList<String>();
				if(rs2.next())
	            {
					disabilitiesList.add(rs2.getString("descripcion"));
					
	            }
				
				String disabilities[] = disabilitiesList.toArray(new String[disabilitiesList.size()]);
				
				pstmt2.close();
				rs2.close();
				sql = "SELECT * FROM sistemaprevencionsocial WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				ArrayList<String> security_systemsList=new ArrayList<String>();
				if(rs2.next())
	            {
					security_systemsList.add(rs2.getString("descripcion"));
					
	            }
				
				String security_systems[] = security_systemsList.toArray(new String[security_systemsList.size()]);
				
				pstmt2.close();
				rs2.close();
				sql = "SELECT * FROM enfermedadPadecida WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				ArrayList<String> diseasesList=new ArrayList<String>();
				String diseasesText;
				String diseases_other="";
				if(rs2.next())
	            {
					diseasesText=rs2.getString("descripcion");
					diseasesList.add(diseasesText);
					if(diseasesText.equals("Otra ¿Cuál?")){
						diseases_other=rs2.getString("valor");
					}
				}
					
				String diseases[] =diseasesList.toArray(new String[diseasesList.size()]);
					
					
				String medical_assistance =rs.getString("lugarAsistenciaMedica");
				String medical_assistance_has =rs.getString("razonAsistenciaMedica");
				
				
				String medical_equipment_required = "";
				String medical_equipment_which ="";
				String medical_equipment_has="";
				String medical_equipment_other="";

				pstmt2.close();
				rs2.close();
				sql = "SELECT * FROM aparatomedico WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				if(rs2.next())
	            {
					medical_equipment_required=rs2.getString("nombre");
					if(!medical_equipment_required.equals("No")){
						medical_equipment_which=medical_equipment_required;
						if(medical_equipment_which.equals("Otra ¿Cuál?")){
							medical_equipment_other=rs2.getString("descripcion");
						}
						medical_equipment_required="Sí";
						medical_equipment_has=rs2.getByte("loTiene")==0 ? "No" : "Sí";
					}				
					
				}
				
				String pregnant =rs.getByte("seEncuentraEmbarazada")==0 ? "No" : "Sí";
				String prenatal =rs.getByte("asisteControlMedicoParental")==0 ? "No" : "Sí";

				pstmt2.close();
				rs2.close();
				sql = "SELECT * FROM vacuna WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				HashMap<String, String> vaccines=new HashMap<String, String>();
				if(rs2.next())
	            {
					vaccines.put(rs2.getString("nombre"), rs2.getInt("numeroDosis")+"");
	
				}
				
				String vaccines_BCG =vaccines.get("BCG");
				String vaccines_Triple =vaccines.get("Triple");
				String vaccines_Trivalente =vaccines.get("Trivalente");
				String vaccines_Polio =vaccines.get("Polio");
				String vaccines_HepatitisA =vaccines.get("HepatitisA");
				String vaccines_HepatitisB =vaccines.get("HepatitisB");
				String vaccines_Meningitis =vaccines.get("Meningitis");
				String vaccines_Sarampion =vaccines.get("Sarampion");

				prop.setProperty(Constants.SECTION8_DISABILITIES,disabilities);
				prop.setProperty(Constants.SECTION8_SECURITY_SYSTEMS,security_systems);
				prop.setProperty(Constants.SECTION8_MEDICAL_ASSISTANCE,medical_assistance);
				prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_REQUIRED,medical_equipment_required);
				prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_WHICH,medical_equipment_which);
				prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_HAS,medical_equipment_has);
				prop.setProperty(Constants.SECTION8_MEDICAL_EQUIPMENT_OTHER,medical_equipment_other);
				prop.setProperty(Constants.SECTION8_MEDICAL_ASSISTANCE_HAS,medical_assistance_has);

				prop.setProperty(Constants.SECTION8_PREGNANT,pregnant);
				prop.setProperty(Constants.SECTION8_DISEASES,diseases);
				prop.setProperty(Constants.SECTION8_DISEASES_OTHER,diseases_other);
				prop.setProperty(Constants.SECTION8_VACCINES_BCG,vaccines_BCG);
				prop.setProperty(Constants.SECTION8_VACCINES_TRIPLE,vaccines_Triple);
				prop.setProperty(Constants.SECTION8_VACCINES_TRIVALENTE,vaccines_Trivalente);
				prop.setProperty(Constants.SECTION8_VACCINES_POLIO,vaccines_Polio);
				prop.setProperty(Constants.SECTION8_VACCINES_HEPATITISA,vaccines_HepatitisA);
				prop.setProperty(Constants.SECTION8_VACCINES_HEPATITISB,vaccines_HepatitisB);
				prop.setProperty(Constants.SECTION8_VACCINES_MENINGITIS,vaccines_Meningitis);
				prop.setProperty(Constants.SECTION8_VACCINES_SARAMPION,vaccines_Sarampion);
				prop.setProperty(Constants.SECTION8_PRENATAL,prenatal);
				
				
				
				
				
				pstmt2.close();
				rs2.close();
				sql = "SELECT * FROM habilidadartisticamanual WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				ArrayList<String> artisticAbilitiesN=new ArrayList<String>();
				ArrayList<String> artisticAbilitiesE=new ArrayList<String>();
				ArrayList<String> artisticAbilitiesI=new ArrayList<String>();
				String participation;
				if(rs2.next())
	            {
					participation=rs2.getString("participacion");
					if(participation.equals("E")){
						artisticAbilitiesE.add(rs2.getString("clave"));
						if (rs2.getString("clave").equals(Constants.OTHER)) {
							prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER,rs2.getString("valor"));
						}
					}else{
						artisticAbilitiesN.add(rs2.getString("clave"));
						if (rs2.getString("clave").equals(Constants.OTHER)) {
							prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER,rs2.getString("valor"));
						}
						if(participation.equals("I")){
							artisticAbilitiesI.add("true");
						}else{
							artisticAbilitiesI.add("false");
						}
					}
	
				}

				String[] artisticAbilities = artisticAbilitiesN.toArray(new String[artisticAbilitiesN.size()]);
				String[] artisticAbilitiesInstructor = artisticAbilitiesI.toArray(new String[artisticAbilitiesI.size()]);
				prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY, artisticAbilities);
				prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR, artisticAbilitiesInstructor);
				String[] artisticAbilitiesStudent = artisticAbilitiesE.toArray(new String[artisticAbilitiesE.size()]);
				prop.setProperty(Constants.SECTION9_ARTISTIC_ABILITY_STUDENT, artisticAbilitiesStudent);


				
				
				
				pstmt2.close();
				rs2.close();
				sql = "SELECT * FROM deporte WHERE personaId = ?";
				pstmt2 = connection.prepareStatement(sql);
				pstmt2.setLong(1, personId);
				rs2=pstmt2.executeQuery();
				ArrayList<String> athleticAbilitiesN=new ArrayList<String>();
				ArrayList<String> athleticAbilitiesE=new ArrayList<String>();
				ArrayList<String> athleticAbilitiesI=new ArrayList<String>();
				if(rs2.next())
	            {
					participation=rs2.getString("participacion");
					if(participation.equals("E")){
						athleticAbilitiesE.add(rs2.getString("clave"));
						if (rs2.getString("clave").equals(Constants.OTHER)) {
							prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER,rs2.getString("valor"));
						}
					}else{
						athleticAbilitiesN.add(rs2.getString("clave"));
						if (rs2.getString("clave").equals(Constants.OTHER)) {
							prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER,rs2.getString("valor"));
						}
						if(participation.equals("I")){
							athleticAbilitiesI.add("true");
						}else{
							athleticAbilitiesI.add("false");
						}
					}
	
				}

				String[] athleticAbilities = athleticAbilitiesN.toArray(new String[athleticAbilitiesN.size()]);
				prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY, athleticAbilities);
				String[] athleticAbilitiesInstructor = athleticAbilitiesI.toArray(new String[athleticAbilitiesI.size()]);
				prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR, athleticAbilitiesInstructor);
				String[] athleticAbilitiesStudent = athleticAbilitiesE.toArray(new String[athleticAbilitiesE.size()]);
				prop.setProperty(Constants.SECTION9_ATHLETIC_ABILITY_STUDENT, athleticAbilitiesStudent);
				
				prop.save();
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				rs2.close();
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
	
	private static HashMap<String, String> processPhone(String phone){
		String phoneArray[]=phone.split("-");
		HashMap<String, String> mapPhone=new HashMap<String, String>();
		int i=1;
		for (String string : phoneArray) {
			mapPhone.put("param"+i,string);
			i++;
		}
		return mapPhone;
	}
}
