package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Pedido;
/**
 * 
 * @author Admin
 *
 */
public interface PedidoDao extends JpaRepository<Pedido, Integer> {

}
