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
-- Table `prepper_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prepper_category` ;

CREATE TABLE IF NOT EXISTS `prepper_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supplier` ;

CREATE TABLE IF NOT EXISTS `supplier` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `contact_email` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
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
-- Table `inventory_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_log` ;

CREATE TABLE IF NOT EXISTS `inventory_log` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `inventory_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `timestamp` DATETIME NULL,
  `notes` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prepper_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `prepper_order` ;

CREATE TABLE IF NOT EXISTS `prepper_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `supplier_id` INT NOT NULL,
  `inventory_id` INT NOT NULL,
  `order_date` DATETIME NULL,
  `quantity` INT NULL,
  `status` VARCHAR(45) NULL,
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

-- -----------------------------------------------------
-- Data for table `prepper_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (1, 'Food', 'Edible items necessary for sustenance');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (2, 'Water', 'Drinking water and other liquid supplies');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (3, 'Medication', 'Essential drugs and first aid supplies');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (4, 'Tools', 'Survival tools such as knives, hammers, and flashlights');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (5, 'Clothing', 'Warm clothing and protective wear');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (6, 'Fuel', 'Gasoline, propane, and other fuel souurces');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (7, 'Communications', 'Radios, and guides for communicaion devices');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (8, 'Hygeine', 'Sanitation supplies such as soap, toothpaste, and towels.');
INSERT INTO `prepper_category` (`id`, `name`, `description`) VALUES (9, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `supplier`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `supplier` (`id`, `name`, `contact_email`, `phone_number`, `address`) VALUES (1, 'Emergency Supplies Co.', 'contact@emergencysupplies.com', '954-5512', '512 Survival Rd, Prep City');
INSERT INTO `supplier` (`id`, `name`, `contact_email`, `phone_number`, `address`) VALUES (2, 'Safeguard Gear', 'info@safeguardgear.com', '555-1298', '461 Saftey Blvd, Shelterville');
INSERT INTO `supplier` (`id`, `name`, `contact_email`, `phone_number`, `address`) VALUES (3, 'Hydro Experts', 'sales@hydroexperts.com', '206-6451', '3460 Aqua St, Water Town');
INSERT INTO `supplier` (`id`, `name`, `contact_email`, `phone_number`, `address`) VALUES (4, 'Premiere Medical', 'support@premieremedical.com', '415-1856', '1719 Health Ave, Medic City');
INSERT INTO `supplier` (`id`, `name`, `contact_email`, `phone_number`, `address`) VALUES (5, ' Power Solutions Inc.', 'orders@powersolutions.com', '555-4698', '999 Generator Ln, Energetopia');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (1, 'robojoe11', 'PassWord123!', 'robotjoe@gmail.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (2, 'TheBushman', 'sticks&st0nes', 'neil.tyyse@Yahoo.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (3, 'BunkerBoss', 'Surviv0r1', 'heathersaxon2@msn.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (4, 'critical0fficial', 'safelock_0.1!', 'greg.ross@aol.com');
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (5, 'SaraRisherDaFisher', 'piper020103', 'doglover99@mediarage.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory_log`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `inventory_log` (`id`, `inventory_id`, `user_id`, `timestamp`, `notes`) VALUES (1, 1, 2, '2025-01-25 10:30:00', 'Added 20 units of canned beans to inventory');
INSERT INTO `inventory_log` (`id`, `inventory_id`, `user_id`, `timestamp`, `notes`) VALUES (2, 2, 1, '2025-01-22 14:45:00', 'Updated quantity of bottled water to 50 units');
INSERT INTO `inventory_log` (`id`, `inventory_id`, `user_id`, `timestamp`, `notes`) VALUES (3, 3, 3, '2025-01-24 09:00:00', 'Removed expired first-aid supplpies from inventory');
INSERT INTO `inventory_log` (`id`, `inventory_id`, `user_id`, `timestamp`, `notes`) VALUES (4, 4, 2, '2025-01-26 16:15:00', 'Restocked 10 units of flashlight batteries');
INSERT INTO `inventory_log` (`id`, `inventory_id`, `user_id`, `timestamp`, `notes`) VALUES (5, 5, 5, '2025-01-26 12:00:00', 'Moved fuel canisters to secondary storage location');
INSERT INTO `inventory_log` (`id`, `inventory_id`, `user_id`, `timestamp`, `notes`) VALUES (6, 6, 4, '2025-01-27 08:30:00', 'Added new shipment of thermal blankets');

COMMIT;


-- -----------------------------------------------------
-- Data for table `prepper_order`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `prepper_order` (`id`, `supplier_id`, `inventory_id`, `order_date`, `quantity`, `status`) VALUES (1, 1, 1, '2025-01-20 10:30:00', 100, 'Pending');
INSERT INTO `prepper_order` (`id`, `supplier_id`, `inventory_id`, `order_date`, `quantity`, `status`) VALUES (2, 2, 2, '2025-01-21 14:00:00', 50, 'Shipped');
INSERT INTO `prepper_order` (`id`, `supplier_id`, `inventory_id`, `order_date`, `quantity`, `status`) VALUES (3, 5, 3, '2025-01-22 09:15:00', 30, 'Delivered');
INSERT INTO `prepper_order` (`id`, `supplier_id`, `inventory_id`, `order_date`, `quantity`, `status`) VALUES (4, 3, 4, '2025-01-23 12:45:00', 20, 'Cancelled');
INSERT INTO `prepper_order` (`id`, `supplier_id`, `inventory_id`, `order_date`, `quantity`, `status`) VALUES (5, 4, 5, '2025-01-24 16:30:00', 200, 'Pending');

COMMIT;

