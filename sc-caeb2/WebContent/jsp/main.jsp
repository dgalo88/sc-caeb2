<%@include file="header.jsp"%>

<%
	Parameters.setTitle("Inicio");
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<div class="form-group center-block text-center main-panel">
		<table class="table">
			<tr>
				<td class="text-right">
					<div class="form-group">
						<button type="button" class="btn btn-primary btn-panel btn-panel-newPoll"
								id="newPoll" name="newPoll"
								data-toggle="tooltip" data-placement="top"
								title="<%=Constants.JSP_NEW_POLL%>">
						</button>
					</div>
				</td>
				<td width="130px">
					<div class="form-group">
						<a href="<%=Constants.ACTION_VIEW_DWELLINGS%>">
						<button type="button" class="btn btn-primary btn-panel btn-panel-search"
								id="search" name="search"
								data-toggle="tooltip" data-placement="top"
								title="<%=Constants.JSP_VIEW_DWELLINGS%>">
						</button></a>
					</div>
				</td>
				<td class="text-left">
					<div class="form-group">
						<a href="<%=Constants.ACTION_GEN_FORMALITY%>">
						<button type="button" class="btn btn-primary btn-panel btn-panel-genFormality"
								id="genFormality"
								name="genFormality"
								data-toggle="tooltip" data-placement="top"
								title="<%=Constants.JSP_GEN_FORMALITY%>">
						</button></a>
					</div>
				</td>
			</tr>
			<tr>
				<td class="text-right">
					<div class="form-group">
						<a href="<%=Constants.ACTION_BACKUP%>">
						<button type="button" class="btn btn-primary btn-panel btn-panel-backup"
								id="backup" name="backup"
								data-toggle="tooltip" data-placement="bottom"
								title="<%=Constants.JSP_BACKUP%>" disabled>
						</button></a>
					</div>
				</td>
				<td width="130px">
					<div class="form-group">
						<a href="<%=Constants.ACTION_PROFILE%>">
						<button type="button" class="btn btn-primary btn-panel btn-panel-profile"
								id="profile" name="profile"
								data-toggle="tooltip" data-placement="bottom"
								title="<%=Constants.JSP_PROFILE%>">
						</button></a>
					</div>
				</td>
				<td class="text-left">
					<div class="form-group">
						<a href="<%=Constants.ACTION_EXIT%>">
						<button type="button" class="btn btn-primary btn-panel btn-panel-exit"
								id="exit" name="exit"
								data-toggle="tooltip" data-placement="bottom"
								title="<%=Constants.JSP_EXIT%>">
						</button></a>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>

<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<br>
			<div class="modal-body text-center" id="confirmBody">

				<div>
					<h4 class="text-center">Secreto de la Información</h4>
					<br>
					<p class="text-justify">
						<strong>Art. 19.</strong> Están amparadas por el secreto estadístico los datos obtenidos
						directamente o por medio de información administrativa, que por su contenido,
						estructura o grado de desagregación identifique a los informantes.
					</p>
					<p class="text-right">LFPE.</p>
					<br>
					<p class="text-center text-danger">
						<strong>¿Desea continuar la creación de una nueva encuesta?</strong>
					</p>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="cancel" data-dismiss="modal">
					<%=Constants.JSP_CANCEL%>
				</button>
				<a href="<%=Constants.ACTION_NEW_POLL%>">
					<button type="button" class="btn btn-primary" id="continue">
						<%=Constants.JSP_CONTINUE%>
					</button>
				</a>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).on('ready', function() {

		$('#newPoll').on('click', function() {
			$('#confirm').modal('show');
		});

	});
</script>

<%@include file="footer.jsp"%>
