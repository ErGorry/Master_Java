package semana1.ligafutbol.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import semana1.ligafutbol.clases.Equipo;
import semana1.ligafutbol.clases.Jugador;
import semana1.ligafutbol.clases.Liga;
import semana1.ligafutbol.clases.Partido;

public class PruebaEjemplo {

	public static void main(String[] args) {

		Liga prueba = simularLiga();
		mostrarTodosLosResultados(prueba);

	}

	private static void mostrarTodosLosResultados(Liga prueba) {
		System.out.println("Clasificacion final: ");
		String[] clas = prueba.obtenerClasificacion();
		for (int i = 0; i < clas.length; i++) {
			System.out.println(clas[i]);
		}
		List<Equipo> equipos = prueba.getLiga();
		for (Iterator<Equipo> ite = equipos.iterator(); ite.hasNext();) {
			Equipo equipo = ite.next();
			System.out.println("Ranking de goles del " + equipo.getNombre());
			String[] jugadores = equipo.obtenerMaximosAnotadores();
			for (int i = 0; i < jugadores.length; i++) {
				System.out.println(jugadores[i]);
			}
			System.out.println("Partidos esta temporada del " + equipo.getNombre());

			String[] partidos;

			partidos = equipo.getPartidosJugados();
			for (int i = 0; i < partidos.length; i++) {
				System.out.println(partidos[i]);
			}

		}

	}

	private static int generarRandom() {
		return new Random().nextInt(6);

	}

	private static Liga simularLiga() {
		List<Jugador> lista1 = new ArrayList<>();
		lista1.add(new Jugador("Mario"));
		lista1.add(new Jugador("Francisco"));
		lista1.add(new Jugador("David"));
		lista1.add(new Jugador("Juan"));
		lista1.add(new Jugador("Manuel"));
		Equipo equipo1 = new Equipo("Man Blue", 1983);
		equipo1.setListaJugadores(lista1);

		List<Jugador> lista2 = new ArrayList<>();
		lista2.add(new Jugador("Javier"));
		lista2.add(new Jugador("Daniel"));
		lista2.add(new Jugador("Jose Antonio"));
		lista2.add(new Jugador("Antonio"));
		lista2.add(new Jugador("Francisco Javier"));
		Equipo equipo2 = new Equipo("Man Red", 1983);
		equipo2.setListaJugadores(lista2);

		List<Jugador> lista3 = new ArrayList<>();
		lista3.add(new Jugador("Valeria"));
		lista3.add(new Jugador("Paula"));
		lista3.add(new Jugador("Emma"));
		lista3.add(new Jugador("Daniela"));
		lista3.add(new Jugador("Carla"));
		Equipo equipo3 = new Equipo("London North", 1981);
		equipo3.setListaJugadores(lista3);

		List<Jugador> lista4 = new ArrayList<>();
		lista4.add(new Jugador("Lucia"));
		lista4.add(new Jugador("Sofia"));
		lista4.add(new Jugador("Martina"));
		lista4.add(new Jugador("Maria"));
		lista4.add(new Jugador("Julia"));
		Equipo equipo4 = new Equipo("London South", 1983);
		equipo4.setListaJugadores(lista4);

		List<Equipo> equiposList = new ArrayList<>();
		equiposList.add(equipo4);
		equiposList.add(equipo3);
		equiposList.add(equipo2);
		equiposList.add(equipo1);

		Liga ligaFalsa = new Liga(equiposList);
		ligaFalsa.addPartido(
				new Partido(equipo1, lista1.subList(0, generarRandom()), equipo2, lista2.subList(0, generarRandom())));

		ligaFalsa.addPartido(
				new Partido(equipo3, lista3.subList(0, generarRandom()), equipo4, lista4.subList(0, generarRandom())));
		ligaFalsa.addPartido(
				new Partido(equipo1, lista1.subList(0, generarRandom()), equipo3, lista3.subList(0, generarRandom())));
		ligaFalsa.addPartido(
				new Partido(equipo4, lista4.subList(0, generarRandom()), equipo2, lista2.subList(0, generarRandom())));
		ligaFalsa.addPartido(
				new Partido(equipo1, lista1.subList(0, generarRandom()), equipo4, lista4.subList(0, generarRandom())));
		ligaFalsa.addPartido(
				new Partido(equipo3, lista3.subList(0, generarRandom()), equipo2, lista2.subList(0, generarRandom())));
		return ligaFalsa;
	}

}
