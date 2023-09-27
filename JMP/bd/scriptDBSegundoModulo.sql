-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema reuniones
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema reuniones
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reuniones` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;
USE `reuniones` ;

-- -----------------------------------------------------
-- Table `reuniones`.`cestudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reuniones`.`cestudiante` (
  `idCestudiante` INT NOT NULL AUTO_INCREMENT,
  `nombreApellido` VARCHAR(100) NOT NULL,
  `rol` VARCHAR(45) NULL DEFAULT NULL,
  `fechaNacimiento` DATE NOT NULL,
  PRIMARY KEY (`idCestudiante`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reuniones`.`cestudiante_has_club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reuniones`.`cestudiante_has_club` (
  `cestudiante_idCestudiante` INT NOT NULL,
  `CLUB_idClub` INT NOT NULL,
  PRIMARY KEY (`cestudiante_idCestudiante`, `CLUB_idClub`),
  INDEX `fk_cestudiante_has_CLUB_CLUB1_idx` (`CLUB_idClub` ASC) VISIBLE,
  INDEX `fk_cestudiante_has_CLUB_cestudiante1_idx` (`cestudiante_idCestudiante` ASC) VISIBLE,
  CONSTRAINT `fk_cestudiante_has_CLUB_cestudiante1`
    FOREIGN KEY (`cestudiante_idCestudiante`)
    REFERENCES `reuniones`.`cestudiante` (`idCestudiante`),
  CONSTRAINT `fk_cestudiante_has_CLUB_CLUB1`
    FOREIGN KEY (`CLUB_idClub`)
    REFERENCES `mydb`.`club` (`idClub`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reuniones`.`cestudiante_has_queja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reuniones`.`cestudiante_has_queja` (
  `cestudiante_idCestudiante` INT NOT NULL,
  `QUEJA_idQuejas` INT NOT NULL,
  PRIMARY KEY (`cestudiante_idCestudiante`, `QUEJA_idQuejas`),
  INDEX `fk_cestudiante_has_QUEJA_QUEJA1_idx` (`QUEJA_idQuejas` ASC) VISIBLE,
  INDEX `fk_cestudiante_has_QUEJA_cestudiante1_idx` (`cestudiante_idCestudiante` ASC) VISIBLE,
  CONSTRAINT `fk_cestudiante_has_QUEJA_cestudiante1`
    FOREIGN KEY (`cestudiante_idCestudiante`)
    REFERENCES `reuniones`.`cestudiante` (`idCestudiante`),
  CONSTRAINT `fk_cestudiante_has_QUEJA_QUEJA1`
    FOREIGN KEY (`QUEJA_idQuejas`)
    REFERENCES `mydb`.`queja` (`idQuejas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reuniones`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reuniones`.`club` (
  `idClub` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `profesor` VARCHAR(45) NOT NULL,
  `actividades` VARCHAR(45) NOT NULL,
  `descripcionActividad` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idClub`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reuniones`.`queja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reuniones`.`queja` (
  `idQueja` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(1000) NOT NULL,
  `nombreApellido` VARCHAR(45) NOT NULL,
  `añoDivision` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idQueja`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reuniones`.`reunion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reuniones`.`reunion` (
  `idReunion` INT NOT NULL AUTO_INCREMENT,
  `temaTratado` VARCHAR(45) NOT NULL,
  `detalleAsamblea` VARCHAR(300) NOT NULL,
  `resumenAsamblea` VARCHAR(100) NOT NULL,
  `fechaAsamblea` DATE NOT NULL,
  PRIMARY KEY (`idReunion`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reuniones`.`reunion_has_cestudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reuniones`.`reunion_has_cestudiante` (
  `REUNION_idReunion` INT NOT NULL,
  `CESTUDIANTE_idCestudiante` INT NOT NULL,
  PRIMARY KEY (`REUNION_idReunion`, `CESTUDIANTE_idCestudiante`),
  INDEX `fk_REUNION_has_CESTUDIANTE_CESTUDIANTE1_idx` (`CESTUDIANTE_idCestudiante` ASC) VISIBLE,
  INDEX `fk_REUNION_has_CESTUDIANTE_REUNION_idx` (`REUNION_idReunion` ASC) VISIBLE,
  CONSTRAINT `fk_REUNION_has_CESTUDIANTE_CESTUDIANTE1`
    FOREIGN KEY (`CESTUDIANTE_idCestudiante`)
    REFERENCES `reuniones`.`cestudiante` (`idCestudiante`),
  CONSTRAINT `fk_REUNION_has_CESTUDIANTE_REUNION`
    FOREIGN KEY (`REUNION_idReunion`)
    REFERENCES `reuniones`.`reunion` (`idReunion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
