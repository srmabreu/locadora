package com.showtag.controller;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public abstract class AbstractLazyDataModel<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;
	
	@Override
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		List<T> list = search();
		setWrappedData(list);
		setRowCount(list.size());
		return list;
	}
	
	@Override
	public void setRowIndex(int rowIndex) {
		if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
	}
	
	public abstract List<T> search();


}
