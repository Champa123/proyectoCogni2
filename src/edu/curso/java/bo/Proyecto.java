package edu.curso.java.bo;

import java.util.*;

import javax.persistence.*;

@Entity
public class Proyecto {
	
	@Id
	@GeneratedValue
	private Long id;	
	private String nombre;
	private String descripcion;
	@ManyToOne
	private Usuario usuarioPrincipal;
	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	@OneToMany
	private List<Tarea> tareas = new ArrayList<>();
	private Date fechaInicio = new Date();
	private Date fechaFin = new Date();
	private Long horasAsignadas;
	private Long sumaHorasTareas;
	
	public void sumarHoras(Long horas) {
		this.setSumaHorasTareas(this.getSumaHorasTareas() + horas);
	}
	
	public void restarHoras(Long horas) {
		this.setSumaHorasTareas(this.getSumaHorasTareas() - horas);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Long getId() {
		return id;
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

	public Usuario getUsuarioPrincipal() {
		return usuarioPrincipal;
	}

	public void setUsuarioPrincipal(Usuario usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
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

	public Long getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(Long horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Long getSumaHorasTareas() {
		return sumaHorasTareas;
	}

	public void setSumaHorasTareas(Long sumaHorasTareas) {
		this.sumaHorasTareas = sumaHorasTareas;
	}
	
}
