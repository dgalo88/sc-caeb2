<%@page import="com.caeb2.util.Constants"%>

<%
	String errorMessage = (String) request.getAttribute(Constants.ATT_ERROR);

	if (errorMessage == null) {
		errorMessage = Constants.ERROR;
	}
%>

<%@include file="header.jsp"%>

<div class="container-fluid">
	<div class="container panel-error text-center">
		<div class="panel panel-danger">
			<div class="panel-heading"><%=Constants.JSP_ERROR%></div>
			<div class="panel-body"><%=errorMessage%></div>
		</div>
		<a href="<%=Constants.ACTION_HOME%>">
			<button type="button" class="btn btn-danger" id="returnBtn" name="returnBtn">
				<%=Constants.JSP_RETURN%>
			</button>
		</a>
	</div>
</div>

<%@include file="footer.jsp"%>
