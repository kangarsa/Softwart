package model.dao.impl;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;



//import org.springframework.test.context.transaction.*; 

/**
 *
 * @author agustin
 */

public  class GenericDaoHibernateJPA<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	
	private EntityManager entityManager;
        
        @PersistenceUnit(unitName = "test")
        private EntityManagerFactory entityManagerFactory;
        
        @Before
        public void initEmfAndEm() {
            Logger.getLogger("org").setLevel(Level.ALL);

            entityManagerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
        }
	
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
	
	
        @Override
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
            System.out.println("WHAAAT???  " + entityManagerFactory);
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                System.out.println("QUE PASA??? " + this.getEntityManager());
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
