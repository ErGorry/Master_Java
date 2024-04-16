package semana2.pruebauno.clases;

/**
 * 
 * @author Admin 16-04-2024
 *
 */
public enum Color {
	BLANCO(800), NEGRO(800), GRIS(800), ROJO(1000), AZUL(1000), AMARILLO(1200), VERDE(1200), NARANJA(1200),
	MORADO(1200);

	int precio;

	Color(int precio) {
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}
}
