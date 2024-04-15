package semana1.enumerados1;

public enum Tutoriales {
	JAVA(40), HTML(30), MYSQL(25);

	int precio;

	private Tutoriales(int precio) {
		this.precio = precio;
	}

	public int mostrarPrecio() {
		return precio;
	}
}
