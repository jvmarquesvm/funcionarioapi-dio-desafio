package com.dio.desafio.funcionarioapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.repository.FuncionarioRepository;

@RestController
@RequestMapping("/v1/api/funcionario")
public class FuncionarioController {
	
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioController(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createFuncionario( @RequestBody Funcionario entidade) {
		Funcionario funcionarioCriado = funcionarioRepository.save(entidade);
		return "Funcionario criado com id " + funcionarioCriado.getFuncionarioId();
	}
	
	@GetMapping
	public List<Funcionario> buscaTodosFuncionarios() {
		List<Funcionario> funcionarioCriado = funcionarioRepository.findAll();
		return funcionarioCriado;
	}
	
	@GetMapping("/{id}")
	public Funcionario createFuncionario( @PathVariable Long id) throws FuncionarioNotFoundException {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
		
		if (optionalFuncionario.isEmpty()) {
			throw new FuncionarioNotFoundException(id);
		}
		
		return optionalFuncionario.get();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarFuncionarioPorId(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public String atualizarFuncionario(@PathVariable Long id, 
			                             @RequestBody Funcionario funcionario) 
			                                           throws FuncionarioNotFoundException {
		Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
		
		if (optionalFuncionario.isEmpty()) {
			throw new FuncionarioNotFoundException(id);
		}
		
		funcionarioRepository.save(funcionario);
		return "Funcionario atualizado com id " + id;
	}
}
