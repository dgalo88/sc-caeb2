
	<%@page import="com.caeb2.util.Parameters"%>
<div class="container-fluid">
		<nav class="navbar navbar-default">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							Menú
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Nueva encuesta</a></li>
							<li><a href="#">Buscar</a></li>
							<li class="divider"></li>
							<li><a href="#">Perfil</a></li>
							<li><a href="#">Salir</a></li>
						</ul>
					</li>
				</ul>
				<p class="navbar-text">
					<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
					<%= Parameters.getTitle() %>
				</p>
			</div><!-- /.navbar-collapse -->
		</nav>
	</div><!-- /.container-fluid -->
