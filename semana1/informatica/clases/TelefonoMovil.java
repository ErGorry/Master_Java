package semana1.informatica.clases;

public class TelefonoMovil extends ProductoInformatico {

	private String operador;

	public TelefonoMovil(int id, String modelo, float precio, int stock, String operador) {
		super(id, modelo, precio, stock);
		this.operador = operador;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	
}
