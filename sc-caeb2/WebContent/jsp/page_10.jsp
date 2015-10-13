
<%@page import="java.util.HashMap"%>
<%@page import="com.caeb2.actions.IndividualCharacteristics"%>
<%@page import="com.caeb2.actions.bean.PersonMissions"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(10);
	Parameters.setTitle("Sección 5: Características individuales - Misiones");

	PersonMissions personMissions = IndividualCharacteristics.loadMissions(request.getRequestedSessionId());
	HashMap<String, String> missions = personMissions.getMissions();
%>

<%@include file="validateCurrentPage.jsp"%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveMissions" method="POST">
		<label for="misionesEducativas">¿Ha asistido o asiste a alguna de las siguientes misiones?</label>
			<table class="table" id="misionesEducativas">
				<tr>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionVuelvanCaras" value="<%=Constants.MISION_VUELVAN_CARAS%>"
											<%=missions.containsKey(Constants.MISION_VUELVAN_CARAS) ? "checked" : ""%>>
									<%=Constants.MISION_VUELVAN_CARAS%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionBarrioAdentroI" value="<%=Constants.MISION_BARRIO_ADENTRO_I%>"
											<%=missions.containsKey(Constants.MISION_BARRIO_ADENTRO_I) ? "checked" : ""%>>
									<%=Constants.MISION_BARRIO_ADENTRO_I%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionBarrioAdentroII" value="<%=Constants.MISION_BARRIO_ADENTRO_II%>"
											<%=missions.containsKey(Constants.MISION_BARRIO_ADENTRO_II) ? "checked" : ""%>>
									<%=Constants.MISION_BARRIO_ADENTRO_II%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="mercalTipoI" value="<%=Constants.MERCAL_TIPO_I%>"
											<%=missions.containsKey(Constants.MERCAL_TIPO_I) ? "checked" : ""%>>
									<%=Constants.MERCAL_TIPO_I%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="mercalTipoII" value="<%=Constants.MERCAL_TIPO_II%>"
											<%=missions.containsKey(Constants.MERCAL_TIPO_II) ? "checked" : ""%>>
									<%=Constants.MERCAL_TIPO_II%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="superMercal" value="<%=Constants.SUPER_MERCAL%>"
											<%=missions.containsKey(Constants.SUPER_MERCAL) ? "checked" : ""%>>
									<%=Constants.SUPER_MERCAL%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="mercalitos" value="<%=Constants.MERCALITOS%>"
											<%=missions.containsKey(Constants.MERCALITOS) ? "checked" : ""%>>
									<%=Constants.MERCALITOS%>
								</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="comedorPopular" value="<%=Constants.COMEDOR_POPULAR%>"
											<%=missions.containsKey(Constants.COMEDOR_POPULAR) ? "checked" : ""%>>
									<%=Constants.COMEDOR_POPULAR%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="comedorEscolar" value="<%=Constants.COMEDOR_ESCOLAR%>"
											<%=missions.containsKey(Constants.COMEDOR_ESCOLAR) ? "checked" : ""%>>
									<%=Constants.COMEDOR_ESCOLAR%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="cocinaComunitaria" value="<%=Constants.COCINA_COMUNITARIA%>"
											<%=missions.containsKey(Constants.COCINA_COMUNITARIA) ? "checked" : ""%>>
									<%=Constants.COCINA_COMUNITARIA%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="fogonComunitaria" value="<%=Constants.FOGON_COMUNITARIO%>"
											<%=missions.containsKey(Constants.FOGON_COMUNITARIO) ? "checked" : ""%>>
									<%=Constants.FOGON_COMUNITARIO%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="casaAlimentacion" value="<%=Constants.CASA_DE_ALIMENTACION%>"
											<%=missions.containsKey(Constants.CASA_DE_ALIMENTACION) ? "checked" : ""%>>
									<%=Constants.CASA_DE_ALIMENTACION%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="casaComunitaria" value="<%=Constants.CASA_COMUNITARIA%>"
											<%=missions.containsKey(Constants.CASA_COMUNITARIA) ? "checked" : ""%>>
									<%=Constants.CASA_COMUNITARIA%>
								</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="boticasPopulares" value="<%=Constants.BOTICAS_POPULARES%>"
											<%=missions.containsKey(Constants.BOTICAS_POPULARES) ? "checked" : ""%>>
									<%=Constants.BOTICAS_POPULARES%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionCultura" value="<%=Constants.MISION_CULTURA%>"
											<%=missions.containsKey(Constants.MISION_CULTURA) ? "checked" : ""%>>
									<%=Constants.MISION_CULTURA%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionHabitat" value="<%=Constants.MISION_HABITAT%>"
											<%=missions.containsKey(Constants.MISION_HABITAT) ? "checked" : ""%>>
									<%=Constants.MISION_HABITAT%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionDeporteAdentro" value="<%=Constants.MISION_DEPORTE_ADENTRO%>"
											<%=missions.containsKey(Constants.MISION_DEPORTE_ADENTRO) ? "checked" : ""%>>
									<%=Constants.MISION_DEPORTE_ADENTRO%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionZamora" value="<%=Constants.MISION_ZAMORA%>"
											<%=missions.containsKey(Constants.MISION_ZAMORA) ? "checked" : ""%>>
									<%=Constants.MISION_ZAMORA%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionGuaicaipuro" value="<%=Constants.MISION_GUAICAIPURO%>"
											<%=missions.containsKey(Constants.MISION_GUAICAIPURO) ? "checked" : ""%>>
									<%=Constants.MISION_GUAICAIPURO%>
								</label><br>
							</div>
						</div>
					</td>
					<td width="25%">
						<div class="form-group">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionIdentidad" value="<%=Constants.MISION_IDENTIDAD%>"
											<%=missions.containsKey(Constants.MISION_IDENTIDAD) ? "checked" : ""%>>
									<%=Constants.MISION_IDENTIDAD%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionPiar" value="<%=Constants.MISION_PIAR%>"
											<%=missions.containsKey(Constants.MISION_PIAR) ? "checked" : ""%>>
									<%=Constants.MISION_PIAR%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionMiranda" value="<%=Constants.MISION_MIRANDA%>"
											<%=missions.containsKey(Constants.MISION_MIRANDA) ? "checked" : ""%>>
									<%=Constants.MISION_MIRANDA%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionMilagro" value="<%=Constants.MISION_MILAGRO%>"
											<%=missions.containsKey(Constants.MISION_MILAGRO) ? "checked" : ""%>>
									<%=Constants.MISION_MILAGRO%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionNegraHipolita" value="<%=Constants.MISION_NEGRA_HIPOLITA%>"
											<%=missions.containsKey(Constants.MISION_NEGRA_HIPOLITA) ? "checked" : ""%>>
									<%=Constants.MISION_NEGRA_HIPOLITA%>
								</label><br>
								<label>
									<input type="checkbox" name="<%=Constants.SECTION10_MISSIONS%>"
											id="misionSimoncito" value="<%=Constants.MISION_SIMONCITO%>"
											<%=missions.containsKey(Constants.MISION_SIMONCITO) ? "checked" : ""%>>
									<%=Constants.MISION_SIMONCITO%>
								</label><br>
							</div>
						</div>
					</td>
				</tr>
			</table>
		<input type="submit" value="Submit" class="btn btn-primary hidden" id="submitBtn<%=Parameters.getPageNumber()%>">
	</form>
	<%@include file="pagination.jsp"%>
