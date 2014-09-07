package com.locadora.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.locadora.model.Veiculo;
import com.locadora.model.Veiculos;

/**
 * Classe responsável por executar as consultas na entidade veiculo. Se fosse
 * utilizado jboss, essa classe seria um EJB.
 * 
 * @author Sérgio Abreu <srmabreu@gmail.com>
 */
@ManagedBean(name = "veiculoService")
@ApplicationScoped
public class VeiculoService implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Busca todos os veiculos e aplica paginação
	 * 
	 * @param first
	 *            Primeiro elemento da pagina
	 * @param pageSize
	 *            Quantidade de registros na pagina
	 * @return Lista de veículos paginada
	 */
	public List<Veiculo> getVeiculosWithPagination(int first, int pageSize) {
		List<Veiculo> veiculos = Veiculos.getInstance().getVeiculos();
		Integer tamanho = veiculos.size();
		if (tamanho > pageSize) {
			try {
				return veiculos.subList(first, first + pageSize);
			} catch (IndexOutOfBoundsException e) {
				return veiculos.subList(first, first + (tamanho % pageSize));
			}
		} else {
			return veiculos;
		}
	}

	/**
	 * Busca veículo pelo id
	 * 
	 * @param id
	 * @return Veículo com id informado
	 */
	public Veiculo findById(Integer id) {
		List<Veiculo> veiculos = Veiculos.getInstance().getVeiculos();
		for (Veiculo v : veiculos) {
			if (v.getId().intValue() == id.intValue()) {
				return v;
			}
		}
		return new Veiculo();
	}

	/**
	 * Cria e edita um veículo. Se o id do veículo for diferente de null realiza
	 * uma busca pelo veículo e realiza a alteração, caso contrário, incrementa
	 * o contador do id e insere um novo veículo na lista
	 * 
	 * @param veiculo que será adicionado na lista ou editado
	 */
	public void save(Veiculo veiculo) {
		List<Veiculo> veiculos = Veiculos.getInstance().getVeiculos();
		if (veiculo.getId() != null) {
			for (Veiculo v : veiculos) {
				if (v.getId().intValue() == veiculo.getId().intValue()) {
					v = veiculo;
				}
			}
		} else {
			Integer count = Veiculos.getInstance().getCount();
			count = count + 1;
			Veiculos.getInstance().setCount(count);
			veiculo.setId(count);
			veiculos.add(veiculo);
		}
	}

	/**
	 * Remove veículo da lista
	 * 
	 * @param veiculo que será removido
	 */
	public void remove(Veiculo veiculo) {
		List<Veiculo> veiculos = Veiculos.getInstance().getVeiculos();
		veiculos.remove(veiculo);
	}

}
