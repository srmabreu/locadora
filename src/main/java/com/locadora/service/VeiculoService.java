package com.locadora.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.locadora.model.Veiculo;
import com.locadora.model.Veiculos;

/**
 * Classe responsável por executar as consultas na entidade veiculo. Se pudesse
 * ser utilizado jboss, essa classe seria um EJB. 
 * 
 * @author Sérgio Abreu
 */
@ManagedBean(name = "veiculoService")
@ApplicationScoped
public class VeiculoService implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Veiculo> getVeiculosWithPagination(int first, int pageSize) {
		List<Veiculo> veiculos = Veiculos.getInstance().getVeiculos();
		Integer tamanho = veiculos.size();
        if(tamanho > pageSize) {
            try {
                return veiculos.subList(first, first + pageSize);
            } catch(IndexOutOfBoundsException e) {
                return veiculos.subList(first, first + (tamanho % pageSize));
            }
        } else {
            return veiculos;
        }
	}
	
	public Veiculo findById(Integer id) {
		List<Veiculo> veiculos = Veiculos.getInstance().getVeiculos();
		for (Veiculo v : veiculos) {
			if (v.getId().intValue() == id.intValue()) {
				return v;
			}
		}
		return new Veiculo();
	}
	
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
	
	public void remove(Veiculo veiculo) {
		List<Veiculo> veiculos = Veiculos.getInstance().getVeiculos();
		veiculos.remove(veiculo);
	}

}