</div>

<!-- Add Person -->
<div class="modal fade" id="addPerson" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<br>
			<div class="modal-body text-center" id="addHomeQuestion">
				¿Desea agregar otra persona al hogar?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" id="addPersonYes">
					<%=Constants.JSP_YES%>
				</button>
				<button type="button" class="btn btn-primary" id="addPersonNo">
					<%=Constants.JSP_NO%>
				</button>
			</div>
		</div>
	</div>
</div>

<!-- Add Home -->
<div class="modal fade" id="addHome" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<br>
			<div class="modal-body text-center" id="addHomeQuestion">
				¿Desea agregar otro hogar a la vivienda?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" id="addHomeYes">
					<%=Constants.JSP_YES%>
				</button>
				<button type="button" class="btn btn-primary" id="addHomeNo">
					<%=Constants.JSP_NO%>
				</button>
			</div>
		</div>
	</div>
</div>

<%@include file="loader.jsp"%>

<script type="text/javascript">

	form = $('#form_<%=Parameters.getPageNumber()%>');
	params = '';

	$(document).on('ready', function() {

		form.submit(function(e) {

			e.preventDefault();

			params = '';

			$('#addPerson').modal('show');

		});

		$('#addPersonNo').on('click', function() {

			$('#addPerson').modal('hide');

			$('#addHome').modal('show');

			addParam('<%=Constants.ATT_ADD_PERSON%>', 'false');

		});

		$('#addPersonYes').on('click', function() {

			$('#addPerson').modal('hide');

			addParam('<%=Constants.ATT_ADD_PERSON%>', 'true');

			finish();

		});

		$('#addHomeNo').on('click', function() {

			$('#addHome').modal('hide');

			showLoader();

			addParam('<%=Constants.ATT_ADD_HOME%>', 'false');

			finish();

		});

		$('#addHomeYes').on('click', function() {

			$('#addHome').modal('hide');

			showLoader();

			addParam('<%=Constants.ATT_ADD_HOME%>', 'true');

			finish();

		});

	});

	function addParam(param, value) {
		params += '&' + param + '=' + value;
	}

	function finish() {

		$.ajax({

			url: form.attr('action') + params,
			method: 'POST',
			data: form.serialize(),

			success: function(data, status, xhr) {

				var jsonData = JSON.parse(data);

				window.location.href = jsonData.target
						+ '&' + '<%=Constants.ATT_MESSAGE%>=' + jsonData.response
						+ '&' + '<%=Constants.ATT_NOTIFICATION + "=" + Constants.ALERT_SUCCESS%>';

				hideLoader();

			},

			error: function(xhr, status, error) {

				hideLoader();

				var msg = xhr.responseText == 'null' ?
						'<%=Constants.GENERAL_ERROR%>'
						: xhr.responseText;
				showError(msg);

			}

		});

	}

</script>

<%@include file="footer.jsp"%>
