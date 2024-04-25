package semana3.empleadosBBDD.principal;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import semana3.empleadosBBDD.clases.Empleado;
import semana3.empleadosBBDD.clases.EmpleadoCRUDRepository;

public class PrincipalEmpleados {
	static List<Empleado> lista = new ArrayList<>();

	public static void main(String[] args) {
		int opcion;
		int empleadoId;
		String result;
		String metodo;

		EmpleadoCRUDRepository crud = new EmpleadoCRUDRepository();
		
		StringBuilder menuPrincipal = new StringBuilder();
		menuPrincipal.append("-----------Opciones:\n");
		menuPrincipal.append("1. Listar empleados.\n");
		menuPrincipal.append("2. Insertar empleado.\n");
		menuPrincipal.append("0. Salir.");
		StringBuilder menuListar = new StringBuilder();
		menuListar.append("-----------Opciones:\n");
		menuListar.append("1. Todos.\n");
		menuListar.append("2. Por departamento.\n");
		menuListar.append("3. Por nombre.\n");
		menuListar.append("4. Por apellido.\n");
		menuListar.append("5. Por salario mayor al indicado.\n");
		menuListar.append("0. Salir.");
		StringBuilder menuEmpleados = new StringBuilder();
		menuEmpleados.append("---------Que deseas hacer:\n");
		menuEmpleados.append("1. Eliminar.\n");
		menuEmpleados.append("2. Actualizar datos.\n");
		menuEmpleados.append("0. Salir.");
		do {
			opcion = Integer.valueOf(JOptionPane.showInputDialog(menuPrincipal.toString()));
			switch (opcion) {
			case 1:
				opcion = Integer.valueOf(JOptionPane.showInputDialog(menuListar.toString()));
				switch (opcion) {
				case 1:
					result = listarEmpleados(crud.getAllEmpleados());
					empleadoId = Integer.valueOf(JOptionPane.showInputDialog(result));
					opcionesEmpleado(empleadoId, crud, menuEmpleados);
					break;
				case 2:
					metodo = JOptionPane.showInputDialog("Escribe el departamento: ");
					result = listarEmpleados(crud.getEmpleadosByDepartamento(metodo));
					empleadoId = Integer.valueOf(JOptionPane.showInputDialog(result));
					opcionesEmpleado(empleadoId, crud, menuEmpleados);
					break;
				case 3:
					metodo = JOptionPane.showInputDialog("Escribe el nombre: ");
					result = listarEmpleados(crud.getEmpleadosByNombre(metodo));
					empleadoId = Integer.valueOf(JOptionPane.showInputDialog(result));
					opcionesEmpleado(empleadoId, crud, menuEmpleados);
					break;
				case 4:
					metodo = JOptionPane.showInputDialog("Escribe el apellido: ");
					result = listarEmpleados(crud.getEmpleadosByApellido(metodo));
					empleadoId = Integer.valueOf(JOptionPane.showInputDialog(result));
					opcionesEmpleado(empleadoId, crud, menuEmpleados);
					break;
				case 5:
					metodo = JOptionPane.showInputDialog("Escribe el salario minimo del filtro: ");
					result = listarEmpleados(crud.getEmpleadosByApellido(metodo));
					empleadoId = Integer.valueOf(JOptionPane.showInputDialog(result));
					opcionesEmpleado(empleadoId, crud, menuEmpleados);
					break;

				default:
					break;
				}
				break;
			case 2:
				Empleado emp = new Empleado(JOptionPane.showInputDialog("Escribe el nombre:"),
						JOptionPane.showInputDialog("Escribe el apellido:"),
						Date.valueOf(
								JOptionPane.showInputDialog("Escribe la fecha de nacimiento en formato: yyyy-mm-dd")),
						Date.valueOf(
								JOptionPane.showInputDialog("Escribe la fecha de contratacion en formato: yyyy-mm-dd")),
						JOptionPane.showInputDialog("Escribe el departamento: "),
						Double.valueOf(JOptionPane.showInputDialog("Escribe el salario: xxxxx,xx")));
				crud.insertEmpleado(emp);

				break;
			default:
				break;
			}
		} while (opcion != 0);

	}

	private static void opcionesEmpleado(int empleadoId, EmpleadoCRUDRepository crud, StringBuilder menuEmpleados) {
		int opcion;
		opcion = Integer.valueOf(JOptionPane.showInputDialog(menuEmpleados.toString()));
		switch (opcion) {
		case 1:
			crud.deleteEmpleadoById(empleadoId);
			break;
		case 2:
			Empleado emp = new Empleado(empleadoId, JOptionPane.showInputDialog("Escribe el nombre:"),
					JOptionPane.showInputDialog("Escribe el apellido:"),
					Date.valueOf(JOptionPane.showInputDialog("Escribe la fecha de nacimiento en formato: yyyy-mm-dd")),
					Date.valueOf(
							JOptionPane.showInputDialog("Escribe la fecha de contratacion en formato: yyyy-mm-dd")),
					JOptionPane.showInputDialog("Escribe el departamento: "),
					Double.valueOf(JOptionPane.showInputDialog("Escribe el salario: xxxxx.xx")));
			crud.updateEmpleado(emp, empleadoId);
			break;
		default:
			break;
		}
	}

	private static String listarEmpleados(List<Empleado> allEmpleados) {
		StringBuilder result = new StringBuilder();
		lista = allEmpleados;
		result.append("Selecciona uno: \n");
		for (Iterator<Empleado> iterator = allEmpleados.iterator(); iterator.hasNext();) {
			Empleado empleado = iterator.next();
			result.append(empleado.toString() + "\n");
		}
		result.append("Escribe una letra para salir \n");
		return result.toString();
	}

}
