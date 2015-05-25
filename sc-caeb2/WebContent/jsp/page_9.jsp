<%@ include file="header.jsp"%>

<%
	int pageNumber = 9;
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=pageNumber%>" name="form_<%=pageNumber%>">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="que_HAOMD">¿Qué habilidad artística o manual domina?</label> 
						<table class="table table-control">
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox">Ninguna</label><br>
											<label><input type="checkbox">Instrumentos de cuerda</label><br>
											<label><input type="checkbox">Cocina</label><br>
											<label><input type="checkbox">Corte y costure</label><br>
											<label><input type="checkbox">Repostería</label>
										</div>
									</div>
								</td>
								<td class="td-center-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox">Pintura</label><br>
											<label><input type="checkbox">Teatro</label><br>
											<label><input type="checkbox">Bordado</label><br>
											<label><input type="checkbox">Peluquería</label><br>
											<label><input type="checkbox">Computación</label>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox">Danza</label><br>
											<label><input type="checkbox">Artesanía</label><br>
											<label><input type="checkbox">Canto</label><br>
											<label><input type="checkbox">Manicure y pedicure</label><br>
											<label><input type="checkbox" id="que_HAOMD_cual">Otra ¿Cuál?</label>
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" required class="form-control" id="que_HAOMD_text" name="que_HAOMD_text" placeholder="¿Cuál?" style="display: none">
					</div>
					
					<div class="form-group">
						<label for="estaria_DAPECDF">¿Estaría dispuesto a participar en cursos de formación?</label> 
						<div class="radio">
							<label><input type="radio" name="estaria_DAPECDF" id="estaria_DAPECDF_si">Sí ¿Cuál de los anteriores?</label>
							<label><input type="radio" name="estaria_DAPECDF" id="estaria_DAPECDF_no" checked="checked" >No</label>
						</div>
						<div class="form-group" id="requiere_UDAOEM_div" style="display: none">
							<div class="radio">
								<label><input type="radio" name="estaria_DAPECDF_cual" id="estaria_DAPECDF_cual_instructor">Como instructor o facilitador</label>
								<label><input type="radio" name="estaria_DAPECDF_cual" id="estaria_DAPECDF_cual_estudiante" checked="checked" >Como estudiante o practicante</label>
							</div>
							<select class="form-control" name="estaria_DAPECDF_cual_select" id="estaria_DAPECDF_cual_select">
								<option value="Pintura">Pintura</option>
								<option value="Danza">Danza</option>
								<option value="Instrumentos de cuerda">Instrumentos de cuerda</option>
								<option value="Teatro">Teatro</option>
								<option value="Artesanía ">Artesanía </option>
								<option value="Cocina">Cocina</option>
								<option value="Bordado">Bordado</option>
								<option value="Canto">Canto</option>
								<option value="Corte y costure">Corte y costure</option>
								<option value="Peluquería ">Peluquería </option>
								<option value="Manicure y pedicure">Manicure y pedicure</option>
								<option value="Repostería">Repostería</option>
								<option value="Computación">Computación</option>
								<option value="Otra ¿Cuál?">Otra ¿Cuál?</option>
							</select>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="cual_DLSDP">¿Cuál de los siguientes deportes practica?</label> 
						<table class="table table-control">
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox">Ninguna</label><br>
											<label><input type="checkbox">Basketbol</label><br>
											<label><input type="checkbox">Beisbol</label><br>
											<label><input type="checkbox" id="cual_DLSDP_cual">Otro ¿Cuál?</label>
										</div>
									</div>
								</td>
								<td class="td-center-control">
									<div class="form-group">
										<div class="checkbox">
											<label> <input type="checkbox">Fútbol campo</label><br>
											<label> <input type="checkbox">Voleibol</label><br>
											<label> <input type="checkbox">Natación</label>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<div class="checkbox">
											<label> <input type="checkbox">Fútbol sala</label><br>
											<label> <input type="checkbox">Softbol</label><br>
											<label> <input type="checkbox">Atletismo</label>
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" required class="form-control" id="cual_DLSDP_text" name="cual_DLSDP_text" placeholder="¿Cuál?" style="display: none">
					</div>
					
					<div class="form-group">
						<label for="bajo_QCLGPDELC">¿Bajo qué condiciones le gustaría participar deportivamente en la comunidad?</label> 
						<div class="radio">
							<label><input type="radio" name="bajo_QCLGPDELC_cual" id="bajo_QCLGPDELC_cual_instructor">Como instructor o facilitador</label>
							<label><input type="radio" name="bajo_QCLGPDELC_cual" id="bajo_QCLGPDELC_cual_estudiante" checked="checked" >Como estudiante o practicante</label>
						</div>
						<select class="form-control" name="bajo_QCLGPDELC_cual_select" id="bajo_QCLGPDELC_cual_select">
							<option value="Fútbol campo">Fútbol campo</option>
							<option value="Fútbol sala">Fútbol sala</option>
							<option value="Basketbol">Basketbol</option>
							<option value="Voleibol">Voleibol</option>
							<option value="Softbol">Softbol</option>
							<option value="Beisbol">Beisbol</option>
							<option value="Natación">Natación</option>
							<option value="Atletismo">Atletismo</option>
							<option value="Otra">Otra</option>
						</select>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
		$('#que_HAOMD_cual').on('change', function (e) {
		    if($(this).is(':checked')){
		    	$('#que_HAOMD_text').show();	
		    }else{
		    	$('#que_HAOMD_text').hide()
		    }
		});
			
		$('#cual_DLSDP_cual').on('change', function (e) {
		    if($(this).is(':checked')){
		    	$('#cual_DLSDP_text').show();	
		    }else{
		    	$('#cual_DLSDP_text').hide()
		    }
		});
		
		
		$('#estaria_DAPECDF_si').change(function() {
			$('#requiere_UDAOEM_div').show();
		});
		$('#estaria_DAPECDF_no').change(function() {
			$('#requiere_UDAOEM_div').hide();
		});
		
		
	});
</script>

<%@ include file="footer.jsp"%>
