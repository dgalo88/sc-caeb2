<%@ include file="jsp/header.jsp"%>
<div class="form-group" align="center" style="margin: 2%;">
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
							<label for="exampleInputEmail1">Urbanizacion o Barrio</label> <input
								type="email" class="form-control" id="exampleInputEmail1"
								placeholder="Andres Eloy Blanco 2" disabled>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Calle o Pasaje</label> <input
								type="email" class="form-control" id="exampleInputEmail1"
								placeholder="Calle o Pasaje">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Nombre o numero de la
								Vivienda</label> <input type="password" class="form-control"
								id="exampleInputPassword1"
								placeholder="Nombre o numero de la Vivienda">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Telefono Residencial</label> <input
								type="text" class="form-control" id="exampleInputPassword1"
								placeholder="Nombre o numero de la Vivienda">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Tipo de Estructura</label> <select
								class="form-control">
								<option>Casa</option>
								<option>Apartamento en Edificio</option>
								<option>Apartamento en Quinta</option>
								<option>Casa de Vecindad</option>
								<option>Rancho</option>
								<option>Otros</option>
							</select>
						</div>
					</div>
				</td>
				<td valign="top">
					<div>
						<div class="form-group">
							<label for="exampleInputPassword1">Ubicacion de la Cocina</label>
							<select class="form-control">
								<option>Cuarto Solo</option>
								<option>Sala, Comedor</option>
								<option>Otro Citio</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Total de Cuarto que
								contiene la Vivienda</label> <input type="number" required
								class="form-control" id="exampleInputPassword1"
								placeholder="No incluye Baños, Pasillos, Balcones ni Lavadores">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Material Predominante
								de la Vivienda</label>
							<table style="padding: none;">
								<tr>
									<th width="30%">Paredes</th>
									<th width="30%">Techo</th>
									<th width="30%">Piso</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;"><select
										class="form-control">
											<option>Bloque o Ladrillo Frisado</option>
											<option>Bloque o Ladrillo sin Frisar</option>
											<option>Concreto</option>
											<option>Madera Aserrada, Fornica, Fibra de vidrio y
												Similares</option>
											<option>Adobe, Tapia o Bahareque sin Frisar</option>
											<option>Otros(Palmas, Tablas o Similares)</option>
									</select></td>
									<td style="padding-right: 1%;"><select
										class="form-control">
											<option>Platabanda</option>
											<option>Teja</option>
											<option>Laminas Asfalticas</option>
											<option>Laminas Metalicas(Zinz y Similares)</option>
											<option>Asbestos y Similares</option>
											<option>Otros(Palmas, Tablas o Similares)</option>
									</select></td>
									<td><select class="form-control">
											<option>Marmol, Mosaico, Granitpo, Vinil Ceramica,
												Ladrillo, Terracota,Parquet, Alfombrado y similares</option>
											<option>Cemento</option>
											<option>Tierra</option>
											<option>Otros</option>
									</select></td>
								</tr>
							</table>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Servicios con los que
								cuenta la Vivienda</label>
							<table style="padding: none;">
								<tr>
									<th width="25%">Agua</th>
									<th width="25%">Servicio Sanitario</th>
									<th width="25%">¿Dispone de Servicio Electrico?</th>
									<th width="25%">Recoleccion de Basura</th>
								</tr>
								<tr>
									<td style="padding-right: 1%;"><select
										class="form-control">
											<option>Acueducto o Tuberia</option>
											<option>Camion Cisterna</option>
											<option>Pila Publica o Estanque</option>
											<option>Pozo con tuberia o Bomba</option>
											<option>Otros medios, Especifique</option>
									</select></td>
									<td style="padding-right: 1%;"><select
										class="form-control">
											<option>Poceta Conectada a la Cloaca</option>
											<option>Poceta Conectada al Rio</option>
									</select></td>
									<td style="padding-right: 1%;"><select
										class="form-control">
											<option>Si</option>
											<option>No</option>
									</select></td>
									<td><select class="form-control">
											<option>Recogida por el Servicio de Aseo Urbano</option>
											<option>Depositada en container Colectivo</option>
											<option>Vertida en Quebradas, Rios, Lagos, Calles o
												Terrenos Baldios</option>
									</select></td>
								</tr>
							</table>
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

