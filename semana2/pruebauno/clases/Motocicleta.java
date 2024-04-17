package semana2.pruebauno.clases;


/**
 * 
 * @author Admin 17-04-2024
 *
 */
public class Motocicleta extends Vehiculo {

	private static final int NUM_RUEDAS = 2;
	private static final int MASA_MAXIMA_AUTO = 350;
	private static final int NUM_PLAZAS = 2;
	private static final int AUTONOMIA = 350;

	private int potencia;

	public Motocicleta(String marca, String modelo, String color, int potencia) {
		super(NUM_RUEDAS, MASA_MAXIMA_AUTO, NUM_PLAZAS, marca, modelo, color);
		super.matricula = generarMatricula();
		this.potencia = potencia;
	}

	@Override
	public void avanzar(int kilometros, int velocidad) {
		if (this.potencia > 30) {
			velocidad += this.potencia / 2;
		}
		super.avanzar(kilometros, velocidad);


	}

	@Override
	public void parar() {
		
		int numDepositos = this.getKilometrajeTrayecto() / AUTONOMIA;
		System.out.println("-->Hemos parado a repostar un total de: " + numDepositos + " veces");
		
		super.parar();
		
	}

	@Override
	public String toString() {
		return "\nMotocicleta con matricula=" + matricula + ",con potencia=" + potencia + ", " + super.toString();
	}

}
