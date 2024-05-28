DROP DATABASE IF EXISTS cursos;
CREATE SCHEMA cursos;
DROP TABLE IF EXISTS cursos.curso;
CREATE TABLE cursos.curso (`cod_curso` VARCHAR(25) NOT NULL AUTO_INCREMENT,`nombre` VARCHAR(45) NULL,`duracion` INT NULL,`precio` DOUBLE NULL,PRIMARY KEY (`cod_curso`));
INSERT INTO cursos.curso (`nombre`, `duracion`, `precio`) VALUES ('JAVA', '80', '99.99');
INSERT INTO cursos.curso (`nombre`, `duracion`, `precio`) VALUES ('PHP', '100', '109.99');
INSERT INTO cursos.curso (`nombre`, `duracion`, `precio`) VALUES ('COBOL', '120', '129.99');