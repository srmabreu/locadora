package com.showtag.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.showtag.model.ActiveUsers;
import com.showtag.model.Credentials;
import com.showtag.model.User;
import com.showtag.service.UserService;

@ManagedBean
@ViewScoped
public class LoginController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	@ManagedProperty(value = "#{activeUsers}")
	private ActiveUsers activeUsers;
	
	@ManagedProperty(value = "#{credentials}")
	private Credentials credentials;
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	public String login() {
		String outcome = null;
		try {
			String username = credentials.getUsername();
			String password = credentials.getPassword();
			User user = userService.findUser(username, password);
			if (user == null) {
				addErrorMessage("Login inválido");
				userSession.setUser(null);
			} else {
				userSession.setUser(user);
				if (!activeUsers.contains(user)) {
					activeUsers.add(user);
				}
				outcome = "members";
			}
		} catch (Exception e) {
			log.error("Unable to login", e);
		}
		return outcome;
	}
	
	public boolean isLoggedIn() {
		return getLoggedInUser() != null;
	}

	public ActiveUsers getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(ActiveUsers activeUsers) {
		this.activeUsers = activeUsers;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
