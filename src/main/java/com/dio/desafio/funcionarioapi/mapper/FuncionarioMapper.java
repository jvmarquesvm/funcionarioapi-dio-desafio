package com.dio.desafio.funcionarioapi.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dio.desafio.funcionarioapi.dto.FuncionarioDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;

public class FuncionarioMapper {
	
	public static Funcionario funcionarioDto2funcionario( FuncionarioDto funcionarioDto ) {
		Funcionario funcionarioEntity = new Funcionario();
		
		funcionarioEntity.setCpf(funcionarioDto.getCpf());
		funcionarioEntity.setDataAdimissao(funcionarioDto.getDataAdimissao());
		funcionarioEntity.setDataNascimento(funcionarioDto.getDataNascimento());
		funcionarioEntity.setFuncionarioId(funcionarioDto.getFuncionarioId());
		funcionarioEntity.setGenero(funcionarioDto.getGenero());
		funcionarioEntity.setPrimeiroNome(funcionarioDto.getPrimeiroNome());
		funcionarioEntity.setUltimoNome(funcionarioDto.getUltimoNome());
		
		return funcionarioEntity;
	}
	
	public static FuncionarioDto funcionario2funcionarioDto( Funcionario funcionario ) {
		FuncionarioDto funcionarioDto = new FuncionarioDto();
		
		funcionarioDto.setCpf(funcionario.getCpf());
		funcionarioDto.setDataAdimissao(funcionario.getDataAdimissao());
		funcionarioDto.setDataNascimento(funcionario.getDataNascimento());
		funcionarioDto.setFuncionarioId(funcionario.getFuncionarioId());
		funcionarioDto.setGenero(funcionario.getGenero());
		funcionarioDto.setPrimeiroNome(funcionario.getPrimeiroNome());
		funcionarioDto.setUltimoNome(funcionario.getUltimoNome());
		
		return funcionarioDto;
	}
	
	public static List<FuncionarioDto> funcionarios2listFuncionarioDto( List<Funcionario> funcionarios ) {
		List<FuncionarioDto> funcionariosDto = new ArrayList<>();
		
		for (Funcionario funcionario : funcionarios ) {
			FuncionarioDto funcionarioDto = new FuncionarioDto();
			
			funcionarioDto.setCpf(funcionario.getCpf());
			funcionarioDto.setDataAdimissao(funcionario.getDataAdimissao());
			funcionarioDto.setDataNascimento(funcionario.getDataNascimento());
			funcionarioDto.setFuncionarioId(funcionario.getFuncionarioId());
			funcionarioDto.setGenero(funcionario.getGenero());
			funcionarioDto.setPrimeiroNome(funcionario.getPrimeiroNome());
			funcionarioDto.setUltimoNome(funcionario.getUltimoNome());
			
			funcionariosDto.add(funcionarioDto);
		}

		return funcionariosDto;
	}

}
