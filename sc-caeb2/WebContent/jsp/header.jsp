<%@page import="com.caeb2.util.Constants"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><%=Constants.CENSO_COMUNITARIO%> - <%=Constants.CCAEB2%></title>

	<!-- Bootstrap -->
	<link href="/sc-caeb2/css/bootstrap.min.css" rel="stylesheet">

	<!-- HTML5 shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="/sc-caeb2/js/html5shiv.min.js"></script>
		<script src="/sc-caeb2/js/respond.min.js"></script>
	<![endif]-->

	<link href="/sc-caeb2/css/styles.css" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/datepicker.css"/>

</head>

<body>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/sc-caeb2/js/jquery-2.1.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/sc-caeb2/js/bootstrap.min.js"></script>

	<script src="/sc-caeb2/js/bootstrap-datepicker.js"></script>

	<script src="/sc-caeb2/js/notifications.js"></script>

	<div class="container-fluid">
		<table class="table" style="margin-bottom: 0px;">
		<tbody>
			<tr>
				<td class="text-left">
					<a href="#">
						<img src="/sc-caeb2/images/logoccaeb2New.png" width="70px" height="70px"
								class="img-responsive text-left" alt="logoccaeb2New">
					</a>
				</td>
				<td class="text-center">
					<h4><%=Constants.CENSO_COMUNITARIO%>
						<br>
						<small><%=Constants.CCAEB2%></small>
					</h4>
				</td>
				<td class="text-right">
					<a href="#" onclick="about();">Acerca de</a>
				</td>
			</tr>
		</tbody>
		</table>
	</div>

	<div class="alert alert-dismissible notification hidden" role="alert" id="notification"></div>
