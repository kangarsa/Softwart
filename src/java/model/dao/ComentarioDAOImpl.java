/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import javax.persistence.TypedQuery;
import model.dao.impl.GenericDaoHibernateJPA;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author agustin
 */
public class ComentarioDAOImpl extends GenericDaoHibernateJPA<Usuario> implements ComentarioDAO {
    Transaction transaction = null;
    Session session;
    
    @Override
    public ArrayList<Publicacion> publicacionesComentablesPara(Usuario u) {
        try{
            
            TypedQuery<Publicacion> query = (TypedQuery<Publicacion>) (Query) this.getEntityManager().createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.dni = '" + u.getDni() +"'");
            

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
    
    @Override
    public boolean agregar(Comentario comentario) {
        try{
;
            return true;
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
    }

    @Override
    public ArrayList<Comentario> listar() {
        try{
 
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
    
}
