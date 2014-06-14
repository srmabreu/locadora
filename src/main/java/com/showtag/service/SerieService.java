package com.showtag.service;

import java.util.List;

import com.showtag.model.Serie;

public interface SerieService {
	
	List<Serie> findByName(String query);
	Serie findById(Integer id);
	List<Serie> findByNameAndPagination(String name, int first, int pageSize);
	Serie save(Serie serie);
}
