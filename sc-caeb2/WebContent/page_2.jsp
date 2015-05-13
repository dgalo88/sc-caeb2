<%@ include file="jsp/header.jsp"%>
<div class="container" style="padding-top: 2%;">
	<form>
		<table width="100%">
			<tr>
				<th  width="50%"></th>
				<th  width="50%"></th>
			</tr>
			<tr>
				<td valign="top" style="padding-right: 2%;">
					<div>
						<div class="form-group">
							<label for="tipo_estructura">Tipo de Estructura</label> 
							<select class="form-control" name="tipo_estructura" id="tipo_estructura">
								<option>Casa</option>
								<option>Apartamento en edificio</option>
								<option>Apartamento en quinta, casa quinta</option>
								<option>Casa de vecindad</option>
								<option>Rancho</option>
								<option>Otros (1=Deposito, 2=Talleres, 3=comercio)</option>
							</select>
						</div>
						<div class="form-group">
							<label for="tenencia">Tenencia</label>
							<select class="form-control" name="tenencia" id="tenencia">
								<option>Propia pagada totalmente</option>
								<option>Propia pagándose</option>
								<option>Alquilada</option>
								<option>Prestada</option>
								<option>Otra forma</option>
							</select>
						</div>
						<div class="form-group">
							<label for="total_cuartos">Total de cuarto que contiene la vivienda</label> 
								<input type="number" required class="form-control" id="total_cuartos" name="total_cuartos" placeholder="No incluye Baños, Pasillos, Balcones ni Lavadores">
						</div>
						<div class="form-group">
							<label for="la_vivienda_GFM">¿La vivienda se ajusta a su grupo familiar?</label> 
							<div class="radio">
								<label><input type="radio" name="la_vivienda_GFM" checked="checked">Si</label>
								<label><input type="radio" name="la_vivienda_GFM">No</label>
							</div>
						</div>
						<div class="form-group">
							<label for="vivienda_sector">¿La vivienda está en un sector?</label>
							<select class="form-control" name="vivienda_sector" id="vivienda_sector">
								<option>Plano</option>
								<option>Inclinado </option>
								<option>Mixto</option>
							</select>
						</div>
						<div class="form-group">
							<label for="la_vivienda_PA">¿La vivienda tiene posibilidad de ampliación?</label> 
							<div class="radio">
								<label><input type="radio" name="la_vivienda_PA" checked="checked">Si</label>
								<label><input type="radio" name="la_vivienda_PA">No</label>
							</div>
						</div>
					</div>
				</td>
				<td valign="top">
					<div>
						<div class="form-group">
							<label for="exampleInputPassword1">Material Predominante de la Vivienda</label>
							<table style="padding: none;">
								<tr>
									<th width="30%">Paredes</th>
									<th width="30%">Techo</th>
									<th width="30%">Piso</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;">
										<select class="form-control" name="paredes">
											<option>Bloque o Ladrillo Frisado</option>
											<option>Bloque o Ladrillo sin Frisar</option>
											<option>Concreto</option>
											<option>Madera Aserrada, Fornica, Fibra de vidrio y
												Similares</option>
											<option>Adobe, Tapia o Bahareque sin Frisar</option>
											<option>Otros(Palmas, Tablas o Similares)</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="techo">
											<option>Platabanda</option>
											<option>Teja</option>
											<option>Laminas Asfálticas</option>
											<option>Laminas Metálicas (Zinz y Similares)</option>
											<option>Asbestos y Similares</option>
											<option>Otros (Palmas, Tablas o Similares)</option>
										</select>
									</td>
									<td>
										<select class="form-control" name="piso">
											<option>Mármol, Mosaico, Granito, Vinil Cerámica, Ladrillo, Terracota, Parquet, Alfombrado y similares</option>
											<option>Cemento</option>
											<option>Tierra</option>
											<option>Otros</option>
										</select>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="ubicacion_cocina">Ubicación de la Cocina</label>
							<select class="form-control" name="ubicacion_cocina" id="ubicacion_cocina">
								<option>Cuarto Solo</option>
								<option>Sala, Comedor</option>
								<option>Otro Sitio</option>
							</select>
						</div>
						
						<div class="form-group">
							<label for="exampleInputPassword1">Servicios con los que cuenta la Vivienda</label>
							<table style="padding: none;">
								<tr>
									<th width="25%">Agua</th>
									<th width="25%">Servicio Sanitario</th>
									<th width="25%">¿Dispone de Servicio Eléctrico?</th>
									<th width="25%">Recolección de Basura</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;">
										<select class="form-control" name="vivienda_S_agua" id="vivienda_S_agua">
											<option value="1">Acueducto o Tubería</option>
											<option value="2">Camión Cisterna</option>
											<option value="3">Pila Publica o Estanque</option>
											<option value="4">Pozo con tubería o Bomba</option>
											<option value="5">Otros medios, Especifique</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="servicio_sanitario">
											<option>Peseta Conectada a la Cloaca</option>
											<option>Peseta Conectada al Rio</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="servicio_electrico">
											<option>Si</option>
											<option>No</option>
										</select>
									</td>
									<td>
										<select class="form-control" name="recoleccion_basura">
											<option>Recogida por el Servicio de Aseo Urbano</option>
											<option>Depositada en conteiner Colectivo</option>
											<option>Vertida en Quebradas, Ríos, Lagos, Calles o Terrenos Baldíos</option>
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
							<label for="vivienda_alturadar">¿La vivienda esta alturada en una zona de riesgo?</label>
							<select class="form-control" name="vivienda_alturadar" id="vivienda_alturadar">
								<option>Ninguna</option>
								<option>Inundación</option>
								<option>Deslizamiento</option>
							</select>
						</div>
						<div class="form-group">
							<label for="la_vivienda_RMU">¿La vivienda requiere mejoras urgentes?</label> 
							<div class="radio">
								<label><input type="radio" name="la_vivienda_RMU" id="la_vivienda_RMU_si">Si</label>
								<label><input type="radio" name="la_vivienda_RMU" id="la_vivienda_RMU_no" checked="checked">No</label>
							</div>
						</div>
						<div class="form-group" style="display: none" id="la_vivienda_RMU_div">
							<table style="padding: none;">
								<tr>
									<th width="30%">¿En qué parte de la vivienda?</th>
									<th width="30%">¿Que requiere mejorar?</th>
									<th width="30%">¿Qué trabajo necesita realizar?</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;">
										<select class="form-control" name="vivienda_mejoras_PV" id="vivienda_mejoras_PV">
											<option value="1">Cocina</option>
											<option value="2">Comedor</option>
											<option value="3">Dormitorio</option>
											<option value="4">Baño</option>
											<option value="5">Otra ¿Cual?</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="vivienda_mejoras_RM" id="vivienda_mejoras_RM">
											<option value="1">Techo</option>
											<option value="2">Piso</option>
											<option value="3">Paredes</option>
											<option value="4">Sistema eléctrico</option>
											<option value="5">Otra ¿Cual?</option>
										</select>
									</td>
									<td>
										<select class="form-control" name="vivienda_mejoras_TNR" id="vivienda_mejoras_TNR">
											<option value="1">Friso</option>
											<option value="2">Ampliación</option>
											<option value="3">Remodelación</option>
											<option value="4">Reparación</option>
											<option value="5">Otra ¿Cual?</option>
										</select>
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
			<tr><td></td><td valign="top" align="right"><button class="btn btn-lg btn-primary btn-block" type="submit" style="width: initial;">Siguiente</button></td></tr>
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
		$('#vivienda_mejoras_PV').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='5'){
		    	$('#vivienda_mejoras_PV_otra').show();	
		    }else{
		    	$('#vivienda_mejoras_PV_otra').hide()
		    }
		});
		$('#vivienda_mejoras_RM').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='5'){
		    	$('#vivienda_mejoras_RM_otra').show();	
		    }else{
		    	$('#vivienda_mejoras_RM_otra').hide()
		    }
		});
		$('#vivienda_mejoras_TNR').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='5'){
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
<%@ include file="jsp/footer.jsp"%>