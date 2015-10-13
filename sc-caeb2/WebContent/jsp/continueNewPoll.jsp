
<%@page import="com.caeb2.util.Constants"%>

<div class="modal fade" id="continueNewPoll" tabindex="-1" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<br>
			<div class="modal-body text-center" id="continueNewPollBody">

				<div>
					<h4 class="text-center">Secreto de la Informaci�n</h4>
					<br>
					<p class="text-justify">
						<strong>Art. 19.</strong> Est�n amparadas por el secreto estad�stico los datos obtenidos
						directamente o por medio de informaci�n administrativa, que por su contenido,
						estructura o grado de desagregaci�n identifique a los informantes.
					</p>
					<p class="text-right">LFPE.</p>
					<br>
					<p class="text-center text-danger">
						<strong>�Desea continuar la creaci�n de una nueva encuesta?</strong>
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
			$('#continueNewPoll').modal('show');
		});

	});
</script>
