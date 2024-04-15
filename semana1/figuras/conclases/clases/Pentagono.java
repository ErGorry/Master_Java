package semana1.figuras.conclases.clases;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class Pentagono extends FiguraGeometrica {

	private static final int NUM_LADOS = 5;
	private static final double RADIANES_72 = 0.73;

	public Pentagono(double lado) {
		super(lado, NUM_LADOS);
	}

	@Override
	protected double calcularArea() {

		return 5 * (this.getLado() * (this.getLado() / (2 * Math.tan(RADIANES_72)))) / 2;
	}

}
