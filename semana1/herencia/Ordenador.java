package semana1.herencia;

public class Ordenador extends Recurso {
	protected String sistemaOperativo;

	public Ordenador(String nombre, String descripcion) {
		super(nombre, descripcion);
	}

	public Ordenador(String nombre, String descripcion, String sistemaOperativo) {
		super(nombre, descripcion);
		this.sistemaOperativo = sistemaOperativo;
	}
	
	public void decirSistemaOperativo() {
		System.out.println("El OS: " + this.sistemaOperativo);
	}

}
