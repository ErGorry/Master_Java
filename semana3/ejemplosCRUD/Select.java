package semana3.ejemplosCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bdpersonas";
		String user = "root";
		String pwd = "root";
		String query = "SELECT * FROM persona";
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);
				Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("Nombre: " + rs.getString("nombre") + ", ");
				System.out.print("Apellido: " + rs.getString("apellido") + ", ");
				System.out.print("Apellido: " + rs.getInt("edad") + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
