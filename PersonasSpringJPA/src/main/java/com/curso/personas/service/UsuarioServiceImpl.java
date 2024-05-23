package com.curso.personas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.personas.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	EntityManagerFactory emf;
	EntityManager em;
	
	public UsuarioServiceImpl() {
		Persistence.generateSchema("personas", null);
		emf = Persistence.createEntityManagerFactory("personas");
		em = emf.createEntityManager();
	}
	@Override
	public List<Usuario> usuarios() {
		
		return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	}

	@Override
	public Usuario usuario(int id) {
		TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u WHERE id=:id", Usuario.class);
		consulta.setParameter("id", id);
		return consulta.getSingleResult();
	}

	@Override
	public void altaUsuario(Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		em.getTransaction().begin();
		Usuario user = em.find(Usuario.class, usuario.getId());
		user.setUsername(usuario.getUsername());
		user.setLocalidad(usuario.getLocalidad());
		user.setEdad(usuario.getEdad());
		em.getTransaction().commit();
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		em.getTransaction().begin();
		Usuario user = em.find(Usuario.class, usuario.getId());
		em.remove(user);
		em.getTransaction().commit();
		
	}


}
