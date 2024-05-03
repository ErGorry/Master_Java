package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletParametros
 */
public class ServletParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("nombre") != null) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"es\">");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\">");
			out.println("<title>Echo datos Formulario02</title>");
			out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
			out.println("</head>");
			out.println("<body>");
			if (request.getParameter("aceptado").equalsIgnoreCase("true")) {
				out.println("<p style='color: green'>Bienvenido '" + request.getParameter("nombre"));
				out.println("' muchas gracias por aceptar las condiciones.");
			} else {
				out.println("<p style='color: red'>Bienvenido '" + request.getParameter("nombre"));
				out.println("' si no aceptas las condiciones no puedes continuar, vuelve y acepta.");
				out.println("<button><a href='ServletParametros'>Volver para aceptar</a></button>");
			}

			out.println("</body>");
			out.println("</html>");
			out.close();
		} else {
			response.sendRedirect("Parametros.html");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @Override
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
