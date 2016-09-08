package edu.curso.java.controllers.forms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public class ProyectoForm {

	private Long id;
	private String nombre;
	private String descripcion;
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Tarea> tareas = new ArrayList<>();
	private Long idUsuarioPrincipal;
	private List<Long> idUsuarios;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio = new Date();
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFin = new Date();
	
	public Long getIdUsuarioPrincipal() {
		return idUsuarioPrincipal;
	}



	public void setIdUsuarioPrincipal(Long idUsuarioPrincipal) {
		this.idUsuarioPrincipal = idUsuarioPrincipal;
	}



	public Long getId() {
		return id;
	}

	
	
	public List<Tarea> getTareas() {
		return tareas;
	}



	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	public List<Long> getIdUsuarios() {
		return idUsuarios;
	}



	public void setIdUsuarios(List<Long> idUsuarios) {
		this.idUsuarios = idUsuarios;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

	
}
