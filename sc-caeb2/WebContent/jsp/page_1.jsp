<%@ include file="header.jsp"%>

<%
	int pageNumber = 1;
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=pageNumber%>" name="form_<%=pageNumber%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=identifyingStructure" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="urbanizacion">Urbanización o barrio</label> 
							<input type="text" class="form-control" placeholder="Andrés Eloy Blanco 2" value="Andrés Eloy Blanco 2"
									id="urbanizacion" name="urbanizacion" required disabled>
						</div>
						<div class="form-group">
							<label for="nombreVivienda">Nombre o número de vivienda</label> 
							<input type="text" class="form-control" placeholder="Ej. #21 o Pérez"
									id="nombreVivienda" name="nombreVivienda" required>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="callePasaje">Calle o pasaje</label>
							<input type="text" class="form-control" placeholder="Ej. Pasaje 4"
									id="callePasaje" name="callePasaje" required>
						</div>
						<div class="form-group">
							<label for="telfResidencial">Teléfono residencial</label>
							<input type="number" class="form-control" placeholder="Ej. 02742395120"
									id="telfResidencial" name="telfResidencial" required>
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

		$('#form_<%=pageNumber%>').on('submit', function() {

			if (!validate()) {
				console.log('!validate');
				return false;
			}

			$('#urbanizacion').removeAttr('disabled');

		});

	});

	function validate() {

		var ret = true;

		$(':input[required]').each(function() {
			ret = !$.trim($(this).val());
			console.log('this = ' + $(this).attr('id'));
			return ret;
		});

		return ret;

	}
</script>

<%@ include file="footer.jsp"%>
