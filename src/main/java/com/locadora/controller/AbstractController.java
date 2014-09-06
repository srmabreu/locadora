package com.locadora.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AbstractController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected void addErrorMessage(String summary) {
		FacesMessage msg = new FacesMessage();
		msg.setDetail(summary);
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	protected void addInfoMessage(String summary) {
		FacesMessage msg = new FacesMessage();
		msg.setDetail(summary);
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
