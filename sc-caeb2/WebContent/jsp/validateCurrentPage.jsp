<%@page import="com.caeb2.util.Controller"%>
<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%
	int pageNum = Parameters.getPageNumber();

	Integer currPage = (Integer) session.getAttribute(Constants.ATT_CURR_PAGE);

	if (pageNum > currPage) {
 		Controller.forwardError(request, response, Constants.CANNOT_ACCESS_ERROR);
	}
%>
