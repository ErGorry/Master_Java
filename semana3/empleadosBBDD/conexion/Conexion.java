package semana3.empleadosBBDD.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection conn = null;

	public static Connection getConnection() {

		if (conn == null) {
			new Conexion();
		}

		return conn;
	}

	private Conexion() {

		String url = "jdbc:mysql://localhost:3306/bdempleados";
		String usuario = "root";
		String password = "root";

		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, password);
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}

}
