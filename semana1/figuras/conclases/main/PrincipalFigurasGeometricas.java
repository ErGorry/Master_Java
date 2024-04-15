package semana1.figuras.conclases.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import semana1.figuras.conclases.clases.Circulo;
import semana1.figuras.conclases.clases.Cuadrado;
import semana1.figuras.conclases.clases.FiguraGeometrica;
import semana1.figuras.conclases.clases.Pentagono;
import semana1.figuras.conclases.clases.Rectangulo;
import semana1.figuras.conclases.clases.TrianguloEquilatero;

public class PrincipalFigurasGeometricas {
	private static final int RANDOM = 100;

	public static void main(String[] args) {
		List<FiguraGeometrica> listaFiguras = crearFiguras();
		listarResultadosFiguras(listaFiguras);

	}

	private static void listarResultadosFiguras(List<FiguraGeometrica> listaFiguras) {
		for (Iterator<FiguraGeometrica> iterator = listaFiguras.iterator(); iterator.hasNext();) {
			FiguraGeometrica figura = iterator.next();
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("La figura: " + figura.getClass().getSimpleName() + " con lado de " + figura.getLado()
					+ " cm tiene: ");
			System.out.println("Un area de " + figura.getArea() + " cm2.");
			System.out.println("Un perimetro de " + figura.getPerimetro() + " cm.");
		}

	}

	private static List<FiguraGeometrica> crearFiguras() {
		List<FiguraGeometrica> listaFiguras = new ArrayList<>();
		listaFiguras.add(new Circulo(new Random(RANDOM).nextDouble()));
		listaFiguras.add(new Cuadrado(new Random(RANDOM).nextDouble()));
		listaFiguras.add(new Rectangulo(new Random(RANDOM).nextDouble(), new Random(RANDOM).nextDouble()));
		listaFiguras.add(new TrianguloEquilatero(new Random(RANDOM).nextDouble()));
		listaFiguras.add(new Pentagono(new Random(RANDOM).nextDouble()));
		return listaFiguras;
	}

}
