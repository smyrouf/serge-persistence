package com.serge.persistence.model;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.reflection.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public abstract class DaoSupport<T extends Identificable> {


	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	private Class<T> getEntityClass() {
	     ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
	     return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	private Class getIdEntityClass() {
	     ParameterizedType parameterizedType = (ParameterizedType) getEntityClass().getGenericSuperclass();
	     return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	public T persist(T entity) {
		this.hibernateTemplate.saveOrUpdate(entity);
		return entity;
	}
	
	public T delete(T entity) {
		this.hibernateTemplate.delete(entity);
		return entity;
	}
	
	public T get(Serializable id) {
		if ( getIdEntityClass().isInstance(id)) {
			throw new IllegalArgumentException(id+" must be of type"+getIdEntityClass()); 
		}
		T entity = this.hibernateTemplate.get(getEntityClass(), id);
		return entity;
	}
}
