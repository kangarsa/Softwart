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
import model.entities.Evento;
import model.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author agustin
 */
public class EventoDaoHibernateJPA extends GenericDaoHibernateJPA<Evento> implements EventoDAO {
    Transaction transaction = null;
    Session session;
    
    public EventoDaoHibernateJPA(){
        super(Evento.class);
        this.initEmfAndEm();
    }
    
    @Override
    public boolean agregar(Evento evento) {
        EntityManager em = this.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(evento);
        em.flush();
        etx.commit();
        em.close();
        return true;
    }

    @Override
    public List<Evento> listar() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Evento> query = (TypedQuery<Evento>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e " );

        if(query.getResultList().isEmpty()){
            return null;
        }
        return query.getResultList();

    }

    @Override
    public Evento getEventoById(Integer idEvento) {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Evento> query = (TypedQuery<Evento>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.idEvento = " + idEvento +" ");
		if(query.getResultList().isEmpty()){
                    return null;
                }
        return (Evento) query.getResultList().get(0);
    }
    
    @Override
    public boolean editar(Evento evento) {
        EntityManager em = this.getEntityManager();
        
        Evento eventoAux = em.find(Evento.class, evento.getIdEvento());
        
        em.getTransaction().begin();
        eventoAux.setTitulo(evento.getTitulo());
        eventoAux.setIdEvento(evento.getIdEvento());
        eventoAux.setContenido(evento.getContenido());
        eventoAux.setDescripcion(evento.getDescripcion());
        evento.setEventoByUsuarioPublicador(evento.getEventoByUsuarioPublicador());
        
        em.getTransaction().commit();
        
        return true;
    }


    @Override
    public void eliminar(Evento evento) {
        EntityManager em = this.getEntityManager();
        
        em.getTransaction().begin();
        evento = em.merge(evento);
        em.remove(evento);
        em.getTransaction().commit();
    }
    
}
