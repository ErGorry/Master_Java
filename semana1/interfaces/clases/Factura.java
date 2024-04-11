package semana1.interfaces.clases;

import semana1.interfaces.Imprimible;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public class Factura implements Imprimible {

	private String nFactura;
	private int codigoCliente;

	public Factura(String nFactura, int codigoCliente) {
		super();
		this.nFactura = nFactura;
		this.codigoCliente = codigoCliente;
	}

	public String getnFactura() {
		return nFactura;
	}

	public void setnFactura(String nFactura) {
		this.nFactura = nFactura;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	@Override
	public void informeCorto() {
		System.out.println("nFactura: " + this.nFactura);

	}

	@Override
	public void informeLargo() {
		System.out.println("nFactura: " + this.nFactura + ", Código de cliente: " + this.codigoCliente);

	}

}
