package com.curso.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;

@RestController
public class CursoController {

	@Autowired
	CursoService service;

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {
		return service.cursos();
	}

	@GetMapping(value = "cursos/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Curso> buscarCurso(@PathVariable("cod") String codCurso) {
		return service.buscarCurso(codCurso);
	}

	@PostMapping(value = "cursos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}

	@PutMapping(value = "cursos/{cod}/{dur}")
	public void actualizarDuracion(@PathVariable("cod") String codCurso, @PathVariable("dur") int duracion) {
		service.actualizarDuracion(duracion, codCurso);
	}
	
	@DeleteMapping(value="cursos/{cod}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable("cod") String codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	@GetMapping(value = "cursos/{desde}/{hasta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosPorPrecio(@PathVariable("desde") double desde,@PathVariable("hasta") double hasta) {
		return service.cursosByPrecio(desde, hasta);
	}
}
