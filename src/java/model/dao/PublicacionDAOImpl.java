/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.entities.Publicacion;
import model.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author agustin
 */
public class PublicacionDAOImpl implements PublicacionDAO {
    Transaction transaction = null;
    Session session;

    @Override
    public boolean agregar(Publicacion publicacion) {
        try{

        }
        catch(HibernateException e){
            System.out.println(e);
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public ArrayList<Publicacion> listar() {
        try{
   
        }
        catch(HibernateException e){
             System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public boolean eliminar(Publicacion publicacion) {
        try{ 
            
     
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }
    
    /**
     *
     * @param publicacion
     * @return
     */
    @Override
     public boolean eliminarComentarios(Publicacion publicacion) {
        try{ 

        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }
    
    //ES IGUAL AL AGREGAR, REPENSAR O REVISAR
    @Override
    public boolean editar(Publicacion publicacion) {
        try{
  
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
     public List listarComentarios(Publicacion publicacion) {
        try{

            
        }
        catch(HibernateException e){
            return null;
        }
        return null;
    }

    @Override
    public List listarTags(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Publicacion> publicacionesDeUsuario(Usuario usuario) {
        try{
   
        }
        catch(HibernateException e){
            return null;
        }
        return null;
    }

}
