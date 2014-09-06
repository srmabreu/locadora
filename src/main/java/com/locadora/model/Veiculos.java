package com.locadora.model;

import java.util.ArrayList;
import java.util.List;

public class Veiculos {
	
	private static Veiculos instance;
	
	private List<Veiculo> veiculos;
	private Integer count;
	
	private Veiculos() {
		veiculos = new ArrayList<Veiculo>();
		count = 0;
	}
	
	public static Veiculos getInstance() {
		if (instance == null) {
			instance = new Veiculos();
		}
		return instance;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
