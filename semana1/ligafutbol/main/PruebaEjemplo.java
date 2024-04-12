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
		Jugador jugador1 = new Jugador("Mario");
		lista1.add(jugador1);
		Jugador jugador2 = new Jugador("Francisco");
		lista1.add(jugador2);
		Jugador jugador3 = new Jugador("David");
		lista1.add(jugador3);
		Jugador jugador4 = new Jugador("Juan");
		lista1.add(jugador4);
		Jugador jugador5 = new Jugador("Manuel");
		lista1.add(jugador5);
		Equipo equipo1 = new Equipo("Man Blue", 1983);
		equipo1.setListaJugadores(lista1);

		List<Jugador> lista2 = new ArrayList<>();
		Jugador jugador6 = new Jugador("Javier");
		lista2.add(jugador6);
		Jugador jugador7 = new Jugador("Daniel");
		lista2.add(jugador7);
		Jugador jugador8 = new Jugador("Jose Antonio");
		lista2.add(jugador8);
		Jugador jugador9 = new Jugador("Antonio");
		lista2.add(jugador9);
		Jugador jugador10 = new Jugador("Francisco Javier");
		lista2.add(jugador10);
		Equipo equipo2 = new Equipo("Man Red", 1983);
		equipo2.setListaJugadores(lista2);

		List<Jugador> lista3 = new ArrayList<>();
		Jugador jugador11 = new Jugador("Valeria");
		lista3.add(jugador11);
		Jugador jugador12 = new Jugador("Paula");
		lista3.add(jugador12);
		Jugador jugador13 = new Jugador("Emma");
		lista3.add(jugador13);
		Jugador jugador14 = new Jugador("Daniela");
		lista3.add(jugador14);
		Jugador jugador15 = new Jugador("Carla");
		lista3.add(jugador15);
		Equipo equipo3 = new Equipo("London North", 1981);
		equipo3.setListaJugadores(lista3);

		List<Jugador> lista4 = new ArrayList<>();
		Jugador jugador16 = new Jugador("Lucia");
		lista4.add(jugador16);
		Jugador jugador17 = new Jugador("Sofia");
		lista4.add(jugador17);
		Jugador jugador18 = new Jugador("Martina");
		lista4.add(jugador18);
		Jugador jugador19 = new Jugador("Maria");
		lista4.add(jugador19);
		Jugador jugador20 = new Jugador("Julia");
		lista4.add(jugador20);
		Equipo equipo4 = new Equipo("London South", 1983);
		equipo4.setListaJugadores(lista4);

		List<Equipo> equiposList = new ArrayList<>();
		equiposList.add(equipo4);
		equiposList.add(equipo3);
		equiposList.add(equipo2);
		equiposList.add(equipo1);
		Liga ligaFalsa = new Liga(equiposList);

		Partido partido1 = new Partido(equipo1, lista1.subList(0, generarRandom()), equipo2,
				lista2.subList(0, generarRandom()));
		ligaFalsa.addPartido(partido1);
		Partido partido2 = new Partido(equipo3, lista3.subList(0, generarRandom()), equipo4,
				lista4.subList(0, generarRandom()));
		ligaFalsa.addPartido(partido2);
		Partido partido3 = new Partido(equipo1, lista1.subList(0, generarRandom()), equipo3,
				lista3.subList(0, generarRandom()));
		ligaFalsa.addPartido(partido3);
		Partido partido4 = new Partido(equipo4, lista4.subList(0, generarRandom()), equipo2,
				lista2.subList(0, generarRandom()));
		ligaFalsa.addPartido(partido4);
		Partido partido5 = new Partido(equipo1, lista1.subList(0, generarRandom()), equipo4,
				lista4.subList(0, generarRandom()));
		ligaFalsa.addPartido(partido5);
		Partido partido6 = new Partido(equipo3, lista3.subList(0, generarRandom()), equipo2,
				lista2.subList(0, generarRandom()));
		ligaFalsa.addPartido(partido6);
		return ligaFalsa;
	}

}
