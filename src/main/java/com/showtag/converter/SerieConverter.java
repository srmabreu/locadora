package com.showtag.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.showtag.model.Serie;
import com.showtag.service.SerieService;

@Named("serieConverter")
@RequestScoped
public class SerieConverter implements Converter {
	
	@EJB
	private SerieService serieService;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Integer id = new Integer(arg2);
		return serieService.findById(id);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Serie serie = (Serie) arg2;
		if (serie != null && serie.getId() != null) {
			return serie.getId().toString();
		}
		return null;
	}

	public SerieService getSerieService() {
		return serieService;
	}

	public void setSerieService(SerieService serieService) {
		this.serieService = serieService;
	}

}
