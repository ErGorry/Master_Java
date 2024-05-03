package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.curso.clases.Tematica;

/**
 * Servlet implementation class ServletBuscador
 */
public class ServletBuscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> mapa = new HashMap<>(3);
		mapa.putIfAbsent("http://www.soundcloud.com/es", "Soundcloud: Streaming de música para artistas");
		mapa.putIfAbsent("https://open.spotify.com/intl-es", "Spotify: Streaming de música generalista");
		mapa.putIfAbsent("https://los40.com/los40_urban/", "Los40 Urban: La emisora más escuchada de España");
		Tematica musica = new Tematica("musica", mapa);
		mapa = new HashMap<>(3);
		mapa.putIfAbsent("http://www.HBOMax.com", "HBOMax: Streaming de cine, especialmente series");
		mapa.putIfAbsent("https://www.disneyplus.com/es-es",
				"Disney+: Streaming de cine y series, incluye otras productoras");
		mapa.putIfAbsent("https://www.netflix.com/login",
				"Netflix: La primera y mas popular pagina de streaming de cine y series");
		Tematica cine = new Tematica("cine", mapa);
		mapa = new HashMap<>(3);
		mapa.putIfAbsent("https://docs.oracle.com/en/java/javase/17/docs/api/index.html",
				"Documentacion de JAVA SE 17");
		mapa.putIfAbsent("https://developer.mozilla.org/es/docs/Web/JavaScript",
				"Documentacion de JavaScript de Mozilla");
		mapa.putIfAbsent("https://www.php.net/docs.php", "Documentacion de PHP");
		Tematica documentacion = new Tematica("documentacion", mapa);
		HttpSession sesion = request.getSession(true);
		sesion.setMaxInactiveInterval(45);
		sesion.setAttribute("musica", musica);
		sesion.setAttribute("cine", cine);
		sesion.setAttribute("documentacion", documentacion);
		response.sendRedirect("FormularioBusqueda.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tema = request.getParameter("tematica").toLowerCase();
		if (tema != null) {
			HttpSession sesion = request.getSession();
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"es\">");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\">");
			out.println("<title>Enlaces encontrados</title>");
			out.println("<link rel='stylesheet' type='text/css' href='style/estilo.css'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form>");
			try {
				Tematica tematica = (Tematica) sesion.getAttribute(tema);
				out.println("<h1>Temática: " + tematica.getNombre() + "</h1>");
				for (Map.Entry<String, String> entry : tematica.getEnlaces().entrySet()) {
					String key = entry.getKey();
					String val = entry.getValue();
					out.println("<h2>" + "<a style='color:darkblue;' href='" + key + "'>" + val + "</a>" + "</h2>");
				}
			} catch (Exception e) {
				out.println("<h2>No encontramos la temática</h2>");
			}

			out.println("</form>");
			out.println("<button><a href='ServletBuscador'>VOLVER</a></button>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		} else {
			response.sendRedirect("FormularioBusqueda.html");
		}
	}

}
