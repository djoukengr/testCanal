
-- -----------------------------------------------------
-- Table `Subscriber`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Subscriber (
  `idSubscriber` VARCHAR(45) NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `adressePrincipale` VARCHAR(200) NOT NULL,
  `pays` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSubscriber`));



-- -----------------------------------------------------
-- Table `Contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Contract (
  `idContract` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `Subscriber_idSubscriber` INT NOT NULL,
   PRIMARY KEY (`idContract`, `Subscriber_idSubscriber`),
    FOREIGN KEY (`Subscriber_idSubscriber`)
    REFERENCES Subscriber (`idSubscriber`)
    ON DELETE CASCADE
    ON UPDATE  CASCADE);



-- -----------------------------------------------------
-- Table `History`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS History (
  `idMouvement` INT NOT NULL AUTO_INCREMENT,
  `idSubscriber` INT NULL,
  `idContract` INT NULL,
  `typeModification` VARCHAR(45) NULL,
  `dateModification` VARCHAR(45) NULL,
  `oldValue` VARCHAR(45) NULL,
  `newValue` VARCHAR(45) NULL,
  PRIMARY KEY (`idMouvement`));

