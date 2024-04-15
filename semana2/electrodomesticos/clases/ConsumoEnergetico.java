package semana2.electrodomesticos.clases;

public enum ConsumoEnergetico {
	A(100), B(80), C(60), D(50), E(30), F(10);
	double precioExtra;

	ConsumoEnergetico(double precio) {
		this.precioExtra = precio;
	}
	double getPrecio() {
		return this.precioExtra;
	}
	
}
