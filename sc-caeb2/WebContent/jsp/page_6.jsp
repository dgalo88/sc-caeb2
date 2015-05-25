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
						<label for="esAnalfabeta">�Sabe leer y escribir?</label>
						<div class="radio">
							<label><input type="radio" name="esAnalfabeta" id="siEsAnalfabeta" value="S�">S�</label>
							<label><input type="radio" name="esAnalfabeta" id="noEsAnalfabeta" value="No">No</label>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="asisteEstEduc">�Asiste actualmente en calidad de estudiante a alg�n establecimiento de educaci�n?</label>
						<div class="radio">
							<label><input type="radio" name="asisteEstEduc" id="siAsisteEstEduc" value="S�">S�</label>
							<label><input type="radio" name="asisteEstEduc" id="noAsisteEstEduc" value="No">No</label>
						</div>
						<div class="form-group hidden" id="cualEst">
							<label for="cualEstEduc">�Cu�l?</label>
							<div class="radio">
								<label><input type="radio" name="cualEstEduc" id="oficial" value="Oficial">Oficial</label>
								<label><input type="radio" name="cualEstEduc" id="privado" value="Privado">Privado</label>
							</div>
						</div>
						<div class="form-group hidden" id="porQueNo">
							<label for="porQueNoAsiste">�Por qu� raz�n no asiste a un establecimiento de educaci�n?</label>
							<input type="text" class="form-control" placeholder="Ej. Falta de recursos econ�micos"
									id="porQueNoAsiste" name="porQueNoAsiste">
						</div>
					</div>
				</td>
			</tr>
		</table>

		<div class="form-group">
			<label for="misionesEducativas">�Ha asistido a alguna de las misiones educativas?</label>
			<div class="checkbox" id="misionesEducativas">
				<table class="table">
					<tr>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="noMision" value="No">No</label><br>
							<label><input type="checkbox" name="misiones" id="misionRobinsonI" value="Misi�n Robinson I">Misi�n Robinson I</label><br>
							<label><input type="checkbox" name="misiones" id="misionRobinsonII" value="Misi�n Robinson II">Misi�n Robinson II</label><br>
							<label><input type="checkbox" name="misiones" id="misionRibas" value="Misi�n Ribas">Misi�n Ribas</label><br>
							<label><input type="checkbox" name="misiones" id="misionSucre" value="Misi�n Sucre">Misi�n Sucre</label><br>
							<label><input type="checkbox" name="misiones" id="misionVuelvanCaras" value="Misi�n Vuelvan Caras">Misi�n Vuelvan Caras</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="misionBarrioAdentroI" value="Misi�n Barrio Adentro I">Misi�n Barrio Adentro I</label><br>
							<label><input type="checkbox" name="misiones" id="misionBarrioAdentroII" value="Misi�n Barrio Adentro II">Misi�n Barrio Adentro II</label><br>
							<label><input type="checkbox" name="misiones" id="mercalTipoI" value="Mercal Tipo I">Mercal Tipo I</label><br>
							<label><input type="checkbox" name="misiones" id="mercalTipoII" value="Mercal Tipo II">Mercal Tipo II</label><br>
							<label><input type="checkbox" name="misiones" id="superMercal" value="Super Mercal">Super Mercal</label><br>
							<label><input type="checkbox" name="misiones" id="mercalitos" value="Mercalitos">Mercalitos</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="comedorPopular" value="Comedor Popular">Comedor Popular</label><br>
							<label><input type="checkbox" name="misiones" id="comedorEscolar" value="Comedor Escolar">Comedor Escolar</label><br>
							<label><input type="checkbox" name="misiones" id="cocinaComunitaria" value="Cocina Comunitaria">Cocina Comunitaria</label><br>
							<label><input type="checkbox" name="misiones" id="fogonComunitaria" value="Fog�n Comunitario">Fog�n Comunitario</label><br>
							<label><input type="checkbox" name="misiones" id="casaAlimentacion" value="Casa de Alimentaci�n">Casa de Alimentaci�n</label><br>
							<label><input type="checkbox" name="misiones" id="casaComunitaria" value="Casa Comunitaria">Casa Comunitaria</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="boticasPopulares" value="Boticas Populares">Boticas Populares</label><br>
							<label><input type="checkbox" name="misiones" id="misionCultura" value="Misi�n Cultura">Misi�n Cultura</label><br>
							<label><input type="checkbox" name="misiones" id="misionHabitat" value="Misi�n H�bitat">Misi�n H�bitat</label><br>
							<label><input type="checkbox" name="misiones" id="misionDeporteAdentro" value="Misi�n Deporte Adentro">Misi�n Deporte Adentro</label><br>
							<label><input type="checkbox" name="misiones" id="misionZamora" value="Misi�n Zamora">Misi�n Zamora</label><br>
							<label><input type="checkbox" name="misiones" id="misionGuaicaipuro" value="Misi�n Guaicaipuro">Misi�n Guaicaipuro</label><br>
						</td>
						<td width="20%">
							<label><input type="checkbox" name="misiones" id="misionIdentidad" value="Misi�n Identidad">Misi�n Identidad</label><br>
							<label><input type="checkbox" name="misiones" id="misionPiar" value="Misi�n Piar">Misi�n Piar</label><br>
							<label><input type="checkbox" name="misiones" id="misionMiranda" value="Misi�n Miranda">Misi�n Miranda</label><br>
							<label><input type="checkbox" name="misiones" id="misionMilagro" value="Misi�n Milagro">Misi�n Milagro</label><br>
							<label><input type="checkbox" name="misiones" id="misionNegraHipolita" value="Misi�n Negra Hip�lita">Misi�n Negra Hip�lita</label><br>
							<label><input type="checkbox" name="misiones" id="misionSimoncito" value="Misi�n Simoncito">Misi�n Simoncito</label><br>
						</td>
					</tr>
				</table>
			</div>
		</div>

		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="cursoCapacitacion">�Est� realizando alg�n curso de capacitaci�n?</label>
						<div class="radio">
							<label><input type="radio" name="cursoCapacitacion" id="siCursoCapacitacion" value="S�">S�</label>
							<label><input type="radio" name="cursoCapacitacion" id="noCursoCapacitacion" value="No">No</label>
						</div>
						<div class="form-group hidden" id="cualCursoCap">
							<label for="cualCursoCapacitacion">�Cu�l?</label>
							<input type="text" class="form-control" placeholder="Ej. Reparaci�n de computadoras"
									id="cualCursoCapacitacion" name="cualCursoCapacitacion">
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="recibeBeca">�Recibe alguna beca o ayuda econ�mica?</label>
						<div class="radio">
							<label><input type="radio" name="recibeBeca" id="siRecibeBeca" value="S�">S�</label>
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
