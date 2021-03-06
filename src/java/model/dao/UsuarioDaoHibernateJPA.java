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
import model.entities.Usuario;


/**
 *
 * @author agustin
 */
public class UsuarioDaoHibernateJPA extends GenericDaoHibernateJPA<Usuario> implements
		UsuarioDAO {

    public UsuarioDaoHibernateJPA(){
        super(Usuario.class);
        this.initEmfAndEm();
    }
    
    @Override
    public boolean agregar(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.persist(usuario);
        em.flush();
        etx.commit();
        em.close();
        return true;
    }

    @Override
    public List<Usuario> listar() {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Usuario> query = (TypedQuery<Usuario>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e " );

        if(query.getResultList().isEmpty()){
            return null;
        }
        return query.getResultList();

    }


    @Override
    public Usuario usuarioConMail(String mail) {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Usuario> query = (TypedQuery<Usuario>)  em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.mail = '" + mail +"'");     
        
        if(query.getResultList().isEmpty()){
            return null;
        }
        return (Usuario) query.getResultList().get(0);        
    }

    @Override
    public Usuario getUsuario(Usuario u) {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Usuario> query = (TypedQuery<Usuario>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.dni = '" + u.getDni() +"'");
		if(query.getResultList().isEmpty()){
                    return null;
                }
        return (Usuario) query.getResultList().get(0);
    }
    
    @Override
    public Usuario getUsuarioById(Integer idUsuario) {
        EntityManager em = this.getEntityManager();
        
        TypedQuery<Usuario> query = (TypedQuery<Usuario>) em.createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.idUsuario = " + idUsuario +" ");
		if(query.getResultList().isEmpty()){
                    return null;
                }
        return (Usuario) query.getResultList().get(0);
    }

    @Override
    public boolean editar(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        
        Usuario usuarioAux = em.find(Usuario.class, usuario.getIdUsuario());
        
        em.getTransaction().begin();
        usuarioAux.setApellido(usuario.getApellido());
        usuarioAux.setIdUsuario(usuario.getIdUsuario());
        usuarioAux.setNombre(usuario.getNombre());
        usuarioAux.setMail(usuario.getMail());
        usuarioAux.setModerador(usuario.getModerador());
        
        em.getTransaction().commit();
        
        return true;
    }

    @Override
    public void eliminar(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.remove(usuario);
        em.getTransaction().commit();
    }
    
}