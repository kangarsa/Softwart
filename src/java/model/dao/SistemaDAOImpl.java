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
import org.hibernate.Session;

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
            
           // return sistema = (Sistema) sessionLocal.createQuery("from Sistema sis order by sis.idSistema desc").list().get(0);
             
        }
        catch(HibernateException e){
            return null;
        }       
        return null;
    }
    
    @Override
    public boolean agregar(Sistema sistema) {
        try{

        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public ArrayList<Sistema> listar() {
        try{

        }
        catch(HibernateException e){
            return null;
        }
        return null;
    }

    @Override
    public boolean cambiarTitulo(String titulo) {
        try{

            
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
  
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public boolean setTag(String tag) {
        try{

            
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
     
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }


    @Override
    public boolean setBanner(String banner) {
        try{

        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }


    @Override
    public boolean setEstilo(String estilo) {
        try{
     
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }


    @Override
    public boolean habilitarSitio() {
        try{
   
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public boolean deshabilitarSitio() {
        try{
          
            
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
       
        }
        catch(HibernateException e){
            if(transaction != null)
                transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public boolean cambiarPuntosParaSancionar(Integer limitePuntos) {
        try{
  
            
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
        
 
        }
        catch(HibernateException e){
            throw new UnsupportedOperationException("FALLO EN getFechaModificacion");

        }
        return null;
    }


    
}
