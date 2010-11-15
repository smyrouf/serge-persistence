package com.serge.persistence.model;

import java.io.Serializable;


public interface DaoStandard<T extends Identificable<? extends Serializable>> {

	public T persist(T entity);
	
	public T delete(T entity);
	
	public T detach(T entity);
	
	public T attach(T entity);
	
	public T get(Serializable id);
	
}
