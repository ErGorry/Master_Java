package com.curso.repository;

import java.util.List;

import com.curso.model.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class EmpleadoRepositoryImpl implements EmpleadoRepository {


	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Empleado getOne(int idEmpleado) {
		return em.find(Empleado.class, idEmpleado);
	}

	public List<Empleado> getAll() {
		return em.createNamedQuery("Empleado.getAll", Empleado.class).getResultList();
	}

	public void save(Empleado empleado) {
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();
	}

	public void delete(Empleado empleado) {
		em.getTransaction().begin();
		em.remove(empleado);
		em.getTransaction().commit();
	}

}