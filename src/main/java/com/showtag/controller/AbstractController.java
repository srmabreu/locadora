package com.showtag.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.showtag.model.User;
import com.showtag.util.UserSession;

public abstract class AbstractController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	@ManagedProperty(value = "#{userSession}")
	protected UserSession userSession;
	
	protected void addErrorMessage(String summary) {
		FacesMessage msg = new FacesMessage(summary);
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	protected User getLoggedInUser() {
		if (userSession != null ) {
			return userSession.getUser();
		}
		return null;
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		log = LoggerFactory.getLogger(getClass());
	}
	
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

}
