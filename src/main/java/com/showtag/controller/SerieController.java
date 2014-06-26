package com.showtag.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.showtag.model.Serie;
import com.showtag.service.SerieService;

@ManagedBean
@ViewScoped
public class SerieController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Serie serie;
	
	private LazySerieDataModel lazyModel;
	
	private String id;
	
	@ManagedProperty(value = "#{serieService}")
	private SerieService serieService;
	
	public SerieController() {
		serie = new Serie();
	}
	
	@PostConstruct
	public void postConstruct() {
		lazyModel = new LazySerieDataModel(serieService);
	}
	
	public void init() {
		if (getId() != null && !getId().equals("")) {
			serie = serieService.findById(Integer.valueOf(getId()));
		}
	}
	
	public String editRedirect(Integer id) {
		return "create.xhtml?faces-redirect=true&id="+id;
	}
	
	public String save() {
		serieService.save(serie);
		serie = new Serie();
		addInfoMessage("Cadastro realizado com sucesso!");
		return "search.xhtml?faces-redirect=true";
	}
	
	public void remove(Serie serie) {
		serieService.remove(serie);
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public LazySerieDataModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazySerieDataModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public SerieService getSerieService() {
		return serieService;
	}

	public void setSerieService(SerieService serieService) {
		this.serieService = serieService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}