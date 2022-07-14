CREATE SCHEMA IF NOT EXISTS `base_KeVeo` DEFAULT CHARACTER SET utf8 ;
USE `base_KeVeo` ;

CREATE TABLE IF NOT EXISTS `base_KeVeo`.`USER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL UNIQUE,
  `PASSWORD` VARCHAR(255) NOT NULL,
  `accountName` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `ACTIVE` TINYINT NOT NULL,
  `DATE` DATE NULL,
  `registerDate` DATETIME NULL,
  PRIMARY KEY (`ID`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`platform` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `commission` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));



CREATE TABLE IF NOT EXISTS `base_KeVeo`.`film` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `duration` INT NOT NULL,
  `year` INT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `number_views` INT NOT NULL,
  `creation_date` DATE NOT NULL,
  `trailer` VARCHAR(255) NULL,
  `image` BLOB NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`type_notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NOT NULL,
  `notification_id` INT NOT NULL,
  `enumerator` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `notification_id`),
  INDEX `fk_tipo_notificacion_notificacion_idx` (`notification_id` ASC) VISIBLE,
  CONSTRAINT `fk_tipo_notificacion_notificacion`
    FOREIGN KEY (`notification_id`)
    REFERENCES `base_KeVeo`.`notification` (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`notification_has_user` (
  `notification_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`notification_id`, `user_id`),
  INDEX `fk_notificacion_has_usuario_usuario1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_notificacion_has_usuario_notificacion1_idx` (`notification_id` ASC) VISIBLE,
  CONSTRAINT `fk_notificacion_has_usuario_notificacion1`
    FOREIGN KEY (`notification_id`)
    REFERENCES `base_KeVeo`.`notification` (`id`),
  CONSTRAINT `fk_notificacion_has_usuario_usuario1`
    FOREIGN KEY (`user_id`)
    REFERENCES `base_KeVeo`.`USER` (`ID`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`url` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `film_id` INT NOT NULL,
  `platform_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`,`film_id`, `platform_id`),
  INDEX `fk_pelicula_has_plataforma_plataforma1_idx` (`platform_id` ASC) VISIBLE,
  INDEX `fk_pelicula_has_plataforma_pelicula1_idx` (`film_id` ASC) VISIBLE,
  CONSTRAINT `fk_pelicula_has_plataforma_pelicula1`
    FOREIGN KEY (`film_id`)
    REFERENCES `base_KeVeo`.`film` (`id`),
  CONSTRAINT `fk_pelicula_has_plataforma_plataforma1`
    FOREIGN KEY (`platform_id`)
    REFERENCES `base_KeVeo`.`platform` (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `platform_id` INT NOT NULL,
  PRIMARY KEY (`id`, `platform_id`),
  INDEX `fk_bill_platform1_idx` (`platform_id` ASC) VISIBLE,
  CONSTRAINT `fk_bill_platform1`
    FOREIGN KEY (`platform_id`)
    REFERENCES `base_KeVeo`.`platform` (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`clicks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `step` TINYINT NULL DEFAULT 0,
  `date` DATETIME NOT NULL,
  `platform_id` INT NOT NULL,
  PRIMARY KEY (`id`, `platform_id`),
  INDEX `fk_clicks_plataforma1_idx` (`platform_id` ASC) VISIBLE,
  CONSTRAINT `fk_clicks_plataforma1`
    FOREIGN KEY (`platform_id`)
    REFERENCES `base_KeVeo`.`platform` (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`punctuation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `opinion` VARCHAR(255) NULL,
  `user_id` INT NOT NULL,
  `film_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `film_id`),
  INDEX `fk_puntuation_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_puntuation_film1_idx` (`film_id` ASC) VISIBLE,
  CONSTRAINT `fk_puntuation_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `base_KeVeo`.`USER` (`ID`),
  CONSTRAINT `fk_puntuation_film1`
    FOREIGN KEY (`film_id`)
    REFERENCES `base_KeVeo`.`film` (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`genre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`genre_has_film` (
  `genre_id` INT NOT NULL,
  `film_id` INT NOT NULL,
  PRIMARY KEY (`genre_id`, `film_id`),
  INDEX `fk_genre_has_film_film1_idx` (`film_id` ASC) VISIBLE,
  INDEX `fk_genre_has_film_genre1_idx` (`genre_id` ASC) VISIBLE,
  CONSTRAINT `fk_genre_has_film_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `base_KeVeo`.`genre` (`id`),
  CONSTRAINT `fk_genre_has_film_film1`
    FOREIGN KEY (`film_id`)
    REFERENCES `base_KeVeo`.`film` (`id`));


CREATE TABLE IF NOT EXISTS  MENU (
     ID  INTEGER NOT NULL AUTO_INCREMENT ,
     ACTIVE  INTEGER,
     DESCRIPTION  VARCHAR(255) NOT NULL,
     APP_ORDER  INTEGER,
     URL  VARCHAR(255),
     PARENT_ID  INTEGER,
     CONSTRAINT PRIMARY KEY( ID )
);             
        
CREATE TABLE IF NOT EXISTS  MENU_ROLES (
     MENU_ID  INTEGER NOT NULL,
     ROLES_ID  INTEGER NOT NULL,
     CONSTRAINT PRIMARY KEY( MENU_ID ,  ROLES_ID )
);              

CREATE TABLE IF NOT EXISTS  ROLE (
     ID  INTEGER NOT NULL auto_increment,
     ROLE_NAME  VARCHAR(255) NOT NULL,
     CONSTRAINT PRIMARY KEY( ID )
);   

CREATE TABLE IF NOT EXISTS  USER_ROLES (
     USERS_ID  INTEGER NOT NULL,
     ROLES_ID  INTEGER NOT NULL,
     CONSTRAINT PRIMARY KEY( USERS_ID ,  ROLES_ID )
);    

ALTER TABLE  USER_ROLES  ADD CONSTRAINT FOREIGN KEY( ROLES_ID ) REFERENCES  ROLE ( ID );     
ALTER TABLE  USER_ROLES  ADD CONSTRAINT FOREIGN KEY( USERS_ID ) REFERENCES  USER ( ID );     
ALTER TABLE  MENU_ROLES  ADD CONSTRAINT FOREIGN KEY( MENU_ID ) REFERENCES  MENU ( ID );      
ALTER TABLE  MENU  ADD CONSTRAINT FOREIGN KEY( PARENT_ID ) REFERENCES  MENU ( ID );              
ALTER TABLE  MENU_ROLES  ADD CONSTRAINT FOREIGN KEY( ROLES_ID ) REFERENCES  ROLE ( ID ); 
