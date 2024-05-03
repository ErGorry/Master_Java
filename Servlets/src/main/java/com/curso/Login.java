package com.curso;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("FormLogin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html");

		// se recoge el valor del userName

		// se recoge el valor del password
		String contra = request.getParameter("userPass");
		if (contra.equals("Pepito")) {

			// Se obtiene el objeto rd para transferir la petición al servlet2
			RequestDispatcher rd = request.getRequestDispatcher("ServletBienvenida");

			// se envía la solicitud al servlet2
			rd.forward(request, response);
		} else {
			// PrintWriter out = response.getWriter();
			// out.print("Contraseña Invalida");
			RequestDispatcher rd = request.getRequestDispatcher("/FormLogin.html");
			rd.include(request, response);

		}
	}

}
