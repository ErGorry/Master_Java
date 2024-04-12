package semana1.orquesta.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import semana1.orquesta.clases.Flauta;
import semana1.orquesta.clases.Guitarra;
import semana1.orquesta.clases.GuitarraElectrica;
import semana1.orquesta.clases.Instrumento;
import semana1.orquesta.clases.Tambor;

/**
 * 
 * @author Admin 11-04-2024 Clase principal del proyecto de orquesta
 */
public class Orquesta {

	public static void main(String[] args) {
		List<Instrumento> orquesta = crearOrquesta();
		afinarOrquesta(orquesta);
		tocarOrquesta(orquesta);
	}

	private static void tocarOrquesta(List<Instrumento> orquesta) {
		for (Iterator<Instrumento> iterator = orquesta.iterator(); iterator.hasNext();) {
			Instrumento instrumento = iterator.next();
			if (instrumento instanceof Tambor) {
				Tambor tambor = (Tambor) instrumento;
				tambor.aporrear();
			} else {
				instrumento.tocar();
			}
		}
	}

	private static void afinarOrquesta(List<Instrumento> orquesta) {
		for (Iterator<Instrumento> iterator = orquesta.iterator(); iterator.hasNext();) {
			Instrumento instrumento = iterator.next();
			instrumento.afinar();
		}

	}

	private static List<Instrumento> crearOrquesta() {
		List<Instrumento> orquesta = new ArrayList<>();
		orquesta.add(new Flauta("Flauta", "Dulce"));
		orquesta.add(new Guitarra("Guitarra", 6));
		orquesta.add(new GuitarraElectrica("Guitarra electrica", 6, 90));
		orquesta.add(new Tambor("Tambor", "Bastante grande"));
		return orquesta;
	}

}
