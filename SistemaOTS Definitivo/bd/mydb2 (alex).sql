-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb2` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb2` ;

-- -----------------------------------------------------
-- Table `mydb2`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`evento` (
  `idEvento` INT NOT NULL AUTO_INCREMENT,
  `titulo_Evento` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_Evento` DATETIME NOT NULL,
  `hora_inicio` TINYINT NULL DEFAULT NULL,
  `motivo_Evento` VARCHAR(45) NULL DEFAULT NULL,
  `hora_Fin` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`idEvento`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb2`.`noticia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`noticia` (
  `idNoticia` INT NOT NULL AUTO_INCREMENT,
  `titulo_Noticia` VARCHAR(45) NULL DEFAULT NULL,
  `contenidoNoticia` VARCHAR(512) NULL DEFAULT NULL,
  `fechaNoticia` DATE NOT NULL,
  PRIMARY KEY (`idNoticia`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
