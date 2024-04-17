package semana2.pruebauno.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import semana2.pruebauno.clases.Camion;
import semana2.pruebauno.clases.Coche;
import semana2.pruebauno.clases.Motocicleta;
import semana2.pruebauno.clases.Vehiculo;

public class Principal {

	public static void main(String[] args) {
		List<Vehiculo> vehiculos = crearVehiculos();
		realizarVariosTrayectos(3, vehiculos);

	}

	private static void realizarVariosTrayectos(int contador, List<Vehiculo> vehiculos) {

		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo.toString());
			vehiculo.conducir();
			for (int i = 0; i < contador; i++) {
				if (i == 1 && vehiculo.getPlazas() < 5) {
					vehiculo.pintarVehiculo("Amarillo");
				}
				vehiculo.avanzar(randDistancia(), randVelocidad());
			}
			vehiculo.parar();

		}

	}

	private static List<Vehiculo> crearVehiculos() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(new Coche("Audi", "TT", "negro", "cabrio"));
		vehiculos.add(new Coche("Fiat", "Cinquecento", "azul", "coupe"));
		vehiculos.add(new Coche("BMW", "330D", "gris", "berlina"));
		vehiculos.add(new Coche("Volkswagen", "Arteon", "amarillo", "sedan"));
		vehiculos.add(new Coche("Peugeot", "807", "verde", "monovolumen"));
		vehiculos.add(new Camion("Volvo", "FH 720 R", "Amarillo"));
		vehiculos.add(new Camion("Iveco", "S-Way", "Verde"));
		vehiculos.add(new Camion("Man", "TGX", "Verde"));
		vehiculos.add(new Motocicleta("Benelli", "TNT 125", "Negro", 12));
		vehiculos.add(new Motocicleta("Yamaha", "MT-07", "Blanco", 70));
		vehiculos.add(new Motocicleta("Kawasaki", "Ninja 500", "Verde", 45));
		return vehiculos;
	}

	protected static int randDistancia() {
		Random rand = new Random();
		int min = 50;
		int max = 500;
		return rand.nextInt((max - min) + 1) + min;
	}

	protected static int randVelocidad() {
		Random rand = new Random();
		int min = 50;
		int max = 140;
		return rand.nextInt((max - min) + 1) + min;
	}

}
