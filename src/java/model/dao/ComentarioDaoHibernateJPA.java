/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.dao.impl.GenericDaoHibernateJPA;
import model.entities.Comentario;
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
public class ComentarioDaoHibernateJPA extends GenericDaoHibernateJPA<Comentario> implements ComentarioDAO {
    Transaction transaction = null;
    Session session;
    List<Publicacion> publicacionesComentables;
    
    public ComentarioDaoHibernateJPA(){
        super(Comentario.class);
        //this.publicacionesComentables = null;
        this.initEmfAndEm();
    }
    
    @Override
    public List<Publicacion> publicacionesComentablesPara(Usuario u) {
        try{
            
            TypedQuery<Publicacion> query = (TypedQuery<Publicacion>) (Query) this.getEntityManager().createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.USUARIOCOMENTADOR_IDUSUARIO = " + u.getIdUsuario() +" ");
            this.publicacionesComentables = query.getResultList();

        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
        return this.publicacionesComentables;
    }
    
    @Override
    public boolean agregar(Comentario comentario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(comentario);
        em.flush();
        etx.commit();
        em.close();
             
        return true;
    }

    @Override
    public List<Comentario> listar() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Comentario> query = (TypedQuery<Comentario>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e " );

        if(query.getResultList().isEmpty()){
            return null;
        }
        return query.getResultList();
    }
    
    @Override
    public boolean editar(Comentario comentario) {
        EntityManager em = this.getEntityManager();
        
        Comentario comentarioAux = em.find(Comentario.class, comentario.getIdComentario());
        
        em.getTransaction().begin();
        comentarioAux.setTitulo(comentario.getTitulo());
        comentarioAux.setIdComentario(comentario.getIdComentario());
        comentarioAux.setContenido(comentario.getContenido());
        comentarioAux.setUsuarioComentador(comentario.getUsuarioComentador());
        comentarioAux.setUsuarioModerador(comentario.getUsuarioModerador());
        
        em.getTransaction().commit();
        
        return true;
    }

    @Override
    public void eliminar(Comentario comentario) {
        EntityManager em = this.getEntityManager();
        
        em.getTransaction().begin();
        comentario = em.merge(comentario);
        em.remove(comentario);
        em.getTransaction().commit();
    }

    @Override
    public List<Comentario> listarDePublicacion(Integer idPublicacion) {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Comentario> query = (TypedQuery<Comentario>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.publicacion.idPublicacion = " + idPublicacion + " " );

        if(query.getResultList().isEmpty()){
            return null;
        }
        return query.getResultList();
    }
    
}
