package com.serge.persistence.model;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;


public abstract class DaoStandardHibernate<T extends Identificable<? extends Serializable>> implements DaoStandard<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private HibernateTemplate hibernateTemplate;
	
	protected HibernateTemplate getHibernateTemplate() {
		if ( this.hibernateTemplate == null ) {
			this.hibernateTemplate = new HibernateTemplate(this.sessionFactory);
		} 
		return this.hibernateTemplate;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Class<T> getEntityClass() {
	     ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
	     return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	protected Class<?> getIdEntityClass() {
	     ParameterizedType parameterizedType = (ParameterizedType) getEntityClass().getGenericSuperclass();
	     return (Class<?>) parameterizedType.getActualTypeArguments()[0];
	}
	
	
	public T persist(T entity) {
		getHibernateTemplate().save(entity);
		return entity;
	}
	
	public T detach(T entity) {
		getHibernateTemplate().evict(entity);
		return entity;
	}
	
	public T attach(T entity) {
		getHibernateTemplate().merge(entity);
		return entity;
	}
	
	
	public T delete(T entity) {
		getHibernateTemplate().delete(entity);
		return entity;
	}
	
	public T get(Serializable id) {
		if ( getIdEntityClass().isInstance(id)) {
			throw new IllegalArgumentException(id+" must be of type"+getIdEntityClass()); 
		}
		T entity = getHibernateTemplate().get((Class<T>)getEntityClass(), id);
		return entity;
	}
}
