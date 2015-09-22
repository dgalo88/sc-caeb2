
<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(10);
	Parameters.setTitle("Secci�n 5: Caracter�sticas individuales - Misiones");
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=index" method="POST">
		<label for="misionesEducativas">�Ha asistido o asiste a alguna de las siguientes misiones?</label>
			<table class="table" id="misionesEducativas">
				<tr>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label><input type="checkbox" name="misiones" id="misionVuelvanCaras" value="Misi�n Vuelvan Caras">Misi�n Vuelvan Caras</label><br>
								<label><input type="checkbox" name="misiones" id="misionBarrioAdentroI" value="Misi�n Barrio Adentro I">Misi�n Barrio Adentro I</label><br>
								<label><input type="checkbox" name="misiones" id="misionBarrioAdentroII" value="Misi�n Barrio Adentro II">Misi�n Barrio Adentro II</label><br>
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
								<label><input type="checkbox" name="misiones" id="fogonComunitaria" value="Fog�n Comunitario">Fog�n Comunitario</label><br>
								<label><input type="checkbox" name="misiones" id="casaAlimentacion" value="Casa de Alimentaci�n">Casa de Alimentaci�n</label><br>
								<label><input type="checkbox" name="misiones" id="casaComunitaria" value="Casa Comunitaria">Casa Comunitaria</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label><input type="checkbox" name="misiones" id="boticasPopulares" value="Boticas Populares">Boticas Populares</label><br>
								<label><input type="checkbox" name="misiones" id="misionCultura" value="Misi�n Cultura">Misi�n Cultura</label><br>
								<label><input type="checkbox" name="misiones" id="misionHabitat" value="Misi�n H�bitat">Misi�n H�bitat</label><br>
								<label><input type="checkbox" name="misiones" id="misionDeporteAdentro" value="Misi�n Deporte Adentro">Misi�n Deporte Adentro</label><br>
								<label><input type="checkbox" name="misiones" id="misionZamora" value="Misi�n Zamora">Misi�n Zamora</label><br>
								<label><input type="checkbox" name="misiones" id="misionGuaicaipuro" value="Misi�n Guaicaipuro">Misi�n Guaicaipuro</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label><input type="checkbox" name="misiones" id="misionIdentidad" value="Misi�n Identidad">Misi�n Identidad</label><br>
								<label><input type="checkbox" name="misiones" id="misionPiar" value="Misi�n Piar">Misi�n Piar</label><br>
								<label><input type="checkbox" name="misiones" id="misionMiranda" value="Misi�n Miranda">Misi�n Miranda</label><br>
								<label><input type="checkbox" name="misiones" id="misionMilagro" value="Misi�n Milagro">Misi�n Milagro</label><br>
								<label><input type="checkbox" name="misiones" id="misionNegraHipolita" value="Misi�n Negra Hip�lita">Misi�n Negra Hip�lita</label><br>
								<label><input type="checkbox" name="misiones" id="misionSimoncito" value="Misi�n Simoncito">Misi�n Simoncito</label><br>
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
