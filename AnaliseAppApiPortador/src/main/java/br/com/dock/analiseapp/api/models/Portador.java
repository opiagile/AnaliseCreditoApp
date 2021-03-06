package br.com.dock.analiseapp.api.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Portador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Column(nullable=false)
	private String nome;

	@NotEmpty
	@Column(nullable=false)
	private String cpf;

	@OneToOne(targetEntity = Proposta.class)
	@JoinColumn(name = "proposta_id")
	private Proposta proposta;
	
	public Portador(long id, String nome, String cpf, Proposta proposta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.proposta = proposta;
	}

	public Portador(String nome, String cpf, Proposta proposta) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.proposta = proposta;		
	}	

	public Portador() {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}
}
