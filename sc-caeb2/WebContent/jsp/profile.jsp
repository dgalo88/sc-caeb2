<%@page import="com.caeb2.actions.bean.AdminProfile"%>
<%@page import="com.caeb2.util.Constants"%>

<%@include file="header.jsp"%>

<%
	Parameters.setTitle("Perfil");

	AdminProfile adminProfile = (AdminProfile) request.getAttribute(Constants.ATT_ADMIN_PROFILE);
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<div class="container">
		<form class="form-horizontal" id="formProfile" name="formProfile"
				action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=updateAdminProfile" method="POST">
			<h4 class="text-center">Datos personales</h4>
			<table class="table" id="datos">
			<tbody>
				<tr>
					<td width="50%">
						<div class="form-group">
							<label for="<%=Constants.SECTION5_LASTNAMES%>" class="col-sm-4 control-label">Apellidos</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
										id="<%=Constants.SECTION5_LASTNAMES%>" name="<%=Constants.SECTION5_LASTNAMES%>"
										value="<%=adminProfile.getLastnames()%>" disabled>
							</div>
						</div>
					</td>
					<td width="50%">
						<div class="form-group">
							<label for="<%=Constants.SECTION5_NAMES%>" class="col-sm-4 control-label">Nombres</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
										id="<%=Constants.SECTION5_NAMES%>" name="<%=Constants.SECTION5_NAMES%>"
										value="<%=adminProfile.getNames()%>" disabled>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-group">
							<label for="cedula" class="col-sm-4 control-label">Cédula de Identidad</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="cedula" name="cedula"
										value="<%=adminProfile.getCedula().isValid() ?
												adminProfile.getCedula().toString() : ""%>" disabled>
							</div>
						</div>
					</td>
					<td>
						<div class="form-group">
							<label for="phone" class="col-sm-4 control-label">Teléfono celular</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="phone" name="phone"
										value="<%=adminProfile.getPhone().isValid() ?
												adminProfile.getPhone().toString() : ""%>" disabled>
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
										id="<%=Constants.SECTION5_EMAIL%>" name="<%=Constants.SECTION5_EMAIL%>"
										value="<%=adminProfile.getEmail()%>" disabled>
							</div>
						</div>
					</td>
					<td>
						<div class="form-group">
							<label for="optionalPhone" class="col-sm-4 control-label">Teléfono celular (opcional)</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="optionalPhone" name="optionalPhone"
										value="<%=adminProfile.getOptionalPhone().isValid() ?
												adminProfile.getOptionalPhone().toString() : ""%>" disabled>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
			</table>

			<div class="container text-center" style="width: 60%;">
				<h4 class="text-center">Cambiar contraseña</h4>
				<div class="form-group" id="changePassword">
					<div class="form-group">
						<label for="<%=Constants.PROFILE_CURR_PASS%>" class="col-sm-4 control-label">Contraseña actual</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"
									id="<%=Constants.PROFILE_CURR_PASS%>"
									name="<%=Constants.PROFILE_CURR_PASS%>"
									required>
						</div>
					</div>
					<div class="form-group">
						<label for="<%=Constants.PROFILE_NEW_PASS%>" class="col-sm-4 control-label">Contraseña nueva</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"
									id="<%=Constants.PROFILE_NEW_PASS%>"
									name="<%=Constants.PROFILE_NEW_PASS%>"
									required>
						</div>
					</div>
					<div class="form-group">
						<label for="<%=Constants.PROFILE_CONFIRM_PASS%>" class="col-sm-4 control-label">Confirme contraseña nueva</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"
									id="<%=Constants.PROFILE_CONFIRM_PASS%>"
									name="<%=Constants.PROFILE_CONFIRM_PASS%>"
									required>
						</div>
					</div>
				</div>
			</div>

			<div class="form-group text-center btn-footer">
				<a href="<%=Constants.ACTION_HOME%>">
					<button type="button" class="btn btn-default" id="backBtn">
						<%=Constants.JSP_COMEBACK%>
					</button>
				</a>
				<a href="addUser.jsp">
					<button type="button" class="btn btn-warning" id="addUserBtn">
						<%=Constants.JSP_ADD_USER%>
					</button>
				</a>
				<button type="submit" class="btn btn-primary" id="save" name="save">
					<%=Constants.JSP_SAVE%>
				</button>
			</div>

		</form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$('#formProfile').submit(function(event) {

			hideNotification();

			event.preventDefault();

			if (checkFields()) {

				$.ajax({
					url: $('#formProfile').attr('action'),
					method: 'POST',
					data: $('#formProfile').serialize(),

					success: function(result, status, xhr) {
						showSuccess(result);
						clearInputs();
					},

					error: function(xhr, status, error) {
						showError(xhr.responseText);
					}
				});

			}

		});

	});

	function clearInputs() {
		$('#<%=Constants.PROFILE_CURR_PASS%>').val('');
		$('#<%=Constants.PROFILE_NEW_PASS%>').val('');
		$('#<%=Constants.PROFILE_CONFIRM_PASS%>').val('');
	}

	function checkFields() {

		if ($('#<%=Constants.PROFILE_NEW_PASS%>').val()
				!== $('#<%=Constants.PROFILE_CONFIRM_PASS%>').val()) {
			showError('<%=Constants.CONFIRM_PASS_ERROR%>');
			return false;
		}

		if ($('#<%=Constants.PROFILE_NEW_PASS%>').val()
				=== $('#<%=Constants.PROFILE_CURR_PASS%>').val()) {
			showError('<%=Constants.EQUALS_PASS_ERROR%>');
			return false;
		}

		return true;

	}
</script>

<%@ include file="footer.jsp"%>
