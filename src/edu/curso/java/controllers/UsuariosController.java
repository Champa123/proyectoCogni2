package edu.curso.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.forms.UsuarioForm;
import edu.curso.java.services.ProyectoService;
import edu.curso.java.services.TareaService;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProyectoService proyectoService;

	// TODO para despues cuando se le asignen tareas a usuarios
//	@Autowired
//	private TareaService tareaService;

	@RequestMapping(value = "/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = usuarioService.recuperarUsuarios();
		
		model.addAttribute("usuarios", usuarios);
		return null;
	}

	@RequestMapping(value = "/verusuario")
	public String verUsuario(@RequestParam Long id, Model model) {
		Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
		model.addAttribute("usuario", usuario);
		return null;
	}

	// borra un usuario de la base y lo quita de todos los proyectos y
	// todas las tareas en las que estaba.
	// si era el principal de un proyecto, queda en null
	@RequestMapping(value = "/borrarusuario")
	public String borrarUsuario(@RequestParam Long id, Model model) {
		// TODO para cuando se le asignen tareas a usuarios
//		tareaService.quitarUsuario(id)
		Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
		proyectoService.desligarUsuario(usuario);
		usuarioService.borrarUsuario(id);
		return "redirect:/usuarios/listar.html";
	}

	@RequestMapping(value = "/nuevousuario")
	public String nuevoUsuario(Model model) {
		model.addAttribute("usuarioForm", new UsuarioForm());
		return "/usuarios/form";
	}

	@RequestMapping(value = "/guardarusuario", method = RequestMethod.POST)
	public String guardarUsuario(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm, Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombreCompleto(usuarioForm.getNombreCompleto());
		usuario.setUsuario(usuarioForm.getUsuario());
		usuario.setPassword(usuarioForm.getPassword());
		usuario.setActivo(usuarioForm.isActivo());
		usuario.setFechaAlta(usuarioForm.getFechaAlta());

		Long idGenerado = usuarioService.crearNuevoUsuario(usuario);

		return "redirect:/usuarios/verusuario.html?id=" + idGenerado;
	}

	@RequestMapping(value = "/editarusuario")
	public String editarUsuario(Model model, @RequestParam Long id) {
		Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
		UsuarioForm usuarioForm= new UsuarioForm();
		
		usuarioForm.setActivo(usuario.isActivo());
		usuarioForm.setNombreCompleto(usuario.getNombreCompleto());
		usuarioForm.setUsuario(usuario.getUsuario());
		usuarioForm.setPassword(usuario.getPassword());
		usuarioForm.setId(usuario.getId());
		usuarioForm.setFechaAlta(usuario.getFechaAlta());
		model.addAttribute("usuarioForm", usuarioForm);
		return "/usuarios/formeditado";
	}
	@RequestMapping(value = "/guardaredicion", method = RequestMethod.POST)
	public String guardarEdicion(@ModelAttribute("usuarioForm") UsuarioForm usuarioForm, Model model,@RequestParam Long id) {

		Usuario usuario = usuarioService.recuperarUsuarioPorId(id);
		usuario.setNombreCompleto(usuarioForm.getNombreCompleto());
		usuario.setUsuario(usuarioForm.getUsuario());
		usuario.setPassword(usuarioForm.getPassword());
		usuario.setActivo(usuarioForm.isActivo());
		usuario.setId(id);
		usuario.setFechaAlta(usuarioForm.getFechaAlta());
		 usuarioService.editarUsuario(usuario);

		return "redirect:/usuarios/verusuario.html?id="+ usuario.getId();
	}
}
