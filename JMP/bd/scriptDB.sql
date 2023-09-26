-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema SistemaOTS
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SistemaOTS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SistemaOTS` DEFAULT CHARACTER SET utf8mb3 ;
USE `SistemaOTS` ;

-- -----------------------------------------------------
-- Table `SistemaOTS`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaOTS`.`categoria` (
  `idCATEGORIA` INT NOT NULL AUTO_INCREMENT,
  `NomCategoria` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idCATEGORIA`),
  UNIQUE INDEX `NomCategoria_UNIQUE` (`NomCategoria` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `SistemaOTS`.`propuesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaOTS`.`propuesta` (
  `idPropuesta` INT NOT NULL AUTO_INCREMENT,
  `origenPropuesta` VARCHAR(65) NOT NULL,
  `tituloPropuesta` VARCHAR(45) NOT NULL,
  `categoria` INT NOT NULL,
  `breveDescripcion` VARCHAR(125) NOT NULL,
  `autorPropuesta` VARCHAR(65) NULL DEFAULT NULL,
  `fechaPropuesta` DATE NOT NULL,
  `estadoPropuesta` VARCHAR(45) NOT NULL DEFAULT 'Pendiente de Aprobacion',
  `motivoRechazo` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`idPropuesta`),
  INDEX `idCATEGORIA_idx` (`categoria` ASC) VISIBLE,
  CONSTRAINT `categoriaPropuesta`
    FOREIGN KEY (`categoria`)
    REFERENCES `SistemaOTS`.`categoria` (`idCATEGORIA`))
ENGINE = InnoDB
AUTO_INCREMENT = 33
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `SistemaOTS`.`jornada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaOTS`.`jornada` (
  `idJornada` INT NOT NULL AUTO_INCREMENT,
  `idPropuesta` INT NOT NULL,
  `refInstiJornada` VARCHAR(65) NOT NULL,
  `tituloJornada` VARCHAR(45) NOT NULL,
  `materialIncluidoJornada` VARCHAR(65) NOT NULL,
  `objetivoJornada` VARCHAR(125) NOT NULL,
  `EsJornadaPrioritaria` TINYINT NOT NULL,
  PRIMARY KEY (`idJornada`),
  INDEX `fk_JORNADA_PROPUESTA_idx` (`idPropuesta` ASC) VISIBLE,
  CONSTRAINT `fk_JORNADA_PROPUESTA`
    FOREIGN KEY (`idPropuesta`)
    REFERENCES `SistemaOTS`.`propuesta` (`idPropuesta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `SistemaOTS`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaOTS`.`material` (
  `idMaterial` INT NOT NULL AUTO_INCREMENT,
  `tituloMaterial` VARCHAR(45) NOT NULL,
  `categoriaMaterial` INT NOT NULL,
  `descripcionMaterial` VARCHAR(125) NOT NULL,
  `fuenteMaterial` VARCHAR(45) NOT NULL,
  `enlaceAlDocMaterial` VARCHAR(300) NOT NULL,
  `esMaterialPrioritario` VARCHAR(2) NULL DEFAULT NULL,
  `Procedencia` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idMaterial`),
  INDEX `categoriaMaterial_idx` (`categoriaMaterial` ASC) VISIBLE,
  CONSTRAINT `categoriaMaterial`
    FOREIGN KEY (`categoriaMaterial`)
    REFERENCES `SistemaOTS`.`categoria` (`idCATEGORIA`))
ENGINE = InnoDB
AUTO_INCREMENT = 105
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `SistemaOTS`.`material_jornada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaOTS`.`material_jornada` (
  `MATERIAL_idMaterial` INT NOT NULL,
  `JORNADA_idJornada` INT NOT NULL,
  PRIMARY KEY (`MATERIAL_idMaterial`, `JORNADA_idJornada`),
  INDEX `fk_MATERIAL_has_JORNADA_JORNADA1_idx` (`JORNADA_idJornada` ASC) VISIBLE,
  INDEX `fk_MATERIAL_has_JORNADA_MATERIAL1_idx` (`MATERIAL_idMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_MATERIAL_has_JORNADA_JORNADA1`
    FOREIGN KEY (`JORNADA_idJornada`)
    REFERENCES `SistemaOTS`.`jornada` (`idJornada`),
  CONSTRAINT `fk_MATERIAL_has_JORNADA_MATERIAL1`
    FOREIGN KEY (`MATERIAL_idMaterial`)
    REFERENCES `SistemaOTS`.`material` (`idMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `SistemaOTS`.`material_propuesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaOTS`.`material_propuesta` (
  `MATERIAL_idMaterial` INT NOT NULL,
  `PROPUESTA_idPropuesta` INT NOT NULL,
  PRIMARY KEY (`MATERIAL_idMaterial`, `PROPUESTA_idPropuesta`),
  INDEX `fk_MATERIAL_has_PROPUESTA_PROPUESTA1_idx` (`PROPUESTA_idPropuesta` ASC) VISIBLE,
  INDEX `fk_MATERIAL_has_PROPUESTA_MATERIAL1_idx` (`MATERIAL_idMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_MATERIAL_has_PROPUESTA_MATERIAL1`
    FOREIGN KEY (`MATERIAL_idMaterial`)
    REFERENCES `SistemaOTS`.`material` (`idMaterial`),
  CONSTRAINT `fk_MATERIAL_has_PROPUESTA_PROPUESTA1`
    FOREIGN KEY (`PROPUESTA_idPropuesta`)
    REFERENCES `SistemaOTS`.`propuesta` (`idPropuesta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
