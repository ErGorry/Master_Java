package semana3.ejemplosCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bdpersonas";
		String user = "root";
		String pwd = "root";
		String query = "UPDATE persona SET edad = 28 where nombre = 'pepito'";
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);
				Statement stmt = con.createStatement()) {
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
