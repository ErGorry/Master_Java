package com.curso.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 * @author Admin
 *
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_emp")
	private int idEmpleado;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "fecha")
	private Date fechaContratacion;
	@Column(name = "sueldo")
	private double sueldo;
	@ManyToOne
	@JoinColumn(name = "id_dept")
	private Departamento idDepartamento;

	public Empleado() {
		super();
	}

	public Empleado(int idEmpleado, String nombre, Date fechaContratacion, double sueldo) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.fechaContratacion = fechaContratacion;
		this.sueldo = sueldo;
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

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
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
			if (this.getFechaContratacion().before(emp.getFechaContratacion())) {
				System.out.println(this.nombre + " entro antes a la empresa, tiene mayor antiguedad");
			} else if (this.getFechaContratacion().after(emp.getFechaContratacion())) {
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
			if (this.getFechaContratacion().before(emp.getFechaContratacion())) {
				System.out.println(this.nombre + " entro mas tarde a la empresa, tiene menor antiguedad");
			} else if (this.getFechaContratacion().after(emp.getFechaContratacion())) {
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
