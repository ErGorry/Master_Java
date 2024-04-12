package semana1.orquesta.clases;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public class Tambor extends Instrumento {

	private String tamanho;

	public Tambor(String nombre, String tamanho) {
		super(nombre, Tipo.PERCUSION);
		this.tamanho = tamanho;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void aporrear() {
		System.out.println("Aporreando tambor " + this.nombre + " es " + this.tamanho);
	}

}
