package com.dio.desafio.funcionarioapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Treinamento;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.service.TreinamentoService;

@RestController
@RequestMapping("/v1/api/treinamento")
public class TreinamentoController {
	
	private TreinamentoService treinamentoService;
	
	@Autowired
	public TreinamentoController(TreinamentoService treinamentoService) {
		this.treinamentoService = treinamentoService;
	}

	@GetMapping
	public List<TreinamentoDto> buscaTodosTreinamentos() {
		return treinamentoService.buscaTodosTreinamentos();
	}
	
	@PostMapping
	public String criarTreinamento(@RequestBody TreinamentoDto treinamentoDto) 
			                                                             throws FuncionarioNotFoundException {
		Treinamento treinamento = treinamentoService.criarTreinamento(treinamentoDto);
		return "Treinamento criado paro o Funcionario id " + treinamento.getFuncionario().getFuncionarioId();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarTreinamento(@PathVariable Long id) {
		treinamentoService.apagarTreinamento(id);
	}
	
}
