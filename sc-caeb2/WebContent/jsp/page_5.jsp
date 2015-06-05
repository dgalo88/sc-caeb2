<%@ include file="header.jsp"%>

<%
	Parameters.setPageNumber(5);
	Parameters.setTitle("Sección 5: Características individuales");
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
												required autofocus>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="<%=Constants.SECTION5_NAMES%>">Nombres</label>
										<input type="text" class="form-control" placeholder="Ej. Andrés Eloy"
												id="<%=Constants.SECTION5_NAMES%>" name="<%=Constants.SECTION5_NAMES%>" required>
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
												<input type="radio" name="<%=Constants.SECTION5_SEX%>" id="masculino" value="M" checked>
												Masculino
											</label>
											<label>
												<input type="radio" name="<%=Constants.SECTION5_SEX%>" id="femenino" value="F">
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
													id="<%=Constants.SECTION5_BIRTHDATE%>" name="<%=Constants.SECTION5_BIRTHDATE%>" required>
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
												<option>0416</option>
												<option>0426</option>
												<option>0414</option>
												<option>0424</option>
												<option>0412</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 4753698"
													id="<%=Constants.SECTION5_PHONE_NUM%>" name="<%=Constants.SECTION5_PHONE_NUM%>"
													required>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="otroTelefono">Indique otro teléfono (opcional)</label>
										<div class="form-inline" id="otroTelefono">
											<select class="form-control" id="<%=Constants.SECTION5_PHONE_OPTIONAL_COD%>"
													name="<%=Constants.SECTION5_PHONE_OPTIONAL_COD%>">
												<option>0416</option>
												<option>0426</option>
												<option>0414</option>
												<option>0424</option>
												<option>0412</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 4753698"
													id="<%=Constants.SECTION5_PHONE_OPTIONAL_NUM%>"
													name="<%=Constants.SECTION5_PHONE_OPTIONAL_NUM%>">
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
								<option>Jefe o jefa del Hogar</option>
								<option>Esposa(o) o compañera(o)</option>
								<option>Hijo(a) o hijastro(a)</option>
								<option>Nieto o nieta</option>
								<option>Yerno o nuera</option>
								<option>Padre, madre o suegro(a)</option>
								<option>Hermano(a) o cuñado(a)</option>
								<option>Sobrino(a)</option>
								<option>Otro pariente</option>
								<option>No pariente</option>
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
												<option>V</option>
												<option>E</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 16465123"
													id="<%=Constants.SECTION5_CEDULA_NUM%>" name="<%=Constants.SECTION5_CEDULA_NUM%>"
													required>
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
														value="<%=Constants.JSP_PASSPORT%>">
												Pasaporte
											</label>
											<label>
												<input type="checkbox" name="<%=Constants.SECTION5_ID_DOCS%>"
														id="<%=Constants.SECTION5_HAS_BIRTH_CERTIFICATE%>"
														value="<%=Constants.JSP_BIRTH_CERTIFICATE%>">
												Partida de nacimiento
											</label>
											<br><br>
											<input type="text" class="form-control hidden" placeholder="Ej. 12340989"
													id="<%=Constants.SECTION5_PASSPORT_NUM%>"
													name="<%=Constants.SECTION5_PASSPORT_NUM%>">
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
									required>
						</div>
	
						<div class="form-group">
							<label for="<%=Constants.SECTION5_EMAIL%>">Indique su correo electrónico</label>
							<input type="email" class="form-control" placeholder="Ej. andres@mail.com"
									id="<%=Constants.SECTION5_EMAIL%>" name="<%=Constants.SECTION5_EMAIL%>"
									required>
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
				$("#<%=Constants.SECTION5_PASSPORT_NUM%>").removeClass('hidden').addClass('show');
			} else {
				$("#<%=Constants.SECTION5_PASSPORT_NUM%>").removeClass('show').addClass('hidden');
			}
		});

	});
</script>

<%@ include file="footer.jsp"%>
