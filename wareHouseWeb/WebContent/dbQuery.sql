CREATE SCHEMA `warehousedb` ;

CREATE TABLE `warehousedb`.`transactions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productGroup` LONGTEXT NULL,
  `productName` LONGTEXT NULL,
  `transaciton` LONGTEXT NULL,
  `date` VARCHAR(85) NULL,
  PRIMARY KEY (`id`));
  
  
  CREATE TABLE `warehousedb`.`liquid_tanks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `amount` INT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `warehousedb`.`silos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `amount` INT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `warehousedb`.`liquid_tanks` (`name`, `amount`) VALUES ('tank1', '11');

INSERT INTO `warehousedb`.`silos` (`name`, `amount`) VALUES ('silos1', '11');

INSERT INTO `warehousedb`.`transactions` (`productGroup`, `productName`, `transaciton`, `date`) VALUES ('silos', 'silos1', 'created', '16.02.2016');
