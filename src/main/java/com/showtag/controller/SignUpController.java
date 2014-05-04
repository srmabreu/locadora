package com.showtag.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.showtag.model.User;
import com.showtag.service.UserService;

@ManagedBean
@ViewScoped
public class SignUpController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	public SignUpController() {
		user = new User();
	}
	
	public String signup() {
		if (isValidUser()) {
			userService.save(user);
			return "login";
		}
		return null;
	}
	
	private Boolean isValidUser() {
		boolean valid = false;
		if (user.getUsername() != null) {
			if (userService.findByUsername(user.getUsername()) == null) {
				valid = true;
			} else {
				FacesMessage msg = new FacesMessage();
				msg.setDetail("O email utilizado já está cadastrado no sistema.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		return valid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
