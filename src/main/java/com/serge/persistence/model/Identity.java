package com.serge.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.serge.persistence.model.Identificable;


@Entity
public abstract class Identity<T extends Serializable>  implements Identificable<T> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private T id;

	public void setId(T id) {
		this.id = id;
	}

	public T getId() {
		return id;
	}
	
	
}
