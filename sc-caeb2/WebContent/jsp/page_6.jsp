<%@ include file="header.jsp"%>

<%
	Parameters.setPageNumber(6);
	Parameters.setTitle("Secci�n 5: Caracter�sticas individuales - Educaci�n");
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="<%=Constants.SECTION6_ILLITERATE%>">�Sabe leer y escribir?</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ILLITERATE%>"
										id="<%=Constants.SECTION6_ILLITERATE%>_si" value="S�">
								S�
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ILLITERATE%>"
										id="<%=Constants.SECTION6_ILLITERATE%>_no" value="No" checked>
								No
							</label>
						</div>
					</div>
				</td>
				<td width="50%">
					<div class="form-group">
						<label for="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>">
							�Asiste actualmente en calidad de estudiante a alg�n establecimiento de educaci�n?
						</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>"
										id="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_si" value="S�">
								S�
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>"
										id="<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_no" value="No">
								No
							</label>
						</div>
						<div class="form-group hidden" id="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>_div">
							<label for="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>">�Cu�l?</label>
							<div class="radio">
								<label>
									<input type="radio" name="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>"
											id="oficial" value="Oficial">
									Oficial
								</label>
								<label>
									<input type="radio" name="<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>"
											id="privado" value="Privado">
									Privado
								</label>
							</div>
						</div>
						<div class="form-group hidden" id="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>_div">
							<label for="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>">
								�Por qu� raz�n no asiste a un establecimiento de educaci�n?
							</label>
							<input type="text" class="form-control" placeholder="Ej. Falta de recursos econ�micos"
									id="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>"
									name="<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="<%=Constants.SECTION6_TRAINING_COURSE%>">
							�Est� realizando alg�n curso de capacitaci�n?
						</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_TRAINING_COURSE%>"
										id="<%=Constants.SECTION6_TRAINING_COURSE%>_si" value="S�">
								S�
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_TRAINING_COURSE%>"
										id="<%=Constants.SECTION6_TRAINING_COURSE%>_no" value="No">
								No
							</label>
						</div>
						<div class="form-group hidden" id="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>_div">
							<label for="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>">�Cu�l?</label>
							<input type="text" class="form-control" placeholder="Ej. Reparaci�n de computadoras"
									name="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>"
									id="<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>">
						</div>
					</div>
				</td>
				<td>
					<div class="form-group">
						<label for="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>">�Recibe alguna beca o ayuda econ�mica?</label>
						<div class="radio">
							<label>
								<input type="radio" name="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>"
										id="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_si" value="S�">
								S�
							</label>
							<label>
								<input type="radio" name="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>"
										id="<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_no" value="No">
								No
							</label>
						</div>
						<div class="form-group hidden" id="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>_div">
							<label for="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>">Especifique:</label>
							<input type="text" class="form-control" placeholder="Ej. Fundayacucho"
									name="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>"
									id="<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>">
							�Ha asistido a alguna de las misiones educativas?
						</label>
						<div class="checkbox" id="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>_div">
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_NONE_MISION%>"
										id="<%=Constants.SECTION6_NONE_MISION%>" value="No">
								No
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionRobinsonI" value="Misi�n Robinson I">
								Misi�n Robinson I
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionRobinsonII" value="Misi�n Robinson II">
								Misi�n Robinson II
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionRibas" value="Misi�n Ribas">
								Misi�n Ribas
							</label><br>
							<label>
								<input type="checkbox" name="<%=Constants.SECTION6_EDUCATIONAL_MISIONS%>"
										id="misionSucre" value="Misi�n Sucre">
								Misi�n Sucre
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
	<%@ include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$('#<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_si').on('click', function() {
			$('#<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>_div').removeClass('show').addClass('hidden');
			$('#<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>_div').removeClass('hidden').addClass('show');
		});

		$('#<%=Constants.SECTION6_ATTEND_EDUC_ESTABLISHMENT%>_no').on('click', function() {
			$('#<%=Constants.SECTION6_WHICH_EDUC_ESTABLISHMENT%>_div').removeClass('show').addClass('hidden');
			$('#<%=Constants.SECTION6_WHYNOT_EDUC_ESTABLISHMENT%>_div').removeClass('hidden').addClass('show');
		});

		$('#<%=Constants.SECTION6_TRAINING_COURSE%>_si').on('click', function() {
			$('#<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>').removeClass('hidden').addClass('show');
		});

		$('#<%=Constants.SECTION6_TRAINING_COURSE%>_no').on('click', function() {
			$('#<%=Constants.SECTION6_WHICH_TRAINING_COURSE%>').removeClass('show').addClass('hidden');
		});

		$('#<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_si').on('click', function() {
			$('#<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>_div').removeClass('hidden').addClass('show');
		});

		$('#<%=Constants.SECTION6_RECEIVES_SCHOLARSHIP%>_no').on('click', function() {
			$('#<%=Constants.SECTION6_SCHOLARSHIP_DESCRIPTION%>_div').removeClass('show').addClass('hidden');
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

<%@ include file="footer.jsp"%>
