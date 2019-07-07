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
@Table(name="tb_bairro")
public class Bairro implements Serializable{

	
	@Id
	@Column(name = "id_bairro",nullable = false,length = 11)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bairro_sequence")
	@SequenceGenerator(name = "bairro_sequence",sequenceName = "bairro_id_sequence",allocationSize = 1)
	private Long id;
	
	@NotBlank
	@Column(name="ds_nome",length = 100)
	@Size(max = 100)
	private String nome;
	
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade_id", nullable = false,foreignKey = @ForeignKey(name = "fk_bairro_cidade"))
	private Cidade cidade;	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bairro_id")
	private Set<Endereco> enderecos = new HashSet<>();
	
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


	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public Set<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	
	
	
	
	
}
