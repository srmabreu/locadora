package com.showtag.controller;

import java.util.List;

import com.showtag.model.UserSerie;
import com.showtag.service.UserSerieService;

public class LazyUserSerieDataModel extends AbstractLazyDataModel<UserSerie> {
	
	private static final long serialVersionUID = 1L;

	private UserSerieService userSerieService; 
	
	private Integer userId;
	
	public LazyUserSerieDataModel(UserSerieService userSerieService,
			Integer userId) {
		super();
		this.userSerieService = userSerieService;
		this.userId = userId;
	}

	@Override
	public List<UserSerie> search() {
		return userSerieService.findSerieByUser(userId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserSerie getRowData(String rowKey) {
		for (UserSerie l : (List<UserSerie>) getWrappedData()) {
			if (l.getId().toString().equals(rowKey)) {
				return l;
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(UserSerie object) {
		return object.getId();
	}

}
