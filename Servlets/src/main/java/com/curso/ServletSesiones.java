package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletSesiones
 */
public class ServletSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("curso", "Sesion de manualidades con goma Eva");
		response.sendRedirect("FormularioSesiones.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		if (sesion.getAttribute("curso") != null) {
			out.println("Tenemos una sesion almacenada: " + sesion.getAttribute("curso"));
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
