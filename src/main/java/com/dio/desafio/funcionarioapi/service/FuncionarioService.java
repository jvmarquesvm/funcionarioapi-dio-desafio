package com.dio.desafio.funcionarioapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.desafio.funcionarioapi.dto.FuncionarioDto;
import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.mapper.FuncionarioMapper;
import com.dio.desafio.funcionarioapi.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario createFuncionario( FuncionarioDto funcionarioDto) {
		Funcionario funcionarioCriado = funcionarioRepository.save(
				                              FuncionarioMapper.funcionarioDto2funcionario(funcionarioDto));
		return funcionarioCriado;
	}
	
	public List<FuncionarioDto> buscaTodosFuncionarios() {
		List<Funcionario> listFuncionarioCriado = funcionarioRepository.findAll();
		return FuncionarioMapper.funcionarios2listFuncionarioDto(listFuncionarioCriado);
	}
	
	public FuncionarioDto createFuncionario( Long id) throws FuncionarioNotFoundException {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
		
		if (optionalFuncionario.isEmpty()) {
			throw new FuncionarioNotFoundException(id);
		}
		
		return FuncionarioMapper.funcionario2funcionarioDto(optionalFuncionario.get());
	}
	
	public void apagarFuncionarioPorId( Long id ) {
		funcionarioRepository.deleteById(id);
	}
	
	public String atualizarFuncionario( Long id,  FuncionarioDto funcionarioDto) 
                                                                  throws FuncionarioNotFoundException {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
		
		if (optionalFuncionario.isEmpty()) {
			throw new FuncionarioNotFoundException(id);
		}
		
		funcionarioRepository.save(FuncionarioMapper.funcionarioDto2funcionario(funcionarioDto));
		return "Funcionario atualizado com id " + id;
	}

	public List<TreinamentoDto> buscaTreinamentoPorFuncionarioId( Long id) {
		List<TreinamentoDto> treinamentos = funcionarioRepository.findTreinametnoByFuncionarioId_Named(id);
		return treinamentos;
	}
	
}
