package com.ejercicioServlets.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

	private String nombre;
	private String pass;
	private List<String> cursos;

	public Usuario(String nombre, String pass) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.cursos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, pass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
