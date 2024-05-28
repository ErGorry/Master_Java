package com.curso.model;

public class Formacion {

	private String curso;
	private int asignaturas;
	private double precio;
	
	public Formacion() {
		// TODO Auto-generated constructor stub
	}

	public Formacion(Curso curso) {
		this.curso = curso.getNombre();
		this.asignaturas = curso.getDuracion()>50?10:5;
		this.precio = curso.getPrecio();
	}

	public Formacion(String nombre, int asignaturas, double precio) {
		this.curso = nombre;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Formacion [curso=" + curso + ", asignaturas=" + asignaturas + ", precio=" + precio + "]";
	}
}
