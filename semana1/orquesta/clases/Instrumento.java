package semana1.orquesta.clases;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public abstract class Instrumento {

	protected String nombre;
	protected Tipo tipo;

	protected Instrumento(String nombre, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void tocar() {
		System.out.println("Tocando el instrumento " + this.nombre);
	}

	public void afinar() {
		System.out.println("Afinando el instrumento " + this.nombre);
	}

}
