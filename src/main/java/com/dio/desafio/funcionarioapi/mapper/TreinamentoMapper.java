package com.dio.desafio.funcionarioapi.mapper;

import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.entidade.Treinamento;
import com.dio.desafio.funcionarioapi.enums.NomeTreinamento;

import java.math.BigInteger;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;

public class TreinamentoMapper {
	
	public static TreinamentoDto treinamento2TreinamentoDto( Treinamento treinamento ) {
		TreinamentoDto treinamentoDto = new TreinamentoDto();
		
		treinamentoDto.setDataFim( Date.from(treinamento.getDataFim().atStartOfDay(ZoneId.systemDefault()).toInstant())  );
		treinamentoDto.setDataInicio( Date.from( treinamento.getDataInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()) );
		treinamentoDto.setFuncionarioId(BigInteger.valueOf( treinamento.getFuncionario().getFuncionarioId() ));
		treinamentoDto.setNome(treinamento.getNome().toString());
		treinamentoDto.setTreinamentoId(BigInteger.valueOf( treinamento.getTreinamentoId() ));
		
		return treinamentoDto;
	}

	public static List<TreinamentoDto> treinamentosToListTreinamentosDto(List<Treinamento> treinamentos) {
		List<TreinamentoDto> listTreinamentoDto = new ArrayList<>();
		
		for( Treinamento treinamento :  treinamentos) {
			TreinamentoDto treinamentoDto = new TreinamentoDto();
			treinamentoDto.setDataFim( Date.from(treinamento.getDataFim().atStartOfDay(ZoneId.systemDefault()).toInstant())  );
			treinamentoDto.setDataInicio( Date.from( treinamento.getDataInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()) );
			treinamentoDto.setFuncionarioId(BigInteger.valueOf( treinamento.getFuncionario().getFuncionarioId() ));
			treinamentoDto.setNome(treinamento.getNome().toString());
			treinamentoDto.setTreinamentoId(BigInteger.valueOf( treinamento.getTreinamentoId() ));
			
			listTreinamentoDto.add(treinamentoDto);
		}
		return listTreinamentoDto;
	}

	public static Treinamento treinamentoDto2treinamento(TreinamentoDto treinamentoDto, Funcionario funcionario) {
		Treinamento treinamento = new Treinamento();
		
		treinamento.setDataFim(  treinamentoDto.getDataFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() );
		treinamento.setDataInicio( treinamentoDto.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() );
		treinamento.setFuncionario(funcionario);
		treinamento.setNome( NomeTreinamento.valueOf( treinamentoDto.getNome()) );
		//treinamento.setTreinamentoId(treinamentoDto.getTreinamentoId().longValue());
		
		return treinamento;
	}

}
