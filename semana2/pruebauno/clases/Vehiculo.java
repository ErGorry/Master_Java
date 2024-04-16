package semana2.pruebauno.clases;

import java.time.Duration;
import java.util.Random;

/**
 * 
 * @author Admin 16-04-2024
 *
 */
public abstract class Vehiculo {

	private int numRuedas;
	private int mMA;// Masa maxima autorizada
	private int plazas;
	private Color color;
	private String marca;
	private String modelo;
	private Duration tiempoActualTrayecto;
	private int kilometraje;
	private int kilometrajeTrayecto;

	public Vehiculo(int numRuedas, int mMA, int plazas, String marca, String modelo, String color) {
		super();
		this.color = validarColor(color);
		this.numRuedas = numRuedas;
		this.mMA = mMA;
		this.plazas = plazas;
		this.marca = marca;
		this.modelo = modelo;
		this.tiempoActualTrayecto = Duration.ZERO;
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

	protected abstract String generarMatricula();

	protected static String formatearDuration(Duration duration) {
		long segundos = duration.getSeconds();
		String cadena = String.format("%d:%02d:%02d", segundos / 3600, (segundos % 3600) / 60, segundos % 60);
		return cadena;
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
		System.out.println("Color actual del " + this.getClass().getSimpleName() + " es " + this.color.toString());
		this.color = validarColor(color);
		System.out.println("Hemos pintado de color: " + this.color.toString());
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

}
