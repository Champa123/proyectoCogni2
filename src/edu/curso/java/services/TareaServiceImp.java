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
public class TareaServiceImp implements TareaService {

	@Autowired
	TareaDAO tareaDAO;
	@Autowired
	ComentarioDAO comentarioDAO;
	

	@Override
	public Long guardarTarea(Tarea tarea) {
		return tareaDAO.guardarTarea(tarea);

	}

	
	@Override
	public Tarea recuperarTareaPorId(Long id) {
		return tareaDAO.recuperarTareaPorId(id);
	}

	
	@Override
	public void borrarTareaPorId(Long id) {
		tareaDAO.borrarTareaPorId(id);
			
	}

	@Override
	public void editarTarea(Tarea tarea) {
		tareaDAO.editarTarea(tarea);
		
	}


	@Override
	public List<Tarea> listarTareas() {
		List<Tarea> tareas = tareaDAO.listarTareas();
		return tareas;
	}

	@Override
	public List<Tarea> buscarTareasPorNombre(String textoTarea) {
		return tareaDAO.buscarTareasPorNombre(textoTarea);
	}

	@Override
	public Long guardarComentarioTarea(Comentario comentario, Long idTarea){
		Tarea tarea = tareaDAO.recuperarTareaPorId(idTarea);
		tarea.getComentarios().add(comentario);
		tareaDAO.editarTarea(tarea);
		Long idActual=comentarioDAO.guardarComentario(comentario);
		
		return idActual;
	}


	@Override
	public void desligarUsuario(Usuario usuario) {
		List<Tarea> tareas = buscarTareasPorIdUsuario(usuario.getId());
		for (Tarea tarea : tareas) {
			tarea.quitarUsuario(usuario);
			editarTarea(tarea);
		}
	}


	public List<Tarea> buscarTareasPorIdUsuario(Long id) {
		return tareaDAO.buscarTareasPorIdUsuario(id);
	}
	
	
}
