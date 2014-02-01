/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Comentario;
import model.entities.Publicacion;
import model.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author agustin
 */
public class ComentarioDAOImpl implements ComentarioDAO {
    Transaction transaction = null;
    Session session;
    
    @Override
    public ArrayList<Publicacion> publicacionesComentablesPara(Usuario u) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            ArrayList<Publicacion> res = (ArrayList<Publicacion>)session.createQuery("from Publicacion").list();
            transaction.commit();
            return res;
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean agregar(Comentario comentario) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            session.save(comentario);
            transaction.commit();
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
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            return (ArrayList<Comentario>)sessionLocal.createQuery("from Comentario").list();
        }
        catch(HibernateException e){
            return null;
        }
    }
    
}
