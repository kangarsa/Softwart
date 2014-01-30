/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Voto;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author agustin
 */
public class VotoDAOImpl implements VotoDAO {
    Transaction transaction = null;
    Session session;
    
    @Override
    public boolean agregar(Voto voto) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            session.save(voto);
            transaction.commit();
            return true;
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Voto> listar() {
        try{
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            return (ArrayList<Voto>)sessionLocal.createQuery("from Voto").list();
        }
        catch(HibernateException e){
            return null;
        }
    }
    
}
