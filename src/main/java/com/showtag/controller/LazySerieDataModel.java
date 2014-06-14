package com.showtag.controller;

import java.util.List;
import java.util.Map;

import com.showtag.model.Serie;
import com.showtag.service.SerieService;

public class LazySerieDataModel extends AbstractLazyDataModel<Serie> {
	
	private static final long serialVersionUID = 1L;
	
	private SerieService serieService;
	
	public LazySerieDataModel(SerieService serieService) {
		super();
		this.serieService = serieService;
	}

	@Override
	public List<Serie> search(int first, int pageSize, Map<String, String> filters) {
		String name = "%%";
		if (filters.get("name") != null && !filters.get("name").equals("")) {
			name = "%" + filters.get("name") + "%";
		}
		return serieService.findByNameAndPagination(name, first, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Serie getRowData(String rowKey) {
		for (Serie l : (List<Serie>) getWrappedData()) {
			if (l.getId().toString().equals(rowKey)) {
				return l;
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Serie object) {
		return object.getId();
	}

}
