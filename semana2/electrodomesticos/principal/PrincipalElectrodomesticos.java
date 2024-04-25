package semana2.electrodomesticos.principal;

import java.util.ArrayList;
import java.util.List;

import semana2.electrodomesticos.clases.Electrodomestico;
import semana2.electrodomesticos.clases.Lavadora;
import semana2.electrodomesticos.clases.Television;

public class PrincipalElectrodomesticos {

	public static void main(String[] args) {
		List<Electrodomestico> electro = crearElectrodomesticos();
		mostrarDatos(electro);

	}

	private static void mostrarDatos(List<Electrodomestico> electro) {
		if (!electro.isEmpty()) {
			double precioElectro = 0;
			double precioTele = 0;
			double precioLava = 0;
			for (Electrodomestico electrodomestico : electro) {
				if (electrodomestico instanceof Television tele) {
					precioTele += tele.getPrecioFinal();
					precioElectro += tele.getPrecioFinal();

				} else if (electrodomestico instanceof Lavadora lava) {
					precioLava += lava.getPrecioFinal();
					precioElectro += lava.getPrecioFinal();
				}

			}
			System.out.println("Precio total de electrodomesticos en el array: " + precioElectro);
			System.out.println("Precio total de televisiones en el array: " + precioTele);
			System.out.println("Precio total de lavadoras en el array: " + precioLava);
		} else {
			System.out.println("No se creo correctamente el array");
		}

	}

	private static List<Electrodomestico> crearElectrodomesticos() {
		try {
			List<Electrodomestico> lista = new ArrayList<>();
			lista.add(new Lavadora(500, 80));
			lista.add(new Lavadora());
			lista.add(new Lavadora(250, 15));
			lista.add(new Lavadora(35));
			lista.add(new Lavadora(10));
			lista.add(new Television());
			lista.add(new Television(50, true));
			lista.add(new Television(35, false));
			lista.add(new Television(800, 30));
			lista.add(new Television(300, 10));
			return lista;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ArrayList<>();
		}

	}

}
