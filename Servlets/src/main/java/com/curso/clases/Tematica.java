package com.curso.clases;

import java.util.Map;

public class Tematica {

	private String nombre;
	private Map<String, String> enlaces;
	public Tematica(String nombre, Map<String, String> enlaces) {
		super();
		this.nombre = nombre;
		this.enlaces = enlaces;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Map<String, String> getEnlaces() {
		return enlaces;
	}
	public void setEnlaces(Map<String, String> enlaces) {
		this.enlaces = enlaces;
	}
	
}
