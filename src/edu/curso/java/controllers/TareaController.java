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

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.forms.ProyectoForm;
import edu.curso.java.controllers.forms.TareaForm;
import edu.curso.java.controllers.forms.UsuarioForm;
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

//	@Autowired
//	private UsuarioService usuarioService;
	

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
		model.addAttribute("tareaForm", new TareaForm());
		model.addAttribute("ID",id);
		return "/tareas/form";
	}
	
	@RequestMapping(value = "/editartarea")
	public String editarTarea(@RequestParam Long id, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		TareaForm tareaForm = new TareaForm();
		tareaForm.setId(tarea.getId());
//		tareaForm.getComentarios(tarea.getComentarios);
		tareaForm.setEstado(tarea.getEstado());
		tareaForm.setTitulo(tarea.getTitulo());
		model.addAttribute("tareaForm", tareaForm);
		model.addAttribute("tarea",tarea);
		return "/tareas/formeditado";
	}
	
	
	@RequestMapping(value = "/guardarnuevatarea", method = RequestMethod.POST)
	public String guardarNuevaTarea(@RequestParam Long id ,@ModelAttribute("tareaForm") TareaForm tareaForm, Model model) {
		Tarea tarea = null;
		Long idActual = tareaForm.getId();
			tarea = new Tarea();
			tarea.setTitulo(tareaForm.getTitulo());
			//tarea.getComentarios(tareaForm.getComentarios())
			tarea.setEstado(tareaForm.getEstado());
			tarea.setId(idActual);
			proyectoService.guardarTareaProyecto(tarea, id);
		
		
		
		return "redirect:/proyectos/index.html";
}
	@RequestMapping(value = "/guardarediciontarea", method = RequestMethod.POST)
	public String guardarEdicionTarea(@RequestParam Long id ,@ModelAttribute("tareaForm") TareaForm tareaForm, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		
		
			tarea.setTitulo(tareaForm.getTitulo());
			//tarea.getComentarios(tareaForm.getComentarios());
			tarea.setEstado(tareaForm.getEstado());
			tareaService.editarTarea(tarea);
			
		
		
		return "redirect:/proyectos/index.html";
}
	
	@RequestMapping(value = "/guardarnuevocomentario", method = RequestMethod.GET)
	public String guardarNuevaTarea(@RequestParam Long id, Model model) {
		return "redirect:/comentarios/nuevocomentario.html?id="+id;
	}
	}
