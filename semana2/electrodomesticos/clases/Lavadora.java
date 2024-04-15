package semana2.electrodomesticos.clases;

public class Lavadora extends Electrodomestico {

	private double carga;

	private static final double CARGA_DEFECTO = 5;

	public Lavadora() {
		super();
		this.carga = CARGA_DEFECTO;
	}

	public Lavadora(double carga) {
		super();
		this.carga = carga;
	}

	public Lavadora(double precio, double peso) {
		super(precio, peso);
		this.carga = CARGA_DEFECTO;
	}

	public double getCarga() {
		return carga;
	}

	@Override
	public double precioFinal() {
		if (carga > 30) {
			return super.precioFinal() + 50;
		}
		return super.precioFinal();
	}

}
