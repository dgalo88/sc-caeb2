<%@include file="header.jsp"%>

<script src="/sc-caeb2/js/bootstrap-filestyle.js"></script>

<div class="container-fluid" style="width: 45%;">
	<form class="form--group" action="<%=Constants.EXEC_ACTION%>initDatabase" method="POST" enctype="multipart/form-data">

		<br>

		<h4 class="text-center">Inicializar la Base de Datos</h4>

		<br>

		<div class="form-group">
			<label for="password" class="control-label">Contraseña de administrador</label>
			<input type="password" id="<%=Constants.ATT_PASSWORD%>" name="<%=Constants.ATT_PASSWORD%>"
					class="form-control" placeholder="<%=Constants.JSP_PASS%>" required>
		</div>

		<div class="form-group">
			<label class="control-label" for="file">
				Seleccione el archivo de configuración de la Base de Datos
			</label>
			<input id="file" name="file" type="file" class="filestyle" accept=".sql"
					data-placeholder="Ejemplo: censoaeb2.sql" data-buttonText=" Seleccionar" required>
		</div>

		<br>

		<div class="form-group text-center">
			<button class="btn btn-primary" type="submit">
				<%=Constants.JSP_SEND%>
			</button>
		</div>
	</form>
</div>

<%@include file="footer.jsp"%>
