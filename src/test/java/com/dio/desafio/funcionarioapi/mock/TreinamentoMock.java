package com.dio.desafio.funcionarioapi.mock;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.entidade.Treinamento;
import com.dio.desafio.funcionarioapi.enums.NomeTreinamento;

public class TreinamentoMock {

	public Treinamento criaTreinamentoMock(Funcionario funcionario) {
		
		Treinamento treinamento = new Treinamento();
		treinamento.setDataFim(LocalDate.now());
		treinamento.setDataInicio(LocalDate.now().minusDays(1l));
		treinamento.setFuncionario( funcionario );
		treinamento.setNome(NomeTreinamento.EDUCACAO_EMOCIONAL);
		//treinamento.setTreinamentoId(1l);
		
		return treinamento;
	}
	
	public Treinamento criaTreinamentoResponseMock(Funcionario funcionario) {
		
		Treinamento treinamento = new Treinamento();
		treinamento.setDataFim(LocalDate.now());
		treinamento.setDataInicio(LocalDate.now().minusDays(1l));
		treinamento.setFuncionario( funcionario );
		treinamento.setNome(NomeTreinamento.EDUCACAO_EMOCIONAL);
		treinamento.setTreinamentoId(2l);
		
		return treinamento;
	}
	
	public TreinamentoDto criaTreinamentoDtoMock() {
		
		TreinamentoDto treinamentoDto = new TreinamentoDto();
		treinamentoDto.setDataFim(new Date());
		treinamentoDto.setDataInicio(new Date());
		treinamentoDto.setFuncionarioId(BigInteger.ONE);
		treinamentoDto.setNome("EDUCACAO_EMOCIONAL");
		//treinamentoDto.setTreinamentoId(BigInteger.ONE);
		
		return treinamentoDto;
	}

}
