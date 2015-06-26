<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%@ include file="header.jsp"%>

<%
	Parameters.setTitle("Viviendas");
%>

<%-- <%@ include file="navbar.jsp"%> --%>

<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/dataTables.bootstrap.css"/>

<script src="/sc-caeb2/js/jquery.dataTables.min.js"></script>
<script src="/sc-caeb2/js/dataTables.bootstrap.min.js"></script>

<div class="container-fluid">
	<div class="container table-responsive">
		<table id="dwellingsData" class="table table-striped table-bordered"></table>
		<div class="btn-footer">
			<button type="button" class="btn btn-default" id="backBtn">Volver</button>
			<button type="button" class="btn btn-primary" id="newPollBtn">Nueva encuesta</button>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$('#dwellingsData').dataTable({
			"scrollY": "450px",
			"scrollCollapse": true,
			"language": {
				"url": "/sc-caeb2/js/Spanish.json"
			},
			"ajax": '<%=Constants.EXEC_ACTION + "loadAllDwellings"%>',
			"columns":[
				{ "data": "id", "title": "Id"},
				{ "data": "name", "title": "Nombre o número"},
				{ "data": "address", "title": "Dirección"},
				{ "data": "pollNumber", "title": "Número de encuesta"}
			]
		});

	});
</script>

<%@ include file="footer.jsp"%>
