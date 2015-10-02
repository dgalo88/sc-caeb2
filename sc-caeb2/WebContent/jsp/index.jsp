<%@page import="com.caeb2.util.Constants"%>

<%if (session.getAttribute(Constants.ATT_USER) == null) {%>
	<%@include file="login.jsp"%>
<%} else {%>
	<%@include file="main.jsp"%>
<%}%>