<%@page import="com.caeb2.sections.EducationLevel"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(7);
	Parameters.setTitle("Sección 5: Características individuales");
	EducationLevel educationLevel= new EducationLevel(request.getRequestedSessionId());
%>

<%@include file="validateCurrentPage.jsp"%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
<%-- 	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"> --%>
<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveProcessPage7" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="ultimo_GA">Último grado aprobado</label> 
							<table class="table table-control">
  								<tr>
   					 				<td class="td-left-control">
										<select class="form-control" name="<%=Constants.SECTION7_DEGREE_APPROVED_TEXT%>" id="<%=Constants.SECTION7_DEGREE_APPROVED_TEXT%>">
											<option value="Ninguno" <%=educationLevel.getDegree_approved_text().equals("Ninguno") ? "selected": ""%>>Ninguno</option>
											<option value="Preescolar" <%=educationLevel.getDegree_approved_text().equals("Preescolar") ? "selected": ""%>>Preescolar</option>
											<option value="Básico (1-9) / Primaria (1-6)" <%=educationLevel.getDegree_approved_text().equals("Básico (1-9) / Primaria (1-6)") ? "selected": ""%>>Básico (1-9) / Primaria (1-6)</option>
											<option value="Educación especial" <%=educationLevel.getDegree_approved_text().equals("Educación especial") ? "selected": ""%>>Educación especial</option>
											<option value="Media (1-2) / Bachillerato" <%=educationLevel.getDegree_approved_text().equals("Media (1-2) / Bachillerat") ? "selected": ""%>>Media (1-2) / Bachillerato</option>
											<option value="Técnico Medio (1-3)" <%=educationLevel.getDegree_approved_text().equals("Técnico Medio (1-3)") ? "selected": ""%>>Técnico Medio (1-3)</option>
											<option value="Técnico Superior" <%=educationLevel.getDegree_approved_text().equals("Técnico Superior") ? "selected": ""%>>Técnico Superior</option>
											<option value="Universitario" <%=educationLevel.getDegree_approved_text().equals("Universitario") ? "selected": ""%>>Universitario</option>
										</select>
									</td>
    								<td class="td-right-control">
    									<input type="number" required class="form-control" <%=educationLevel.getDegree_approved_text().equals("Ninguno")||educationLevel.getDegree_approved_text().equals("") ? "disabled" : "value='"+educationLevel.getDegree_approved_level()+"'"%> id="<%=Constants.SECTION7_DEGREE_APPROVED_LEVEL%>" name="<%=Constants.SECTION7_DEGREE_APPROVED_LEVEL%>" placeholder="Grado, semestre o año" >
    								</td>
  								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="usted_SE">Ud. Se encuentra</label> 
							<select class="form-control" name="<%=Constants.SECTION7_YOU_ARE%>" id="<%=Constants.SECTION7_YOU_ARE%>">
								<option value="Trabajando" <%=educationLevel.getYou_are().equals("Trabajando") ? "selected": ""%>>Trabajando</option>
								<option value="Sin trabajar pero tiene trabajo" <%=educationLevel.getYou_are().equals("Sin trabajar pero tiene trabajo") ? "selected": ""%>>Sin trabajar pero tiene trabajo</option>
								<option value="Buscando trabajo habiendo trabajado antes" <%=educationLevel.getYou_are().equals("Buscando trabajo habiendo trabajado antes") ? "selected": ""%>>Buscando trabajo habiendo trabajado antes</option>
								<option value="Buscando trabajo por primera vez" <%=educationLevel.getYou_are().equals("Buscando trabajo por primera vez") ? "selected": ""%>>Buscando trabajo por primera vez</option>
								<option value="En quehaceres del hogar" <%=educationLevel.getYou_are().equals("En quehaceres del hogar") ? "selected": ""%>>En quehaceres del hogar</option>
								<option value="Estudiando sin trabajo" <%=educationLevel.getYou_are().equals("Estudiando sin trabajo") ? "selected": ""%>>Estudiando sin trabajo</option>
								<option value="Como pensionado o jubilado sin trabajar" <%=educationLevel.getYou_are().equals("Como pensionado o jubilado sin trabajar") ? "selected": ""%>>Como pensionado o jubilado sin trabajar</option>
								<option value="Otra situación" <%=educationLevel.getYou_are().equals("Otra situación") ? "selected": ""%>>Otra situación</option>
							</select>
						</div>
						<div class="form-group">
							<label for="usted_E">¿Ud. Es?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION7_OCCUPATION%>" id="<%=Constants.SECTION7_OCCUPATION%>_empleado" <%=(educationLevel.getOccupation().equals("Empleado(a) u obrero(a)")||educationLevel.getOccupation().equals("")) ? "checked": ""%> value="Empleado(a) u obrero(a)">Empleado(a) u obrero(a)</label>
								<label><input type="radio" name="<%=Constants.SECTION7_OCCUPATION%>" id="<%=Constants.SECTION7_OCCUPATION%>_otro" <%=(educationLevel.getOccupation().equals("Otro")) ? "checked": ""%> value="Otro">Otro</label>
							</div>
							<select class="form-control" name="<%=Constants.SECTION7_OCCUPATION_VALUE%>" id="<%=Constants.SECTION7_OCCUPATION_VALUE%>_empleado" <%= (educationLevel.getOccupation().equals("Empleado(a) u obrero(a)")||educationLevel.getOccupation().equals("")) ? "": "style='display: none'"%>>
								<option value="Fijo(a)" <%=educationLevel.getOccupation_value().equals("Fijo(a)") ? "selected": ""%>>Fijo(a)</option>
								<option value="Contratado(a)" <%=educationLevel.getOccupation_value().equals("Contratado(a)") ? "selected": ""%>>Contratado(a)</option>
								<option value="Ocasional" <%=educationLevel.getOccupation_value().equals("Ocasional") ? "selected": ""%>>Ocasional</option>
							</select>
							<select class="form-control" name="<%=Constants.SECTION7_OCCUPATION_VALUE%>" id="<%=Constants.SECTION7_OCCUPATION_VALUE%>_otro" <%= (educationLevel.getOccupation().equals("Otro")) ? "": "style='display: none'"%>>
								<option value="Trabajador(a) por cuenta propia" <%=educationLevel.getOccupation_value().equals("Trabajador(a) por cuenta propia") ? "selected": ""%>>Trabajador(a) por cuenta propia</option>
								<option value="Empleador(a) o patrono(a)" <%=educationLevel.getOccupation_value().equals("Empleador(a) o patrono(a)") ? "selected": ""%>>Empleador(a) o patrono(a)</option>
								<option value="Miembro de cooperativa" <%=educationLevel.getOccupation_value().equals("Miembro de cooperativa") ? "selected": ""%>>Miembro de cooperativa</option>
								<option value="Ayudante familiar o no remunerado" <%=educationLevel.getOccupation_value().equals("Ayudante familiar o no remunerado") ? "selected": ""%>>Ayudante familiar o no remunerado</option>
								<option value="Servicio doméstico" <%=educationLevel.getOccupation_value().equals("Servicio doméstico") ? "selected": ""%>>Servicio doméstico</option>
							</select>
						</div>
						<div class="form-group">
							<label for="desempena_ST">Desempeña su trabajo:</label> 
							<select class="form-control" name="<%=Constants.SECTION7_WORK_PERFORMED%>" id="<%=Constants.SECTION7_WORK_PERFORMED%>">
								<option value="Dentro de la vivienda" <%=educationLevel.getWork_performed().equals("Dentro de la vivienda") ? "selected": ""%>>Dentro de la vivienda</option>
								<option value="En local anexo a la vivienda" <%=educationLevel.getWork_performed().equals("En local anexo a la vivienda") ? "selected": ""%>>En local anexo a la vivienda</option>
								<option value="En local o lugar exclusivo" <%=educationLevel.getWork_performed().equals("En local o lugar exclusivo") ? "selected": ""%>>En local o lugar exclusivo</option>
								<option value="En la calle (buhonero, puesto callejero, ...)" <%=educationLevel.getWork_performed().equals("En la calle (buhonero, puesto callejero, ...)") ? "selected": ""%>>En la calle (buhonero, puesto callejero, ...)</option>
								<option value="En kiosco" <%=educationLevel.getWork_performed().equals("En kiosco") ? "selected": ""%>>En kiosco</option>
								<option value="En mercado" <%=educationLevel.getWork_performed().equals("En mercado") ? "selected": ""%>>En mercado</option>
								<option value="En vehículo" <%=educationLevel.getWork_performed().equals("En vehículo") ? "selected": ""%>>En vehículo</option>
								<option value="Servicio a domicilio" <%=educationLevel.getWork_performed().equals("Servicio a domicilio") ? "selected": ""%>>Servicio a domicilio</option>
							</select>
						</div>
						<div class="form-group">
							<label for="parte_DTUOQDUTHPDOA">¿A parte del trabajo u oficio que desempeña Ud. tiene habilidades para desempeñar otra actividad?</label>
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION7_SKILLS_ACTIVITY%>" id="<%=Constants.SECTION7_SKILLS_ACTIVITY%>_si" <%=(educationLevel.getSkills_activity().equals("Sí ¿Cuál?")) ? "checked": ""%> value="Sí ¿Cuál?">Sí ¿Cuál?</label>
								<label><input type="radio" name="<%=Constants.SECTION7_SKILLS_ACTIVITY%>" id="<%=Constants.SECTION7_SKILLS_ACTIVITY%>_no" <%=(educationLevel.getSkills_activity().equals("No")||educationLevel.getSkills_activity().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
							<input type="text" class="form-control" id="<%=Constants.SECTION7_SKILLS_ACTIVITY_OPTION%>" name="<%=Constants.SECTION7_SKILLS_ACTIVITY_OPTION%>" <%= educationLevel.getSkills_activity().equals("Sí ¿Cuál?") ? "value='"+educationLevel.getSkills_activity_option()+"'": "style='display: none'"%> placeholder="¿Cuál?" >
						</div>
					</div>
				</td>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="profesion">Profesión</label> 
							<input type="text" class="form-control" id="<%=Constants.SECTION7_PROFESSION%>" name="<%=Constants.SECTION7_PROFESSION%>" <%= !educationLevel.getProfession().equals("") ? "value='"+educationLevel.getProfession()+"'": ""%> placeholder="Ej: Educador">
						</div>
						<div class="form-group">
							<label for="cual_ESOOCDTP">¿Cuál es su oficio o clase de trabajo principal?</label> 
							<input type="text" class="form-control" id="<%=Constants.SECTION7_MAIN_JOB%>" name="<%=Constants.SECTION7_MAIN_JOB%>" <%= !educationLevel.getMain_job().equals("") ? "value='"+educationLevel.getMain_job()+"'": ""%>placeholder="Ej: Educador">
						</div>
						<div class="form-group">
							<label for="negocio_OOEDTE">El negocio, organismo o empresa donde trabaja es:</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION7_BODY_WORKS%>" id="<%=Constants.SECTION7_BODY_WORKS%>" <%=(educationLevel.getBody_works().equals("Privado")||educationLevel.getBody_works().equals("")) ? "checked": ""%> value="Privado">Privado</label>
								<label><input type="radio" name="<%=Constants.SECTION7_BODY_WORKS%>" id="<%=Constants.SECTION7_BODY_WORKS%>" <%=(educationLevel.getBody_works().equals("Público")) ? "checked": ""%> value="Público">Público</label>
							</div>
						</div>
						<div class="form-group">
							<label for="cual_ESIM">¿Cuál es su ingreso mensual?</label> 
							<select class="form-control" name="<%=Constants.SECTION7_MONTHLY_INCOME%>" id="<%=Constants.SECTION7_MONTHLY_INCOME%>">
								<option value="Menor o igual a 1 salario" <%=educationLevel.getMonthly_income().equals("Menor o igual a 1 salario") ? "selected": ""%>>Menor o igual a 1 salario</option>
								<option value="Menor o igual a 2 salarios" <%=educationLevel.getMonthly_income().equals("Menor o igual a 2 salarios") ? "selected": ""%>>Menor o igual a 2 salarios</option>
								<option value="Menor o igual a 3 salarios" <%=educationLevel.getMonthly_income().equals("Menor o igual a 3 salarios") ? "selected": ""%>>Menor o igual a 3 salarios</option>
								<option value="Mayor a 3 salarios" <%=educationLevel.getMonthly_income().equals("Mayor a 3 salarios") ? "selected": ""%>>Mayor a 3 salarios</option>
							</select>
						</div>
						<div class="form-group">
							<label for="ultimo_2AHRAC">En los últimos 2 años, ha recibido algún crédito</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION7_RECEIVED_CREDIT%>" id="<%=Constants.SECTION7_RECEIVED_CREDIT%>_si"  <%=(educationLevel.getReceived_credit().equals("Sí ¿Cuál instituto lo otorgo?")) ? "checked": ""%> value="Sí ¿Cuál instituto lo otorgo?">Sí ¿Cuál instituto lo otorgo?</label>
								<label><input type="radio" name="<%=Constants.SECTION7_RECEIVED_CREDIT%>" id="<%=Constants.SECTION7_RECEIVED_CREDIT%>_no"  <%=(educationLevel.getReceived_credit().equals("No")||educationLevel.getReceived_credit().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
							<select class="form-control" name="<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE%>" id="<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE%>" <%= (educationLevel.getReceived_credit().equals("Sí ¿Cuál instituto lo otorgo?")) ? "": "style='display: none'"%>>
								<option value="Alcaldía" <%=educationLevel.getReceived_credit_value().equals("Alcaldía") ? "selected": ""%>>Alcaldía</option>
								<option value="Banco de la mujer" <%=educationLevel.getReceived_credit_value().equals("Banco de la mujer") ? "selected": ""%>>Banco de la mujer</option>
								<option value="Banco del pueblo" <%=educationLevel.getReceived_credit_value().equals("Banco del pueblo") ? "selected": ""%>>Banco del pueblo</option>
								<option value="Banco industrial de Venezuela" <%=educationLevel.getReceived_credit_value().equals("Banco industrial de Venezuela") ? "selected": ""%>>Banco industrial de Venezuela</option>
								<option value="Bancas universales y comerciales" <%=educationLevel.getReceived_credit_value().equals("Bancas universales y comerciales") ? "selected": ""%>>Bancas universales y comerciales</option>
								<option value="BANDES" <%=educationLevel.getReceived_credit_value().equals("BANDES") ? "selected": ""%>>BANDES</option>
								<option value="FONDAFA" <%=educationLevel.getReceived_credit_value().equals("FONDAFA") ? "selected": ""%>>FONDAFA</option>
								<option value="FONDEMI" <%=educationLevel.getReceived_credit_value().equals("FONDEMI") ? "selected": ""%>>FONDEMI</option>
								<option value="FOMDES" <%=educationLevel.getReceived_credit_value().equals("FOMDES") ? "selected": ""%>>FOMDES</option>
								<option value="Otra ¿Cuál?" <%=educationLevel.getReceived_credit_value().equals("Otra ¿Cuál?") ? "selected": ""%>>Otra ¿Cuál?</option>
							</select>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER%>" name="<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER%>" placeholder="¿Cuál?" <%= (educationLevel.getReceived_credit_value().equals("Otra ¿Cuál?")) ? "value='"+educationLevel.getReceived_credit_value_other()+"'": "style='display: none'"%>>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit" class="btn btn-primary hidden" id="submitBtn<%=Parameters.getPageNumber()%>">
	</form>
	<%@include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
		$('#<%=Constants.SECTION7_DEGREE_APPROVED_TEXT%>').change(function() {
			 if($(this).val()!='Ninguno'){
				 $('#<%=Constants.SECTION7_DEGREE_APPROVED_LEVEL%>').removeAttr('disabled');
			 }else{
				 $('#<%=Constants.SECTION7_DEGREE_APPROVED_LEVEL%>').attr('disabled','disabled');
			 }
			});
		
		$('#<%=Constants.SECTION7_OCCUPATION%>_empleado').change(function() {
			$('#<%=Constants.SECTION7_OCCUPATION_VALUE%>_empleado').show();
			$('#<%=Constants.SECTION7_OCCUPATION_VALUE%>_otro').hide();
		});
		$('#<%=Constants.SECTION7_OCCUPATION%>_otro').change(function() {
			$('#<%=Constants.SECTION7_OCCUPATION_VALUE%>_otro').show();
			$('#<%=Constants.SECTION7_OCCUPATION_VALUE%>_empleado').hide();
		});
		
		$('#<%=Constants.SECTION7_SKILLS_ACTIVITY%>_si').change(function() {
			$('#<%=Constants.SECTION7_SKILLS_ACTIVITY_OPTION%>').show();
		});
		$('#<%=Constants.SECTION7_SKILLS_ACTIVITY%>_no').change(function() {
			$('#<%=Constants.SECTION7_SKILLS_ACTIVITY_OPTION%>').hide();
		});
		
		$('#<%=Constants.SECTION7_RECEIVED_CREDIT%>_si').change(function() {
			$('#<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE%>').show();
		});
		$('#<%=Constants.SECTION7_RECEIVED_CREDIT%>_no').change(function() {
			$('#<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE%>').hide();
		});
		
		$('#<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE%>').change(function() {
			
			if($(this).val()=='Otra ¿Cuál?'){
		    	$('#<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER%>').show();	
		    }else{
		    	$('#<%=Constants.SECTION7_RECEIVED_CREDIT_VALUE_OTHER%>').hide();
		    }
		});
		
	});
</script>

<%@include file="footer.jsp"%>
