package com.dio.desafio.funcionarioapi.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.entidade.Treinamento;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.mapper.TreinamentoMapper;
import com.dio.desafio.funcionarioapi.repository.FuncionarioRepository;
import com.dio.desafio.funcionarioapi.repository.TreinamentoRepository;

@Service
public class TreinamentoService {
	
	private TreinamentoRepository treinamentoRepository;
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	public TreinamentoService(TreinamentoRepository treinamentoRepository,
			FuncionarioRepository funcionarioRepository) {
		this.treinamentoRepository = treinamentoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	public List<TreinamentoDto> buscaTodosTreinamentos() {
		List<Treinamento> treinamentos = treinamentoRepository.findAll();
		return TreinamentoMapper.treinamentosToListTreinamentosDto(treinamentos);
	}
	
	public Treinamento criarTreinamento(@RequestBody TreinamentoDto treinamentoDto) throws FuncionarioNotFoundException {
		
		Funcionario funcionario = funcionarioRepository.getById(treinamentoDto.getFuncionarioId().longValue());
		treinamentoDto.setFuncionarioId( BigInteger.valueOf(  funcionario.getFuncionarioId() ));	
		
		return treinamentoRepository.save(TreinamentoMapper.treinamentoDto2treinamento(treinamentoDto, funcionario));
	}
	
	public void apagarTreinamento(@PathVariable Long id) {
		treinamentoRepository.deleteById(id);
	}

}
