<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Censo Comunitario - Consejo Comunal Andrés Eloy Blanco II</title>

	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">

	<!-- HTML5 shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="js/html5shiv.min.js"></script>
		<script src="js/respond.min.js"></script>
	<![endif]-->

</head>

<body>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-2.1.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

	<div class="container-fluid">
		<table class="table" style="margin-bottom: 0px;">
		<tbody>
			<tr>
				<td class="text-left">
					<a href="#">
						<img src="images/logoccaeb2.png" width="70px" height="70px"
								class="img-responsive text-left" alt="logoccaeb2">
					</a>
				</td>
				<td class="text-center">
					<h4>CENSO COMUNITARIO
						<br>
						<small>Consejo Comunal Andrés Eloy Blanco II</small>
					</h4>
				</td>
				<td class="text-right">
					<a href="#" onclick="about();">Acerca de</a>
				</td>
			</tr>
		</tbody>
		</table>
	</div>

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
						</ul>
					</li>
				</ul>
				<p class="navbar-text">Sección 1: Datos de la vivienda</p>
			</div><!-- /.navbar-collapse -->
		</nav>
	</div><!-- /.container-fluid -->
