package com.curso.tienda.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.curso.tienda.model.Producto;
import com.curso.tienda.service.ProductoService;

/**
 * Servlet implementation class NewProducto
 */
public class NewProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("newProducto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombreProducto");
		String categoria = request.getParameter("categoriaProducto");
		double precio = 0;
		int stock = 0;
		try {
			precio = Double.parseDouble(request.getParameter("precioProducto").replaceAll(",", "."));
			stock = Integer.parseInt(request.getParameter("stockProducto"));
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		if (nombre != null && categoria != null && precio > 0 && stock > 0) {
			Producto prod = new Producto(nombre, categoria, precio, stock);
			ProductoService.anhadirNewProducto(prod);
			HttpSession sesion = request.getSession();
			sesion.setAttribute("mensajeMenu", "Se ha añadido el producto: " + nombre);
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		} else {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("error", "Alguno de los campos no fue aceptado");
			response.sendRedirect("newProducto.jsp");
		}
	}

}
