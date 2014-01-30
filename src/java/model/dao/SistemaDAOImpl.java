/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Sistema;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author agustin
 */
public class SistemaDAOImpl implements SistemaDAO {
    Transaction transaction = null;
    Session session;
    
    @Override
    public boolean agregar(Sistema sistema) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            session.save(sistema);
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
    public ArrayList<Sistema> listar() {
        try{
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            return (ArrayList<Sistema>)sessionLocal.createQuery("from Sistema").list();
        }
        catch(HibernateException e){
            return null;
        }
    }
    
}
