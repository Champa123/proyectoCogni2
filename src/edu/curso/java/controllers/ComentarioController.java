package edu.curso.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Comentario;
import edu.curso.java.controllers.forms.ComentarioForm;
import edu.curso.java.controllers.forms.TareaForm;
import edu.curso.java.services.ComentarioService;


@Controller
@RequestMapping("/comentarios")
public class ComentarioController {
	
	
	
	@Autowired
	private ComentarioService comentarioService;
	
	
	
	
	@RequestMapping(value = "/nuevocomentario")
	public String nuevoComentario(Model model, @RequestParam Long id) {
		model.addAttribute("comentarioForm", new ComentarioForm());
		model.addAttribute("Id",id);
		return "/comentarios/form";
	}
	
	@RequestMapping(value = "/guardarnuevocomentario", method = RequestMethod.POST)
	public String guardarNuevoComentario(@RequestParam Long id ,@ModelAttribute("comentarioForm") ComentarioForm comentarioForm, Model model) {
		Comentario comentario = null;
		Long idActual = comentarioForm.getId();
			comentario = new Comentario();
			comentario.setComentario(comentarioForm.getComentario());
			comentario.setId(idActual);
			comentarioService.guardarComentario(comentario);
		
		
		
		return "redirect:/proyectos/index.html";
}
	
	
	
	@RequestMapping(value = "/borrarcomentario")
	public String borrarComentario(@RequestParam Long id, Model model) {
	return null;
	}
	
	
	
}
