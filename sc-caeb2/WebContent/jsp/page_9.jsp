<%@page import="com.caeb2.actions.bean.Ability"%>
<%@ include file="header.jsp"%>

<%
	Parameters.setPageNumber(9);
	Parameters.setTitle("Secci�n 5: Caracter�sticas individuales");
	Ability ability=new Ability();
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="que_HAOMD">�Qu� habilidad art�stica o manual domina?</label> 
						<table class="table table-control">
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox" value="Ninguna" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Ninguna")) ? "checked": ""%>>Ninguna</label><br>
											<label><input type="checkbox" value="Instrumentos de cuerda" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Instrumentos de cuerda")) ? "checked": ""%>>Instrumentos de cuerda</label><br>
											<label><input type="checkbox" value="Cocina" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Cocina")) ? "checked": ""%>>Cocina</label><br>
											<label><input type="checkbox" value="Corte y costure" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Corte y costure")) ? "checked": ""%>>Corte y costure</label><br>
											<label><input type="checkbox" value="Reposter�a" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Reposter�a")) ? "checked": ""%>>Reposter�a</label>
										</div>
									</div>
								</td>
								<td class="td-center-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox" value="Pintura" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Pintura")) ? "checked": ""%>>Pintura</label><br>
											<label><input type="checkbox" value="Teatro" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Teatro")) ? "checked": ""%>>Teatro</label><br>
											<label><input type="checkbox" value="Bordado" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Bordado")) ? "checked": ""%>>Bordado</label><br>
											<label><input type="checkbox" value="Peluquer�a" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Peluquer�a")) ? "checked": ""%>>Peluquer�a</label><br>
											<label><input type="checkbox" value="Computaci�n" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Computaci�n")) ? "checked": ""%>>Computaci�n</label>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox" value="Danza" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Danza")) ? "checked": ""%>>Danza</label><br>
											<label><input type="checkbox" value="Artesan�a" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Artesan�a")) ? "checked": ""%>>Artesan�a</label><br>
											<label><input type="checkbox" value="Canto" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Canto")) ? "checked": ""%>>Canto</label><br>
											<label><input type="checkbox" value="Manicure y pedicure" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Manicure y pedicure")) ? "checked": ""%>>Manicure y pedicure</label><br>
											<label><input type="checkbox" id="que_HAOMD_cual"  value="Otra �Cu�l?" name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>" <%= (ability.getArtistic_ability().containsKey("Otra �Cu�l?")) ? "checked": ""%>>Otra �Cu�l?</label>
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" required class="form-control" id="que_HAOMD_text" name="<%=Constants.SECTION9_ARTISTIC_ABILITY_OTHER%>" placeholder="�Cu�l?" <%=ability.getArtistic_ability_other().equals("") ? "style=\"display: none\"": ""%> value="<%=ability.getArtistic_ability_other()%>">
					</div>
					
					<div class="form-group">
						<label for="estaria_DAPECDF">�Estar�a dispuesto a participar en cursos de formaci�n?</label> 
						<div class="radio">
							<label><input type="radio" name="<%=Constants.SECTION9_TRAINING_COURSES%>" id="estaria_DAPECDF_si" <%=(ability.getTraining_courses().equals("S� �Cu�l de los anteriores?")) ? "checked": ""%> value="S� �Cu�l de los anteriores?">S� �Cu�l de los anteriores?</label>
							<label><input type="radio" name="<%=Constants.SECTION9_TRAINING_COURSES%>" id="estaria_DAPECDF_no" <%=(ability.getTraining_courses().equals("No")||ability.getTraining_courses().equals("")) ? "checked": ""%> value="No">No</label>
						</div>
						<div class="form-group" id="requiere_UDAOEM_div" <%=ability.getTraining_courses_which().equals("") ? "style=\"display: none\"": ""%>>
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION9_TRAINING_COURSES_WHICH%>" id="estaria_DAPECDF_cual_instructor" <%=(ability.getTraining_courses_which().equals("Como instructor o facilitador")) ? "checked": ""%> value="Como instructor o facilitador">Como instructor o facilitador</label>
								<label><input type="radio" name="<%=Constants.SECTION9_TRAINING_COURSES_WHICH%>" id="estaria_DAPECDF_cual_estudiante" <%=(ability.getTraining_courses_which().equals("Como estudiante o practicante")||ability.getTraining_courses_which().equals("")) ? "checked": ""%> value="Como estudiante o practicante">Como estudiante o practicante</label>
							</div>
							<select class="form-control" name="<%=Constants.SECTION9_TRAINING_COURSES_OPTIONS%>" id="estaria_DAPECDF_cual_select">
								<option value="Pintura" <%= ability.getTraining_courses_options().equals("Pintura") ? "selected": ""%>>Pintura</option>
								<option value="Danza" <%= ability.getTraining_courses_options().equals("Danza") ? "selected": ""%>>Danza</option>
								<option value="Instrumentos de cuerda" <%= ability.getTraining_courses_options().equals("Instrumentos de cuerda") ? "selected": ""%>>Instrumentos de cuerda</option>
								<option value="Teatro" <%= ability.getTraining_courses_options().equals("Teatro") ? "selected": ""%>>Teatro</option>
								<option value="Artesan�a" <%= ability.getTraining_courses_options().equals("Artesan�a") ? "selected": ""%>>Artesan�a</option>
								<option value="Cocina" <%= ability.getTraining_courses_options().equals("Cocina") ? "selected": ""%>>Cocina</option>
								<option value="Bordado" <%= ability.getTraining_courses_options().equals("Bordado") ? "selected": ""%>>Bordado</option>
								<option value="Canto" <%= ability.getTraining_courses_options().equals("Canto") ? "selected": ""%>>Canto</option>
								<option value="Corte y costure" <%= ability.getTraining_courses_options().equals("Corte y costure") ? "selected": ""%>>Corte y costure</option>
								<option value="Peluquer�a" <%= ability.getTraining_courses_options().equals("Peluquer�a") ? "selected": ""%>>Peluquer�a </option>
								<option value="Manicure y pedicure" <%= ability.getTraining_courses_options().equals("Manicure y pedicure") ? "selected": ""%>>Manicure y pedicure</option>
								<option value="Reposter�a" <%= ability.getTraining_courses_options().equals("Reposter�a") ? "selected": ""%>>Reposter�a</option>
								<option value="Computaci�n" <%= ability.getTraining_courses_options().equals("Computaci�n") ? "selected": ""%>>Computaci�n</option>
								<option value="Otra �Cu�l?" <%= ability.getTraining_courses_options().equals("Otra �Cu�l?") ? "selected": ""%>>Otra �Cu�l?</option>
							</select>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="cual_DLSDP">�Cu�l de los siguientes deportes practica?</label> 
						<table class="table table-control">
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox" value="Ninguna" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Ninguna")) ? "checked": ""%>>Ninguna</label><br>
											<label><input type="checkbox" value="Basketbol" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Basketbol")) ? "checked": ""%>>Basketbol</label><br>
											<label><input type="checkbox" value="Beisbol" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Beisbol")) ? "checked": ""%>>Beisbol</label><br>
											<label><input type="checkbox" id="cual_DLSDP_cual" value="Otro �Cu�l?" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Otro �Cu�l?")) ? "checked": ""%>>Otro �Cu�l?</label>
										</div>
									</div>
								</td>
								<td class="td-center-control">
									<div class="form-group">
										<div class="checkbox">
											<label> <input type="checkbox" value="F�tbol campo" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("F�tbol campo")) ? "checked": ""%>>F�tbol campo</label><br>
											<label> <input type="checkbox" value="Voleibol" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Voleibol")) ? "checked": ""%>>Voleibol</label><br>
											<label> <input type="checkbox" value="Nataci�n" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Nataci�n")) ? "checked": ""%>>Nataci�n</label>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<div class="checkbox">
											<label> <input type="checkbox" value="F�tbol sala" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("F�tbol sala")) ? "checked": ""%>>F�tbol sala</label><br>
											<label> <input type="checkbox" value="Softbol" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Softbol")) ? "checked": ""%>>Softbol</label><br>
											<label> <input type="checkbox" value="Atletismo" name="<%=Constants.SECTION9_PLAY_SPORTS%>" <%= (ability.getPlay_sports().containsKey("Atletismo")) ? "checked": ""%>>Atletismo</label>
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" required class="form-control" id="cual_DLSDP_text" name="<%=Constants.SECTION9_PLAY_SPORTS_OTHER%>" placeholder="�Cu�l?" <%=ability.getPlay_sports_other().equals("") ? "style=\"display: none\"": ""%> value="<%=ability.getPlay_sports_other()%>">
					</div>
					
					<div class="form-group">
						<label for="bajo_QCLGPDELC">�Bajo qu� condiciones le gustar�a participar deportivamente en la comunidad?</label> 
						<div class="radio">
							<label><input type="radio" name="<%=Constants.SECTION9_PARTICIPATE_ATHLETICALLY%>" id="bajo_QCLGPDELC_cual_instructor" <%=(ability.getParticipate_athletically().equals("Como instructor o facilitador")) ? "checked": ""%> value="Como instructor o facilitador">Como instructor o facilitador</label>
							<label><input type="radio" name="<%=Constants.SECTION9_PARTICIPATE_ATHLETICALLY%>" id="bajo_QCLGPDELC_cual_estudiante" <%=(ability.getParticipate_athletically().equals("Como estudiante o practicante")||ability.getParticipate_athletically().equals("")) ? "checked": ""%> value="Como estudiante o practicante">Como estudiante o practicante</label>
						</div>
						<select class="form-control" name="<%=Constants.SECTION9_PARTICIPATE_WHICH%>" id="bajo_QCLGPDELC_cual_select">
							<option value="F�tbol campo" <%= ability.getTraining_courses_options().equals("F�tbol campo") ? "selected": ""%>>F�tbol campo</option>
							<option value="F�tbol sala" <%= ability.getTraining_courses_options().equals("F�tbol sala") ? "selected": ""%>>F�tbol sala</option>
							<option value="Basketbol" <%= ability.getTraining_courses_options().equals("Basketbol") ? "selected": ""%>>Basketbol</option>
							<option value="Voleibol" <%= ability.getTraining_courses_options().equals("Voleibol") ? "selected": ""%>>Voleibol</option>
							<option value="Softbol" <%= ability.getTraining_courses_options().equals("Softbol") ? "selected": ""%>>Softbol</option>
							<option value="Beisbol" <%= ability.getTraining_courses_options().equals("Beisbol") ? "selected": ""%>>Beisbol</option>
							<option value="Nataci�n" <%= ability.getTraining_courses_options().equals("Nataci�n") ? "selected": ""%>>Nataci�n</option>
							<option value="Atletismo" <%= ability.getTraining_courses_options().equals("Atletismo") ? "selected": ""%>>Atletismo</option>
							<option value="Otra" <%= ability.getTraining_courses_options().equals("Otra") ? "selected": ""%>>Otra</option>
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
