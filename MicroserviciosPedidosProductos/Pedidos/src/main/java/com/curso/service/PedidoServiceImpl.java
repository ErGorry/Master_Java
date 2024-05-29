package com.curso.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.PedidoDao;
import com.curso.model.Pedido;
import com.curso.model.Producto;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoDao dao;
	@Autowired
	RestTemplate template;

	private static final String URL_PRODUCTOS = "http://localhost:8000/productos";

	@Override
	public List<Pedido> listar() {

		return dao.findAll();
	}

	@Override
	public List<Pedido> crearPedido(Pedido pedido) {
		String nombreProducto = pedido.getNombreProducto();
		Producto prod = template.getForObject(URL_PRODUCTOS + "/" + nombreProducto, Producto.class);
		
		if (pedido.getUnidades() <= prod.getStock()) {
			
			prod.setStock(prod.getStock() - pedido.getUnidades());
			template.put(URL_PRODUCTOS, prod);
			pedido.setPrecioTotal(prod.getPrecioUnitario() * pedido.getUnidades());
			pedido.setFechaPedido(LocalDate.now());
			dao.save(pedido);
		}
		return dao.findAll();
	}

}
