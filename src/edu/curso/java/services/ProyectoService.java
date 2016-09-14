package edu.curso.java.services;

import java.util.Date;
import java.util.List;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.autocomplete.ItemAutoComplete;
import edu.curso.java.exceptions.HorasInsuficientesException;

public interface ProyectoService {

	public Long guardarProyecto(Proyecto proyecto);

	public List<Proyecto> listarProyectos();

	Proyecto recuperarProyectoPorId(Long id);

	void agregarUsuarioProyecto(Usuario usuario, Long id);

	void borrarProyectoPorId(Long id);

	void editarProyecto(Proyecto proyecto);

	public Long actualizarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, List<Long> idUsuarios);

	public List<Proyecto> buscarProyectos(String textoBuscar, Date fechaIni2, Date fechaFin2);

	public List<Proyecto> buscarProyectos(String term);

	Long guardarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, List<Long> idUsuarios);

	public Long guardarTareaProyecto(Tarea tarea, Long idProyecto) throws HorasInsuficientesException;

	public void guardarEdicionTareaProyecto(Tarea tarea, Long idProyecto);

	List<Proyecto> buscarProyectosPorIdUsuario(Long id);

	public void desligarUsuario(Usuario usuario);
}