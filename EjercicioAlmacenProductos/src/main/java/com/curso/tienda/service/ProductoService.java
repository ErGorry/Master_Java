package com.curso.tienda.service;

import java.util.LinkedList;
import java.util.List;

import com.curso.tienda.model.Producto;

/**
 * 
 * @author Admin 08-05-2024
 *
 */
public class ProductoService {

	private static List<Producto> listaProductos = new LinkedList<Producto>(List.of(
			new Producto("Jamon Serrano", "ALIMENTACION", 89.99, 15),
			new Producto("Agua Mineral", "ALIMENTACION", 0.99, 150),
			new Producto("Atun lata", "ALIMENTACION", 2.99, 50), new Producto("Pan", "ALIMENTACION", 0.89, 15),
			new Producto("Nevera", "ELECTRODOMESTICOS", 489.99, 3),
			new Producto("Lavavajillas", "ELECTRODOMESTICOS", 289.99, 0),
			new Producto("Microondas", "ELECTRODOMESTICOS", 69.99, 12),
			new Producto("Ventilador", "ELECTRODOMESTICOS", 29.99, 20),
			new Producto("Ordenador Portatil", "INFORMATICA", 489.99, 0),
			new Producto("Impresora", "INFORMATICA", 79.99, 5), new Producto("PS5", "INFORMATICA", 489.99, 2),
			new Producto("Monitor", "INFORMATICA", 129.99, 8), new Producto("Bebedero perros", "MASCOTAS", 9.99, 25),
			new Producto("Cepillo pelo largo", "MASCOTAS", 9.99, 30),
			new Producto("Comida gatos", "MASCOTAS", 19.99, 45), new Producto("Collar", "MASCOTAS", 7.99, 40),
			new Producto("Aceite coche", "MOTOR", 24.99, 15), new Producto("Bobillas H7", "MOTOR", 1.99, 60),
			new Producto("Parasol", "MOTOR", 14.99, 15), new Producto("Limpiador tapicerias", "MOTOR", 8.99, 25),
			new Producto("Sofa", "OTROS", 524.99, 1), new Producto("Lampara", "OTROS", 54.99, 3),
			new Producto("Silla gamer", "OTROS", 99.99, 2)));

	/**
	 * 
	 * @return lista completa de productos
	 */
	public static List<Producto> listaProductos() {
		return listaProductos;
	}

	/**
	 * 
	 * @param categoria
	 * @return productos de la categoria
	 */
	public static List<Producto> listaProductosByCategoria(String categoria) {
		return listaProductos().stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria)).toList();
	}

	/**
	 * 
	 * @param nombre
	 * @return productos que contengan el nombre
	 */
	public static List<Producto> listaProductosByNombre(String nombre) {
		return listaProductos().stream().filter(p -> p.getNombre().contains(nombre)).toList();
	}

	/**
	 * 
	 * @param nombre
	 * @param categoria
	 * @return productos que contengan el nombre y dentro de la categoria
	 */
	public static List<Producto> listaProductosByNombreCategoria(String nombre, String categoria) {
		return listaProductos().stream()
				.filter(p -> p.getNombre().contains(nombre) && p.getCategoria().equalsIgnoreCase(categoria)).toList();
	}

	/**
	 * 
	 * @return productos con stock 0
	 */
	public static List<Producto> listaProductosSinStock() {
		return listaProductos.stream().filter(p -> p.getStock() < 1).toList();
	}

	/**
	 * Metodo para introducir un producto en el almacen
	 * 
	 * @param producto
	 */
	public static void anhadirNewProducto(Producto producto) {
		try {
			listaProductos.add(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para eliminar el producto con el nombre y categoria
	 * 
	 * @param producto
	 * @param categoria
	 */
	public static void deleteProducto(String producto, String categoria) {
		Producto prod = listaProductosByNombreCategoria(producto, categoria).get(0);
		try {
			listaProductos.remove(prod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
