<%@ include file="header.jsp"%>

<%
	int pageNumber = 8;
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group">
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
												<label><input type="checkbox">Ninguna</label><br>
												<label><input type="checkbox">Ceguera total</label><br>
												<label><input type="checkbox">Dificultad para ver</label><br>
												<label><input type="checkbox">Sordera total</label>
											</div>
										</div>
									</td>
									<td class="td-center-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox">Dificulta para oír</label><br>
												<label><input type="checkbox">Dificultad para hablar</label><br>
												<label><input type="checkbox">Retardo mental</label>
											</div>
										</div>
									</td>
									<td class="td-right-control">
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox">Pérdida de capacidad mental</label><br>
												<label><input type="checkbox">Pérdida o discapacidad de extremidades superiores</label><br>
												<label><input type="checkbox">Pérdida o discapacidad de extremidades inferiores</label>
											</div>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="cuando_RAMAQLA">¿Cuándo requiere asistencia médica a qué lugar asiste?</label> 
							<select class="form-control" name="cuando_RAMAQLA_select" id="cuando_RAMAQLA_select">
								<option value="Ninguno">Ninguno</option>
								<option value="Ambulatorio">Ambulatorio</option>
								<option value="Hospital público">Hospital público</option>
								<option value="Hospital del seguro social">Hospital del seguro social</option>
								<option value="Clínica o consultorio privado">Clínica o consultorio privado</option>
								<option value="Servicio médico del trabajo">Servicio médico del trabajo</option>
								<option value="Servicio médico Barrio Adentro I">Servicio médico Barrio Adentro I</option>
								<option value="Servicio médico Barrio Adentro I">Servicio médico Barrio Adentro II</option>
							</select>
						</div>
						<div class="form-group" style="display: none" id="porque_RAAEEDS_div">
							<label for="porque_RAAEEDS">¿Por qué razón acude a ese establecimiento de salud?</label> 
							<select class="form-control" name="porque_RAAEEDS_select" id="porque_RAAEEDS_select">
								<option value="Bajos recursos económicos ">Bajos recursos económicos </option>
								<option value="Los servicios son económicos">Los servicios son económicos</option>
								<option value="Es el único establecimiento que presta el servicio">Es el único establecimiento que presta el servicio</option>
								<option value="Esta cerca del lugar de residencia">Esta cerca del lugar de residencia</option>
							</select>
						</div>
						<div class="form-group">
							<label for="requiere_UDAOEM">¿Requiere uso de aparatos o equipos médicos?</label> 
							<div class="radio">
								<label><input type="radio" name="requiere_UDAOEM" id="requiere_UDAOEM_si">Sí</label>
								<label><input type="radio" name="requiere_UDAOEM" id="requiere_UDAOEM_no" checked>No</label>
							</div>
							<div class="form-group" id="requiere_UDAOEM_div" style="display: none">
								<table class="table table-control">
									<tr>
										<td class="td-left-control">
											<div class="form-group">
												<label for="requiere_UDAOEM_cual">¿Cuál?</label> 
												<select class="form-control" name="requiere_UDAOEM_cual_select" id="requiere_UDAOEM_cual_select">
													<option value="Andadera">Andadera</option>
													<option value="Muletas">Muletas</option>
													<option value="Bastón">Bastón</option>
													<option value="Silla de ruedas">Silla de ruedas</option>
													<option value="Prótesis">Prótesis</option>
													<option value="Bombona de oxigeno">Bombona de oxigeno</option>
													<option value="Otro ¿Cuál?">Otro ¿Cuál?</option>
												</select>
											</div>
											<div class="form-group">
												<div class="radio">
													<input type="text" required class="form-control" id="requiere_UDAOEM_cual_text" name="requiere_UDAOEM_cual_text" placeholder="¿Cuál?" style="display: none">
												</div>
											</div>
										</td>
										<td class="td-right-control">
											<div class="form-group">
												<label for="requiere_UDAOEM_TEAOEQR">¿Tiene el aparato o equipo que requiere?</label> 
												<div class="radio">
													<label><input type="radio" name="requiere_UDAOEM_TEAOEQR" id="requiere_UDAOEM_TEAOEQR_si">Sí</label>
													<label><input type="radio" name="requiere_UDAOEM_TEAOEQR" id="requiere_UDAOEM_TEAOEQR_no" checked>No</label>
												</div>
											</div>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="form-group">
							<label for="se_ECE">¿Se encuentra embarazada?</label> 
							<div class="radio">
								<label><input type="radio" name="se_ECE">Sí</label>
								<label><input type="radio" name="se_ECE" checked>No</label>
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
										<label for="por_CDLSSDPSEA">¿Por cuales de los siguientes sistemas de previsión social está amparado?</label>
										<div class="form-group">
											<div class="checkbox">
												<label><input type="checkbox">Ninguna</label><br>
												<label><input type="checkbox">Seguro social obligatorio</label><br>
												<label><input type="checkbox">Seguro privado de asistencia médica por su cuenta</label><br>
												<label><input type="checkbox">Seguro colectivo de asistencia médica de empresa u organización</label>
											</div>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="padecido_OHSDPADLSE">¿Ha padecido o ha sido diagnosticado por alguna de las siguientes enfermedades?</label> 
							<select class="form-control" name="padecido_OHSDPADLSE_select" id="padecido_OHSDPADLSE_select">
								<option value="Ninguno">Ninguno</option>
								<option value="Asma bronquial">Asma bronquial</option>
								<option value="Cáncer o tumores malignos">Cáncer o tumores malignos</option>
								<option value="Enfermedades congénitas o adquiridas">Enfermedades congénitas o adquiridas</option>
								<option value="Enfermedades del corazón">Enfermedades del corazón</option>
								<option value="Enfermedades de la piel">Enfermedades de la piel</option>
								<option value="Hipertensión arterial">Hipertensión arterial</option>
								<option value="Diabetes mellitus">Diabetes mellitus</option>
								<option value="Otra ¿Cuál?">Otra ¿Cuál?</option>
							</select>
						</div>
						<div class="form-group">
							<input type="text" required class="form-control" id="padecido_OHSDPADLSE_text" name="padecido_OHSDPADLSE_text" placeholder="¿Cuál?" style="display: none">
						</div>
						<div class="form-group">
							<label for="ha_RSHLSV">¿Ha recibido su hijo(s) las siguientes vacunas?</label> 
							<table class="table table-control">
								<tr>
									<td class="td-left-control">
										<table>
											<tr>
												<td>BCG: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_BCG" id="ha_RSHLSV_BCG">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
											<tr>
												<td>Triple: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_triple" id="ha_RSHLSV_triple">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
										</table>
									</td>
									<td class="td-center-control">
										<table>
											<tr>
												<td>Trivalente: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_trivalente" id="ha_RSHLSV_trivalente">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
											<tr>
												<td>Polio: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_polio" id="ha_RSHLSV_polio">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
										</table>
									</td>
									<td class="td-center-control">
										<table>
											<tr>
												<td>Hepatitis A: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_hepatitis_A" id="ha_RSHLSV_hepatitis_A">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
											<tr>
												<td>Hepatitis B: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_hepatitis_B" id="ha_RSHLSV_hepatitis_B">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
										</table>
									</td>
									<td class="td-right-control">
										<table>
											<tr>
												<td>Meningitis: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_meningitis" id="ha_RSHLSV_meningitis">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
											<tr>
												<td>Sarampión: </td>
												<td><select class="form-control"
												name="ha_RSHLSV_sarampion" id="ha_RSHLSV_sarampion">
													<option value="1">1</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5</option>
												</select></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="asiste_ACMP">¿Asiste a control médico prenatal?</label> 
							<div class="radio">
								<label><input type="radio" name="asiste_ACMP">Sí</label>
								<label><input type="radio" name="asiste_ACMP" checked>No</label>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="pagination.jsp"%>
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
		    var valueSelected = this.value;
		    if(valueSelected=='Otra ¿Cual?'){
		    	$('#padecido_OHSDPADLSE_text').show();	
		    }else{
		    	$('#padecido_OHSDPADLSE_text').hide()
		    }
		});
		
		$('#requiere_UDAOEM_cual_select').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='Otro ¿Cuál?'){
		    	$('#requiere_UDAOEM_cual_text').show();	
		    }else{
		    	$('#requiere_UDAOEM_cual_text').hide()
		    }
		});
		
	});
</script>

<%@ include file="footer.jsp"%>
