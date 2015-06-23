<%@page import="com.caeb2.sections.HomeData"%>
<%@ include file="header.jsp"%>

<%
	Parameters.setPageNumber(4);
	Parameters.setTitle("Sección 4: Datos del hogar");
	HomeData homeData=new HomeData();
%>

<%@ include file="navbar.jsp"%>

<div class="container-fluid">
	<form class="form-group" id="form_<%=Parameters.getPageNumber()%>" name="form_<%=Parameters.getPageNumber()%>">
		<table class="table">
			<tr>
				<td width="50%">
					<div class="form-group">
						<label for="hogares_EEV">Hogares en esta vivienda</label> 
						<div class="form-inline">
							<div class="radio">
								<label>Hogar: <input type="text" class="form-control" id="<%=Constants.SECTION4_HOME%>" name="<%=Constants.SECTION4_HOME%>" value="<%= !homeData.getHome().equals("") ? homeData.getHome(): ""%>"></label>
								<label>De: <input type="text" class="form-control" id="<%=Constants.SECTION4_TO%>" name="<%=Constants.SECTION4_TO%>" value="<%= !homeData.getTo().equals("") ? homeData.getTo(): ""%>" ></label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="numero_DCPD">Número de cuartos para dormir</label> 
						<input type="number" class="form-control" id="<%=Constants.SECTION4_ROOMS%>" name="<%=Constants.SECTION4_ROOMS%>" min="0" value="<%= !homeData.getRooms().equals("") ? homeData.getRooms(): ""%>">
					</div>
					<div class="form-group">
						<label for="jefe_OJDEHTP">¿El jefe o jefa de este hogar tiene pareja?</label> 
						<div class="radio">
							<label><input type="radio" name="<%=Constants.SECTION4_CHIEF_COUPLE%>" <%=(homeData.getChief_couple().equals("Sí")||homeData.getChief_couple().equals("")) ? "checked": ""%> value="Sí">Sí</label>
							<label><input type="radio" name="<%=Constants.SECTION4_CHIEF_COUPLE%>" <%=(homeData.getChief_couple().equals("No")) ? "checked": ""%> value="No">No</label>
						</div>
					</div>
					<div class="form-group">
						<label for="hogar_UM">¿Este hogar utiliza MERCAL?</label> 
						<div class="radio">
							<label><input type="radio" name="<%=Constants.SECTION4_USED_MERCAL%>" id="hogar_UM_si" <%=(homeData.getUsed_mercal().equals("Sí")) ? "checked": ""%> value="Sí">Sí</label>
							<label><input type="radio" name="<%=Constants.SECTION4_USED_MERCAL%>" id="hogar_UM_no" <%=(homeData.getUsed_mercal().equals("No")||homeData.getUsed_mercal().equals("")) ? "checked": ""%> value="No">No</label>
						</div>
						<select class="form-control" name="<%=Constants.SECTION4_USED_MERCAL_SELECTED%>" id="<%=Constants.SECTION4_USED_MERCAL_SELECTED%>" <%=homeData.getUsed_mercal_selected().equals("") ? "style=\"display: none\"": ""%>>
							<option value="Diariamente" <%= homeData.getUsed_mercal().equals("Diariamente") ? "selected": ""%>>Diariamente</option>
							<option value="Semanalmente" <%= homeData.getUsed_mercal().equals("Semanalmente") ? "selected": ""%>>Semanalmente</option>
							<option value="Quincenalmente" <%= homeData.getUsed_mercal().equals("Quincenalmente") ? "selected": ""%>>Quincenalmente</option>
							<option value="Mensualmente" <%= homeData.getUsed_mercal().equals("Mensualmente") ? "selected": ""%>>Mensualmente</option>
							<option value="Esporádicamente" <%= homeData.getUsed_mercal().equals("Esporádicamente") ? "selected": ""%>>Esporádicamente</option>
						</select>
					</div>
					<div class="form-group">
						<label for="hogar_HSBCMDA">¿Este hogar ha sido beneficiado con mercados de alimentación?</label> 
						<div class="radio">
							<label><input type="radio" name="<%=Constants.SECTION4_FOOD_MARKETS%>" id="hogar_HSBCMDA_si" <%=(homeData.getFood_markets().equals("Sí")) ? "checked": ""%> value="Sí">Sí ¿Cuál?</label>
							<label><input type="radio" name="<%=Constants.SECTION4_FOOD_MARKETS%>" id="hogar_HSBCMDA_no" <%=(homeData.getFood_markets().equals("No")||homeData.getFood_markets().equals("")) ? "checked": ""%> value="No">No</label>
						</div> 
						<div class="radio" id="hogar_HSBCMDA_grupo" <%=homeData.getFood_markets_response().equals("") ? "style=\"display: none\"": ""%>>
							<label><input type="radio" name="<%=Constants.SECTION4_FOOD_MARKETS_RESPONSE%>" <%=(homeData.getFood_markets_response().equals("Mercado completo")) ? "checked": ""%> value="Mercado completo">Mercado completo</label>
							<label><input type="radio" name="<%=Constants.SECTION4_FOOD_MARKETS_RESPONSE%>" <%=(homeData.getFood_markets_response().equals("Mercado 50%")||homeData.getFood_markets_response().equals("")) ? "checked": ""%> value="Mercado 50%">Mercado 50%</label>
						</div>
					</div>
					<div class="form-group">
						<label for="cuales_SLPPDLC">¿Cuáles son los principales problemas de la comunidad?</label>
						<table class="table table-control">
							<tr>
								<td class="td-left-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Vivienda")) ? "checked": ""%> value="Vivienda">Vivienda</label><br>
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Empleo")) ? "checked": ""%> value="Empleo">Empleo</label><br>
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Inseguridad")) ? "checked": ""%> value="Inseguridad">Inseguridad</label>
										</div>
									</div>
								</td>
								<td class="td-center-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Servicio de Agua")) ? "checked": ""%> value="Servicio de Agua">Servicio de Agua</label><br>
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Servicio de luz eléctrica")) ? "checked": ""%> value="Servicio de luz eléctrica">Servicio de luz eléctrica</label><br>
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Servicio telefónico")) ? "checked": ""%> value="Servicio telefónico">Servicio telefónico</label>
										</div>
									</div>
								</td>
								<td class="td-right-control">
									<div class="form-group">
										<div class="checkbox">
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Vialidad")) ? "checked": ""%> value="Vialidad">Vialidad</label><br>
											<label><input type="checkbox" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Red de cloacas")) ? "checked": ""%> value="Red de cloacas">Red de cloacas</label><br>
											<label><input type="checkbox" id="cuales_SLPPDLC_checkbox_otro" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS%>" <%= (homeData.getCommunity_problems().containsKey("Otra ¿Cuál?")) ? "checked": ""%> value="Otra ¿Cuál?">Otra ¿Cuál?</label>
										</div>
									</div>
								</td>
							</tr>
						</table>
						<input type="text" class="form-control" id="cuales_SLPPDLC_otro" name="<%=Constants.SECTION4_COMMUNITY_PROBLEMS_OTHER%>" placeholder="¿Cuál?"  <%=homeData.getCommunity_problems_other().equals("") ? "style=\"display: none\"": ""%>>
					</div>
				</td>
				<td width="50%">
					<div>
						<div class="form-group">
							<label for="numero_TDPEEH">Número total de personas en el hogar</label> 
							<input type="number" class="form-control" id="numero_TDPEEH" name="<%=Constants.SECTION4_TOTAL_PERSONS%>" value="<%= !homeData.getTotal_persons().equals("") ? homeData.getTotal_persons(): ""%>" min="1">
						</div>
						<div class="form-group">
							<label for="numero_DB">Número de baños</label> 
							<input type="number" class="form-control" id="numero_DB" name="<%=Constants.SECTION4_NUMBER_BATHROOMS%>" value="<%= !homeData.getNumber_bathrooms().equals("") ? homeData.getNumber_bathrooms(): ""%>" min="0">
						</div>
						<div class="form-group">
							<label for="alguno_DLDDLVD3OMP">¿En alguno de los dormitorios de la vivienda duermen 3 o más personas?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION4_SLEEPS_3_OR_MORE%>" <%=(homeData.getSleeps_3_or_more().equals("Sí")) ? "checked": ""%> value="Sí">Sí</label>
								<label><input type="radio" name="<%=Constants.SECTION4_SLEEPS_3_OR_MORE%>" <%=(homeData.getSleeps_3_or_more().equals("No")||homeData.getSleeps_3_or_more().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
						</div>
						<div class="form-group">
							<label for="hogar_U_PDVAL">¿Este hogar utiliza PDVAL?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION4_USED_PDVAL%>" id="hogar_U_PDVAL_si" <%=(homeData.getUsed_pdval().equals("Sí")) ? "checked": ""%> value="Sí">Sí</label>
								<label><input type="radio" name="<%=Constants.SECTION4_USED_PDVAL%>" id="hogar_U_PDVAL_no" <%=(homeData.getUsed_pdval().equals("No")||homeData.getUsed_pdval().equals("")) ? "checked": ""%> value="No">No</label>
							</div>
							<select class="form-control" name="<%=Constants.SECTION4_USED_PDVALL_SELECTED%>" <%=homeData.getUsed_pdval_selected().equals("") ? "style=\"display: none\"": ""%>>
								<option value="Diariamente" <%= homeData.getUsed_pdval_selected().equals("Diariamente") ? "selected": ""%>>Diariamente</option>
								<option value="Semanalmente" <%= homeData.getUsed_pdval_selected().equals("Semanalmente") ? "selected": ""%>>Semanalmente</option>
								<option value="Quincenalmente" <%= homeData.getUsed_pdval_selected().equals("Quincenalmente") ? "selected": ""%>>Quincenalmente</option>
								<option value="Mensualmente" <%= homeData.getUsed_pdval_selected().equals("Mensualmente") ? "selected": ""%>>Mensualmente</option>
								<option value="Esporádicamente" <%= homeData.getUsed_pdval_selected().equals("Esporádicamente") ? "selected": ""%>>Esporádicamente</option>
							</select>
						</div>
						<div class="form-group">
							<label for="algun_MDHPEUOC">¿Algún miembro del hogar participa en una organización comunitaria?</label> 
							<div class="radio">
								<label><input type="radio" name="<%=Constants.SECTION4_COMMUNITY_ORGANIZATIO%>" id="algun_MDHPEUOC_si" <%=(homeData.getCommunity_organization().equals("Sí")) ? "checked": ""%> value="Sí">Sí ¿Cuál?</label>
								<label><input type="radio" name="<%=Constants.SECTION4_COMMUNITY_ORGANIZATIO%>" id="algun_MDHPEUOC_no" <%=(homeData.getCommunity_organization().equals("No")||homeData.getCommunity_organization().equals("")) ? "checked": ""%> value="No">No</label>
							</div> 
							<input type="text" class="form-control" id="algun_MDHPEUOC_opcion" name="<%=Constants.SECTION4_COMMUNITY_ORGANIZATION_WHICH%>" placeholder="¿Cuál?" <%=homeData.getCommunity_organization_which().equals("") ? "style=\"display: none\"": "value=\""+homeData.getCommunity_organization_which()+"\""%>>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="pagination.jsp"%>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
		$('#hogar_UM_si').change(function() {
			$('#<%=Constants.SECTION4_USED_MERCAL_SELECTED%>').show();
		});
		$('#hogar_UM_no').change(function() {
			$('#<%=Constants.SECTION4_USED_MERCAL_SELECTED%>').hide();
		});
		
		$('#hogar_HSBCMDA_si').change(function() {
			$('#hogar_HSBCMDA_grupo').show();
		});
		$('#hogar_HSBCMDA_no').change(function() {
			$('#hogar_HSBCMDA_grupo').hide();
		});
		
		$('#hogar_U_PDVAL_si').change(function() {
			$('#hogar_U_PDVAL_select').show();
		});
		$('#hogar_U_PDVAL_no').change(function() {
			$('#hogar_U_PDVAL_select').hide();
		});
		
		$('#algun_MDHPEUOC_si').change(function() {
			$('#algun_MDHPEUOC_opcion').show();
		});
		$('#algun_MDHPEUOC_no').change(function() {
			$('#algun_MDHPEUOC_opcion').hide();
		});
		
		
		$('#cuales_SLPPDLC_checkbox_otro').on('change', function (e) {
		    if($("#cuales_SLPPDLC_checkbox_otro").is(':checked')){
		    	$('#cuales_SLPPDLC_otro').show();	
		    }else{
		    	$('#cuales_SLPPDLC_otro').hide()
		    }
		});
	});
</script>

<%@ include file="footer.jsp"%>
