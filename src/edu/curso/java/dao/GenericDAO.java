
package edu.curso.java.dao;
 
import java.io.Serializable;
import java.util.List;

import edu.curso.java.bo.Comentario;
import edu.curso.java.bo.Proyecto;
import edu.curso.java.bo.Tarea;
import edu.curso.java.bo.Usuario;

public interface GenericDAO<E, K extends Serializable> {
	
    public K guardar(E elemento);
    public void actualizar(E elemento);
    public void borrar(E elemento);
    public E buscarPorId(K id);
 
}