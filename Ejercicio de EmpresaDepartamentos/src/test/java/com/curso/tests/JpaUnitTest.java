package com.curso.tests;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class JpaUnitTest {
	static EntityManagerFactory emf;
	static EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Persistence.generateSchema("empresa", null);
		emf = Persistence.createEntityManagerFactory("empresa");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.clear();
		em.close();
	}

	@Test
	void EntityManagerFactoryTest() {
		assertNotNull(emf);
	}
	@Test
	void EntityManagerTest() {
		assertNotNull(em);
	}

}
