package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Comentario;


public interface ComentarioService {


	public Long guardarComentario(Comentario comentario);
	
	public List<Comentario> listarComentarios();
	
	Comentario recuperarComentarioPorId(Long id);
	
	public void borrarComentario(Long idComentario, Long idTarea);
}