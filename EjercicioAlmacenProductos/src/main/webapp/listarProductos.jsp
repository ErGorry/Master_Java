<%@page import="java.util.List"%>
<%@page import="com.curso.tienda.model.Producto"%>
<%@page import="com.curso.tienda.service.ProductoService"%>
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
	Boolean admin = (Boolean) session.getAttribute("admin");
	List<Producto> lista = null;
	if (session.getAttribute("listaProductos") != null) {
		lista = (List<Producto>) session.getAttribute("listaProductos");
	} else {
		lista = ProductoService.listaProductos();
	}
	%>
	<h2>
		Se han encontrado
		<%=lista.size()%>
		productos.
	</h2>
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
				<th><a
					href="EliminarProducto?nombre=<%=prod.getNombre()%>&categoria=<%=prod.getCategoria()%>">🚮Eliminar</a></th>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</thead>
		<button>
			<a href="menu.jsp">Volver</a>
		</button>
	</table>
</body>
</html>