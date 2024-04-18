DROP TABLE IF EXISTS `cancion`;
DROP TABLE IF EXISTS `artista`;
DROP TABLE IF EXISTS `emisora`;
DROP TABLE IF EXISTS `modo_transmision`;
DROP TABLE IF EXISTS `tipo_musica`;

CREATE TABLE `modo_transmision` (
    `id` INT AUTO_INCREMENT,
    `modo` VARCHAR(32) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `tipo_musica` (
    `id` INT AUTO_INCREMENT,
    `tipo` VARCHAR(32) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `emisora` (
    `id` INT AUTO_INCREMENT,
    `nombre` VARCHAR(64) NOT NULL,
    `id_modo_transmision` INT,
    `id_tipo_musica` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_modo_transmision`) REFERENCES `modo_transmision`(`id`),
    FOREIGN KEY(`id_tipo_musica`) REFERENCES `tipo_musica`(`id`)
);

CREATE TABLE `artista` (
    `id` INT AUTO_INCREMENT ,
    `nombre` VARCHAR(64) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `cancion` (
    `id` INT AUTO_INCREMENT,
    `nombre` VARCHAR(64) NOT NULL,
    `nombre_archivo` VARCHAR(2048) NOT NULL,
    `id_artista` INT,
    `id_emisora` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_artista`) REFERENCES `artista`(`id`),
    FOREIGN KEY(`id_emisora`) REFERENCES `emisora`(`id`)
);
