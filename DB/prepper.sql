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
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory` ;

CREATE TABLE IF NOT EXISTS `inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  INDEX `fk_inventory_user1_idx` (`user_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_inventory_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_log` ;

CREATE TABLE IF NOT EXISTS `inventory_log` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `inventoryId` INT NULL,
  `userId` INT NULL,
  `timestamp` DATETIME NULL,
  `notes` VARCHAR(255) NULL,
  `inventory_id` INT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_inventory_log_inventory1_idx` (`inventory_id` ASC) VISIBLE,
  INDEX `fk_inventory_log_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_inventory_log_inventory1`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `inventory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventory_log_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_item` ;

CREATE TABLE IF NOT EXISTS `inventory_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `inventory_id` INT NULL,
  `name` VARCHAR(45) NULL,
  `quantity` INT NULL,
  `unit` VARCHAR(45) NULL,
  `expiration` DATETIME NULL,
  `addded_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_inventory_item_inventory1_idx` (`inventory_id` ASC) VISIBLE,
  CONSTRAINT `fk_inventory_item_inventory1`
    FOREIGN KEY (`inventory_id`)
    REFERENCES `inventory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `item_has_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_has_category` ;

CREATE TABLE IF NOT EXISTS `item_has_category` (
  `category_id` INT NOT NULL,
  `inventory_item_id` INT NOT NULL,
  PRIMARY KEY (`category_id`, `inventory_item_id`),
  INDEX `fk_item_has_category_inventory_item1_idx` (`inventory_item_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_has_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_category_inventory_item1`
    FOREIGN KEY (`inventory_item_id`)
    REFERENCES `inventory_item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS bunkerboss@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'bunkerboss'@'localhost' IDENTIFIED BY 'doomsday';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'bunkerboss'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `category` (`id`, `name`, `description`) VALUES (1, 'Food', 'Edible items necessary for sustenance');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (2, 'Water', 'Drinking water and other liquid supplies');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (3, 'Medication', 'Essential drugs and first aid supplies');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (4, 'Tools', 'Survival tools such as knives, hammers, and flashlights');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (5, 'Clothing', 'Warm clothing and protective wear');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (6, 'Fuel', 'Gasoline, propane, and other fuel souurces');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (7, 'Communications', 'Radios, and guides for communicaion devices');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (8, 'Hygeine', 'Sanitation supplies such as soap, toothpaste, and towels.');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (9, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (1, 'Colin Moriarty', 'moneyman11', 'luckoftheirish7@gmail.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (2, 'Andy Stahl', 'barterboy0102', 'bargainboy@Yahoo.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (3, 'Lucy West', 'foodsbyforce', 'bellyofplates@msn.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (4, 'Three Dog', 'radiobaby3', 'capitalking@aol.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (5, 'Private Sierra', 'lockednloaded!', 'gungirl99@yahoo.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `inventory` (`id`, `user_id`, `name`, `description`, `created_at`, `updated_at`) VALUES (1, 1, 'Home Essentials', 'Primary inventory for home supplies and tools', '2025-01-01 10:00:00', '2025-01-01 10:00:00');
INSERT INTO `inventory` (`id`, `user_id`, `name`, `description`, `created_at`, `updated_at`) VALUES (2, 2, 'Trading Goods', 'Items for trading post and bartering', '2025-01-02 11:00:00', '2025-01-02 11:00:00');
INSERT INTO `inventory` (`id`, `user_id`, `name`, `description`, `created_at`, `updated_at`) VALUES (3, 3, 'Food Supplies', 'Kitchen gear and food supplies for the winter', '2025-01-03 12:00:00', '2025-01-04 08:15:00');
INSERT INTO `inventory` (`id`, `user_id`, `name`, `description`, `created_at`, `updated_at`) VALUES (4, 4, 'Medical Gear', 'Medical supplies, first aid, medicine', '2025-01-04 06:30:00', '2025-01-05 07:00:00');
INSERT INTO `inventory` (`id`, `user_id`, `name`, `description`, `created_at`, `updated_at`) VALUES (5, 5, 'Security', 'Items for defense, support, security', '2025-01-01 09:24:00', '2025-01-05 16:25:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory_log`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `inventory_log` (`id`, `inventoryId`, `userId`, `timestamp`, `notes`, `inventory_id`, `user_id`) VALUES (1, 1, 2, '2025-01-25 10:30:00', 'Added 20 units of canned beans to inventory', NULL, NULL);
INSERT INTO `inventory_log` (`id`, `inventoryId`, `userId`, `timestamp`, `notes`, `inventory_id`, `user_id`) VALUES (2, 2, 1, '2025-01-22 14:45:00', 'Updated quantity of bottled water to 50 units', NULL, NULL);
INSERT INTO `inventory_log` (`id`, `inventoryId`, `userId`, `timestamp`, `notes`, `inventory_id`, `user_id`) VALUES (3, 3, 3, '2025-01-24 09:00:00', 'Removed expired first-aid supplpies from inventory', NULL, NULL);
INSERT INTO `inventory_log` (`id`, `inventoryId`, `userId`, `timestamp`, `notes`, `inventory_id`, `user_id`) VALUES (4, 4, 2, '2025-01-26 16:15:00', 'Restocked 10 units of flashlight batteries', NULL, NULL);
INSERT INTO `inventory_log` (`id`, `inventoryId`, `userId`, `timestamp`, `notes`, `inventory_id`, `user_id`) VALUES (5, 5, 5, '2025-01-26 12:00:00', 'Moved fuel canisters to secondary storage location', NULL, NULL);
INSERT INTO `inventory_log` (`id`, `inventoryId`, `userId`, `timestamp`, `notes`, `inventory_id`, `user_id`) VALUES (6, 6, 4, '2025-01-27 08:30:00', 'Added new shipment of thermal blankets', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `inventory_item` (`id`, `inventory_id`, `name`, `quantity`, `unit`, `expiration`, `addded_at`) VALUES (1, 1, 'Canned Beans', 20, 'cans', '2026-01-01', '2025-01-01 10:10:00');
INSERT INTO `inventory_item` (`id`, `inventory_id`, `name`, `quantity`, `unit`, `expiration`, `addded_at`) VALUES (2, 1, 'Bottled Water', 50, 'liters', '2025-12-31', '2025-01-01 10:15:00');
INSERT INTO `inventory_item` (`id`, `inventory_id`, `name`, `quantity`, `unit`, `expiration`, `addded_at`) VALUES (3, 4, 'Alcohol Pads', 100, 'pieces', '2025-01-02', '2025-01-02 11:10:00');
INSERT INTO `inventory_item` (`id`, `inventory_id`, `name`, `quantity`, `unit`, `expiration`, `addded_at`) VALUES (4, 2, 'Batteries', 40, 'pieces', '2025-01-03 ', '2025-01-03 12:30:00');
INSERT INTO `inventory_item` (`id`, `inventory_id`, `name`, `quantity`, `unit`, `expiration`, `addded_at`) VALUES (5, NULL, 'Ammo Boxes', 20, 'boxes', '2027-01-01', '2025-01-03 12:40:00');

COMMIT;

