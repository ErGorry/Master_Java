package semana2.electrodomesticos.clases;

import semana2.electrodomesticos.interfaz.Comprable;

public class Television extends Electrodomestico implements Comprable {

	private static final double RESOLUCION_DEFECTO = 20;
	private static final boolean TDT_DEFECTO = false;

	private double resolucion;
	private boolean sintonizadorTDT;

	public Television() {
		super();
	}

	public Television(double precio, double peso) {
		super(precio, peso);
		this.resolucion = RESOLUCION_DEFECTO;
		this.sintonizadorTDT = TDT_DEFECTO;
	}

	public Television(double resolucion, boolean sintonizadorTDT) {
		super();
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
	}

	public double getResolucion() {
		return resolucion;
	}

	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}

	@Override
	public double getPrecioFinal() {
		if (resolucion > 40) {
			return sintonizadorTDT ? (super.precioFinal() * 1.3) + 50 : super.precioFinal() * 1.3;
		} else {
			return sintonizadorTDT ? super.precioFinal() + 50 : super.precioFinal();
		}
	}
}
