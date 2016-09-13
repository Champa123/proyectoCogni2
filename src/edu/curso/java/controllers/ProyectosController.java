package edu.curso.java.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import edu.curso.java.controllers.forms.UsuarioForm;
import edu.curso.java.services.ProyectoService;
import edu.curso.java.services.TareaService;
import edu.curso.java.services.UsuarioService;

@Controller
@RequestMapping("/proyectos")
public class ProyectosController {

	private static final Logger log = Logger.getLogger(ProyectosController.class);
	
	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private TareaService tareaService;

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		log.info("Listando los proyectos");
		List<Proyecto> proyectos = proyectoService.listarProyectos();
		model.addAttribute("proyectos",proyectos);
		return null;
	}

	@RequestMapping(value = "/buscadorproyectos", method = RequestMethod.POST)
	public String buscarProyectos(@RequestParam String textoBuscar, @RequestParam String fechaInicio, @RequestParam String fechaFin, Model model) {
		log.info("Buscando los proyectos");
		DateFormat formatter = null;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		/*Date fechaIni = DateFormat.getInstance().parse(fechaInicio);
		Date fechaF = DateFormat.getInstance().parse(fechaFin);
		Date fechaIni2 = (Date)formatter.parse(fechaIni);
			Date fechaFin2 = (Date)formatter.parse(fechaFin);*/
		Date fechaIni2;
		Date fechaFin2;
		try {
			fechaIni2 = formatter.parse(fechaInicio);
			
		} catch (ParseException e) {
			fechaIni2=null;
			
		}
		try{
			fechaFin2 = formatter.parse(fechaFin);
		}catch (ParseException e) {
			fechaFin2=null;
		}
		List<Proyecto> proyectos = proyectoService.buscarProyectos(textoBuscar, fechaIni2, fechaFin2);
		model.addAttribute("proyectos",proyectos);
		return "/proyectos/buscadorproyectos";
	}
	//"/proyectos/verproyecto"
	@RequestMapping(value = "/verproyecto")
	public String verProyecto(@RequestParam Long id, Model model) {
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		model.addAttribute("proyecto", proyecto);
		return null;
	}
	@RequestMapping(value = "/modal")
	public String modal(@RequestParam Long id, Model model) {
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		model.addAttribute("proyecto", proyecto);
		return null;
	}
	
	@RequestMapping(value = "/borrarproyecto")
	public String borrarProyecto(@RequestParam Long id, Model model) {
		proyectoService.borrarProyectoPorId(id);
		return "redirect:/proyectos/index.html";
	}
	
	@RequestMapping(value = "/nuevoproyecto")
	public String nuevoProyecto(Model model) {
		model.addAttribute("proyectoForm", new ProyectoForm());
		model.addAttribute("usuarios", usuarioService.recuperarUsuarios());
		return "/proyectos/form";
	}
	
	@RequestMapping(value = "/editarproyecto")
	public String editarProyecto(@RequestParam Long id, Model model) {
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		Usuario usuarioPpal = proyecto.getUsuarioPrincipal();
		Integer contador= 0;
		List<Usuario> usuarios = new ArrayList<>();
		usuarios= proyecto.getUsuarios();
		List<Long> idUsuarios = proyecto.getUsuarios().stream().map((Usuario u) -> u.getId()).collect(Collectors.toList());
		ProyectoForm proyectoForm = new ProyectoForm();
		proyectoForm.setId(proyecto.getId());
		proyectoForm.setDescripcion(proyecto.getDescripcion());
		proyectoForm.setNombre(proyecto.getNombre());
		proyectoForm.setIdUsuarioPrincipal(usuarioPpal.getId());
		proyectoForm.setIdUsuarios(idUsuarios);
		proyectoForm.setFechaInicio(proyecto.getFechaInicio());
		proyectoForm.setFechaFin(proyecto.getFechaFin());
		model.addAttribute("proyectoForm", proyectoForm);
		model.addAttribute("proyecto",proyecto);
		model.addAttribute("usuarios", usuarioService.recuperarUsuarios());
		return "/proyectos/formeditado";
	}
	
