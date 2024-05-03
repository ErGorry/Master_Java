package com.curso;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet01
 */
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Saluditos</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
		out.println("</head>");
		out.println("<body>");

		for (int i = 0; i < 5; i++) {
			out.println("<h2>Hola mundo</h2>");

		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] listaCookies = request.getCookies();
		String usuarioReq = request.getParameter("usuario");

		String passReq = request.getParameter("password");
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
		if (usuarioReq.equals("Alvaro") && passReq.equals("Alvaro")) {
			out.println("<h2 style='color:green;'>Hola " + usuarioReq + ", has iniciado sesion correctamente</h2>");
		} else {
			out.println("<h2 style='color:red;'>Acceso denegado</h2>");
			out.println("<button><a href='ServletFormulario01'>Volver</a></button>");
		}
		for (Cookie cookie : listaCookies) {
			out.println("<p>- Tenemos una cookie: " + cookie.getName() + " -> " + cookie.getValue() + "<p>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
