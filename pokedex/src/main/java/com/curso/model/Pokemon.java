package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Pokemon {

	@Id
	@Column(name = "num_pokedex")
	private int numPokedex;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "nivel")
	private int nivel;
	@Column(name = "vida")
	private int vida;
	@Column(name = "ataque")
	private Integer ataque;
	@Column(name = "defensa")
	private int defensa;
	@Column(name = "ataque_especial")
	private int ataqueEspecial;
	@Column(name = "defensa_especial")
	private int defensaEspecial;
	@Column(name = "velocidad")
	private int velocidad;
	public Pokemon() {
	}
	public Pokemon(int numPokedex) {
		this.numPokedex = numPokedex;
	}
	public Pokemon(int numPokedex, String nombre, int nivel, int vida, int ataque, int defensa, int ataqueEspecial,
			int defensaEspecial, int velocidad) {
		this.numPokedex = numPokedex;
		this.nombre = nombre;
		this.nivel = nivel;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
	}
	public int getNumPokedex() {
		return numPokedex;
	}
	public void setNumPokedex(int numPokedex) {
		this.numPokedex = numPokedex;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}
	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}
	public int getDefensaEspecial() {
		return defensaEspecial;
	}
	public void setDefensaEspecial(int defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numPokedex);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return numPokedex == other.numPokedex;
	}
	@Override
	public String toString() {
		return "Pokemon [numPokedex=" + numPokedex + ", nombre=" + nombre + ", nivel=" + nivel + ", vida=" + vida
				+ ", ataque=" + ataque + ", defensa=" + defensa + ", ataqueEspecial=" + ataqueEspecial
				+ ", defensaEspecial=" + defensaEspecial + ", velocidad=" + velocidad + "]";
	}
	
}
