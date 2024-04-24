package semana3.empleadosBBDD.clases;

import java.sql.Date;
import java.util.Objects;

public class Empleado {

	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Date fechaContratacion;
	private Departamento departamento;
	private double salario;

	public Empleado() {
		super();
	}

	public Empleado(int id, String nombre, String apellido, Date fechaNacimiento, Date fechaContratacion,
			String departamento, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaContratacion = fechaContratacion;
		this.departamento = validarDpto(departamento);
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = validarDpto(departamento);
	}

	public static Departamento validarDpto(String dpto) {
		for (Departamento salida : Departamento.values()) {
			if (dpto.equalsIgnoreCase(salida.toString())) {
				return salida;
			}
		}
		return Departamento.PRODUCCION;

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, departamento, fechaContratacion, fechaNacimiento, nombre, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellido, other.apellido) && departamento == other.departamento
				&& Objects.equals(fechaContratacion, other.fechaContratacion)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
	

}
