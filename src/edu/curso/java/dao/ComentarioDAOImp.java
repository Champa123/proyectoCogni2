package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Usuario;
import edu.curso.java.controllers.autocomplete.ItemAutoComplete;

@Repository
public class ComentarioDAOImp extends GenericDAOImp<Comentario, Long> implements ComentarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Comentario> listarComentarios() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Comentarios as c");
		
		return query.list();
	}

	@Override
	public void borrar (Comentario comentario){
		
	}

	
}