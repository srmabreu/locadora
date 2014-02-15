package com.showtag.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import com.showtag.model.User;
import com.showtag.service.UserService;

@Named("userService")
@Stateless
public class UserServiceImpl extends AbstractService implements UserService {

	@Override
	@SuppressWarnings("unchecked")
	public User findUser(String username, String password) {
		List<User> users = em.createNamedQuery(User.FIND_BY_NAME).setParameter("username", username).setParameter("password", password).getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

}
