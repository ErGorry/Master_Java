package com.curso.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private String comprador;
	private String nombreProducto;
	private int unidades;
	private LocalDate fechaPedido;
	private double precioTotal;

	public Pedido() {
	}

	public Pedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Pedido(String comprador, String nombreProducto, int unidades) {
		this.comprador = comprador;
		this.nombreProducto = nombreProducto;
		this.unidades = unidades;
	}

	public Pedido(int idPedido, String comprador, String nombreProducto, int unidades, LocalDate fechaPedido,
			double precioTotal) {
		this.idPedido = idPedido;
		this.comprador = comprador;
		this.nombreProducto = nombreProducto;
		this.unidades = unidades;
		this.fechaPedido = fechaPedido;
		this.precioTotal = precioTotal;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", comprador=" + comprador + ", nombreProducto=" + nombreProducto
				+ ", unidades=" + unidades + ", fechaPedido=" + fechaPedido + ", precioTotal=" + precioTotal + "]";
	}

}
