package com.dio.desafio.funcionarioapi.mock;

import java.time.LocalDate;
import java.util.Optional;

import com.dio.desafio.funcionarioapi.dto.FuncionarioDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.enums.TipoGenero;

public class FuncionarioMock {
	
	public Funcionario criaFuncionarioMock() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("72396377191");
		funcionario.setDataAdimissao(LocalDate.now());
		funcionario.setDataNascimento(LocalDate.now().minusYears(15));
		funcionario.setFuncionarioId(1l);
		funcionario.setGenero(TipoGenero.MASCULINO);
		funcionario.setPrimeiroNome("João");
		funcionario.setUltimoNome("Victor");
		
		return funcionario;
	}
	
	public FuncionarioDto criaFuncionarioDtoMock() {
		
		FuncionarioDto funcionarioDto = new FuncionarioDto();
		funcionarioDto.setCpf("72396377191");
		funcionarioDto.setDataAdimissao(LocalDate.now());
		funcionarioDto.setDataNascimento(LocalDate.now().minusYears(15));
		funcionarioDto.setFuncionarioId(1l);
		funcionarioDto.setGenero(TipoGenero.MASCULINO);
		funcionarioDto.setPrimeiroNome("João");
		funcionarioDto.setUltimoNome("Victor");
		
		return funcionarioDto;
	}
	

}
