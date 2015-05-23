<%@page import="com.caeb2.util.Constants"%>

<%
	String errorMessage = (String) request.getAttribute(Constants.ATT_ERROR);

	if (errorMessage == null) {
		errorMessage = "Ha ocurrido un errorcito";
	}
%>

<%@ include file="header.jsp"%>

<div class="container-fluid">
	<div class="container panel-error text-center">
		<div class="panel panel-danger">
			<div class="panel-heading"><%=Constants.JSP_ERROR%></div>
			<div class="panel-body"><%=errorMessage%></div>
		</div>
		<input id="datepicker" type="text" type="text" class="form-control">
		<button type="button" class="btn btn-danger"><%=Constants.JSP_RETURN%></button>
	</div>
</div>

<%@ include file="footer.jsp"%>
