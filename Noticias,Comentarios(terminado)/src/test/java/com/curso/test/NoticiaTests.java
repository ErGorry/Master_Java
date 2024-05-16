package com.curso.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.model.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 * Test de la funcionalidad de la BBDD con JPA
 * @author Admin
 *
 */
class NoticiaTests {

	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeEach
	void iniciar() {
		emf = Persistence.createEntityManagerFactory("periodico");
		em = emf.createEntityManager();
		assertNotNull(emf);
		assertNotNull(em);
	}
	@Test
	void selecccionarNoticia() {
		Noticia noticia = em.find(Noticia.class, "Las acciones suben");
		assertNotNull(noticia);
	}
	@Test
	void insertarNoticia() {
		em.getTransaction().begin();
		Noticia noticia = new Noticia("Test", "Test", new Date());
		em.persist(noticia);
		em.getTransaction().commit();
		Noticia noticiaInsertada = em.find(Noticia.class, "Test");
		assertEquals("Test", noticiaInsertada.getTitulo());
	}
	@Test
	void eliminarNoticia() {
		em.getTransaction().begin();
		Noticia noticia = em.find(Noticia.class, "Sin comentarios");
		em.remove(noticia);
		em.getTransaction().commit();
		Noticia noticiaEliminada = em.find(Noticia.class, "Sin comentarios");
		assertNull(noticiaEliminada);
	}
	@Test
	void modificarNoticia() {
		em.getTransaction().begin();
		Noticia noticia = em.find(Noticia.class, "Las acciones suben");
		noticia.setAutor("Test");
		em.persist(noticia);
		em.getTransaction().commit();
		Noticia noticiaModificada = em.find(Noticia.class, "Las acciones suben");
		assertEquals("Test",noticiaModificada.getAutor());
	}
}
