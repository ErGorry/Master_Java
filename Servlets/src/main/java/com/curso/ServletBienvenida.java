package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.curso.clases.Producto;

/**
 * Servlet implementation class ServletBienvenida
 */
public class ServletBienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Echo datos Formulario01</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style/estilo.css\">");
		out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Bienvenido" + request.getParameter("userName") + "</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
