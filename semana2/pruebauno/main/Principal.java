package semana2.pruebauno.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import semana2.pruebauno.clases.Coche;
import semana2.pruebauno.clases.Vehiculo;

public class Principal {

	public static void main(String[] args) {
		List<Vehiculo> vehiculos = crearVehiculos();
		realizarTrayecto(3, vehiculos);
	}

	private static void realizarTrayecto(int trayectos, List<Vehiculo> vehiculos) {

		for (Vehiculo vehiculo : vehiculos) {

			for (int i = 0; i < trayectos; i++) {
				vehiculo.conducir();
				if (vehiculo instanceof Coche) {

					Coche coche = (Coche) vehiculo;
					coche.avanzar(randDistancia(), randVelocidad());

				}
				vehiculo.parar();
			}

		}

	}

	private static List<Vehiculo> crearVehiculos() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(new Coche("Audi", "TT", "negro", "coupe"));
		vehiculos.add(new Coche("Fiat", "Cinquecento", "azul", "coupe"));
		return vehiculos;
	}

	protected static int randDistancia() {
		Random rand = new Random();
		int min = 50;
		int max = 300;
		return rand.nextInt((max - min) + 1) + min;
	}

	protected static int randVelocidad() {
		Random rand = new Random();
		int min = 50;
		int max = 140;
		return rand.nextInt((max - min) + 1) + min;
	}

}
