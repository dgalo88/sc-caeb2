<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="hogares_EEV">Hogares en esta vivienda</label> 
						<div class="form-inline">
							<div class="radio">
								<label>Hogar: <input type="text" class="form-control" id="hogar_EEV_hogar" name="hogar_EEV_hogar"></label>
								<label>De: <input type="text" class="form-control" id="hogar_EEV_de" name="hogar_EEV_de"></label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="numero_DCPD">Número de cuartos para dormir</label> 
						<input type="number" class="form-control" id="numero_DCPD" name="numero_DCPD" min="0">
					</div>
					<div class="form-group">
						<label for="jefe_OJDEHTP">¿El jefe o jefa de este hogar tiene pareja?</label> 
						<div class="radio">
							<label><input type="radio" name="jefe_OJDEHTP" checked="checked">Sí</label>
							<label><input type="radio" name="jefe_OJDEHTP">No</label>
						</div>
					</div>
					<div class="form-group">
						<label for="hogar_UM">¿Este hogar utiliza MERCAL?</label> 
						<div class="radio">
							<label><input type="radio" name="hogar_UM" id="hogar_UM_si">Sí</label>
							<label><input type="radio" name="hogar_UM" id="hogar_UM_no" checked="checked">No</label>
						</div>
						<select class="form-control" name="hogar_UM_select" id="hogar_UM_select" style="display: none">
							<option value="1">Diariamente</option>
							<option value="2">Semanalmente</option>
							<option value="3">Quincenalmente</option>
							<option value="4">Mensualmente</option>
							<option value="5">Esporádicamente</option>
						</select>
					</div>
					<div class="form-group">
						<label for="hogar_HSBCMDA">¿Este hogar ha sido beneficiado con mercados de alimentación?</label> 
						<div class="radio">
							<label><input type="radio" name="hogar_HSBCMDA" id="hogar_HSBCMDA_si">Sí ¿Cuál?</label>
							<label><input type="radio" name="hogar_HSBCMDA" id="hogar_HSBCMDA_no" checked="checked">No</label>
						</div> 
						<div class="radio" id="hogar_HSBCMDA_grupo" style="display: none">
							<label><input type="radio" name="hogar_HSBCMDA_opcion">Mercado completo</label>
							<label><input type="radio" name="hogar_HSBCMDA_opcion" checked="checked">Mercado 50%</label>
						</div>
					</div>
					<div class="form-group">
						<label for="cuales_SLPPDLC">¿Cuáles son los principales problemas de la comunidad?</label>
						<table class="table table-control">
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox">Vivienda</label><br>
											<label><input type="checkbox">Empleo</label><br>
											<label><input type="checkbox">Inseguridad</label>
										</div>
									</div>
								</td>
								<td class="td-center-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox">Servicio de Agua</label><br>
											<label><input type="checkbox">Servicio de luz eléctrica</label><br>
											<label><input type="checkbox">Servicio telefónico</label>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox">Vialidad</label><br>
											<label><input type="checkbox">Red de cloacas</label><br>
											<label><input type="checkbox" id="cuales_SLPPDLC_checkbox_otro" name="cuales_SLPPDLC_checkbox_otro">Otra ¿Cuál?</label>
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" class="form-control" id="cuales_SLPPDLC_otro" name="cuales_SLPPDLC_otro" placeholder="¿Cuál?" style="display: none">
					</div>
				</td>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="numero_TDPEEH">Número total de personas en el hogar</label> 
							<input type="number" class="form-control" id="numero_TDPEEH" name="numero_TDPEEH" min="1">
						</div>
						<div class="form-group">
							<label for="numero_DB">Número de baños</label> 
							<input type="number" class="form-control" id="numero_DB" name="numero_DB" min="0">
						</div>
						<div class="form-group">
							<label for="alguno_DLDDLVD3OMP">¿En alguno de los dormitorios de la vivienda duermen 3 o más personas?</label> 
							<div class="radio">
								<label><input type="radio" name="alguno_DLDDLVD3OMP">Sí</label>
								<label><input type="radio" name="alguno_DLDDLVD3OMP" checked="checked">No</label>
							</div>
						</div>
						<div class="form-group">
							<label for="hogar_U_PDVAL">¿Este hogar utiliza PDVAL?</label> 
							<div class="radio">
								<label><input type="radio" name="hogar_U_PDVAL" id="hogar_U_PDVAL_si">Sí</label>
								<label><input type="radio" name="hogar_U_PDVAL" id="hogar_U_PDVAL_no" checked="checked">No</label>
							</div>
							<select class="form-control" name="hogar_U_PDVAL_select" id="hogar_U_PDVAL_select" style="display: none">
								<option value="1">Diariamente</option>
								<option value="2">Semanalmente</option>
								<option value="3">Quincenalmente</option>
								<option value="4">Mensualmente</option>
								<option value="5">Esporádicamente</option>
							</select>
						</div>
						<div class="form-group">
							<label for="algun_MDHPEUOC">¿Algún miembro del hogar participa en una organización comunitaria?</label> 
							<div class="radio">
								<label><input type="radio" name="algun_MDHPEUOC" id="algun_MDHPEUOC_si">Sí ¿Cuál?</label>
								<label><input type="radio" name="algun_MDHPEUOC" id="algun_MDHPEUOC_no" checked="checked">No</label>
							</div> 
							<input type="text" class="form-control" id="algun_MDHPEUOC_opcion" name="algun_MDHPEUOC_opcion" placeholder="¿Cuál?" style="display: none">
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>

<script>
	$(document).ready(function() {
		
		$('#hogar_UM_si').change(function() {
			$('#hogar_UM_select').show();
		});
		$('#hogar_UM_no').change(function() {
			$('#hogar_UM_select').hide();
		});
		
		$('#hogar_HSBCMDA_si').change(function() {
			$('#hogar_HSBCMDA_grupo').show();
		});
		$('#hogar_HSBCMDA_no').change(function() {
			$('#hogar_HSBCMDA_grupo').hide();
		});
		
		$('#hogar_U_PDVAL_si').change(function() {
			$('#hogar_U_PDVAL_select').show();
		});
		$('#hogar_U_PDVAL_no').change(function() {
			$('#hogar_U_PDVAL_select').hide();
		});
		
		$('#algun_MDHPEUOC_si').change(function() {
			$('#algun_MDHPEUOC_opcion').show();
		});
		$('#algun_MDHPEUOC_no').change(function() {
			$('#algun_MDHPEUOC_opcion').hide();
		});
		
		
		$('#cuales_SLPPDLC_checkbox_otro').on('change', function (e) {
		    if($("#cuales_SLPPDLC_checkbox_otro").is(':checked')){
		    	$('#cuales_SLPPDLC_otro').show();	
		    }else{
		    	$('#cuales_SLPPDLC_otro').hide()
		    }
		});
	});
</script>

<%@ include file="footer.jsp"%>