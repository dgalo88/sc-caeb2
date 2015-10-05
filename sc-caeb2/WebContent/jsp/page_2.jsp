<%@page import="com.caeb2.sections.HousingData"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(2);
	Parameters.setTitle("Secci�n 2: Datos de la vivienda");
	HousingData housingData= new HousingData(request.getRequestedSessionId());
%>

<%@include file="validateCurrentPage.jsp"%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveProcessPage2" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="tipo_estructura">Tipo de Estructura</label> 
							<select class="form-control" name="<%=Constants.SECTION2_STRUCTURE_TYPE%>" id="<%=Constants.SECTION2_STRUCTURE_TYPE%>">
								<option value="Casa" <%= housingData.getStructure_type().equals("Casa") ? "selected": ""%>>Casa</option>
								<option value="Apartamento en edificio" <%= housingData.getStructure_type().equals("Apartamento en edificio") ? "selected": ""%>>Apartamento en edificio</option>
								<option value="Apartamento en quinta, casa quinta" <%= housingData.getStructure_type().equals("Apartamento en quinta, casa quinta") ? "selected": ""%>>Apartamento en quinta, casa quinta</option>
								<option value="Casa de vecindad" <%= housingData.getStructure_type().equals("Casa de vecindad") ? "selected": ""%>>Casa de vecindad</option>
								<option value="Rancho" <%= housingData.getStructure_type().equals("Rancho") ? "selected": ""%>>Rancho</option>
								<option value="Dep�sito" <%= housingData.getStructure_type().equals("Dep�sito") ? "selected": ""%>>Dep�sito</option>
								<option value="Taller" <%= housingData.getStructure_type().equals("Taller") ? "selected": ""%>>Taller</option>
								<option value="Comercio" <%= housingData.getStructure_type().equals("Comercio") ? "selected": ""%>>Comercio</option>
							</select>
						</div>
						<div class="form-group">
							<label for="tenencia">Tenencia</label>
							<select class="form-control" name="<%=Constants.SECTION2_HOLDING%>" id="<%=Constants.SECTION2_HOLDING%>">
								<option value="Propia pagada totalmente" <%= housingData.getHolding().equals("Propia pagada totalmente") ? "selected": ""%>>Propia pagada totalmente</option>
								<option value="Propia pag�ndose" <%= housingData.getHolding().equals("Propia pag�ndose") ? "selected": ""%>>Propia pag�ndose</option>
								<option value="Alquilada" <%= housingData.getHolding().equals("Alquilada") ? "selected": ""%>>Alquilada</option>
								<option value="Prestada" <%= housingData.getHolding().equals("Prestada") ? "selected": ""%>>Prestada</option>
								<option value="Otra forma" <%= housingData.getHolding().equals("Otra forma") ? "selected": ""%>>Otra forma</option>
							</select>
						</div>
						<div class="form-group">
							<label for="total_cuartos">Total de cuartos que contiene la vivienda</label> 
								<input type="number" required class="form-control" id="<%=Constants.SECTION2_TOTAL_ROOMS%>"
										name="<%=Constants.SECTION2_TOTAL_ROOMS%>"
										placeholder="No incluye ba�os, pasillos, balcones ni lavaderos"
										value="<%=housingData.getTotal_rooms()%>" min="1">
						</div>
						<div class="form-group">
							<label for="la_vivienda_GFM">�La vivienda se ajusta a su grupo familiar?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION2_HOUSING_FITS_HOUSEHOLD%>" <%= (housingData.getHousing_fits_household().equals("S�")||housingData.getHousing_fits_household().equals("")) ? "checked": ""%> value="S�">S�</label>
								<label><input type="radio" name="<%=Constants.SECTION2_HOUSING_FITS_HOUSEHOLD%>" <%= (housingData.getHousing_fits_household().equals("No")) ? "checked": ""%> value="No">No</label>
							</div>
						</div>
						<div class="form-group">
							<label for="vivienda_sector">�La vivienda est� en un sector?</label>
							<select class="form-control" name="<%=Constants.SECTION2_HOUSE_SECTOR%>" id="<%=Constants.SECTION2_HOUSE_SECTOR%>">
								<option value="Plano" <%= housingData.getHouse_sector().equals("Plano") ? "selected": ""%>>Plano</option>
								<option value="Inclinado" <%= housingData.getHouse_sector().equals("Inclinado") ? "selected": ""%>>Inclinado </option>
								<option value="Mixto" <%= housingData.getHouse_sector().equals("Mixto") ? "selected": ""%>>Mixto</option>
							</select>
						</div>
						<div class="form-group">
							<label for="la_vivienda_PA">�La vivienda tiene posibilidad de ampliaci�n?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION2_HOUSE_SCALABILITY%>" <%= (housingData.getHouse_scalability().equals("S�")||housingData.getHouse_scalability().equals("")) ? "checked": ""%> value="S�">S�</label>
								<label><input type="radio" name="<%=Constants.SECTION2_HOUSE_SCALABILITY%>" <%= (housingData.getHouse_scalability().equals("No")) ? "checked": ""%> value="No">No</label>
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
										<select class="form-control" name="<%=Constants.SECTION2_WALLS_TYPE%>">
											<option value="Bloque o ladrillo frisado" <%= housingData.getWalls_type().equals("Bloque o ladrillo frisado") ? "selected": ""%>>Bloque o ladrillo frisado</option>
											<option value="Bloque o ladrillo sin frisar" <%= housingData.getWalls_type().equals("Bloque o ladrillo sin frisar") ? "selected": ""%>>Bloque o ladrillo sin frisar</option>
											<option value="Concreto" <%= housingData.getWalls_type().equals("Concreto") ? "selected": ""%>>Concreto</option>
											<option value="Madera aserrada, formica, fibra de vidrio y similares" <%= housingData.getWalls_type().equals("Madera aserrada, formica, fibra de vidrio y similares") ? "selected": ""%>>Madera aserrada, formica, fibra de vidrio y similares</option>
											<option value="Adobe, tapia o bahareque sin frisar" <%= housingData.getWalls_type().equals("Adobe, tapia o bahareque sin frisar") ? "selected": ""%>>Adobe, tapia o bahareque sin frisar</option>
											<option value="Otros (Palmas, tablas o similares)" <%= housingData.getWalls_type().equals("Otros (Palmas, tablas o similares)") ? "selected": ""%>>Otros (Palmas, tablas o similares)</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="<%=Constants.SECTION2_CEILING_TYPE%>">
											<option value="Platabanda" <%= housingData.getCeiling_type().equals("Platabanda") ? "selected": ""%>>Platabanda</option>
											<option value="Teja" <%= housingData.getCeiling_type().equals("Teja") ? "selected": ""%>>Teja</option>
											<option value="L�minas asf�lticas" <%= housingData.getCeiling_type().equals("L�minas asf�lticas") ? "selected": ""%>>L�minas asf�lticas</option>
											<option value="L�minas met�licas (Zinc y similares)" <%= housingData.getCeiling_type().equals("L�minas met�licas (Zinc y similares)") ? "selected": ""%>>L�minas met�licas (Zinc y similares)</option>
											<option value="Asbestos y similares" <%= housingData.getCeiling_type().equals("Asbestos y similares") ? "selected": ""%>>Asbestos y similares</option>
											<option value="Otros (Palmas, tablas o Similares)" <%= housingData.getCeiling_type().equals("Otros (Palmas, tablas o Similares)") ? "selected": ""%>>Otros (Palmas, tablas o Similares)</option>
										</select>
									</td>
									<td>
										<select class="form-control" name="<%=Constants.SECTION2_FLAT_TYPE%>">
											<option value="M�rmol, mosaico, granito, vinil cer�mica, ladrillo, terracota, parquet, alfombrado y similares" <%= housingData.getCeiling_type().equals("M�rmol, mosaico, granito, vinil cer�mica, ladrillo, terracota, parquet, alfombrado y similares") ? "selected": ""%>>M�rmol, mosaico, granito, vinil cer�mica, ladrillo, terracota, parquet, alfombrado y similares</option>
											<option value="Cemento" <%= housingData.getFlat_type().equals("Cemento") ? "selected": ""%>>Cemento</option>
											<option value="Tierra" <%= housingData.getFlat_type().equals("Tierra") ? "selected": ""%>>Tierra</option>
											<option value="Otros" <%= housingData.getFlat_type().equals("Otros") ? "selected": ""%>>Otros</option>
										</select>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="ubicacion_cocina">Ubicaci�n de la Cocina</label>
							<select class="form-control" name="<%=Constants.SECTION2_LOCATION_KITCHEN%>" id="<%=Constants.SECTION2_LOCATION_KITCHEN%>">
								<option value="Cuarto solo" <%= housingData.getLocation_kitchen().equals("Cuarto solo") ? "selected": ""%>>Cuarto solo</option>
								<option value="Comedor" <%= housingData.getLocation_kitchen().equals("Comedor") ? "selected": ""%>>Comedor</option>
								<option value="Otro sitio" <%= housingData.getLocation_kitchen().equals("Otro sitio") ? "selected": ""%>>Otro sitio</option>
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
										<select class="form-control" name="<%=Constants.SECTION2_HOUSING_WATER%>" id="<%=Constants.SECTION2_HOUSING_WATER%>">
											<option value="Acueducto o tuber�a" <%= housingData.getHousing_water().equals("Acueducto o tuber�a") ? "selected": ""%>>Acueducto o tuber�a</option>
											<option value="Cami�n cisterna" <%= housingData.getHousing_water().equals("Cami�n cisterna") ? "selected": ""%>>Cami�n cisterna</option>
											<option value="Pila p�blica o estanque" <%= housingData.getHousing_water().equals("Pila p�blica o estanque") ? "selected": ""%>>Pila p�blica o estanque</option>
											<option value="Pozo con tuber�a o bomba" <%= housingData.getHousing_water().equals("Pozo con tuber�a o bomba") ? "selected": ""%>>Pozo con tuber�a o bomba</option>
											<option value="Otros medios, especifique" <%= housingData.getHousing_water().equals("Otros medios, especifique") ? "selected": ""%>>Otros medios, especifique</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="<%=Constants.SECTION2_SANITARY_SERVICE%>">
											<option value="Poceta conectada a la cloaca" <%= housingData.getSanitary_service().equals("Poceta conectada a la cloaca") ? "selected": ""%>>Poceta conectada a la cloaca</option>
											<option value="Poceta conectada al r�o" <%= housingData.getSanitary_service().equals("Poceta conectada al r�o") ? "selected": ""%>>Poceta conectada al r�o</option>
										</select>
									</td>
									<td style="padding-right: 1%;">
										<select class="form-control" name="<%=Constants.SECTION2_ELECTRICAL_SERVICE%>">
											<option value="S�" <%= housingData.getElectrical_service().equals("S�") ? "selected": ""%>>S�</option>
											<option value="No" <%= housingData.getElectrical_service().equals("No") ? "selected": ""%>>No</option>
										</select>
									</td>
									<td>
										<select class="form-control" name="<%=Constants.SECTION2_GARBAGE_COLLECTION%>">
											<option value="Recogida por el servicio de aseo urbano" <%= housingData.getGarbage_collection().equals("Recogida por el servicio de aseo urbano") ? "selected": ""%>>Recogida por el servicio de aseo urbano</option>
											<option value="Depositada en container colectivo" <%= housingData.getGarbage_collection().equals("Depositada en container colectivo") ? "selected": ""%>>Depositada en container colectivo</option>
											<option value="Vertida en quebradas, r�os, lagos, calles o terrenos bald�os" <%= housingData.getGarbage_collection().equals("Vertida en quebradas, r�os, lagos, calles o terrenos bald�os") ? "selected": ""%>>Vertida en quebradas, r�os, lagos, calles o terrenos bald�os</option>
										</select>
									</td>
								</tr>
								<tr>
									<td style="padding-top: 1%" colspan="4">
										<input type="text" class="form-control" id="<%=Constants.SECTION2_OTHER_HOUSING_WATER%>" name="<%=Constants.SECTION2_OTHER_HOUSING_WATER%>" placeholder="Otros medios de servicio de agua" <%= housingData.getHousing_water().equals("Otros medios, especifique") ? "value='"+housingData.getOther_housing_water()+"'": "style='display: none'"%>>
									</td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="vivienda_alturadar">�La vivienda esta situada en una zona de riesgo?</label>
							<select class="form-control" name="<%=Constants.SECTION2_HOUSING_RISK%>" id="<%=Constants.SECTION2_HOUSING_RISK%>">
								<option value="Ninguna" <%= housingData.getHousing_risk().equals("Ninguna") ? "selected": ""%>>Ninguna</option>
								<option value="Inundaci�n" <%= housingData.getHousing_risk().equals("Inundaci�n") ? "selected": ""%>>Inundaci�n</option>
								<option value="Deslizamiento" <%= housingData.getHousing_risk().equals("Deslizamiento") ? "selected": ""%>>Deslizamiento</option>
							</select>
						</div>
						<div class="form-group">
							<label for="la_vivienda_RMU">�La vivienda requiere mejoras urgentes?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS%>" id="<%=Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS%>_si" <%= (housingData.getUrgent_housing_improvements().equals("S�")) ? "checked": ""%> value="S�">S�</label>
								<label><input type="radio" name="<%=Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS%>" id="<%=Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS%>_no" <%= (housingData.getUrgent_housing_improvements().equals("No")||housingData.getHouse_scalability().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
						</div>
						<div class="form-group" <%= housingData.getUrgent_housing_improvements().equals("S�") ? "": "style='display: none'"%> id="la_vivienda_RMU_div">
							<table style="padding: none;">
								<tr>
									<th width="30%">�En qu� parte de la vivienda?</th>
									<th width="30%">�Qu� requiere mejorar?</th>
									<th width="30%">�Qu� trabajo necesita realizar?</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;">
										<div class="checkbox">
											<label><input type="checkbox" value="Cocina" name="<%=Constants.SECTION2_PART%>" <%= (housingData.getPart().containsKey("Cocina")) ? "checked": ""%>>Cocina</label><br>
											<label><input type="checkbox" value="Comedor" name="<%=Constants.SECTION2_PART%>" <%= (housingData.getPart().containsKey("Comedor")) ? "checked": ""%>>Comedor</label><br>
											<label><input type="checkbox" value="Dormitorio" name="<%=Constants.SECTION2_PART%>" <%= (housingData.getPart().containsKey("Dormitorio")) ? "checked": ""%>>Dormitorio</label><br>
											<label><input type="checkbox" value="Ba�o" name="<%=Constants.SECTION2_PART%>" <%= (housingData.getPart().containsKey("Ba�o")) ? "checked": ""%>>Ba�o</label><br>
											<label><input type="checkbox" value="Otra �Cu�l?" id="<%=Constants.SECTION2_PART%>_5" name="<%=Constants.SECTION2_PART%>" <%= (housingData.getPart().containsKey("Otra �Cu�l?")) ? "checked": ""%>>Otra �Cu�l?</label>
										</div> 
									</td>
									<td style="padding-right: 1%;">
										<div class="checkbox">
											<label><input type="checkbox" value="Techo" name="<%=Constants.SECTION2_REQUIRED%>" <%= (housingData.getRequired().containsKey("Techo")) ? "checked": ""%>>Techo</label><br>
											<label><input type="checkbox" value="Piso" name="<%=Constants.SECTION2_REQUIRED%>" <%= (housingData.getRequired().containsKey("Piso")) ? "checked": ""%>>Piso</label><br>
											<label><input type="checkbox" value="Paredes" name="<%=Constants.SECTION2_REQUIRED%>" <%= (housingData.getRequired().containsKey("Paredes")) ? "checked": ""%>>Paredes</label><br>
											<label><input type="checkbox" value="Sistema el�ctrico" name="<%=Constants.SECTION2_REQUIRED%>" <%= (housingData.getRequired().containsKey("Sistema el�ctrico")) ? "checked": ""%>>Sistema el�ctrico</label><br>
											<label><input type="checkbox" value="Otra �Cu�l?" id="<%=Constants.SECTION2_REQUIRED%>_5" name="<%=Constants.SECTION2_REQUIRED%>" <%= (housingData.getRequired().containsKey("Otra �Cu�l?")) ? "checked": ""%>>Otra �Cu�l?</label>
										</div> 
									</td>
									<td>
										<div class="checkbox">
											<label><input type="checkbox" value="Friso" name="<%=Constants.SECTION2_WORK_NEEDS%>" <%= (housingData.getWorkNeeds().containsKey("Friso")) ? "checked": ""%>>Friso</label><br>
											<label><input type="checkbox" value="Ampliaci�n" name="<%=Constants.SECTION2_WORK_NEEDS%>" <%= (housingData.getWorkNeeds().containsKey("Ampliaci�n")) ? "checked": ""%>>Ampliaci�n</label><br>
											<label><input type="checkbox" value="Remodelaci�n" name="<%=Constants.SECTION2_WORK_NEEDS%>" <%= (housingData.getWorkNeeds().containsKey("Remodelaci�n")) ? "checked": ""%>>Remodelaci�n</label><br>
											<label><input type="checkbox" value="Reparaci�n" name="<%=Constants.SECTION2_WORK_NEEDS%>" <%= (housingData.getWorkNeeds().containsKey("Reparaci�n")) ? "checked": ""%>>Reparaci�n</label><br>
											<label><input type="checkbox" value="Otra �Cu�l?"  id="<%=Constants.SECTION2_WORK_NEEDS%>_5" name="<%=Constants.SECTION2_WORK_NEEDS%>" <%= (housingData.getWorkNeeds().containsKey("Otra �Cu�l?")) ? "checked": ""%>>Otra �Cu�l?</label>
										</div> 
									</td>
								</tr>
								<tr>
									<td style="padding-right: 1%; padding-top: 1%">
										<input type="text" class="form-control" id="<%=Constants.SECTION2_PART_OTHER_RESPONSE%>" name="<%=Constants.SECTION2_PART_OTHER_RESPONSE%>" placeholder="Respuesta" <%= (housingData.getPart().containsKey("Otra �Cu�l?")) ? "value='"+housingData.getPart_other_response()+"'": "style='display: none'"%>>
									</td>
									<td style="padding-right: 1%; padding-top: 1%">
										<input type="text" class="form-control" id="<%=Constants.SECTION2_REQUIRED_OTHER_RESPONSE%>" name="<%=Constants.SECTION2_REQUIRED_OTHER_RESPONSE%>" placeholder="Respuesta" <%= (housingData.getRequired().containsKey("Otra �Cu�l?")) ? "value='"+housingData.getRequired_other_response()+"'": "style='display: none'"%>>
									</td>
									<td style="padding-top: 1%">
										<input type="text" class="form-control" id="<%=Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE%>" name="<%=Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE%>" placeholder="Respuesta" <%= (housingData.getWorkNeeds().containsKey("Otra �Cu�l?")) ? "value='"+housingData.getWork_needs_other_response()+"'": "style='display: none'"%>>
									</td>
								</tr>
							</table>
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
		$('#<%=Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS%>_si').change(function() {
			$('#la_vivienda_RMU_div').show();
		});
		$('#<%=Constants.SECTION2_URGENT_HOUSING_IMPROVEMENTS%>_no').change(function() {
			$('#la_vivienda_RMU_div').hide();
		});
		$('#<%=Constants.SECTION2_PART%>_5').on('change', function (e) {
		    if($("#<%=Constants.SECTION2_PART%>_5").is(':checked')){
		    	$('#<%=Constants.SECTION2_PART_OTHER_RESPONSE%>').show();	
		    }else{
		    	$('#<%=Constants.SECTION2_PART_OTHER_RESPONSE%>').hide()
		    }
		});
		$('#<%=Constants.SECTION2_REQUIRED%>_5').on('change', function (e) {
		    if($("#<%=Constants.SECTION2_REQUIRED%>_5").is(':checked')){
		    	$('#<%=Constants.SECTION2_REQUIRED_OTHER_RESPONSE%>').show();	
		    }else{
		    	$('#<%=Constants.SECTION2_REQUIRED_OTHER_RESPONSE%>').hide()
		    }
		});
		$('#<%=Constants.SECTION2_WORK_NEEDS%>_5').on('change', function (e) {
		    if($("#<%=Constants.SECTION2_WORK_NEEDS%>_5").is(':checked')){
		    	$('#<%=Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE%>').show();	
		    }else{
		    	$('#<%=Constants.SECTION2_WORK_NEEDS_OTHER_RESPONSE%>').hide()
		    }
		});
		$('#<%=Constants.SECTION2_HOUSING_WATER%>').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='Otros medios, especifique'){
		    	$('#<%=Constants.SECTION2_OTHER_HOUSING_WATER%>').show();	
		    }else{
		    	$('#<%=Constants.SECTION2_OTHER_HOUSING_WATER%>').hide()
		    }
		});
		
	});
</script>

<%@include file="footer.jsp"%>
