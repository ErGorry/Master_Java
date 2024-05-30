package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Pedido;
import com.curso.service.PedidoService;
/**
 * 
 * @author Admin
 *
 */
@RestController
public class PedidoController {

	@Autowired
	PedidoService service;

	@GetMapping(value = "pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Pedido> listar() {

		return service.listar();
	}

	@GetMapping(value = "pedidos/{idPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	Optional<Pedido> buscar(@PathVariable("idPedido") Integer idPedido) {
		return service.buscar(idPedido);

	}

	@PostMapping(value = "pedidos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Pedido> crearPedido(@RequestBody Pedido pedido) {
		return service.comprobarPedido(pedido);
	}

	@DeleteMapping(value = "pedidos/{idPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Pedido> eliminarPedido(@PathVariable("idPedido") Integer idPedido) {
		return service.eliminarPedido(idPedido);
	}
}
