package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Producto;

/**
 * 
 * @author Admin
 *
 */
public interface ProductoService {

	List<Producto> listar();

	/**
	 * Actualiza el stock de un producto
	 * 
	 * @param producto a actualizar
	 */
	void actualizarStock(Producto producto);

	/**
	 * Obtiene el precio de un producto
	 * 
	 * @param idProducto producto a consultar
	 * @return Double del precio por articulo
	 */
	Optional<Double> obtenerPrecio(Integer idProducto);

	Optional<Producto> buscar(String nombre);

	void eliminar(Integer idProducto);

	void crearProducto(Producto producto);
}
