<%@page import="com.caeb2.util.Constants"%>
<%@ include file="header.jsp"%>

<%
	Parameters.setTitle("Perfil");
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<div class="container">
		<form class="form-horizontal" id="form_profile" name="form_profile"
				action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=updatePassword" method="POST">
			<h4 class="text-center">Datos personales</h4>
			<table class="table" id="datos">
			<tbody>
				<tr>
					<td width="50%">
						<div class="form-group">
							<label for="<%=Constants.SECTION5_LASTNAMES%>" class="col-sm-4 control-label">Apellidos</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
										id="<%=Constants.SECTION5_LASTNAMES%>" name="<%=Constants.SECTION5_LASTNAMES%>">
							</div>
						</div>
					</td>
					<td width="50%">
						<div class="form-group">
							<label for="<%=Constants.SECTION5_NAMES%>" class="col-sm-4 control-label">Nombres</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
										id="<%=Constants.SECTION5_NAMES%>" name="<%=Constants.SECTION5_NAMES%>">
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
							<label for="cedula" class="col-sm-4 control-label">Cédula de Identidad</label>
							<div class="col-sm-8">
								<div class="form-inline" id="cedula">
									<select class="form-control" id="<%=Constants.SECTION5_CEDULA_TYPE%>"
											name="<%=Constants.SECTION5_CEDULA_TYPE%>">
										<option>V</option>
										<option>E</option>
									</select>
									<input type="number" class="form-control"
											id="<%=Constants.SECTION5_CEDULA_NUM%>" name="<%=Constants.SECTION5_CEDULA_NUM%>"
											required>
								</div>
							</div>
						</div>
					</td>
					<td>
						<div class="form-group">
							<label for="celular" class="col-sm-4 control-label">Teléfono celular</label>
							<div class="col-sm-8">
								<div class="form-inline" id="celular">
									<select class="form-control" id="<%=Constants.SECTION5_PHONE_COD%>"
											name="<%=Constants.SECTION5_PHONE_COD%>">
										<option>0416</option>
										<option>0426</option>
										<option>0414</option>
										<option>0424</option>
										<option>0412</option>
									</select>
									<input type="number" class="form-control"
											id="<%=Constants.SECTION5_PHONE_NUM%>"
											name="<%=Constants.SECTION5_PHONE_NUM%>">
								</div>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
							<label for="<%=Constants.SECTION5_EMAIL%>" class="col-sm-4 control-label">Correo electrónico</label>
							<div class="col-sm-8">
								<input type="email" class="form-control"
										id="<%=Constants.SECTION5_EMAIL%>" name="<%=Constants.SECTION5_EMAIL%>">
							</div>
						</div>
					</td>
					<td>
						<div class="form-group">
							<label for="otroTelefono" class="col-sm-4 control-label">Teléfono celular (opcional)</label>
							<div class="col-sm-8">
								<div class="form-inline" id="otroTelefono">
									<select class="form-control" id="<%=Constants.SECTION5_PHONE_OPTIONAL_COD%>"
											name="<%=Constants.SECTION5_PHONE_OPTIONAL_COD%>">
										<option>0416</option>
										<option>0426</option>
										<option>0414</option>
										<option>0424</option>
										<option>0412</option>
									</select>
									<input type="number" class="form-control"
											id="<%=Constants.SECTION5_PHONE_OPTIONAL_NUM%>"
											name="<%=Constants.SECTION5_PHONE_OPTIONAL_NUM%>">
								</div>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
			</table>

			<div class="container">
				<h4 class="text-center">Cambiar contraseña</h4>
				<div class="form-group" id="changePassword">
					<div class="form-group">
						<label for="<%=Constants.PROFILE_CURR_PASS%>" class="col-sm-4 control-label">Contraseña actual</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"
									id="<%=Constants.PROFILE_CURR_PASS%>" name="<%=Constants.PROFILE_CURR_PASS%>">
						</div>
					</div>
					<div class="form-group">
						<label for="<%=Constants.PROFILE_NEW_PASS%>" class="col-sm-4 control-label">Contraseña nueva</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"
									id="<%=Constants.PROFILE_NEW_PASS%>" name="<%=Constants.PROFILE_NEW_PASS%>">
						</div>
					</div>
					<div class="form-group">
						<label for="<%=Constants.PROFILE_CONFIRM_PASS%>" class="col-sm-4 control-label">Confirme contraseña nueva</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"
									id="<%=Constants.PROFILE_CONFIRM_PASS%>" name="<%=Constants.PROFILE_CONFIRM_PASS%>">
						</div>
					</div>
				</div>
			</div>

			<div class="form-group text-center">
				<button type="button" class="btn btn-primary">Guardar</button>
			</div>

		</form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>

<%@ include file="footer.jsp"%>
