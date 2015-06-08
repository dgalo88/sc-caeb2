<%@ include file="header.jsp"%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid text-center">
	<div class="form-group" style="width: 50% !important;">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<button type="button" class="btn btn-primary"
									id="<%=Constants.JSP_NEW_POLL%>"
									name="<%=Constants.JSP_NEW_POLL%>">
									<%=Constants.JSP_NEW_POLL%>
							</button>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<button type="button" class="btn btn-primary"
									id="<%=Constants.JSP_SEARCH%>"
									name="<%=Constants.JSP_SEARCH%>">
									<%=Constants.JSP_SEARCH%>
							</button>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<button type="button" class="btn btn-primary"
									id="<%=Constants.JSP_PROFILE%>"
									name="<%=Constants.JSP_PROFILE%>">
									<%=Constants.JSP_PROFILE%>
							</button>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<div class="form-group">
							<button type="button" class="btn btn-primary"
									id="<%=Constants.JSP_EXIT%>"
									name="<%=Constants.JSP_EXIT%>">
									<%=Constants.JSP_EXIT%>
							</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

	});
</script>

<%@ include file="footer.jsp"%>
