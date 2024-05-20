package com.curso.repository;

import java.util.List;

import com.curso.model.Departamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class DepartamentoRepositoryImpl implements DepartamentoRepository {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Departamento getOne(int idDepartamento) {
		return em.find(Departamento.class, idDepartamento);
	}

	public List<Departamento> getAll() {
		return em.createNamedQuery("Departamento.getAll", Departamento.class).getResultList();
	}

	public void save(Departamento departamento) {
		em.getTransaction().begin();
		em.persist(departamento);
		em.getTransaction().commit();
	}

	public void delete(Departamento departamento) {
		em.getTransaction().begin();
		em.remove(departamento);
		em.getTransaction().commit();
	}

}