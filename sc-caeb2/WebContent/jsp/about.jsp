<%@page import="com.caeb2.util.Constants"%>

<div class="modal fade" id="aboutModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title"><%=Constants.JSP_ABOUT%></h4>
			</div>
			<div class="modal-body">
				<p class="text-center"><%=Constants.CENSO_COMUNITARIO%></p>
				<p class="text-center"><%=Constants.CCAEB2%></p>
				<p class="text-justify">Proyecto de Servicio Comunitario desarrollado por los estudiantes
					de la Escuela de Ingeniería de Sistemas: Araujo Arnoely, Galo Donato, Hidalgo José Miguel,
					Porcar Marcelino, Velásquez Erik y Viloria Marco.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">
					<%=Constants.JSP_OK%>
				</button>
			</div>
		</div>
	</div>
</div>
