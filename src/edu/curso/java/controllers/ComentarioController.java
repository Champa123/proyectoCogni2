package edu.curso.java.controllers;


import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Tarea;
import edu.curso.java.controllers.forms.ComentarioForm;
import edu.curso.java.controllers.forms.TareaForm;
import edu.curso.java.services.ComentarioService;
import edu.curso.java.services.TareaService;


@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

	private static final Logger log = Logger.getLogger(ComentarioController.class);
	
	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private TareaService tareaService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		List<Comentario> comentarios = comentarioService.listarComentarios();
		model.addAttribute("comentarios",comentarios);
		return null;
	}
	@RequestMapping(value = "/borrarcomentario")
	public String borrarComentario(@RequestParam Long idComent,@RequestParam Long idTarea, Model model) {
		comentarioService.borrarComentario(idComent,idTarea);
		return "redirect:/proyectos/index.html";
	}
	@RequestMapping(value = "/nuevocomentario", method = RequestMethod.GET)
	public String nuevoComentario(Model model, @RequestParam Long id) {
		model.addAttribute("comentarioForm", new ComentarioForm());
		model.addAttribute("id",id);
		
		return "/tareas/modalcomentario";
	}
	@RequestMapping(value = "/guardarnuevocomentario", method = RequestMethod.POST)
	public String guardarNuevoComentario(@RequestParam Long id ,@ModelAttribute("comentarioForm") ComentarioForm comentarioForm, Model model) {
		Comentario comentario= null;
		Long idActual = comentarioForm.getId();
			comentario = new Comentario();
			comentario.setComentario(comentarioForm.getComentario());
			comentario.setId(idActual);
			tareaService.guardarComentarioTarea(comentario, id);
		return "redirect:/tareas/listartareas.html";
}

}