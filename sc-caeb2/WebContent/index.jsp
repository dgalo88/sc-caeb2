<%@ include file="jsp/header.jsp" %>

		<div class="bar">
			<div class="btn-group">
				<button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
					<span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#">Separated link</a></li>
				</ul>
				<p class="label label-default">Sección 1: Datos de la vivienda</p>
			</div>
		</div>

		<div class="contentPane container" align="center">
			<form class="form-signin" action="http://localhost:8080/sc-caeb2/
			startup" method="get">
				<h4 class="form-signin-heading">Por favor ingrese sus datos</h4>
				<label for="inputEmail" class="sr-only">Usuario</label>
				<input type="text" id="inputEmail" name="user" class="form-control" placeholder="Usuario" required="" autofocus="">
				<label for="inputPassword" class="sr-only">Contraseña</label>
				<input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Contraseña" required="">
				<div class="checkbox">
					<label><input type="checkbox" value="remember-me">Recordarme</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			</form>
		</div>

<%@ include file="jsp/footer.jsp" %>