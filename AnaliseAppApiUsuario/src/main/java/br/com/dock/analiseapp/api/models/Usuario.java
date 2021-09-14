package br.com.dock.analiseapp.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.dock.analiseapp.api.enums.Permissao;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Column(nullable=false)
	private String nome;

	@NotEmpty
	@Column(nullable=false)
	private String login;

	@NotEmpty
	@Column(nullable=false)
	private String senha;

	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private Permissao permissao;

	public Usuario(long id, String nome, String login, String senha, Permissao permissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.permissao = permissao;
	}

	public Usuario(String nome, String login, String senha, Permissao permissao) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.permissao = permissao;
	}

	public Usuario() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}		
}
