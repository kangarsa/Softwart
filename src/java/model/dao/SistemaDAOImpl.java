/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.Date;
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
    public Sistema getSistema() {
        Sistema sistema;
        
        try{
            Session sessionLocal;
            sessionLocal=HibernateUtil.getSessionFactory().getCurrentSession();
            
            return sistema = (Sistema) sessionLocal.createQuery("from Sistema sis order by sis.idSistema").uniqueResult();
             
        }
        catch(HibernateException e){
            return null;
        }       
    }
    
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

    @Override
    public boolean cambiarTitulo(String titulo) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setTituloDelSitio(titulo);
            
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
    public boolean cambiarDescripcion(String descripcion) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setDescripcionDelSitio(descripcion);
            
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
    public boolean setTag(String tag) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setTagsDelSitio(tag);
            
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
    public boolean setUris(String uris) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setUrisSemanticas(uris);
            
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
    public boolean setBanner(String banner) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setBanner(banner);
            
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
    public boolean setEstilo(String estilo) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setEstilo(estilo);
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
    public boolean habilitarSitio() {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setHablitado(Boolean.TRUE);
            
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
    public boolean deshabilitarSitio() {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setHablitado(Boolean.FALSE);
            
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
    public boolean activarModerarPublicaciones() {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setModerarPublicaciones(Boolean.TRUE);
            
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
    public boolean desactivarModerarPublicaciones() {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setModerarPublicaciones(Boolean.FALSE);
            
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
    public boolean cambiarPuntosParaSancionar(Integer limitePuntos) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setPuntosParaSancionar(limitePuntos);
            
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
    public boolean cambiarTiempoDeSancion(Integer tiempo) {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            sistema.setTiempoDeSancion(tiempo);
            
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
    public Date getFechaModificacion() {
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
           
            Sistema sistema = this.getSistema();// puede ser null?
            return sistema.getFechaModificacion();
 
        }
        catch(HibernateException e){
            throw new UnsupportedOperationException("FALLO EN getFechaModificacion");

        }
    }


    
}
