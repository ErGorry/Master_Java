package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletFormulario01
 */
public class ServletFormulario01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c1 = new Cookie("nombre", "Alvaro");
		c1.setMaxAge(5);
		response.addCookie(c1);
		response.sendRedirect("Formulario01.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int veces = Integer.parseInt(request.getParameter("edad"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Echo datos Formulario01</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
		out.println("</head>");
		out.println("<body>");
		for (int i = 0; i < veces; i++) {
			out.println("<h2>Hola " + request.getParameter("nombre") + ", estamos en el Servlet.</h2>");
		}
		out.println("<p>INSERT INTO usuarios ('nombre','email') VALUES '" + request.getParameter("nombre") + "', '"
				+ request.getParameter("email") + "';</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
