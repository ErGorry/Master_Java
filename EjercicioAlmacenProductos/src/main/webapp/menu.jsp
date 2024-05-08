<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Menu de tienda</title>
<link rel="stylesheet" type="text/css" href="style/estilo.css">
</head>
<body>
	<h2>Has llegado al menú
		<%=session.getAttribute("user").toString()%></h2>
	<%
	if (session.getAttribute("mensajeMenu") != null) {
	%>
	<p style="color: green;"><%=session.getAttribute("mensajeMenu") %></p>
	<%
	} else {
	%>
	<p>Puedes escoger entre algunas de estas acciones:</p>
	<%
	}
	%>
	<form action="">
		<button>
			<a href="BusquedaProductos">Realizar busquedas de productos</a>
		</button>

		<%
		if ((Boolean) session.getAttribute("admin")) {
		%>
		<button>
			<a href="NewProducto">Añadir un producto nuevo</a>
		</button>
		<%
		}
		%>
	</form>
</body>
</html>