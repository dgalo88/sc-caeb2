--
-- Base de datos: `censoaeb2`
--
CREATE DATABASE IF NOT EXISTS `censoaeb2` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `censoaeb2`;

--
-- Estructura de la tabla `t_administrador`
--
CREATE TABLE IF NOT EXISTS `t_administrador` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `clave` varchar(255) NOT NULL COLLATE utf8_spanish_ci,
  `usuario` varchar(255) NOT NULL COLLATE utf8_spanish_ci
) ENGINE=InnoDB ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_credito`
--
CREATE TABLE IF NOT EXISTS `t_credito` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `institucion` varchar(255) DEFAULT NULL,
  `usoCredito` varchar(255) DEFAULT NULL
) ENGINE=InnoDB ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_documento_identificacion`
--
CREATE TABLE IF NOT EXISTS `t_documento_identificacion` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `tipo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_telefono`
--
CREATE TABLE IF NOT EXISTS `t_telefono` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `codigoArea` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_vivienda`
--
CREATE TABLE IF NOT EXISTS `t_vivienda` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `cantidadPersonas` int(11) NOT NULL,
  `combustibleCocina` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `gastosSeparados` bit(1) DEFAULT NULL,
  `gruposGastosPersonas` int(11) DEFAULT NULL,
  `materialParedes` varchar(255) DEFAULT NULL,
  `materialPiso` varchar(255) DEFAULT NULL,
  `materialTecho` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `numeroCuartos` int(11) NOT NULL,
  `posibilidadAmpliacion` bit(1) NOT NULL,
  `seAjustaGrupoFamiliar` bit(1) NOT NULL,
  `servicioAgua` varchar(255) DEFAULT NULL,
  `servicioElectrico` bit(1) NOT NULL,
  `servicioRecoleccionBasura` varchar(255) DEFAULT NULL,
  `servicioSanitario` varchar(255) DEFAULT NULL,
  `tenencia` varchar(255) DEFAULT NULL,
  `tipoEstructura` varchar(255) DEFAULT NULL,
  `tipoSector` varchar(255) DEFAULT NULL,
  `ubicacionCocina` varchar(255) DEFAULT NULL,
  `zonaRiesgo` varchar(255) DEFAULT NULL,
  `telefonoId` int(11) DEFAULT NULL,
  FOREIGN KEY (`telefonoId`) REFERENCES `t_telefono` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_hogar`
--
CREATE TABLE IF NOT EXISTS `t_hogar` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `beneficioMercado` varchar(255) DEFAULT NULL,
  `dormitorioTresOMas` bit(1) NOT NULL,
  `jefeTienePareja` bit(1) NOT NULL,
  `miembroParticipaOrganizacionComunitaria` varchar(255) DEFAULT NULL,
  `numeroBanos` int(11) NOT NULL,
  `numeroComidas` int(11) NOT NULL,
  `numeroCuartos` int(11) NOT NULL,
  `numeroPersonas` int(11) NOT NULL,
  `principalProblemaComunidad` varchar(255) DEFAULT NULL,
  `utilizaMercal` varchar(255) DEFAULT NULL,
  `utilizaPdval` varchar(255) DEFAULT NULL,
  `vigilanciaPolicial` varchar(255) DEFAULT NULL,
  `viviendaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `t_vivienda` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_empleo`
--
CREATE TABLE IF NOT EXISTS `t_empleo` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `lugarTrabajo` varchar(255) DEFAULT NULL,
  `oficio` varchar(255) DEFAULT NULL,
  `situacion` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `tipoNegocio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_persona`
--
CREATE TABLE IF NOT EXISTS `t_persona` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `aisteEstablecimientoEducacion` bit(1) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `asisteControlMedicoParental` bit(1) NOT NULL,
  `beneficioEstablecimientoEducacion` varchar(255) DEFAULT NULL,
  `cursoCapacitacion` varchar(255) DEFAULT NULL,
  `edadNacimientoPrimerHijo` int(11) NOT NULL,
  `esAnalfabeta` bit(1) NOT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `haAsistidoServicioSalud` bit(1) NOT NULL,
  `ingresoMensual` varchar(255) DEFAULT NULL,
  `nivelEducativo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numeroHijosAunViven` int(11) NOT NULL,
  `numeroHijosNacidosVivos` int(11) NOT NULL,
  `otrasHabilidades` varchar(255) DEFAULT NULL,
  `parentescoJefeHogar` varchar(255) DEFAULT NULL,
  `profesion` varchar(255) DEFAULT NULL,
  `respEstablecimientoEducacion` varchar(255) DEFAULT NULL,
  `seEncuentraEmbarazada` bit(1) NOT NULL,
  `sexo` char(1) NOT NULL,
  `situacionConyugal` varchar(255) DEFAULT NULL,
  `tienePareja` bit(1) NOT NULL,
  `ultimoGradoAprobado` int(11) NOT NULL,
  `creditoId` int(11) DEFAULT NULL,
  `documentoIdentificacionId` int(11) DEFAULT NULL,
  `empleoId` int(11) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  `telefonoId` int(11) DEFAULT NULL,
  FOREIGN KEY (`creditoId`) REFERENCES `t_credito` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`documentoIdentificacionId`) REFERENCES `t_documento_identificacion` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`hogarId`) REFERENCES `t_hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`empleoId`) REFERENCES `t_empleo` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`telefonoId`) REFERENCES `t_telefono` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_aparato_medico`
