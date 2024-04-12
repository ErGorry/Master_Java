package semana1.animales.clases;

public abstract class Animal {
	private int numPatas;

	protected Animal(int numPatas) {
		this.numPatas = numPatas;
	}

	public abstract void comer();

	public void andar() {
		System.out.println("Este animal anda sobre " + numPatas + " patas.");
	}
}
