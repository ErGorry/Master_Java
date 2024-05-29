package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Producto;
import com.curso.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	ProductoService service;

	@GetMapping(value="productos",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> listar() {
		
		return service.listar();
	}
	
	@GetMapping(value="productos/{nombre}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Producto> buscar(@PathVariable("nombre") String nombre) {
		
		return service.buscar(nombre);
	}
	
	@PutMapping(value = "productos",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarStock(@RequestBody Producto producto) {
		
		service.actualizarStock(producto);
	}
	
	@GetMapping(value = "productos/precio/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Double> obtenerPrecio(@PathVariable("idProducto") Integer idProducto){
		
		return service.obtenerPrecio(idProducto);
	}
}
