package com.curso.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.curso.model.Departamento;
import com.curso.model.Empleado;
import com.curso.repository.EmpleadoRepositoryImpl;
@TestMethodOrder(OrderAnnotation.class)
class EmpleadoRepositoryTest extends JpaUnitTest {
	EmpleadoRepositoryImpl repo;

	@BeforeEach
	void setRepository() {
		repo = new EmpleadoRepositoryImpl();
		repo.setEm(em);
	}

	@Test
	void repositoryTest() {
		assertNotNull(repo);
		assertNotNull(repo.getEm());
	}

	@Test
	void getOneTest() {
		Empleado emp = repo.getOne(1);
		assertNotNull(emp);
	}

	@Test
	void getAllTest() {
		List<Empleado> lista = repo.getAll();
		assertFalse(lista.isEmpty());;
	}

	@Test
	@Order(0)
	void saveTest() {
		Departamento dep = em.find(Departamento.class, 2);
		Empleado emp = new Empleado("Prueba", LocalDate.now(), 1, dep);
		repo.save(emp);
		assertEquals("Prueba",
				repo.getAll().stream().filter(e -> e.getNombre().equals("Prueba")).toList().get(0).getNombre());
	}

	@Test
	@Order(1)
	void deleteTest() {
		Empleado emp = em.find(Empleado.class, 5);
		int idEmpleado = emp.getIdEmpleado();
		repo.delete(emp);
		assertNull(em.find(Empleado.class,idEmpleado));
	}

}
