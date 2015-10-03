<%@page import="com.caeb2.actions.PollManager"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(3);
	Parameters.setTitle("Sección 3: Observaciones");

	String observations = PollManager.getObservations();

	System.out.println("curr = " + session.getAttribute(Constants.ATT_CURR_PAGE));
%>

<%@include file="validateCurrentPage.jsp"%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
<%-- 	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"> --%>
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveProcessPage3" method="POST">
		<br>
		<div class="center-block" style="width: 60%">
			<label class="text-danger text-justify">
				NOTA: Responda la encuesta para cada hogar en esta vivienda y para las personas que forman parte de cada hogar.
			</label>
			<label class="text-justify">
				Por ejemplo: En una vivienda en la que viven dos familias que mantienen gastos separados, se debe responder la encuesta para dos hogares.
				Debe responder la encuesta para todos los miembros de un hogar y luego del otro.
			</label>

			<br><br>

			<label for="<%=Constants.SECTION3_OBSERVATIONS%>">Observaciones:</label>
			<textarea class="form-control" rows="5"
						id="<%=Constants.SECTION3_OBSERVATIONS%>" name="<%=Constants.SECTION3_OBSERVATIONS%>"
						placeholder="Escriba aquí las observaciones sobre la encuesta"><%=observations%></textarea>
		</div>
		<input type="submit" value="Submit" class="btn btn-primary hidden" id="submitBtn<%=Parameters.getPageNumber()%>">
	</form>
	
	<%@include file="pagination.jsp"%>
</div>

<%@include file="footer.jsp"%>
