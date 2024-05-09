<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/estilo.css">
</head>
<body>
<h2>Bienvenido a la tienda Master_Java</h2>

	<p>En esta tienda puede explorar nuestros productos de diferentes
		categorías</p>
	<form action="Login" method="post">
	<p>{admin,admin}Para obtener funcionalidad completa</p>
		<div>
			<label for="userName">Nombre de usuario:</label><input type="text"
				name="userName">
		</div>
		<div>
			<label for="userPass">Contraseña:</label><input type="text"
				name="userPass">
		</div>
		<button type="submit">Iniciar Sesion</button>
	</form>
</body>
</html>
