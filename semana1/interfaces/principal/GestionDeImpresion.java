package semana1.interfaces.principal;

import semana1.interfaces.Imprimible;
import semana1.interfaces.clases.Factura;
import semana1.interfaces.clases.Pagina;

/**
 * 
 * @author Admin 11-04-2024
 *
 */
public class GestionDeImpresion {

	public static void main(String[] args) {
		Imprimible pagina1 = new Pagina("Nombre de la primera página", "Líneas de la primera página");
		Imprimible factura1 = new Factura("Nombre de la primera factura", 108);

		System.out.println("Información de Página: ");
		pagina1.informeCorto();
		pagina1.informeLargo();

		System.out.println("Información de Facturas: ");
		factura1.informeCorto();
		factura1.informeLargo();

	}

}
