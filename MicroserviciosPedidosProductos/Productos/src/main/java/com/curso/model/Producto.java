package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/**
 * Entidad de productos de la BBDD tabla=producto
 * @author Admin
 *
 */
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombre;
	private String descripcion;
	private int stock;
	private double precioUnitario;

	public Producto() {
	}

	public Producto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Producto(String nombre, String descripcion, int stock, double precioUnitario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}

	public Producto(int idProducto, String nombre, String descripcion, int stock, double precioUnitario) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
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
		return idProducto == other.idProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", stock=" + stock + ", precioUnitario=" + precioUnitario + "]";
	}

}
