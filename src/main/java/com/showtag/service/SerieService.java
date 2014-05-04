package com.showtag.service;

import java.util.List;

import com.showtag.model.Serie;

public interface SerieService {
	
	List<Serie> findByName(String query);
	Serie findById(Integer id);

}
