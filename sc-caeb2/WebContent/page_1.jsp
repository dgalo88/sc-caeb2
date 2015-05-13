<%@ include file="jsp/header.jsp"%>
<div class="container" style="padding-top: 2%;">
	<form>
		<table width="100%">
			<tr>
				<th  width="50%"></th>
				<th  width="50%"></th>
			</tr>
			<tr>
				<td valign="top" style="padding-right: 2%;">
					<div>
						<div class="form-group">
							<label for="urbanizacion">Urbanización o barrio</label> 
							<input type="text" class="form-control" id="urbanizacion" placeholder="Andrés Eloy Blanco 2" disabled>
						</div>
						<div class="form-group">
							<label for="nombre_vivienda">Nombre o número de vivienda</label> 
							<input type="text" class="form-control" id="exampleInputPassword1" placeholder="21 o Pérez">
						</div>
					</div>
				</td>
				<td valign="top">
					<div>
						<div class="form-group">
							<label for="calle_pasaje">Calle o pasaje</label> 
							<input type="text" class="form-control" id="calle_pasaje" name="calle_pasaje" placeholder="Calle o Pasaje">
						</div>
						<div class="form-group">
							<label for="telefono_residencial">Teléfono residencia </label> 
							<input type="text" class="form-control" id="telefono_residencial" name="telefono_residencial" placeholder="02742395120">
						</div>
					</div>
				</td>
			</tr>
			<tr><td></td><td valign="top" align="right"><button class="btn btn-lg btn-primary btn-block" type="submit" style="width: initial;">Siguiente</button></td></tr>
		</table>
		
	</form>
</div>


<!-- <form class="form-horizontal" style="margin: 2%;"> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">Email:</label> -->
<!--         <div class="col-xs-9"> -->
<!--             <input type="email" class="form-control" id="inputEmail" placeholder="Email"> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">Password:</label> -->
<!--         <div class="col-xs-9"> -->
<!--             <input type="password" class="form-control" id="inputPassword" placeholder="Password"> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">Confirmar Password:</label> -->
<!--         <div class="col-xs-9"> -->
<!--             <input type="password" class="form-control" placeholder="Confirmar Password"> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">Nombre:</label> -->
<!--         <div class="col-xs-9"> -->
<!--             <input type="text" class="form-control" placeholder="Nombre"> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">Apellido:</label> -->
<!--         <div class="col-xs-9"> -->
<!--             <input type="text" class="form-control" placeholder="Apellido"> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3" >Telefono:</label> -->
<!--         <div class="col-xs-9"> -->
<!--             <input type="tel" class="form-control" placeholder="Telefono"> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">F. Nacimiento:</label> -->
<!--         <div class="col-xs-3"> -->
<!--             <select class="form-control"> -->
<!--                 <option>Dia</option> -->
<!--             </select> -->
<!--         </div> -->
<!--         <div class="col-xs-3"> -->
<!--             <select class="form-control"> -->
<!--                 <option>Mes</option> -->
<!--             </select> -->
<!--         </div> -->
<!--         <div class="col-xs-3"> -->
<!--             <select class="form-control"> -->
<!--                 <option>Año</option> -->
<!--             </select> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">Dirección:</label> -->
<!--         <div class="col-xs-9"> -->
<!--             <textarea rows="3" class="form-control" placeholder="Dirección"></textarea> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <label class="control-label col-xs-3">Genero:</label> -->
<!--         <div class="col-xs-2"> -->
<!--             <label class="radio-inline"> -->
<!--                 <input type="radio" name="genderRadios" value="male"> Maculino -->
<!--             </label> -->
<!--         </div> -->
<!--         <div class="col-xs-2"> -->
<!--             <label class="radio-inline"> -->
<!--                 <input type="radio" name="genderRadios" value="female"> Femenino -->
<!--             </label> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <div class="col-xs-offset-3 col-xs-9"> -->
<!--             <label class="checkbox-inline"> -->
<!--                 <input type="checkbox" value="news"> Enviar noticias. -->
<!--             </label> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="form-group"> -->
<!--         <div class="col-xs-offset-3 col-xs-9"> -->
<!--             <label class="checkbox-inline"> -->
<!--                 <input type="checkbox" value="agree">  Accepto <a href="#">Terminos y condiciones</a>. -->
<!--             </label> -->
<!--         </div> -->
<!--     </div> -->
<!--     <br> -->
<!--     <div class="form-group"> -->
<!--         <div class="col-xs-offset-3 col-xs-9"> -->
<!--             <input type="submit" class="btn btn-primary" value="Enviar"> -->
<!--             <input type="reset" class="btn btn-default" value="Limpiar"> -->
<!--         </div> -->
<!--     </div> -->
<!-- </form> -->

<%@ include file="jsp/footer.jsp"%>

