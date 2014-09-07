package com.locadora.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.locadora.model.Veiculo;
import com.locadora.service.VeiculoService;

/**
 * Classe bean que controla as paginas para listar e cadastrar veiculos. Esta
 * sendo utilizado ViewScoped para que sempre que mudar de pagina os dados dessa
 * classe sejam resetados e não fiquem na sessão enquanto o usuário estiver
 * utilizando o sistema.
 * 
 * @author Sérgio Abreu <srmabreu@gmail.com>
 */
@ManagedBean
@ViewScoped
public class VeiculoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Veiculo veiculo;

	private LazyVeiculoDataModel lazyModel;

	// id que será passado quando usuário clicar no icone para editar um
	// veículo, isso é necessário por causa do uso do ViewScoped
	private String id;

	@ManagedProperty(value = "#{veiculoService}")
	private VeiculoService veiculoService;

	public VeiculoController() {
		veiculo = new Veiculo();
	}

	@PostConstruct
	public void postConstruct() {
		// o lazyModel não é instaciado no construtor porque a variavel
		// veiculoService não está injetada na execução do construtor
		lazyModel = new LazyVeiculoDataModel(veiculoService);
	}

	/**
	 * Método executado pelo preRenderView, esse método é executado a cada
	 * submit da tela e recupera o veiculo selecionado na tela com a lista de
	 * veículos
	 */
	public void init() {
		if (getId() != null && !getId().equals("")) {
			veiculo = veiculoService.findById(Integer.valueOf(getId()));
		}
	}

	/**
	 * Esse método foi criado apenas porque quis utilizar commandButton no icone
	 * de edição. O commandoButton não envia atributos no submit, então foi
	 * necessário setar manualmente
	 * 
	 * @param id
	 *            do veículo que será editado
	 * @return url da pagina para edição com o id do veículo que será recuperado
	 *         no método init
	 */
	public String editRedirect(Integer id) {
		return "create.xhtml?faces-redirect=true&id=" + id;
	}

	public String save() {
		veiculoService.save(veiculo);
		veiculo = new Veiculo();
		addInfoMessage("Cadastro realizado com sucesso!");
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);
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

	private void addInfoMessage(String summary) {
		FacesMessage msg = new FacesMessage();
		msg.setDetail(summary);
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
