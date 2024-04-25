package semana2.electrodomesticos.clases;

import semana2.electrodomesticos.interfaz.Comprable;

public class Lavadora extends Electrodomestico  implements Comprable{

	private static final double CARGA_DEFECTO = 5;
	
	private double carga;

	

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
	public double getPrecioFinal() {
		if (carga > 30) {
			return super.precioFinal() + 50;
		}
		return super.precioFinal();
	}

}
