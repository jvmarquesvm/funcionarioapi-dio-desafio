package com.dio.desafio.funcionarioapi.enums;

public enum TipoGenero {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private TipoGenero(String descricao) {
		this.descricao = descricao;
	} 
	
	private final String descricao;

	public String getDescricao() {
		return descricao;
	}

}
