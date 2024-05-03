package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.curso.clases.Producto;

/**
 * Servlet implementation class ServletSesionProducto
 */
public class ServletSesionProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		sesion.setMaxInactiveInterval(120);
		Producto prod = new Producto(1, "Mesa", 350.5);
		sesion.setAttribute("producto", prod);
		response.sendRedirect("FormularioSesionProducto.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Echo datos Formulario01</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
		out.println("</head>");
		out.println("<body>");
		if (sesion.getAttribute("producto") != null && sesion.getAttribute("producto") instanceof Producto) {
			Producto producto = (Producto) sesion.getAttribute("producto");
			out.println("<p>" + producto + "</p>");
		} else {
			out.println("<p>No se ha encontrado el producto dentro de las sesiones</p>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
