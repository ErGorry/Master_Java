package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Curso;

public interface CursoService {

	List<Curso> cursos();

	Optional<Curso> buscarCurso(String codCurso);
	
	Optional<Curso> buscarCursoPorNombre(String nombre);

	void altaCurso(Curso curso);

	List<Curso> eliminarCurso(String codCurso);

	void actualizarDuracion(int duracion, String codCurso);

	List<Curso> cursosByPrecio(double desde, double hasta);
}
