-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema research
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema research
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `research` DEFAULT CHARACTER SET utf8 ;
USE `research` ;

-- -----------------------------------------------------
-- Table `research`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `research`.`user` (
  `iduser` VARCHAR(45) NOT NULL,
  `sex` VARCHAR(45) NULL,
  `age` INT NULL,
  `diagnosis` VARCHAR(45) NULL,
  `user_date` DATETIME NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `research`.`record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `research`.`record` (
  `id` VARCHAR(45) NOT NULL,
  `problem` TINYINT(1) NOT NULL,
  `ill` TINYINT(1) NULL,
  `user_record` VARCHAR(45) NULL,
  `palpitations` INT NULL,
  `weight_gain` INT NULL,
  `high_blood_pressure` INT NULL,
  `muscle_weakness` INT NULL,
  `sweating` INT NULL,
  `flushing` INT NULL,
  `headache` INT NULL,
  `chest_pain` INT NULL,
  `back_pain` INT NULL,
  `bruising` INT NULL,
  `fatigue` INT NULL,
  `panic` INT NULL,
  `sadness` INT NULL,
  `body_hair_growth` INT NULL,
  `record_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_record_user_idx` (`user_record` ASC),
  CONSTRAINT `fk_record_user`
    FOREIGN KEY (`user_record`)
    REFERENCES `research`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
