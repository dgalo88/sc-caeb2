<%@page import="com.caeb2.sections.IdentifyingStructure"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(1);
	Parameters.setTitle("Sección 1: Identificación de la estructura");

	IdentifyingStructure identifyingStructure= new IdentifyingStructure();
%>

<%@include file="validateCurrentPage.jsp"%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveProcessPage1" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="urbanizacion">Urbanización o barrio</label> 
							<input type="text" class="form-control" placeholder="Andrés Eloy Blanco 2"
									value="Andrés Eloy Blanco" id="urbanizacion" name="urbanizacion" required disabled>
						</div>
						<div class="form-group">
							<label for="nombreVivienda">Nombre o número de vivienda</label> 
							<input type="text" class="form-control" placeholder="Ej. 21 o Casa Linda"
									id="<%=Constants.SECTION1_NAME_HOUSING%>" name="<%=Constants.SECTION1_NAME_HOUSING%>"
									required value="<%=(identifyingStructure==null||identifyingStructure.getNameHousing()==null) ? "" : identifyingStructure.getNameHousing()%>">
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<label for="callePasaje">Calle o pasaje</label>
							<input type="text" class="form-control" placeholder="Ej. Pasaje 4" required
									id="<%=Constants.SECTION1_STREET%>" name="<%=Constants.SECTION1_STREET%>"
									value="<%=(identifyingStructure==null||identifyingStructure.getStreet()==null) ? "" : identifyingStructure.getStreet()%>">
						</div>
						<div class="form-group">
							<label for="telfResidencial">Teléfono residencial</label>
							<input type="number" class="form-control" placeholder="Ej. 2445120" required maxlength="7"
									id="<%=Constants.SECTION1_HOME_PHONE%>" name="<%=Constants.SECTION1_HOME_PHONE%>"
									value="<%=(identifyingStructure==null||identifyingStructure.getHomePhone()==null) ? "" : identifyingStructure.getHomePhone()%>">
						</div>
					</div>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit" class="btn btn-primary hidden" id="submitBtn<%=Parameters.getPageNumber()%>">
	</form>
	<%@include file="pagination.jsp"%>
</div>

<%@include file="footer.jsp"%>
