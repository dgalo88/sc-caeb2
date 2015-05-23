<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group">
		<table class="table">
			<tr>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="tipo_estructura">Tipo de Estructura</label> 
							<select class="form-control" name="tipo_estructura" id="tipo_estructura">
								<option>Casa</option>
								<option>Apartamento en edificio</option>
								<option>Apartamento en quinta, casa quinta</option>
								<option>Casa de vecindad</option>
								<option>Rancho</option>
								<option>Otros (1 = Dep�sito, 2 = Talleres, 3 = Comercio)</option>
							</select>
						</div>
						<div class="form-group">
							<label for="tenencia">Tenencia</label>
							<select class="form-control" name="tenencia" id="tenencia">
								<option>Propia pagada totalmente</option>
								<option>Propia pag�ndose</option>
								<option>Alquilada</option>
								<option>Prestada</option>
								<option>Otra forma</option>
							</select>
						</div>
						<div class="form-group">
							<label for="total_cuartos">Total de cuartos que contiene la vivienda</label> 
								<input type="number" required class="form-control" id="total_cuartos" name="total_cuartos" placeholder="No incluye ba�os, pasillos, balcones ni lavaderos">
						</div>
						<div class="form-group">
							<label for="la_vivienda_GFM">�La vivienda se ajusta a su grupo familiar?</label> 
							<div class="radio">
								<label><input type="radio" name="la_vivienda_GFM" checked>S�</label>
								<label><input type="radio" name="la_vivienda_GFM">No</label>
							</div>
						</div>
						<div class="form-group">
							<label for="vivienda_sector">�La vivienda est� en un sector?</label>
							<select class="form-control" name="vivienda_sector" id="vivienda_sector">
								<option>Plano</option>
								<option>Inclinado </option>
								<option>Mixto</option>
							</select>
						</div>
						<div class="form-group">
							<label for="la_vivienda_PA">�La vivienda tiene posibilidad de ampliaci�n?</label> 
							<div class="radio">
								<label><input type="radio" name="la_vivienda_PA" checked>S�</label>
								<label><input type="radio" name="la_vivienda_PA">No</label>
							</div>
						</div>
					</div>
				</td>
				<td width="50%">
					<div>
						<div class="form-group">
							<label>Material Predominante de la Vivienda</label>
							<table style="padding: none;">
								<tr>
									<th width="30%">Paredes</th>
									<th width="30%">Techo</th>
									<th width="30%">Piso</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;">
										<select class="form-control" name="paredes">
											<option>Bloque o ladrillo frisado</option>
											<option>Bloque o ladrillo sin frisar</option>
											<option>Concreto</option>
											<option>Madera aserrada, formica, fibra de vidrio y similares</option>
											<option>Adobe, tapia o bahareque sin frisar</option>
											<option>Otros (Palmas, tablas o similares)</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="techo">
											<option>Platabanda</option>
											<option>Teja</option>
											<option>L�minas asf�lticas</option>
											<option>L�minas met�licas (Zinc y similares)</option>
											<option>Asbestos y similares</option>
											<option>Otros (Palmas, tablas o Similares)</option>
										</select>
									</td>
									<td>
										<select class="form-control" name="piso">
											<option>M�rmol, mosaico, granito, vinil cer�mica, ladrillo, terracota, parquet, alfombrado y similares</option>
											<option>Cemento</option>
											<option>Tierra</option>
											<option>Otros</option>
										</select>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="ubicacion_cocina">Ubicaci�n de la Cocina</label>
							<select class="form-control" name="ubicacion_cocina" id="ubicacion_cocina">
								<option>Cuarto solo</option>
								<option>Sala, comedor</option>
								<option>Otro sitio</option>
							</select>
						</div>
						
						<div class="form-group">
							<label>Servicios con los que cuenta la Vivienda</label>
							<table style="padding: none;">
								<tr>
									<th width="25%">Agua</th>
									<th width="25%">Servicio sanitario</th>
									<th width="25%">�Dispone de servicio el�ctrico?</th>
									<th width="25%">Recolecci�n de basura</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;">
										<select class="form-control" name="vivienda_S_agua" id="vivienda_S_agua">
											<option value="1">Acueducto o tuber�a</option>
											<option value="2">Cami�n cisterna</option>
											<option value="3">Pila p�blica o estanque</option>
											<option value="4">Pozo con tuber�a o bomba</option>
											<option value="5">Otros medios, especifique</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="servicio_sanitario">
											<option>Peseta conectada a la cloaca</option>
											<option>Peseta conectada al r�o</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="servicio_electrico">
											<option>S�</option>
											<option>No</option>
										</select>
									</td>
									<td>
										<select class="form-control" name="recoleccion_basura">
											<option>Recogida por el servicio de aseo urbano</option>
											<option>Depositada en conteiner colectivo</option>
											<option>Vertida en quebradas, r�os, lagos, calles o terrenos bald�os</option>
										</select>
									</td>
								</tr>
								<tr>
									<td style="padding-top: 1%" colspan="4">
										<input type="text" class="form-control" id="vivienda_S_agua_otra" name="vivienda_S_agua_otra" placeholder="Otros medios de servicio de agua" style="display: none">
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="vivienda_alturadar">�La vivienda esta alturada en una zona de riesgo?</label>
							<select class="form-control" name="vivienda_alturadar" id="vivienda_alturadar">
								<option>Ninguna</option>
								<option>Inundaci�n</option>
								<option>Deslizamiento</option>
							</select>
						</div>
						<div class="form-group">
							<label for="la_vivienda_RMU">�La vivienda requiere mejoras urgentes?</label> 
							<div class="radio">
								<label><input type="radio" name="la_vivienda_RMU" id="la_vivienda_RMU_si">S�</label>
								<label><input type="radio" name="la_vivienda_RMU" id="la_vivienda_RMU_no" checked>No</label>
							</div>
						</div>
						<div class="form-group" style="display: none" id="la_vivienda_RMU_div">
							<table style="padding: none;">
								<tr>
									<th width="30%">�En qu� parte de la vivienda?</th>
									<th width="30%">�Qu� requiere mejorar?</th>
									<th width="30%">�Qu� trabajo necesita realizar?</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;">
										<div class="checkbox">
											<label><input type="checkbox">Cocina</label><br>
											<label><input type="checkbox">Comedor</label><br>
											<label><input type="checkbox">Dormitorio</label><br>
											<label><input type="checkbox">Ba�o</label><br>
											<label><input type="checkbox" id="vivienda_mejoras_PV_checkbox" name="vivienda_mejoras_PV_checkbox">Otra �Cu�l?</label>
										</div> 
									</td>
									<td style="padding-right: 1%;">
										<div class="checkbox">
											<label><input type="checkbox">Techo</label><br>
											<label><input type="checkbox">Piso</label><br>
											<label><input type="checkbox">Paredes</label><br>
											<label><input type="checkbox">Sistema el�ctrico</label><br>
											<label><input type="checkbox" id="vivienda_mejoras_RM_checkbox" name="vivienda_mejoras_RM_checkbox">Otra �Cu�l?</label>
										</div> 
									</td>
									<td>
										<div class="checkbox">
											<label><input type="checkbox">Friso</label><br>
											<label><input type="checkbox">Ampliaci�n</label><br>
											<label><input type="checkbox">Remodelaci�n</label><br>
											<label><input type="checkbox">Reparaci�n</label><br>
											<label><input type="checkbox" id="vivienda_mejoras_TNR_checkbox" name="vivienda_mejoras_TNR_checkbox">Otra �Cu�l?</label>
										</div> 
									</td>
								</tr>
								<tr>
									<td style="padding-right: 1%; padding-top: 1%">
										<input type="text" class="form-control" id="vivienda_mejoras_PV_otra" name="vivienda_mejoras_PV_otra" placeholder="Respuesta" style="display: none">
									</td>
									<td style="padding-right: 1%; padding-top: 1%">
										<input type="text" class="form-control" id="vivienda_mejoras_RM_otra" name="vivienda_mejoras_RM_otra" placeholder="Respuesta" style="display: none">
									</td>
									<td style="padding-top: 1%">
										<input type="text" class="form-control" id="vivienda_mejoras_TNR_otra" name="vivienda_mejoras_TNR_otra" placeholder="Respuesta" style="display: none">
									</td>
								</tr>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>

