-- MySQL Script generated by MySQL Workbench
-- Tue Sep 12 21:57:45 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema integrador_2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema integrador_2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `integrador_2` DEFAULT CHARACTER SET utf8 ;
USE `integrador_2` ;

-- -----------------------------------------------------
-- Table `integrador_2`.`Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `integrador_2`.`Alumno` (
  `idAlumno` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(250) NOT NULL,
  `apellido` VARCHAR(250) NOT NULL,
  `edad` INT NOT NULL,
  `genero` CHAR NOT NULL,
  `dni` INT NOT NULL,
  `residencia` VARCHAR(500) NOT NULL,
  `num_libreta_un` INT NOT NULL,
  PRIMARY KEY (`idAlumno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `integrador_2`.`Carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `integrador_2`.`Carrera` (
  `idCarrera` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idCarrera`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `integrador_2`.`Carrera_inscripta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `integrador_2`.`Carrera_inscripta` (
  `antiguedad` INT NOT NULL,
  `graduado` TINYINT NOT NULL,
  `Alumno_idAlumno` INT NOT NULL,
  `Carrera_idCarrera` INT NOT NULL,
  INDEX `fk_Carrera_inscripta_Alumno_idx` (`Alumno_idAlumno` ASC),
  INDEX `fk_Carrera_inscripta_Carrera1_idx` (`Carrera_idCarrera` ASC),
  CONSTRAINT `fk_Carrera_inscripta_Alumno`
    FOREIGN KEY (`Alumno_idAlumno`)
    REFERENCES `integrador_2`.`Alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carrera_inscripta_Carrera1`
    FOREIGN KEY (`Carrera_idCarrera`)
    REFERENCES `integrador_2`.`Carrera` (`idCarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
