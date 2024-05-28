package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.curso.dao.CursoDao;
import com.curso.model.Curso;

@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	CursoDao dao;

	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}

	@Override
	public List<Curso> cursosByPrecio(double desde, double hasta) {
		return dao.findByPrecioBetween(desde, hasta);
	}

	@Override
	public Optional<Curso> buscarCurso(String codCurso) {
		return dao.findById(codCurso);
	}

	@Override
	public void altaCurso(Curso curso) {
		dao.save(curso);

	}

	@Override
	public void actualizarDuracion(int duracion,String codCurso) {
		dao.updateDuracion(duracion,codCurso);

	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public Optional<Curso> buscarCursoPorNombre(String nombre) {
		
		return dao.findFirstByNombre(nombre);
	}

}
