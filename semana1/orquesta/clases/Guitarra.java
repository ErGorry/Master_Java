package semana1.orquesta.clases;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public class Guitarra extends Instrumento {

	private int numCuerdas;

	public Guitarra(String nombre, int numCuerdas) {
		super(nombre, Tipo.CUERDA);
	}

	public int getNumCuerdas() {
		return numCuerdas;
	}

	public void setNumCuerdas(int numCuerdas) {
		this.numCuerdas = numCuerdas;
	}

}
