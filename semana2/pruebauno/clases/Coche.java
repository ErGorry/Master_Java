package semana2.pruebauno.clases;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author Admin 16-04-2024
 *
 */
public class Coche extends Vehiculo {

	private static final int NUM_RUEDAS = 4;
	private static final int MASA_MAXIMA_AUTO = 3500;
	private static final TipoCoche TIPO_COCHE_DEFAULT = TipoCoche.SEDAN;

	public Coche(String marca, String modelo, String color, String tipo) {
		super(NUM_RUEDAS, MASA_MAXIMA_AUTO, validarTipoCoche(tipo), marca, modelo, color);
		super.matricula = generarMatricula();
	}

	public String getMatricula() {
		return matricula;
	}

	private static int validarTipoCoche(String tipo2) {
		for (TipoCoche modelo : TipoCoche.values()) {
			if (tipo2.equalsIgnoreCase(modelo.toString())) {

				return modelo.plazas;
			}
		}
		return TIPO_COCHE_DEFAULT.plazas;
	}

	@Override
	public void conducir() {
		this.setTiempoActualTrayecto(Duration.ofNanos(0));
		this.setKilometrajeTrayecto(0);
		System.out.println("Se inicia la conducción en el coche: " + this.getMarca() + " " + this.getModelo());
	}

	@Override
	public void avanzar(int kilometros, int velocidad) {
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
		this.setTiempoActualTrayecto(Duration.ofNanos(0));
		this.setKilometrajeTrayecto(0);

	}

	@Override
	public String toString() {
		return "\nCoche con matricula=" + matricula + ", " + super.toString();
	}

}
