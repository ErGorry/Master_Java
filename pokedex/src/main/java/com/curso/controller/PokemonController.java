package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Pokemon;
import com.curso.service.PokemonService;

@RestController
public class PokemonController {
	@Autowired
	PokemonService service;

	@GetMapping(value = "pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pokemon> pokemons() {
		return service.listarTodos();
	}

	@GetMapping(value = "pokemon/{numPokedex}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Pokemon> pokemon(@PathVariable("numPokedex") int numPokedex) {
		return service.buscarPorId(numPokedex);
	}

	@PostMapping(value = "pokemon", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaPokemon(@RequestBody Pokemon pokemon) {
		service.nuevo(pokemon);
	}

	@PutMapping(value = "pokemon", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarPokemon(@RequestBody Pokemon pokemon) {
		service.actualizarDatos(pokemon);
	}

	@DeleteMapping(value = "pokemon/{numPokedex}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pokemon> borrar(@PathVariable("numPokedex") Integer numPokedex) {
		return service.borrar(numPokedex);
	}

	@PatchMapping(value = "pokemon/subirdenivel/{numPokedex}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Pokemon> subirDeNivel(@PathVariable("numPokedex") int numPokedex) {
		return service.subirDeNivel(numPokedex);
	}

	@PatchMapping(value = "pokemon/debilitar/{numPokedex}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Pokemon> debilitar(@PathVariable("numPokedex") int numPokedex) {
		return service.debilitarPokemon(numPokedex);
	}

	@GetMapping(value = "pokemon/vidamayor/{vida}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pokemon> listarPorVidaMayor(@PathVariable("vida") int vida) {
		return service.findByVidaGreaterThan(vida);
	}

	@GetMapping(value = "pokemon/vidamenor/{vida}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pokemon> listarPorVidaMenor(@PathVariable("vida") int vida) {
		return service.findByVidaLessThan(vida);
	}

}
