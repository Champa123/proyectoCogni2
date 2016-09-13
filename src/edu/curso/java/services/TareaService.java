package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Comentario;

import edu.curso.java.bo.Tarea;

public interface TareaService {

	public Long guardarTarea(Tarea tarea);
		
	Tarea recuperarTareaPorId(Long id);

	void borrarTareaPorId(Long id);
	
	void editarTarea(Tarea tarea);
	
	List<Tarea> listarTareas();
	
	public Long guardarComentarioTarea(Comentario comentario, Long idTarea);

}