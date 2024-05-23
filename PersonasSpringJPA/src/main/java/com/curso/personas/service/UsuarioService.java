package com.curso.personas.service;

import java.util.List;

import com.curso.personas.model.Usuario;

public interface UsuarioService {

	List<Usuario> usuarios();

	Usuario usuario(int id);

	void altaUsuario(Usuario usuario);

	void actualizarUsuario(Usuario usuario);

	void eliminarUsuario(Usuario usuario);
}
