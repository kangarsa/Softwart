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
import org.hibernate.Session;

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
    public ArrayList<Voto> listar() {
        try{

        }
        catch(HibernateException e){
            return null;
        }
        return null;
    }
    
}
