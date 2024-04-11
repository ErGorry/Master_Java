package semana1.orquesta.clases;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public class Flauta extends Instrumento {

	private String modelo;

	public Flauta(String nombre, String modelo) {
		super(nombre, Tipo.CUERDA);
		this.modelo = modelo;
	}

	@Override
	public void tocar() {
		super.tocar();
		System.out.print(" Soplando...\n");

	}

}
