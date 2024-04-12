package semana1.orquesta.main;

import semana1.orquesta.clases.Flauta;
import semana1.orquesta.clases.Guitarra;
import semana1.orquesta.clases.GuitarraElectrica;
import semana1.orquesta.clases.Tambor;

/**
 * 
 * @author Admin 11-04-2024
 *	Clase principal del proyecto de orquesta
 */
public class Orquesta {

	public static void main(String[] args) {
		hacerSonarOrquesta();

	}

	private static void hacerSonarOrquesta() {
		new Flauta("Flauta", "Dulce").tocar();
		new Guitarra("Guitarra", 6).tocar();
		new GuitarraElectrica("Guitarra electrica", 6, 90).tocar();
		new Tambor("Tambor", "Bastante grande").aporrear();
		
	}

}
