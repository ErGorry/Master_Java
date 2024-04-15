package semana2.electrodomesticos.clases;

public class Television extends Electrodomestico {

	private double resolucion;
	private boolean sintonizadorTDT;

	private static final double RESOLUCION_DEFECTO = 20;
	private static final boolean TDT_DEFECTO = false;

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
	public double precioFinal() {
		if (resolucion > 40) {
			return sintonizadorTDT ? (super.precioFinal() * 1.3) + 50 : super.precioFinal() * 1.3;
		} else {
			return sintonizadorTDT ? super.precioFinal() + 50 : super.precioFinal();
		}
	}
}
