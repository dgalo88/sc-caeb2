<%@page import="com.caeb2.util.Constants"%>
<%@page import="com.caeb2.util.Controller"%>

<%
	if (session.getAttribute(Constants.ATT_USER) == null) {
		Controller.forward(request, response, "index.jsp");
	}
%>