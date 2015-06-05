--
-- Base de datos: `censoaeb2`
--
CREATE DATABASE IF NOT EXISTS `censoaeb2` DEFAULT CHARACTER SET utf8;
USE `censoaeb2`;

--
-- Estructura de la tabla `administrador`
--
CREATE TABLE IF NOT EXISTS `administrador` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `usuario` varchar(40) NOT NULL,
  `clave` varchar(40) NOT NULL
) ENGINE=InnoDB ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Insertar en la tabla `administrador` el administrador por defecto
--
INSERT INTO `administrador` (`id`, `usuario`, `clave`) VALUES ('1', 'admin', SHA1('1234'));

--
-- Estructura de la tabla `documentoIdentificacion`
--
CREATE TABLE IF NOT EXISTS `documentoIdentificacion` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `tipo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `directivaCC`
--
CREATE TABLE IF NOT EXISTS `directivaCC` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `apellido` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `documentoIdentificacionId` int(11) DEFAULT NULL,
  `administradorId` int(11) DEFAULT NULL,
  FOREIGN KEY (`documentoIdentificacionId`) REFERENCES `documentoIdentificacion` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`administradorId`) REFERENCES `administrador` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `credito`
--
CREATE TABLE IF NOT EXISTS `credito` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `institucion` varchar(255) DEFAULT NULL,
  `usoCredito` varchar(255) DEFAULT NULL
) ENGINE=InnoDB ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `telefono`
--
CREATE TABLE IF NOT EXISTS `telefono` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `codigoArea` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `vivienda`
--
CREATE TABLE IF NOT EXISTS `vivienda` (
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
  FOREIGN KEY (`telefonoId`) REFERENCES `telefono` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `hogar`
--
CREATE TABLE IF NOT EXISTS `hogar` (
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
  FOREIGN KEY (`viviendaId`) REFERENCES `vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `empleo`
--
CREATE TABLE IF NOT EXISTS `empleo` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `lugarTrabajo` varchar(255) DEFAULT NULL,
  `oficio` varchar(255) DEFAULT NULL,
  `situacion` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `tipoNegocio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `persona`
--
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `apellido` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `tienePartidaNacimiento` bit(1) NOT NULL,
  `aisteEstablecimientoEducacion` bit(1) NOT NULL,
  `asisteControlMedicoParental` bit(1) NOT NULL,
  `beneficioEstablecimientoEducacion` varchar(255) DEFAULT NULL,
  `cursoCapacitacion` varchar(255) DEFAULT NULL,
  `edadNacimientoPrimerHijo` int(11) NOT NULL,
  `esAnalfabeta` bit(1) NOT NULL,
  `haAsistidoServicioSalud` bit(1) NOT NULL,
  `ingresoMensual` varchar(255) DEFAULT NULL,
  `nivelEducativo` varchar(255) DEFAULT NULL,
  `numeroHijosAunViven` int(11) NOT NULL,
  `numeroHijosNacidosVivos` int(11) NOT NULL,
  `otrasHabilidades` varchar(255) DEFAULT NULL,
  `parentescoJefeHogar` varchar(255) DEFAULT NULL,
  `profesion` varchar(255) DEFAULT NULL,
  `respEstablecimientoEducacion` varchar(255) DEFAULT NULL,
  `seEncuentraEmbarazada` bit(1) NOT NULL,
  `situacionConyugal` varchar(255) DEFAULT NULL,
  `tienePareja` bit(1) NOT NULL,
  `ultimoGradoAprobado` int(11) NOT NULL,
  `creditoId` int(11) DEFAULT NULL,
  `documentoIdentificacionId` int(11) DEFAULT NULL,
  `empleoId` int(11) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  `telefonoId` int(11) DEFAULT NULL,
  FOREIGN KEY (`creditoId`) REFERENCES `credito` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`documentoIdentificacionId`) REFERENCES `documentoIdentificacion` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`empleoId`) REFERENCES `empleo` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`telefonoId`) REFERENCES `telefono` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `aparatoMedico`
--
CREATE TABLE IF NOT EXISTS `aparatoMedico` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `casosViolencia`
--
CREATE TABLE IF NOT EXISTS `casosViolencia` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `denunciado` bit(1) NOT NULL,
  `violenciaMujer` varchar(255) DEFAULT NULL,
  `violenciaNinos` varchar(255) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `hogarCasosViolencia`
--
CREATE TABLE IF NOT EXISTS `hogarCasosViolencia` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `hogarId` int(11) DEFAULT NULL,
  `casosViolenciaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`casosViolenciaId`) REFERENCES `casosViolencia` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `delito`
