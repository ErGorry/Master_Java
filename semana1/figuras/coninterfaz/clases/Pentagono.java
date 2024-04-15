package semana1.figuras.coninterfaz.clases;

import semana1.figuras.coninterfaz.interfaz.Geometrizable;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class Pentagono implements Geometrizable {

	private double lado;
	private double perimetro;
	private double area;
	private double apotema;
	private static final double RADIANES_72 = 0.73;
	private static final int NUM_LADOS = 5;

	public Pentagono(double lado) {
		super();
		this.lado = lado;
		this.apotema = setApotema(lado);
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

	private double setApotema(double lado) {
		return lado / (2 * Math.tan(RADIANES_72));
	}

	@Override
	public double calcularArea() {
		return 5 * (this.getLado() * this.apotema) / 2;
	}

}
