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
import model.entities.Tag;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author agustin
 */
public class TagDaoHibernateJPA extends GenericDaoHibernateJPA<Tag> implements TagDAO {
    Transaction transaction = null;
    Session session;

    public TagDaoHibernateJPA(){
        super(Tag.class);
        this.initEmfAndEm();
    }
    
    @Override
    public boolean agregar(Tag tag) {
        EntityManager em = this.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(tag);
        em.flush();
        etx.commit();
        //em.close();
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Tag> listar() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Tag> query = (TypedQuery<Tag>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e " );

        if(query.getResultList().isEmpty()){
            return null;
        }
        return query.getResultList();

    }
    
    @Override
    public boolean editar(Tag tag) {
        EntityManager em = this.getEntityManager();
        
        Tag tagAux = em.find(Tag.class, tag.getIdTag());
        
        em.getTransaction().begin();
        tagAux.setIdTag(tag.getIdTag());
        tagAux.setCantidad(tag.getCantidad());
        tagAux.setTexto(tag.getTexto());
        
        em.getTransaction().commit();
        
        return true;
    }

    @Override
    public void eliminar(Tag tag) {
        EntityManager em = this.getEntityManager();
        
        em.getTransaction().begin();
        tag = em.merge(tag);
        em.remove(tag);
        em.getTransaction().commit();
    }

    @Override
    public Tag getTagById(Integer idTag) {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Tag> query = (TypedQuery<Tag>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.idTag = " + idTag +" ");
		if(query.getResultList().isEmpty()){
                    return null;
                }
        return (Tag) query.getResultList().get(0);
    }

    @Override
    public Tag buscarPorTexto(String textoTag){
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Tag> query = (TypedQuery<Tag>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.texto ='" + textoTag +"' ");
		if(query.getResultList().isEmpty()){
                    return null;
                }
        
        System.out.println("OBTIENE TAG MODELO: " + query.getResultList());
        
        return (Tag) query.getResultList().get(0);
    }

    
}
