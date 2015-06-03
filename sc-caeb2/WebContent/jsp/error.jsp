<%@page import="com.caeb2.util.Constants"%>

<%
	String errorMessage = (String) request.getAttribute(Constants.ATT_MESSAGE);

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
		<button type="button" class="btn btn-danger" id="returnBtn" name="returnBtn"><%=Constants.JSP_RETURN%></button>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#returnBtn').on('click', function() {
			window.location.href = '/sc-caeb2/index.jsp';
		});
	});
</script>

<%@ include file="footer.jsp"%>
