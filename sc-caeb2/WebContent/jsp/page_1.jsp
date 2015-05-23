<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group">
		<table class="table">
			<tr>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="urbanizacion">Urbanizaci�n o barrio</label> 
							<input type="text" class="form-control" id="urbanizacion" placeholder="Andr�s Eloy Blanco 2" disabled>
						</div>
						<div class="form-group">
							<label for="nombre_vivienda">Nombre o n�mero de vivienda</label> 
							<input type="text" class="form-control" id="exampleInputPassword1" placeholder="Ej. #21 o P�rez">
						</div>
					</div>
				</td>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="calle_pasaje">Calle o pasaje</label> 
							<input type="text" class="form-control" id="calle_pasaje" name="calle_pasaje" placeholder="Ej. Pasaje 4">
						</div>
						<div class="form-group">
							<label for="telfResidencial">Tel�fono residencial</label>
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

<%@ include file="footer.jsp"%>
