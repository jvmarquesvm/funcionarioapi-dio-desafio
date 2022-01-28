package com.dio.desafio.funcionarioapi.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class TreinamentoDto implements Serializable {
	
	private static final long serialVersionUID = 8523161372715600295L;

	private BigInteger treinamentoId;
	private Date dataInicio;
	private Date dataFim;
	private BigInteger funcionarioId;
	private String nome;
	
	public TreinamentoDto(BigInteger treinamentoId, Date dataInicio, Date dataFim,
			BigInteger funcionarioId, String nome) {
		this.treinamentoId = treinamentoId;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.funcionarioId = funcionarioId;
		this.nome = nome;
	}
	
	public TreinamentoDto() {

	}
	public BigInteger getTreinamentoId() {
		return treinamentoId;
	}
	public void setTreinamentoId(BigInteger treinamentoId) {
		this.treinamentoId = treinamentoId;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public BigInteger getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(BigInteger funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
