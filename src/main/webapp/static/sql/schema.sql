SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ISC
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ISC
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ISC` DEFAULT CHARACTER SET utf8 ;
USE `ISC` ;

-- -----------------------------------------------------
-- Table `ISC`.`product_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`product_type` (
  `id_product_type` INT NOT NULL AUTO_INCREMENT,
  `product_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_product_type`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NOT NULL,
  `product_cost` DOUBLE NOT NULL,
  `product_amount` VARCHAR(45) NOT NULL,
  `product_date_storage` DATE NOT NULL,
  `id_product_type` INT NOT NULL,
  PRIMARY KEY (`id_product`, `id_product_type`),
  INDEX `fk_products_product_type_idx` (`id_product_type` ASC),
  CONSTRAINT `fk_products_product_type`
  FOREIGN KEY (`id_product_type`)
  REFERENCES `ISC`.`product_type` (`id_product_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `name_firm` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email_user` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  `address_user` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id_user`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`user_phones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`user_phones` (
  `id_phone` INT NOT NULL AUTO_INCREMENT,
  `phone_number` VARCHAR(45) NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_phone`, `id_user`),
  INDEX `fk_clients_phones_clients1_idx` (`id_user` ASC),
  CONSTRAINT `fk_clients_phones_clients1`
  FOREIGN KEY (`id_user`)
  REFERENCES `ISC`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`place_delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`place_delivery` (
  `id_place_delivery` INT NOT NULL AUTO_INCREMENT,
  `address_delivery` VARCHAR(45) NOT NULL,
  `place_latitude` FLOAT NOT NULL,
  `place_longitude` FLOAT NOT NULL,
  PRIMARY KEY (`id_place_delivery`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`place_store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`place_store` (
  `id_place_store` INT NOT NULL AUTO_INCREMENT,
  `address_store` VARCHAR(45) NOT NULL,
  `place_latitude` FLOAT NOT NULL,
  `place_longitude` FLOAT NOT NULL,
  PRIMARY KEY (`id_place_store`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`order_status` (
  `id_order_status` INT NOT NULL AUTO_INCREMENT,
  `order_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_order_status`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`transport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`transport` (
  `id_transport` INT NOT NULL AUTO_INCREMENT,
  `name_transport` VARCHAR(45) NOT NULL,
  `min_tonnage` DOUBLE NULL,
  `max_tonnage` DOUBLE NULL,
  PRIMARY KEY (`id_transport`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`order` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `date_delivery` DATE NOT NULL,
  `time_delivery` VARCHAR(45) NOT NULL,
  `date_order` DATE NOT NULL,
  `price_order` DOUBLE NOT NULL,
  `id_user` INT NOT NULL,
  `id_order_status` INT NOT NULL,
  `transport_id_transport` INT NOT NULL,
  PRIMARY KEY (`id_order`, `id_user`, `id_order_status`, `transport_id_transport`),
  INDEX `fk_orders_clients1_idx` (`id_user` ASC),
  INDEX `fk_orders_order_status1_idx` (`id_order_status` ASC),
  INDEX `fk_order_transport1_idx` (`transport_id_transport` ASC),
  CONSTRAINT `fk_orders_clients1`
  FOREIGN KEY (`id_user`)
  REFERENCES `ISC`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_order_status1`
  FOREIGN KEY (`id_order_status`)
  REFERENCES `ISC`.`order_status` (`id_order_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_transport1`
  FOREIGN KEY (`transport_id_transport`)
  REFERENCES `ISC`.`transport` (`id_transport`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`product_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`product_order` (
  `id_product_order` INT NOT NULL AUTO_INCREMENT,
  `amount_product` VARCHAR(45) NOT NULL,
  `price_amount` VARCHAR(45) NOT NULL,
  `id_order` INT NOT NULL,
  `id_user` INT NOT NULL,
  `id_order_status` INT NOT NULL,
  `id_product` INT NOT NULL,
  `id_product_type` INT NOT NULL,
  PRIMARY KEY (`id_product_order`, `id_order`, `id_user`, `id_order_status`, `id_product`, `id_product_type`),
  INDEX `fk_product_order_order1_idx` (`id_order` ASC, `id_user` ASC, `id_order_status` ASC),
  INDEX `fk_product_order_product1_idx` (`id_product` ASC, `id_product_type` ASC),
  CONSTRAINT `fk_product_order_order1`
  FOREIGN KEY (`id_order` , `id_user` , `id_order_status`)
  REFERENCES `ISC`.`order` (`id_order` , `id_user` , `id_order_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_order_product1`
  FOREIGN KEY (`id_product` , `id_product_type`)
  REFERENCES `ISC`.`product` (`id_product` , `id_product_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`place_store_has_orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`place_store_has_orders` (
  `id_place_store` INT NOT NULL,
  `id_order` INT NOT NULL,
  PRIMARY KEY (`id_place_store`, `id_order`),
  INDEX `fk_place_store_has_orders_orders1_idx` (`id_order` ASC),
  INDEX `fk_place_store_has_orders_place_store1_idx` (`id_place_store` ASC),
  CONSTRAINT `fk_place_store_has_orders_place_store1`
  FOREIGN KEY (`id_place_store`)
  REFERENCES `ISC`.`place_store` (`id_place_store`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_store_has_orders_orders1`
  FOREIGN KEY (`id_order`)
  REFERENCES `ISC`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`orders_has_place_delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`orders_has_place_delivery` (
  `id_order` INT NOT NULL,
  `id_user` INT NOT NULL,
  `id_order_status` INT NOT NULL,
  `id_place_delivery` INT NOT NULL,
  PRIMARY KEY (`id_order`, `id_user`, `id_order_status`, `id_place_delivery`),
  INDEX `fk_orders_has_place_delivery_place_delivery1_idx` (`id_place_delivery` ASC),
  INDEX `fk_orders_has_place_delivery_orders1_idx` (`id_order` ASC, `id_user` ASC, `id_order_status` ASC),
  CONSTRAINT `fk_orders_has_place_delivery_orders1`
  FOREIGN KEY (`id_order` , `id_user` , `id_order_status`)
  REFERENCES `ISC`.`order` (`id_order` , `id_user` , `id_order_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_place_delivery_place_delivery1`
  FOREIGN KEY (`id_place_delivery`)
  REFERENCES `ISC`.`place_delivery` (`id_place_delivery`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`product_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`product_type` (
  `id_product_type` INT NOT NULL AUTO_INCREMENT,
  `product_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_product_type`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ISC`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ISC`.`user_roles` (
  `id_user_roles` INT NOT NULL AUTO_INCREMENT,
  `user_role` VARCHAR(45) NOT NULL,
  `user_id_user` INT NOT NULL,
  PRIMARY KEY (`id_user_roles`, `user_id_user`),
  INDEX `fk_user_roles_clients1_idx` (`user_id_user` ASC),
  CONSTRAINT `fk_user_roles_clients1`
  FOREIGN KEY (`user_id_user`)
  REFERENCES `ISC`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;