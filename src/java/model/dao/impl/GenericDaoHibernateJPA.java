package model.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static org.eclipse.persistence.sessions.server.ConnectionPolicy.ExclusiveMode.Transactional;


//import org.springframework.test.context.transaction.*; 

/**
 *
 * @author agustin
 */

public  class GenericDaoHibernateJPA<T> extends GenericDAO<T> {
	protected Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	public GenericDaoHibernateJPA(){}
	
	public GenericDaoHibernateJPA(Class<T> c){
		persistentClass = c;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	
	public T persist(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public T update(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	
	public void remove(T entity) {
		this.getEntityManager().remove(entity);
	}

	
	public T remove(Serializable id) {
		T entity = find(id);
		if (entity != null){
			this.remove(entity);
			return entity;
		}
		return null;
	}

	
	public Boolean exists(Serializable id) {
		T entity = find(id);
		if (entity != null){
			return true;
		}
		return false;
	}

	
	public T find(Serializable id) {
		return this.getEntityManager().find(this.getPersistentClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	
	public List<T> findAll() {
		Query query = this.getEntityManager().createQuery("select e from "+getPersistentClass().getSimpleName()+" e");
		List<T> resultList = (List<T>)query.getResultList();
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(String columnOrder) {
		Query query = this.getEntityManager().createQuery("select e from "+getPersistentClass().getSimpleName()+" e order by e."+columnOrder);
		List<T> resultList = (List<T>)query.getResultList();
		return resultList;
	}
}
