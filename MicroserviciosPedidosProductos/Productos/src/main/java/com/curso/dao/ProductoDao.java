package com.curso.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Producto;

import jakarta.transaction.Transactional;

public interface ProductoDao extends JpaRepository<Producto, Integer> {

	
	
	@Query(value = "SELECT p.precioUnitario FROM Producto p WHERE p.idProducto = ?1")
	Optional<Double> obtenerPrecio(Integer idProducto);
	
	List<Producto> findByNombre(String nombre);
}
