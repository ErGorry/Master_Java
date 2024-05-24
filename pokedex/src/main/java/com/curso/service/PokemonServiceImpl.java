package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.PokemonDao;
import com.curso.model.Pokemon;

import jakarta.transaction.Transactional;
@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	PokemonDao dao;
	
	@Override
	public List<Pokemon> listarTodos() {
		
		return dao.findAll();
	}

	@Override
	public Optional<Pokemon> buscarPorId(int numPokedex) {
		
		return dao.findById(numPokedex);
	}


	@Override
	public void nuevo(Pokemon pokemon) {
		
		dao.save(pokemon);
	}


	@Override
	public void actualizarDatos(Pokemon pokemon) {
		
		dao.save(pokemon);
	}


	@Override
	public List<Pokemon> borrar(Integer numPokedex) {

		dao.delete(dao.findById(numPokedex).orElse(null));
		return dao.findAll();
	}

	@Override
	public Optional<Pokemon> subirDeNivel(int numPokedex) {
		dao.subirDeNivel(numPokedex);
		return dao.findById(numPokedex);
	}

	@Override
	public Optional<Pokemon> debilitarPokemon(int numPokedex) {
		dao.debilitarPokemon(numPokedex);
		return dao.findById(numPokedex);
	}

	@Override
	public List<Pokemon> findByVidaGreaterThan(int vida) {
		
		return dao.findByVidaGreaterThan(vida);
	}

	@Override
	public List<Pokemon> findByVidaLessThan(int vida) {
		
		return dao.findByVidaLessThan(vida);
	}

	

}
