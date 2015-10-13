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

<%@include file="continueNewPoll.jsp"%>

<%@include file="footer.jsp"%>
