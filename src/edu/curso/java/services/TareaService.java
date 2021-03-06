package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Comentario;

import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface TareaService {

	public Long guardarTarea(Tarea tarea);
		
	Tarea recuperarTareaPorId(Long id);

	void borrarTareaPorId(Long id);
	
	void editarTarea(Tarea tarea);
	
	List<Tarea> listarTareas();

	public List<Tarea> buscarTareasPorNombre(String textoTarea);
	
	public Long guardarComentarioTarea(Comentario comentario, Long idTarea);

	public void desligarUsuario(Usuario usuario);
	
	public List<Tarea> buscarTareasPorIdUsuario(Long id);

}