package semana1.orquesta.clases;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public class GuitarraElectrica extends Guitarra {

	private int potencia;

	public GuitarraElectrica(String nombre, int numCuerdas, int potencia) {
		super(nombre, numCuerdas);
		this.potencia = potencia;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public void tocar() {
		System.out.println("Tocando la guitarra electrica");
	}
}
