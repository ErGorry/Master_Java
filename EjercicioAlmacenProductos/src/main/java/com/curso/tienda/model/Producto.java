package com.curso.tienda.model;

import java.util.Objects;
/**
 * 
 * @author Admin 08-05-2024
 *
 */
public class Producto {

	private String nombre;
	private Categoria categoria;
	private double precio;
	private int stock;

	public Producto() {
		super();
	}

	public Producto(String nombre, String categoria, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.categoria = validarCategoria(categoria);
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria.toString();
	}

	public void setCategoria(String categoria) {
		this.categoria = validarCategoria(categoria);
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	private Categoria validarCategoria(String categoria2) {
		for (Categoria cat : Categoria.values()) {
			if (categoria2.equalsIgnoreCase(cat.toString())) {
				return cat;
			}
		}
		return Categoria.OTROS;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(categoria, nombre, precio, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return categoria == other.categoria && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock;
	}

	@Override
	public String toString() {
		return "Producto: " + nombre + ", categoria=" + categoria + ", precio=" + precio + "€, stock=" + stock
				+ " unidades.";
	}

}
