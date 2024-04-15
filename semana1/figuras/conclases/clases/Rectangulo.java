package semana1.figuras.conclases.clases;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class Rectangulo extends FiguraGeometrica {

	public static final int NUM_LADOS = 4;

	public Rectangulo(double ladoMenor, double ladoMayor) {
		super((ladoMenor + ladoMayor / 2), NUM_LADOS);
	}

	@Override
	protected double calcularArea() {
		return this.getLado() * this.getNumLados();
	}

}
