package semana1.informatica.clases;

public class ProductoInformatico {

	private int id;
	private String modelo;
	private float precio;
	private int stock;
	public ProductoInformatico(int id, String modelo, float precio, int stock) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.precio = precio;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	 
	
}