//	@RequestMapping(value = "/guardarproyecto", method = RequestMethod.POST)
//	public String guardarUsuario(@ModelAttribute("proyectoForm") ProyectoForm proyectoForm, Model model) {
//
//		Proyecto proyecto = new Proyecto();
//		proyecto.setDescripcion(proyectoForm.getDescripcion());
//		proyecto.setNombre(proyectoForm.getNombre());
//		proyecto.setUsuarios(proyectoForm.getUsuarios());
//		proyecto.setId(proyectoForm.getId());
//		
//		Long idGenerado = proyectoService.guardarProyecto(proyecto);
//
//		return "redirect:/proyectos/verproyecto.html?id=" + idGenerado;
//	}
	
	@RequestMapping(value = "/guardarnuevoproyecto", method = RequestMethod.POST)
	public String guardarNuevoProyecto(@RequestParam Long id ,@ModelAttribute("proyectoForm") ProyectoForm proyectoForm, Model model) {
		Proyecto proyecto = null;
		Long idActual = proyectoForm.getId();
		Long idUsuarioPrincipal = proyectoForm.getIdUsuarioPrincipal();
		List<Long> idUsuarios = proyectoForm.getIdUsuarios();

		proyecto = new Proyecto();
		proyecto.setNombre(proyectoForm.getNombre());
		proyecto.setDescripcion(proyectoForm.getDescripcion());
		proyecto.setFechaInicio(proyectoForm.getFechaInicio());
		proyecto.setFechaFin(proyectoForm.getFechaFin());
		
		idActual = proyectoService.guardarProyecto(proyecto, idUsuarioPrincipal, idUsuarios);
		
		
		
		
		return "redirect:/proyectos/verproyecto.html?id=" + idActual;
}
	
	
//	@RequestMapping(value = "/guardarproyecto", method = RequestMethod.POST)
//	public String guardarUsuario(@ModelAttribute("proyectoForm") ProyectoForm proyectoForm, Model model) {
//		Proyecto proyecto = null;
//		Long idActual = proyectoForm.getId();
//		Long idUsuarioPrincipal = proyectoForm.getIdUsuarioPrincipal();
//		
//		if(idActual != null){
//			proyecto= proyectoService.recuperarProyectoPorId(idActual);
//			proyecto.setNombre(proyectoForm.getNombre());
//			proyecto.setDescripcion(proyecto.getDescripcion());
//			idActual = proyectoService.guardarProyecto(proyecto,idUsuarioPrincipal);
//		} else {
//			proyecto = new Proyecto();
//			proyecto.setNombre(proyectoForm.getNombre());
//			proyecto.setDescripcion(proyecto.getDescripcion());
//			idActual = proyectoService.guardarProyecto(proyecto, idUsuarioPrincipal);
//		}
//		
//		
//		
//		return null;
//}
	@RequestMapping(value = "/guardareditproyecto", method = RequestMethod.POST)
	public String guardareditproyecto(@ModelAttribute("proyectoForm") ProyectoForm proyectoForm, Model model) {
		Proyecto proyecto = null;
		Long idActual = proyectoForm.getId();
		Long idUsuarioPrincipal = proyectoForm.getIdUsuarioPrincipal();
		List<Long> idUsuarios = proyectoForm.getIdUsuarios();
		if(idActual != null){
			proyecto= proyectoService.recuperarProyectoPorId(idActual);
			proyecto.setNombre(proyectoForm.getNombre());
			proyecto.setDescripcion(proyectoForm.getDescripcion());
			proyecto.setId(idActual);
			proyecto.setFechaInicio(proyectoForm.getFechaInicio());
			proyecto.setFechaFin(proyectoForm.getFechaFin());
			
			idActual = proyectoService.actualizarProyecto(proyecto,idUsuarioPrincipal, idUsuarios);
		} 
		
		 
		return "redirect:/proyectos/verproyecto.html?id=" + idActual;
}
	@RequestMapping(value = "/listartareas", method = RequestMethod.GET)
	public String listarTareas(@RequestParam Long id, Model model) {
		Proyecto proyecto = proyectoService.recuperarProyectoPorId(id);
		List<Tarea> tareas = new ArrayList<>();
		for (Tarea tarea : proyecto.getTareas()) {
			tareas.add(tarea);
		}
		model.addAttribute("tareas",tareas);
		return "/tareas/vertarea";
	}
	
	@RequestMapping(value = "/guardarnuevatarea", method = RequestMethod.GET)
	public String guardarNuevaTarea(@RequestParam Long id, Model model) {
		return "redirect:/tareas/nuevatarea.html?id="+id;
	}
	@RequestMapping(value = "/modaltarea")
	public String modalTarea(@RequestParam Long id, Model model) {
		Tarea tarea = tareaService.recuperarTareaPorId(id);
		model.addAttribute("tarea", tarea);
		return null;
	}
	
}
