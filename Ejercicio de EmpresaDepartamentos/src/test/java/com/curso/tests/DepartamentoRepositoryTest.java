package com.curso.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.curso.model.Departamento;
import com.curso.model.Empleado;
import com.curso.repository.DepartamentoRepositoryImpl;
import com.curso.repository.EmpleadoRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
class DepartamentoRepositoryTest extends JpaUnitTest {
	DepartamentoRepositoryImpl repo;
	
	@BeforeEach
	void setRepository(){
		repo = new DepartamentoRepositoryImpl();
		repo.setEm(em);
	}

	@Test
	void repositoryTest() {
		assertNotNull(repo);
		assertNotNull(repo.getEm());
	}
	
	@Test
	void getOneTest() {
		Departamento dep = repo.getOne(1);
		assertNotNull(dep);
	}
	
	@Test 
	void getAllTest(){
		List<Departamento> lista = repo.getAll();
		assertFalse(lista.isEmpty());
	}
	
	@Test
	@Order(4)
	void saveTest() {
		Departamento dep = new Departamento("Prueba", "CiudadFalsa");
		repo.save(dep);
		assertTrue(
				repo.getAll().stream().filter(d -> d.getNombre().equals("Prueba")).toList().size()>0);
	}
	@Test
	@Order(5)
	void deleteTest() {
		Departamento dep = em.find(Departamento.class, 6);
		repo.delete(dep);
		assertNull(em.find(Departamento.class,6));
	}

}
