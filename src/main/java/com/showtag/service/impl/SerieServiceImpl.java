package com.showtag.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import com.showtag.model.Serie;
import com.showtag.service.SerieService;

@Named("serieService")
@Stateless
public class SerieServiceImpl extends AbstractService<Serie> implements SerieService {
	
	@SuppressWarnings("unchecked")
	public List<Serie> findByName(String query) {
		return em.createNamedQuery(Serie.FIND_BY_NAME).setParameter("serieName", query).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Serie findById(Integer id) {
		List<Serie> serie = em.createNamedQuery(Serie.FIND_BY_ID).setParameter("serieId", id).getResultList();
		if (!serie.isEmpty()) {
			return serie.get(0);
		}
		return null;
	}
	
	public Serie save(Serie obj) {
		Serie saved = em.merge(obj);
		return saved;
	}

}
