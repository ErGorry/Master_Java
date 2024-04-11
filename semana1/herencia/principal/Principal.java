package semana1.herencia.principal;

import semana1.herencia.Aula;
import semana1.herencia.Ordenador;

public class Principal {

	public static void main(String[] args) {

		Aula a1 = new Aula("Aula1", "descripcion aula1", "bajo");
		a1.decirNombre();
		a1.decirDescripcion();

		Ordenador o1 = new Ordenador("Ordenador1", "Sobremesa", "Linux");
		o1.decirNombre();
		o1.decirDescripcion();
		o1.decirSistemaOperativo();

	}

}
