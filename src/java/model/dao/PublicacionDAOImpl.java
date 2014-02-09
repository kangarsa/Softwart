/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.entities.Publicacion;
import model.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
            System.out.println(e);
            if(transaction != null)
                transaction.rollback();
            return false;
        }
    }

    @Override
    public ArrayList<Publicacion> listar() {
        try{
            Session session;
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            
            return (ArrayList<Publicacion>)session.createQuery("from Publicacion").list();
        }
        catch(HibernateException e){
             System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean eliminar(Publicacion publicacion) {
        try{ 
            
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            
            Integer idPub = publicacion.getIdPublicacion();
  
            Query query = session.createQuery("delete Publicacion where publicacion = :idQuery");
            query.setParameter("idQuery", idPub);
            query.executeUpdate();

            transaction.commit();
            
            return this.eliminarComentarios(publicacion);
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
    }
    
    /**
     *
     * @param publicacion
     * @return
     */
    @Override
     public boolean eliminarComentarios(Publicacion publicacion) {
        try{ 
            
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            
            Integer idPub = publicacion.getIdPublicacion();
  
            Query query = session.createQuery("delete Comentario where publicacion = :idQuery");
            query.setParameter("idQuery", idPub);
            query.executeUpdate();

            transaction.commit();
            
            return true;
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
    }
    
    //ES IGUAL AL AGREGAR, REPENSAR O REVISAR
    @Override
    public boolean editar(Publicacion publicacion) {
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
     public List listarComentarios(Publicacion publicacion) {
        try{
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            Session session;
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Comentario c where c.publicacion = :idQuery");
            
            query.setParameter("idQuery", publicacion.getIdPublicacion());
            List comentarios = query.list();
            
            return comentarios;
            
        }
        catch(HibernateException e){
            return null;
        }
    }

    @Override
    public List listarTags(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Publicacion> publicacionesDeUsuario(Usuario usuario) {
        try{
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            
            Integer idUser = usuario.getIdUsuario();
            return (ArrayList<Publicacion>)sessionLocal.createQuery("from Publicacion p where p.usuarioByUsuarioPublicador ='" + idUser + "'").list();
        
        }
        catch(HibernateException e){
            return null;
        }
    }

}
