package com.curso.principales;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.curso.model.Departamento;
import com.curso.model.Empleado;
import com.curso.restore.Generar;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Ejercicios {

	public static void main(String[] args) {
		Generar.main(args);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empresa");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Crear un departamento y asignarle tres nuevos trabajadores:");
		ejercicio1(em);
		System.out.println("Crear un nuevo empleado y asignarlo a un departamento existente = 3");
		ejercicio2(em,3);
		System.out.println("Dados dos empleados ( 7, 23), muestra por pantalla el que lleva menos tiempo en la empresa");
		ejercicio3(em,7,23);
		System.out.println("Muestra todos los departamentos");
		ejercicio4(em);
		System.out.println("Muestra todos los empleados del departamento 3");
		ejercicio5(em,3);
		System.out.println("Selecciona los departamentos con menor numero de empleados");
		ejercicio6(em);
		System.out.println("Selecciona los empleados que ganan menos sueldo que la media");
		ejercicio7(em);
	}

	private static void ejercicio7(EntityManager em) {
		TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.sueldo < (SELECT AVG(e.sueldo) FROM Empleado e)", Empleado.class);
		List<Empleado> lista = query.getResultList();
		for (Empleado empleado : lista) {
			System.out.println(empleado);
		}
	}

	private static void ejercicio6(EntityManager em) {
		TypedQuery<Integer> queryInt = em.createQuery("SELECT SIZE(e.listaEmpleados) FROM Departamento e", Integer.class);
		List<Integer> listaInt = queryInt.getResultList();
		Collections.sort(listaInt);
		int emp = listaInt.get(0);
		TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d WHERE SIZE(d.listaEmpleados) <= :emp", Departamento.class);
		query.setParameter("emp", emp);
		List<Departamento> lista = query.getResultList();
		for (Departamento departamento : lista) {
			System.out.println(departamento);
		}
	}

	private static void ejercicio5(EntityManager em, int departamento) {
		TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.idDepartamento.idDepartamento = :departamento", Empleado.class);
		query.setParameter("departamento", departamento);
		List<Empleado> lista = query.getResultList();
		for (Empleado empleado : lista) {
			System.out.println(empleado);
		}
		
	}

	private static void ejercicio4(EntityManager em) {
		TypedQuery<Departamento> query = em.createNamedQuery("Departamento.getAll", Departamento.class);
		List<Departamento> lista = query.getResultList();
		for (Departamento departamento : lista) {
			System.out.println(departamento);
		}
		
	}

	private static void ejercicio3(EntityManager em, int empleado1, int empleado2) {
		Empleado emp1 = em.find(Empleado.class, empleado1);
		Empleado emp2 = em.find(Empleado.class, empleado2);
		emp1.minAntiguedad(emp2);
	}

	private static void ejercicio2(EntityManager em,int depart) {
		em.getTransaction().begin();
		
		Departamento dep = em.find(Departamento.class, depart);
		Empleado emp = new Empleado("ejercicio2", LocalDate.now(),1);
		emp.setIdDepartamento(dep);
		
		List<Empleado> lista = dep.getListaEmpleados();
		lista.add(emp);
		dep.setListaEmpleados(lista);
		
		//em.persist(dep);
		em.persist(emp);
		
		em.getTransaction().commit();
	}

	private static void ejercicio1(EntityManager em) {
		em.getTransaction().begin();
		Departamento dep = new Departamento(6, "Departamento de alvaros", "Ciudad falsa");
		
		Empleado emp1 = new Empleado("Alvaro", LocalDate.now(), 1);
		Empleado emp2 = new Empleado("Alvaro", LocalDate.now(), 1);
		Empleado emp3 = new Empleado("Alvaro", LocalDate.now(), 1);
		emp1.setIdDepartamento(dep);
		emp2.setIdDepartamento(dep);
		emp3.setIdDepartamento(dep);
		
		List<Empleado> lista = dep.getListaEmpleados();
		lista.add(emp1);
		lista.add(emp2);
		lista.add(emp3);
		dep.setListaEmpleados(lista);
		
		em.persist(dep);
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		
		em.getTransaction().commit();
		
		
	}

}
