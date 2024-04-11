package semana1.herencia;

public abstract class Recurso {

	protected String descripcion;
	protected String nombre;
	protected Recurso(String nombre, String descripcion) {
		this.descripcion = descripcion;
		this.nombre = nombre;
		
	}
	public void decirNombre() {
		System.out.println("El nombre es: "+nombre);
	}
	public void decirDescripcion() {
		System.out.println("La descripcion es: "+descripcion);
	}
	
}
