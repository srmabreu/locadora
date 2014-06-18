package com.showtag.service;

import java.util.List;

import com.showtag.model.UserSerie;

public interface UserSerieService {
	
	void save(UserSerie userSerie);
	
	List<UserSerie> findSerieByUser(Integer userId);
	
	void remove(UserSerie userSerie);

}
