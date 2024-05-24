package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Pokemon;

import jakarta.transaction.Transactional;

public interface PokemonDao extends JpaRepository<Pokemon, Integer> {
	@Transactional
	@Modifying
	@Query(value = "UPDATE Pokemon p SET vida = vida+3, ataque = ataque+3, defensa=defensa+3, ataqueEspecial=ataqueEspecial+3, defensaEspecial = defensaEspecial+3, velocidad = velocidad+3, nivel = nivel+1 WHERE numPokedex=?1")
	public void subirDeNivel(int numPokedex);
	@Transactional
	@Modifying
	@Query(value = "UPDATE Pokemon p SET vida = 0 WHERE numPokedex=?1")
	public void debilitarPokemon(Integer numPokedex);
	
	public List<Pokemon> findByVidaGreaterThan(int vida);
	
	public List<Pokemon> findByVidaLessThan(int vida);
}
