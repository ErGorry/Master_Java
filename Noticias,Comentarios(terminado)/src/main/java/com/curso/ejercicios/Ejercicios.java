package com.curso.ejercicios;

import java.util.Date;
import java.util.List;

import com.curso.model.Comentario;
import com.curso.model.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
/**
 * Ejercicios inventados para practicar
 * @author Admin
 *
 */
public class Ejercicios {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("periodico");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Crear una noticia nueva: Se acabo la liga");
		ejercicio1(em, "Se acabo la liga");
		
		System.out.println("Añadir tres comentarios positivos");
		ejericio2(em);
		
		System.out.println("Ver la noticia con mas comentarios y listar sus comentarios");
		ejercicio3(em);
		
		System.out.println("Modificar la noticia que se creo antes");
		ejercicio4(em, "Se acabo la liga");
		
		System.out.println("Modificar el comentario con id 3");
		ejericio5(em, 3);
		
		System.out.println("Mostrar el autor con mayor numero de noticias publicadas");
		ejercicio6(em);
		
		System.out.println("Mostrar el autor con mayor numero de comentarios publicados");
		ejercicio7(em);

	}

	private static void ejercicio1(EntityManager em, String titulo) {
		em.getTransaction().begin();
		Noticia not = new Noticia(titulo, "Marcela", new Date());
		em.persist(not);
		em.getTransaction().commit();

	}

	private static void ejericio2(EntityManager em) {
		em.getTransaction().begin();
		Noticia noti = em.find(Noticia.class, "Se acabo la liga");
		Comentario com1 = new Comentario("Campeones!!!", "Emilia");
		Comentario com2 = new Comentario("Otro año sera", "Juan");
		Comentario com3 = new Comentario("Que liga?", "Diego");
		com1.setTituloNoticia(noti);
		com2.setTituloNoticia(noti);
		com3.setTituloNoticia(noti);
		List<Comentario> lista = noti.getListaComentarios();
		lista.add(com1);
		lista.add(com2);
		lista.add(com3);
		noti.setListaComentarios(lista);
		em.persist(com1);
		em.persist(com2);
		em.persist(com3);
		em.getTransaction().commit();

	}

	private static void ejercicio3(EntityManager em) {
		TypedQuery<Noticia> consulta = em
				.createQuery("SELECT c.noticia FROM Comentario c GROUP BY c.noticia ORDER BY COUNT(c) DESC LIMIT 1", Noticia.class);
		Noticia not = consulta.getSingleResult();
		System.out.println(not);
		for (Comentario com : not.getListaComentarios()) {
			System.out.println(com);
		}

		
	}

	private static void ejercicio4(EntityManager em, String titulo) {
		em.getTransaction().begin();
		Noticia not = em.find(Noticia.class, titulo);
		not.setAutor("Nuevo autor");
		em.persist(not);
		TypedQuery<Noticia> consulta = em.createNamedQuery("Noticia.byTitulo",Noticia.class);
		consulta.setParameter("titulo", titulo);
		Noticia noti = consulta.getSingleResult();
		System.out.println(noti);
		em.getTransaction().commit();
		

	}

	private static void ejericio5(EntityManager em, int id) {
		TypedQuery<Comentario> consulta = em.createNamedQuery("comentario.byId", Comentario.class);
		consulta.setParameter("id", id);
		Comentario coment = consulta.getSingleResult();
		System.out.println(coment);

	}

	private static void ejercicio6(EntityManager em) {
		TypedQuery<String> query = em.createQuery("SELECT n.autor FROM Noticia n GROUP BY n.autor ORDER BY COUNT(n) DESC LIMIT 1", String.class);
		String autor = query.getSingleResult();
		System.out.println(autor);
	}

	private static void ejercicio7(EntityManager em) {
		TypedQuery<String> query = em.createQuery("SELECT c.autor FROM Comentario c GROUP BY c.autor ORDER BY COUNT(c) DESC LIMIT 1", String.class);
		String autor = query.getSingleResult();
		System.out.println(autor);

	}

}
