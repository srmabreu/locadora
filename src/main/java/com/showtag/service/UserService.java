package com.showtag.service;

import com.showtag.model.User;

public interface UserService {
	User findUser(String username, String password);
	User findByUsername(String username);
	User save(User user);
}
