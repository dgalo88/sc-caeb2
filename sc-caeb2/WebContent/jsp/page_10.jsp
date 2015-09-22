
<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(10);
	Parameters.setTitle("Sección 5: Características individuales - Misiones");
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=index" method="POST">
		<label for="misionesEducativas">¿Ha asistido o asiste a alguna de las siguientes misiones?</label>
			<table class="table" id="misionesEducativas">
				<tr>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label><input type="checkbox" name="misiones" id="misionVuelvanCaras" value="Misión Vuelvan Caras">Misión Vuelvan Caras</label><br>
								<label><input type="checkbox" name="misiones" id="misionBarrioAdentroI" value="Misión Barrio Adentro I">Misión Barrio Adentro I</label><br>
								<label><input type="checkbox" name="misiones" id="misionBarrioAdentroII" value="Misión Barrio Adentro II">Misión Barrio Adentro II</label><br>
								<label><input type="checkbox" name="misiones" id="mercalTipoI" value="Mercal Tipo I">Mercal Tipo I</label><br>
								<label><input type="checkbox" name="misiones" id="mercalTipoII" value="Mercal Tipo II">Mercal Tipo II</label><br>
								<label><input type="checkbox" name="misiones" id="superMercal" value="Super Mercal">Super Mercal</label><br>
								<label><input type="checkbox" name="misiones" id="mercalitos" value="Mercalitos">Mercalitos</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label><input type="checkbox" name="misiones" id="comedorPopular" value="Comedor Popular">Comedor Popular</label><br>
								<label><input type="checkbox" name="misiones" id="comedorEscolar" value="Comedor Escolar">Comedor Escolar</label><br>
								<label><input type="checkbox" name="misiones" id="cocinaComunitaria" value="Cocina Comunitaria">Cocina Comunitaria</label><br>
								<label><input type="checkbox" name="misiones" id="fogonComunitaria" value="Fogón Comunitario">Fogón Comunitario</label><br>
								<label><input type="checkbox" name="misiones" id="casaAlimentacion" value="Casa de Alimentación">Casa de Alimentación</label><br>
								<label><input type="checkbox" name="misiones" id="casaComunitaria" value="Casa Comunitaria">Casa Comunitaria</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label><input type="checkbox" name="misiones" id="boticasPopulares" value="Boticas Populares">Boticas Populares</label><br>
								<label><input type="checkbox" name="misiones" id="misionCultura" value="Misión Cultura">Misión Cultura</label><br>
								<label><input type="checkbox" name="misiones" id="misionHabitat" value="Misión Hábitat">Misión Hábitat</label><br>
								<label><input type="checkbox" name="misiones" id="misionDeporteAdentro" value="Misión Deporte Adentro">Misión Deporte Adentro</label><br>
								<label><input type="checkbox" name="misiones" id="misionZamora" value="Misión Zamora">Misión Zamora</label><br>
								<label><input type="checkbox" name="misiones" id="misionGuaicaipuro" value="Misión Guaicaipuro">Misión Guaicaipuro</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label><input type="checkbox" name="misiones" id="misionIdentidad" value="Misión Identidad">Misión Identidad</label><br>
								<label><input type="checkbox" name="misiones" id="misionPiar" value="Misión Piar">Misión Piar</label><br>
								<label><input type="checkbox" name="misiones" id="misionMiranda" value="Misión Miranda">Misión Miranda</label><br>
								<label><input type="checkbox" name="misiones" id="misionMilagro" value="Misión Milagro">Misión Milagro</label><br>
								<label><input type="checkbox" name="misiones" id="misionNegraHipolita" value="Misión Negra Hipólita">Misión Negra Hipólita</label><br>
								<label><input type="checkbox" name="misiones" id="misionSimoncito" value="Misión Simoncito">Misión Simoncito</label><br>
							</div>
						</div>
					</td>
				</tr>
			</table>
		<input type="submit" value="Finalizar">
<%-- 		<input type="submit" value="Submit" class="btn btn-primary hidden" id="submitBtn<%=Parameters.getPageNumber()%>"> --%>
	</form>
	<%@include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		

	});
</script>

<%@ include file="footer.jsp"%>
