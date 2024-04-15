package semana1.figuras.conclases.clases;

/**
 * 
 * @author Admin 
 *
 */
public class Circulo extends FiguraGeometrica {
	private static final int NUM_LADOS = 0;

	public Circulo(double radio) {
		super(radio, NUM_LADOS);
	}

	@Override
	protected double calcularArea() {
		return Math.PI * this.getLado() * this.getLado();

	}

}
