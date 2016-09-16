package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;

import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface TareaDAO extends GenericDAO<Tarea, Long> {
	
	List<Tarea> listarTareas();

	public List<Tarea> buscarTareasPorNombre(String textoTarea);

	public List<Tarea> buscarTareasPorIdUsuario(Long id);
}
