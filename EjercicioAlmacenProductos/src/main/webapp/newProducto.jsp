<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.curso.tienda.model.Producto"%>
	<%@page import="com.curso.tienda.model.Categoria"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Formulario para añadir producto</title>
<link rel="stylesheet" type="text/css" href="style/estilo.css">
</head>
<body>
<%
Producto prod = null;
if (request.getAttribute("productoMod") != null) {
prod = (Producto)request.getAttribute("productoMod");
}%>
	<form action="NewProducto" method="post">
		<div>
			<label for="nombreProducto">Nombre: </label><input required
				type="text" name="nombreProducto"
				<%if (prod != null) {%>
				value="<%=prod.getNombre()%>" <%}%>>
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
		<div>
			<label for="precioProducto">Precio: </label><input required
				type="text" name="precioProducto" <%if (prod != null) {%>
				value="<%=prod.getPrecio()%>" <%}%>>
		</div>
		<div>
			<label for="stockProducto">Stock: </label><input required type="text"
				name="stockProducto" <%if (prod != null) {%>
				value="<%=prod.getStock()%>" <%}%>>
		</div>
		<%
		if (session.getAttribute("error") != null) {
		%>
		<p style="color: red;"><%=session.getAttribute("error")%></p>
		<%
		}
		%>
		<button type="submit">Añadir Producto</button>
	</form>
	<button>
		<a href="menu.jsp">Volver</a>
	</button>
</body>
</html>