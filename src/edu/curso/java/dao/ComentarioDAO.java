package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;


public interface ComentarioDAO extends GenericDAO<Comentario, Long> {

	
	
	public List<Comentario> listarComentarios();
	
	
}
