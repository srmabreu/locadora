package com.locadora.controller;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.locadora.model.Veiculo;
import com.locadora.model.Veiculos;
import com.locadora.service.VeiculoService;

/**
 * Classe que busca os veículos cadastrados e aplica paginação e ordenação
 * 
 * @author Sérgio Abreu <srmabreu@gmail.com>
 */
public class LazyVeiculoDataModel extends LazyDataModel<Veiculo> {

	private static final long serialVersionUID = 1L;

	private VeiculoService veiculoService;

	public LazyVeiculoDataModel(VeiculoService veiculoService) {
		super();
		this.veiculoService = veiculoService;
	}

	/**
	 * Realiza a busca com paginação e informa o total de registros para
	 * calculo da paginação.
	 */
	@Override
	public List<Veiculo> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		List<Veiculo> lista = veiculoService.getVeiculosWithPagination(first,
				pageSize, sortField, sortOrder);

		setRowCount(Veiculos.getInstance().getVeiculos().size());
		return lista;
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

}
