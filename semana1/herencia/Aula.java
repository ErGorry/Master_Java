package semana1.herencia;

public class Aula extends Recurso {

	private String localizacion;

	public Aula(String nombre, String descripcion) {
		super(nombre, descripcion);
	}

	public Aula(String nombre, String descripcion, String localizacion) {
		super(nombre, descripcion);
		this.localizacion = localizacion;
	}
}
