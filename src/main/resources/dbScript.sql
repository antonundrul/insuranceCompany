-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema insurancecompany
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema insurancecompany
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `insurancecompany` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `insurancecompany` ;

-- -----------------------------------------------------
-- Table `insurancecompany`.`cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurancecompany`.`cars` (
  `car_id` INT NOT NULL AUTO_INCREMENT,
  `car_brand` VARCHAR(45) NOT NULL,
  `car_model` VARCHAR(45) NOT NULL,
  `year` INT NOT NULL,
  `vin_code` VARCHAR(45) NOT NULL,
  `car_number` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`car_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `insurancecompany`.`companies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurancecompany`.`companies` (
  `company_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`company_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `insurancecompany`.`currencies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurancecompany`.`currencies` (
  `currency_id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(3) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`currency_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `insurancecompany`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurancecompany`.`persons` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NOT NULL,
  `passport_series` VARCHAR(2) NOT NULL,
  `passport_number` VARCHAR(7) NOT NULL,
  `date_of_birth` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`person_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `insurancecompany`.`policy_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurancecompany`.`policy_types` (
  `policy_type_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`policy_type_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `insurancecompany`.`policies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `insurancecompany`.`policies` (
  `policy_id` INT NOT NULL AUTO_INCREMENT,
  `person_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `currency_id` INT NOT NULL,
  `insurance_sum` INT NOT NULL,
  `date_of_issue` DATE NULL DEFAULT NULL,
  `validity_period` DATE NULL DEFAULT NULL,
  `car_id` INT NOT NULL,
  `policy_type_id` INT NOT NULL,
  PRIMARY KEY (`policy_id`),
  INDEX `FK_POLICIES_PERSONS_idx` (`person_id` ASC) VISIBLE,
  INDEX `FK_POLICIES_COMPANIES_idx` (`company_id` ASC) VISIBLE,
  INDEX `FK_POLICIES_CURRENCIES_idx` (`currency_id` ASC) VISIBLE,
  INDEX `FK_POLICIES_CARS_idx` (`car_id` ASC) VISIBLE,
  INDEX `FK_POLICIES_POLICY_TYPES_idx` (`policy_type_id` ASC) VISIBLE,
  CONSTRAINT `FK_POLICIES_CARS`
    FOREIGN KEY (`car_id`)
    REFERENCES `insurancecompany`.`cars` (`car_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_POLICIES_COMPANIES`
    FOREIGN KEY (`company_id`)
    REFERENCES `insurancecompany`.`companies` (`company_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_POLICIES_CURRENCIES`
    FOREIGN KEY (`currency_id`)
    REFERENCES `insurancecompany`.`currencies` (`currency_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_POLICIES_PERSONS`
    FOREIGN KEY (`person_id`)
    REFERENCES `insurancecompany`.`persons` (`person_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_POLICIES_POLICY_TYPES`
    FOREIGN KEY (`policy_type_id`)
    REFERENCES `insurancecompany`.`policy_types` (`policy_type_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
