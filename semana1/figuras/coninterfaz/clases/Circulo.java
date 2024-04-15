package semana1.figuras.coninterfaz.clases;

import semana1.figuras.coninterfaz.interfaz.Geometrizable;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class Circulo implements Geometrizable {

	private double radio;
	private double perimetro;
	private double area;
	private static final int NUM_LADOS = 0;

	public Circulo(double radio) {
		super();
		this.radio = radio;
		this.area = calcularArea();
		this.perimetro = calcularPerimetro(radio, NUM_LADOS);
	}

	public double getRadio() {
		return conversor(this.radio);
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getPerimetro() {
		return conversor(perimetro);
	}

	public double getArea() {
		return conversor(area);
	}

	@Override
	public double calcularArea() {
		return Math.PI * this.getRadio() * this.getRadio();
	}
}
