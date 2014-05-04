package com.showtag.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import com.showtag.model.UserSerie;
import com.showtag.service.UserSerieService;

@Named("userSerieService")
@Stateless
public class UserSerieServiceImpl extends AbstractService<UserSerie> implements UserSerieService {
	
	public void save(UserSerie obj) {
		em.merge(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserSerie> findSerieByUser(Integer userId) {
		return em.createNamedQuery(UserSerie.FIND_SERIE_BY_USER).setParameter("userId", userId).getResultList();
	}

}
