package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Pedido;
import com.curso.service.PedidoService;

@RestController
public class PedidoController {

	@Autowired
	PedidoService service;
	
	@GetMapping(value = "pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Pedido> listar(){
	
		return service.listar();
	}
	
	@PostMapping(value = "pedidos", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	List<Pedido> crearPedido(@RequestBody Pedido pedido){
		return service.crearPedido(pedido);
	}
}
