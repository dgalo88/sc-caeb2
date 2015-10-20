<%@include file="header.jsp"%>

<%
	Parameters.setTitle("Sincronización de Datos");
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
<form action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=prepararConexion" method="POST">
	<div class="form-group center-block text-center main-panel">
		<div class="form-group">
			<label>Defina la condicion de este equipo</label>
		</div>
		<table class="table">
			<tr>
				<td class="text-center">
					<div class="radio">
						<label><input type="radio" name="radio" value="equipo_principal" checked>Equipo Principal</label>
						<br>
						<br>
						<label><input type="radio" name="radio" value="equipo_temporal">Equipo Temporal</label>
					</div>
				</td>
			</tr>
			<tr>
				<td class="text-center">
					<div class="form-group">
						<input type="submit" value="Siguiente" class="btn btn-primary" id="submitBtn<%=Parameters.getPageNumber()%>">
					</div>
				</td>
			</tr>
		</table>
	</div>
</form>
</div>

<%@include file="continueNewPoll.jsp"%>

<%@include file="footer.jsp"%>