package semana2.pruebauno.clases;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import semana2.pruebauno.interfaces.Conducible;

/**
 * 
 * @author Admin 16-04-2024
 *
 */
public class Coche extends Vehiculo implements Conducible {

	private static final int NUM_RUEDAS = 4;
	private static final int MASA_MAXIMA_AUTO = 3500;
	private static final TipoCoche TIPO_COCHE_DEFAULT = TipoCoche.SEDAN;

	private final String matricula;

	public Coche(String marca, String modelo, String color, String tipo) {
		super(NUM_RUEDAS, MASA_MAXIMA_AUTO, validarTipoCoche(tipo), marca, modelo, color);
		this.matricula = generarMatricula();
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
	protected String generarMatricula() {
		StringBuilder sb = new StringBuilder();
		sb.append(randInt());
		sb.append(randInt());
		sb.append(randInt());
		sb.append(randInt());
		sb.append(' ');
		sb.append(randChar());
		sb.append(randChar());
		sb.append(randChar());
		return sb.toString();
	}

	@Override
	public void conducir() {
		this.setTiempoActualTrayecto(Duration.ZERO);
		this.setKilometrajeTrayecto(0);
		System.out.println("Se inicia el trayecto en el coche: " + this.getMarca() + " " + this.getModelo());
	}

	@Override
	public void avanzar(int kilometros, int velocidad) {
		this.setKilometraje(this.getKilometraje() + kilometros);
		this.setKilometrajeTrayecto(this.getKilometrajeTrayecto() + kilometros);
		this.setTiempoActualTrayecto(this.getTiempoActualTrayecto().plus(kilometros / velocidad, ChronoUnit.HOURS));
		System.out.println("Avanzamos " + kilometros + "km a velocidad de " + velocidad + "km/h");
		System.out.println("En este recorrido llevamos " + this.getKilometrajeTrayecto() + "km y "
				+ formatearDuration(getTiempoActualTrayecto()));
	}

	@Override
	public void parar() {
		System.out.println("-------Trayecto finalizado--------");
		System.out.println("-->Has recorrido : " + this.getKilometrajeTrayecto());
		System.out.println("-->Has tardado : " + formatearDuration(getTiempoActualTrayecto()));
		int velocidadMedia = Math
				.round(this.getKilometrajeTrayecto() / (getTiempoActualTrayecto().getSeconds() / 3600));
		System.out.println("-->La velocidad media fue de :" + velocidadMedia);
		this.setTiempoActualTrayecto(Duration.ZERO);

	}

	@Override
	public String toString() {
		return "Coche con matricula=" + matricula + ", " + super.toString();
	}

}
