package com.showtag.model;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ActiveUsers extends ArrayList<User> {

	private static final long serialVersionUID = 1L;

}
