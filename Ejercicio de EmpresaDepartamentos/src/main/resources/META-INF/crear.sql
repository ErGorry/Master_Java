CREATE TABLE empleados(id_emp INT NOT NULL,nombre VARCHAR(255) NOT NULL,fecha DATE NULL,sueldo DOUBLE NULL,id_dept INT NULL ,PRIMARY KEY (id_emp));
CREATE TABLE departamentos(id_dept INT NOT NULL,nombre VARCHAR(255) NOT NULL,localidad VARCHAR(255),PRIMARY KEY (id_dept));
ALTER TABLE empleados ADD CONSTRAINT empleados_fk0 FOREIGN KEY (id_dept) REFERENCES departamentos(id_dept);