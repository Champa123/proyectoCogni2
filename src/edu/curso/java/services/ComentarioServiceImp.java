package edu.curso.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.autocomplete.ItemAutoComplete;
import edu.curso.java.dao.ComentarioDAO;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.TareaDAO;
import edu.curso.java.dao.UsuarioDAO;

@Service
@Transactional
public class ComentarioServiceImp implements ComentarioService {

	@Autowired
	ComentarioDAO comentarioDAO;
	@Autowired
	TareaDAO tareaDAO;

	@Override
	public Long guardarComentario(Comentario comentario) {
		
		return comentarioDAO.guardar(comentario);
	}

	@Override
	public List<Comentario> listarComentarios() {
		
		return comentarioDAO.listarComentarios();
	}

	@Override
	public Comentario recuperarComentarioPorId(Long id) {
		
		return comentarioDAO.buscarPorId(id);
	}
	
	@Override
	public void borrarComentario(Long idComentario, Long idTarea) {
		Comentario comentario = comentarioDAO.buscarPorId(idComentario);
		Tarea tarea = tareaDAO.buscarPorId(idTarea);
		tarea.getComentarios().remove(comentario);
		tareaDAO.actualizar(tarea);
		
		comentarioDAO.borrar(comentario);
	}
	
}
