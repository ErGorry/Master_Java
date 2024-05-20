package com.curso.repository;

import java.util.List;

import com.curso.model.Empleado;

public interface EmpleadoRepository {

	public Empleado getOne(int idEmpleado);
	public List<Empleado> getAll();
	public void save(Empleado empleado);
	public void delete(Empleado empleado);
}
