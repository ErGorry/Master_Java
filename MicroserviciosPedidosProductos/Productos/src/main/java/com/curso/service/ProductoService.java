package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Producto;

public interface ProductoService {

	List<Producto> listar();

	void actualizarStock(Producto producto);

	Optional<Double> obtenerPrecio(Integer idProducto);

	Optional<Producto> buscar(String nombre);
}
