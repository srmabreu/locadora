package com.showtag.controller;

import java.util.List;

import javax.annotation.PostConstruct;
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
	
	private LazyUserSerieDataModel lazyModel;
	
	private List<UserSerie> userSerieList;
	
	@ManagedProperty(value = "#{serieService}")
	private SerieService serieService;
	
	@ManagedProperty(value = "#{userSerieService}")
	private UserSerieService userSerieService;
	
	public UserSerieController() {
		userSerie = new UserSerie();
	}
	
	@PostConstruct
	public void postConstruct() {
		lazyModel = new LazyUserSerieDataModel(userSerieService, getLoggedInUser().getId());
		userSerieList = userSerieService.findSerieByUser(getLoggedInUser().getId());
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
	
	public LazyUserSerieDataModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyUserSerieDataModel lazyModel) {
		this.lazyModel = lazyModel;
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

	public List<UserSerie> getUserSerieList() {
		return userSerieList;
	}

	public void setUserSerieList(List<UserSerie> userSerieList) {
		this.userSerieList = userSerieList;
	}
	
}
