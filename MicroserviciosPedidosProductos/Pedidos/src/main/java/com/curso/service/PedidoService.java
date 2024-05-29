package com.curso.service;

import java.util.List;

import com.curso.model.Pedido;

public interface PedidoService {

	List<Pedido> listar();
	
	List<Pedido> crearPedido(Pedido pedido);
}
