package semana2.cuentabancaria.clases;

public class Cuenta {
	private String titular;
	private double saldo;
	private EstadoCuenta estado; // EstadoCuenta.OPERATIVA

	public Cuenta(String titular, double saldo, EstadoCuenta estado) {
		super();
		this.titular = titular;
		this.saldo = saldo;
		this.estado = estado;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public EstadoCuenta getEstado() {
		return estado;
	}

	public void setEstado(EstadoCuenta estado) {
		this.estado = estado;
	}

	public String getTitular() {
		return titular;
	}

	public void ingreso(double cantidad) throws Exception {
		if (cantidad < 0)
			throw new PersonalizadaException("La cantidad no puede ser negativa");
		if (cantidad > 1000)
			throw new PersonalizadaException("La cantidad a ingresar en cajero no puede ser superior a 1000.00€");
		if (estado.equals(EstadoCuenta.BLOQUEADA))
			throw new PersonalizadaException(
					"Debe ponerse en contacto con su oficina antes de realizar cualquier operacion");
		this.saldo += cantidad;
	}

	public double reintegro(double cantidad) throws Exception {
		if (cantidad < 0)
			throw new PersonalizadaException("La cantidad no puede ser negativa");
		if (cantidad > this.saldo)
			throw new PersonalizadaException("El saldo no es suficiente para hacer el reintegro");
		if (estado.equals(EstadoCuenta.BLOQUEADA))
			throw new PersonalizadaException(
					"Debe ponerse en contacto con su oficina antes de realizar cualquier operacion");

		return saldo;
	}

}
