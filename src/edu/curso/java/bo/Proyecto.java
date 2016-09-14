package edu.curso.java.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import edu.curso.java.exceptions.HorasInsuficientesException;

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
	@OneToMany (cascade= CascadeType.ALL)// TODO
//	@OneToMany
	private List<Tarea> tareas = new ArrayList<>();
	private Date fechaInicio = new Date();
	private Date fechaFin = new Date();
	private Long horasAsignadas = new Long(0);
	private Long sumaHorasTareas = new Long (0);
	
	public void validarHoras() throws HorasInsuficientesException {
		if ( sumaHorasTareas > horasAsignadas ) {
			throw new HorasInsuficientesException("no hay horas disponibles");
		}
	}
	
	public void agregarTarea(Tarea tarea) throws HorasInsuficientesException {
		setSumaHorasTareas( sumaHorasTareas + tarea.getHoras() );
		tareas.add(tarea);
	}
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Tarea> getTareas() {
		List<Tarea> res = Collections.unmodifiableList(tareas);
		return res;
	}

	public void setTareas(List<Tarea> tareas) throws HorasInsuficientesException {
		Long horas = new Long(0);
		for (Tarea tarea : tareas) {
			horas = horas + tarea.getHoras();
		}
		this.setSumaHorasTareas(horas);
		
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

	public void setHorasAsignadas(Long horasAsignadas) throws HorasInsuficientesException {
		this.horasAsignadas = horasAsignadas;
		validarHoras();
	}

	public Long getSumaHorasTareas() {
		return sumaHorasTareas;
	}

	private void setSumaHorasTareas(Long sumaHorasTareas) throws HorasInsuficientesException {
		this.sumaHorasTareas = sumaHorasTareas;
		validarHoras();
	}

	public void quitarUsuario(Usuario usuario) {
		// TODO if not this usuarioPrincipal not null hace falta?
		
		if ( getUsuarioPrincipal() == usuario ) {
		}
		setUsuarioPrincipal(null);
		
		usuarios.remove(usuario);
	}

	
}
