package com.locadora.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.locadora.model.Veiculo;
import com.locadora.service.VeiculoService;

@ManagedBean
@ViewScoped
public class VeiculoController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Veiculo veiculo;
	
	private LazyVeiculoDataModel lazyModel;
	
	private String id;
	
	@ManagedProperty(value = "#{veiculoService}")
	private VeiculoService veiculoService;
	
	public VeiculoController() {
		veiculo = new Veiculo();
	}
	
	@PostConstruct
	public void postConstruct() {
		lazyModel = new LazyVeiculoDataModel(veiculoService);
	}
	
	public void init() {
		if (getId() != null && !getId().equals("")) {
			veiculo = veiculoService.findById(Integer.valueOf(getId()));
		}
	}
	
	public String editRedirect(Integer id) {
		return "create.xhtml?faces-redirect=true&id="+id;
	}
	
	public String createRedirect() {
		return "create.xhtml?faces-redirect=true";
	}
	
	public String save() {
		veiculoService.save(veiculo);
		veiculo = new Veiculo();
		addInfoMessage("Cadastro realizado com sucesso!");
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "search.xhtml?faces-redirect=true";
	}
	
	public void remove(Veiculo veiculo) {
		veiculoService.remove(veiculo);
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LazyVeiculoDataModel getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyVeiculoDataModel lazyModel) {
		this.lazyModel = lazyModel;
	}

	public VeiculoService getVeiculoService() {
		return veiculoService;
	}

	public void setVeiculoService(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
