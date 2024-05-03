package com.ejercicioServlets.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ejercicioServlets.clases.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		sesion.setMaxInactiveInterval(45);
		response.sendRedirect("formLogin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("userName") != null && request.getParameter("userPass") != null) {
			String userName = request.getParameter("userName");
			String userPass = request.getParameter("userPass");
			Usuario user = new Usuario(userName, userPass);
			HttpSession sesion = request.getSession();
			sesion.setAttribute("userLogin", user);
			if (userName.equals("Alvaro") && userPass.equals("Alvaro")) {
				
				RequestDispatcher rd = request.getRequestDispatcher("ServletCursos");
				rd.include(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("ServletNewCursos");
				rd.include(request, response);
			}
		} else {
			response.sendRedirect("formLogin.html");
		}
	}

}
