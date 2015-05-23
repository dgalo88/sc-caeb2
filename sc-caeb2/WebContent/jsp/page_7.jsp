<%@ include file="header.jsp"%>

<%
	int pageNumber = 7;
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group">
		<table class="table">
			<tr>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="ultimo_GA">Último grado aprobado</label> 
							<div class="radio">
								<label><input type="radio" name="ultimo_GA" id="ultimo_GA_NE" checked="checked">Nivel  educativo</label>
								<label><input type="radio" name="ultimo_GA" id="ultimo_GA_GSA">Grado, semestre o año</label>
							</div>
							<select class="form-control" name="ultimo_GA_select" id="ultimo_GA_select">
								<option value="Ninguno">Ninguno</option>
								<option value="Preescolar">Preescolar</option>
								<option value="Básico (1-9) / Primaria (1-6)">Básico (1-9) / Primaria (1-6)</option>
								<option value="Educación especial">Educación especial</option>
								<option value="Media (1-2) / Bachillerato">Media (1-2) / Bachillerato</option>
								<option value="Técnico Medio (1-3)">Técnico Medio (1-3)</option>
								<option value="Técnico Superior">Técnico Superior</option>
								<option value="Universitario">Universitario</option>
							</select>
							<input type="number" required class="form-control" id="ultimo_GA_text" name="ultimo_GA_text" placeholder="Grado, semestre o año" style="display: none">
						</div>
						<div class="form-group">
							<label for="usted_SE">Ud. Se encuentra</label> 
							<select class="form-control" name="usted_SE_select" id="usted_SE_select">
								<option>Trabajando</option>
								<option>Sin trabajar pero tiene trabajo</option>
								<option>Buscando trabajo habiendo trabajado antes</option>
								<option>Buscando trabajo por primera vez</option>
								<option>En quehaceres del hogar</option>
								<option>Estudiando sin trabajo</option>
								<option>Como pensionado o jubilado sin trabajar</option>
								<option>Otra situación</option>
							</select>
						</div>
						<div class="form-group">
							<label for="usted_E">¿Ud. Es?</label> 
							<div class="radio">
								<label><input type="radio" name="usted_E" id="usted_E_EUO" checked="checked">Empleado(a) u obrero(a)</label>
								<label><input type="radio" name="usted_E" id="usted_E_otro">Otro</label>
							</div>
							<select class="form-control" name="usted_E_EUO_select" id="usted_E_EUO_select">
								<option value="Fijo(a)">Fijo(a)</option>
								<option value="Contratado(a)">Contratado(a)</option>
								<option value="Ocasional">Ocasional</option>
							</select>
							<select class="form-control" name="usted_E_otro_select" id="usted_E_otro_select" style="display: none">
								<option value="Trabajador(a) por cuenta propia">Trabajador(a) por cuenta propia</option>
								<option value="Empleador(a) o patrono(a)">Empleador(a) o patrono(a)</option>
								<option value="Miembro de  cooperativa">Miembro de  cooperativa</option>
								<option value="Ayudante familiar o no remunerado">Ayudante familiar o no remunerado</option>
								<option value="Servicio doméstico">Servicio doméstico</option>
							</select>
						</div>
						<div class="form-group">
							<label for="desempena_ST">Desempeña su trabajo:</label> 
							<select class="form-control" name="desempena_ST_select" id="desempena_ST_select">
								<option value="Dentro de la vivienda">Dentro de la vivienda</option>
								<option value="En local anexo a la vivienda">En local anexo a la vivienda</option>
								<option value="En local o lugar exclusivo">En local o lugar exclusivo</option>
								<option value="En la calle (buhonero, puesto callejero, ...)">En la calle (buhonero, puesto callejero, ...)</option>
								<option value="En kiosco">En kiosco</option>
								<option value="En mercado">En mercado</option>
								<option value="En vehículo">En vehículo</option>
								<option value="Servicio a domicilio">Servicio a domicilio</option>
							</select>
						</div>
						<div class="form-group">
							<label for="parte_DTUOQDUTHPDOA">¿A parte del trabajo u oficio que desempeña Ud. tiene habilidades para desempeñar otra actividad?</label>
							<div class="radio">
								<label><input type="radio" name="parte_DTUOQDUTHPDOA" id="parte_DTUOQDUTHPDOA_si">Sí ¿Cuál?</label>
								<label><input type="radio" name="parte_DTUOQDUTHPDOA" id="parte_DTUOQDUTHPDOA_no" checked="checked">No</label>
							</div>
							<input type="text" required class="form-control" id="parte_DTUOQDUTHPDOA_text" name="parte_DTUOQDUTHPDOA_text" style="display: none">
						</div>
					</div>
				</td>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="profesion">Profesión</label> 
							<input type="text" class="form-control" id="profesion" name="profesion" placeholder="Ej: Educador">
						</div>
						<div class="form-group">
							<label for="cual_ESOOCDTP">¿Cuál es su oficio o clase de trabajo principal?</label> 
							<input type="text" class="form-control" id="cual_ESOOCDTP" name="cual_ESOOCDTP" placeholder="Ej: Educador">
						</div>
						<div class="form-group">
							<label for="negocio_OOEDTE">El negocio, organismo o empresa donde trabaja es:</label> 
							<div class="radio">
								<label><input type="radio" name="negocio_OOEDTE" id="negocio_OOEDTE" checked="checked">Privado</label>
								<label><input type="radio" name="negocio_OOEDTE" id="negocio_OOEDTE">Público</label>
							</div>
						</div>
						<div class="form-group">
							<label for="cual_ESIM">¿Cuál es su ingreso mensual?</label> 
							<select class="form-control" name="cual_ESIM_select" id="cual_ESIM_select">
								<option value="Menor o igual a 1 salario">Menor o igual a 1 salario</option>
								<option value="Menor o igual a 2 salarios">Menor o igual a 2 salarios</option>
								<option value="Menor o igual a 3 salarios">Menor o igual a 3 salarios</option>
								<option value="Mayor a 3 salarios">Mayor a 3 salarios</option>
							</select>
						</div>
						<div class="form-group">
							<label for="ultimo_2AHRAC">En los últimos 2 años, ha recibido algún crédito</label> 
							<div class="radio">
								<label><input type="radio" name="ultimo_2AHRAC" id="ultimo_2AHRAC_si">Sí ¿Cuál instituto lo otorgo?</label>
								<label><input type="radio" name="ultimo_2AHRAC" id="ultimo_2AHRAC_no" checked="checked">No</label>
							</div>
							<select class="form-control" name="ultimo_2AHRAC_select" id="ultimo_2AHRAC_select" style="display: none">
								<option value="Alcaldía">Alcaldía</option>
								<option value="Banco de la mujer">Banco de la mujer</option>
								<option value="Banco del pueblo">Banco del pueblo</option>
								<option value="Banco industrial de Venezuela">Banco industrial de Venezuela</option>
								<option value="Bancas universales y comerciales">Bancas universales y comerciales</option>
								<option value="BANDES">BANDES</option>
								<option value="FONDAFA">FONDAFA</option>
								<option value="FONDEMI">FONDEMI</option>
								<option value="FOMDES">FOMDES</option>
								<option value="Otra ¿Cuál?">Otra ¿Cuál?</option>
							</select>
						</div>
						<div class="form-group">
							<input type="text" required class="form-control" id="ultimo_2AHRAC_text" name="ultimo_2AHRAC_text" placeholder="¿Cuál?" style="display: none">
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
		$('#ultimo_GA_NE').change(function() {
			$('#ultimo_GA_select').show();
			$('#ultimo_GA_text').hide();
		});
		$('#ultimo_GA_GSA').change(function() {
			$('#ultimo_GA_text').show();
			$('#ultimo_GA_select').hide();
		});
		
		
		$('#usted_E_EUO').change(function() {
			$('#usted_E_EUO_select').show();
			$('#usted_E_otro_select').hide();
		});
		$('#usted_E_otro').change(function() {
			$('#usted_E_otro_select').show();
			$('#usted_E_EUO_select').hide();
		});
		
		$('#parte_DTUOQDUTHPDOA_si').change(function() {
			$('#parte_DTUOQDUTHPDOA_text').show();
		});
		$('#parte_DTUOQDUTHPDOA_no').change(function() {
			$('#parte_DTUOQDUTHPDOA_text').hide();
		});
		
		$('#ultimo_2AHRAC_si').change(function() {
			$('#ultimo_2AHRAC_select').show();
		});
		$('#ultimo_2AHRAC_no').change(function() {
			$('#ultimo_2AHRAC_select').hide();
		});
		
		$('#ultimo_2AHRAC_select').on('change', function (e) {
		    var valueSelected = this.value;
		    if(valueSelected=='Otra ¿Cual?'){
		    	$('#ultimo_2AHRAC_text').show();	
		    }else{
		    	$('#ultimo_2AHRAC_text').hide()
		    }
		});
		
	});
</script>

<%@ include file="footer.jsp"%>
