package semana1.figuras.conclases.clases;

public abstract class FiguraGeometrica {

	private int numLados;
	private double lado;
	private double perimetro;
	private double area;

	protected FiguraGeometrica(double lado, int numLados) {
		this.lado = decimales(lado);
		this.numLados = numLados;
		this.perimetro = decimales(calcularPerimetro(lado, numLados));
		this.area = decimales(this.calcularArea());
	}

	public int getNumLados() {
		return numLados;
	}

	public double getLado() {
		return lado;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public double getArea() {
		return area;
	}

	protected double decimales(double num) {
		int conversor = (int) Math.floor(num * 1000);
		return (double) conversor / 1000;
	}

	protected abstract double calcularArea();

	private double calcularPerimetro(double lado, int numLados) {
		if (numLados == 0) {
			return 2.0 * Math.PI * lado;
		}
		return numLados * lado;
	}
}
