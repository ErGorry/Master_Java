package semana1.ligafutbol.clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Equipo {

	private String nombre;
	private int fundacion;
	private List<Jugador> listaJugadores;
	private List<Partido> partidosJugados;
	private int puntosClasificacion;

	public Equipo(String nombre, int fundacion) {
		super();
		this.nombre = nombre;
		this.fundacion = fundacion;
		this.listaJugadores = new ArrayList<Jugador>();
		this.partidosJugados = new ArrayList<Partido>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getFundacion() {
		return fundacion;
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public String [] getPartidosJugados() {
		String [] partidos = new String[partidosJugados.size()];
		int posicion = 0;
		for (Iterator<Partido> ite = partidosJugados.iterator(); ite.hasNext();) {
			Partido partido = ite.next();
			partidos[posicion++] = partido.toString();
		}
		return partidos;
	}

	/*public List<Partido> getPartidosJugados() {
		return partidosJugados;
	}*/

	public void setPartidosJugados(List<Partido> partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getPuntosClasificacion() {
		return puntosClasificacion;
	}

	public void addPuntos(int puntos) {
		this.puntosClasificacion += puntos;
	}
	
	public void addPartido(Partido partido) {
		this.partidosJugados.add(partido);
	}
	
	public String[] obtenerMaximosAnotadores(){
		List <Jugador> ranking = crearLista();
		
		String[] clasificacion = new String[ranking.size()];
		int cont = 0;
		for (Iterator<Jugador> ite = ranking.iterator(); ite.hasNext();) {
			Jugador jugador = ite.next();
			clasificacion[cont++] = cont + "º / " + jugador.getNombre() + " / " 
									+ jugador.getGoles() + " goles.";
		}
		return clasificacion;
		
	}

	private List<Jugador> crearLista() {
		List<Jugador> ranking = new ArrayList<>();
		for (Iterator<Jugador> ite = listaJugadores.iterator(); ite.hasNext();) {
			Jugador jugador = ite.next();
			if (jugador.getGoles()>0) {
				ranking.add(jugador);
			}
		}
		ranking.sort((jugador1,jugador2)->jugador2.getGoles() - jugador1.getGoles());
		return ranking;
	}

}
