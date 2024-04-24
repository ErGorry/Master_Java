package semana3.ejemplosCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prepared {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/bdpersonas";
		String user = "root";
		String pwd = "root";

		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pwd);
				PreparedStatement preStmt = generarConsultaParametrizada("SELECT * FROM persona WHERE nombre = ?;",
						"alvaro", con);
				ResultSet rs = preStmt.executeQuery();) {

			while (rs.next()) {
				System.out.print("Nombre: " + rs.getString("nombre") + ", ");
				System.out.print("Apellido: " + rs.getString("apellido") + ", ");
				System.out.print("Edad: " + rs.getInt("edad") + "\n");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static PreparedStatement generarConsultaParametrizada(String consulta, String parametro, Connection con)
			throws SQLException {
		PreparedStatement prepStmt = con.prepareStatement(consulta);
		prepStmt.setString(1, parametro);
		return prepStmt;
	}

}
