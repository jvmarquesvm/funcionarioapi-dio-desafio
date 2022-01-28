package com.dio.desafio.funcionarioapi.enums;

public enum NomeTreinamento {
	
	MATEMATICA_FINANCEIRA("Matematica Financeira"),
	EDUCACAO_EMOCIONAL("Educacao Emocional"),
	MICROSOFT_VISIO("Microsoft Visio"),
	MICROSOT_EXCEL("Microsoft Excel");
	
	private final String nome;

	public String getNome() {
		return nome;
	}

	private NomeTreinamento(String nome) {
		this.nome = nome;
	}
	
	
}
