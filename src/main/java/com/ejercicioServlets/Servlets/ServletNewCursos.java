package com.ejercicioServlets.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.ejercicioServlets.clases.Usuario;

/**
 * Servlet implementation class ServletNewCursos
 */
public class ServletNewCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Usuario user = (Usuario) sesion.getAttribute("userLogin");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Formulario para matriculacion</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Bienvenido " + user.getNombre() + "</h2>");
		out.println("<p>Completa este formulario para matricularte:</p>");
		out.println("<form action='ServletCursos' method='post'>" 
					+ "<div>"
						+ "<label>Cursos: </label>"
						+"<select multiple size='1' name='cursos'>"
							+ "<option value='JAVA'>JAVA</option>"
							+ "<option value='JavaScript'>JavaScript</option>"
							+ "<option value='Python'>Python</option>"
							+ "<option value='React'>React</option>"
							+ "<option value='Angular'>Angular</option>"
							+ "<option value='PHP'>PHP</option>"
							+ "<option value='Ruby'>Ruby</option>" 
						+ "</select>" 
					+ "</div>"
					+ "<button type='submit'>Matricularse</button>" 
				+ "	</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Usuario user = (Usuario) sesion.getAttribute("userLogin");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Formulario para matriculacion</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Bienvenido " + user.getNombre() + "</h2>");
		out.println("<p>Completa este formulario para matricularte:</p>");
		out.println("<form action='ServletCursos' method='post'>" 
					+ "<div>"
						+ "<label>Cursos: </label>"
						+"<select multiple size='1' name='cursos'>"
							+ "<option value='JAVA'>JAVA</option>"
							+ "<option value='JavaScript'>JavaScript</option>"
							+ "<option value='Python'>Python</option>"
							+ "<option value='React'>React</option>"
							+ "<option value='Angular'>Angular</option>"
							+ "<option value='PHP'>PHP</option>"
							+ "<option value='Ruby'>Ruby</option>" 
						+ "</select>" 
					+ "</div>"
					+ "<button type='submit'>Matricularse</button>" 
				+ "	</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
