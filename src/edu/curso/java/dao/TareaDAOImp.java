package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.autocomplete.ItemAutoComplete;

@Repository
public class TareaDAOImp implements TareaDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	

	@Override
	public Long guardarTarea(Tarea tarea) {
		return  (Long) sessionFactory.getCurrentSession().save(tarea);
	}


	@Override
	public Tarea recuperarTareaPorId(Long id) {
		return (Tarea) sessionFactory.getCurrentSession().load(Tarea.class, id);
	}

	@Override
	public void borrarTareaPorId(Long id) {
		Tarea tarea = this.recuperarTareaPorId(id);
		sessionFactory.getCurrentSession().delete(tarea);
	}

	@Override
	public void editarTarea(Tarea tarea) {
		sessionFactory.getCurrentSession().update(tarea);	
	}


	@Override
	public List<Tarea> listarTareas() {
		String hql = "From Tarea as t order by t.titulo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}


	@Override
	public List<Tarea> buscarTareasPorNombre(String textoTarea) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Tarea as t where t.titulo like '%" + textoTarea + "%'");
		return  query.list();
	}

	
	
	
}
