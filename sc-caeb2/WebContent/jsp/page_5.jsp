<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form>
		<table class="table">
			<tbody>
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
							<tbody>
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
									<div class="input-group">
										<span class="input-group-btn">
											<button type="button" class="btn btn-default" aria-label="calendar">
												<span class="glyphicon glyphicon glyphicon-calendar" aria-hidden="true"></span>
											</button>
										</span>
										<input type="datetime" class="form-control" placeholder="Ej. 15/02/1980"
												id="fechaNacimiento" name="fechaNacimiento" required>
									</div>	<!-- /input-group -->
								</td>
							</tr>
							</tbody>
						</table>

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
												<input type="checkbox" name="tieneDocIdentidad" id="pasaporte">
												Pasaporte
											</label>
											<label>
												<input type="checkbox" name="tieneDocIdentidad" id="partidaNacimiento">
												Partida de nacimiento
											</label>
										</div>
									</div>
								</td>
							</tr>
							</tbody>
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

					</div>
				</td>
				<td width="50%">
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
				</td>
			</tr>
			</tbody>
		</table>
	</form>
</div>

<%@ include file="footer.jsp"%>