package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Servlet implementation class ServletFormulario04
 */
public class ServletFormulario04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Formulario04.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
		String apellidos = request.getParameter("apellidos") != null ? request.getParameter("apellidos") : "";
		String trabajo = request.getParameter("trabajo") != null ? request.getParameter("trabajo") : "";
		String estudio = request.getParameter("estudio") != null ? request.getParameter("estudio") : "";
		String institucion = request.getParameter("institucion") != null ? request.getParameter("institucion") : "";
		String[] tecnologias = request.getParameter("tecnologias") != null ? request.getParameterValues("tecnologias")
				: new String[0];

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Carta presentacion:</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Buenas tardes, mi nombre es " + nombre + " " + apellidos + ".");
		out.println("Soy un programador con estudios de " + estudio + " cursados en " + institucion);
		out.println(". Me pongo en contacto con usted en relacion al puesto de trabajo de " + trabajo
				+ " el cual teneis vacante.");
		out.print("Estaré encantado de concertar una entrevista si lo desea.");
		out.println("Mis conocimientos de lenguaje son: ");
		for (String string : tecnologias) {
			out.println(string + " ");
		}
		out.println(".");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
