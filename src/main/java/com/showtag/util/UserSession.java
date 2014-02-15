package com.showtag.util;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.showtag.model.ActiveUsers;
import com.showtag.model.User;

@Named
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ActiveUsers activeUsers;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
     * CDI calls this method before the bean is destroyed. Since this class is
     * session-scoped, it will get called if the user session expires, allowing
     * us to remove the user from the active user list.
     */
	@PreDestroy
	public void release() {
		activeUsers.remove(user);
	}
	
}
