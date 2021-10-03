-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema patientsData
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `patientsData` ;

-- -----------------------------------------------------
-- Schema patientsData
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `patientsData` DEFAULT CHARACTER SET utf8 ;
USE `patientsData` ;

-- -----------------------------------------------------
-- Table `patientsData`.`hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`hospital` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`hospital` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`medical_card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`medical_card` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`medical_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birth_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`doctor_personal_file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`doctor_personal_file` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`doctor_personal_file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `hospital_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doctor_personal_file_hospital1_idx` (`hospital_id` ASC) VISIBLE,
  CONSTRAINT `fk_doctor_personal_file_hospital1`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `patientsData`.`hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`patient` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`patient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `medical_card_id` INT NOT NULL,
  `hospital_id` INT NOT NULL,
  `doctor_personal_file_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_patient_medical_card1_idx` (`medical_card_id` ASC) VISIBLE,
  INDEX `fk_patient_hospital1_idx` (`hospital_id` ASC) VISIBLE,
  INDEX `fk_patient_doctor_personal_file1_idx` (`doctor_personal_file_id` ASC) VISIBLE,
  CONSTRAINT `fk_patient_medical_card1`
    FOREIGN KEY (`medical_card_id`)
    REFERENCES `patientsData`.`medical_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_hospital1`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `patientsData`.`hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_doctor_personal_file1`
    FOREIGN KEY (`doctor_personal_file_id`)
    REFERENCES `patientsData`.`doctor_personal_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`doctor_appointment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`doctor_appointment` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`doctor_appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `recomendation` VARCHAR(45) NULL,
  `doctor_personal_file_id` INT NOT NULL,
  `medical_card_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doctor_appointment_doctor_personal_file1_idx` (`doctor_personal_file_id` ASC) VISIBLE,
  INDEX `fk_doctor_appointment_medical_card1_idx` (`medical_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_doctor_appointment_doctor_personal_file1`
    FOREIGN KEY (`doctor_personal_file_id`)
    REFERENCES `patientsData`.`doctor_personal_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doctor_appointment_medical_card1`
    FOREIGN KEY (`medical_card_id`)
    REFERENCES `patientsData`.`medical_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`tracker_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`tracker_data` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`tracker_data` (
  `id` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `systolic_blood_pressure` TINYINT(250) NULL,
  `diastolic_blood_pressure` TINYINT(160) NULL,
  `heart_rate` TINYINT(250) NULL,
  `temperature` DECIMAL(3,1) NULL,
  `medical_card_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tracker_data_medical_card1_idx` (`medical_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_tracker_data_medical_card1`
    FOREIGN KEY (`medical_card_id`)
    REFERENCES `patientsData`.`medical_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`country` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`manufacturer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`manufacturer` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`manufacturer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_manufacturer_country1_idx` (`country_id` ASC) VISIBLE,
  CONSTRAINT `fk_manufacturer_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `patientsData`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`drug`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`drug` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`drug` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NULL,
  `manufacturer_id` INT NOT NULL,
  PRIMARY KEY (`id`, `manufacturer_id`),
  INDEX `fk_drug_manufacturer1_idx` (`manufacturer_id` ASC) VISIBLE,
  CONSTRAINT `fk_drug_manufacturer1`
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `patientsData`.`manufacturer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `patientsData`.`doctor_appointment_has_drug`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `patientsData`.`doctor_appointment_has_drug` ;

CREATE TABLE IF NOT EXISTS `patientsData`.`doctor_appointment_has_drug` (
  `doctor_appointment_id` INT NOT NULL,
  `drug_id` INT NOT NULL,
  PRIMARY KEY (`doctor_appointment_id`, `drug_id`),
  INDEX `fk_doctor_appointment_has_drug_drug1_idx` (`drug_id` ASC) VISIBLE,
  INDEX `fk_doctor_appointment_has_drug_doctor_appointment1_idx` (`doctor_appointment_id` ASC) VISIBLE,
  CONSTRAINT `fk_doctor_appointment_has_drug_doctor_appointment1`
    FOREIGN KEY (`doctor_appointment_id`)
    REFERENCES `patientsData`.`doctor_appointment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doctor_appointment_has_drug_drug1`
    FOREIGN KEY (`drug_id`)
    REFERENCES `patientsData`.`drug` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
