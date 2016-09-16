package edu.curso.java.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.forms.ProyectoForm;
import edu.curso.java.controllers.forms.TareaForm;
import edu.curso.java.controllers.forms.UsuarioForm;
import edu.curso.java.exceptions.HorasInsuficientesException;
import edu.curso.java.services.ProyectoService;
import edu.curso.java.services.TareaService;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping("/tareas")
public class TareaController {

	
	@Autowired
	private ProyectoService proyectoService;
	@Autowired
	private TareaService tareaService;

	@Autowired
	private UsuarioService usuarioService;
	

	//"/proyectos/verproyecto"
	@RequestMapping(value = "/vertarea")
	public String verTarea(@RequestParam Long id, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		model.addAttribute("tarea", tarea);
		return null;
	}

	@RequestMapping(value = "/listartareas")
	public String listarTareas( Model model) {
		List <Tarea> tareas = tareaService.listarTareas();
		model.addAttribute("tareas", tareas);
		return null;
	}
	
	@RequestMapping(value = "/borrartarea")
	public String borrarTarea(@RequestParam Long id, Model model) {
	return null;
	}
	
	@RequestMapping(value = "/nuevatarea")
	public String nuevaTarea(Model model, @RequestParam Long id) {
		
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		List<Usuario> usuarios= new ArrayList<>();
		
		for (Usuario usuario : proyecto.getUsuarios()) {
			usuarios.add(usuario);
		}
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tareaForm", new TareaForm());
		model.addAttribute("ID",id);
		return "/tareas/form";
	}
	
	@RequestMapping(value = "/editartarea")
	public String editarTarea(@RequestParam Long idTarea,@RequestParam Long idProy, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(idTarea);
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(idProy);
		TareaForm tareaForm = new TareaForm();
		
		tareaForm.setId(tarea.getId());
		tareaForm.setEstado(tarea.getEstado());
		tareaForm.setTitulo(tarea.getTitulo());
		tareaForm.setHoras(tarea.getHoras());
		List<Long> idUsuarios = tarea.getUsuarios().stream().map((Usuario u) -> u.getId()).collect(Collectors.toList());
		tareaForm.setIdUsuarios(idUsuarios);
		model.addAttribute("usuarios",proyecto.getUsuarios());
		model.addAttribute("tareaForm", tareaForm);
		model.addAttribute("tarea",tarea);
		return "/tareas/formeditado";
	}
	
	
	@RequestMapping(value = "/guardarnuevatarea", method = RequestMethod.POST)
	public String guardarNuevaTarea(@RequestParam Long id ,@ModelAttribute("tareaForm") TareaForm tareaForm, Model model) {
		Tarea tarea = null;
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<>();
		Long idActual = tareaForm.getId();
		tarea = new Tarea();
		tarea.setTitulo(tareaForm.getTitulo());
		tarea.setId(idActual);
		tarea.setHoras(tareaForm.getHoras());
		tarea.setEstado(tareaForm.getEstado());
		tarea.getComentarios();
		tarea.setUsuarios(usuarios);
		for (Long idUsuario : tareaForm.getIdUsuarios()) {
			usuario= usuarioService.recuperarUsuarioPorId(idUsuario);
			tarea.getUsuarios().add(usuario);	
		}
		
		String returnPage = "redirect:/proyectos/index.html"; 
		try {
			proyectoService.guardarTareaProyecto(tarea, id);
		} catch (HorasInsuficientesException e) {
			returnPage = "/error/horasInsuficientes";
		}

		return returnPage;
	}
	
	@RequestMapping(value = "/guardarediciontarea", method = RequestMethod.POST)
	public String guardarEdicionTarea(@RequestParam Long id ,@ModelAttribute("tareaForm") TareaForm tareaForm, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(id);

		Long horasOld = tarea.getHoras();
		Proyecto proyecto = proyectoService.buscarProyectoPorIdTarea(id);
		
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<>();
		for (Long idUsuario : tareaForm.getIdUsuarios()) {
			usuario = usuarioService.recuperarUsuarioPorId(idUsuario);
			usuarios.add(usuario);
		}
		tarea.setUsuarios(usuarios);
		
		tarea.setTitulo(tareaForm.getTitulo());
		tarea.setHoras(tareaForm.getHoras());
		tarea.setEstado(tareaForm.getEstado());

		String returnPage = "redirect:/proyectos/index.html";
		try {
			proyecto.editarHorasTarea( horasOld - tarea.getHoras() );
//			guradarEdicionTareaProyecto edita la tarea
//			tareaService.editarTarea(tarea);
			proyectoService.guardarEdicionTareaProyecto(tarea, proyecto.getId());
		} catch (HorasInsuficientesException e) {
			returnPage = "/error/horasInsuficientes";
		}
		
		return returnPage;
	}
	
	@RequestMapping(value = "/guardarnuevocomentario", method = RequestMethod.GET)
	public String guardarNuevaTarea(@RequestParam Long id, Model model) {
		return "redirect:/comentarios/nuevocomentario.html?id="+id;
	}
	
	
	
	@RequestMapping(value = "/buscadortareas", method = RequestMethod.GET)
	public String buscarTareas(@RequestParam String textoTarea, Model model) {
		List<Tarea> tareas = tareaService.buscarTareasPorNombre(textoTarea);
		model.addAttribute("tareas",tareas);
		return null;
	}

	@RequestMapping(value = "/modalcomentario", method = RequestMethod.GET)
	public String modalTarea(@RequestParam Long id, Model model) {	
		return "redirect:/comentarios/nuevocomentario.html?id="+ id;
	}
	@RequestMapping(value = "/modalusuario", method = RequestMethod.GET)
	public String modalUsuario(@RequestParam Long id, Model model) {	
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		model.addAttribute("usuarios", tarea.getUsuarios());
		model.addAttribute("tarea",tarea);
		return null;
	}
}
