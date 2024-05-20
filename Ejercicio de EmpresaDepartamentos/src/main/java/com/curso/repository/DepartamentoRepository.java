package com.curso.repository;

import java.util.List;

import com.curso.model.Departamento;


public interface DepartamentoRepository {

	public Departamento getOne(int idDepartamento);
	public List<Departamento> getAll();
	public void save(Departamento departamento);
	public void delete(Departamento departamento);
}
