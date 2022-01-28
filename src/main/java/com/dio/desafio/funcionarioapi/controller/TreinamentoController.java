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

import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.entidade.Treinamento;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.repository.FuncionarioRepository;
import com.dio.desafio.funcionarioapi.repository.TreinamentoRepository;

@RestController
@RequestMapping("/v1/api/treinamento")
public class TreinamentoController {
	
	private TreinamentoRepository treinamentoRepository;
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public TreinamentoController(TreinamentoRepository treinamentoRepository,
			FuncionarioRepository funcionarioRepository) {
		this.treinamentoRepository = treinamentoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	@GetMapping
	public List<Treinamento> buscaTodosTreinamentos() {
		List<Treinamento> treinamentos = treinamentoRepository.findAll();
		return treinamentos;
	}
	
	@PostMapping
	public Treinamento criarTreinamento(@RequestBody Treinamento treinamento) throws FuncionarioNotFoundException {
		
		Funcionario Funcionario = funcionarioRepository.getById(treinamento.getFuncionario().getFuncionarioId());
		treinamento.setFuncionario(Funcionario);
		
		Treinamento treinamentoCriado = treinamentoRepository.save(treinamento);
		return treinamentoCriado;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarTreinamento(@PathVariable Long id) {
		treinamentoRepository.deleteById(id);
	}
	
	
}
