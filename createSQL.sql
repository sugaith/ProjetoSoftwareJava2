CREATE TABLE IF NOT EXISTS `mydb`.`desenho` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `create_date` VARCHAR(45) NULL,
  `update_date` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `mydb`.`forma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `pontos` TEXT NULL,
  `create_date` VARCHAR(45) NULL,
  `update_date` VARCHAR(45) NULL,
  `desenho_id` INT NOT NULL,
  PRIMARY KEY (`id`, `desenho_id`),
  INDEX `fk_forma_desenho_idx` (`desenho_id` ASC) VISIBLE,
  CONSTRAINT `fk_forma_desenho`
    FOREIGN KEY (`desenho_id`)
    REFERENCES `mydb`.`desenho` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB