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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_solicitante")
public class Solicitante implements Serializable{
	
	@Id
	@Column(name="id_solicitante", nullable = false, length  = 20)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "solicitante_sequence")
	@SequenceGenerator(name = "solicitante_sequence", sequenceName = "solicitante_id_sequence", allocationSize = 1)
	private Long id;
		 
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_id",nullable = false, foreignKey = @ForeignKey(name = "fk_solicitante_endereco" ))
	private Endereco endereco;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "servico")
	private Set<Endereco> enderecos = new HashSet<>();
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}	


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Set<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}



	
	

}