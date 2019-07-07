package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_cidade")
public class Cidade implements Serializable{
	
	@Id
	@Column(name="id_cidade", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_sequence")
	@SequenceGenerator(name="cidade_sequence",sequenceName = "cidade_id_sequence",allocationSize = 1)
	private Long id;
	
	@NotBlank
	@Column(name="ds_nome",nullable = false, length = 38)
	@Size(max = 38, min = 5)
	private String nome;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_id",nullable = false, foreignKey = @ForeignKey(name = "fk_cidade_estado"))
	private Estado estado;		
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cidade_id")
	private Set<Bairro> bairros = new HashSet<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Set<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(Set<Bairro> bairros) {
		this.bairros = bairros;
	}
	

	
	
}
