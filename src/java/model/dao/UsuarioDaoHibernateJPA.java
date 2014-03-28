/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import java.util.List;
import javax.persistence.*;
import model.dao.impl.GenericDaoHibernateJPA;
import model.entities.Usuario;
import org.hibernate.Query;

/**
 *
 * @author agustin
 */
public class UsuarioDaoHibernateJPA extends GenericDaoHibernateJPA<Usuario> implements
		UsuarioDAO {

    /**
	public StudentDaoHibernateJPA(){
		super(Student.class);
	}
	
	public Student findByUsername(String s){
		javax.persistence.Query query = this.getEntityManager().createQuery("select e from "+getPersistentClass().getSimpleName()+" e where e.username = '"+s+"'");
		if(query.getResultList().size() == 0){
			return null;
		}
		return (Student) query.getResultList().get(0);
	}
 */
    
    @Override
    public boolean agregar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
        TypedQuery<Usuario> query = (TypedQuery<Usuario>) (Query) this.getEntityManager().createQuery("select e from " + getPersistentClass().getSimpleName());
                if(query.getResultList().isEmpty()){
                    return null;
                }
        return query.getResultList();        
    }


    @Override
    public Usuario usuarioConMail(String mail) {
        TypedQuery<Usuario> query = (TypedQuery<Usuario>) (Query) this.getEntityManager().createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.mail = '" + mail +"'");
                if(query.getResultList().isEmpty()){
                    return null;
                }
        return (Usuario) query.getResultList().get(0);        
    }

    @Override
    public Usuario getUsuario(Usuario u) {
        TypedQuery<Usuario> query = (TypedQuery<Usuario>) (Query) this.getEntityManager().createQuery("select e from " + getPersistentClass().getSimpleName() + " e where e.dni = '" + u.getDni() +"'");
		if(query.getResultList().isEmpty()){
                    return null;
                }
        return (Usuario) query.getResultList().get(0);
    }
}
