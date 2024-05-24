package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Pokemon;

public interface PokemonService {

	List<Pokemon> listarTodos();

	Optional<Pokemon> buscarPorId(int numPokedex);

	void nuevo(Pokemon pokemon);

	void actualizarDatos(Pokemon pokemon);

	List<Pokemon> borrar(Integer numPokedex);

	Optional<Pokemon> subirDeNivel(int numPokedex);

	Optional<Pokemon> debilitarPokemon(int numPokedex);

	List<Pokemon> findByVidaGreaterThan(int vida);

	List<Pokemon> findByVidaLessThan(int vida);

}
