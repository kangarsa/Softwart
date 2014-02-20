/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Tag;
import model.entities.Usuario;
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
            System.out.println("TAG: " + tag);
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
            org.hibernate.Session session;
            Transaction transaction;
            
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            return (ArrayList<Tag>)session.createQuery("from Tag").list();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
