-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema prepperdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `prepperdb` ;

-- -----------------------------------------------------
-- Schema prepperdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `prepperdb` DEFAULT CHARACTER SET utf8 ;
USE `prepperdb` ;

-- -----------------------------------------------------
-- Table `prepper_inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prepper_inventory` ;

CREATE TABLE IF NOT EXISTS `prepper_inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS bunkerboss@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'bunkerboss'@'localhost' IDENTIFIED BY 'doomsday';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'bunkerboss'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
