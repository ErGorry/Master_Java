package com.curso.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * 
 * @author Admin
 *
 */
@Entity
@Table(name = "empleados")
@NamedQueries(
		{ @NamedQuery(name = "Empleado.getAll", query = "SELECT e FROM Empleado e") 
})

public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_emp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "fecha")
	private LocalDate fechaContratacion;
	@Column(name = "sueldo")
	private double sueldo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dept")
	private Departamento idDepartamento;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, LocalDate fechaContratacion, double sueldo) {
		this.nombre = nombre;
		this.fechaContratacion = fechaContratacion;
		this.sueldo = sueldo;
	}

	public Empleado(String nombre, LocalDate fechaContratacion, double sueldo, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.fechaContratacion = fechaContratacion;
		this.sueldo = sueldo;
		this.idDepartamento = departamento;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Departamento getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Departamento idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	/**
	 * Escribe en la consola el nombre del empleado con mayor antiguedad
	 * 
	 * @param emp
	 */
	public void maxAntiguedad(Empleado emp) {
		if (!this.equals(emp)) {
			if (this.getFechaContratacion().isBefore(emp.getFechaContratacion())) {
				System.out.println(this.nombre + " entro antes a la empresa, tiene mayor antiguedad");
			} else if (this.getFechaContratacion().isAfter(emp.getFechaContratacion())) {
				System.out.println(emp.getNombre() + " entro antes a la empresa, tiene mayor antiguedad");
			} else {
				System.out.println(this.nombre + " y " + emp.getNombre() + " fueron contratados el mismo dia");
			}
		} else {
			System.out.println("Son el mismo empleado");
		}
	}

	/**
	 * Escribe en la consola el nuombre del empleado con menor antiguedad
	 * 
	 * @param emp
	 */
	public void minAntiguedad(Empleado emp) {
		if (!this.equals(emp)) {
			if (this.getFechaContratacion().isBefore(emp.getFechaContratacion())) {
				System.out.println(this.nombre + " entro mas tarde a la empresa, tiene menor antiguedad");
			} else if (this.getFechaContratacion().isAfter(emp.getFechaContratacion())) {
				System.out.println(emp.getNombre() + " entro mas tarde a la empresa, tiene menor antiguedad");
			} else {
				System.out.println(this.nombre + " y " + emp.getNombre() + " fueron contratados el mismo dia");
			}
		} else {
			System.out.println("Son el mismo empleado");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpleado;
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
		Empleado other = (Empleado) obj;
		if (idEmpleado != other.idEmpleado)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", fechaContratacion=" + fechaContratacion
				+ ", sueldo=" + sueldo + ", idDepartamento=" + idDepartamento + "]";
	}

}
