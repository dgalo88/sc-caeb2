<%@ include file="header.jsp"%>

<%
	Parameters.setPageNumber(3);
	Parameters.setTitle("Secci�n 3: N�mero de Hogares");
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>">
		<br>
		<div class="container">
			<div class="form-group">
				<label for="tipo_estructura">�Cu�ntas personas viven en este hogar?</label> 
				<div class="radio">
					<label><input type="radio" name="cuantas_PVEEH">Una sola persona (Un hogar censal, pase a la secci�n IV)</label>
					<br>
					<label><input type="radio" name="cuantas_PVEEH" checked="checked">Dos o m�s personas</label>
				</div>
			</div>
			<br>
			<div class="form-inline">
				<label for="tipo_estructura">�Cu�ntos grupos de personas mantienen gastos separados para la compra de la comida?</label> 
				<input type="number" required class="form-control" id="grupo_PMGPLCDLC" name="grupo_PMGPLCDLC"
						placeholder="Cada grupo de personas forma un hogar censal" min="1">
			</div>
			<br>
			<div class="form-group">
				<label for="tipo_estructura">��stas personas mantienen gastos separados para la compra  de la comida?</label>
				<div class="radio">
					<label><input type="radio" name="personas_MGSPLCDLC" checked="checked">S�</label>
					<br>
					<label><input type="radio" name="personas_MGSPLCDLC">No (Un hogar censal, pase a la secci�n IV)</label>
				</div>
			</div>
			<br>
			<label class="text-danger">Nota: Contin�e la entrevista para el primer hogar censal en este mismo cuestionario y para el resto de los hogares utilice otro cuestionario</label>
		</div>
	</form>
	<%@ include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {
	});
</script>

<%@ include file="footer.jsp"%>
