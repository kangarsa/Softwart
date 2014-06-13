/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Tag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
     * @return
     */
    @Override
    public ArrayList<Tag> listar() {
        try{
      
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
    
}
