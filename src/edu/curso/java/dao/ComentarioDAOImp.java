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
public class ComentarioDAOImp implements ComentarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Long guardarComentario(Comentario comentario) {
		return (Long) sessionFactory.getCurrentSession().save(comentario);
	}

	@Override
	public List<Comentario> listarComentarios() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Comentarios as c");
		
		return query.list();
	}

	@Override
	public Comentario recuperarComentarioPorId(Long id) {
		return (Comentario) sessionFactory.getCurrentSession().load(Comentario.class, id);
		}

	@Override
	public void borrarComentario(Long id) {
		Comentario comentario= this.recuperarComentarioPorId(id);
		sessionFactory.getCurrentSession().delete(comentario);		
	}


	
}