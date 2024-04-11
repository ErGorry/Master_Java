package semana1.cuentabancaria.clase;

public class Cuenta {

	private String titular;
	private float cantidad;

	public Cuenta(String titular) {
		super();
		this.titular = titular;
	}

	public Cuenta(String titular, int cantidad) {
		super();
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public void ingresar(float ingreso) {
		if (ingreso > 0.0) {
			this.cantidad += ingreso;
		}
	}

	public void retirar(float retirada) {
		if (retirada > 0) {
			if (this.cantidad - retirada < 0.0) {
				this.cantidad = 0;
			} else {
				this.cantidad -= retirada;
			}
		}

	}

	@Override
	public String toString() {
		return "La cuenta de " + titular + " tiene un saldo en la cuenta de: " + cantidad + "€.";
	}

}
