DROP TABLE IF EXISTS `artistas_y_canciones`;
DROP TABLE IF EXISTS `canciones`;
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

CREATE TABLE `canciones` (
    `id` INT AUTO_INCREMENT,
    `nombre` VARCHAR(64) NOT NULL,
    `nombre_archivo` VARCHAR(2048) NOT NULL,
    `id_emisora` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_emisora`) REFERENCES `emisoras`(`id`)
);

CREATE TABLE `artistas_y_canciones` (
    `id` INT AUTO_INCREMENT,
    `id_artista` INT,
    `id_cancion` INT,
    PRIMARY KEY(`id`),
    FOREIGN KEY(`id_artista`) REFERENCES `artistas`(`id`),
    FOREIGN KEY(`id_cancion`) REFERENCES `canciones`(`id`)
);
