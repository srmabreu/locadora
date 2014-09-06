package com.locadora.controller;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.locadora.model.Veiculos;

public abstract class AbstractLazyDataModel<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;
	
	@Override
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		List<T> list = search(first, pageSize, filters, sortField, sortOrder);
		
		setRowCount(Veiculos.getInstance().getVeiculos().size());
		return list;
	}
	
	public abstract List<T> search(int first, int pageSize, Map<String, String> filters, String sortField, SortOrder sortOrder);


}
