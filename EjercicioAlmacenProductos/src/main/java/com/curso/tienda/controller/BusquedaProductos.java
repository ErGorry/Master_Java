package com.curso.tienda.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.curso.tienda.model.Producto;
import com.curso.tienda.service.ProductoService;

/**
 * Servlet implementation class BusquedaProductos
 */
public class BusquedaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("busquedaProductos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombreProducto").isBlank() ? null
				: request.getParameter("nombreProducto");
		String categoria = request.getParameter("categoriaProducto").isBlank() ? null
				: request.getParameter("categoriaProducto");
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listaProductos", null);
		LinkedList<Producto> list = new LinkedList<>();
		if (nombre != null) {
			if (categoria != null) {
				list.addAll(ProductoService.listaProductosByNombreCategoria(nombre, categoria));
			} else {
				list.addAll(ProductoService.listaProductosByNombre(nombre));
			}
		} else {
			if (categoria != null) {
				list.addAll(ProductoService.listaProductosByCategoria(categoria));
			} else {
				sesion.setAttribute("error", "No se han procesado correctamente los campos del formulario");
				response.sendRedirect("busquedaProductos.jsp");
			}
		}
		sesion.setAttribute("mensajeList", "Se han encontrado: " + list.size() + " productos");
		sesion.setAttribute("error", null);
		if (!list.isEmpty()) {
			sesion.setAttribute("listaProductos", list);
		}
		response.sendRedirect("listarProductos.jsp");
	}

}
