package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;


public interface ComentarioDAO {

	public Long guardarComentario(Comentario comentario);
	
	public List<Comentario> listarComentarios();
	
	Comentario recuperarComentarioPorId(Long id);
	
	public void borrarComentario(Long id);
}
