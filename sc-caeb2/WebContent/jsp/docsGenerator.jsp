<%@page import="com.caeb2.util.TextUtils"%>
<%@ include file="header.jsp"%>

<%@page import="com.caeb2.util.Constants"%>
<%-- <%@ include file="navbar.jsp"%> --%>

<script src="/sc-caeb2/js/jquery.print.js"></script>

<div class="container-fluid">
	<form class="form-group" id="form_docs" name="form_docs"
			action="<%=Constants.EXEC_ACTION%>loadFormalityData" method="POST">
		<table class="table container" style="width: 50%;">
			<tr>
				<td>
					<div class="form-group">
						<label for="cedula">Ingrese la cédula de identidad:</label>
						<div class="form-inline" id="cedula">
							<select class="form-control" id="<%=Constants.SECTION5_CEDULA_TYPE%>"
									name="<%=Constants.SECTION5_CEDULA_TYPE%>">
								<option>V</option>
								<option>E</option>
							</select>
								<input type="number" class="form-control" placeholder="Ej. 16465123" min="1"
										id="<%=Constants.SECTION5_CEDULA_NUM%>" name="<%=Constants.SECTION5_CEDULA_NUM%>"
										required>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="formlalityType">Seleccione el tipo de trámite</label>
							<select class="form-control" id="formlalityType" name="formlalityType">
								<option>Legal</option>
								<option>Bancario</option>
								<option>Bla bla bla</option>
								<option>Ble ble ble</option>
							</select>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="docType">Seleccione quien firma</label>
							<select class="form-control" id="docSignature" name="docSignature">
								<option>Anni SinApellido</option>
								<option>José Ivan González</option>
							</select>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="docType">Seleccione el tipo de documento</label>
							<select class="form-control" id="docType" name="docType">
								<option><%=Constants.JSP_RES_PROOF%></option>
								<option><%=Constants.JSP_RES_PROOF_LOW_INCOME%></option>
							</select>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="form-group text-center">
						<button type="submit" class="btn btn-primary" id="generateBtn">
							Generar
						</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>

