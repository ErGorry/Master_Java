package semana1.figuras.coninterfaz.clases;

import semana1.figuras.coninterfaz.interfaz.Geometrizable;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class Rectangulo implements Geometrizable {

	private double ladoMayor;
	private double ladoMenor;
	private double perimetro;
	private double area;
	private static final int NUM_LADOS = 4;

	public Rectangulo(double ladoMayor, double ladoMenor) {
		super();
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.perimetro = calcularPerimetro((ladoMenor + ladoMayor) / 2, NUM_LADOS);
		this.area = calcularArea();
	}

	public double getLadoMayor() {
		return conversor(ladoMayor);
	}

	public void setLadoMayor(double ladoMayor) {
		this.ladoMayor = ladoMayor;
	}

	public double getLadoMenor() {
		return conversor(ladoMenor);
	}

	public void setLadoMenor(double ladoMenor) {
		this.ladoMenor = ladoMenor;
	}

	public double getPerimetro() {
		return conversor(perimetro);
	}

	public double getArea() {
		return conversor(area);
	}

	@Override
	public double calcularArea() {
		return ladoMayor * ladoMenor;
	}

}
