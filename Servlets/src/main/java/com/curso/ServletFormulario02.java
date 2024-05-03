package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletFormulario02
 */
public class ServletFormulario02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		if (request.getParameter("yoga") != null) {
			out.println("<h2>Has seleccionado el curso de yoga");
		}
		if (request.getParameter("pilates") != null) {
			out.println("<h2>Has seleccionado el curso de pilates");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
