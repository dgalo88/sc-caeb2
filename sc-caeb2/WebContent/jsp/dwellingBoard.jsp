<%@page import="com.caeb2.actions.BoardsManager"%>
<%@page import="com.caeb2.util.TextUtils"%>
<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%@include file="header.jsp"%>

<%
	Parameters.setTitle("Viviendas");

	String dwellingsJSON = BoardsManager.loadAllDwellings();
%>

<%@include file="loader.jsp"%>

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

			window.location.href = '<%=Constants.EXEC_ACTION%>loadAllHomes'
										+ '&<%=Constants.ATT_DWELLING_ID%>='
										+ $(this).attr('data-dwelling-id');

		});

		$('.editDwellingBtn').on('click', function() {

			showLoader();

			$.ajax({

				url: '<%=Constants.EXEC_ACTION%>editDwelling'
						+'&<%=Constants.ATT_DWELLING_ID%>='
						+ $(this).attr('data-dwelling-id'),

				method: 'POST',

				success: function(data) {

					window.location.href = 'page_1.jsp'
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

		$('.deleteDwellingBtn').on('click', function() {
			$('#confirm').modal('show');
		});

		$('#confirmYes').on('click', function() {

			showLoader();

			$.ajax({

				url: '<%=Constants.EXEC_ACTION%>deleteDwelling'
						+ '&<%=Constants.ATT_DWELLING_ID%>='
						+ $(this).attr('data-dwelling-id'),

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
		<table id="dwellingsData" class="table table-striped table-bordered"></table>

		<div class="btn-footer">
			<a href="<%=Constants.ACTION_HOME%>">
				<button type="button" class="btn btn-default" id="backBtn">
					<%=Constants.JSP_COMEBACK%>
				</button>
			</a>
			<button type="button" class="btn btn-primary" id="newPoll">
				<%=Constants.JSP_NEW_DWELLING%>
			</button>
		</div>
	</div>
</div>

<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<br>
			<div class="modal-body text-center" id="confirmQuestion">
				¿Está seguro que desea eliminar la vivienda?
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

<%@include file="continueNewPoll.jsp"%>

<%@include file="footer.jsp"%>
