package semana1.animales.clases;

public abstract class Mascota extends Animal {
	private String nombre;

	protected Mascota(int numPatas, String nombre) {
		super(numPatas);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void comer() {

	}

	public abstract void jugar();

}
