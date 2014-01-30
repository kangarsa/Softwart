/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Publicacion;
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
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            session.save(publicacion);
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
    public ArrayList<Publicacion> listar() {
        try{
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            return (ArrayList<Publicacion>)sessionLocal.createQuery("from Publicacion").list();
        }
        catch(HibernateException e){
            return null;
        }
    }
    
    
    
}
