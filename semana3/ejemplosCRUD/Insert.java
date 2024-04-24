package semana3.ejemplosCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bdpersonas";
		String user = "root";
		String pwd = "root";
		String query = "INSERT INTO persona values ('pepito','sera',20);";
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);
				Statement stmt = con.createStatement()) {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
