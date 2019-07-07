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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ultracar.treinamento.entidades.enumeradores.Crud;


@SuppressWarnings("serial")
@Entity
@Table(name="tb_operacao")
public class Operacao implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "operacao_sequence")
	@SequenceGenerator(name="operacao_sequence",sequenceName = "operacao_id_sequence",allocationSize = 1)
	@Column(name="id_operacao",nullable = false)
	private Long idOperacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="en_operacao",nullable = false,length = 10)
	private Crud operacao;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "operacoes")
	private Set<PermissaoAcesso> permissoesDeAcesso = new HashSet<>();
	
	@Size(min = 5, max = 45)
	@Column(name = "ds_descricao", length = 45, nullable = false)
	private String descricao;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tb_operacao_servico", joinColumns = {@JoinColumn(name = "id_operacao")}, inverseJoinColumns = {@JoinColumn(name = "id_servico")})
	private Set<Servico> servicos = new HashSet<>();
	
	

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

	public Set<PermissaoAcesso> getPermissoesDeAcesso() {
		return permissoesDeAcesso;
	}

	public void setPermissoesDeAcesso(Set<PermissaoAcesso> permissoesDeAcesso) {
		this.permissoesDeAcesso = permissoesDeAcesso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdOperacao() {
		return idOperacao;
	}

	public void setIdOperacao(Long idOperacao) {
		this.idOperacao = idOperacao;
	}

	public Crud getOperacao() {
		return operacao;
	}

	public void setOperacao(Crud operacao) {
		this.operacao = operacao;
	}
	
	

}
