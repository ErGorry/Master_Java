package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ProductoDao;
import com.curso.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDao dao;

	@Override
	public List<Producto> listar() {

		return dao.findAll();
	}

	public void actualizarStock(Producto producto) {

		dao.save(producto);
	}

	@Override
	public Optional<Double> obtenerPrecio(Integer idProducto) {

		return dao.obtenerPrecio(idProducto);
	}

	@Override
	public Optional<Producto> buscar(String nombre) {

		return Optional.of(dao.findByNombre(nombre).get(0));
	}
}
