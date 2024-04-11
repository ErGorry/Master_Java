package semana1.cafetera.clase;

public class Cafetera {

	private int capacidadMax;
	private int cantidad;
	private static final int CAPACIDAD_MAXIMA = 1000;

	public Cafetera() {
		super();
		this.capacidadMax = CAPACIDAD_MAXIMA;
	}

	public Cafetera(int capacidadMax) {
		super();
		this.capacidadMax = capacidadMax;
		this.cantidad = capacidadMax;
	}

	public Cafetera(int capacidadMax, int cantidadActual) {
		super();
		this.capacidadMax = capacidadMax;
		this.cantidad = cantidadActual;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void llenarCafetera() {
		this.cantidad = this.capacidadMax;
		escribirMensaje("La cafetera se ha llenado con " + this.cantidad);
	}

	public void servirTaza(int capacidadTaza) {
		if (capacidadTaza + this.cantidad < this.capacidadMax) {
			if (this.cantidad - capacidadTaza < 0) {

				escribirMensaje("La taza se ha llenado con lo que quedaba en la cafetera, " + this.cantidad);
				this.cantidad = 0;
			} else {
				this.cantidad -= capacidadTaza;
				escribirMensaje("La taza se ha llenado con lo indicado, queda en la cafetera: " + this.cantidad);
			}
		} else {
			System.out.println("No podemos quitar una cantidad negativa de café a una taza");
		}
	}

	public void vaciarCafetera() {
		this.cantidad = 0;
		System.out.println("La cafetera está vacía ahora.");
	}

	public void agregarCafe(int agregado) {
		if (agregado > 0) {
			if (agregado + this.cantidad >= this.capacidadMax) {
				this.cantidad = this.capacidadMax;
				escribirMensaje("La cafetera se ha llenado tiene " + this.cantidad);
			} else {
				this.cantidad += agregado;
				escribirMensaje("La cafetera se ha llenado con lo indicado, queda en la cafetera: " + this.cantidad);
			}
		} else {
			System.out.println("No podemos introducir una cantidad de cafe negativa en la cafetera");

		}
	}

	private void escribirMensaje(String mensaje) {
		System.out.println(mensaje + " ml de café.");

	}

}
