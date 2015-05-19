<%@page import="com.caeb2.util.Constants"%>

<%
	String errorMessage = (String) request.getAttribute(Constants.ATT_ERROR);

	if (errorMessage == null) {
		errorMessage = "Ha ocurrido un errorcito";
	}
%>

<%@ include file="header.jsp"%>

<script type="text/javascript">
	$(document).on('ready', function() {

// 		$('#datetimepicker').datetimepicker({
// 			timepicker: false,
// 			formatDate: 'Y/m/d',
// 			lang: 'es'
// 		});
		$('#dp2').datepicker();
// 		$('#dp3').datepicker();
// 		$('#dp4').datepicker();

	}); // end on ready
</script>

	<link rel="stylesheet" type="text/css" href="/sc-caeb2/css/datepicker.css"/>
	<script src="/sc-caeb2/js/bootstrap-datepicker.js"></script>

	<div class="container-fluid">
		<div class="container panel-error text-center">
			<div class="panel panel-danger">
				<div class="panel-heading"><%=Constants.JSP_ERROR%></div>
				<div class="panel-body"><%=errorMessage%></div>
			</div>
			<button type="button" class="btn btn-danger"><%=Constants.JSP_RETURN%></button>
<!-- 			<input id="datetimepicker" data-provide="dp2"> -->
<!-- 			<input type="text" class="span2" id="dp2"> -->
			<div class="form-group">
				<label for="dp2">Fecha</label>
				<input type="text" class="form-control" id="dp2" placeholder="Ej. 13/05/1982">
			</div>
	</div>

<!-- 		<div class="input-append date" id="dp3" data-date="12/02/2012" data-date-format="dd/mm/yyyy"> -->
<!-- 			<input class="span2" size="16" type="text" value="12/02/2012"> -->
<!-- 			<span class="add-on"><i class="icon-th"></i></span> -->
<!-- 		</div> -->
	
<!-- 		<div id="dp4" data-date="12/03/2012">aqui</div> -->
	</div>

<%@ include file="footer.jsp"%>