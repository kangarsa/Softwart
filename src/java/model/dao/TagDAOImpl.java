/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Tag;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author agustin
 */
public class TagDAOImpl implements TagDAO {
    Transaction transaction = null;
    Session session;

    
    @Override
    public boolean agregar(Tag tag) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            session.save(tag);
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
    public ArrayList<Tag> listar() {
        try{
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            return (ArrayList<Tag>)sessionLocal.createQuery("from Tag").list();
        }
        catch(HibernateException e){
            return null;
        }
    }
    
}
