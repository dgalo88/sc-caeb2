<%@page import="com.caeb2.util.Constants"%>

<%@ include file="jsp/header.jsp" %>

<link href="css/signin.css" rel="stylesheet">

<div class="container-fluid">
	<form class="form-signin" action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=login" method="POST">
		<h4 class="form-signin-heading text-center"><%=Constants.JSP_LOGIN_TITLE%></h4>
		<label for="user" class="sr-only"><%=Constants.JSP_USER%></label>
		<input type="text" id="user" name="user" class="form-control" placeholder="<%=Constants.JSP_USER%>" required autofocus>
		<label for="pass" class="sr-only"><%=Constants.JSP_PASS%></label>
		<input type="password" id="pass" name="pass" class="form-control" placeholder="<%=Constants.JSP_PASS%>" required>
<!-- 				<div class="checkbox"> -->
<!-- 					<label><input type="checkbox" value="remember-me">Recordarme</label> -->
<!-- 				</div> -->
		<button class="btn btn-lg btn-primary btn-block" type="submit"><%=Constants.JSP_SIGN_IN%></button>
	</form>
</div>

<%@ include file="jsp/footer.jsp" %>