<script>
	$(document).ready(function() {
		$('#la_vivienda_RMU_si').change(function() {
			$('#la_vivienda_RMU_div').show();
		});
		$('#la_vivienda_RMU_no').change(function() {
			$('#la_vivienda_RMU_div').hide();
		});
		$('#vivienda_mejoras_PV_checkbox').on('change', function (e) {
		    if($("#vivienda_mejoras_PV_checkbox").is(':checked')){
		    	$('#vivienda_mejoras_PV_otra').show();	
		    }else{
		    	$('#vivienda_mejoras_PV_otra').hide()
		    }
		});
		$('#vivienda_mejoras_RM_checkbox').on('change', function (e) {
		    if($("#vivienda_mejoras_RM_checkbox").is(':checked')){
		    	$('#vivienda_mejoras_RM_otra').show();	
		    }else{
		    	$('#vivienda_mejoras_RM_otra').hide()
		    }
		});
		$('#vivienda_mejoras_TNR_checkbox').on('change', function (e) {
		    if($("#vivienda_mejoras_TNR_checkbox").is(':checked')){
		    	$('#vivienda_mejoras_TNR_otra').show();	
		    }else{
		    	$('#vivienda_mejoras_TNR_otra').hide()
		    }
		});
		$('#vivienda_S_agua').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='5'){
		    	$('#vivienda_S_agua_otra').show();	
		    }else{
		    	$('#vivienda_S_agua_otra').hide()
		    }
		});
		
	});
</script>

<%@ include file="footer.jsp"%>