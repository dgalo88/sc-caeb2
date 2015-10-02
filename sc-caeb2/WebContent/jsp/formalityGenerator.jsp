<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.TextUtils"%>
<%@page import="com.caeb2.util.Constants"%>

<%@include file="header.jsp"%>

<%
	Parameters.setTitle(Constants.JSP_GEN_FORMALITY);
%>

<%@include file="navbar.jsp"%>

<script src="/sc-caeb2/js/jquery.print.js"></script>

<div class="container-fluid">
	<form class="form-group" id="form_docs" name="form_docs"
			action="<%=Constants.EXEC_ACTION%>loadFormalityData" method="POST">
		<table class="table container" style="width: 50%;">
			<tr>
				<td>
					<div class="form-group">
						<label for="cedula">Ingrese la c�dula de identidad:</label>
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
							<label for="formlalityType">Seleccione el tipo de tr�mite</label>
							<select class="form-control" id="formlalityType" name="formlalityType">
								<option>Social</option>
								<option>Bancario</option>
								<option>Personal</option>
								<option>Legal</option>
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
							<select class="form-control" id="docSigner" name="docSigner">
								<option>Ani Villarreal</option>
								<option>Jos� Ivan Gonz�lez</option>
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
					<div class="form-group text-center btn-footer">
						<a href="<%=Constants.ACTION_HOME%>">
							<button type="button" class="btn btn-default" id="backBtn">
								<%=Constants.JSP_COMEBACK%>
							</button>
						</a>
						<button type="submit" class="btn btn-primary" id="generateBtn">
							<%=Constants.JSP_GENERATE%>
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
				<button type="button" class="close" data-dismiss="modal"
						aria-label="<%=Constants.JSP_CLOSE%>">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="modalTitle"></h4>
			</div>
			<div class="modal-body" id="modalBody">
				<table class="table table-control" id="residenceCard">
					<tr>
						<th class="td-left-control" width="20%">
							<img src="<%=Constants.LOGO_CCAEB2%>" width="100px" height="100px"
									class="img-responsive text-left" alt="logoccaeb2">
						</th>
						<th class="td-right-control text-center" width="60%" colspan="2">
							Rep�blica Bolivariana de Venezuela<br>
							<%=Constants.CCAEB2%><br>
							Parroquia Milla<br>
							Municipio Libertador<br>
							M�rida, Estado M�rida
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
							de la Parroquia Milla, Municipio Libertador del Estado M�rida,
							hacemos constar que _CIU,
						</td>
					</tr>
					<tr>
						<td class="text-center" colspan="4"><h4 id="personName"></h4></td>
					</tr>
					<tr>
						<td class="text-justify" colspan="4" id="docContent">
							<br>
							_NAC, mayor de edad, _POR de la C�dula de Identidad N� _CED,
							damos fe de que _LO conocemos de vista, trato y comunicaci�n;
							y por el conocimiento hacia _EL nos consta que tiene su residencia en la siguiente direcci�n: _DIR,
							<%=Constants.SECTOR_AEB%>, que pertenece al �mbito geogr�fico del "<%=Constants.CCAEB2%>".
						</td>
					</tr>
					<tr>
						<td class="text-justify" colspan="4" id="docDate">
							Constancia que se expide a solicitud de la parte interesada,
							para tr�mite _FTY, en la ciudad de M�rida, el d�a
						</td>
					</tr>
					<tr>
						<td class="text-left" colspan="2">
							<br><br>
							__________________
							<br>
							<h5>Angela Maldonado</h5>
							Unidad Administrativa y Financiera
						</td>
						<td class="text-right" colspan="2">
							<br><br>
							__________________
							<br>
							<h5 id="signer"></h5>
							Unidad Administrativa y Financiera
						</td>
					</tr>
					<tr>
						<td class="text-justify" colspan="4"><br>V�lido por seis meses.</td>
					</tr>
					<tr>
						<td class="footer text-center text-muted" colspan="4">
							<br><br><h6><%=Constants.DIR_CCAEB2%></h6>
						</td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal" id="closeModalBtn">
					<%=Constants.JSP_CLOSE%>
				</button>
				<button type="button" class="btn btn-primary" id="printModalBtn">
					<%=Constants.JSP_PRINT%>
				</button>
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

		var contentText = $('#docContent').text();

		if ($('#docType').val() == '<%=Constants.JSP_RES_PROOF_LOW_INCOME%>') {
			contentText += ' Nos consta adem�s que es una persona de bajos recursos econ�micos.';
		}

		var date = $('#docDate').text() 
					+ date.getDate()
					+ ' de ' + month[date.getMonth()]
					+ ' de ' + date.getFullYear() + '.';

		date = date.replace('_FTY', $('#formlalityType').val().toLowerCase());

		var first = data.nationality.charAt(0);
	    var nationality = first.toUpperCase() + data.nationality.substr(1, data.nationality.length - 1);

		contentText = contentText.replace('_CED', $('#<%=Constants.SECTION5_CEDULA_NUM%>').val());
		contentText = contentText.replace('_DIR', data.direction);
		contentText = contentText.replace('_NAC', nationality);

		contentText = replaceContentData(contentText, data.sex);

		$('#docContent').text(contentText);
		$('#docDate').text(date);
		$('#signer').text($('#docSigner').val());

	}

	function replaceContentData(contentText, sex) {

		if (sex == 'F') {

			$('#docIntro').text($('#docIntro').text().replace('_CIU', 'la ciudadana'));

			return contentText.replace('_POR', 'portadora')
							  .replace('_LO', 'la')
							  .replace('_EL', 'ella');

		} else if (sex == 'M') {

			$('#docIntro').text($('#docIntro').text().replace('_CIU', 'el ciudadano'));

			return contentText.replace('_POR', 'portador')
							  .replace('_LO', 'lo')
							  .replace('_EL', '�l');

		} else {

			$('#docIntro').text($('#docIntro').text().replace('_CIU', 'el (la) ciudadano (a)'));

			return contentText.replace('_POR', 'portador (a)')
							  .replace('_LO', 'lo (a)')
							  .replace('_EL', '�l (ella)');

		}

	}
</script>

<%@ include file="footer.jsp"%>
