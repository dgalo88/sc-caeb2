<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form>
		<table class="table">
			<tr>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="que_HAOMD">�Que habilidad art�stica o manual domina?</label> 
							<table width="100%">
								<tr>
									<td valign="top">
										<div class="form-group">
											<div class="checkbox">
												<label> <input type="checkbox">Ninguna</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Instrumentos de cuerda</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Cocina</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Corte y costure</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Reposter�a</label>
											</div>
										</div>
									</td>
									<td valign="top">
										<div class="form-group">
											<div class="checkbox">
												<label> <input type="checkbox">Pintura</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Teatro</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Bordado</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Peluquer�a</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Computaci�n</label>
											</div>
										</div>
									</td>
									<td valign="top">
										<div class="form-group">
											<div class="checkbox">
												<label> <input type="checkbox">Danza</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Artesan�a</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Canto</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Manicure y pedicure</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox" id="que_HAOMD_cual">Otra �Cu�l?</label>
											</div>
										</div>
									</td>
								</tr>
							</table>
							<input type="text" required class="form-control" id="que_HAOMD_text" name="que_HAOMD_text" placeholder="�Cu�l?" style="display: none">
						</div>
						
						<div class="form-group">
							<label for="estaria_DAPECDF">�Estar�a dispuesto a participar en cursos de formaci�n?</label> 
							<div class="radio">
								<label><input type="radio" name="estaria_DAPECDF" id="estaria_DAPECDF_si">Si �Cu�l de los anteriores?</label>
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
									<option value="Artesan�a ">Artesan�a </option>
									<option value="Cocina">Cocina</option>
									<option value="Bordado">Bordado</option>
									<option value="Canto">Canto</option>
									<option value="Corte y costure">Corte y costure</option>
									<option value="Peluquer�a ">Peluquer�a </option>
									<option value="Manicure y pedicure">Manicure y pedicure</option>
									<option value="Reposter�a">Reposter�a</option>
									<option value="Computaci�n">Computaci�n</option>
									<option value="Otra �Cu�l?">Otra �Cu�l?</option>
								</select>
							</div>
						</div>
					</div>
				</td>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="cual_DLSDP">�Cu�l de los siguientes deportes practica?</label> 
							<table width="100%">
								<tr>
									<td valign="top">
										<div class="form-group">
											<div class="checkbox">
												<label> <input type="checkbox">Ninguna</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Basketbol</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Beisbol</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox" id="cual_DLSDP_cual">Otra �Cu�l?</label>
											</div>
										</div>
									</td>
									<td valign="top">
										<div class="form-group">
											<div class="checkbox">
												<label> <input type="checkbox">Futbol campo</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Voleibol</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Nataci�n</label>
											</div>
										</div>
									</td>
									<td valign="top">
										<div class="form-group">
											<div class="checkbox">
												<label> <input type="checkbox">Futbol sala</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Softbol</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">Atletismo</label>
											</div>
										</div>
									</td>
								</tr>
							</table>
							<input type="text" required class="form-control" id="cual_DLSDP_text" name="cual_DLSDP_text" placeholder="�Cu�l?" style="display: none">
						</div>
						
						<div class="form-group">
							<label for="bajo_QCLGPDELC">�Bajo qu� condiciones le gustar�a participar deportivamente en la comunidad?</label> 
							<div class="radio">
								<label><input type="radio" name="bajo_QCLGPDELC_cual" id="bajo_QCLGPDELC_cual_instructor">Como instructor o facilitador</label>
								<label><input type="radio" name="bajo_QCLGPDELC_cual" id="bajo_QCLGPDELC_cual_estudiante" checked="checked" >Como estudiante o practicante</label>
							</div>
							<select class="form-control" name="bajo_QCLGPDELC_cual_select" id="bajo_QCLGPDELC_cual_select">
								<option value="Futbol campo">Futbol campo</option>
								<option value="Futbol sala">Futbol sala</option>
								<option value="Basketbol">Basketbol</option>
								<option value="Voleibol">Voleibol</option>
								<option value="Softbol">Softbol</option>
								<option value="Beisbol">Beisbol</option>
								<option value="Nataci�n">Nataci�n</option>
								<option value="Atletismo">Atletismo</option>
								<option value="Otra">Otra</option>
							</select>
						</div>
					</div>
				</td>
			</tr>
<!-- 			<tr><td></td><td valign="top" align="right"><button class="btn btn-lg btn-primary btn-block" type="submit" style="width: initial;">Siguiente</button></td></tr> -->
		</table>
	</form>
</div>
<script>
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