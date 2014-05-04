package com.showtag.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import com.showtag.model.User;
import com.showtag.service.UserService;

@Named("userService")
@Stateless
public class UserServiceImpl extends AbstractService<User> implements UserService {

	@Override
	@SuppressWarnings("unchecked")
	public User findUser(String username, String password) {
		List<User> users = em.createNamedQuery(User.FIND_BY_NAME).setParameter("username", username).setParameter("password", password).getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User findByUsername(String username) {
		List<User> u = em.createNamedQuery(User.FIND_BY_USERNAME).setParameter("username", username).getResultList();
		if (!u.isEmpty()) {
			return u.get(0);
		}
		return null;
	}
	
	public User save(User obj) {
		User saved = em.merge(obj);
		return saved;
	}

}