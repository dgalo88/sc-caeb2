<%@page import="com.caeb2.util.Constants"%>

<%if (session.getAttribute(Constants.ATT_USER) == null) {%>
	<%@ include file="jsp/login.jsp" %>
<%} else {%>
	<%@ include file="jsp/main.jsp" %>
<%}%>