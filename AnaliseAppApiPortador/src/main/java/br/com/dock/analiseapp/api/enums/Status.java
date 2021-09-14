package br.com.dock.analiseapp.api.enums;

public enum Status {

	PENDENTE(0),
	APROVADO(1),
	NEGADO(2);

	private int status;

	Status(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}
