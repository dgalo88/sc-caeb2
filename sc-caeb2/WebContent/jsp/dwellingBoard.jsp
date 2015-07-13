<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%@ include file="header.jsp"%>

<%
	Parameters.setTitle("Viviendas");
%>

<%@ include file="navbar.jsp"%>

<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/dataTables.bootstrap.css"/>

<script src="/sc-caeb2/js/jquery.dataTables.min.js"></script>
<script src="/sc-caeb2/js/dataTables.bootstrap.min.js"></script>

<div class="container-fluid">
	<div class="container table-responsive">

		<table id="dwellingsData" class="table table-striped table-bordered"></table>

		<div class="btn-footer">
			<a href="<%=Constants.ACTION_HOME%>">
				<button type="button" class="btn btn-default" id="backBtn">Volver</button>
			</a>
			<a href="<%=Constants.ACTION_NEW_POLL%>">
				<button type="button" class="btn btn-primary" id="newPollBtn">Nueva encuesta</button>
			</a>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$.ajax({

			url: '<%=Constants.EXEC_ACTION + "loadAllDwellings"%>',
			method: 'POST',

			success: function(data) {

				var jsonData = JSON.parse(data);

				$('#dwellingsData').dataTable({
					'scrollY': '450px',
					'scrollCollapse': true,
					'language': {
						'url': '/sc-caeb2/js/Spanish.json'
					},
					'data': jsonData.data,
					'columns': jsonData.columns
				});

			},

			error: function(xhr, status, error) {

				var msg = xhr.responseText == 'null' ?
						'<%=Constants.GENERAL_ERROR%>'
						: xhr.responseText;
				showError(msg);

			}

		});

	});
</script>

<%@ include file="footer.jsp"%>
