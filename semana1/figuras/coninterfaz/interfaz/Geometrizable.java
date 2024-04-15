package semana1.figuras.coninterfaz.interfaz;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public interface Geometrizable {
	

	abstract double calcularArea();

	default double calcularPerimetro(double lado, int numLados) {
		if (numLados == 0) {
			return 2.0 * Math.PI * lado;
		}
		return numLados * lado;
	}

	default double conversor(double num) {
		int conversor = (int) Math.floor(num * 1000);
		return (double) conversor / 1000;
	}
}
