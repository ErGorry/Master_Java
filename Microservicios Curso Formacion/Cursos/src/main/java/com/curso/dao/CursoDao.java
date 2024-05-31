package com.curso.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Curso;

import jakarta.transaction.Transactional;

/**
 * 
 * @author Admin
 *
 */
public interface CursoDao extends JpaRepository<Curso, String> {

	@Transactional
	@Modifying()
	@Query(value = "UPDATE Curso c SET c.duracion = ?1 WHERE c.codCurso = ?2")
	void updateDuracion(int duracion, String codCurso);

	// @Modifying
	// @Query(value = "SELECT c FROM Curso c WHERE c.precio BETWEEN :desde AND
	// :hasta")
	List<Curso> findByPrecioBetween(double desde, double hasta);

	Optional<Curso> findFirstByNombre(String nombre);
}
