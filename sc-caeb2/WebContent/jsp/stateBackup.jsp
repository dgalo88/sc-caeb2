<%@include file="header.jsp"%>

<%
	Parameters.setTitle("Sincronización de Datos");
	String messageBackup=(String)request.getAttribute("messageBackup");
	String type=(String)request.getAttribute("type");
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
<form action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=ejecutarCopiado" method="POST">
	<div class="form-group center-block text-center main-panel">
		<div class="form-group">
			<label><%=messageBackup %></label>
			<%if(type!=null && type.equals("0")){%>
				<br>
				<br>
				<input type="submit" value="Siguiente" class="btn btn-primary" id="submitBtn<%=Parameters.getPageNumber()%>">
			<%}%>
		</div>
	</div>
</form>
</div>

<%@include file="continueNewPoll.jsp"%>

<%@include file="footer.jsp"%>