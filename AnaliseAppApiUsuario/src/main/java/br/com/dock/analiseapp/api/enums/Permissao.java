package br.com.dock.analiseapp.api.enums;

public enum Permissao {

	ANALISTA(0),
	CAPTADOR(1);

	private int permissao;
	
	Permissao(int i) {
		this.permissao = i;
	}
	
	public int getPermissao() {
		return permissao;
	}	
}
