package com.curso.restore;

import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
/**
 * Esta clase se usa para reiniciar la base de datos a un punto inicial con 5 dept y 25 empleados
 * @author Admin
 *
 */
public class Generar {

	public static void main(String[] args) {

			Persistence.generateSchema("empresa", null);
	}

}
