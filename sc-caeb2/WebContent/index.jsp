<%@page import="com.caeb2.util.Constants"%>

<%@ include file="jsp/header.jsp" %>

	<link href="css/signin.css" rel="stylesheet">

	<div class="container-fluid">
		<form class="form-signin" action="startup?<%=Constants.ACTION%>=login" method="POST">
			<h4 class="form-signin-heading text-center">Bienvenido</h4>
			<label for="user" class="sr-only">Usuario</label>
			<input type="text" id="user" name="user" class="form-control" placeholder="Usuario" required autofocus>
			<label for="pass" class="sr-only">Contrase�a</label>
			<input type="password" id="pass" name="pass" class="form-control" placeholder="Contrase�a" required>
	<!-- 				<div class="checkbox"> -->
	<!-- 					<label><input type="checkbox" value="remember-me">Recordarme</label> -->
	<!-- 				</div> -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar sesi�n</button>
		</form>
	</div>

<%@ include file="jsp/footer.jsp" %>