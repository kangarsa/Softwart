/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import model.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author agustin
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    Transaction transaction = null;
    Session session;
    
    @Override
    public boolean agregar(Usuario usuario) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            session.save(usuario);
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
    public ArrayList<Usuario> listar() {
        try{
            Session session;
            Transaction transaction;
            
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            return (ArrayList<Usuario>)session.createQuery("from Usuario").list();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public Usuario usuarioConMail(String mail) {
        try{
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            return (Usuario)sessionLocal.createQuery("from Usuario where mail = ?").setString(0, mail).list().get(0);
        }
        catch(HibernateException e){
            return null;
        }
    }
    
    @Override
    public Usuario getUsuario(Usuario u) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            String hql = "from Usuario u where u.mail = :mail and u.clave = :clave";
            Usuario e= (Usuario)session
                    .createQuery(hql)
                    .setString("mail",u.getMail())
                    .setString("clave",u.getClave())
                    .uniqueResult();
            transaction.commit();
            return e;
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return null;
        }
    }
    
}
