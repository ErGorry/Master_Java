package semana1.animales.clases;

public class Spider extends Animal {
	private static final int NUMERO_PATAS = 8;

	public Spider() {
		super(NUMERO_PATAS);
	}

	@Override
	public void comer() {
		System.out.println("Las arañas comen mosquitos");

	}

}
