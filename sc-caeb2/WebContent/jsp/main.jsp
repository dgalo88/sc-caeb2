<%@ include file="header.jsp"%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<div class="form-group center-block text-center main-panel">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<a href="<%=Constants.ACTION_NEW_POLL%>">
							<button type="button" class="btn btn-primary btn-panel btn-panel-newPoll"
									id="<%=Constants.JSP_NEW_POLL%>"
									name="<%=Constants.JSP_NEW_POLL%>"
									data-toggle="tooltip" data-placement="left"
									title="Nueva encuesta">
							</button></a>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<a href="<%=Constants.ACTION_SEARCH%>">
							<button type="button" class="btn btn-primary btn-panel btn-panel-search"
									id="<%=Constants.JSP_SEARCH%>"
									name="<%=Constants.JSP_SEARCH%>"
									data-toggle="tooltip" data-placement="right"
									title="Buscar">
							</button></a>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<div class="form-group">
							<a href="<%=Constants.ACTION_PROFILE%>">
							<button type="button" class="btn btn-primary btn-panel btn-panel-profile"
									id="<%=Constants.JSP_PROFILE%>"
									name="<%=Constants.JSP_PROFILE%>"
									data-toggle="tooltip" data-placement="left"
									title="Perfil">
							</button></a>
						</div>
					</div>
				</td>
				<td>
					<div class="form-group">
						<div class="form-group">
							<a href="<%=Constants.ACTION_EXIT%>">
							<button type="button" class="btn btn-primary btn-panel btn-panel-exit"
									id="<%=Constants.JSP_EXIT%>"
									name="<%=Constants.JSP_EXIT%>"
									data-toggle="tooltip" data-placement="right"
									title="Salir">
							</button></a>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip()
	});
</script>

<%@ include file="footer.jsp"%>
