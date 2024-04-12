package semana1.animales.clases;

public class Gato extends Mascota {
	private static final int NUMERO_PATAS = 4;

	public Gato(String nombre) {
		super(NUMERO_PATAS, nombre);
	}

	@Override
	public void jugar() {
		System.out.println("A " + super.getNombre() + " le gusta jugar con pelotas");

	}
}
