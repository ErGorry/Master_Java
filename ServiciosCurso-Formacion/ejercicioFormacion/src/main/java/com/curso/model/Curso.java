package com.curso.model;

import java.util.Objects;


public class Curso {

	private int codCurso;
	private String nombre;
	private int duracion;
	private double precio;

	public Curso() {
	}
	
	public Curso(int codCurso, String nombre, int duracion, double precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public Curso(String nombre, int duracion, double precio) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	public Curso(Formacion formacion) {
		this.nombre = formacion.getCurso();
		this.duracion = formacion.getAsignaturas()*10;
		this.precio = formacion.getPrecio();
	}
	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio + "]";
	}


}
