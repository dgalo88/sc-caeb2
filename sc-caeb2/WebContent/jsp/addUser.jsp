<%@page import="com.caeb2.actions.ActionManager"%>
<%@page import="com.caeb2.actions.bean.AdminProfile"%>
<%@page import="com.caeb2.util.Constants"%>

<%@include file="header.jsp"%>

<%
	Parameters.setTitle("Agregar Usuario");

	String persons = ActionManager.getPersons();
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<div class="container">
		<form class="form-horizontal" id="formAddNewUser" name="formAddNewUser"
				action="<%=Constants.EXEC_ACTION%>saveNewUser" method="POST">

			<br>
			<div class="container text-center" style="width: 60%;">
				<div class="form-group">
					<label for="<%=Constants.PROFILE_CEDULA%>" class="col-sm-4 control-label">
						Cédula:
					</label> 
					<div class="col-sm-6">
						<select class="form-control"
								name="<%=Constants.PROFILE_CEDULA%>"
								id="<%=Constants.PROFILE_CEDULA%>">
							<option value="Seleccione">Seleccione...</option>
						</select>
						<input type="hidden" name="<%=Constants.ATT_PERSON_ID%>" id="<%=Constants.ATT_PERSON_ID%>">
					</div>
				</div>
				<div class="form-group">
					<label for="personName" class="col-sm-4 control-label">
						Nombre:
					</label> 
					<div class="col-sm-6">
						<input type="text" class="form-control" id="personName" name="personName" disabled>
					</div>
				</div>
				<div class="form-group">
					<label for="<%=Constants.PROFILE_USER%>" class="col-sm-4 control-label">
						<%=Constants.JSP_USER%>:
					</label>
					<div class="col-sm-6">
						<input type="text" class="form-control"
								id="<%=Constants.PROFILE_USER%>"
								name="<%=Constants.PROFILE_USER%>"
								required>
					</div>
				</div>
				<div class="form-group">
					<label for="<%=Constants.PROFILE_NEW_PASS%>" class="col-sm-4 control-label">
						<%=Constants.JSP_PASS%>:
					</label>
					<div class="col-sm-6">
						<input type="password" class="form-control"
								id="<%=Constants.PROFILE_NEW_PASS%>"
								name="<%=Constants.PROFILE_NEW_PASS%>"
								required>
					</div>
				</div>
				<div class="form-group">
					<label for="<%=Constants.PROFILE_CONFIRM_PASS%>" class="col-sm-4 control-label">
						Confirme contraseña:
					</label>
					<div class="col-sm-6">
						<input type="password" class="form-control"
								id="<%=Constants.PROFILE_CONFIRM_PASS%>"
								name="<%=Constants.PROFILE_CONFIRM_PASS%>"
								required>
					</div>
				</div>
			</div>

			<div class="form-group text-center btn-footer">
				<a href="<%=Constants.ACTION_PROFILE%>">
					<button type="button" class="btn btn-default" id="backBtn">
						<%=Constants.JSP_COMEBACK%>
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

	persons = JSON.parse('<%=persons%>');

	$(document).on('ready', function() {

		loadPersonsData();

		$('#formAddNewUser').submit(function(event) {

			hideNotification();

			event.preventDefault();

			if (checkFields()) {

				var params = 

				$.ajax({
					url: $('#formAddNewUser').attr('action'),
					method: 'POST',
					data: $('#formAddNewUser').serialize(),

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

		$('#<%=Constants.PROFILE_CEDULA%>').on('change', function() {

			var idx = $("#<%=Constants.PROFILE_CEDULA%> option:selected").index() - 1;

			if (idx < 0) {
				return;
			}

			var person = persons[idx];

			$('#<%=Constants.ATT_PERSON_ID%>').val(person.id);
			$('#personName').val(person.names + ' ' + person.lastnames);

		});

	});

	function clearInputs() {
		$('#<%=Constants.PROFILE_USER%>').val('');
		$('#<%=Constants.PROFILE_NEW_PASS%>').val('');
		$('#<%=Constants.PROFILE_CONFIRM_PASS%>').val('');
	}

	function checkFields() {

		if ($("#<%=Constants.PROFILE_CEDULA%> option:selected").index() == 0) {
			showError('<%=Constants.NOT_SEL_CEDULA_ERROR%>');
			return false;
		}

		if ($('#<%=Constants.PROFILE_NEW_PASS%>').val()
				!== $('#<%=Constants.PROFILE_CONFIRM_PASS%>').val()) {
			showError('<%=Constants.CONFIRM_PASS_ERROR%>');
			return false;
		}

		return true;

	}

	function loadPersonsData() {

		for (var i = 0; i < persons.length; i++) {

			var cedula = persons[i].cedula.type + persons[i].cedula.number;
			var option = '<option value="' + cedula + '">' + cedula + '</option>';

			$('#<%=Constants.PROFILE_CEDULA%>').append(option);

		}

	}
</script>

<%@ include file="footer.jsp"%>
