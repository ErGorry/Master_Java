package semana1.libro.main;

import semana1.libro.clases.Libro;

public class PruebaLibro {

	public static void main(String[] args) {
		Libro libro1 = new Libro("9783140464079", "El principito", "Antoine de Saint-Exupéry", 104);
		Libro libro2 = new Libro();
		libro2.setIsbn("9780060904791");
		libro2.setTitulo("Odisea");
		libro2.setAutor("Homero");
		libro2.setNumeroPaginas(384);

		calcularMaxPaginas(libro1,libro2);
	}

	private static void calcularMaxPaginas(Libro libro1, Libro libro2) {
		if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
			System.out.println("El libro "+libro1.getTitulo()+" tiene más páginas, "+libro1.getNumeroPaginas());
		} else if(libro2.getNumeroPaginas() > libro1.getNumeroPaginas()) {
			System.out.println("El libro "+libro2.getTitulo()+" tiene más páginas, "+libro2.getNumeroPaginas());
		} else {
			System.out.println("Ambos tienen el mismo número de páginas");
		}
		
	}

}
