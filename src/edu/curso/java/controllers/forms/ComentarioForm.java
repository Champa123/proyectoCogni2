package edu.curso.java.controllers.forms;

import javax.persistence.*;

@Entity
public class ComentarioForm {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String comentario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