--
CREATE TABLE IF NOT EXISTS `delito` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `denuncio` bit(1) NOT NULL,
  `haSidoVictima` bit(1) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `delitoHogar`
--
CREATE TABLE IF NOT EXISTS `delitoHogar` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `delitoId` int(11) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`delitoId`) REFERENCES `delito` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `deporte`
--
CREATE TABLE IF NOT EXISTS `deporte` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `discapacidad`
--
CREATE TABLE IF NOT EXISTS `discapacidad` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `electrodomestico`
--
CREATE TABLE IF NOT EXISTS `electrodomestico` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `observaciones`
--
CREATE TABLE IF NOT EXISTS `observaciones` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `observacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `encuesta`
--
CREATE TABLE IF NOT EXISTS `encuesta` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `fechaEntrevista` datetime DEFAULT NULL,
  `nombreEmpadronador` varchar(255) DEFAULT NULL,
  `numeroPlanilla` int(11) NOT NULL,
  `observacionesId` int(11) DEFAULT NULL,
  `viviendaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`observacionesId`) REFERENCES `observaciones` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`viviendaId`) REFERENCES `vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `enfermedadPadecida`
--
CREATE TABLE IF NOT EXISTS `enfermedadPadecida` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `habilidadArtisticaManual`
--
CREATE TABLE IF NOT EXISTS `habilidadArtisticaManual` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `lugarAsistenciaMedica`
--
CREATE TABLE IF NOT EXISTS `lugarAsistenciaMedica` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `mejora`
--
CREATE TABLE IF NOT EXISTS `mejora` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `parte` varchar(255) DEFAULT NULL,
  `queMejorar` varchar(255) DEFAULT NULL,
  `requiereMejora` bit(1) NOT NULL,
  `trabajo` varchar(255) DEFAULT NULL,
  `viviendaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `idioma`
--
CREATE TABLE IF NOT EXISTS `idioma` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `personaIdioma`
--
CREATE TABLE IF NOT EXISTS `personaIdioma` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `idiomaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`idiomaId`) REFERENCES `idioma` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `misionEducativa`
--
CREATE TABLE IF NOT EXISTS `misionEducativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `haAsistido` bit(1) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `razonAbandono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `personaMisionEducativa`
--
CREATE TABLE IF NOT EXISTS `personaMisionEducativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `misionEducativaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`misionEducativaId`) REFERENCES `misionEducativa` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `programaMision`
--
CREATE TABLE IF NOT EXISTS `programaMision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `personaProgramaMision`
--
CREATE TABLE IF NOT EXISTS `personaProgramaMision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `programaMisionId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`programaMisionId`) REFERENCES `programaMision` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `recursoTareaEducativa`
--
CREATE TABLE IF NOT EXISTS `recursoTareaEducativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `recurso` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `personaRecursoTareaEducativa`
--
CREATE TABLE IF NOT EXISTS `personaRecursoTareaEducativa` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `recursoTareaEducativaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`recursoTareaEducativaId`) REFERENCES `recursoTareaEducativa` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `planificacionFamiliar`
--
CREATE TABLE IF NOT EXISTS `planificacionFamiliar` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `tieneInformacion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `razonAcudirEstablecimientoSalud`
--
CREATE TABLE IF NOT EXISTS `razonAcudirEstablecimientoSalud` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `sistemaPrevencionSocial`
--
CREATE TABLE IF NOT EXISTS `sistemaPrevencionSocial` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `vacuna`
--
CREATE TABLE IF NOT EXISTS `vacuna` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `numeroDosis` int(11) NOT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `vehiculo`
--
CREATE TABLE IF NOT EXISTS `vehiculo` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `mision`
--
CREATE TABLE IF NOT EXISTS `mision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `viviendaMision`
--
CREATE TABLE IF NOT EXISTS `viviendaMision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `viviendaId` int(11) DEFAULT NULL,
  `misionId` int(11) DEFAULT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`misionId`) REFERENCES `mision` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
