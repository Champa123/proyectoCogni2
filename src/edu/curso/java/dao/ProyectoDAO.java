package edu.curso.java.dao;

import java.util.Date;
import java.util.List;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.autocomplete.ItemAutoComplete;

public interface ProyectoDAO {

	public Long guardarProyecto(Proyecto proyecto);

	public List<Proyecto> listarProyectos();

	Proyecto recuperarProyectoPorId(Long id);

	void agregarUsuarioProyecto(Usuario usuario, Long id);

	void borrarProyectoPorId(Long id);

	void editarProyecto(Proyecto proyecto);

	List<Proyecto> buscarProyectos(String textoBuscar, Date fechaIni2, Date fechaFin2);

	List<Proyecto> buscarProyectos(String term);

	List<Proyecto> buscarProyectosPorIdUsuario(Long id);
}
