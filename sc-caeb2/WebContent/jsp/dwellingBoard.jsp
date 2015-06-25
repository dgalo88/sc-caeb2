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
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$.ajax({
			url: '<%=Constants.EXEC_ACTION + "loadAllDwellings"%>',
			method: 'POST',
			dataType: 'json',

			success: function(result, status, xhr) {

				console.log('result = ' + result);

				var jsonData = JSON.parse(result);

				console.log('jsonData = ' + jsonData);

				$('#dwellingsData').dataTable({
					"language": {
						"url": "/sc-caeb2/js/Spanish.json"
					},
					"data": jsonData.data,
					"columns": jsonData.columns,
				});

			},

			error: function(xhr, status, error) {
				showError(xhr.responseText);
			}
		});

	});
</script>

<%@ include file="footer.jsp"%>
