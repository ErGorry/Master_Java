package semana2.pruebauno.clases;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Motocicleta extends Vehiculo {

	private static final int NUM_RUEDAS = 2;
	private static final int MMA = 350;
	private static final int NUM_PLAZAS = 2;
	private static final int AUTONOMIA = 350;

	private int potencia;

	public Motocicleta(String marca, String modelo, String color, int potencia) {
		super(NUM_RUEDAS, MMA, NUM_PLAZAS, marca, modelo, color);
		super.matricula = generarMatricula();
		this.potencia = potencia;
	}

	@Override
	public void conducir() {
		this.setTiempoActualTrayecto(Duration.ofNanos(0));
		this.setKilometrajeTrayecto(0);
		System.out.println("Se inicia la conducción en la motocicleta: " + this.getMarca() + " " + this.getModelo());

	}

	@Override
	public void avanzar(int kilometros, int velocidad) {
		if (this.potencia > 30) {
			velocidad += this.potencia / 2;
		}
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
		int numDepositos = this.getKilometrajeTrayecto() / AUTONOMIA;
		System.out.println("-->Hemos parado a repostar un total de: " + numDepositos + " veces");
		this.setTiempoActualTrayecto(Duration.ofNanos(0));
		this.setKilometrajeTrayecto(0);
	}

	@Override
	public String toString() {
		return "\nMotocicleta con matricula=" + matricula + ",con potencia=" + potencia + ", " + super.toString();
	}

}
