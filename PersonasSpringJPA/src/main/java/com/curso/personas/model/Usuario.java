package com.curso.personas.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Usuario {

	@Id
	private int id;
	private String username;
	private String localidad;
	private int edad;

	public Usuario() {
	}

	public Usuario(int id) {
		this.id = id;
	}

	public Usuario(int id, String username, String localidad, int edad) {
		this.id = id;
		this.username = username;
		this.localidad = localidad;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", localidad=" + localidad + ", edad=" + edad + "]";
	}

}
