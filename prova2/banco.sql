-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`imagem` (
  `idImagem` VARCHAR(45) NOT NULL,
  `path` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idImagem`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UsuarioLogin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`UsuarioLogin` (
  `idUsuarioLogin` INT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `usuario` VARCHAR(200) NOT NULL,
  `senha` VARCHAR(200) NOT NULL,
  `admin` TINYINT NOT NULL,
  PRIMARY KEY (`idUsuarioLogin`),
  UNIQUE INDEX `idUsuarioLogin_UNIQUE` (`idUsuarioLogin` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Permissao` (
  `visualizar` TINYINT NOT NULL,
  `excluir` TINYINT NOT NULL,
  `compartilhar` TINYINT NOT NULL,
  `idUsuarioLogin` INT NOT NULL,
  `idImagem` INT NOT NULL,
  INDEX `fk_Permissao_UsuarioLogin1_idx` (`idUsuarioLogin` ASC) VISIBLE,
  INDEX `fk_Permissao_imagem1_idx` (`idImagem` ASC) VISIBLE,
  CONSTRAINT `fk_Permissao_UsuarioLogin1`
    FOREIGN KEY (`idUsuarioLogin`)
    REFERENCES `mydb`.`UsuarioLogin` (`idUsuarioLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Permissao_imagem1`
    FOREIGN KEY (`idImagem`)
    REFERENCES `mydb`.`imagem` (`idImagem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Notificacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Notificacao` (
  `idNotificacao` INT NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `idUsuarioLogin` INT NOT NULL,
  PRIMARY KEY (`idNotificacao`),
  INDEX `fk_Notificacao_UsuarioLogin_idx` (`idUsuarioLogin` ASC) VISIBLE,
  CONSTRAINT `fk_Notificacao_UsuarioLogin`
    FOREIGN KEY (`idUsuarioLogin`)
    REFERENCES `mydb`.`UsuarioLogin` (`idUsuarioLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
