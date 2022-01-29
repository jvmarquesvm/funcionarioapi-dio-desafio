package com.dio.desafio.funcionarioapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.desafio.funcionarioapi.dto.FuncionarioDto;
import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.mock.FuncionarioMock;
import com.dio.desafio.funcionarioapi.mock.TreinamentoMock;
import com.dio.desafio.funcionarioapi.repository.FuncionarioRepository;
import com.dio.desafio.funcionarioapi.service.FuncionarioService;

@ExtendWith(MockitoExtension.class)
public class FuncionarioControllerTest {
	@Mock
	private FuncionarioRepository funcionarioRepository;
	@InjectMocks
	private FuncionarioService funcionarioService;
	
	@Test
	public void buscaTodosFuncionariosTest() {
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario funcionario = new FuncionarioMock().criaFuncionarioMock();
		funcionarios.add(funcionario);
		
		Mockito.when(funcionarioRepository.findAll()).thenReturn(funcionarios);
		List<FuncionarioDto> listFuncionarios = funcionarioService.buscaTodosFuncionarios();
		
		Assertions.assertNotNull(listFuncionarios);
	}
	
	@Test
	public void buscaTreinamentoPorFuncionarioIdTest() {
		List<TreinamentoDto> treinamentos = new ArrayList<>();
		treinamentos.add(new TreinamentoMock().criaTreinamentoDtoMock());

		Mockito.when(funcionarioRepository.findTreinametnoByFuncionarioId_Named(1l)).thenReturn(treinamentos);
		List<TreinamentoDto> listTreinamentoPorFuncionarioId = funcionarioService.buscaTreinamentoPorFuncionarioId(1l);
		
		Assertions.assertNotNull(listTreinamentoPorFuncionarioId);
	}
	
	@Test 
	public void buscaFuncionarioPorIdTest() throws FuncionarioNotFoundException {
		
		Mockito.when(funcionarioRepository.findById( 1l ))
		                                        .thenReturn(Optional.of(new FuncionarioMock().criaFuncionarioMock()));
		FuncionarioDto funcionarioPorId = funcionarioService.buscaFuncionarioPorId( 1l );
		
		Assertions.assertNotNull(funcionarioPorId);
	}
	
}