--
CREATE TABLE IF NOT EXISTS `t_aparato_medico` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_casos_violencia`
--
CREATE TABLE IF NOT EXISTS `t_casos_violencia` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `denunciado` bit(1) NOT NULL,
  `violenciaMujer` varchar(255) DEFAULT NULL,
  `violenciaNinos` varchar(255) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `t_hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_delito`
--
CREATE TABLE IF NOT EXISTS `t_delito` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `denuncio` bit(1) NOT NULL,
  `haSidoVictima` bit(1) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_delito_hogar`
--
CREATE TABLE IF NOT EXISTS `t_delito_hogar` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `delitoId` int(11) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`delitoId`) REFERENCES `t_delito` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`hogarId`) REFERENCES `t_hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_deporte`
--
CREATE TABLE IF NOT EXISTS `t_deporte` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_discapacidad`
--
CREATE TABLE IF NOT EXISTS `t_discapacidad` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_electrodomestico`
--
CREATE TABLE IF NOT EXISTS `t_electrodomestico` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `t_hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_observaciones`
--
CREATE TABLE IF NOT EXISTS `t_observaciones` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `observacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_encuesta`
--
CREATE TABLE IF NOT EXISTS `t_encuesta` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `fechaEntrevista` datetime DEFAULT NULL,
  `nombreEmpadronador` varchar(255) DEFAULT NULL,
  `numeroPlanilla` int(11) NOT NULL,
  `observacionesId` int(11) DEFAULT NULL,
  `viviendaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`observacionesId`) REFERENCES `t_observaciones` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`viviendaId`) REFERENCES `t_vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_enfermedad_padecida`
--
CREATE TABLE IF NOT EXISTS `t_enfermedad_padecida` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_habilidad_artistica_manual`
--
CREATE TABLE IF NOT EXISTS `t_habilidad_artistica_manual` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_lugar_asistencia_medica`
--
CREATE TABLE IF NOT EXISTS `t_lugar_asistencia_medica` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_mejora`
--
CREATE TABLE IF NOT EXISTS `t_mejora` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `parte` varchar(255) DEFAULT NULL,
  `queMejorar` varchar(255) DEFAULT NULL,
  `requiereMejora` bit(1) NOT NULL,
  `trabajo` varchar(255) DEFAULT NULL,
  `viviendaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `t_vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_idioma`
--
CREATE TABLE IF NOT EXISTS `t_idioma` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_persona_idioma`
--
CREATE TABLE IF NOT EXISTS `t_persona_idioma` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `idiomaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`idiomaId`) REFERENCES `t_idioma` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_mision_educativa`
--
CREATE TABLE IF NOT EXISTS `t_mision_educativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `haAsistido` bit(1) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `razonAbandono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_persona_mision_educativa`
--
CREATE TABLE IF NOT EXISTS `t_persona_mision_educativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `misionEducativaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`misionEducativaId`) REFERENCES `t_mision_educativa` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_programa_mision`
--
CREATE TABLE IF NOT EXISTS `t_programa_mision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_persona_programa_mision`
--
CREATE TABLE IF NOT EXISTS `t_persona_programa_mision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `programaMisionId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`programaMisionId`) REFERENCES `t_programa_mision` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_recurso_tarea_educativa`
--
CREATE TABLE IF NOT EXISTS `t_recurso_tarea_educativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `recurso` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_persona_recurso_tarea_educativa`
--
CREATE TABLE IF NOT EXISTS `t_persona_recurso_tarea_educativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `recursoTareaEducativaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`recursoTareaEducativaId`) REFERENCES `t_recurso_tarea_educativa` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_planificacion_familiar`
--
CREATE TABLE IF NOT EXISTS `t_planificacion_familiar` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `tieneInformacion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_razon_acudir_establecimiento_salud`
--
CREATE TABLE IF NOT EXISTS `t_razon_acudir_establecimiento_salud` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_sistema_prevencion_social`
--
CREATE TABLE IF NOT EXISTS `t_sistema_prevencion_social` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_vacuna`
--
CREATE TABLE IF NOT EXISTS `t_vacuna` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `numeroDosis` int(11) NOT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `t_persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_vehiculo`
--
CREATE TABLE IF NOT EXISTS `t_vehiculo` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `t_hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_mision`
--
CREATE TABLE IF NOT EXISTS `t_mision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `t_vivienda_mision`
--
CREATE TABLE IF NOT EXISTS `t_vivienda_mision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `viviendaId` int(11) DEFAULT NULL,
  `misionId` int(11) DEFAULT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `t_vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`misionId`) REFERENCES `t_mision` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
