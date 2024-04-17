package semana2.pruebauno.clases;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion extends Vehiculo {

	private static final int NUM_RUEDAS = 8;
	private static final int MMA = 7500;
	private static final int NUM_PLAZAS = 1;
	private static final int LIM_VELOCIDAD = 90;

	private List<Integer> tacografo;

	public Camion(String marca, String modelo, String color) {
		super(NUM_RUEDAS, MMA, NUM_PLAZAS, marca, modelo, color);
		super.matricula = generarMatricula();
		this.tacografo = new ArrayList<>();
	}

	@Override
	public void conducir() {
		this.setTiempoActualTrayecto(Duration.ofNanos(0));
		this.setKilometrajeTrayecto(0);
		this.tacografo.clear();
		System.out.println("Se inicia la conducción en el camion: " + this.getMarca() + " " + this.getModelo());
	}

	@Override
	public void avanzar(int kilometros, int velocidad) {
		if (velocidad > LIM_VELOCIDAD) {
			velocidad = LIM_VELOCIDAD;
		}
		this.tacografo.add(velocidad);
		this.setKilometraje(this.getKilometraje() + kilometros);
		this.setKilometrajeTrayecto(this.getKilometrajeTrayecto() + kilometros);
		float horas = (float) kilometros / (float) velocidad;
		float segundosTrayecto = horas * 3600;
		this.setTiempoActualTrayecto(
				this.getTiempoActualTrayecto().plus(Math.round(segundosTrayecto), ChronoUnit.SECONDS));
		System.out.println("Avanzamos " + kilometros + "KM a velocidad de " + velocidad + "KM/H");
		System.out.println("Acumulamos " + this.getKilometrajeTrayecto() + " KM y "
				+ formatearDuration(getTiempoActualTrayecto()));

	}

	@Override
	public void parar() {
		pintarResumenFinal();
		System.out.print("-->El tacografo tiene las siguientes lecturas: ");
		for (Iterator<Integer> iterator = tacografo.iterator(); iterator.hasNext();) {
			Integer velocidad = iterator.next();
			System.out.print(velocidad + ", ");

		}
		this.setTiempoActualTrayecto(Duration.ofNanos(0));
		this.setKilometrajeTrayecto(0);
		this.tacografo.clear();

	}

	@Override
	public String toString() {
		return "\nCamion con matricula=" + matricula + "," + super.toString();
	}

}
