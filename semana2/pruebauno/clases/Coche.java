package semana2.pruebauno.clases;

/**
 * 
 * @author Admin 16-04-2024
 *
 */
public class Coche extends Vehiculo {

	private static final int NUM_RUEDAS = 4;
	private static final int MASA_MAXIMA_AUTO = 3500;
	private static final TipoCoche TIPO_COCHE_DEFAULT = TipoCoche.SEDAN;

	public Coche(String marca, String modelo, String color, String tipo) {
		super(NUM_RUEDAS, MASA_MAXIMA_AUTO, validarPlazasCoche(tipo), marca, modelo, color);
		super.matricula = generarMatricula();
	}

	private static int validarPlazasCoche(String tipo2) {
		for (TipoCoche modelo : TipoCoche.values()) {
			if (tipo2.equalsIgnoreCase(modelo.toString())) {
				return modelo.plazas;
			}
		}
		return TIPO_COCHE_DEFAULT.plazas;
	}

}
