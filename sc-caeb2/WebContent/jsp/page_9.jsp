<%@page import="com.caeb2.actions.IndividualCharacteristics"%>
<%@page import="com.caeb2.util.TextUtils"%>
<%@page import="com.caeb2.actions.bean.Ability"%>

<%@include file="header.jsp"%>

<%
	Parameters.setPageNumber(9);
	Parameters.setTitle("Sección 5: Características individuales - Habilidades");

	Ability ability = IndividualCharacteristics.loadAbilitiesData();
%>

<%@include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>"
			action="<%=Constants.EXECUTE%>?<%=Constants.ACTION%>=saveAbilitiesData" method="POST">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<table class="table table-control">
							<tr>
								<td class="td-left-control" width="35%">
									<label>¿Qué habilidad artística o manual domina?</label>
								</td>
								<td class="td-right-control hidden" width="65%" id="artisticInstructorQuestion">
									<label>¿Le gustaría participar como instructor o facilitador en cursos de capacitación?</label>
								</td>
							</tr>
							<tr>
								<td class="td-left-control withoutMargin">
									<div class="form-group">
										<div class="checkbox">
											<label>
												<input type="checkbox" value="<%=Constants.NONE%>"
														name="<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_NONE%>"
														id="<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_NONE%>">
												<%=Constants.NONE%>
											</label>
										</div>
									</div>
								</td>
								<td class="td-right-control withoutMargin">
								</td>
							</tr>

							<%for (int i = 0; i < Ability.ARTISTIC_ABILITIES_OPTIONS.size(); i++) {

								String artisticAbility = Ability.ARTISTIC_ABILITIES_OPTIONS.get(i);%>

								<tr>
									<td class="td-left-control withoutMargin">
										<div class="form-group">
											<div class="checkbox">
												<label>
													<input type="checkbox" value="<%=artisticAbility%>"
															name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>"
															id="<%=Constants.SECTION9_ARTISTIC_ABILITY + "_"
																+ TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbility)%>"
															<%=(ability.getArtisticAbilities().containsKey(artisticAbility)) ? "checked": ""%>>
													<%=artisticAbility%>
												</label>
												<%if (artisticAbility.equals(Constants.OTHER)) {%>
													<input type="text" class="form-control <%=ability.getArtisticAbilitiesInstructorOther().isEmpty() ? "hidden": ""%>"
															name="<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER%>"
															id="<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER%>"
															placeholder="¿Cuál?" value="<%=ability.getArtisticAbilitiesInstructorOther()%>">
												<%}%>
											</div>
										</div>
									</td>
									<td class="td-right-control withoutMargin">
										<div class="radio hidden" id="<%=Constants.SECTION9_ARTISTIC_ABILITY + "_"
																		+ TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbility)%>_opt">
											<label>
												<input type="radio" name="<%=TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbility)%>"
														id="<%=Constants.SECTION9_ARTISTIC_ABILITY + "_"
															+ TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbility)%>_si" value="Si"
														<%=(ability.getAbility(ability.getArtisticAbilitiesInstructor(), artisticAbility)) ? "checked": ""%>>
												Sí
											</label>
											<label>
												<input type="radio" name="<%=TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbility)%>"
														id="<%=Constants.SECTION9_ARTISTIC_ABILITY + "_"
															+ TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbility)%>_no" value="No"
														<%=(!ability.getAbility(ability.getArtisticAbilitiesInstructor(), artisticAbility)) ? "checked": ""%>>
												No
											</label>
										</div>
									</td>
								</tr>

							<%}%>
						</table>
					</div>
					
					<div class="form-group">
						<label for="estaria_DAPECDF">¿Estaría dispuesto a participar como estudiante en alguno de los siguientes cursos de formación?</label>
						<table class="table table-control">
							<tr>
								<td class="td-left-control" width="33%">
									<div class="form-group">
										<div class="checkbox">

											<label>
												<input type="checkbox" value="<%=Constants.NONE%>"
														name="<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_NONE%>"
														id="<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_NONE%>">
												<%=Constants.NONE%>
											</label><br>

											<%for (int i = 0; i < Ability.ARTISTIC_ABILITIES_OPTIONS.size(); i++) {
			
												String artisticAbilityStudent = Ability.ARTISTIC_ABILITIES_OPTIONS.get(i);

												if ((i + 1) % ((Ability.ARTISTIC_ABILITIES_OPTIONS.size() + 1) / 3) == 0) {%>
															</div>
														</div>
													</td>
													<td class="td-left-control" width="33%">
														<div class="form-group">
															<div class="checkbox">
												<%}%>

												<label>
													<input type="checkbox" value="<%=artisticAbilityStudent%>"
															name="<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT%>"
															id="<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT + "_"
																+ TextUtils.replaceRareSymbolsAndBlankSpaces(artisticAbilityStudent)%>"
															<%=(ability.getArtisticAbilitiesStudent().containsKey(artisticAbilityStudent)) ? "checked": ""%>>
													<%=artisticAbilityStudent%>
												</label>

												<%if (i < Ability.ARTISTIC_ABILITIES_OPTIONS.size()) {%>
													<br>
												<%}
											}%>
			
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" class="form-control <%=ability.getArtisticAbilitiesStudentOther().isEmpty() ? "hidden": ""%>"
								name="<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER%>"
								id="<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER%>"
								placeholder="¿Cuál?" value="<%=ability.getArtisticAbilitiesStudentOther()%>">
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<table class="table table-control">
							<tr>
								<td class="td-left-control" width="35%">
									<label>¿Cuál de los siguientes deportes practica?</label>
								</td>
								<td class="td-right-control hidden" width="65%" id="athleticInstructorQuestion">
									<label>¿Le gustaría participar como instructor o facilitador en cursos de capacitación?</label>
								</td>
							</tr>
							<tr>
								<td class="td-left-control withoutMargin">
									<div class="form-group">
										<div class="checkbox">
											<label>
												<input type="checkbox" value="<%=Constants.NONE%>"
														name="<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_NONE%>"
														id="<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_NONE%>">
												<%=Constants.NONE%>
											</label>
										</div>
									</div>
								</td>
								<td class="td-right-control withoutMargin">
								</td>
							</tr>

							<%for (int i = 0; i < Ability.ATHLETIC_ABILITIES_OPTIONS.size(); i++) {

								String athleticAbility = Ability.ATHLETIC_ABILITIES_OPTIONS.get(i);%>

								<tr>
									<td class="td-left-control withoutMargin">
										<div class="form-group">
											<div class="checkbox">
												<label>
													<input type="checkbox" value="<%=athleticAbility%>"
															name="<%=Constants.SECTION9_ATHLETIC_ABILITY%>"
															id="<%=Constants.SECTION9_ATHLETIC_ABILITY + "_"
																+ TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbility)%>"
															<%=(ability.getAthleticAbilities().containsKey(athleticAbility)) ? "checked": ""%>>
													<%=athleticAbility%>
												</label>
												<%if (athleticAbility.equals(Constants.OTHER)) {%>
													<input type="text" class="form-control <%=ability.getAthleticAbilitiesInstructorOther().isEmpty() ? "hidden": ""%>"
															name="<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER%>"
															id="<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER%>"
															placeholder="¿Cuál?" value="<%=ability.getAthleticAbilitiesInstructorOther()%>">
												<%}%>
											</div>
										</div>
									</td>
									<td class="td-right-control withoutMargin">
										<div class="radio hidden" id="<%=Constants.SECTION9_ATHLETIC_ABILITY + "_"
																		+ TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbility)%>_opt">
											<label>
												<input type="radio" name="<%=TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbility)%>"
														id="<%=Constants.SECTION9_ATHLETIC_ABILITY + "_"
															+ TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbility)%>_si" value="Si"
														<%=(ability.getAbility(ability.getAthleticAbilitiesInstructor(), athleticAbility)) ? "checked": ""%>>
												Sí
											</label>
											<label>
												<input type="radio" name="<%=TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbility)%>"
														id="<%=Constants.SECTION9_ATHLETIC_ABILITY + "_"
															+ TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbility)%>_no" value="No"
														<%=(!ability.getAbility(ability.getAthleticAbilitiesInstructor(), athleticAbility)) ? "checked": ""%>>
												No
											</label>
										</div>
									</td>
								</tr>

							<%}%>
						</table>
					</div>
					
					<div class="form-group">
						<label for="bajo_QCLGPDELC">¿En cuál de los siguientes deportes le gustaría participar en la comunidad?</label>
						<table class="table table-control">
							<tr>
								<td class="td-left-control" width="33%">
									<div class="form-group">
										<div class="checkbox">

											<label>
												<input type="checkbox" value="<%=Constants.NONE%>"
														name="<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_NONE%>"
														id="<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_NONE%>">
												<%=Constants.NONE%>
											</label><br>

											<%for (int i = 0; i < Ability.ATHLETIC_ABILITIES_OPTIONS.size(); i++) {
			
												String athleticAbilityStudent = Ability.ATHLETIC_ABILITIES_OPTIONS.get(i);

												if ((i + 1) % ((Ability.ATHLETIC_ABILITIES_OPTIONS.size() + 1) / 3) == 0) {%>
															</div>
														</div>
													</td>
													<td class="td-left-control" width="33%">
														<div class="form-group">
															<div class="checkbox">
												<%}%>

												<label>
													<input type="checkbox" value="<%=athleticAbilityStudent%>"
															name="<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT%>"
															id="<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT + "_"
																+ TextUtils.replaceRareSymbolsAndBlankSpaces(athleticAbilityStudent)%>"
															<%=(ability.getAthleticAbilitiesStudent().containsKey(athleticAbilityStudent)) ? "checked": ""%>>
													<%=athleticAbilityStudent%>
												</label>

												<%if (i < Ability.ATHLETIC_ABILITIES_OPTIONS.size()) {%>
													<br>
												<%}
											}%>
			
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" class="form-control <%=ability.getAthleticAbilitiesStudentOther().isEmpty() ? "hidden": ""%>"
								name="<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER%>"
								id="<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER%>"
								placeholder="¿Cuál?" value="<%=ability.getAthleticAbilitiesStudentOther()%>">
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

		$('label #<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_NONE%>, #<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_NONE%>').on(
				'change', function() {

			$('input[name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>"]').each(function(index) {
				if (!$("#<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_NONE%>").is(':checked')) {
					$(this).removeAttr('disabled');
				} else {
					$(this).removeAttr('checked').attr('disabled', 'disabled');
 					$('#' + $(this).attr('id') + '_opt').addClass('hidden');
 					$('#artisticInstructorQuestion').addClass('hidden');
 					$('#<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER%>').addClass('hidden');
				}
			});

		});

		$('label #<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_NONE%>, #<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_NONE%>').on(
				'change', function() {

			$('input[name="<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT%>"]').each(function(index) {
				if (!$("#<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_NONE%>").is(':checked')) {
					$(this).removeAttr('disabled');
				} else {
					$(this).removeAttr('checked').attr('disabled', 'disabled');
 					$('#' + $(this).attr('id') + '_opt').addClass('hidden');
 					$('#<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER%>').addClass('hidden');
				}
			});

		});

		$('label #<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_NONE%>, #<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_NONE%>').on(
				'change', function() {

			$('input[name="<%=Constants.SECTION9_ATHLETIC_ABILITY%>"]').each(function(index) {
				if (!$("#<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_NONE%>").is(':checked')) {
					$(this).removeAttr('disabled');
				} else {
					$(this).removeAttr('checked').attr('disabled', 'disabled');
 					$('#' + $(this).attr('id') + '_opt').addClass('hidden');
 					$('#<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER%>').addClass('hidden');
 					$('#athleticInstructorQuestion').addClass('hidden');
				}
			});

		});

		$('label #<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_NONE%>, #<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_NONE%>').on(
				'change', function() {

			$('input[name="<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT%>"]').each(function(index) {
				if (!$("#<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_NONE%>").is(':checked')) {
					$(this).removeAttr('disabled');
				} else {
					$(this).removeAttr('checked').attr('disabled', 'disabled');
 					$('#' + $(this).attr('id') + '_opt').addClass('hidden');
 					$('#<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER%>').addClass('hidden');
				}
			});

		});

		$('input[name="<%=Constants.SECTION9_ARTISTIC_ABILITY%>"]').on('change', function (e) {
			if ($(this).is(':checked')) {
 		    	$('#' + $(this).attr('id') + '_opt').removeClass('hidden');
 		    	$('#artisticInstructorQuestion').removeClass('hidden');
 		    } else {
 		    	$('#' + $(this).attr('id') + '_opt').addClass('hidden');
 		    }
		});

		$('input[name="<%=Constants.SECTION9_ATHLETIC_ABILITY%>"]').on('change', function (e) {
			if ($(this).is(':checked')) {
 		    	$('#' + $(this).attr('id') + '_opt').removeClass('hidden');
 		    	$('#athleticInstructorQuestion').removeClass('hidden');
 		    } else {
 		    	$('#' + $(this).attr('id') + '_opt').addClass('hidden');
 		    }
		});

		$('#<%=Constants.SECTION9_ARTISTIC_ABILITY + "_"
			+ TextUtils.replaceRareSymbolsAndBlankSpaces(Constants.OTHER)%>').on('change', function (e) {

			if ($(this).is(':checked')) {
		    	$('#<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER%>').removeClass('hidden');
		    } else {
		    	$('#<%=Constants.SECTION9_ARTISTIC_ABILITY_INSTRUCTOR_OTHER%>').addClass('hidden');
		    }

		});

		$('#<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT + "_"
			+ TextUtils.replaceRareSymbolsAndBlankSpaces(Constants.OTHER)%>').on('change', function (e) {

			if ($(this).is(':checked')) {
		    	$('#<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER%>').removeClass('hidden');
		    } else {
		    	$('#<%=Constants.SECTION9_ARTISTIC_ABILITY_STUDENT_OTHER%>').addClass('hidden');
		    }

		});

		$('#<%=Constants.SECTION9_ATHLETIC_ABILITY + "_"
			+ TextUtils.replaceRareSymbolsAndBlankSpaces(Constants.OTHER)%>').on('change', function (e) {

			if ($(this).is(':checked')) {
		    	$('#<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER%>').removeClass('hidden');
		    } else {
		    	$('#<%=Constants.SECTION9_ATHLETIC_ABILITY_INSTRUCTOR_OTHER%>').addClass('hidden');
		    }

		});

		$('#<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT + "_"
			+ TextUtils.replaceRareSymbolsAndBlankSpaces(Constants.OTHER)%>').on('change', function (e) {

		    if ($(this).is(':checked')) {
		    	$('#<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER%>').removeClass('hidden');
		    } else {
		    	$('#<%=Constants.SECTION9_ATHLETIC_ABILITY_STUDENT_OTHER%>').addClass('hidden');
		    }

		});

	});
</script>

<%@ include file="footer.jsp"%>