<!-- Modal -->
<div class="modal fade" id="modalDoc" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="modalTitle"></h4>
			</div>
			<div class="modal-body" id="modalBody">
				<table class="table table-control" id="residenceCard">
					<tr>
						<th class="td-left-control" width="20%">
							<img src="/sc-caeb2/images/logoccaeb2New.png" width="100px" height="100px"
									class="img-responsive text-left" alt="logoccaeb2New">
						</th>
						<th class="td-right-control text-center" width="60%" colspan="2">
							República Bolivariana de Venezuela<br>
							<%=Constants.CCAEB2%><br>
							Parroquia Milla<br>
							Municipio Libertador<br>
							Mérida, Estado Mérida
						</th>
						<th class="td-right-control" width="20%">
							<img src="/sc-caeb2/images/headerLogoRight.png" width="150px"
									class="img-responsive text-right" alt="headerLogoRight">
						</th>
					</tr>
					<tr>
						<td class="text-center" colspan="4"><br><h4 id="formalityName"></h4></td>
					</tr>
					<tr>
						<td class="text-justify" colspan="4" id="docIntro">
							<br>
							Quienes suscriben miembros del "<%=Constants.CCAEB2%>"
							de la Parroquia Milla, Municipio Libertador del Estado Mérida,
							hacemos constar que
						</td>
					</tr>
					<tr>
						<td class="text-center" colspan="4"><h4 id="personName"></h4></td>
					</tr>
					<tr>
						<td class="text-justify" colspan="4" id="docContent">
							<br>
						</td>
					</tr>
					<tr>
						<td class="text-justify" colspan="4" id="docDate"></td>
					</tr>
					<tr>
						<td class="text-left" colspan="2">
							<br><br>
							__________________
							<br>
							Angela Maldonado<br>
							Unidad Administrativa
						</td>
						<td class="text-right" colspan="2">
							<br><br>
							__________________
							<br>
							José Iván González<br>
							Unidad Administrativa
						</td>
					</tr>
					<tr>
						<td class="text-justify" colspan="4"><br>Válido por seis meses.</td>
					</tr>
					<tr>
						<td class="footer text-center text-muted" colspan="4">
							<br><%=Constants.DIR_CCAEB2%>
						</td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" id="closeModalBtn">Cerrar</button>
				<button type="button" class="btn btn-primary" id="printModalBtn">Imprimir</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

	month = new Array();
	
	month[0] = "enero";
	month[1] = "febrero";
	month[2] = "marzo";
	month[3] = "abril";
	month[4] = "mayo";
	month[5] = "junio";
	month[6] = "julio";
	month[7] = "agosto";
	month[8] = "septiembre";
	month[9] = "octubre";
	month[10] = "noviembre";
	month[11] = "diciembre";

	$(document).ready(function() {

		$('#form_docs').submit(function(event) {

			hideNotification();

			event.preventDefault();

			$.ajax({

				url: $('#form_docs').attr('action'),
				method: 'POST',
				data: $('#form_docs').serialize(),

				success: function(data, status, xhr) {
					loadDocData(JSON.parse(data));
					$('#modalDoc').modal('show');
				},

				error: function(xhr, status, error) {

					var msg = xhr.responseText == 'null' ?
							'<%=Constants.GENERAL_ERROR%>'
							: xhr.responseText;
					showError(msg);

				}

			});

		});

		$('#printModalBtn').on('click', function() {
			$('#modalBody').print();
		});

	});

	function loadDocData(data) {

		$('#modalTitle').text($('#docType').val());
		$('#formalityName').text($('#docType').val());
		$('#personName').text(data.names + ' ' + data.lastnames);

		var date = new Date();

		var content = '_NAC, mayor de edad, _POR de la Cédula de Identidad Nº _CED,'
			+ ' damos fe de que _LO conocemos de vista, trato y comunicación;'
			+ ' y por el conocimiento hacia _EL nos consta que tiene su residencia en la siguiente dirección: _DIR,'
			+ ' <%=Constants.SECTOR_AEB%>, que pertenece al ámbito geográfico del "<%=Constants.CCAEB2%>".'

		if ($('#docType').val() == '<%=Constants.JSP_RES_PROOF_LOW_INCOME%>') {
			content += ' Nos consta además que es una persona de bajos recursos económicos.';
		}

		var date = 'Constancia que se expide a solicitud de la parte interesada, para trámite _FTY, '
			+ 'en la ciudad de Mérida, el día ' + date.getDate() + ' de ' + month[date.getMonth()] + ' de ' + date.getFullYear() + '.';

		date = date.replace('_FTY', $('#formlalityType').val().toLowerCase());

		content = content.replace('_CED', $('#<%=Constants.SECTION5_CEDULA_NUM%>').val());
		content = content.replace('_DIR', data.direction);

		if (data.sex == 'F') {

			$("#docIntro").append(' la ciudadana,');

			content = content.replace('_NAC', 'Venezolana')
							 .replace('_POR', 'portadora')
							 .replace('_LO', 'la')
							 .replace('_EL', 'ella');

		} else if (data.sex == 'M') {

			$('#docIntro').append(' el ciudadano,');

			content = content.replace('_NAC', 'Venezolano')
							 .replace('_POR', 'portador')
							 .replace('_LO', 'lo')
							 .replace('_EL', 'él');

		} else {

			$('#docIntro').append(' el ciudadano (a),');

			content = content.replace('_NAC', 'Venezolano (a)')
							 .replace('_POR', 'portador (a)')
							 .replace('_LO', 'lo (a)')
							 .replace('_EL', 'él (ella)');

		}

		$('#docContent').append(content);
		$('#docDate').append(date);

	}
</script>

<%@ include file="footer.jsp"%>
