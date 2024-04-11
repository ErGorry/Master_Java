package semana1.ligafutbol.clases;

public class Jugador {

	private String nombre;
	private int goles;
	//private int dorsal;

	public Jugador(String nombre/*, int dorsal*/) {
		super();
		this.nombre = nombre;
	//	this.dorsal = dorsal;
		this.goles = 0;

	}

	public String getNombre() {
		return nombre;
	}

	public int getGoles() {
		return goles;
	}

	/*public int getDorsal() {
		return dorsal;
	}*/

	public void addGol() {
		this.goles += 1;

	}

}
