package br.com.dock.analiseapp.api.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import br.com.dock.analiseapp.api.enums.Status;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Min(0)
	@Column(nullable=false)
	private BigDecimal credito;

	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	public Proposta(long id, BigDecimal credito, Status status) {
		this.id = id;
		this.credito = credito;
		this.status = status;
	}

	public Proposta(BigDecimal credito, Status status) {
		super();
		this.credito = credito;
		this.status = status;
	}
	
	public Proposta() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCredito() {
		return credito;
	}

	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
