DROP TABLE IF EXISTS `canciones_y_programaciones`;
DROP TABLE IF EXISTS `programaciones`;
DROP TABLE IF EXISTS `artistas_y_canciones`;
DROP TABLE IF EXISTS `canciones`;
DROP TABLE IF EXISTS `generos_musicales`;
DROP TABLE IF EXISTS `artistas`;
DROP TABLE IF EXISTS `emisoras`;
DROP TABLE IF EXISTS `tipos_musica`;
DROP TABLE IF EXISTS `modos_transmision`;

CREATE TABLE `modos_transmision` (
    `id` INT AUTO_INCREMENT,
    `modo` VARCHAR(32) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `tipos_musica` (
    `id` INT AUTO_INCREMENT,
    `tipo` VARCHAR(32) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `emisoras` (
    `id` INT AUTO_INCREMENT,
    `nombre` VARCHAR(64) NOT NULL,
    `id_modo_transmision` INT,
    `id_tipo_musica` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_modo_transmision`) REFERENCES `modos_transmision`(`id`),
    FOREIGN KEY(`id_tipo_musica`) REFERENCES `tipos_musica`(`id`)
);

CREATE TABLE `artistas` (
    `id` INT AUTO_INCREMENT ,
    `nombre` VARCHAR(64) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `generos_musicales` (
    `id` INT AUTO_INCREMENT,
    `genero` VARCHAR(64) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `canciones` (
    `id` INT AUTO_INCREMENT,
    `nombre` VARCHAR(64) NOT NULL,
    `url` VARCHAR(2048) NOT NULL,
    `id_emisora` INT,
    `id_genero_musical` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_emisora`) REFERENCES `emisoras`(`id`),
    FOREIGN KEY(`id_genero_musical`) REFERENCES `generos_musicales`(`id`)
);

CREATE TABLE `artistas_y_canciones` (
    `id` INT AUTO_INCREMENT,
    `id_artista` INT,
    `id_cancion` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_artista`) REFERENCES `artistas`(`id`),
    FOREIGN KEY(`id_cancion`) REFERENCES `canciones`(`id`)
);

CREATE TABLE `programaciones` (
    `id` INT AUTO_INCREMENT,
    `fecha` DATE,
    PRIMARY KEY(`id`)
);

CREATE TABLE `canciones_y_programaciones` (
    `id` INT AUTO_INCREMENT,
    `id_cancion` INT,
    `id_programacion` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_cancion`) REFERENCES `canciones`(`id`),
    FOREIGN KEY(`id_programacion`) REFERENCES `programaciones`(`id`)
);
