package com.curso.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 * 
 * @author Admin
 *
 */
@Entity
@Table(name="noticias")
@NamedQueries({
	@NamedQuery(name="Noticia.listar",query="SELECT n FROM Noticia n"),
	@NamedQuery(name="Noticia.byTitulo",query="SELECT n FROM Noticia n WHERE n.titulo=:titulo"),
	@NamedQuery(name="Noticia.byAutor",query="SELECT n FROM Noticia n WHERE n.autor=:autor"),
	@NamedQuery(name="Noticia.desdeFecha",query="SELECT n FROM Noticia n WHERE n.fecha>=:fecha")
	})
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="titulo")
	private String titulo;
	@Column(name="autor")
	private String autor;
	@Column(name="fecha")
	private Date fecha;
	@OneToMany(mappedBy="noticia")
	private List<Comentario> listaComentarios = new ArrayList<Comentario>();
	public Noticia() {
	}
	public Noticia(String titulo, String autor, Date fecha) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Comentario> getListaComentarios() {
		return listaComentarios;
	}
	public void setListaComentarios(List<Comentario> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		return Objects.equals(titulo, other.titulo);
	}
	@Override
	public String toString() {
		return "Noticia titulo=" + titulo + ", autor=" + autor + ", fecha=" + fecha;
	}

}
