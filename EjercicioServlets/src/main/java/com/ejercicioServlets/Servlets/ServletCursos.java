package com.ejercicioServlets.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ejercicioServlets.clases.Usuario;

/**
 * Servlet implementation class ServletCursos
 */
public class ServletCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Usuario user = (Usuario) sesion.getAttribute("userLogin");
		List<String> listaCursos = user.getCursos();
		if (listaCursos.contains(request.getParameter("curso"))) {
			listaCursos.remove(listaCursos.indexOf(request.getParameter("curso")));
		}

		user.setCursos(listaCursos);
		sesion.setAttribute("userLogin", user);

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
		out.println("<form action='' method='post'>");
		out.println("<p>Hola " + user.getNombre() + " hemos borrado el curso de " + request.getParameter("curso")
				+ " de la seleccion </p>");
		out.println("<button type='submit'>Volver</button>");
		out.println("</form>");
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
		if (sesion.getAttribute("userLogin") != null) {
			Usuario user = (Usuario) sesion.getAttribute("userLogin");
			String[] cursos = request.getParameterValues("cursos");
			List<String> listaCursos = new ArrayList<>();
			if (cursos == null) {
				listaCursos = user.getCursos();
			} else {
				for (String string : cursos) {
					listaCursos.add(string);
				}
			}
			user.setCursos(listaCursos);

			sesion.setAttribute("userLogin", user);
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
			out.println("<h2>Hola " + user.getNombre() + "!</h2>");
			out.println("<p>Cursos en los que esta matriculado:</p>");
			out.println("<p>Si desea desmatricularse puede pinchar el enlace del curso</p>");
			out.println("<ul>");
			if (!listaCursos.isEmpty()) {
				for (String curso : listaCursos) {
					out.println("<li><a href='ServletCursos?curso=" + curso + "'>Curso de " + curso + "</a></li>");
				}
			}
			out.println("</ul>");
			out.println("<p>Tambien puedes cambiar la selección de cursos aqui:</p>");
			out.println("<button><a href='ServletNewCursos'>Mostrar Formulario de cursos</a></button>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} else {
			response.sendRedirect("formLogin.html");
		}
	}

}
