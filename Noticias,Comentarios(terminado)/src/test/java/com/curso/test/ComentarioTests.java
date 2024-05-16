package com.curso.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.model.Comentario;
import com.curso.model.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 * Test de la funcionalidad de la BBDD con JPA
 * @author Admin
 *
 */
class ComentarioTests {

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
	void seleccionarComentarioTest() {
		Comentario coment = em.find(Comentario.class, 1);
		assertNotNull(coment);
	}
	@Test
	void insertarComentario() {
		em.getTransaction().begin();
		Comentario coment = new Comentario( "Test", "Test");
		Noticia noticia = em.find(Noticia.class, "Las acciones suben");
		coment.setTituloNoticia(noticia);
		em.persist(coment);
		em.getTransaction().commit();
		Comentario comentarioInsertada = em.find(Comentario.class, 5);
		assertEquals("Test", comentarioInsertada.getTexto());
	}
	@Test
	void eliminarComentario() {
		em.getTransaction().begin();
		Comentario coment = em.find(Comentario.class, 2);
		em.remove(coment);
		em.getTransaction().commit();
		Comentario comentarioEliminado = em.find(Comentario.class, 2);
		assertNull(comentarioEliminado);
	}
	@Test
	void modificarcomentario() {
		em.getTransaction().begin();
		Comentario coment = em.find(Comentario.class, 2);
		coment.setAutor("Test");
		em.persist(coment);
		em.getTransaction().commit();
		Comentario comentarioModificado = em.find(Comentario.class, 2);
		assertEquals("Test", comentarioModificado.getAutor());
	}

}
