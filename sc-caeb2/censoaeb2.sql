--
-- Base de datos: `censoaeb2`
--
CREATE DATABASE IF NOT EXISTS `censoaeb2` DEFAULT CHARACTER SET utf8;
USE `censoaeb2`;

--
-- Estructura de la tabla `vivienda`
--
CREATE TABLE IF NOT EXISTS `vivienda` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `callePasaje` varchar(255) NOT NULL,
  `nombre` varchar(100) NOT NULL UNIQUE,
  `telefono` varchar(100) DEFAULT NULL,
  `tipoEstructura` varchar(100) DEFAULT NULL,
  `materialParedes` varchar(255) DEFAULT NULL,
  `materialPiso` varchar(255) DEFAULT NULL,
  `materialTecho` varchar(255) DEFAULT NULL,
  `tenencia` varchar(100) DEFAULT NULL,
  `ubicacionCocina` varchar(20) DEFAULT NULL,
  `numeroCuartos` int(11),
  `servicioAgua` varchar(100) DEFAULT NULL,
  `servicioSanitario` varchar(100) DEFAULT NULL,
  `servicioElectrico` bit(1),
  `servicioRecoleccionBasura` varchar(255) DEFAULT NULL,
  `seAjustaGrupoFamiliar` bit(1),
  `tipoSector` varchar(20) DEFAULT NULL,
  `zonaRiesgo` varchar(20) DEFAULT NULL,
  `posibilidadAmpliacion` bit(1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `mejoraInfo`
--
CREATE TABLE IF NOT EXISTS `mejoraInfo` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `tipo` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `valor` varchar(255) DEFAULT NULL,
  `viviendaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `hogar`
--
CREATE TABLE IF NOT EXISTS `hogar` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `numeroCuartos` int(11) NOT NULL,
  `numeroBanos` int(11) NOT NULL,
  `jefeTienePareja` bit(1) NOT NULL,
  `dormitorioTresOMas` bit(1) NOT NULL,
  `utilizaMercal` varchar(20) DEFAULT NULL,
  `utilizaPdval` varchar(20) DEFAULT NULL,
  `beneficioMercado` varchar(20) DEFAULT NULL,
  `miembroParticipaOrganizacionComunitaria` varchar(255) DEFAULT NULL,
  `viviendaId` int(11) NOT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `vivienda` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `principalesProblemasComunidad`
--
CREATE TABLE IF NOT EXISTS `principalesProblemasComunidad` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `valor` varchar(100) DEFAULT NULL,
  `hogarId` int(11) DEFAULT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `persona`
--
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `apellidos` varchar(100) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `parentescoJefeHogar` varchar(100) DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `fechaNacimiento` datetime NOT NULL,
  `nacionalidad` varchar(100) NOT NULL,
  `cedula` varchar(100) NOT NULL UNIQUE,
  `pasaporte` varchar(100) DEFAULT NULL UNIQUE,
  `correoElectronico` varchar(100) DEFAULT NULL,
  `celular` varchar(100) DEFAULT NULL,
  `celularOpcional` varchar(100) DEFAULT NULL,
  `esAnalfabeta` bit(1) NOT NULL,
  `asisteEstablecimientoEducacion` bit(1) NOT NULL,
  `respEstablecimientoEducacion` varchar(255) DEFAULT NULL,
  `recibeBeca` varchar(255) DEFAULT NULL,
  `cursoCapacitacion` varchar(255) DEFAULT NULL,
  `nivelEducativo` varchar(255) DEFAULT NULL,
  `ultimoGradoAprobado` int(11) DEFAULT NULL,
  `profesion` varchar(255) DEFAULT NULL,
  `ingresoMensual` varchar(100) DEFAULT NULL,
  `otrasHabilidades` varchar(255) DEFAULT NULL,
  `credito` varchar(255) DEFAULT NULL,
  `creditoOtros` varchar(255) DEFAULT NULL,
  `seEncuentraEmbarazada` bit(1) NOT NULL,
  `asisteControlMedicoParental` bit(1) NOT NULL,
  `lugarAsistenciaMedica` varchar(255) DEFAULT NULL,
  `razonAsistenciaMedica` varchar(255) DEFAULT NULL,
  `fechaLlegada` datetime DEFAULT NULL,
  `hogarId` int(11) NOT NULL,
  FOREIGN KEY (`hogarId`) REFERENCES `hogar` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `empleo`
--
CREATE TABLE IF NOT EXISTS `empleo` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `situacion` varchar(255) DEFAULT NULL,
  `oficio` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `tipo_seleccion` varchar(255) DEFAULT NULL,
  `tipoNegocio` varchar(20) DEFAULT NULL,
  `lugarTrabajo` varchar(150) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `directivaCC`
--
CREATE TABLE IF NOT EXISTS `directivaCC` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `administrador`
--
CREATE TABLE IF NOT EXISTS `administrador` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `usuario` varchar(40) NOT NULL UNIQUE,
  `clave` varchar(40) NOT NULL,
  `directivaCCId` int(11) DEFAULT NULL,
  FOREIGN KEY (`directivaCCId`) REFERENCES `directivaCC` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `encuesta`
--
CREATE TABLE IF NOT EXISTS `encuesta` (
  `numeroPlanilla` int(11) PRIMARY KEY AUTO_INCREMENT,
  `fechaEntrevista` datetime DEFAULT NULL,
  `nombreEmpadronador` varchar(100) DEFAULT NULL,
  `observaciones` LONGTEXT DEFAULT NULL,
  `viviendaId` int(11) NOT NULL,
  FOREIGN KEY (`viviendaId`) REFERENCES `vivienda` (`id`)
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
-- Estructura de la tabla `enfermedadPadecida`
--
CREATE TABLE IF NOT EXISTS `enfermedadPadecida` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `valor` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `aparatoMedico`
--
CREATE TABLE IF NOT EXISTS `aparatoMedico` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `loTiene` bit(1) NOT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `vacuna`
--
CREATE TABLE IF NOT EXISTS `vacuna` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `numeroDosis` int(11) NOT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `habilidadArtisticaManual`
--
CREATE TABLE IF NOT EXISTS `habilidadArtisticaManual` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `clave` varchar(100) DEFAULT NULL,
  `valor` varchar(100) DEFAULT NULL,
  `participacion` varchar(1) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `deporte`
--
CREATE TABLE IF NOT EXISTS `deporte` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `clave` varchar(100) DEFAULT NULL,
  `valor` varchar(100) DEFAULT NULL,
  `participacion` varchar(1) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Estructura de la tabla `mision`
--
CREATE TABLE IF NOT EXISTS `mision` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `tipo` varchar(1) DEFAULT NULL,
  `mision` varchar(255) DEFAULT NULL,
  `personaId` int(11) DEFAULT NULL,
  FOREIGN KEY (`personaId`) REFERENCES `persona` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
