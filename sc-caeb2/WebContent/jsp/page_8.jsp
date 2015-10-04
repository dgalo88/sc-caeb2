<%@page import="com.caeb2.actions.bean.MedicalData"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(8);
	Parameters.setTitle("Secci�n 5: Caracter�sticas individuales");
	MedicalData medicalData=new MedicalData(request.getRequestedSessionId());
%>

<%@include file="validateCurrentPage.jsp"%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
<%-- 	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"> --%>
<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveProcessPage8" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="tiene_ADLSDPOD">Tiene alguna de las siguientes deficiencias, problemas o discapacidades: </label>
							<table class="table table-control">
								<tr>
									<td class="td-left-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox" value="Ninguna" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("Ninguna")) ? "checked": ""%>>Ninguna</label><br>
												<label><input type="checkbox" value="Ceguera total" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("Ceguera total")) ? "checked": ""%>>Ceguera total</label><br>
												<label><input type="checkbox" value="Dificultad para ver" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("Dificultad para ver")) ? "checked": ""%>>Dificultad para ver</label><br>
												<label><input type="checkbox" value="Sordera total" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("Sordera total")) ? "checked": ""%>>Sordera total</label>
											</div>
										</div>
									</td>
									<td class="td-center-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox" value="Dificulta para o�r" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("Dificulta para o�r")) ? "checked": ""%>>Dificulta para o�r</label><br>
												<label><input type="checkbox" value="Dificultad para hablar" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("Dificultad para hablar")) ? "checked": ""%>>Dificultad para hablar</label><br>
												<label><input type="checkbox" value="Retardo mental" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("Retardo mental")) ? "checked": ""%>>Retardo mental</label>
											</div>
										</div>
									</td>
									<td class="td-right-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox" value="P�rdida de capacidad mental" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("P�rdida de capacidad mental")) ? "checked": ""%>>P�rdida de capacidad mental</label><br>
												<label><input type="checkbox" value="P�rdida o discapacidad de extremidades superiores" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("P�rdida o discapacidad de extremidades superiores")) ? "checked": ""%>>P�rdida o discapacidad de extremidades superiores</label><br>
												<label><input type="checkbox" value="P�rdida o discapacidad de extremidades inferiores" name="<%=Constants.SECTION8_DISABILITIES%>" <%= (medicalData.getDisabilities().containsKey("P�rdida o discapacidad de extremidades inferiores")) ? "checked": ""%>>P�rdida o discapacidad de extremidades inferiores</label>
											</div>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="cuando_RAMAQLA">�Cu�ndo requiere asistencia m�dica a qu� lugar asiste?</label> 
							<select class="form-control" name="<%=Constants.SECTION8_MEDICAL_ASSISTANCE%>" id="cuando_RAMAQLA_select">
								<option value="Ninguno" <%= medicalData.getMedical_assistance().equals("Ninguna") ? "selected": ""%>>Ninguno</option>
								<option value="Ambulatorio" <%= medicalData.getMedical_assistance().equals("Ambulatorio") ? "selected": ""%>>Ambulatorio</option>
								<option value="Hospital p�blico" <%= medicalData.getMedical_assistance().equals("Hospital p�blico") ? "selected": ""%>>Hospital p�blico</option>
								<option value="Hospital del seguro social" <%= medicalData.getMedical_assistance().equals("Hospital del seguro social") ? "selected": ""%>>Hospital del seguro social</option>
								<option value="Cl�nica o consultorio privado" <%= medicalData.getMedical_assistance().equals("Cl�nica o consultorio privado") ? "selected": ""%>>Cl�nica o consultorio privado</option>
								<option value="Servicio m�dico del trabajo" <%= medicalData.getMedical_assistance().equals("Servicio m�dico del trabajo") ? "selected": ""%>>Servicio m�dico del trabajo</option>
								<option value="Servicio m�dico Barrio Adentro I" <%= medicalData.getMedical_assistance().equals("Servicio m�dico Barrio Adentro I") ? "selected": ""%>>Servicio m�dico Barrio Adentro I</option>
								<option value="Servicio m�dico Barrio Adentro II" <%= medicalData.getMedical_assistance().equals("Servicio m�dico Barrio Adentro II") ? "selected": ""%>>Servicio m�dico Barrio Adentro II</option>
							</select>
						</div>
						<div class="form-group" <%=medicalData.getMedical_assistance_has().equals("") ? "style=\"display: none\"": ""%> id="porque_RAAEEDS_div">
							<label for="porque_RAAEEDS">�Por qu� raz�n acude a ese establecimiento de salud?</label> 
							<select class="form-control" name="<%=Constants.SECTION8_MEDICAL_ASSISTANCE_HAS%>" id="porque_RAAEEDS_select">
								<option value="Bajos recursos econ�micos" <%= medicalData.getMedical_assistance_has().equals("Bajos recursos econ�micos") ? "selected": ""%>>Bajos recursos econ�micos </option>
								<option value="Los servicios son econ�micos" <%= medicalData.getMedical_assistance_has().equals("Los servicios son econ�micos") ? "selected": ""%>>Los servicios son econ�micos</option>
								<option value="Es el �nico establecimiento que presta el servicio" <%= medicalData.getMedical_assistance_has().equals("Es el �nico establecimiento que presta el servicio") ? "selected": ""%>>Es el �nico establecimiento que presta el servicio</option>
								<option value="Esta cerca del lugar de residencia" <%= medicalData.getMedical_assistance_has().equals("Esta cerca del lugar de residencia") ? "selected": ""%>>Esta cerca del lugar de residencia</option>
							</select>
						</div>
						<div class="form-group">
							<label for="requiere_UDAOEM">�Requiere uso de aparatos o equipos m�dicos?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION8_MEDICAL_EQUIPMENT_REQUIRED%>" id="requiere_UDAOEM_si" <%=(medicalData.getMedical_equipment_required().equals("S�")) ? "checked": ""%> value="S�">S�</label>
								<label><input type="radio" name="<%=Constants.SECTION8_MEDICAL_EQUIPMENT_REQUIRED%>" id="requiere_UDAOEM_no" <%=(medicalData.getMedical_equipment_required().equals("No")||medicalData.getMedical_equipment_required().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
							<div class="form-group" id="requiere_UDAOEM_div" <%=!medicalData.getMedical_equipment_required().equals("S�") ? "style=\"display: none\"": ""%>>
								<table class="table table-control">
									<tr>
										<td class="td-left-control">
											<div class="form-group">
												<label for="requiere_UDAOEM_cual">�Cu�l?</label> 
												<select class="form-control" name="<%=Constants.SECTION8_MEDICAL_EQUIPMENT_WHICH%>" id="requiere_UDAOEM_cual_select">
													<option value="Andadera" <%= medicalData.getMedical_equipment_which().equals("Andadera") ? "selected": ""%>>Andadera</option>
													<option value="Muletas" <%= medicalData.getMedical_equipment_which().equals("Muletas") ? "selected": ""%>>Muletas</option>
													<option value="Bast�n" <%= medicalData.getMedical_equipment_which().equals("Bast�n") ? "selected": ""%>>Bast�n</option>
													<option value="Silla de ruedas" <%= medicalData.getMedical_equipment_which().equals("Silla de ruedas") ? "selected": ""%>>Silla de ruedas</option>
													<option value="Pr�tesis" <%= medicalData.getMedical_equipment_which().equals("Pr�tesis") ? "selected": ""%>>Pr�tesis</option>
													<option value="Bombona de oxigeno" <%= medicalData.getMedical_equipment_which().equals("Bombona de oxigeno") ? "selected": ""%>>Bombona de oxigeno</option>
													<option value="Otro �Cu�l?" <%= medicalData.getMedical_equipment_which().equals("Otro �Cu�l?") ? "selected": ""%>>Otro �Cu�l?</option>
												</select>
											</div>
											<div class="form-group">
												<div class="radio">
													<input type="text" class="form-control" id="requiere_UDAOEM_cual_text" name="<%=Constants.SECTION8_MEDICAL_EQUIPMENT_OTHER%>" placeholder="�Cu�l?" <%=medicalData.getMedical_equipment_other().equals("") ? "style=\"display: none\"": ""%> value="<%=medicalData.getMedical_equipment_other()%>">
												</div>
											</div>
										</td>
										<td class="td-right-control">
											<div class="form-group">
												<label for="requiere_UDAOEM_TEAOEQR">�Tiene el aparato o equipo que requiere?</label> 
												<div class="radio">
													<label><input type="radio" name="<%=Constants.SECTION8_MEDICAL_EQUIPMENT_HAS%>" id="requiere_UDAOEM_TEAOEQR_si" <%=(medicalData.getMedical_equipment_has().equals("S�")) ? "checked": ""%> value="S�">S�</label>
													<label><input type="radio" name="<%=Constants.SECTION8_MEDICAL_EQUIPMENT_HAS%>" id="requiere_UDAOEM_TEAOEQR_no" <%=(medicalData.getMedical_equipment_has().equals("No")||medicalData.getMedical_equipment_has().equals("")) ? "checked": ""%> value="No">No</label>
												</div>
											</div>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="form-group">
							<label for="se_ECE">�Se encuentra embarazada?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION8_PREGNANT%>" <%=(medicalData.getPregnant().equals("S�")) ? "checked": ""%> value="S�">S�</label>
								<label><input type="radio" name="<%=Constants.SECTION8_PREGNANT%>" <%=(medicalData.getPregnant().equals("No")||medicalData.getPregnant().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<table class="table table-control">
								<tr>
									<td class="td-center-control">
										<label for="por_CDLSSDPSEA">�Por cuales de los siguientes sistemas de previsi�n social est� amparado?</label>
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox" value="Ninguna" name="<%=Constants.SECTION8_SECURITY_SYSTEMS%>" <%= (medicalData.getSecurity_systems().containsKey("Ninguna")) ? "checked": ""%>>Ninguna</label><br>
												<label><input type="checkbox" value="Seguro social obligatorio" name="<%=Constants.SECTION8_SECURITY_SYSTEMS%>" <%= (medicalData.getSecurity_systems().containsKey("Seguro social obligatorio")) ? "checked": ""%>>Seguro social obligatorio</label><br>
												<label><input type="checkbox" value="Seguro privado de asistencia m�dica por su cuenta" name="<%=Constants.SECTION8_SECURITY_SYSTEMS%>" <%= (medicalData.getSecurity_systems().containsKey("Seguro privado de asistencia m�dica por su cuenta")) ? "checked": ""%>>Seguro privado de asistencia m�dica por su cuenta</label><br>
												<label><input type="checkbox" value="Seguro colectivo de asistencia m�dica de empresa u organizaci�n" name="<%=Constants.SECTION8_SECURITY_SYSTEMS%>" <%= (medicalData.getSecurity_systems().containsKey("Seguro colectivo de asistencia m�dica de empresa u organizaci�n")) ? "checked": ""%>>Seguro colectivo de asistencia m�dica de empresa u organizaci�n</label>
											</div>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="padecido_OHSDPADLSE">�Ha padecido o ha sido diagnosticado por alguna de las siguientes enfermedades?</label> 
							<table class="table table-control">
								<tr>
									<td class="td-left-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox" value="Ninguna" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("Ninguna")) ? "checked": ""%>>Ninguna</label><br>
												<label><input type="checkbox" value="Asma bronquial" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("Asma bronquial")) ? "checked": ""%>>Asma bronquial</label><br>
												<label><input type="checkbox" value="C�ncer o tumores malignos" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("C�ncer o tumores malignos")) ? "checked": ""%>>C�ncer o tumores malignos</label><br>
											</div>
										</div>
									</td>
									<td class="td-center-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox" value="Enfermedades cong�nitas o adquiridas" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("Enfermedades cong�nitas o adquiridas")) ? "checked": ""%>>Enfermedades cong�nitas o adquiridas</label><br>
												<label><input type="checkbox" value="Enfermedades del coraz�n" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("Enfermedades del coraz�n")) ? "checked": ""%>>Enfermedades del coraz�n</label><br>
												<label><input type="checkbox" value="Enfermedades de la piel" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("Enfermedades de la piel")) ? "checked": ""%>>Enfermedades de la piel</label>
											</div>
										</div>
									</td>
									<td class="td-right-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox" value="Hipertensi�n arterial" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("Hipertensi�n arterial")) ? "checked": ""%>>Hipertensi�n arterial</label><br>
												<label><input type="checkbox" value="Diabetes mellitus" name="<%=Constants.SECTION8_DISEASES%>" <%= (medicalData.getDiseases().containsKey("Diabetes mellitus")) ? "checked": ""%>>Diabetes mellitus</label><br>
												<label><input type="checkbox" value="Otra �Cu�l?" name="<%=Constants.SECTION8_DISEASES%>" id="padecido_OHSDPADLSE_select" <%= (medicalData.getDiseases().containsKey("Otra �Cu�l?")) ? "checked": ""%>>Otra �Cu�l?</label>
											</div>
										</div>
									</td>
								</tr>
							</table>

						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="padecido_OHSDPADLSE_text" name="<%=Constants.SECTION8_DISEASES_OTHER%>" placeholder="�Cu�l?"  <%=!medicalData.getDiseases().containsKey("Otra �Cu�l?") ? "style=\"display: none\"": ""%> value="<%=medicalData.getDiseases_other()%>">
						</div>
						<div class="form-group">
							<label for="ha_RSHLSV">�Ha recibido su hijo(s) las siguientes vacunas?</label> 
							<table class="table table-control">
								<tr>
									<td class="td-left-control">
										<table>
											<tr>
												<td>BCG: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_BCG%>" id="ha_RSHLSV_BCG">
													<option value="1" <%= medicalData.getVaccines_BCG().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_BCG().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_BCG().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_BCG().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_BCG().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
											<tr>
												<td>Triple: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_TRIPLE%>" id="ha_RSHLSV_triple">
													<option value="1" <%= medicalData.getVaccines_Triple().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_Triple().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_Triple().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_Triple().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_Triple().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
										</table>
									</td>
									<td class="td-center-control">
										<table>
											<tr>
												<td>Trivalente: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_TRIVALENTE%>" id="ha_RSHLSV_trivalente">
													<option value="1" <%= medicalData.getVaccines_Trivalente().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_Trivalente().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_Trivalente().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_Trivalente().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_Trivalente().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
											<tr>
												<td>Polio: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_POLIO%>" id="ha_RSHLSV_polio">
													<option value="1" <%= medicalData.getVaccines_Polio().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_Polio().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_Polio().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_Polio().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_Polio().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
										</table>
									</td>
									<td class="td-center-control">
										<table>
											<tr>
												<td>Hepatitis A: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_HEPATITISA%>" id="ha_RSHLSV_hepatitis_A">
													<option value="1" <%= medicalData.getVaccines_HepatitisA().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_HepatitisA().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_HepatitisA().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_HepatitisA().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_HepatitisA().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
											<tr>
												<td>Hepatitis B: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_HEPATITISB%>" id="ha_RSHLSV_hepatitis_B">
													<option value="1" <%= medicalData.getVaccines_HepatitisB().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_HepatitisB().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_HepatitisB().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_HepatitisB().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_HepatitisB().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
										</table>
									</td>
									<td class="td-right-control">
										<table>
											<tr>
												<td>Meningitis: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_MENINGITIS%>" id="ha_RSHLSV_meningitis">
													<option value="1" <%= medicalData.getVaccines_Meningitis().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_Meningitis().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_Meningitis().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_Meningitis().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_Meningitis().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
											<tr>
												<td>Sarampi�n: </td>
												<td><select class="form-control"
												name="<%=Constants.SECTION8_VACCINES_SARAMPION%>" id="ha_RSHLSV_sarampion">
													<option value="1" <%= medicalData.getVaccines_Sarampion().equals("1") ? "selected": ""%>>1</option>
													<option value="2" <%= medicalData.getVaccines_Sarampion().equals("2") ? "selected": ""%>>2</option>
													<option value="3" <%= medicalData.getVaccines_Sarampion().equals("3") ? "selected": ""%>>3</option>
													<option value="4" <%= medicalData.getVaccines_Sarampion().equals("4") ? "selected": ""%>>4</option>
													<option value="5" <%= medicalData.getVaccines_Sarampion().equals("5") ? "selected": ""%>>5</option>
												</select></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="asiste_ACMP">�Asiste a control m�dico prenatal?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION8_PRENATAL%>" <%=(medicalData.getPrenatal().equals("S�")) ? "checked": ""%> value="S�">S�</label>
								<label><input type="radio" name="<%=Constants.SECTION8_PRENATAL%>" <%=(medicalData.getPrenatal().equals("No")||medicalData.getPrenatal().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit" class="btn btn-primary hidden" id="submitBtn<%=Parameters.getPageNumber()%>">
	</form>
	<%@include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
		$('#requiere_UDAOEM_si').change(function() {
			$('#requiere_UDAOEM_div').show();
		});
		$('#requiere_UDAOEM_no').change(function() {
			$('#requiere_UDAOEM_div').hide();
		});

		
		$('#cuando_RAMAQLA_select').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected!='Ninguno'){
		    	$('#porque_RAAEEDS_div').show();	
		    }else{
		    	$('#porque_RAAEEDS_div').hide()
		    }
		});
		
		$('#padecido_OHSDPADLSE_select').on('change', function (e) {
			
			if($(this).is(':checked')){
		    	$('#padecido_OHSDPADLSE_text').show();	
		    }else{
		    	$('#padecido_OHSDPADLSE_text').hide()
		    }
		});
		
		$('#requiere_UDAOEM_cual_select').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='Otro �Cu�l?'){
		    	$('#requiere_UDAOEM_cual_text').show();	
		    }else{
		    	$('#requiere_UDAOEM_cual_text').hide()
		    }
		});
		
	});
</script>

<%@include file="footer.jsp"%>
