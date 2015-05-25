<%@ include file="header.jsp"%>

<%
	int pageNumber = 6;
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=pageNumber%>" name="form_<%=pageNumber%>">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="esAnalfabeta">¿Sabe leer y escribir?</label>
						<div class="radio">
							<label><input type="radio" name="esAnalfabeta" id="siEsAnalfabeta" value="Sí">Sí</label>
							<label><input type="radio" name="esAnalfabeta" id="noEsAnalfabeta" value="No">No</label>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="asisteEstEduc">¿Asiste actualmente en calidad de estudiante a algún establecimiento de educación?</label>
						<div class="radio">
							<label><input type="radio" name="asisteEstEduc" id="siAsisteEstEduc" value="Sí">Sí</label>
							<label><input type="radio" name="asisteEstEduc" id="noAsisteEstEduc" value="No">No</label>
						</div>
						<div class="form-group hidden" id="cualEst">
							<label for="cualEstEduc">¿Cuál?</label>
							<div class="radio">
								<label><input type="radio" name="cualEstEduc" id="oficial" value="Oficial">Oficial</label>
								<label><input type="radio" name="cualEstEduc" id="privado" value="Privado">Privado</label>
							</div>
						</div>
						<div class="form-group hidden" id="porQueNo">
							<label for="porQueNoAsiste">¿Por qué razón no asiste a un establecimiento de educación?</label>
							<input type="text" class="form-control" placeholder="Ej. Falta de recursos económicos"
									id="porQueNoAsiste" name="porQueNoAsiste">
						</div>
					</div>
				</td>
			</tr>
		</table>

		<div class="form-group">
			<label for="misionesEducativas">¿Ha asistido a alguna de las misiones educativas?</label>
			<div class="checkbox" id="misionesEducativas">
				<table class="table">
					<tr>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="noMision" value="No">No</label><br>
							<label><input type="checkbox" name="misiones" id="misionRobinsonI" value="Misión Robinson I">Misión Robinson I</label><br>
							<label><input type="checkbox" name="misiones" id="misionRobinsonII" value="Misión Robinson II">Misión Robinson II</label><br>
							<label><input type="checkbox" name="misiones" id="misionRibas" value="Misión Ribas">Misión Ribas</label><br>
							<label><input type="checkbox" name="misiones" id="misionSucre" value="Misión Sucre">Misión Sucre</label><br>
							<label><input type="checkbox" name="misiones" id="misionVuelvanCaras" value="Misión Vuelvan Caras">Misión Vuelvan Caras</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="misionBarrioAdentroI" value="Misión Barrio Adentro I">Misión Barrio Adentro I</label><br>
							<label><input type="checkbox" name="misiones" id="misionBarrioAdentroII" value="Misión Barrio Adentro II">Misión Barrio Adentro II</label><br>
							<label><input type="checkbox" name="misiones" id="mercalTipoI" value="Mercal Tipo I">Mercal Tipo I</label><br>
							<label><input type="checkbox" name="misiones" id="mercalTipoII" value="Mercal Tipo II">Mercal Tipo II</label><br>
							<label><input type="checkbox" name="misiones" id="superMercal" value="Super Mercal">Super Mercal</label><br>
							<label><input type="checkbox" name="misiones" id="mercalitos" value="Mercalitos">Mercalitos</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="comedorPopular" value="Comedor Popular">Comedor Popular</label><br>
							<label><input type="checkbox" name="misiones" id="comedorEscolar" value="Comedor Escolar">Comedor Escolar</label><br>
							<label><input type="checkbox" name="misiones" id="cocinaComunitaria" value="Cocina Comunitaria">Cocina Comunitaria</label><br>
							<label><input type="checkbox" name="misiones" id="fogonComunitaria" value="Fogón Comunitario">Fogón Comunitario</label><br>
							<label><input type="checkbox" name="misiones" id="casaAlimentacion" value="Casa de Alimentación">Casa de Alimentación</label><br>
							<label><input type="checkbox" name="misiones" id="casaComunitaria" value="Casa Comunitaria">Casa Comunitaria</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="boticasPopulares" value="Boticas Populares">Boticas Populares</label><br>
							<label><input type="checkbox" name="misiones" id="misionCultura" value="Misión Cultura">Misión Cultura</label><br>
							<label><input type="checkbox" name="misiones" id="misionHabitat" value="Misión Hábitat">Misión Hábitat</label><br>
							<label><input type="checkbox" name="misiones" id="misionDeporteAdentro" value="Misión Deporte Adentro">Misión Deporte Adentro</label><br>
							<label><input type="checkbox" name="misiones" id="misionZamora" value="Misión Zamora">Misión Zamora</label><br>
							<label><input type="checkbox" name="misiones" id="misionGuaicaipuro" value="Misión Guaicaipuro">Misión Guaicaipuro</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="misionIdentidad" value="Misión Identidad">Misión Identidad</label><br>
							<label><input type="checkbox" name="misiones" id="misionPiar" value="Misión Piar">Misión Piar</label><br>
							<label><input type="checkbox" name="misiones" id="misionMiranda" value="Misión Miranda">Misión Miranda</label><br>
							<label><input type="checkbox" name="misiones" id="misionMilagro" value="Misión Milagro">Misión Milagro</label><br>
							<label><input type="checkbox" name="misiones" id="misionNegraHipolita" value="Misión Negra Hipólita">Misión Negra Hipólita</label><br>
							<label><input type="checkbox" name="misiones" id="misionSimoncito" value="Misión Simoncito">Misión Simoncito</label><br>
						</td>
					</tr>
				</table>
			</div>
		</div>

		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="cursoCapacitacion">¿Está realizando algún curso de capacitación?</label>
						<div class="radio">
							<label><input type="radio" name="cursoCapacitacion" id="siCursoCapacitacion" value="Sí">Sí</label>
							<label><input type="radio" name="cursoCapacitacion" id="noCursoCapacitacion" value="No">No</label>
						</div>
						<div class="form-group hidden" id="cualCursoCap">
							<label for="cualCursoCapacitacion">¿Cuál?</label>
							<input type="text" class="form-control" placeholder="Ej. Reparación de computadoras"
									id="cualCursoCapacitacion" name="cualCursoCapacitacion">
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="recibeBeca">¿Recibe alguna beca o ayuda económica?</label>
						<div class="radio">
							<label><input type="radio" name="recibeBeca" id="siRecibeBeca" value="Sí">Sí</label>
							<label><input type="radio" name="recibeBeca" id="noRecibeBeca" value="No">No</label>
						</div>
						<div class="form-group hidden" id="espBeca">
							<label for="especifiqueBeca">Especifique: </label>
							<input type="text" class="form-control" placeholder="Ej. Fundayacucho"
									id="especifiqueBeca" name="especifiqueBeca">
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form><%@ include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$('#siAsisteEstEduc').on('click', function() {
			$('#porQueNo').removeClass('show').addClass('hidden');
			$('#cualEst').removeClass('hidden').addClass('show');
		});

		$('#noAsisteEstEduc').on('click', function() {
			$('#cualEst').removeClass('show').addClass('hidden');
			$('#porQueNo').removeClass('hidden').addClass('show');
		});

		$('#noMision').on('mousedown', function() {

			if ($("#noMision").is(':checked')) {
	 			$('#noMision').removeAttr('checked');
			} else {
				$('input[name="misiones"]').removeAttr('checked');
	 			$('#noMision').attr('checked', 'checked');
			}

		});

		$('input[name="misiones"]').on('click', function() {

			if ($(this).val() == $("#noMision").val()) {
				return;
			}

			if ($("#noMision").is(':checked')) {
	 			$('#noMision').removeAttr('checked');
			}

		});

		$('#siCursoCapacitacion').on('click', function() {
			$('#cualCursoCap').removeClass('hidden').addClass('show');
		});

		$('#noCursoCapacitacion').on('click', function() {
			$('#cualCursoCap').removeClass('show').addClass('hidden');
		});

		$('#siRecibeBeca').on('click', function() {
			$('#espBeca').removeClass('hidden').addClass('show');
		});

		$('#noRecibeBeca').on('click', function() {
			$('#espBeca').removeClass('show').addClass('hidden');
		});

	});
</script>

<%@ include file="footer.jsp"%>
