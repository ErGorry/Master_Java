package semana2.pruebauno.clases;

import java.time.Duration;
import java.util.Random;

import semana2.pruebauno.interfaces.Conducible;

/**
 * 
 * @author Admin 16-04-2024
 *
 */
public abstract class Vehiculo implements Conducible {

	private int numRuedas;
	private int mMA;// Masa maxima autorizada
	private int plazas;
	private Color color;
	private String marca;
	private String modelo;
	private Duration tiempoActualTrayecto;
	private int kilometraje;
	private int kilometrajeTrayecto;
	protected String matricula;

	public Vehiculo(int numRuedas, int mMA, int plazas, String marca, String modelo, String color) {
		super();
		this.color = validarColor(color);
		this.numRuedas = numRuedas;
		this.mMA = mMA;
		this.plazas = plazas;
		this.marca = marca;
		this.modelo = modelo;
		this.tiempoActualTrayecto = Duration.ofSeconds(0);
		this.kilometraje = 0;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Duration getTiempoActualTrayecto() {
		return tiempoActualTrayecto;
	}

	public void setTiempoActualTrayecto(Duration tiempoActualTrayecto) {
		this.tiempoActualTrayecto = tiempoActualTrayecto;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public int getKilometrajeTrayecto() {
		return kilometrajeTrayecto;
	}

	public void setKilometrajeTrayecto(int kilometrajeTrayecto) {
		this.kilometrajeTrayecto = kilometrajeTrayecto;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public int getmMA() {
		return mMA;
	}

	public int getPlazas() {
		return plazas;
	}

	public Color getColor() {
		return color;
	}

	protected static String formatearDuration(Duration duration) {
		long segundosTotales = duration.getSeconds();
		long segundos = segundosTotales % 60;
		segundosTotales -= segundos;
		long minutos = (segundosTotales % 3600) / 60;
		segundosTotales -= minutos * 60;
		long horas = segundosTotales / 3600;
		return String.format("%d Horas %02d Minutos %02d Segundos", horas, minutos, segundos);
		// return duration.toString();
	}

	private Color validarColor(String color2) {
		for (Color color : Color.values()) {
			if (color2.equalsIgnoreCase(color.toString())) {
				return color;
			}
		}
		System.out.println("No disponemos de ese color, se pintará en blanco");
		return Color.BLANCO;
	}

	public void pintarVehiculo(String color) {
		System.out.println("Color actual del " + this.getClass().getSimpleName() + " es " + this.color.toString()
				+ " y lo pintaremos.");
		this.color = validarColor(color);
		System.out.println("Hemos pintado de color: " + this.color.toString() + " el precio del trabajo es "
				+ this.color.precio + "€.");
	}

	protected static int randInt() {
		Random rand = new Random();
		int min = 1;
		int max = 9;
		return rand.nextInt((max - min) + 1) + min;
	}

	protected static char randChar() {
		Random rand = new Random();
		int min = 65;
		int max = 90;
		return (char) (rand.nextInt((max - min) + 1) + min);
	}

	protected void pintarResumenFinal() {
		System.out.println("-------Trayecto finalizado--------");
		System.out.println("-->Has recorrido : " + this.getKilometrajeTrayecto() + "KM.");
		System.out.println("-->Has tardado : " + formatearDuration(this.getTiempoActualTrayecto()) + ".");
		float horas = (float) this.getTiempoActualTrayecto().getSeconds() / 3600;
		float velocidadMedia = this.getKilometrajeTrayecto() / horas;
		System.out.println(String.format("-->La velocidad media ha sido de: %.2f KM/H.", velocidadMedia));
	}

	@Override
	public String toString() {
		return "numRuedas=" + numRuedas + ", mMA=" + mMA + "kg, plazas=" + plazas + ", color=" + color.toString()
				+ ", marca=" + marca + ", modelo=" + modelo + ", kilometraje=" + kilometraje;
	}

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
	};

	public abstract void conducir();

	public abstract void avanzar(int metros, int velocidad);

	public abstract void parar();

}
