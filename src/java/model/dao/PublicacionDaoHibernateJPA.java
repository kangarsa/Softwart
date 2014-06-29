/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.dao.impl.GenericDaoHibernateJPA;
import model.entities.Publicacion;
import model.entities.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author agustin
 */
public class PublicacionDaoHibernateJPA extends GenericDaoHibernateJPA<Publicacion> implements PublicacionDAO {
    Session session;

    public PublicacionDaoHibernateJPA(){
        super(Publicacion.class);
        this.initEmfAndEm();
    }
    
    @Override
    public boolean agregar(Publicacion publicacion) {
        EntityManager em = this.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(publicacion);
        em.flush();
        etx.commit();
        em.close();
        return true;
    }

    @Override
    public List<Publicacion> listar() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Publicacion> query = (TypedQuery<Publicacion>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e " );

        if(query.getResultList().isEmpty()){
            return null;
        }
       
        Iterator iterador = query.getResultList().iterator();
        while(iterador.hasNext()){
            em.refresh(iterador.next());
        }
 
        return query.getResultList();

    }

    @Override
    public void eliminar(Publicacion publicacion) {
        EntityManager em = this.getEntityManager();
        
        em.getTransaction().begin();
        publicacion = em.merge(publicacion);
        em.remove(publicacion);
        em.getTransaction().commit();
    }
    
    
    /**
     *
     * @param publicacion
     * @return
     */

    
    //ES IGUAL AL AGREGAR, REPENSAR O REVISAR
    @Override
    public boolean editar(Publicacion publicacion) {
        EntityManager em = this.getEntityManager();
        
        Publicacion publicacionAux = em.find(Publicacion.class, publicacion.getIdPublicacion());
        
        em.getTransaction().begin();
        publicacionAux.setTitulo(publicacion.getTitulo());
        publicacionAux.setIdPublicacion(publicacion.getIdPublicacion());
        publicacionAux.setDescripcion(publicacion.getDescripcion());
        publicacionAux.setContenido(publicacion.getContenido());
        publicacionAux.setUsuarioModerador(publicacion.getUsuarioModerador());
        
        em.getTransaction().commit();
        
        return true;
    }

    @Override
     public List listarComentarios(Publicacion publicacion) {
        EntityManager em = this.getEntityManager(); 
        
        TypedQuery<Publicacion> query = (TypedQuery<Publicacion>) em.createQuery("select c from " + getPersistentClass().getSimpleName() + " e, Comentario c WHERE e.idPublicacion = c.publicacion.idPublicacion " );
        System.out.println("LISTA COMENTARIOS DAO: " + query.getResultList());
        
        if(query.getResultList().isEmpty()){
            return null;
        }
        return query.getResultList();
    }

    @Override
    public List listarTags(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Publicacion> publicacionesDeUsuario(Usuario usuario) {
        try{
   
        }
        catch(HibernateException e){
            return null;
        }
        return null;
    }

    @Override
    public boolean eliminarComentarios(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publicacion getPublicacionById(Integer idPublicacion) {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Publicacion> query = (TypedQuery<Publicacion>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.idPublicacion= " + idPublicacion +" ");
		if(query.getResultList().isEmpty()){
                    return null;
                }
        return (Publicacion) query.getResultList().get(0);
    }

}
