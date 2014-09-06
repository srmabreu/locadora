package com.locadora.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import com.locadora.model.Veiculo;
import com.locadora.service.VeiculoService;

public class LazyVeiculoDataModel extends AbstractLazyDataModel<Veiculo> {
	
	private static final long serialVersionUID = 1L;
	
	private VeiculoService veiculoService;
	
	public LazyVeiculoDataModel(VeiculoService veiculoService) {
		super();
		this.veiculoService = veiculoService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Veiculo getRowData(String rowKey) {
		for (Veiculo l : (List<Veiculo>) getWrappedData()) {
			if (l.getId().toString().equals(rowKey)) {
				return l;
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Veiculo object) {
		return object.getId();
	}

	@Override
	public List<Veiculo> search(int first, int pageSize,
			Map<String, String> filters, String sortField, SortOrder sortOrder) {
		List<Veiculo> lista = veiculoService.getVeiculosWithPagination(first, pageSize);
		
		if(sortField != null) {
            Collections.sort(lista, new LazySorter(sortField, sortOrder));
        }
		
		return lista;
	}

}
