-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Shcherba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Shcherba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Shcherba` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema iot-test-db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema iot-test-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `iot-test-db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Shcherba` ;

-- -----------------------------------------------------
-- Table `Shcherba`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shcherba`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NULL,
  `street` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `coordinate` VARCHAR(45) NOT NULL,
  `zip_code` VARCHAR(5) NULL,
  `number_available_cars` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `coordinate_UNIQUE` (`coordinate` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shcherba`.`security`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shcherba`.`security` (
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shcherba`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shcherba`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `identity_document` VARCHAR(45) NOT NULL,
  `driver_license` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  `payment_card` VARCHAR(45) NULL,
  `security_login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `identity_document_UNIQUE` (`identity_document` ASC) VISIBLE,
  UNIQUE INDEX `driver_license_UNIQUE` (`driver_license` ASC) VISIBLE,
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  INDEX `fk_user_security_idx` (`security_login` ASC) VISIBLE,
  CONSTRAINT `fk_user_security`
    FOREIGN KEY (`security_login`)
    REFERENCES `Shcherba`.`security` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shcherba`.`car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shcherba`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `car_body_style` VARCHAR(45) NOT NULL,
  `price_for_day` FLOAT NOT NULL,
  `seats` INT NULL,
  `doors` INT NULL,
  `gearbox type` VARCHAR(30) NULL,
  `accessible` TINYINT NOT NULL,
  `date_take` DATE NULL,
  `to_pay` FLOAT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_car_location1_idx` (`location_id` ASC) VISIBLE,
  CONSTRAINT `fk_car_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `Shcherba`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shcherba`.`fine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shcherba`.`fine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_of_fine` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fine_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_fine_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Shcherba`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Shcherba`.`location_has_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Shcherba`.`location_has_user` (
  `location_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`location_id`, `user_id`),
  INDEX `fk_location_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_location_has_user_location1_idx` (`location_id` ASC) VISIBLE,
  CONSTRAINT `fk_location_has_user_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `Shcherba`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Shcherba`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `iot-test-db` ;

-- -----------------------------------------------------
-- Table `iot-test-db`.`drink`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot-test-db`.`drink` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `price` FLOAT NULL DEFAULT NULL,
  `volume_in_ml` INT NULL DEFAULT NULL,
  `country` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `iot-test-db`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot-test-db`.`hibernate_sequence` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `iot-test-db`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot-test-db`.`items` (
  `name` VARCHAR(20) NULL DEFAULT NULL,
  `price` INT NULL DEFAULT NULL,
  `producer` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(20) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `iot-test-db`.`makeup_brushes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot-test-db`.`makeup_brushes` (
  `id` INT NOT NULL,
  `length_mm` INT NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NOT NULL,
  `producer` VARCHAR(255) NULL DEFAULT NULL,
  `professional` BIT(1) NOT NULL,
  `rigidity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `iot-test-db`.`technique`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iot-test-db`.`technique` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL,
  `model` VARCHAR(20) NOT NULL,
  `manufactory_company` ENUM('Panasonic', 'Bosh', 'Philips', 'Samsung') NULL DEFAULT NULL,
  `year_of_manufacture` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `input_voltage` FLOAT NOT NULL,
  `watts` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
