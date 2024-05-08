<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.curso.tienda.model.Categoria"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Buscar productos</title>
<link rel="stylesheet" type="text/css" href="style/estilo.css">
</head>
<body>
	<form action="BusquedaProductos" method="post">
		<div>
			<label for="nombreProducto">Nombre: </label><input type="text"
				name="nombreProducto">
		</div>
		<div>
			<label for="categoriaProducto">Categoria: </label> <select
				name="categoriaProducto" required>
				<%
				for (Categoria cat : Categoria.values()) {
				%>
				<option value="<%=cat.toString()%>"><%=cat.toString()%></option>
				<%
				}
				%>
			</select>
		</div>
		<button type="submit">Buscar Productos</button>
		<%
		if (session.getAttribute("mensajeBuscar") != null) {
		%>
		<p style="color: green;"><%=session.getAttribute("mensajeBuscar")%></p>
		<%
		}
		%>
		<%
		if (session.getAttribute("error") != null) {
		%>
		<p style="color: red;"><%=session.getAttribute("error")%></p>
		<%
		}
		%>
	</form>
	<button>
		<a href="menu.jsp">Volver</a>
	</button>
</body>
</html>