package semana2.cuentabancaria.clases;


public class PersonalizadaException extends Exception {
	String texto;

	public PersonalizadaException(String texto) {
		super();
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "ExceptionPersonalizada [texto=" + texto + "]";
	}

}
