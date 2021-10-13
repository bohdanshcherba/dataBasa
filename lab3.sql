CREATE SCHEMA IF NOT EXISTS `lab3`;
USE `lab3`;

DROP TABLE IF EXISTS `location_has_user`;
DROP TABLE IF EXISTS `fine`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `security`;
DROP TABLE IF EXISTS `car`;
DROP TABLE IF EXISTS `location`;

CREATE TABLE IF NOT EXISTS `location` (
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
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `security` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`),
  KEY(`id`)
  );



CREATE TABLE IF NOT EXISTS `user` (
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
    REFERENCES `security` (`login`));



CREATE TABLE IF NOT EXISTS `fine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_of_fine` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fine_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_fine_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`));


CREATE TABLE IF NOT EXISTS `location_has_user` (
  `location_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`location_id`, `user_id`),
  
  INDEX `fk_location_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_location_has_user_location1_idx` (`location_id` ASC) VISIBLE,
  
  CONSTRAINT `fk_location_has_user_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`),
    
  CONSTRAINT `fk_location_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES`user` (`id`));


CREATE TABLE IF NOT EXISTS `car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `car_body_style` VARCHAR(45) NOT NULL,
  `price_for_day` FLOAT NOT NULL,
  `seats` INT NULL,
  `doors` INT NULL,
  `gearbox_type` VARCHAR(30) NULL,
  `accessible` TINYINT NOT NULL,
  `date_take` DATE NULL,
  `to_pay` FLOAT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_car_location1_idx` (`location_id` ASC) ,
  CONSTRAINT `fk_car_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`));