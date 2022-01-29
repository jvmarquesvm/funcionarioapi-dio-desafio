package com.dio.desafio.funcionarioapi.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.dio.desafio.funcionarioapi.enums.TipoGenero;

public class FuncionarioDto implements Serializable {
	
	private static final long serialVersionUID = -2883392130272219740L;

	private Long funcionarioId;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String primeiroNome;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String ultimoNome;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private TipoGenero genero;
	
	@NotNull
	private LocalDate dataNascimento;
	
	@NotNull
	private LocalDate dataAdimissao;
	
	public FuncionarioDto() {
		
	}
	
	public FuncionarioDto(String primeiroNome, String ultimoNome, String cpf, TipoGenero genero,
			LocalDate dataNascimento, LocalDate dataAdimissao, Long funcionarioId) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.cpf = cpf;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.dataAdimissao = dataAdimissao;
		this.funcionarioId = funcionarioId;
	}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public TipoGenero getGenero() {
		return genero;
	}
	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public LocalDate getDataAdimissao() {
		return dataAdimissao;
	}
	public void setDataAdimissao(LocalDate dataAdimissao) {
		this.dataAdimissao = dataAdimissao;
	}
	public Long getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	
}
