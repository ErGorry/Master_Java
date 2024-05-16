package com.curso.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/**
 * 
 * @author Admin
 *
 */
@Entity
@Table(name="comentarios")
@NamedQueries({
	@NamedQuery(name="comentario.listar",query="SELECT c FROM Comentario c"),
	@NamedQuery(name="comentario.byId",query="SELECT c FROM Comentario c WHERE c.id=:id"),
	@NamedQuery(name="comentario.byAutor",query="SELECT c FROM Comentario c WHERE c.autor=:autor"),
	@NamedQuery(name="comentario.byNoticia",query="SELECT c FROM Comentario c WHERE c.noticia.titulo=:tituloNoticia")
})
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="texto")
	private String texto;
	@Column(name="autor")
	private String autor;
	@OneToOne()
	@JoinColumn(name="titulo_noticia")
	private Noticia noticia;
	public Comentario() {
	}
	public Comentario( String texto, String autor) {
		this.texto = texto;
		this.autor = autor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Noticia getTituloNoticia() {
		return noticia;
	}
	public void setTituloNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", texto=" + texto + ", autor=" + autor + ", tituloNoticia=" + noticia
				+ "]";
	}
	
	
	
}
