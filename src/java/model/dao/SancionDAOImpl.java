/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Publicacion;
import model.entities.Sancion;
import model.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author agustin
 */
public class SancionDAOImpl implements SancionDAO{
    Transaction transaction = null;
    Session session;

    @Override
    public boolean agregar(Sancion sancion) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            session.save(sancion);
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
    public ArrayList<Sancion> listar() {
        try{
            Session session;
            Transaction transaction;
            
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            //NO SE MUESTRA Y NO SE PORQUE
            System.out.println("A VER: " + transaction);
            return (ArrayList<Sancion>)session.createQuery("from Sancion").list();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Publicacion> publicacionesSancionablesPara(Usuario u) {
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

}
