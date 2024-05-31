package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.Formacion;
/**
 * 
 * @author Admin
 *
 */
@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	RestTemplate template;

	private final String url = "http://localhost:8080/cursos";

	@Override
	public List<Formacion> listar() {
		List<Formacion> lista = new ArrayList<Formacion>();
		Arrays.asList(template.getForObject(url, Curso[].class)).iterator()
				.forEachRemaining(c -> lista.add(new Formacion(c)));
		return lista;
	}

	@Override
	public List<Formacion> nuevoCurso(Formacion formacion) {
		if (template.getForObject(url + "/nombre/" + formacion.getCurso(), Curso[].class) == null) {
			template.postForLocation(url, new Curso(formacion));
		}
		return listar();

	}

}
