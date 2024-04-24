package semana3.ejemplosCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1 {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bdpersonas";
		try (Connection con = DriverManager.getConnection(cadenaConexion, "root", "root");
				Statement stmt = con.createStatement()) {
			stmt.executeUpdate("INSERT INTO persona (nombre,apellido,edad) values ('edith','gonzalez',26);");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
