<%@page import="com.caeb2.actions.IndividualCharacteristics"%>
<%@page import="com.caeb2.actions.bean.PersonEducationData"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(6);
	Parameters.setTitle("Sección 5: Características individuales - Educación");

	PersonEducationData personEducationData = IndividualCharacteristics.loadPersonEducationData(request.getRequestedSessionId());
%>

<%@include file="validateCurrentPage.jsp"%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=savePersonEducationData" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="<%=Constants.SECTION6_ILLITERATE%>">¿Sabe leer y escribir?</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ILLITERATE%>"
										id="<%=Constants.SECTION6_ILLITERATE%>_si" value="Sí"
										<%if (personEducationData.isIlliterate()) {%> checked <%}%>>
								Sí
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ILLITERATE%>"
										id="<%=Constants.SECTION6_ILLITERATE%>_no" value="No"
										<%if (!personEducationData.isIlliterate()) {%> checked <%}%>>
								No
							</label>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="<%=Constants.SECTION6_TRAINING_COURSE%>">
							¿Está realizando algún curso de capacitación?
						</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_TRAINING_COURSE%>"
										id="<%=Constants.SECTION6_TRAINING_COURSE%>_si" value="Sí"
										<%if (!personEducationData.getTrainingCourse().equalsIgnoreCase("No")) {%> checked <%}%>>
								Sí
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_TRAINING_COURSE%>"
										id="<%=Constants.SECTION6_TRAINING_COURSE%>_no" value="No"
										<%if (personEducationData.getTrainingCourse().equalsIgnoreCase("No")) {%> checked <%}%>>
								No
							</label>
						</div>
						<div class="form-group <%if (personEducationData.getTrainingCourse().equalsIgnoreCase("No")) {%> hidden <%}%>"
								id="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>_div">
							<label for="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>">¿Cuál?</label>
							<input type="text" class="form-control" placeholder="Ej. Reparación de computadoras"
									name="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>"
									id="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>"
									<%if (!personEducationData.getTrainingCourse().equalsIgnoreCase("No")) {%>
										required value="<%=personEducationData.getTrainingCourse()%>" <%}%>>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>">
							¿Asiste actualmente en calidad de estudiante a algún establecimiento de educación?
						</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>"
										id="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_si" value="Sí"
										<%if (personEducationData.hasAttendEducEstablishment()) {%> checked <%}%>>
								Sí
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>"
										id="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_no" value="No"
										<%if (!personEducationData.hasAttendEducEstablishment()) {%> checked <%}%>>
								No
							</label>
						</div>
						<div class="form-group <%if (!personEducationData.hasAttendEducEstablishment()) {%> hidden <%}%>"
								id="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>_div">
							<label for="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>">¿Cuál?</label>
							<div class="radio">
								<label>
									<input type="radio" name="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>"
											id="oficial" value="Oficial"
											<%if (personEducationData.getAnswerEducEstablishment().equalsIgnoreCase("Oficial")||personEducationData.getAnswerEducEstablishment().equalsIgnoreCase("")) {%>
												checked <%}%>>
									Oficial
								</label>
								<label>
									<input type="radio" name="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>"
											id="privado" value="Privado"
											<%if (personEducationData.getAnswerEducEstablishment().equalsIgnoreCase("Privado")) {%>
												checked <%}%>>
									Privado
								</label>
							</div>
						</div>
						<div class="form-group <%if (personEducationData.hasAttendEducEstablishment()) {%> hidden <%}%>"
								id="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>_div">
							<label for="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>">
								¿Por qué razón no asiste a un establecimiento de educación?
							</label>
							<input type="text" class="form-control" placeholder="Ej. Falta de recursos económicos"
									id="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>"
									name="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>"
									<%if (!personEducationData.hasAttendEducEstablishment()) {%> 
										required value="<%=personEducationData.getAnswerEducEstablishment()%>" <%}%>>
						</div>
					</div>
				</td>
				<td>
					<div class="form-group">
						<label for="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>">¿Recibe alguna beca o ayuda económica?</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>"
										id="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_si" value="Sí"
										<%if (!personEducationData.getScholarshipDescription().equalsIgnoreCase("No")) {%> checked <%}%>>
								Sí
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>"
										id="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_no" value="No"
										<%if (personEducationData.getScholarshipDescription().equalsIgnoreCase("No")) {%> checked <%}%>>
								No
							</label>
						</div>
						<div class="form-group <%if (personEducationData.getScholarshipDescription().equalsIgnoreCase("No")) {%> hidden <%}%>"
								id="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>_div">
							<label for="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>">Especifique:</label>
							<input type="text" class="form-control" placeholder="Ej. Fundayacucho"
									name="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>"
									id="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>"
									<%if (!personEducationData.getScholarshipDescription().equalsIgnoreCase("No")) {%>
										required value="<%=personEducationData.getScholarshipDescription()%>" <%}%>>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>">
							¿Ha asistido o asiste a alguna de las misiones educativas?
						</label>
						<div class="checkbox" id="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>_div">
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_NONE_MISION%>"
										id="<%=Constants.SECTION6_NONE_MISION%>" value="No"
										<%if (personEducationData.getEducationalMisions().containsKey("No")) {%> checked <%}%>>
								No
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionRobinsonI" value="Misión Robinson I"
										<%if (personEducationData.getEducationalMisions().containsKey("Misión Robinson I")) {%> checked <%}%>>
								Misión Robinson I
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionRobinsonII" value="Misión Robinson II"
										<%if (personEducationData.getEducationalMisions().containsKey("Misión Robinson II")) {%> checked <%}%>>
								Misión Robinson II
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionRibas" value="Misión Ribas"
										<%if (personEducationData.getEducationalMisions().containsKey("Misión Ribas")) {%> checked <%}%>>
								Misión Ribas
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionSucre" value="Misión Sucre"
										<%if (personEducationData.getEducationalMisions().containsKey("Misión Sucre")) {%> checked <%}%>>
								Misión Sucre
							</label><br>
						</div>
					</div>
				</td>
				<td>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit" class="btn btn-primary hidden"
				id="submitBtn<%=Parameters.getPageNumber()%>">
	</form>
	<%@include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$('#<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_si').on('click', function() {
			$('#<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>_div').removeClass('show').addClass('hidden');
			$('#<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>_div').removeClass('hidden').addClass('show');
			$('#<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>').prop('required',false);

		});

		$('#<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_no').on('click', function() {
			$('#<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>_div').removeClass('show').addClass('hidden');
			$('#<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>_div').removeClass('hidden').addClass('show');
			$('#<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>').prop('required',true);
		});

		$('#<%=Constants.SECTION6_TRAINING_COURSE%>_si').on('click', function() {
			$('#<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>_div').removeClass('hidden').addClass('show');
			$('#<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>').prop('required',true);
		});

		$('#<%=Constants.SECTION6_TRAINING_COURSE%>_no').on('click', function() {
			$('#<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>_div').removeClass('show').addClass('hidden');
			$('#<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>').prop('required',false);
		});

		$('#<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_si').on('click', function() {
			$('#<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>_div').removeClass('hidden').addClass('show');
			$('#<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>').prop('required',true);
		});

		$('#<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_no').on('click', function() {
			$('#<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>_div').removeClass('show').addClass('hidden');
			$('#<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>').prop('required',false);
		});

		$('label #<%=Constants.SECTION6_NONE_MISION%>, #<%=Constants.SECTION6_NONE_MISION%>').on('click', function() {

			if (!$("#<%=Constants.SECTION6_NONE_MISION%>").is(':checked')) {

				$('input[name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"]').each(function(index) {
 					$(this).removeAttr('disabled');
 				});

			} else {

				$('input[name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"]').each(function(index) {
 					$(this).removeAttr('checked').attr('disabled', 'disabled');
 				});

			}

		});

	});
</script>

<%@include file="footer.jsp"%>
