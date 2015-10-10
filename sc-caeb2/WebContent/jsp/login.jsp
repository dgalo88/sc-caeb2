<%@page import="com.caeb2.util.Constants"%>

<%@include file="header.jsp"%>

<link href="/sc-caeb2/css/signin.css" rel="stylesheet">

<%
	String username = request.getAttribute(Constants.ATT_USERNAME) == null ?
			"" : (String) request.getAttribute(Constants.ATT_USERNAME);
%>

<div class="container-fluid">
	<form class="form-signin" action="<%=Constants.EXEC_ACTION%>login" method="POST">

		<h4 class="form-signin-heading text-center"><%=Constants.JSP_LOGIN_TITLE%></h4>

		<label for="user" class="sr-only"><%=Constants.JSP_USER%></label>
		<input type="text" id="<%=Constants.ATT_USERNAME%>" name="<%=Constants.ATT_USERNAME%>"
				class="form-control" placeholder="<%=Constants.JSP_USER%>" required autofocus
				value="<%=username%>">

		<label for="pass" class="sr-only"><%=Constants.JSP_PASS%></label>
		<input type="password" id="<%=Constants.ATT_PASSWORD%>" name="<%=Constants.ATT_PASSWORD%>"
				class="form-control" placeholder="<%=Constants.JSP_PASS%>" required>

<!-- 				<div class="checkbox"> -->
<!-- 					<label><input type="checkbox" value="remember-me">Recordarme</label> -->
<!-- 				</div> -->

		<button class="btn btn-lg btn-primary btn-block" type="submit">
			<%=Constants.JSP_SIGN_IN%>
		</button>
	</form>
</div>

<%@include file="footer.jsp"%>
