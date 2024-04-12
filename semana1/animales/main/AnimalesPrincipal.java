package semana1.animales.main;

import java.util.ArrayList;
import java.util.List;

import semana1.animales.clases.Animal;
import semana1.animales.clases.Gato;
import semana1.animales.clases.Mascota;
import semana1.animales.clases.Pez;
import semana1.animales.clases.Spider;

public class AnimalesPrincipal {

	public static void main(String[] args) {
		List<Animal> listaAnimales = obtenerDatosAnimales();
		usarMetodosAnimales(listaAnimales);

	}

	private static void usarMetodosAnimales(List<Animal> listaAnimales) {
		for (Animal animal : listaAnimales) {
			System.out.println("El animal es un/a " + animal.getClass().getSimpleName());
			if (animal instanceof Mascota) {
				System.out.println("Es una mascota que se llama " + ((Mascota) animal).getNombre() + ":");
				((Mascota) animal).jugar();
			}
			animal.andar();
			animal.comer();

		}

	}

	private static List<Animal> obtenerDatosAnimales() {
		List<Animal> listaAnimales = new ArrayList<>();
		listaAnimales.add(new Spider());
		listaAnimales.add(new Gato("Gardfield"));
		listaAnimales.add(new Pez("Nemo"));
		return listaAnimales;
	}

}
