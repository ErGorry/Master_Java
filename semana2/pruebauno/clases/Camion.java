package semana2.pruebauno.clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Admin 17-04-2024
 *
 */
public class Camion extends Vehiculo {

	private static final int NUM_RUEDAS = 8;
	private static final int MASA_MAXIMA_AUTO = 7500;
	private static final int NUM_PLAZAS = 1;
	private static final int LIM_VELOCIDAD = 90;

	private List<Integer> tacografo;

	public Camion(String marca, String modelo, String color) {
		super(NUM_RUEDAS, MASA_MAXIMA_AUTO, NUM_PLAZAS, marca, modelo, color);
		super.matricula = generarMatricula();
		this.tacografo = new ArrayList<>();
	}

	@Override
	public void conducir() {
		super.conducir();
		this.tacografo.clear();
	}

	@Override
	public void avanzar(int kilometros, int velocidad) {
		velocidad = velocidad > LIM_VELOCIDAD ? LIM_VELOCIDAD : velocidad;
		this.tacografo.add(velocidad);

		super.avanzar(kilometros, velocidad);
	}

	@Override
	public void parar() {
		System.out.print("-->El tacografo tiene las siguientes lecturas: ");
		for (Iterator<Integer> iterator = tacografo.iterator(); iterator.hasNext();) {
			Integer velocidad = iterator.next();
			System.out.print(velocidad + "KM/H, ");
		}
		System.out.println();
		this.tacografo.clear();

		super.parar();
	}

	@Override
	public String toString() {
		return "\nCamion con matricula=" + matricula + "," + super.toString();
	}

}
