<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container" style="padding-top: 2%;">
	<form>
		<table width="100%">
			<tr>
				<th  width="50%"></th>
				<th  width="50%"></th>
			</tr>
			<tr>
				<td valign="top" style="padding-right: 2%;">
					<div>
						<div class="form-group">
							<label for="tipo_estructura">¿Cuantas personas viven en este hogar?</label> 
							<div class="radio">
								<label><input type="radio" name="cuantas_PVEEH">Una sola persona (Un hogar censal, pase a la sección IV)</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="cuantas_PVEEH" checked="checked">Dos o más personas </label>
							</div>
						</div>
						<div class="form-group">
							<label for="tipo_estructura">¿Cuantos grupos de personas mantienen gastos separados para la compra de la comida?</label> 
								<input type="number" required class="form-control" id="grupo_PMGPLCDLC" name="grupo_PMGPLCDLC" placeholder="Cada grupo de personas forma un hogar censal">
						</div>
					</div>
				</td>
				<td valign="top">
					<div>
						<div class="form-group">
							<label for="tipo_estructura">¿Estas personas mantienen gastos separados para la compra  de la comida?</label> 
							<div class="radio">
								<label><input type="radio" name="personas_MGSPLCDLC" checked="checked">Si</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="personas_MGSPLCDLC">No (Un hogar censal, pase a la sección IV)</label>
							</div>
						</div>	
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label for="tipo_estructura">Nota: Continúe la entrevista para el primer hogar censal en este mismo cuestionario y para el resto de los hogares utilice otro cuestionario</label>	
				</td>
			</tr>
			<tr><td></td><td valign="top" align="right"><button class="btn btn-lg btn-primary btn-block" type="submit" style="width: initial;">Siguiente</button></td></tr>
		</table>
	</form>
</div>
<script>
	$(document).ready(function() {
	});
</script>

<%@ include file="footer.jsp"%>