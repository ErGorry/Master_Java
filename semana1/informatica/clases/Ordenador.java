package semana1.informatica.clases;

public class Ordenador extends ProductoInformatico {
	String[] caracteristicas;

	public Ordenador(int id, String modelo, float precio, int stock, String[] caracteristicas) {
		super(id, modelo, precio, stock);
		this.caracteristicas = caracteristicas;
	}

	public String[] getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
