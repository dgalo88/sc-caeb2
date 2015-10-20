package com.caeb2.sync;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;



public class Sincronizer {
	
	private String direccionServidor = "192.168.0.3";
	private String direccionCliente  = "192.168.0.2";
	private String nombreAdaptador   = "\"Conexión de área local\"";
	private String conexionServidor  ="jdbc:mysql://192.168.0.3/censoaeb2";
	private String conexionLocal  ="jdbc:mysql://localhost/censoaeb2";
	private String usuarioForaneo = "copy";
	private String claveUsuarioForaneo   = "12";
	private String usuarioLocal = "root";
	private String claveUsuarioLocal   = "";
	
	private String consulta_vivienda_local = "SELECT w.* FROM vivienda w";
	
	private String obtenerInsercionVivienda() { 
		
		
		return "INSERT INTO vivienda ("
											+ "callePasaje, "
											+ "nombre, "
											+ "telefono, "
											+ "tipoEstructura, "
											+ "materialParedes, "
											+ "materialPiso, "
											+ "materialTecho, "
											+ "tenencia, "
											+ "ubicacionCocina, "
											+ "numeroCuartos, "
											+ "servicioAgua, "
											+ "servicioSanitario, "
											+ "servicioElectrico, "
											+ "servicioRecoleccionBasura, "
											+ "seAjustaGrupoFamiliar, "
											+ "tipoSector,"
											+ "zonaRiesgo,"
											+ "posibilidadAmpliacion) "
											+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	
	String obtenerInsercionHogar() {
		
		
		return "INSERT INTO hogar ("
										+ "numeroCuartos, "
										+ "numeroBanos, "
										+ "jefeTienePareja, "
										+ "dormitorioTresOMas, "
										+ "utilizaMercal, "
										+ "utilizaPdval, "
										+ "beneficioMercado, "
										+ "jefeId, "
										+ "miembroParticipaOrganizacionComunitaria, "
										+ "viviendaId) "
										+ "VALUES (?,?,?,?,?,?,?,?,?,?)";		
	}
	
	String obtenerInsercionPersona() {
		
		
		return "INSERT INTO persona ("
										+ "apellidos, "
										+ "nombres, "
										+ "parentescoJefeHogar, "
										+ "sexo, "
										+ "fechaNacimiento, "
										+ "nacionalidad, "
										+ "cedula, "
										+ "pasaporte, "
										+ "correoElectronico, "
										+ "celular, "
										+ "celularOpcional, "
										+ "esAnalfabeta, "
										+ "asisteEstablecimientoEducacion, "
										+ "respEstablecimientoEducacion, "
										+ "recibeBeca, "
										+ "cursoCapacitacion, "
										+ "nivelEducativo, "
										+ "ultimoGradoAprobado, "
										+ "profesion, "
										+ "ingresoMensual, "
										+ "otrasHabilidades, "
										+ "credito, "
										+ "creditoOtros, "
										+ "seEncuentraEmbarazada, "
										+ "asisteControlMedicoParental, "
										+ "lugarAsistenciaMedica, "
										+ "razonAsistenciaMedica, "
										+ "fechaLlegada, "
										+ "hogarId) "
										+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
	}
	
	String obtenerInsercionDeporte() {
		
		
		return "INSERT INTO deporte ("
										+ "clave, "
										+ "valor, "
										+ "participacion, "
										+ "personaId) "
										+ "VALUES (?,?,?,?)";		
	}
	
	String obtenerInsercionDiscapacidad() {
		
		
		return "INSERT INTO discapacidad ("
										+ "descripcion, "
										+ "personaId) "
										+ "VALUES (?,?)";		
	}
	
	String obtenerInsercionEmpleo() {
		
		
		return "INSERT INTO empleo ("
										+ "situacion, "
										+ "oficio, "
										+ "tipo, "
										+ "tipo_seleccion, "
										+ "tipoNegocio, "
										+ "lugarTrabajo, "
										+ "personaId) "
										+ "VALUES (?,?,?,?,?,?,?)";		
	}
	
	String obtenerInsercionEncuesta() {
		
		
		return "INSERT INTO encuesta ("
										+ "fechaEntrevista, "
										+ "nombreEmpadronador, "
										+ "observaciones, "
										+ "viviendaId) "
										+ "VALUES (?,?,?,?)";		
	}

	String obtenerInsercionEnfermedadpadecida() {
		
		
		return "INSERT INTO enfermedadpadecida ("
										+ "descripcion, "
										+ "valor, "
										+ "personaId) "
										+ "VALUES (?,?,?)";		
	}
	
	String obtenerInsercionHabilidadartisticamanual() {
		
		
		return "INSERT INTO habilidadartisticamanual ("
										+ "clave, "
										+ "valor, "
										+ "participacion, "
										+ "personaId) "
										+ "VALUES (?,?,?,?)";		
	}
	
	String obtenerInsercionMejorainfo() {
		
		
		return "INSERT INTO mejorainfo ("
										+ "tipo, "
										+ "clave, "
										+ "valor, "
										+ "viviendaId) "
										+ "VALUES (?,?,?,?)";		
	}
	
	String obtenerInsercionMision() {
		
		
		return "INSERT INTO mision ("
										+ "tipo, "
										+ "mision, "
										+ "personaId) "
										+ "VALUES (?,?,?)";		
	}
	
	String obtenerInsercionPrincipalesproblemascomunidad() {
		
		
		return "INSERT INTO principalesproblemascomunidad ("
										+ "descripcion, "
										+ "valor, "
										+ "hogarId) "
										+ "VALUES (?,?,?)";		
	}
	
	String obtenerInsercionSistemaprevencionsocial() {
		
		
		return "INSERT INTO sistemaprevencionsocial ("
										+ "descripcion, "
										+ "personaId) "
										+ "VALUES (?,?)";		
	}
	
	String obtenerInsercionVacuna() {
		
		
		return "INSERT INTO vacuna ("
										+ "nombre, "
										+ "numeroDosis, "
										+ "personaId) "
										+ "VALUES (?,?,?)";		
	}
	
	String obtenerInsercionAparatomedico() {
		
		
		return "INSERT INTO aparatomedico ("
										+ "nombre, "
										+ "descripcion, "
										+ "loTiene, "
										+ "personaId) "
										+ "VALUES (?,?,?,?)";		
	}
	
		void copiarTablaDeporte(long idLocal, long idForaneo) {
		
		String consulta_deporte_local = "SELECT w.* FROM deporte w WHERE w.personaId=" + idLocal;

		Connection conexionDeporteLocal = null;
		
		Statement declaracionDeporteLocal = null;
		
		ResultSet consultaDeporteLocal = null;
		try {
			
			conexionDeporteLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionDeporteLocal = conexionDeporteLocal.createStatement();
			
			consultaDeporteLocal = declaracionDeporteLocal.executeQuery(consulta_deporte_local);
			
			while(consultaDeporteLocal.next()) {
				
				String comandoInsercionDeporte = obtenerInsercionDeporte();
				
				Connection conexionDeporteForanea = null;
				
				PreparedStatement st = null;
			    
				try {
					conexionDeporteForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					st = (PreparedStatement) conexionDeporteForanea.prepareStatement(comandoInsercionDeporte);
					st.setString(1, consultaDeporteLocal.getString(2));
				    st.setString(2, consultaDeporteLocal.getString(3));
				    st.setString(3, consultaDeporteLocal.getString(4));
				    st.setLong(4, idForaneo);
				    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
						conexionDeporteForanea.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conexionDeporteLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaDeporteLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				declaracionDeporteLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
		
		void copiarTablaDiscapacidad(long idLocal, long idForaneo) {
			
		String consulta_discapacidad_local = "SELECT w.* FROM discapacidad w WHERE w.personaId=" + idLocal;
		
		Connection conexionDiscapacidadLocal =null;
		
		Statement declaracionDiscapacidadLocal = null;
		
		ResultSet consultaDiscapacidadLocal = null;
		
				
		try {
			
			conexionDiscapacidadLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionDiscapacidadLocal = conexionDiscapacidadLocal.createStatement();
			
			consultaDiscapacidadLocal = declaracionDiscapacidadLocal.executeQuery(consulta_discapacidad_local);
			
			while(consultaDiscapacidadLocal.next()) {
			
				String comandoInsercionDiscapacidad = obtenerInsercionDiscapacidad();
				Connection conexionDiscapacidadForanea = null;
				PreparedStatement st = null;
				try {
					conexionDiscapacidadForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					st = (PreparedStatement) conexionDiscapacidadForanea.prepareStatement(comandoInsercionDiscapacidad);
				    st.setString(1, consultaDiscapacidadLocal.getString(2));
				    st.setLong(2, idForaneo);
				    st.executeUpdate();
				    st.close();
				    conexionDiscapacidadForanea.close();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
						conexionDiscapacidadForanea.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conexionDiscapacidadLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				declaracionDiscapacidadLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaDiscapacidadLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		void copiarTablaEmpleo(long idLocal, long idForaneo) {
			
		String consulta_empleo_local = "SELECT w.* FROM empleo w WHERE w.personaId=" + idLocal;
		
		Connection conexionEmpleoLocal = null;
		
		Statement declaracionEmpleoLocal = null;
		
		ResultSet consultaEmpleoLocal = null;
				
		try {
			
			conexionEmpleoLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionEmpleoLocal = conexionEmpleoLocal.createStatement();
			
			consultaEmpleoLocal = declaracionEmpleoLocal.executeQuery(consulta_empleo_local);
			
			while(consultaEmpleoLocal.next()) {
				
				String comandoInsercionEmpleo = obtenerInsercionEmpleo();
				Connection conexionEmpleoForanea = null;
				
				PreparedStatement st = null;
				try {
					conexionEmpleoForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					st = (PreparedStatement) conexionEmpleoForanea.prepareStatement(comandoInsercionEmpleo);
				    st.setString(1, consultaEmpleoLocal.getString(2));
				    st.setString(2, consultaEmpleoLocal.getString(3));
				    st.setString(3, consultaEmpleoLocal.getString(4));
				    st.setString(4, consultaEmpleoLocal.getString(5));
				    st.setString(5, consultaEmpleoLocal.getString(6));
				    st.setString(6, consultaEmpleoLocal.getString(7));
				    st.setLong(7, idForaneo);
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
						 st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionEmpleoForanea.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionEmpleoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionEmpleoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaEmpleoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
	
		void copiarTablaEncuesta(long idLocal, long idForaneo) {
			
		String consulta_encuesta_local = "SELECT w.* FROM encuesta w WHERE w.viviendaId=" + idLocal;
		
		Connection conexionEncuestaLocal = null;
		
		Statement declaracionEncuestaLocal = null;
		
		ResultSet consultaEncuestaLocal = null;
				
		try {
			
			conexionEncuestaLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionEncuestaLocal = conexionEncuestaLocal.createStatement();
			
			consultaEncuestaLocal = declaracionEncuestaLocal.executeQuery(consulta_encuesta_local);
			
			while(consultaEncuestaLocal.next()) {
			
				
				String comandoInsercionEncuesta = obtenerInsercionEncuesta();
				Connection conexionEncuestaForanea = null;
				
				PreparedStatement st = null;
				
				try {
					 conexionEncuestaForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					 st = (PreparedStatement) conexionEncuestaForanea.prepareStatement(comandoInsercionEncuesta);
					 st.setDate(1, consultaEncuestaLocal.getDate(2));
					 st.setString(2, consultaEncuestaLocal.getString(3));
					 st.setString(3, consultaEncuestaLocal.getString(4));
					 st.setLong(4, idForaneo);
					 st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionEncuestaForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}   
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionEncuestaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaEncuestaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionEncuestaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		void copiarTablaEnfermedadpadecida(long idLocal, long idForaneo) {
			
		String consulta_enfermedadpadecida_local = "SELECT w.* FROM enfermedadpadecida w WHERE w.personaId=" + idLocal;
		
		Connection conexionEnfermedadpadecidaLocal = null;
		
		Statement declaracionEnfermedadpadecidaLocal = null;
		
		ResultSet consultaEnfermedadpadecidaLocal = null;		
		try {
			
			conexionEnfermedadpadecidaLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionEnfermedadpadecidaLocal = conexionEnfermedadpadecidaLocal.createStatement();
			
			consultaEnfermedadpadecidaLocal = declaracionEnfermedadpadecidaLocal.executeQuery(consulta_enfermedadpadecida_local);
			
			while(consultaEnfermedadpadecidaLocal.next()) {
	
				
				String comandoInsercionEnfermedadpadecida = obtenerInsercionEnfermedadpadecida();
				Connection conexionEnfermedadpadecidaForanea = null;
				
				PreparedStatement st =null;
				try {
					conexionEnfermedadpadecidaForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					st = (PreparedStatement) conexionEnfermedadpadecidaForanea.prepareStatement(comandoInsercionEnfermedadpadecida);
					st.setString(1, consultaEnfermedadpadecidaLocal.getString(2));
					st.setString(2, consultaEnfermedadpadecidaLocal.getString(3));
					st.setLong(3, idForaneo);
					st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionEnfermedadpadecidaForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} 
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionEnfermedadpadecidaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionEnfermedadpadecidaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaEnfermedadpadecidaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		
		void copiarTablaHabilidadartisticamanual(long idLocal, long idForaneo) {
			
		String consulta_Habilidadartisticamanual_local = "SELECT w.* FROM Habilidadartisticamanual w WHERE w.personaId=" + idLocal;
		
		Connection conexionHabilidadartisticamanualLocal = null;
		
		Statement declaracionHabilidadartisticamanualLocal = null;
		
		ResultSet consultaHabilidadartisticamanualLocal = null;
				
		try {
			
			conexionHabilidadartisticamanualLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionHabilidadartisticamanualLocal = conexionHabilidadartisticamanualLocal.createStatement();
			
			consultaHabilidadartisticamanualLocal = declaracionHabilidadartisticamanualLocal.executeQuery(consulta_Habilidadartisticamanual_local);
			
			while(consultaHabilidadartisticamanualLocal.next()) {
				
				String comandoInsercionHabilidadartisticamanual = obtenerInsercionHabilidadartisticamanual();
			    Connection conexionHabilidadartisticamanualForanea = null;
				
				PreparedStatement st = null;
				try {
					 	conexionHabilidadartisticamanualForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
						
						st = (PreparedStatement) conexionHabilidadartisticamanualForanea.prepareStatement(comandoInsercionHabilidadartisticamanual);
					    st.setString(1, consultaHabilidadartisticamanualLocal.getString(2));
					    st.setString(2, consultaHabilidadartisticamanualLocal.getString(3));
					    st.setString(3, consultaHabilidadartisticamanualLocal.getString(4));
					    st.setLong(4, idForaneo);
					    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionHabilidadartisticamanualForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} 				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionHabilidadartisticamanualLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionHabilidadartisticamanualLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaHabilidadartisticamanualLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		void copiarTablaMejorainfo(long idLocal, long idForaneo) {
			
		String consulta_Mejorainfo_local = "SELECT w.* FROM mejorainfo w WHERE w.viviendaId=" + idLocal;
		
		Connection conexionMejorainfoLocal = null;
		
		Statement declaracionMejorainfoLocal = null;
		
		ResultSet consultaMejorainfoLocal = null;
				
		try {
			
			conexionMejorainfoLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionMejorainfoLocal = conexionMejorainfoLocal.createStatement();
			
			consultaMejorainfoLocal = declaracionMejorainfoLocal.executeQuery(consulta_Mejorainfo_local);
			
			while(consultaMejorainfoLocal.next()) {
				
				String comandoInsercionMejorainfo = obtenerInsercionMejorainfo();
				
				Connection conexionMejorainfoForanea = null;
				
				PreparedStatement st = null;
				
				try {

				    conexionMejorainfoForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					
					st = (PreparedStatement) conexionMejorainfoForanea.prepareStatement(comandoInsercionMejorainfo);
				    st.setString(1, consultaMejorainfoLocal.getString(2));
				    st.setString(2, consultaMejorainfoLocal.getString(3));
				    st.setString(3, consultaMejorainfoLocal.getString(4));
				    st.setLong(4, idForaneo);

				    // execute the preparedstatement insert
				    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionMejorainfoForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionMejorainfoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionMejorainfoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaMejorainfoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		void copiarTablaMision(long idLocal, long idForaneo) {
			
		String consulta_Mision_local = "SELECT w.* FROM mision w WHERE w.personaId=" + idLocal;
		
		Connection conexionMisionLocal = null;
		
		Statement declaracionMisionLocal = null;
		
		ResultSet consultaMisionLocal = null;
				
		try {
			
			conexionMisionLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionMisionLocal = conexionMisionLocal.createStatement();
			
			consultaMisionLocal = declaracionMisionLocal.executeQuery(consulta_Mision_local);
			
			while(consultaMisionLocal.next()) {

				String comandoInsercionMision = obtenerInsercionMision();
				Connection conexionMisionForanea = null;
				
				PreparedStatement st = null;
				try {
					conexionMisionForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					
					st = (PreparedStatement) conexionMisionForanea.prepareStatement(comandoInsercionMision);
				    st.setString(1, consultaMisionLocal.getString(2));
				    st.setString(2, consultaMisionLocal.getString(3));
				    st.setLong(3, idForaneo);

				    // execute the preparedstatement insert
				    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionMisionForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionMisionLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionMisionLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaMisionLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

				
	}
		
		void copiarTablaPrincipalesproblemascomunidad(long idLocal, long idForaneo) {
			
		String consulta_principalesproblemascomunidad_local = "SELECT w.* FROM principalesproblemascomunidad w WHERE w.hogarId=" + idLocal;
		
		Connection conexionPrincipalesproblemascomunidadLocal = null;
		
		Statement declaracionPrincipalesproblemascomunidadLocal = null;
		
		ResultSet consultaPrincipalesproblemascomunidadLocal = null;
		
		try {
			
			conexionPrincipalesproblemascomunidadLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionPrincipalesproblemascomunidadLocal = conexionPrincipalesproblemascomunidadLocal.createStatement();
			
			consultaPrincipalesproblemascomunidadLocal = declaracionPrincipalesproblemascomunidadLocal.executeQuery(consulta_principalesproblemascomunidad_local);
			
			while(consultaPrincipalesproblemascomunidadLocal.next()) {
				
				String comandoInsercionPrincipalesproblemascomunidad = obtenerInsercionPrincipalesproblemascomunidad();
				
				Connection conexionPrincipalesproblemascomunidadForanea = null;
					
				PreparedStatement st = null;
					
				try {
					conexionPrincipalesproblemascomunidadForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					
					st = (PreparedStatement) conexionPrincipalesproblemascomunidadForanea.prepareStatement(comandoInsercionPrincipalesproblemascomunidad);
				    st.setString(1, consultaPrincipalesproblemascomunidadLocal.getString(2));
				    st.setString(2, consultaPrincipalesproblemascomunidadLocal.getString(3));
				    st.setLong(3, idForaneo);

				    // execute the preparedstatement insert
				    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionPrincipalesproblemascomunidadForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionPrincipalesproblemascomunidadLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionPrincipalesproblemascomunidadLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaPrincipalesproblemascomunidadLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		void copiarTablaSistemaprevencionsocial(long idLocal, long idForaneo) {
			
		String consulta_sistemaprevencionsocial_local = "SELECT w.* FROM sistemaprevencionsocial w WHERE w.personaId=" + idLocal;
		
		Connection conexionSistemaprevencionsocialLocal = null;
		
		Statement declaracionSistemaprevencionsocialLocal = null;
		
		ResultSet consultaSistemaprevencionsocialLocal = null;
				
		try {
			
			conexionSistemaprevencionsocialLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionSistemaprevencionsocialLocal = conexionSistemaprevencionsocialLocal.createStatement();
			
			consultaSistemaprevencionsocialLocal = declaracionSistemaprevencionsocialLocal.executeQuery(consulta_sistemaprevencionsocial_local);
			
			while(consultaSistemaprevencionsocialLocal.next()) {
				
				String comandoInsercionSistemaprevencionsocial = obtenerInsercionSistemaprevencionsocial();
				
				Connection conexionSistemaprevencionsocialForanea = null;
					
				PreparedStatement st = null;
				
				try {
					conexionSistemaprevencionsocialForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					st = (PreparedStatement) conexionSistemaprevencionsocialForanea.prepareStatement(comandoInsercionSistemaprevencionsocial);
				    st.setString(1, consultaSistemaprevencionsocialLocal.getString(2));
				    st.setLong(2, idForaneo);
				    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionSistemaprevencionsocialForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionSistemaprevencionsocialLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionSistemaprevencionsocialLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaSistemaprevencionsocialLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		void copiarTablaVacuna(long idLocal, long idForaneo) {
			
		String consulta_vacuna_local = "SELECT w.* FROM vacuna w WHERE w.personaId=" + idLocal;
		
		Connection conexionVacunaLocal = null;
		
		Statement declaracionVacunaLocal = null;
		
		ResultSet consultaVacunaLocal = null;
				
		try {
			
			conexionVacunaLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionVacunaLocal = conexionVacunaLocal.createStatement();
			
			consultaVacunaLocal = declaracionVacunaLocal.executeQuery(consulta_vacuna_local);
			
			while(consultaVacunaLocal.next()) {
				
				String comandoInsercionVacuna = obtenerInsercionVacuna();
				
				Connection conexionVacunaForanea = null;
				
				PreparedStatement st = null;
				
				try {
					conexionVacunaForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					
					st = (PreparedStatement) conexionVacunaForanea.prepareStatement(comandoInsercionVacuna);
				    st.setString(1, consultaVacunaLocal.getString(2));
				    st.setLong(2, consultaVacunaLocal.getLong(3));
				    st.setLong(3, idForaneo);
				    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionVacunaForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionVacunaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionVacunaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaVacunaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}
		
		void copiarTablaAparatomedico(long idLocal, long idForaneo) {
			
		String consulta_aparatomedico_local = "SELECT w.* FROM aparatomedico w WHERE w.personaId=" + idLocal;
		
		Connection conexionAparatomedicoLocal = null;
		
		Statement declaracionAparatomedicoLocal = null;
		
		ResultSet consultaAparatomedicoLocal = null;
				
		try {
			
			conexionAparatomedicoLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionAparatomedicoLocal = conexionAparatomedicoLocal.createStatement();
			
		consultaAparatomedicoLocal = declaracionAparatomedicoLocal.executeQuery(consulta_aparatomedico_local);
			
			while(consultaAparatomedicoLocal.next()) {
				
				String comandoInsercionAparatomedico = obtenerInsercionAparatomedico();
				
				Connection conexionAparatomedicoForanea = null;
				
				PreparedStatement st = null;
				
				try {
					conexionAparatomedicoForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					
					st = (PreparedStatement) conexionAparatomedicoForanea.prepareStatement(comandoInsercionAparatomedico);
				    st.setString(1, consultaAparatomedicoLocal.getString(2));
				    st.setString(2, consultaAparatomedicoLocal.getString(3));
				    st.setBoolean(3, consultaAparatomedicoLocal.getBoolean(4));
				    st.setLong(4, idForaneo);

				    // execute the preparedstatement insert
				    st.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionAparatomedicoForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionAparatomedicoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionAparatomedicoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaAparatomedicoLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

				
	}
		
	void copiarTablaPersona(long idLocal, long idForaneo) {
		
		String consulta_persona_local = "SELECT w.* FROM persona w WHERE w.hogarId=" + idLocal;
		
		Connection conexionPersonaLocal = null;
		
		Statement declaracionPersonaLocal = null;
		
		ResultSet consultaPersonaLocal = null;
		
		try {
			
			conexionPersonaLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionPersonaLocal = conexionPersonaLocal.createStatement();
			
			consultaPersonaLocal = declaracionPersonaLocal.executeQuery(consulta_persona_local);
			
			while(consultaPersonaLocal.next()) {
				
				long idPersonaForaneo;
				long idPersonaLocal;

				String comandoInsercionPersona = obtenerInsercionPersona();
				Connection conexionPersonaForanea = null;
					
				PreparedStatement st = null;
					
				try {
						conexionPersonaForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
						
						st = (PreparedStatement) conexionPersonaForanea.prepareStatement(comandoInsercionPersona);
					    st.setString(1, consultaPersonaLocal.getString(2));
					    st.setString(2, consultaPersonaLocal.getString(3));
					    st.setString(3, consultaPersonaLocal.getString(4));
					    st.setCharacterStream(4, consultaPersonaLocal.getCharacterStream(5));
					    st.setDate(5, consultaPersonaLocal.getDate(6));
					    st.setString(6, consultaPersonaLocal.getString(7));
					    st.setString(7, consultaPersonaLocal.getString(8));
					    st.setString(8, consultaPersonaLocal.getString(9));
					    st.setString(9, consultaPersonaLocal.getString(10));
					    st.setString(10, consultaPersonaLocal.getString(11));
					    st.setString(11, consultaPersonaLocal.getString(12));
					    st.setBoolean(12, consultaPersonaLocal.getBoolean(13));
					    st.setBoolean(13, consultaPersonaLocal.getBoolean(14));
					    st.setString(14, consultaPersonaLocal.getString(15));
					    st.setString(15, consultaPersonaLocal.getString(16));
					    st.setString(16, consultaPersonaLocal.getString(17));
					    st.setString(17, consultaPersonaLocal.getString(18));
					    st.setLong(18, consultaPersonaLocal.getLong(19));
					    st.setString(19, consultaPersonaLocal.getString(20));
					    st.setString(20, consultaPersonaLocal.getString(21));
					    st.setString(21, consultaPersonaLocal.getString(22));
					    st.setString(22, consultaPersonaLocal.getString(23));
					    st.setString(23, consultaPersonaLocal.getString(24));
					    st.setBoolean(24, consultaPersonaLocal.getBoolean(25));
					    st.setBoolean(25, consultaPersonaLocal.getBoolean(26));
					    st.setString(26, consultaPersonaLocal.getString(27));
					    st.setString(27, consultaPersonaLocal.getString(28));
					    st.setDate(28, consultaPersonaLocal.getDate(29));
					    st.setLong(29, idForaneo);

					    // execute the preparedstatement insert
					    st.executeUpdate();
//					    st.close();
					    
						String consulta_persona_foranea = "SELECT t.id FROM persona t WHERE t.cedula='" + consultaPersonaLocal.getString(8) + "'";
						
						Statement declaracionPersonaForanea = null;
						
						ResultSet consultaPersonaForanea = null;
						
						try {
							declaracionPersonaForanea = conexionPersonaForanea.createStatement();
							
							consultaPersonaForanea = declaracionPersonaForanea.executeQuery(consulta_persona_foranea);
							
							consultaPersonaForanea.next();
							
							idPersonaForaneo = consultaPersonaForanea.getLong(1);
							
							idPersonaLocal = consultaPersonaLocal.getLong(1);
							
							declaracionPersonaForanea.close();
							conexionPersonaForanea.close();
							consultaPersonaForanea.close();
							
							copiarTablaDeporte(idPersonaLocal, idPersonaForaneo);
							copiarTablaDiscapacidad(idPersonaLocal, idPersonaForaneo);
							copiarTablaEmpleo(idPersonaLocal, idPersonaForaneo);
							copiarTablaEnfermedadpadecida(idPersonaLocal, idPersonaForaneo);
							copiarTablaHabilidadartisticamanual(idPersonaLocal, idPersonaForaneo);
							copiarTablaVacuna(idPersonaLocal, idPersonaForaneo);
							copiarTablaSistemaprevencionsocial(idPersonaLocal, idPersonaForaneo);
							copiarTablaMision(idPersonaLocal, idPersonaForaneo);
							copiarTablaAparatomedico(idPersonaLocal, idPersonaForaneo);
						} catch (Exception e) {
							// TODO: handle exception
						}finally{
							try {
								declaracionPersonaForanea.close();
							} catch (Exception e2) {
								// TODO: handle exception
							}
							try {
								consultaPersonaForanea.close();
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					    
						
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionPersonaForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				declaracionPersonaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionPersonaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaPersonaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	void copiarTablaHogar(long idLocal, long idForaneo) throws SQLException {
		
		
		String consulta_hogar_local = "SELECT w.* FROM hogar w WHERE w.viviendaId=" + idLocal;
		
		
		Connection conexionHogarLocal = null;
//		
		Statement declaracionHogarLocal = null;
		
		ResultSet consultaHogarLocal = null;
		
		try {
			conexionHogarLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
//			
			declaracionHogarLocal = conexionHogarLocal.createStatement();
			
			consultaHogarLocal = declaracionHogarLocal.executeQuery(consulta_hogar_local);
			
			while(consultaHogarLocal.next()) {
				
				long idHogarLocal;
				long idHogarForaneo;
				
				String comandoInsercionHogar = obtenerInsercionHogar();
				
				Connection conexionHogarForanea =null;
					
				PreparedStatement st = null;
				
				try {
					conexionHogarForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
					
					st = (PreparedStatement) conexionHogarForanea.prepareStatement(comandoInsercionHogar);
					
					st.setInt(1, consultaHogarLocal.getInt(2));
				    st.setInt(2, consultaHogarLocal.getInt(3));
				    st.setBoolean(3, consultaHogarLocal.getBoolean(4));
				    st.setBoolean(4, consultaHogarLocal.getBoolean(5));
				    st.setString(5, consultaHogarLocal.getString(6));
				    st.setString(6, consultaHogarLocal.getString(7));
				    st.setString(7, consultaHogarLocal.getString(8));
				    st.setString(8, consultaHogarLocal.getString(9));
				    st.setString(9, consultaHogarLocal.getString(10));
				    st.setLong(10, idForaneo);
				    st.executeUpdate();

					String consulta_hogar_foranea = "SELECT t.id FROM hogar t WHERE t.jefeId='" + consultaHogarLocal.getString(9) + "'";
					
					Statement declaracionHogarForanea = null;
					
					ResultSet consultaHogarForanea = null;
					
					try {
						declaracionHogarForanea = conexionHogarForanea.createStatement();
						
						consultaHogarForanea = declaracionHogarForanea.executeQuery(consulta_hogar_foranea);
						
						consultaHogarForanea.next();
						
						idHogarForaneo = consultaHogarForanea.getLong(1);
						
						idHogarLocal = consultaHogarLocal.getLong(1);
						
						copiarTablaPersona(idHogarLocal, idHogarForaneo);
						copiarTablaPrincipalesproblemascomunidad(idHogarLocal, idHogarForaneo);
					} catch (Exception e) {
						// TODO: handle exception
					}finally{
						try {
							declaracionHogarForanea.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
						try {
							consultaHogarForanea.close();
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}

				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionHogarForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				declaracionHogarLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionHogarLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaHogarLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	
	boolean copiarTablaVivienda() throws SQLException {
		
		Connection conexionViviendaLocal = null;
		
		Statement declaracionLocal = null;
		
		ResultSet consultaLocal = null;
		
		try {
			conexionViviendaLocal = (Connection) DriverManager.getConnection(conexionLocal, usuarioLocal, claveUsuarioLocal);
			
			declaracionLocal = conexionViviendaLocal.createStatement();
			
			consultaLocal = declaracionLocal.executeQuery(consulta_vivienda_local);
			
			while(consultaLocal.next()) {
				
				long idViviendaLocal;
				long idViviendaForaneo;
				
				String comandoInsercionVivienda = obtenerInsercionVivienda();
				
				Connection conexionForanea = null;
				
				PreparedStatement st = null;
				
				try {
					 	conexionForanea = (Connection) DriverManager.getConnection(conexionServidor, usuarioForaneo, claveUsuarioForaneo);
						
						st = (PreparedStatement) conexionForanea.prepareStatement(comandoInsercionVivienda);
						
						st.setString(1, consultaLocal.getString(2));
					    st.setString(2, consultaLocal.getString(3));
					    st.setString(3, consultaLocal.getString(4));
					    st.setString(4, consultaLocal.getString(5));
					    st.setString(5, consultaLocal.getString(6));
					    st.setString(6, consultaLocal.getString(7));
					    st.setString(7, consultaLocal.getString(8));
					    st.setString(8, consultaLocal.getString(9));
					    st.setString(9, consultaLocal.getString(10));
					    st.setLong(10, consultaLocal.getLong(11));
					    st.setString(11, consultaLocal.getString(12));
					    st.setString(12, consultaLocal.getString(13));
					    st.setBoolean(13, consultaLocal.getBoolean(14));
					    st.setString(14, consultaLocal.getString(15));
					    st.setBoolean(15, consultaLocal.getBoolean(16));
					    st.setString(16, consultaLocal.getString(17));
					    st.setString(17, consultaLocal.getString(18));
					    st.setBoolean(18, consultaLocal.getBoolean(19));
					    st.executeUpdate();

						String consulta_vivienda_foranea = "SELECT t.id FROM vivienda t WHERE t.nombre='" + consultaLocal.getString(3) + "'";
						
						Statement declaracionForanea = null;
						
						ResultSet consultaForanea = null;
						
						try {
							declaracionForanea = conexionForanea.createStatement();
							
							consultaForanea = declaracionForanea.executeQuery(consulta_vivienda_foranea);
							
							consultaForanea.next();
							
							idViviendaForaneo = consultaForanea.getLong(1);
							
							idViviendaLocal = consultaLocal.getLong(1);
							
							copiarTablaHogar(idViviendaLocal, idViviendaForaneo);
							copiarTablaEncuesta(idViviendaLocal, idViviendaForaneo);
							copiarTablaMejorainfo(idViviendaLocal, idViviendaForaneo);
						} catch (Exception e) {
							// TODO: handle exception
						}finally{
							try {
								declaracionForanea.close();
							} catch (Exception e2) {
								// TODO: handle exception
							}
							try {
								consultaForanea.close();
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					try {
					    st.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						conexionForanea.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				declaracionLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				conexionViviendaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				consultaLocal.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}


	public boolean enviarDatos() throws SQLException {
		
		return copiarTablaVivienda();
		
	}
	
	public boolean prepararConexionServidor() {
		
		try {
	    // Execute a command without arguments
	    String command = "netsh interface ip set address " + nombreAdaptador + " static " + direccionServidor + " 255.255.255.0 192.168.0.1 1";
	    System.out.println(command);
	    Runtime.getRuntime().exec(command);
	    return true;
	} catch (IOException e) {
		return false;
	}
		
	}
	
	public boolean prepararConexionCliente() {
		
		try {
	    // Execute a command without arguments
	    String command = "netsh interface ip set address " + nombreAdaptador + " static " + direccionCliente + " 255.255.255.0 192.168.0.1 1";
	    Runtime.getRuntime().exec(command);
	    return true;
	} catch (IOException e) {
		return false;
	}
		
	}
	
	public void reestablecerAdactador() {
		
		try {
	    // Execute a command without arguments
	    String command = "netsh interface ip set address " + nombreAdaptador + " dhcp";
	    Runtime.getRuntime().exec(command);
	} catch (IOException e) {
	}
		
	}
	
	public static void main(String args[]) throws SQLException {
		
		Sincronizer sc =new Sincronizer();

		sc.enviarDatos();
		
	}
	public String getDireccionServidor(){
		return direccionServidor;
	}


}