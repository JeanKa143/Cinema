-- MySQL Script generated by MySQL Workbench
-- Wed Jun  9 17:12:02 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_cinema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd_cinema` ;

-- -----------------------------------------------------
-- Schema bd_cinema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_cinema` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci ;
USE `bd_cinema` ;

-- -----------------------------------------------------
-- Table `bd_cinema`.`cinema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`cinema` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`cinema` (
  `id_cinema` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cinema`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`sala`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`sala` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`sala` (
  `cinema_id` INT NOT NULL,
  `numero` INT NOT NULL,
  `capacidad` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`cinema_id`, `numero`),
  CONSTRAINT `fk_sala_cinema`
    FOREIGN KEY (`cinema_id`)
    REFERENCES `bd_cinema`.`cinema` (`id_cinema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`pelicula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`pelicula` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`pelicula` (
  `id_pelicula` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `poster_path` VARCHAR(100) NOT NULL,
  `movie_data` LONGTEXT NOT NULL,
  PRIMARY KEY (`id_pelicula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`funcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`funcion` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`funcion` (
  `id_funcion` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `sala_cinema_id` INT NOT NULL,
  `sala_numero` INT NOT NULL,
  `pelicula_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_funcion`, `fecha`, `sala_cinema_id`, `sala_numero`),
  INDEX `fk_funcion_pelicula_idx` (`pelicula_id` ASC) VISIBLE,
  CONSTRAINT `fk_funcion_sala`
    FOREIGN KEY (`sala_cinema_id` , `sala_numero`)
    REFERENCES `bd_cinema`.`sala` (`cinema_id` , `numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcion_pelicula`
    FOREIGN KEY (`pelicula_id`)
    REFERENCES `bd_cinema`.`pelicula` (`id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`asiento_funcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`asiento_funcion` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`asiento_funcion` (
  `fila` CHAR(1) NOT NULL,
  `posicion` INT(2) NOT NULL,
  `funcion_id` INT NOT NULL,
  `funcion_fecha` DATETIME NOT NULL,
  `funcion_sala_cinema_id` INT NOT NULL,
  `funcion_sala_numero` INT NOT NULL,
  `ocupado` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`fila`, `posicion`, `funcion_id`, `funcion_fecha`, `funcion_sala_cinema_id`, `funcion_sala_numero`),
  INDEX `fk_asiento_funcion_funcion1_idx` (`funcion_id` ASC, `funcion_fecha` ASC, `funcion_sala_cinema_id` ASC, `funcion_sala_numero` ASC) VISIBLE,
  CONSTRAINT `fk_asiento_funcion_funcion1`
    FOREIGN KEY (`funcion_id` , `funcion_fecha` , `funcion_sala_cinema_id` , `funcion_sala_numero`)
    REFERENCES `bd_cinema`.`funcion` (`id_funcion` , `fecha` , `sala_cinema_id` , `sala_numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`usuario` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`usuario` (
  `id_usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `rol` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`cliente` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`cliente` (
  `usuario_id_usuario` VARCHAR(45) NOT NULL,
  `id_cliente` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `tarjeta_pago` VARCHAR(45) NULL,
  PRIMARY KEY (`usuario_id_usuario`, `id_cliente`),
  INDEX `fk_cliente_usuario1_idx` (`usuario_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`usuario_id_usuario`)
    REFERENCES `bd_cinema`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`factura` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`factura` (
  `seq_factura` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `cliente_id` VARCHAR(45) NOT NULL,
  `tarjeta_pago` VARCHAR(45) NULL,
  PRIMARY KEY (`seq_factura`),
  INDEX `fk_factura_cliente_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_factura_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `bd_cinema`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_cinema`.`tiquete`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_cinema`.`tiquete` ;

CREATE TABLE IF NOT EXISTS `bd_cinema`.`tiquete` (
  `id_tiquete` INT NOT NULL AUTO_INCREMENT,
  `factura_seq` INT NOT NULL,
  `monto` DOUBLE NOT NULL,
  PRIMARY KEY (`id_tiquete`),
  INDEX `fk_tiquete_factura_idx` (`factura_seq` ASC) VISIBLE,
  CONSTRAINT `fk_tiquete_factura`
    FOREIGN KEY (`factura_seq`)
    REFERENCES `bd_cinema`.`factura` (`seq_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;