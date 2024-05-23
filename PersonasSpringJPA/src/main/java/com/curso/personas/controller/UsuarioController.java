package com.curso.personas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.personas.model.Usuario;
import com.curso.personas.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;
	@GetMapping(value = "usuarios",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> usuarios(){
		return service.usuarios();
	}
	
	@GetMapping(value = "usuarios/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario usuario(@PathVariable("id") int id){
		return service.usuario(id);
	}
	
	@PostMapping(value="usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaUsuario(@RequestBody Usuario usuario) {
		service.altaUsuario(usuario);
	}
	
	@PutMapping(value="usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarUsuario(@RequestBody Usuario usuario) {
		service.actualizarUsuario(usuario);
	}
	@DeleteMapping(value="usuarios")
	public void eliminarUsuario(@RequestBody Usuario usuario) {
		service.eliminarUsuario(usuario);
	}
}
