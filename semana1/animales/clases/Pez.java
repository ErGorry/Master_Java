package semana1.animales.clases;

public class Pez extends Mascota {
	private static final int NUMERO_PATAS = 8;

	public Pez(String nombre) {
		super(NUMERO_PATAS, nombre);
	}

	@Override
	public void jugar() {
		System.out.println("Estoy nadando");

	}

}
