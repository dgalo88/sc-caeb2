package com.caeb2.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.caeb2.util.Constants;
import com.caeb2.util.Controller;
import com.caeb2.util.TextUtils;
import com.caeb2.util.Controller.PropFileRole;

public class LoadDataBase {

	public static boolean loadDwelling(long idDwelling) {
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
            	rs.getLong(1);
            	PropertiesConfiguration prop = Controller.getPropertiesFile(Constants.PROP_FILE_DWELLING, PropFileRole.LOAD);
        		String street =rs.getString(1);
        		String name_housing =rs.getString(2);
        		String home_phone=rs.getString(3);
        		
        		prop.setProperty(Constants.SECTION1_STREET, street);
        		prop.setProperty(Constants.SECTION1_NAME_HOUSING, name_housing);
        		prop.setProperty(Constants.SECTION1_HOME_PHONE, home_phone);
        		
        		String structure_type=TextUtils.escaparString(rs.getString(4));
        		String walls_type=TextUtils.escaparString(rs.getString(5));
        		String flat_type=TextUtils.escaparString(rs.getString(6));
        		String ceiling_type=TextUtils.escaparString(rs.getString(7));
        		String holding=TextUtils.escaparString(rs.getString(8));
        		String location_kitchen=TextUtils.escaparString(rs.getString(9));
        		String total_rooms=TextUtils.escaparString(rs.getLong(10)+"");
        		String housing_water=TextUtils.escaparString(rs.getString(11));
        		String other_housing_water = null; 
        		if(!housing_water.equals("Acueducto o tubería")&&!housing_water.equals("Camión cisterna")&&!housing_water.equals("Pila pública o estanque")){
        			other_housing_water=housing_water; 
        			housing_water="Otros medios, especifique";
        		}
        		
        		String sanitary_service=TextUtils.escaparString(rs.getString(12));
        		String electrical_service=TextUtils.escaparString(rs.getByte(13)==0 ? "No" : "Sí");
        		String garbage_collection=TextUtils.escaparString(rs.getString(14));
        		String housing_fits_household=TextUtils.escaparString(rs.getByte(15)==0 ? "No" : "Sí");
        		String house_sector=TextUtils.escaparString(rs.getString(16));
        		String housing_risk=TextUtils.escaparString(rs.getString(17));
        		String house_scalability=TextUtils.escaparString(rs.getByte(18)==0 ? "No" : "Sí");
        		
        		
        		String part_other_response = null;
        		String required_other_response = null;
        		String work_needs_other_response = null;
        		
        		rs.close();
        		String urgent_housing_improvements=TextUtils.escaparString("No");
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
                			part_other_response=TextUtils.escaparString(value);
                		}
                	}else if(type.equals("queMejorar")){
                		requiredList.add(clave);
                		if(clave.equals("Otra ¿Cuál?")){
                			required_other_response=TextUtils.escaparString(value);
                		}
                	}else if(type.equals("trabajo")){
                		workNeedsList.add(clave);
                		if(clave.equals("Otra ¿Cuál?")){
                			work_needs_other_response=TextUtils.escaparString(value);
                		}
                	}
                	urgent_housing_improvements=TextUtils.escaparString("Sí");
                }
        		
        		String part[]=TextUtils.escaparArray((String[])partList.toArray());
        		String required[]=TextUtils.escaparArray((String[])requiredList.toArray());
        		String workNeeds[]=TextUtils.escaparArray((String[])workNeedsList.toArray());

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
	
	public static boolean loadHome(long dwellingId){
		Connection connection = null;
		PreparedStatement pstmt= null;
		PreparedStatement pstmt2= null;
		ResultSet rs = null;
		try {
			
			PropertiesConfiguration prop = Controller.getPropertiesFile(Constants.PROP_FILE_HOME, PropFileRole.LOAD);
			connection = Controller.getConnection();			
			String sql = "SELECT id, numeroCuartos, numeroBanos, jefeTienePareja, dormitorioTresOMas, utilizaMercal, utilizaPdval,"
					+ " beneficioMercado, miembroParticipaOrganizacionComunitaria, viviendaId FROM hogar WHERE id=?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, dwellingId);
			rs=pstmt.executeQuery();
            if(rs.next())
            {
            	
            	String section4_rooms=TextUtils.escaparString(rs.getString("numeroCuartos"));
            	String section4_number_bathrooms=TextUtils.escaparString(rs.getString("numeroBanos"));
        		String section4_chief_couple=TextUtils.escaparString(rs.getByte("jefeTienePareja")==0 ? "No" : "Sí");
        		String section4_sleeps_3_or_more=TextUtils.escaparString(rs.getByte("dormitorioTresOMas")==0 ? "No" : "Sí");
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
    			pstmt2.setLong(1, dwellingId);
    			rs=pstmt2.executeQuery();
    			ArrayList<String> communityProblems=new ArrayList<String>();
                if(rs.next())
                {
                	String clave=rs.getString("clave");
                	String value=rs.getString("clave");
                	communityProblems.add(clave);
                	if(clave.equals("Otra ¿Cuál?")){
                		section4_community_problems_other=TextUtils.escaparString(value);
                	}
                }
                	
                String section4_community_problems[]=TextUtils.escaparArray((String[])communityProblems.toArray());
                
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
}
