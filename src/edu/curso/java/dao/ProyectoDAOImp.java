package edu.curso.java.dao;

import javax.persistence.criteria.*;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Selection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.autocomplete.ItemAutoComplete;

@Repository
public class ProyectoDAOImp implements ProyectoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long guardarProyecto(Proyecto proyecto) {
		return (Long) sessionFactory.getCurrentSession().save(proyecto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> listarProyectos() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Proyecto as p");
		return query.list();
	}

	@Override
	public Proyecto recuperarProyectoPorId(Long id) {
		return (Proyecto) sessionFactory.getCurrentSession().load(Proyecto.class, id);
	}

	@Override
	public void agregarUsuarioProyecto(Usuario usuario, Long id) {
		Proyecto proyecto = recuperarProyectoPorId(id);
		List<Usuario> usuarios = proyecto.getUsuarios();
		usuarios.add(usuario);
		proyecto.setUsuarios(usuarios);
	}

	@Override
	public void borrarProyectoPorId(Long id) {
		Proyecto proyecto = this.recuperarProyectoPorId(id);
		sessionFactory.getCurrentSession().delete(proyecto);
	}

	@Override
	public void editarProyecto(Proyecto proyecto) {
		sessionFactory.getCurrentSession().update(proyecto);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarProyectos(String textoBuscar, Date fechaIni2, Date fechaFin2) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Proyecto.class);
		if (textoBuscar != null) {
			criteria.add(Restrictions.like("nombre", textoBuscar + "%"));
		}

		if (fechaIni2 != null) {
			criteria.add(Restrictions.ge("fechaInicio", fechaIni2));
		}

		if (fechaFin2 != null) {
			criteria.add(Restrictions.le("fechaFin", fechaFin2));
		}

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarProyectos(String term) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Proyecto as p where p.nombre like '%" + term + "%'");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarProyectosPorIdUsuario(Long id) {
		
		String sql = "select id, nombre, descripcion, usuarioPrincipal_id, fechaInicio, fechaFin," + 
				" horasAsignadas, sumaHorasTareas" +
				" from Proyecto as p" +
				" inner join proyecto_usuario as p_u on p.id = p_u.Proyecto_id" +
				" where p_u.usuarios_id = " + id +
				" group by p.id";
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Proyecto.class);
		
		List<Proyecto> result = query.list();
		
		return result;
	}

}
