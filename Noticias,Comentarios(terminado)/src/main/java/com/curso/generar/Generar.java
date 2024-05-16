package com.curso.generar;

import jakarta.persistence.Persistence;

/**
 * 
 * @author Admin
 *
 */
public class Generar {
	/**
	 * Regenera la BBDD a los datos por defecto de los scripts
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Persistence.generateSchema("periodico", null);

	}

}
