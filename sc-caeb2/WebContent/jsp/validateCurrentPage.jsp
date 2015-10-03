<%@page import="com.caeb2.util.Controller"%>
<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%
	int pageNum = Parameters.getPageNumber();

	Integer currPage = (Integer) session.getAttribute(Constants.ATT_CURR_PAGE);

	if (pageNum != currPage) {
		Controller.forward(request, response, "error.jsp", Constants.IT_CANNOT_ERROR);
	}
%>
