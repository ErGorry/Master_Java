package com.curso.service;

import java.util.List;

import com.curso.model.Formacion;
/**
 * 
 * @author Admin
 *
 */
public interface FormacionService {

	List<Formacion> listar();
	List<Formacion> nuevoCurso(Formacion formacion);
}
