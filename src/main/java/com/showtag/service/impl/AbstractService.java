package com.showtag.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractService<T> {
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
//	public T save(T obj) {
//		T saved = em.merge(obj);
//		return saved;
//	}

}
