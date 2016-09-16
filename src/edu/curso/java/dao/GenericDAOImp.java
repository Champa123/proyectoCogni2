package edu.curso.java.dao;
 
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

 
 
public class GenericDAOImp<E, K extends Serializable> implements GenericDAO<E, K> {
     
    @Autowired
    private SessionFactory sessionFactory;
 
    private Class<E> entityClass;
      
    public GenericDAOImp() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
   this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }
     
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Override
    public K guardar(E elemento) {
        return (K) sessionFactory.getCurrentSession().save(elemento);
    }
 
    @Override
    public void actualizar(E elemento) {
        sessionFactory.getCurrentSession().update(elemento);        
    }
 
    @Override
    public void borrar(E elemento) {
    	sessionFactory.getCurrentSession().delete(elemento);
         
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public E buscarPorId(K id) {
        return (E) sessionFactory.getCurrentSession().get(entityClass, id);
    }
 
    
         
 
}