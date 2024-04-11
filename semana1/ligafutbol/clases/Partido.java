package semana1.ligafutbol.clases;

import java.util.Iterator;
import java.util.List;

public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private List<Jugador> golesLocal;
	private List<Jugador> golesVisitante;
	private static final int PUNTOS_VICTORIA = 3;
	private static final int PUNTOS_EMPATE = 1;

	public Partido(Equipo equipoLocal, List<Jugador> golesLocal, Equipo equipoVisitante, List<Jugador> golesVisitante) {

		this.equipoLocal = equipoLocal;
		this.golesLocal = golesLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesVisitante = golesVisitante;
		actualizarDatosPartido();
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public List<Jugador> getGolesLocal() {
		return golesLocal;
	}

	public List<Jugador> getGolesVisitante() {
		return golesVisitante;
	}

	private void actualizarDatosPartido() {
		this.equipoLocal.addPartido(this);
		this.equipoVisitante.addPartido(this);
		actualizarResultado();

	}

	private void actualizarResultado() {
		if (!this.golesLocal.isEmpty()) {
			for (Iterator<Jugador> ite = golesLocal.iterator(); ite.hasNext();) {
				Jugador jugador = (Jugador) ite.next();
				jugador.addGol();
			}
		}
		if (!this.golesVisitante.isEmpty()) {
			for (Iterator<Jugador> ite = golesVisitante.iterator(); ite.hasNext();) {
				Jugador jugador = ite.next();
				jugador.addGol();
			}
		}
		if (this.golesLocal.size() > this.golesVisitante.size()) {
			this.equipoLocal.addPuntos(PUNTOS_VICTORIA);
		} else if (this.golesLocal.size() == this.golesVisitante.size()) {
			this.equipoLocal.addPuntos(PUNTOS_EMPATE);
			this.equipoVisitante.addPuntos(PUNTOS_EMPATE);
		} else {
			this.equipoVisitante.addPuntos(PUNTOS_VICTORIA);
		}
	}

	@Override
	public String toString() {
		return equipoLocal.getNombre() + " " + golesLocal.size() + " - " + equipoVisitante.getNombre() + " " + golesVisitante.size();
	}

}
