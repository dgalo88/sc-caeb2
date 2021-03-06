<%@page import="com.caeb2.util.TextUtils"%>
<%@page import="com.caeb2.util.Constants"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String message = null;

	if (request.getAttribute(Constants.ATT_MESSAGE) != null) {
		message = (String) request.getAttribute(Constants.ATT_MESSAGE);
	} else if (!TextUtils.isEmptyOrNull(request.getParameter(Constants.ATT_MESSAGE))) {
		message = request.getParameter(Constants.ATT_MESSAGE);
	}

	String notification = request.getParameter(Constants.ATT_NOTIFICATION);

	if (TextUtils.isEmptyOrNull(notification)) {
		notification = Constants.ALERT_INFO;
	}
%>

<!DOCTYPE html>

<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title><%=Constants.CENSO_COMUNITARIO%> - <%=Constants.CCAEB2%></title>

	<link rel="shortcut icon" href="/sc-caeb2/images/favicon.ico">

	<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/normalize.css"/>

	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/bootstrap.min.css">

	<!-- HTML5 shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="/sc-caeb2/js/html5shiv.min.js"></script>
		<script src="/sc-caeb2/js/respond.min.js"></script>
	<![endif]-->

	<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/styles.css">

	<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/datepicker.css"/>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/sc-caeb2/js/jquery-2.1.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/sc-caeb2/js/bootstrap.min.js"></script>

	<script src="/sc-caeb2/js/bootstrap-datepicker.js"></script>

	<script src="/sc-caeb2/js/notifications.js"></script>

	<script type="text/javascript">
		$(document).on('ready', function() {

			$('[data-toggle="tooltip"]').tooltip();

			<%if (!TextUtils.isEmptyOrNull(message)) {%>
				showNotification('<%=message%>', '<%=notification%>');
			<%}%>

		});
	</script>
</head>

<body>

	<%@include file="about.jsp"%>

	<div class="alert alert-dismissible notification hidden" role="alert" id="notification"></div>

	<div class="container-fluid">
		<table class="table" style="margin-bottom: 0px;">
		<tbody>
			<tr>
				<td class="text-left">
					<a href="<%=Constants.ACTION_HOME%>">
						<img src="<%=Constants.LOGO_CCAEB2%>" width="70px" height="70px"
								class="img-responsive text-left" alt="logoccaeb2">
					</a>
				</td>
				<td class="text-center">
					<h4><%=Constants.CENSO_COMUNITARIO%>
						<br>
						<small><%=Constants.CCAEB2%></small>
					</h4>
				</td>
				<td class="text-right">
					<button type="button" class="btn btn-link" data-toggle="modal" data-target="#aboutModal">
						<%=Constants.JSP_ABOUT%>
					</button>
				</td>
			</tr>
		</tbody>
		</table>
	</div>
