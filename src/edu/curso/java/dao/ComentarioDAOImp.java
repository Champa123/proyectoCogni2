package edu.curso.java.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;

@Repository
public abstract class ComentarioDAOImp implements ComentarioDAO {

	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void borrarComentario(Long id) {
		Comentario comentario = this.recuperarComentarioPorId(id);
		sessionFactory.getCurrentSession().delete(comentario);
		
	}

	@Override
	public Comentario guardarComentario(Comentario comentario) {
		return (Comentario) sessionFactory.getCurrentSession().save(comentario);
	}
	
	
	@Override
	public Comentario recuperarComentarioPorId(Long id) {
		return (Comentario) sessionFactory.getCurrentSession().load(Comentario.class, id);
	}

}
