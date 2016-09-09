package edu.curso.java.dao;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;

public interface ComentarioDAO {

	void borrarComentario(Long id);

	Comentario recuperarComentarioPorId(Long id);

	Comentario guardarComentario(Comentario comentario);
}
