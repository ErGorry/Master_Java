<%@page import="java.util.LinkedList"%>
<%@page import="com.curso.tienda.model.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado Productos</title>
<link rel="stylesheet" type="text/css" href="style/estilo.css">
</head>
<body>
	<%
	session.setAttribute("error", null);
	if (session.getAttribute("mensajeList") != null) {
	%>
	<h2><%=session.getAttribute("mensajeList")%></h2>
	<%
	}
	Boolean admin = (Boolean) session.getAttribute("admin");
	%>
	<table>
		<thead>
			<th>Nombre</th>
			<th>Categoria</th>
			<th>Precio</th>
			<th>Stock</th>
			<%
			if (admin) {
			%>
			<th>Modificar</th>
			<th>Eliminar</th>
			<%
			}
			if (session.getAttribute("listaProductos") != null) {
			LinkedList<Producto> lista = (LinkedList<Producto>) session.getAttribute("listaProductos");
			for (Producto prod : lista) {
			%>
			<tr>
				<td><%=prod.getNombre()%></td>
				<td><%=prod.getCategoria()%></td>
				<td><%=prod.getPrecio()%>€</td>
				<td><%=prod.getStock()%></td>
				<%
				if (admin) {
				%>
				<th><a
					href="ModificarProducto?nombre=<%=prod.getNombre()%>&categoria=<%=prod.getCategoria()%>&precio=<%=prod.getPrecio()%>&stock=<%=prod.getStock()%>">📝Modificar</a></th>
				<th><a href="EliminarProducto?nombre=<%=prod.getNombre()%>">🚮Eliminar</a></th>
				<%
				}
				%>
			</tr>
			<%
			}
			}
			%>
		</thead>
		<button>
			<a href="menu.jsp">Volver</a>
		</button>
	</table>
</body>
</html>