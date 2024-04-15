package semana1.figuras.conclases.clases;

public class TrianguloEquilatero extends FiguraGeometrica {

	private static final int NUM_LADOS = 3;
	private static final double RELACION_ALTURA = Math.sqrt(3) / 2;

	public TrianguloEquilatero(double lado) {
		super(lado, NUM_LADOS);
	}

	@Override
	protected double calcularArea() {
		return this.getLado() * (this.getLado() * RELACION_ALTURA) / 2;
	}

}
