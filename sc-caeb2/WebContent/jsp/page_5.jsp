<%@ include file="header.jsp"%>

<%
	int pageNumber = 5;
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=pageNumber%>" name="form_<%=pageNumber%>">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<table class="table table-control">
							<tbody>
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<label for="apellido">Apellidos</label>
										<input type="text" class="form-control" placeholder="Ej. Blanco Meaño"
												id="apellido" name="apellido" required autofocus>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="nombre">Nombres</label>
										<input type="text" class="form-control" placeholder="Ej. Andrés Eloy"
												id="apellido" name="apellido" required>
									</div>
								</td>
							</tr>
							</tbody>
						</table>

						<table class="table table-control">
							<tr>
								<td class="td-left-control" width="50%">
									<div class="form-group">
										<label for="sexo">Sexo</label>
										<div class="radio">
											<label>
												<input type="radio" name="sexo" id="masculino" value="M" checked>
												Masculino
											</label>
											<label>
												<input type="radio" name="sexo" id="femenino" value="F">
												Femenino
											</label>
										</div>
									</div>
								</td>
								<td class="td-right-control" width="50%">
									<label for="fechaNacimiento">Fecha de nacimiento</label>
									<div class="form-group" id="fecha">	<!-- fecha -->
										<div class="input-group date">
											<input type="text" class="form-control" placeholder="Ej. 15/02/1980"
													id="fechaNacimiento" name="fechaNacimiento" required>
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
											<select class="form-control" id="codAreaCelular" name="codAreaCelular">
												<option>0416</option>
												<option>0426</option>
												<option>0414</option>
												<option>0424</option>
												<option>0412</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 4753698"
													id="numeroCelular" name="numeroCelular" required>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="otroTelefono">Indique otro teléfono (opcional)</label>
										<div class="form-inline" id="otroTelefono">
											<select class="form-control" id="codAreaOtroTelf" name="codAreaOtroTelf">
												<option>0416</option>
												<option>0426</option>
												<option>0414</option>
												<option>0424</option>
												<option>0412</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 4753698"
													id="numeroOtroTelf" name="numeroOtroTelf">
										</div>
									</div>
								</td>
							</tr>
							</tbody>
						</table>

						<div class="form-group">
							<label for="parentesco">Parentesco con Jefe(a) del Hogar</label>
							<select class="form-control" id="parentesco" name="parentesco">
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
											<select class="form-control" id="tipoCedula" name="tipoCedula">
												<option>V</option>
												<option>E</option>
											</select>
											<input type="number" class="form-control" placeholder="Ej. 16465123"
													id="numeroCedula" name="numeroCedula" required>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<label for="tieneDI">¿Tiene?</label>
										<div class="checkbox" id="tieneDI">
											<label>
												<input type="checkbox" name="docId" id="pasaporte">
												Pasaporte
											</label>
											<label>
												<input type="checkbox" name="docId" id="partidaNacimiento">
												Partida de nacimiento
											</label>
											<br><br>
											<input type="text" class="form-control hidden" placeholder="Ej. 12340989"
													id="numeroPasaporte" name="numeroPasaporte">
										</div>
									</div>
								</td>
							</tr>
							</tbody>
						</table>

						<div class="form-group">
							<label for="nacionalidad">Nacionalidad</label>
							<input type="text" class="form-control" placeholder="Ej. Venezolano"
									id="nacionalidad" name="nacionalidad" required>
						</div>
	
						<div class="form-group">
							<label for="correo">Indique su correo electrónico</label>
							<input type="text" class="form-control" placeholder="Ej. andres@mail.com"
									id="correo" name="correo" required>
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

		$('#fecha input').datepicker();

		$('#pasaporte').on("click", function() {
			if ($(this).is(":checked")) {
				$("#numeroPasaporte").removeClass('hidden').addClass('show');
			} else {
				$("#numeroPasaporte").removeClass('show').addClass('hidden');
			}
		});

	});
</script>

<%@ include file="footer.jsp"%>
