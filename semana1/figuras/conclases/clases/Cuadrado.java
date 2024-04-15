package semana1.figuras.conclases.clases;

public class Cuadrado extends FiguraGeometrica {

	public static final int NUM_LADOS = 4;

	public Cuadrado(double lado) {
		super(lado, NUM_LADOS);
	}

	@Override
	protected double calcularArea() {
		return this.getLado() * this.getNumLados();
	}
}
