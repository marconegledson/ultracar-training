package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ultracar.treinamento.entidades.enumeradores.Situacao;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario_sequence")
	@SequenceGenerator(name="usuario_sequence", sequenceName = "usuario_id_sequence", allocationSize = 1)
	@Column(name="id_usuario",nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name = "ds_login",nullable = false ,length = 45)
	private String login;

	@NotBlank
	@Size(min = 5, max = 45)
	@Column(name="ds_senha",nullable = false, length = 45)
	private String senha;
	
	@NotNull
	@Column(name="dt_ultimo_acesso", nullable = false )
	private Date ultimoAcesso;
	
	@Email	
	@Column(name="ds_email",length = 45)
	private String email;
	
	@NotNull
	@Column(name="lg_administrador",nullable = false)
	private boolean administrador;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="en_situacao", nullable = false)
	private Situacao situacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<PermissaoAcesso> permissoesDeAcesso = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<GrupoAcesso> grupoDeAcesso = new HashSet<>();
	
	@Transient
	private String token;	
	
		
	
	public Set<GrupoAcesso> getGrupoDeAcesso() {
		return grupoDeAcesso;
	}

	public void setGrupoDeAcesso(Set<GrupoAcesso> grupoDeAcesso) {
		this.grupoDeAcesso = grupoDeAcesso;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public Set<PermissaoAcesso> getPermissoesDeAcesso() {
		return permissoesDeAcesso;
	}

	public void setPermissoesDeAcesso(Set<PermissaoAcesso> permissoesDeAcesso) {
		this.permissoesDeAcesso = permissoesDeAcesso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
	
}
