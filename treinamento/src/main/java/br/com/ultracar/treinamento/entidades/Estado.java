package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_estado")
public class Estado implements Serializable{
	
	@Id
	@Column(name="id_estado", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estado_sequence")
	@SequenceGenerator(name="estado_sequence",sequenceName = "estado_id_sequence",allocationSize = 1)
	private Long id;
	
	@NotBlank
	@Max(2)
	@Column(name="ds_sigla",length = 2,nullable = false)
	private String sigla;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado_id")
	private Set<Cidade> cidades = new HashSet<>();	
	

	public Set<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
		
	

}
