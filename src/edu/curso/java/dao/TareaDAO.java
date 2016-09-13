package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Comentario;

import edu.curso.java.bo.Tarea;

public interface TareaDAO {

	public Long guardarTarea(Tarea tarea);
	
	Tarea recuperarTareaPorId(Long id);

	void borrarTareaPorId(Long id);
	

	void editarTarea(Tarea tarea);
	
	List<Tarea> listarTareas();
}
