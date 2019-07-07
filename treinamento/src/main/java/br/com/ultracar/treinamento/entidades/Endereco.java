package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ultracar.treinamento.entidades.enumeradores.TipoLocal;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_endereco")
public class Endereco implements Serializable{

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "endereco_sequence")
	@SequenceGenerator(name="endereco_sequence",sequenceName = "endereco_id_sequence", allocationSize = 1)	
	@Column(name = "id_endereco",nullable = false)
	private Long id;
	
	@NotNull	
	@Column(name="en_tipo_local",nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private TipoLocal tipo_local;
	
	@NotBlank
	@Size(min = 5 ,max=128)
	@Column(name="ds_logradouro",nullable = false, length = 128)
	private String logradouro;
		
	@Size(min = 1, max = 11)
	@Column(name="nm_numero", nullable = false, length = 11)
	private Integer numero;
		
	@Size(min = 5, max = 255)
	@Column(name="ds_complemento",length = 255)
	private String complemento;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bairro_id",nullable = false,foreignKey = @ForeignKey(name = "fk_endereco_bairro"))
	private Bairro bairro;	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Solicitante> solicitantes = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Ponto> pontos = new HashSet<>();


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tb_endereco_solicitante", joinColumns = {@JoinColumn(name = "id_endereco")},inverseJoinColumns = {@JoinColumn(name = "id_solicitante")})
	private Set<Solicitante> servico = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Servico> servicos = new HashSet<>();
	
	


	public Set<Servico> getServicos() {
		return servicos;
	}


	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

	public TipoLocal getTipo_local() {
		return tipo_local;
	}


	public void setTipo_local(TipoLocal tipo_local) {
		this.tipo_local = tipo_local;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public Bairro getBairro() {
		return bairro;
	}


	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}


	public Set<Solicitante> getSolicitantes() {
		return solicitantes;
	}


	public void setSolicitantes(Set<Solicitante> solicitantes) {
		this.solicitantes = solicitantes;
	}


	public Set<Ponto> getPontos() {
		return pontos;
	}


	public void setPontos(Set<Ponto> pontos) {
		this.pontos = pontos;
	}


	public Set<Solicitante> getServico() {
		return servico;
	}


	public void setServico(Set<Solicitante> servico) {
		this.servico = servico;
	}


	
	


	
	
	
	
}
