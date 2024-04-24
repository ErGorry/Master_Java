package semana3.empleadosBBDD.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import semana3.empleadosBBDD.conexion.Conexion;

public class EmpleadoCRUDRepository {
	private static final String COL_ID = "id";
	private static final String COL_NOMBRE = "nombre";
	private static final String COL_APELLIDO = "apellido";
	private static final String COL_FECHA_NAC = "fecha_nacimiento";
	private static final String COL_FECHA_CON = "fecha_contratacion";
	private static final String COL_DPTO = "departamento";
	private static final String COL_SALARIO = "salario";

	private static Connection con = null;

	public EmpleadoCRUDRepository() {
		con = Conexion.getConnection();
	}

	List<Empleado> getAllEmpleados() {
		String query = "SELECT * FROM empleados";
		return obtenerLista(query);
	}

	Empleado getEmpleadoById(int id) {
		String query = "SELECT * FROM empleados WHERE id = ?";
		Empleado emp = null;
		try (PreparedStatement prepS = con.prepareStatement(query)) {
			prepS.setInt(1, id);
			ResultSet rs = prepS.executeQuery();
			if (rs.next()) {
				emp.setId(rs.getInt(COL_ID));
				emp.setNombre(rs.getString(COL_NOMBRE));
				emp.setApellido(rs.getString(COL_APELLIDO));
				emp.setFechaNacimiento(rs.getDate(COL_FECHA_NAC));
				emp.setFechaContratacion(rs.getDate(COL_FECHA_CON));
				emp.setDepartamento(rs.getString(COL_DPTO));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	List<Empleado> getEmpleadosByDepartamento(String dpto) {
		String query = "SELECT * FROM empleados WHERE departamento = ?";
		return obtenerLista(query, Empleado.validarDpto(dpto).toString());
	}

	List<Empleado> getEmpleadosByApellido(String apellido) {
		String query = "SELECT * FROM empleados WHERE apellido = ?";
		return obtenerLista(query, apellido);
	}

	List<Empleado> getEmpleadosByNombre(String nombre) {
		String query = "SELECT * FROM empleados WHERE nombre = ?";
		return obtenerLista(query, nombre);
	}

	List<Empleado> getEmpleadosByMayorSalarioQue(boolean salario) {
		String query = "SELECT * FROM empleados WHERE salario > ?";
		return obtenerLista(query, String.valueOf(salario));
	}

	void insertarEmpleado(Empleado emp) {
		String query = "INSERT INTO empleados (nombre, apellidos, fecha_nacimiento,"
				+ " fecha_contratacion, departamento, salario) VALUES(?,?,?,?,?,?)";
		try (PreparedStatement prepS = con.prepareStatement(query)) {
			setStatementEmpleado(emp, prepS);
			prepS.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateEmpleado(Empleado emp, int id) {
		if (!emp.equals(getEmpleadoById(id))) {
			String query = "UPDATE empleados SET nombre = ?, apellido = ?, fecha_nacimiento = ?,"
					+ " fecha_contratacion = ?, departamento = ?, salario = ? WHERE id = ?";
			try (PreparedStatement prepS = con.prepareStatement(query)) {
				setStatementEmpleado(emp, prepS);
				prepS.setInt(7, id);
				prepS.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void deleteEmpleadoById(int id) {
		String query = "DELETE FROM empleados WHERE id = ?";
		try (PreparedStatement prepS = con.prepareStatement(query)) {
			prepS.setInt(1, id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void deleteListaEmpleados(List<Empleado> list) {
		for (Empleado empleado : list) {
			deleteEmpleadoById(empleado.getId());
		}
	}

	private List<Empleado> obtenerLista(String query) {
		List<Empleado> lista = new ArrayList<>();
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				lista.add(crearEmpleadoDesdeBBDD(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	private List<Empleado> obtenerLista(String query, String... params) {
		List<Empleado> lista = new ArrayList<>();
		try (PreparedStatement prepStmt = con.prepareStatement(query);) {
			for (int i = 1; i <= params.length; i++) {
				prepStmt.setString(i, params[i]);
			}
			ResultSet rs = prepStmt.executeQuery(query);
			while (rs.next()) {
				lista.add(crearEmpleadoDesdeBBDD(rs));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	private Empleado crearEmpleadoDesdeBBDD(ResultSet rs) throws SQLException {
		return new Empleado(rs.getInt(COL_ID), rs.getString(COL_NOMBRE), rs.getString(COL_APELLIDO),
				rs.getDate(COL_FECHA_NAC), rs.getDate(COL_FECHA_CON), rs.getString(COL_DPTO),
				rs.getDouble(COL_SALARIO));
	}

	private void setStatementEmpleado(Empleado emp, PreparedStatement prepS) throws SQLException {
		prepS.setString(1, emp.getNombre());
		prepS.setString(2, emp.getApellido());
		prepS.setDate(3, emp.getFechaNacimiento());
		prepS.setDate(4, emp.getFechaContratacion());
		prepS.setString(5, emp.getDepartamento().toString());
		prepS.setDouble(6, emp.getSalario());
	}

}
