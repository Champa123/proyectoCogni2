package edu.curso.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.dao.ComentarioDAO;



@Service
@Transactional
public class ComentarioServiceImp implements ComentarioService{

	@Autowired
	private ComentarioDAO comentarioDAO;
	

	@Override
	public void borrarComentario(Long id) {
		comentarioDAO.borrarComentario(id);		
	}
	
	
	@Override
	public Comentario recuperarComentarioPorId(Long id) {
		
		return comentarioDAO.recuperarComentarioPorId(id);
	}

	@Override
	public Comentario guardarComentario(Comentario comentario) {
		return comentarioDAO.guardarComentario(comentario);
		
	}



	
}
