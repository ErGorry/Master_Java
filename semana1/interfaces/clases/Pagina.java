package semana1.interfaces.clases;

import semana1.interfaces.Imprimible;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public class Pagina implements Imprimible {

	private String nPagina;
	private String nLineas;

	public Pagina(String nPagina, String nLineas) {
		super();
		this.nPagina = nPagina;
		this.nLineas = nLineas;
	}

	public String getnPagina() {
		return nPagina;
	}

	public void setnPagina(String nPagina) {
		this.nPagina = nPagina;
	}

	public String getnLineas() {
		return nLineas;
	}

	public void setnLineas(String nLineas) {
		this.nLineas = nLineas;
	}

	@Override
	public void informeCorto() {
		System.out.println("nPágina: " + this.nPagina);

	}

	@Override
	public void informeLargo() {
		System.out.println("nPágina: " + this.nPagina + ", nLíneas: " + this.nLineas);

	}

}
