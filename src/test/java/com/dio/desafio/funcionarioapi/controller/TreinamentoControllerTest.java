package com.dio.desafio.funcionarioapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Treinamento;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.mock.FuncionarioMock;
import com.dio.desafio.funcionarioapi.mock.TreinamentoMock;
import com.dio.desafio.funcionarioapi.repository.FuncionarioRepository;
import com.dio.desafio.funcionarioapi.repository.TreinamentoRepository;
import com.dio.desafio.funcionarioapi.service.TreinamentoService;

@ExtendWith(MockitoExtension.class)
public class TreinamentoControllerTest {
	
	@Mock
	private TreinamentoRepository treinamentoRepository;
	@Mock
	private FuncionarioRepository funcionarioRepository;
	@InjectMocks
	private TreinamentoService treinamentoService;
	
	@Test
	public void buscaTodosTreinamentosTest() {
						
		List<Treinamento> treinamentos = new ArrayList<>();
		treinamentos.add(new TreinamentoMock().criaTreinamentoMock(
				               new FuncionarioMock().criaFuncionarioMock())
				        );
		Mockito.when(treinamentoRepository.findAll()).thenReturn(treinamentos);
		List<TreinamentoDto> todosTreinamentos = treinamentoService.buscaTodosTreinamentos();
		
		Assertions.assertNotNull(todosTreinamentos);
	}
	
	@Test
	public void criarTreinamentoTest() throws FuncionarioNotFoundException {

		Mockito.when(funcionarioRepository.getById(1l)).thenReturn( new FuncionarioMock().criaFuncionarioMock() );
		Mockito.when(treinamentoRepository.save( new TreinamentoMock().criaTreinamentoMock( 
				                                      new FuncionarioMock().criaFuncionarioMock())))
		                                                       .thenReturn( new TreinamentoMock().criaTreinamentoResponseMock( 
		                                                                      new FuncionarioMock().criaFuncionarioMock()));
		
		Treinamento criarTreinamento = treinamentoService.criarTreinamento(new TreinamentoMock().criaTreinamentoDtoMock());
		
		Assertions.assertNotNull(criarTreinamento);
	}

}
