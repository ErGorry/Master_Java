package semana1.figuras.coninterfaz.clases;

import semana1.figuras.coninterfaz.interfaz.Geometrizable;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class Cuadrado implements Geometrizable {

	private double lado;
	private double perimetro;
	private double area;
	private static final int NUM_LADOS = 4;

	public Cuadrado(double lado) {
		super();
		this.lado = lado;
		this.perimetro = calcularPerimetro(lado, NUM_LADOS);
		this.area = calcularArea();
	}

	public double getLado() {
		return conversor(lado);
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getPerimetro() {
		return conversor(perimetro);
	}

	public double getArea() {
		return conversor(area);
	}

	@Override
	public double calcularArea() {
		return this.lado * NUM_LADOS;
	}

}
