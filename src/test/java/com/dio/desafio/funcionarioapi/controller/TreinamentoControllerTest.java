package com.dio.desafio.funcionarioapi.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.entidade.Treinamento;
import com.dio.desafio.funcionarioapi.enums.NomeTreinamento;
import com.dio.desafio.funcionarioapi.enums.TipoGenero;
import com.dio.desafio.funcionarioapi.repository.TreinamentoRepository;
import com.dio.desafio.funcionarioapi.service.TreinamentoService;

@ExtendWith(MockitoExtension.class)
public class TreinamentoControllerTest {
	@Mock
	private TreinamentoRepository treinamentoRepository;
	@InjectMocks
	private TreinamentoService treinamentoService;
	
	@Test
	public void buscaTodosTreinamentosTest() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("72396377191");
		funcionario.setDataAdimissao(LocalDate.now());
		funcionario.setDataNascimento(LocalDate.now().minusYears(15));
		funcionario.setFuncionarioId(1l);
		funcionario.setGenero(TipoGenero.MASCULINO);
		funcionario.setPrimeiroNome("João");
		funcionario.setUltimoNome("Victor");
		
		Treinamento treinamento = new Treinamento();
		treinamento.setDataFim(LocalDate.now());
		treinamento.setDataInicio(LocalDate.now().minusDays(1l));
		treinamento.setFuncionario(funcionario);
		treinamento.setNome(NomeTreinamento.EDUCACAO_EMOCIONAL);
		treinamento.setTreinamentoId(1l);
		
		List<Treinamento> treinamentos = new ArrayList<>();
		treinamentos.add(treinamento);
		
		Mockito.when(treinamentoRepository.findAll()).thenReturn(treinamentos);
		List<TreinamentoDto> todosTreinamentos = treinamentoService.buscaTodosTreinamentos();
		
		Assertions.assertNotNull(todosTreinamentos);
		
	}

}
