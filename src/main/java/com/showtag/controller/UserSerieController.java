package com.showtag.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.showtag.model.Serie;
import com.showtag.model.UserSerie;
import com.showtag.service.SerieService;
import com.showtag.service.UserSerieService;

@ManagedBean
@ViewScoped
public class UserSerieController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private UserSerie userSerie;
	
	@ManagedProperty(value = "#{serieService}")
	private SerieService serieService;
	
	@ManagedProperty(value = "#{userSerieService}")
	private UserSerieService userSerieService;
	
	public UserSerieController() {
		userSerie = new UserSerie();
	}

	public List<Serie> complete(String query) {
		return serieService.findByName("%" + query + "%");
	}
	
	public void save() {
		userSerie.setUser(getLoggedInUser());
		userSerieService.save(userSerie);
	}
	
	public UserSerie getUserSerie() {
		return userSerie;
	}

	public void setUserSerie(UserSerie userSerie) {
		this.userSerie = userSerie;
	}

	public SerieService getSerieService() {
		return serieService;
	}

	public void setSerieService(SerieService serieService) {
		this.serieService = serieService;
	}

	public UserSerieService getUserSerieService() {
		return userSerieService;
	}

	public void setUserSerieService(UserSerieService userSerieService) {
		this.userSerieService = userSerieService;
	}
	
}
