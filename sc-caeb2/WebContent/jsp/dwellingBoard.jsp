<%@page import="com.caeb2.actions.BoardsManager"%>
<%@page import="com.caeb2.util.TextUtils"%>
<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%@include file="header.jsp"%>

<%
	Parameters.setTitle("Viviendas");

	String dwellingsJSON = BoardsManager.loadAllDwellings();
%>

<script type="text/javascript">
	$(document).ready(function() {

		<%if (TextUtils.isEmptyOrNull(dwellingsJSON)) {%>
			showError('<%=Constants.NO_DATA_ERROR%>');
		<%} else {%>
			loadDatatable();
		<%}%>

	});

	function loadDatatable() {

		var jsonData = JSON.parse('<%=dwellingsJSON%>');

		$('#dwellingsData').on('draw.dt', function () {
			init();
		}).dataTable({
			'scrollY': '450px',
			'scrollCollapse': true,
			'language': {
				'url': '/sc-caeb2/js/Spanish.json'
			},
			'data': jsonData.data,
			'columns': jsonData.columns
		});

	}

	function init() {

		$('[data-toggle="tooltip"]').tooltip();

		$('.viewDwellingBtn').on('click', function() {

			console.log('viewDwellingBtn on click = ' + $(this).attr('data-dwelling-id'));

			window.location.href = '<%=Constants.EXEC_ACTION + "loadAllHomes"%>&dwellingId='
										+ $(this).attr('data-dwelling-id');

		});

		$('.editDwellingBtn').on('click', function() {
			console.log('editDwellingBtn on click = ' + $(this).attr('data-dwelling-id'));
		});

		$('.deleteDwellingBtn').on('click', function() {
			console.log('deleteDwellingBtn on click = ' + $(this).attr('data-dwelling-id'));
		});

	}
</script>

<%@include file="navbar.jsp"%>

<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/dataTables.bootstrap.css"/>

<script src="/sc-caeb2/js/jquery.dataTables.min.js"></script>
<script src="/sc-caeb2/js/dataTables.bootstrap.min.js"></script>

<div class="container-fluid">
	<div class="container table-responsive">

		<br>
		<table id="dwellingsData" class="table table-striped table-bordered"></table>

		<div class="btn-footer">
			<a href="<%=Constants.ACTION_HOME%>">
				<button type="button" class="btn btn-default" id="backBtn"><%=Constants.JSP_COMEBACK%></button>
			</a>
			<a href="<%=Constants.ACTION_NEW_POLL%>">
				<button type="button" class="btn btn-primary" id="newPollBtn"><%=Constants.JSP_NEW_POLL%></button>
			</a>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>
