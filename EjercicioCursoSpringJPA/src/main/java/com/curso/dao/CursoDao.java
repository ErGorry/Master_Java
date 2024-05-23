package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Curso;

import jakarta.transaction.Transactional;

public interface CursoDao extends JpaRepository<Curso, String> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Curso c SET c.duracion = :duracion WHERE c.codCurso = :codCurso")
	void updateDuracion(@Param("duracion") int duracion,@Param("codCurso") String codCurso);

	@Modifying
	@Query(value = "SELECT c FROM Curso c WHERE c.precio BETWEEN :desde AND :hasta")
	List<Curso> cursosByPrecio(double desde, double hasta);
}
