package edu.curso.java.services;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Comentario;
public interface ComentarioService {
	
	
	
	void borrarComentario(Long id);
	
	Comentario recuperarComentarioPorId(Long id);

	public Comentario guardarComentario(Comentario comentario);
}
