package com.curso.tienda.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.curso.tienda.service.ProductoService;

/**
 * Servlet implementation class EliminarProducto
 */
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		HttpSession sesion = request.getSession();
		sesion.setAttribute("mensajeBuscar", null);
		if (nombre != null && !nombre.isBlank() && categoria!=null && !categoria.isBlank()) {
			ProductoService.deleteProducto(nombre, categoria);
			sesion.setAttribute("mensajeBuscar", "Se ha borrado el producto "+nombre);
			
		}else {
		sesion.setAttribute("error", "No se ha podido borrar el articulo " + nombre);
		}
		response.sendRedirect("busquedaProductos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
