<%@page import="com.caeb2.actions.IndividualCharacteristics"%>
<%@ include file="header.jsp"%>

<%
	Parameters.setPageNumber(5);
	Parameters.setTitle("Sección 5: Características individuales");

	IndividualCharacteristics characteristics = IndividualCharacteristics.loadIndividualCharacteristics();
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveIndividualCharacteristics" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<table class="table table-control">
							<tbody>
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<label for="<%=Constants.SECTION5_LASTNAMES%>">Apellidos</label>
										<input type="text" class="form-control" placeholder="Ej. Blanco Meaño"
												id="<%=Constants.SECTION5_LASTNAMES%>" name="<%=Constants.SECTION5_LASTNAMES%>"
												value="<%=characteristics.getLastnames()%>" required autofocus>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="<%=Constants.SECTION5_NAMES%>">Nombres</label>
										<input type="text" class="form-control" placeholder="Ej. Andrés Eloy"
												id="<%=Constants.SECTION5_NAMES%>" name="<%=Constants.SECTION5_NAMES%>"
												value="<%=characteristics.getNames()%>" required>
									</div>
								</td>
							</tr>
							</tbody>
						</table>

						<table class="table table-control">
							<tr>
								<td class="td-left-control" width="50%">
									<div class="form-group">
										<label for="<%=Constants.SECTION5_SEX%>">Sexo</label>
										<div class="radio">
											<label>
												<input type="radio" name="<%=Constants.SECTION5_SEX%>" id="masculino" value="M"
														<%if (characteristics.getSex().equals("M")) {%> checked <%}%>>
												Masculino
											</label>
											<label>
												<input type="radio" name="<%=Constants.SECTION5_SEX%>" id="femenino" value="F"
														<%if (characteristics.getSex().equals("F")) {%> checked <%}%>>
												Femenino
											</label>
										</div>
									</div>
								</td>
								<td class="td-right-control" width="50%">
									<label for="<%=Constants.SECTION5_BIRTHDATE%>">Fecha de nacimiento</label>
									<div class="form-group" id="fecha">	<!-- fecha -->
										<div class="input-group date">
											<input type="text" class="form-control" placeholder="Ej. 15/02/1980"
													id="<%=Constants.SECTION5_BIRTHDATE%>" name="<%=Constants.SECTION5_BIRTHDATE%>"
													value="<%=characteristics.getBirthdate()%>" required>
											<span class="input-group-addon" id="fechaNacIcon">
												<i class="glyphicon glyphicon-calendar" aria-label="calendar" aria-hidden="true"></i>
											</span>
											<div class="date"></div>
										</div>
									</div>	<!-- /fecha -->
								</td>
							</tr>
						</table>

						<table class="table table-control">
							<tbody>
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<label for="celular">Indique su teléfono celular</label>
										<div class="form-inline" id="celular">
											<select class="form-control" id="<%=Constants.SECTION5_PHONE_COD%>"
													name="<%=Constants.SECTION5_PHONE_COD%>">
												<option <%if (characteristics.getPhoneCod() == 0416) {%> selected <%}%>>0416</option>
												<option <%if (characteristics.getPhoneCod() == 0426) {%> selected <%}%>>0426</option>
												<option <%if (characteristics.getPhoneCod() == 0416) {%> selected <%}%>>0414</option>
												<option <%if (characteristics.getPhoneCod() == 0426) {%> selected <%}%>>0424</option>
												<option <%if (characteristics.getPhoneCod() == 0412) {%> selected <%}%>>0412</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 4753698" min="1"
													id="<%=Constants.SECTION5_PHONE_NUM%>" name="<%=Constants.SECTION5_PHONE_NUM%>"
													value="<%=characteristics.getPhoneNum()%>" required>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="otroTelefono">Indique otro teléfono (opcional)</label>
										<div class="form-inline" id="otroTelefono">
											<select class="form-control" id="<%=Constants.SECTION5_PHONE_COD_OPTIONAL%>"
													name="<%=Constants.SECTION5_PHONE_COD_OPTIONAL%>">
												<option <%if (characteristics.getPhoneCodOptional() == 0416) {%> selected <%}%>>0416</option>
												<option <%if (characteristics.getPhoneCodOptional() == 0426) {%> selected <%}%>>0426</option>
												<option <%if (characteristics.getPhoneCodOptional() == 0416) {%> selected <%}%>>0414</option>
												<option <%if (characteristics.getPhoneCodOptional() == 0426) {%> selected <%}%>>0424</option>
												<option <%if (characteristics.getPhoneCodOptional() == 0412) {%> selected <%}%>>0412</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 4753698" min="1"
													id="<%=Constants.SECTION5_PHONE_NUM_OPTIONAL%>"
													name="<%=Constants.SECTION5_PHONE_NUM_OPTIONAL%>"
													<%if (characteristics.getPhoneNumOptional() != 0) {%>
														value="<%=characteristics.getPhoneNumOptional()%>" <%}%>>
										</div>
									</div>
								</td>
							</tr>
							</tbody>
						</table>

						<div class="form-group">
							<label for="<%=Constants.SECTION5_RELATIONSHIP%>">Parentesco con Jefe(a) del Hogar</label>
							<select class="form-control" id="<%=Constants.SECTION5_RELATIONSHIP%>"
									name="<%=Constants.SECTION5_RELATIONSHIP%>">
								<option <%if (characteristics.getRelationship().equals("Jefe o jefa del Hogar")) {%> selected <%}%>>Jefe o jefa del Hogar</option>
								<option <%if (characteristics.getRelationship().equals("Esposa(o) o compañera(o)")) {%> selected <%}%>>Esposa(o) o compañera(o)</option>
								<option <%if (characteristics.getRelationship().equals("Hijo(a) o hijastro(a)")) {%> selected <%}%>>Hijo(a) o hijastro(a)</option>
								<option <%if (characteristics.getRelationship().equals("Nieto o nieta")) {%> selected <%}%>>Nieto o nieta</option>
								<option <%if (characteristics.getRelationship().equals("Yerno o nuera")) {%> selected <%}%>>Yerno o nuera</option>
								<option <%if (characteristics.getRelationship().equals("Padre, madre o suegro(a)")) {%> selected <%}%>>Padre, madre o suegro(a)</option>
								<option <%if (characteristics.getRelationship().equals("Hermano(a) o cuñado(a)")) {%> selected <%}%>>Hermano(a) o cuñado(a)</option>
								<option <%if (characteristics.getRelationship().equals("Sobrino(a)")) {%> selected <%}%>>Sobrino(a)</option>
								<option <%if (characteristics.getRelationship().equals("Otro pariente")) {%> selected <%}%>>Otro pariente</option>
								<option <%if (characteristics.getRelationship().equals("No pariente")) {%> selected <%}%>>No pariente</option>
								<option <%if (characteristics.getRelationship().equals("Inquilino")) {%> selected <%}%>>Inquilino</option>
							</select>
						</div>

					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<table class="table table-control">
							<tbody>
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<label for="cedula">Cédula de Identidad</label>
										<div class="form-inline" id="cedula">
											<select class="form-control" id="<%=Constants.SECTION5_CEDULA_TYPE%>"
													name="<%=Constants.SECTION5_CEDULA_TYPE%>">
												<option <%if (characteristics.getCedula().getType().equals("V")) {%> selected <%}%>>V</option>
												<option <%if (characteristics.getCedula().getType().equals("E")) {%> selected <%}%>>E</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 16465123" min="1"
													id="<%=Constants.SECTION5_CEDULA_NUM%>" name="<%=Constants.SECTION5_CEDULA_NUM%>"
													value="<%=characteristics.getCedula().getNumber()%>" required>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="tieneDI">¿Tiene?</label>
										<div class="checkbox" id="tieneDI">
											<label>
												<input type="checkbox" name="<%=Constants.SECTION5_ID_DOCS%>"
														id="<%=Constants.SECTION5_HAS_PASSPORT%>"
														value="<%=Constants.JSP_PASSPORT%>"
														<%if (characteristics.getPassport().getNumber() != 0) {%> checked <%}%>>
												Pasaporte
											</label>
											<label>
												<input type="checkbox" name="<%=Constants.SECTION5_ID_DOCS%>"
														id="<%=Constants.SECTION5_HAS_BIRTH_CERTIFICATE%>"
														value="<%=Constants.JSP_BIRTH_CERTIFICATE%>"
														<%if (characteristics.hasBirthCertificate()) {%> checked <%}%>>
												Partida de nacimiento
											</label>
											<br><br>
											<input type="number" class="form-control hidden" placeholder="Ej. 12340989" min="1"
													id="<%=Constants.SECTION5_PASSPORT_NUM%>"
													name="<%=Constants.SECTION5_PASSPORT_NUM%>"
													<%if (characteristics.getPassport().getNumber() != 0) {%>
														value="<%=characteristics.getPassport().getNumber()%>" <%}%>>
										</div>
									</div>
								</td>
							</tr>
							</tbody>
						</table>

						<div class="form-group">
							<label for="<%=Constants.SECTION5_NATIONALITY%>">Nacionalidad</label>
							<input type="text" class="form-control" placeholder="Ej. Venezolano"
									id="<%=Constants.SECTION5_NATIONALITY%>" name="<%=Constants.SECTION5_NATIONALITY%>"
									value="<%=characteristics.getNationality()%>" required>
						</div>
	
						<div class="form-group">
							<label for="<%=Constants.SECTION5_EMAIL%>">Indique su correo electrónico</label>
							<input type="email" class="form-control" placeholder="Ej. andres@mail.com"
									id="<%=Constants.SECTION5_EMAIL%>" name="<%=Constants.SECTION5_EMAIL%>"
									value="<%=characteristics.getEmail()%>" required>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
	<%@ include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$('#fecha input').datepicker();

		$('#<%=Constants.SECTION5_HAS_PASSPORT%>').on("click", function() {
			if ($(this).is(":checked")) {
				$("#<%=Constants.SECTION5_PASSPORT_NUM%>")
					.removeClass('hidden').addClass('show')
					.attr('required', 'required');
			} else {
				$("#<%=Constants.SECTION5_PASSPORT_NUM%>")
					.removeClass('show').addClass('hidden')
					.removeAttr('required');
			}
		});

	});
</script>

<%@ include file="footer.jsp"%>
