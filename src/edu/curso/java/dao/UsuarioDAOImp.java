package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Usuario;

@Component
public class UsuarioDAOImp extends GenericDAOImp<Usuario, Long> implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Usuario> recuperarUsuarios() {
		String hql = "from Usuario as u order by u.nombreCompleto";
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(hql);
		return query.list();
	}
	

	
	
}
