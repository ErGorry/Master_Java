package semana1.figuras.coninterfaz.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import semana1.figuras.coninterfaz.clases.Circulo;
import semana1.figuras.coninterfaz.clases.Cuadrado;
import semana1.figuras.coninterfaz.interfaz.Geometrizable;
import semana1.figuras.coninterfaz.clases.Pentagono;
import semana1.figuras.coninterfaz.clases.Rectangulo;
import semana1.figuras.coninterfaz.clases.TrianguloEquilatero;

/**
 * 
 * @author Admin 15-04-2024
 *
 */
public class PrincipalFigurasGeometricas {

	public static void main(String[] args) {
		List<Geometrizable> listaFiguras = crearFiguras();
		listarResultadosFiguras(listaFiguras);

	}

	private static void listarResultadosFiguras(List<Geometrizable> listaFiguras) {
		for (Iterator<Geometrizable> iterator = listaFiguras.iterator(); iterator.hasNext();) {
			Geometrizable figura = iterator.next();
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("La figura: " + figura.getClass().getSimpleName() + " tiene: ");
			System.out.println("Un area de " + figura.calcularArea() + " cm2.");
			// System.out.println("Un perimetro de " +
			// figura.calcularPerimetro(figura.getLado(), figura.getNumLados()) + " cm.");
		}

	}

	private static List<Geometrizable> crearFiguras() {
		List<Geometrizable> listaFiguras = new ArrayList<>();
		listaFiguras.add(new Circulo(new Random().nextDouble()));
		listaFiguras.add(new Cuadrado(new Random().nextDouble()));
		listaFiguras.add(new Rectangulo(new Random().nextDouble(), new Random().nextDouble()));
		listaFiguras.add(new TrianguloEquilatero(new Random().nextDouble()));
		listaFiguras.add(new Pentagono(new Random().nextDouble()));
		return listaFiguras;
	}

}
