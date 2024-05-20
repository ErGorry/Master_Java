package com.curso.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 * @author Admin
 *
 */
@Entity
@Table(name = "departamentos")
@NamedQueries({ @NamedQuery(name = "Departamento.getAll", query = "SELECT d FROM Departamento d") })
public class Departamento implements Serializable, Comparable<Departamento> {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_dept")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "localidad")
	private String localidad;
	@OneToMany(mappedBy = "idDepartamento", cascade = CascadeType.ALL)
	private List<Empleado> listaEmpleados = new ArrayList<Empleado>();

	public Departamento() {
	}
	public Departamento(String nombre, String localidad) {
		this.nombre = nombre;
		this.localidad = localidad;
	}

	public Departamento(int idDepartamento, String nombre, String localidad) {
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDepartamento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (idDepartamento != other.idDepartamento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", localidad=" + localidad
				+ "]";
	}

	/**
	 * Compara por el departamento con mayor numero de empleados
	 */
	public int compareTo(Departamento o) {
		int compare = this.listaEmpleados.size() > o.listaEmpleados.size() ? 1 : -0;
		compare = this.listaEmpleados.size() == o.listaEmpleados.size() ? 0 : compare;
		return compare;
	}

}
