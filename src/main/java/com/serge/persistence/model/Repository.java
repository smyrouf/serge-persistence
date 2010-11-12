package com.serge.persistence.model;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;



public class Repository<T extends Identificable<? extends Serializable>, V  extends Serializable> {

	@Autowired
	protected EntityManager entityManager;
	private Class<T> clazz = Class<T>;
	
	public T persist(T entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	public T get(T entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	public T load(V id) {
		T entity = entityManager.find(Class<T> , id);
		return entity;
	}
}
