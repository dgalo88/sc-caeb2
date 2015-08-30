package com.caeb2.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;

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
		PreparedStatement pstmt2= null;
		PreparedStatement pstmt3= null;
		ResultSet rs = null;
		try {
			connection = Controller.getConnection();
			String sql = "INSERT INTO vivienda (id, callePasaje, nombre, telefono, tipoEstructura, materialParedes, materialPiso, materialTecho, tenencia, ubicacionCocina, numeroCuartos, servicioAgua, servicioSanitario, servicioElectrico, servicioRecoleccionBasura, seAjustaGrupoFamiliar, tipoSector, zonaRiesgo, posibilidadAmpliacion) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pstmt.setString(11,housingData.getHousing_water());
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

			String sql2 = "INSERT INTO mejora (id, viviendaId) VALUES (NULL, ?)";
			pstmt2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			pstmt2.setLong(1, last_inserted_id);
			pstmt2.executeUpdate();
			
			rs = pstmt2.getGeneratedKeys();
			long idMejora=0;
            if(rs.next())
            {
            	idMejora = rs.getLong(1);
            }
			
			String sql3 = "INSERT INTO mejorainfo (id, tipo, clave, valor, mejoraId) VALUES (NULL,?,?,?,?)";
			pstmt3 = connection.prepareStatement(sql3);
			processMap(housingData.getPart(), pstmt3, "parte", idMejora);
			processMap(housingData.getRequired(), pstmt3, "queMejorar", idMejora);
			processMap(housingData.getWorkNeeds(), pstmt3, "trabajo", idMejora);
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
				pstmt2.close();
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
}
