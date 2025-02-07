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
-- Table `vault-tec-employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vault-tec-employee` ;

CREATE TABLE IF NOT EXISTS `vault-tec-employee` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `overseer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `overseer` ;

CREATE TABLE IF NOT EXISTS `overseer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `age` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `vault_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vault`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vault` ;

CREATE TABLE IF NOT EXISTS `vault` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `overseer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vault_overseer_idx` (`overseer_id` ASC) VISIBLE,
  CONSTRAINT `fk_vault_overseer`
    FOREIGN KEY (`overseer_id`)
    REFERENCES `overseer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dweller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dweller` ;

CREATE TABLE IF NOT EXISTS `dweller` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `vault_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_dweller_vault1_idx` (`vault_id1` ASC) VISIBLE,
  CONSTRAINT `fk_dweller_vault1`
    FOREIGN KEY (`vault_id1`)
    REFERENCES `vault` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory_item` ;

CREATE TABLE IF NOT EXISTS `inventory_item` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL,
  `vault_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_inventory_item_vault1_idx` (`vault_id` ASC) VISIBLE,
  CONSTRAINT `fk_inventory_item_vault1`
    FOREIGN KEY (`vault_id`)
    REFERENCES `vault` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transactions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transactions` ;

CREATE TABLE IF NOT EXISTS `transactions` (
  `id` INT NOT NULL,
  `item_id` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `timestamp` VARCHAR(45) NOT NULL,
  `performer` VARCHAR(45) NOT NULL,
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
-- Data for table `vault-tec-employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `vault-tec-employee` (`id`, `name`, `email`, `password`, `role`) VALUES (1, 'James Anderson', 'j.anderson@vault-tec.gov', 'password123', 'ADMIN');
INSERT INTO `vault-tec-employee` (`id`, `name`, `email`, `password`, `role`) VALUES (2, 'Sarah Conner', 's.conner@vault-tec.gov', 'securepass', 'MANAGER');
INSERT INTO `vault-tec-employee` (`id`, `name`, `email`, `password`, `role`) VALUES (3, 'Ethan Hunt', 'e.hunt@vault-tec.gov', 'vaultAccess', 'MANAGER');
INSERT INTO `vault-tec-employee` (`id`, `name`, `email`, `password`, `role`) VALUES (4, 'Diana Parker', 'd.parker@vault-tec.gov', 'capSecure', 'ADMIN');
INSERT INTO `vault-tec-employee` (`id`, `name`, `email`, `password`, `role`) VALUES (5, 'Ellie Miller', 'e.miller@vault-tec.gov', 'crowbar', 'MANAGER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `overseer`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (1, 43, 'Dr. Richard Grey', 'r.grey@vaults.com', 'overseer123', '1');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (2, 61, 'Elizabeth Warren', 'e.warren@vaults.com', 'cats', '2');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (3, 22, 'Nathan Roberts', 'r.roberts@vaults.com', 'password456', '3');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (4, 29, 'Sarah Miles', 's.miles@vaults.com', 'safteyFirst', '4');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (5, 31, 'Tom Henderson', 't.henderson@vaults.com', 'dogs', '5');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (6, 28, 'Emile Rose', 'e.rose@vaults.com', 'gardenOfEden', '6');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (7, 86, 'Derek Hale', 'd.hale@vaults.com', 'haleBale', '7');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (8, 33, 'Sofia Carter', 's.carter@vaults.com', 'leadership', '8');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (9, 12, 'Ryan Davis', 'ryanrocks@vaults.com', 'irock123', '9');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (10, 57, 'Isabella Garcia', 'i.garcia@vaults.com', 'futureproof', '10');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (11, 210, 'Securitron Mk4', 'robcoadmin@vaults.com', 'protectall', '11');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (12, 41, 'Michael Adama', 'm.adams@vault.com', 'noentry', '12');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (13, 33, 'Rebecca Wilson', 'r.wilson@vaults.com', 'vaultheart', '13');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (14, 61, 'Joshua Bell', 'j.bell@vaults.com', 'lawandorder', '14');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (15, 30, 'Victoria Johnson', 'v.johnson@vaults.com', 'bunkers', '15');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (16, 29, 'Ethan Turner', 'e.turner@vaults.com', 'haven', '16');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (17, 37, 'Sophia Mitchell', 's.mitchell@vaults.com', 'stayinside', '17');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (18, 73, 'Oliver Scott', 'o.scott@vaults.com', 'powerforce', '18');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (19, 20, 'Jacob Hall', 'j.hall@vaults.com', 'citadelguard', '19');
INSERT INTO `overseer` (`id`, `age`, `name`, `email`, `password`, `vault_id`) VALUES (20, 55, 'Lucas Brown', 'l.brown@vaults.com', 'guardian', '20');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vault`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (1, 'Vault 101', 'Washington D.C', 'NORMAL', 1);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (2, 'Vault 111', 'Boston', 'ABANDONED', 2);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (3, 'Vault 76', 'West Virginia', 'NORMAL', 3);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (4, 'Vault 95', 'Massachusetts', 'RAIDED', 4);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (5, 'Vault 92', 'Virginia', 'NORMAL', 5);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (6, 'Vault 22', 'Nevada', 'ABANDONED', 6);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (7, 'Vault 108', 'Maryland', 'NORMAL', 7);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (8, 'Vault 87', 'Capital Wasteland', 'RAIDED', 8);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (9, 'Vault 12', 'California', 'ABANDONED', 9);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (10, 'Vault 81', 'Commonwealth', 'ABANDONED', 10);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (11, 'Vault 63', 'West Virginia', 'NORMAL', 11);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (12, 'Vault 34', 'Nevada', 'ABANDONED', 12);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (13, 'Vault 19', 'Mojave Wasteland', 'RAIDED', 13);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (14, 'Vault 3', 'Nevada', 'NORMAL', 14);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (15, 'Vault 56 ', 'Colorado', 'NORMAL', 15);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (16, 'Vault 17', 'Nevada', 'NORMAL', 16);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (17, 'Vault 53', 'New York', 'ABANDONED', 17);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (18, 'Vault 69', 'Texas', 'NORMAL', 18);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (19, 'Vault 77', 'Washington D.C', 'ABANDONED', 19);
INSERT INTO `vault` (`id`, `name`, `location`, `status`, `overseer_id`) VALUES (20, 'Vault 88', 'Commonwealth', 'NORMAL', 20);

COMMIT;


-- -----------------------------------------------------
-- Data for table `dweller`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (1, 'John', '28', 'Engineer', 1);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (2, 'Anna', '35', 'Guard', 1);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (3, 'Kevin', '22', 'Scientist', 1);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (4, 'Sarah', '31', 'Doctor', 1);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (5, 'Mike', '40', 'Guard', 3);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (6, 'Emily', '27', 'Teacher', 3);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (7, 'David', '13', 'Guard', 4);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (8, 'Chris', '24', 'Technician', 4);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (9, 'Laura', '28', 'Scientist', 5);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (10, 'Daniel', '46', 'Doctor', 5);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (11, 'Jessica', '34', 'Teacher', 7);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (12, 'Adam', '11', 'Student', 7);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (13, 'Ethan', '12', 'Student', 7);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (14, 'Lee', '33', 'Guard', 7);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (15, 'Wilson', '24', 'Engineer', 8);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (16, 'Jones', '26', 'Scientist', 8);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (17, 'Harris', '31', 'Guard', 8);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (18, 'Scott', '38', 'Electrician', 8);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (19, 'Jaymee', '44', 'Nurse', 11);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (20, 'Lucas', '36', 'Cook', 11);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (21, 'Lewis', '23', 'Scientist', 11);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (22, 'Moore', '45', 'Technician', 11);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (23, 'Martinez', '26', 'Guard', 13);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (24, 'Jackson', '32', 'Researcher', 13);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (25, 'Allen', '25', 'Researcher', 13);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (26, 'Thomas', '23', 'Guard', 15);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (27, 'Holmes', '54', 'Guard', 14);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (28, 'Tracy', '23', 'Doctor', 14);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (29, 'Bella', '19', 'Teacher', 16);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (30, 'Stockton', '67', 'Doctor', 18);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (31, 'Wesley', '32', 'Cook', 18);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (32, 'Braxton', '23', 'Guard', 18);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (33, 'Dominic', '32', 'Electrician', 4);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (34, 'Lucy', '20', 'Technican', 10);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (35, 'Roy', '44', 'Plumber', 20);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (36, 'Kody', '25', 'Scientist', 20);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (37, 'Polly', '33', 'Cook', 1);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (38, 'Norma', '76', 'Guard', 8);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (39, 'Alvin', '21', 'Doctor', 20);
INSERT INTO `dweller` (`id`, `name`, `age`, `role`, `vault_id1`) VALUES (40, 'Louise', '11', 'Mechanic', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory_item`
-- -----------------------------------------------------
START TRANSACTION;
USE `prepperdb`;
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (1, 'Purified Water', 'FOOD', 50, 1);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (2, 'Stimpaks', 'MEDICAL', 30, 1);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (3, 'RadAway', 'MEDICAL', 20, 3);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (4, 'Laser Rifle', 'WEAPON', 3, 3);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (5, 'Fusion Cores', 'MISC', 15, 4);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (6, 'Cram Cans', 'FOOD', 10, 5);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (7, 'Med-X', 'MEDICAL', 12, 5);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (8, '10mm Ammo', 'MISC', 200, 8);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (9, 'Plasma Grenade', 'WEAPON', 10, 11);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (10, 'Buffout', 'MEDICAL', 13, 13);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (11, 'T-45 Power Armor', 'MISC', 1, 16);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (12, 'Microfusoin Cell', 'MISC', 35, 3);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (13, 'Ration Packs', 'FOOD', 19, 3);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (14, 'Feral Ghoul Repellent ', 'MISC', 20, 7);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (15, 'Nuka-Cola Quantum', 'FOOD', 50, 16);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (16, 'Sweet Rolls', 'FOOD', 2, 13);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (17, 'Hunting Rifle', 'WEAPON', 3, 5);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (18, 'Pipe Pistol', 'WEAPON', 5, 5);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (19, 'Abraxo Cleaner', 'MISC', 13, 1);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (20, 'Stimpaks', 'MEDICAL', 11, 20);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (21, 'Canned Dog Food', 'FOOD ', 5, 8);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (22, 'Ration Pacls', 'FOOD', 10, 20);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (23, 'Stealth-Boy', 'MISC', 1, 5);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (24, 'Mutifruit', 'FOOD', 80, 7);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (25, 'Fusion Cores', 'MISC ', 12, 7);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (26, 'Nuka Cola', 'FOOD', 2, 13);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (27, 'Plasma Cartridge', 'MISC', 40, 11);
INSERT INTO `inventory_item` (`id`, `name`, `category`, `quantity`, `vault_id`) VALUES (28, 'Mirelurk Meat', 'FOOD', 3, 8);

COMMIT;

