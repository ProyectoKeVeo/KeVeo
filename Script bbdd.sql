CREATE SCHEMA IF NOT EXISTS `base_KeVeo` DEFAULT CHARACTER SET utf8 ;
-- drop database base_keveo;
USE `base_KeVeo` ;
CREATE TABLE IF NOT EXISTS `base_KeVeo`.`USERS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL UNIQUE,
  `PASSWORD` VARCHAR(255) NOT NULL,
  `account_name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `active` tinyint default '1',
  `birth_date` DATE NULL,
  `register_date` DATETIME NULL,
  PRIMARY KEY (`ID`));



CREATE TABLE IF NOT EXISTS `base_KeVeo`.`platform` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `commission` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));



CREATE TABLE IF NOT EXISTS `base_KeVeo`.`films` (
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
  `users_id` INT NOT NULL,
  PRIMARY KEY (`notification_id`, `users_id`),
  INDEX `fk_notificacion_has_usuario_usuario1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_notificacion_has_usuario_notificacion1_idx` (`notification_id` ASC) VISIBLE,
  CONSTRAINT `fk_notificacion_has_usuario_notificacion1`
    FOREIGN KEY (`notification_id`)
    REFERENCES `base_KeVeo`.`notification` (`id`),
  CONSTRAINT `fk_notificacion_has_usuario_usuario1`
    FOREIGN KEY (`users_id`)
    REFERENCES `base_KeVeo`.`USERS` (`ID`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`url` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `films_id` INT NOT NULL,
  `platform_id` INT NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `url` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`,`films_id`, `platform_id`),
  INDEX `fk_pelicula_has_plataforma_plataforma1_idx` (`platform_id` ASC) VISIBLE,
  INDEX `fk_pelicula_has_plataforma_pelicula1_idx` (`films_id` ASC) VISIBLE,
  CONSTRAINT `fk_pelicula_has_plataforma_pelicula1`
    FOREIGN KEY (`films_id`)
    REFERENCES `base_KeVeo`.`films` (`id`),
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
  `users_id` INT NOT NULL,
  `films_id` INT NOT NULL,
  PRIMARY KEY (`id`, `users_id`, `films_id`),
  INDEX `fk_puntuation_users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_puntuation_films1_idx` (`films_id` ASC) VISIBLE,
  CONSTRAINT `fk_puntuation_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `base_KeVeo`.`USERS` (`ID`),
  CONSTRAINT `fk_puntuation_films1`
    FOREIGN KEY (`films_id`)
    REFERENCES `base_KeVeo`.`films` (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`genres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `base_KeVeo`.`genres_films` (
  `genres_id` INT NOT NULL,
  `films_id` INT NOT NULL,
  PRIMARY KEY (`genres_id`, `films_id`),
  INDEX `fk_genres_films_films1_idx` (`films_id` ASC) VISIBLE,
  INDEX `fk_genres_films_genres1_idx` (`genres_id` ASC) VISIBLE,
  CONSTRAINT `fk_genres_films_genres1`
    FOREIGN KEY (`genres_id`)
    REFERENCES `base_KeVeo`.`genres` (`id`),
  CONSTRAINT `fk_genres_films_films1`
    FOREIGN KEY (`films_id`)
    REFERENCES `base_KeVeo`.`films` (`id`));
    
    CREATE  TABLE MENUS(
    ID INTEGER auto_increment,
    ACTIVE INTEGER,
    DESCRIPTION VARCHAR(255) NOT NULL,
    APP_ORDER INTEGER,
    URL VARCHAR(255),
    PARENT_ID INTEGER,
    CONSTRAINT CONSTRAINT_2 PRIMARY KEY(ID)
);             
   
-- 6 +/- SELECT COUNT(*) FROM PUBLIC.MENUS;    
             
CREATE TABLE MENUS_ROLES(
    MENUS_ID INTEGER NOT NULL,
    ROLES_ID INTEGER NOT NULL
);              
ALTER TABLE MENUS_ROLES ADD CONSTRAINT CONSTRAINT_4 PRIMARY KEY(MENUS_ID, ROLES_ID);  
-- 11 +/- SELECT COUNT(*) FROM PUBLIC.MENUS_ROLES;             
 
CREATE TABLE ROLES(
    ID INTEGER auto_increment,
    ROLE_NAME VARCHAR(255) NOT NULL,
    CONSTRAINT CONSTRAINT_26 PRIMARY KEY(ID)
);   
      
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.ROLES;    
INSERT INTO ROLES VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');     
	
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.USERS;    

CREATE TABLE USERS_ROLES(
    USERS_ID INTEGER NOT NULL,
    ROLES_ID INTEGER NOT NULL

);             
ALTER TABLE USERS_ROLES ADD CONSTRAINT CONSTRAINT_C PRIMARY KEY(USERS_ID, ROLES_ID); 
-- 9 +/- SELECT COUNT(*) FROM PUBLIC.USERS_ROLES;                   
 
ALTER TABLE USERS_ROLES ADD CONSTRAINT FKJ9553ASS9UCTJRMH0GKQSMV0D FOREIGN KEY(ROLES_ID) REFERENCES ROLES(ID) ;     
ALTER TABLE MENUS_ROLES ADD CONSTRAINT FKQ7K54HB6F3NGDBFPBLWJ68BHG FOREIGN KEY(MENUS_ID) REFERENCES MENUS(ID) ;      
ALTER TABLE MENUS ADD CONSTRAINT FKGEUPUBDQNCC1LPGF2CN4FQWBC FOREIGN KEY(PARENT_ID) REFERENCES MENUS(ID) ;          
ALTER TABLE MENUS_ROLES ADD CONSTRAINT FKAUV6MBPEO296VHBM7AVTOI3O8 FOREIGN KEY(ROLES_ID) REFERENCES ROLES(ID) ; 


-- Datos para peliculas --
INSERT INTO `films` (`id`,`name`,`duration`,`year`,`description`,`number_views`,`creation_date`,`trailer`,`image`) 
VALUES 
(1,'Malnazidos',101,2022,'En plena guerra civil española, unos enemigos acérrimos se ven obligados a luchar codo con codo contra los zombis caníbales creados en un experimento nazi.',0,'2022-07-13','https://www.youtube.com/watch?v=MGnCUnJVse4','https://pics.filmaffinity.com/Malnazidos-290050143-large.jpg'),
(2,'Los Futbolísimos',101,2018,'Los jugadores de un equipo de fútbol juvenil deben averiguar por qué pierden continuamente. Si siguen así, el cole cancelará el equipo y destinará los fondos a un coro.',0,'2022-07-13','https://www.youtube.com/watch?v=F5d6P6yCOSw','https://es.web.img3.acsta.net/pictures/18/03/15/16/35/4898546.jpg'),
(3,'Alerta Roja',118,2021,'Un criminólogo del FBI y el ladrón de arte más buscado del mundo se hacen compinches para atrapar a una escurridiza estafadora que siempre va un paso por delante.',0,'2022-07-13',NULL,NULL),
(4,'Uno más de la familia',95,2019,'Una fiel perrita, que echa de menos su hogar, emprende un peligroso viaje por el corazón de los Estados Unidos para volver con su dueño.',0,'2022-07-13',NULL,NULL),
(5,'El Hombre de Toronto',112,2022,'Un caso de identidad equivocada obliga a un empresario inepto a colaborar con el asesino conocido como el «Hombre de Toronto» para sobrevivir.',0,'2022-07-13',NULL,NULL),
(6,'Spider-Man: Homecoming',133,2017,'Peter Parker regresa a su vida cotidiana de estudiante. Pero la aparición de un villano le da la oportunidad de demostrar que es todo un superhéroe arácnido.',0,'2022-07-13',NULL,NULL),
(7,'Pixels',106,2015,'Cuando los extraterrestres invaden la Tierra como en un videojuego clásico, el presidente y sus amigos de infancia, antiguos reyes de los recreativos, entran en acción.',0,'2022-07-13',NULL,NULL),
(8,'El proyecto Adam',106,2022,'Adam Reed es un piloto de caza que viaja en el tiempo. Cuando se estrella en el año 2022, conoce a su yo de 12 años y juntos emprenden una misión para salvar el futuro.',0,'2022-07-13',NULL,NULL),
(9,'The Equalizer 2',120,2018,'Robert McCall, un exagente de la CIA convertido en justiciero, vuelve a hacer uso de sus habilidades letales para vengar la muerte de una excolega muy amiga suya.',0,'2022-07-13',NULL,NULL),
(10,'Enola Holmes',124,2020,'Enola Holmes, una intrépida joven que busca a su madre, utiliza su brillante instinto investigador para superar a su hermano Sherlock y ayudar a un lord en su fuga.',0,'2022-07-13',NULL,NULL),
(11,'Tiburón',124,1975,'Cuando un insaciable gran tiburón blanco siembra el terror en Amity Island, un oceanógrafo y un curtido cazador de escualos se unen para acabar con la bestia.',0,'2022-07-13',NULL,NULL),
(12,'Transformers',144,2007,'Los Autobots y los Decepticons luchan por hacerse con los recursos de la Tierra, y Sam Witwicky no sabe que él es la única esperanza de supervivencia para la raza humana.',0,'2022-07-13',NULL,NULL),
(13,'Transformers: El lado oscuro de la luna',155,2011,'Cuando Optimus Prime se entera de que una nave de Transformers ha caído en la luna, se pone al mando de una misión para rescatar al piloto, su mentor, Sentinel Prime.',0,'2022-07-13',NULL,NULL),
(14,'Blade Runner 2049',163,2017,'Los contenidos de una tumba atraen la atención de un magnate y obligan al agente K, un blade runner de la Policía de Los Ángeles, a seguir la pista de una leyenda.',0,'2022-07-13',NULL,NULL),
(15,'Assassin\'s Creed',115,2016,'En esta adaptación de la aclamada franquicia de videojuegos, una misteriosa organización rescata a un hombre condenado a muerte.',0,'2022-07-13',NULL,NULL),
(16,'FullMetal Alchemist',134,2017,'El alquimista Edward Elric busca la manera de devolverle el cuerpo a su hermano Al. Pero tanto los militares como unos misteriosos monstruos le vigilan atentamente.',0,'2022-07-13',NULL,NULL),
(17,'El monstruo marino',119,2022,'Una joven polizona se cuela en el navío de un cazador legendario de monstruos marinos y juntos emprenden un viaje épico por mares inexplorados. Y hacen historia.',0,'2022-07-13',NULL,NULL),
(18,'Los pitufos: La aldea escondida',89,2017,'Pitufina se adentra en el Bosque Prohibido con sus grandes amigos Filósofo, Torpe y Fortachón para librar a una misteriosa aldea de las garras del malvado mago Gárgamel.',0,'2022-07-13',NULL,NULL),
(19,'Mascotas unidas',93,2020,'Un perro callejero y una gata mimada lideran a unos peculiares héroes dispuestos a liberar la ciudad de las garras del malvado alcalde y su ejército de robots.',0,'2022-07-13',NULL,NULL),
(20,'Jumanji',104,1995,'Dos hermanos descubren un juego de mesa encantado que abre una puerta a un mundo mágico y, sin saberlo, liberan a un hombre que ha estado atrapado dentro durante años.',0,'2022-07-13',NULL,NULL),
(21,'Animales fantásticos: Los secretos de Dumbledore',142,2022,'Albus Dumbledore confía al magizoólogo Newt Scamander la dirección de un intrépido equipo de magos, brujas y un',0,'2022-07-20',NULL,NULL),
(22,'The Batman',176,2022,'En su segundo año luchando contra el crimen, Batman descubre un caso de corrupción en Gotham relacionado con su',0,'2022-07-20',NULL,NULL),
(23,'Harry Potter y las Reliquias de la Muerte - Parte II',125,2011,'Harry, Ron y Hermione siguen su búsqueda de los tres horrocruxes restantes del Señor Tenebroso, los objetos mágicos',0,'2022-07-20',NULL,NULL),
(24,'Oblivion',119,2013,'En un planeta Tierra del futuro casi irreconocible, el conflicto de un hombre con el pasado hace que se embarque en un',0,'2022-07-20',NULL,NULL),
(25,'Dunkerke',102,2017,'Cientos de miles de tropas aliadas son rodeadas por el enemigo en Dunkerque, al norte de Francia, durante la II Guerra',0,'2022-07-20',NULL,NULL),
(26,'Aliados',119,2016,'En 1942, tras enamorarse de una agente francesa durante una peligrosa misión en el norte de África, un agente de',0,'2022-07-20',NULL,NULL),
(27,'Inferno',116,2016,'Robert Langdon y Sienna Brooks siguen una serie de pistas a través de Europa para evitar que un virus acabe con la mitad',0,'2022-07-20',NULL,NULL),
(28,'El método Williams',144,2021,'La vida de Richard Williams, padre y figura fundamental en el desarrollo de dos de las deportistas más extraordinarias de',0,'2022-07-20',NULL,NULL),
(29,'En el corazón del mar',116,2015,'Una aventura de acción sobre la catástrofe marítima real que inspiró Moby Dick.',0,'2022-07-20',NULL,NULL),
(30,'Los Croods. Una aventura prehistórica',94,2013,'Tras perder su cueva, los Croods emprenden un viaje a través de increíbles paisajes cargados de criaturas fantásticas,',0,'2022-07-20',NULL,NULL),
(31,'Shrek',86,2001,'Shrek emprende un viaje para rescatar a la peleona princesa Fiona con ayuda de su adorable Asno y para recuperar su',0,'2022-07-20',NULL,NULL),
(32,'Once Upon a Time in Hollywood',160,2019,'Un actor y su doble de acción se embarcan en una odisea para darse a conocer en la industria del cine coincidiendo con los asesinatos ideados por Charles Manson en Los Ángeles en 1969.',0,'2022-07-20',NULL,NULL),
(33,'Tres reyes',114,1999,'Tras la Guerra del Golfo un pequeño grupo de soldados estadounidenses planea robar un gran alijo de oro escondido en el desierto de Irak.',0,'2022-07-20',NULL,NULL),
(34,'Joker',122,2019,'Arthur Fleck (Phoenix) vive en Gotham con su madre, y su única motivación en la vida es hacer reír a la gente. Actúa haciendo de payaso en pequeños trabajos, pero tiene problemas mentales que hacen que la gente le vea como un bicho raro.',0,'2022-07-20',NULL,NULL),
(35,'El mejor verano de mi vida',91,2018,'Curro es un fantasioso vendedor de robots de cocina que sueña con un trabajo en el mundo financiero. Hace una promesa que no puede cumplir: si su hijo Nico, de 9 años, saca todo sobresalientes, le llevará a unas vacaciones de verano inolvidables. ',0,'2022-07-20',NULL,NULL),
(36,'Interstellar',169,2014,'Al ver que la vida en la Tierra está llegando a su fin, un grupo de exploradores emprende una misión que puede ser la más importante de la historia de la humanidad: viajar más allá de nuestra galaxia.',0,'2022-07-20',NULL,NULL),
(37,'La monja',96,2018,'Cuando una joven monja se suicida en una abadía de clausura en Rumanía, un sacerdote experto en posesiones demoniacas y una novicia a punto de tomar sus votos, son enviados por el Vaticano para investigar.',0,'2022-07-20',NULL,NULL),
(38,'Happy Feet',108,2006,'En la gélida Antártida, los pingüinos cantan para hacer el cortejo, pero lo que a Mumble se le da bien es bailar. Cuando sus compañeros pingüinos empiezan a entonar canciones románticas, los pies de Mumble no pueden evitar moverse.',0,'2022-07-20',NULL,NULL),
(39,'Kong: La Isla Calavera',120,2017,'En los años 70, un variopinto grupo de exploradores y soldados es reclutado para viajar a una misteriosa isla del Pacífico. Pero al adentrarse en esta bella pero traicionera isla, los exploradores encontrarán algo absolutamente sorprendente.',0,'2022-07-20',NULL,NULL),
(40,'Kimi',89,2022,'Una empleada de una empresa tecnológica que sufre agorafobia descubre un crimen e intenta alertar a sus superiores.',0,'2022-07-20',NULL,NULL);


INSERT INTO `genres` (`id`,`title`) 
values
(1, 'Acción'),
(2, 'Comedia'),
(3, 'Familiar'),
(4, 'Ciencia Ficción'),
(5, 'Aventura'),
(6, 'Suspense'),
(7, 'Drama'),
(8, 'Fantasía'),
(9, 'Bélico'),
(10, 'Terror'),
(11, 'Infantil');

INSERT INTO `genres_films` (`genres_id`,`films_id`) 
values
(1,1),
(2,2),
(1,3),
(3,4),
(1,5),
(4,6),
(2,7),
(4,8),
(1,9),
(5,10),
(6,11),
(2,12),
(4,13),
(4,14),
(1,15),
(7,16),
(5,17),
(3,18),
(3,19),
(5,20),
(8,21),
(6,22),
(8,23),
(4,24),
(9,25),
(9,26),
(6,27),
(7,28),
(5,29),
(3,30),
(3,31),
(7,32),
(9,33),
(7,34),
(2,35),
(4,36),
(10,37),
(11,38),
(5,39),
(6,40);







