<%@page import="com.caeb2.actions.BoardsManager"%>
<%@page import="com.caeb2.util.TextUtils"%>
<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%@include file="header.jsp"%>

<%
	Parameters.setTitle(Constants.JSP_HOMES);

	String dwellingIdStr = (String) request.getParameter(Constants.ATT_DWELLING_ID);

	int dwellingId = TextUtils.isEmptyOrNull(dwellingIdStr) ? -1 : Integer.valueOf(dwellingIdStr);

	String homesJSON = BoardsManager.loadAllHomes(dwellingId);

	String newHomeAction = Constants.ACTION_NEW_HOME
			+ "&" + Constants.ATT_DWELLING_ID + "=" + String.valueOf(dwellingId);
%>

<%@include file="loader.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {

		<%if (TextUtils.isEmptyOrNull(homesJSON)) {%>
			showError('<%=Constants.NO_DATA_ERROR%>');
		<%} else {%>
			loadDatatable();
		<%}%>

	});

	function loadDatatable() {

		var jsonData = JSON.parse('<%=homesJSON%>');

		$('#homesData').on('draw.dt', function () {
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

		$('.viewHomeBtn').on('click', function() {

			window.location.href = '<%=Constants.EXEC_ACTION%>loadAllPersons'
				+ '&<%=Constants.ATT_DWELLING_ID + "=" + String.valueOf(dwellingId)%>'
				+ '&<%=Constants.ATT_HOME_ID%>=' + $(this).attr('data-home-id');

		});

		$('.editHomeBtn').on('click', function() {

			showLoader();

			$.ajax({

				url: '<%=Constants.EXEC_ACTION%>editHome'
						+ '&<%=Constants.ATT_DWELLING_ID + "=" + String.valueOf(dwellingId)%>'
						+ '&<%=Constants.ATT_HOME_ID%>=' + $(this).attr('data-home-id'),

				method: 'POST',

				success: function(data) {

					window.location.href = 'page_4.jsp'
							+ '?' + '<%=Constants.ATT_MESSAGE%>=' + data
							+ '&' + '<%=Constants.ATT_NOTIFICATION + "=" + Constants.ALERT_SUCCESS%>';

					hideLoader();

				},

				error: function(xhr, status, error) {

					hideLoader();

					var msg = xhr.responseText == 'null' ?
							'<%=Constants.GENERAL_ERROR%>'
							: xhr.responseText;
					showError(msg);

				}

			});

		});

		$('.deleteHomeBtn').on('click', function() {
			$('#confirm').modal('show');
		});

		$('#confirmYes').on('click', function() {

			showLoader();

			$.ajax({

				url: '<%=Constants.EXEC_ACTION%>deleteHome'
						+ '&<%=Constants.ATT_HOME_ID%>='
						+ $(this).attr('data-home-id'),

				method: 'POST',

				success: function(data) {

					showSuccess(data);
					hideLoader();

				},

				error: function(xhr, status, error) {

					hideLoader();

					var msg = xhr.responseText == 'null' ?
							'<%=Constants.GENERAL_ERROR%>'
							: xhr.responseText;
					showError(msg);

				}

			});

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
		<h4 class="text-center"><%=Constants.JSP_HOMES%></h4>
		<table id="homesData" class="table table-striped table-bordered"></table>

		<div class="btn-footer">
			<a href="<%=Constants.EXEC_ACTION + "loadAllDwellings"%>">
				<button type="button" class="btn btn-default" id="backBtn">
					<%=Constants.JSP_COMEBACK%>
				</button>
			</a>
			<a href="<%=newHomeAction%>">
				<button type="button" class="btn btn-primary" id="newHomeBtn">
					<%=Constants.JSP_NEW_HOME%>
				</button>
			</a>
		</div>
	</div>
</div>

<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<br>
			<div class="modal-body text-center" id="confirmQuestion">
				¿Está seguro que desea eliminar el hogar?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" id="confirmYes">
					<%=Constants.JSP_YES%>
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal" id="confirmNo">
					<%=Constants.JSP_NO%>
				</button>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>
