package edu.curso.java.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.autocomplete.ItemAutoComplete;
import edu.curso.java.dao.ProyectoDAO;
import edu.curso.java.dao.TareaDAO;
import edu.curso.java.dao.UsuarioDAO;
import edu.curso.java.exceptions.HorasInsuficientesException;

@Service
@Transactional(rollbackFor=Exception.class)
public class ProyectoServiceImp implements ProyectoService {

	@Autowired
	TareaDAO tareaDAO;
	@Autowired
	ProyectoDAO proyectoDAO;
	@Autowired
	UsuarioDAO usuarioDAO;
	@Override
	public Long guardarProyecto(Proyecto proyecto) {
		return proyectoDAO.guardar(proyecto);
	}
	
	@Override
	public List<Proyecto> listarProyectos() {
		return proyectoDAO.listarProyectos();
	}

	@Override
	public Proyecto recuperarProyectoPorId(Long id) {
		
		return proyectoDAO.buscarPorId(id);
	}

	@Override
	public void agregarUsuarioProyecto(Usuario usuario, Long id) {
		proyectoDAO.agregarUsuarioProyecto(usuario, id);
		
	}

	@Override
	public void borrarProyectoPorId(Long id) {
		Proyecto proyecto = proyectoDAO.buscarPorId(id);
		proyectoDAO.borrar(proyecto);
		
	}

	@Override
	public void editarProyecto(Proyecto proyecto) {
		proyectoDAO.actualizar(proyecto);
		
	}

	@Override
	public Long guardarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, List<Long> idUsuarios) {
		
		Usuario usuario = usuarioDAO.buscarPorId(idUsuarioPrincipal);
		proyecto.setUsuarioPrincipal(usuario);
		for (Long idUsuario : idUsuarios) {
			proyecto.getUsuarios().add(usuarioDAO.buscarPorId(idUsuario));
		}
		proyectoDAO.guardar(proyecto);
		return proyecto.getId();
	}

	@Override
	public Long actualizarProyecto(Proyecto proyecto, Long idUsuarioPrincipal, List<Long> idUsuarios) {
		Usuario usuarioPpal = usuarioDAO.buscarPorId(idUsuarioPrincipal);
		proyecto.getUsuarios().clear();
		for (Long id : idUsuarios) {
			Usuario usuario = usuarioDAO.buscarPorId(id);
			proyecto.getUsuarios().add(usuario);
		}
			
		
		proyecto.setUsuarioPrincipal(usuarioPpal);
		proyectoDAO.actualizar(proyecto);
		return proyecto.getId();
		
	}

	@Override
	public List<Proyecto> buscarProyectos(String textoBuscar, Date fechaIni2, Date fechaFin2) {
		return proyectoDAO.buscarProyectos(textoBuscar, fechaIni2, fechaFin2);
	}
	
	@Override
	public List<Proyecto> buscarProyectos(String term) {
		return proyectoDAO.buscarProyectos(term);
	}
	
	@Override
	public List<Proyecto> buscarProyectosPorIdUsuario(Long id) {
		return proyectoDAO.buscarProyectosPorIdUsuario(id);
	}
	
	@Override
	public Long guardarTareaProyecto(Tarea tarea, Long idProyecto) throws HorasInsuficientesException{
		Proyecto proyecto = proyectoDAO.buscarPorId(idProyecto);
		
		proyecto.agregarTarea(tarea);
		
		proyectoDAO.actualizar(proyecto);
		Long idActual=tareaDAO.guardar(tarea);
		return idActual;

	}
	@Override
	public void guardarEdicionTareaProyecto(Tarea tarea, Long idProyecto){
		Proyecto proyecto = proyectoDAO.buscarPorId(idProyecto);
		
		proyectoDAO.actualizar(proyecto);
		tareaDAO.actualizar(tarea);
		
		
	}

	@Override
	public void desligarUsuario(Usuario usuario) {
		List<Proyecto> proyectos = buscarProyectosPorIdUsuario(usuario.getId());
		for (Proyecto proyecto : proyectos) {
			proyecto.quitarUsuario(usuario);
			editarProyecto(proyecto);
		}
	}

	@Override
	public Proyecto buscarProyectoPorIdTarea(Long id) {
		Proyecto res = proyectoDAO.buscarProyectoPorIdTarea(id);
		return res;
	}
}
