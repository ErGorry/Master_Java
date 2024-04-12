package semana1.ligafutbol.clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Liga {

	private List<Equipo> liga;
	private  List<Partido> historico;

	public Liga(List<Equipo> liga) {
		super();
		this.liga = liga;
		this.historico = new ArrayList<>();
	}

	public void addPartido(Partido partido) {
		historico.add(partido);
	}

	public List<Equipo> getLiga() {
		return liga;
	}

	public String[] obtenerClasificacion() {
		String[] clasificacion = new String[liga.size()];
		int cont = 0;
		liga.sort((equipo1, equipo2) -> equipo2.getPuntosClasificacion() - equipo1.getPuntosClasificacion());
		for (Iterator<Equipo> ite = liga.iterator(); ite.hasNext();) {
			Equipo equipo = ite.next();
			clasificacion[cont++] = cont + "º / " + equipo.getNombre() + " / " 
									+ equipo.getPuntosClasificacion() + " puntos.";
		}
		return clasificacion;
	}
}
