package com.dio.desafio.funcionarioapi.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.dio.desafio.funcionarioapi.dto.FuncionarioDto;
import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;
import com.dio.desafio.funcionarioapi.exception.FuncionarioNotFoundException;
import com.dio.desafio.funcionarioapi.service.FuncionarioService;

@RestController
@RequestMapping("/v1/api/funcionario")
public class FuncionarioController {
	
	private FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createFuncionario( @RequestBody @Valid FuncionarioDto funcionarioDto) {
		Funcionario funcionarioCriado = funcionarioService.createFuncionario( funcionarioDto );
		return "Funcionario criado com id " + funcionarioCriado.getFuncionarioId();
	}
	
	@GetMapping
	public List<FuncionarioDto> buscaTodosFuncionarios() {
		List<FuncionarioDto> funcionarioCriado = funcionarioService.buscaTodosFuncionarios();
		return funcionarioCriado;
	}
	
	@GetMapping("/{id}")
	public FuncionarioDto buscaFuncionarioPorId( @PathVariable Long id)   throws FuncionarioNotFoundException {
		FuncionarioDto funcionarioDto = funcionarioService.buscaFuncionarioPorId( id );
		return funcionarioDto;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarFuncionarioPorId(@PathVariable Long id) {
		funcionarioService.apagarFuncionarioPorId( id );
	}
	
	@PutMapping("/{id}")
	public String atualizarFuncionario(@PathVariable Long id, @RequestBody FuncionarioDto funcionarioDto) 
			                                                        throws FuncionarioNotFoundException {
		return funcionarioService.atualizarFuncionario(id, funcionarioDto);
	}
	
	@GetMapping("/{id}/treinamento")
	public List<TreinamentoDto> buscaTreinamentoPorFuncionarioId(@PathVariable Long id) {
		return  funcionarioService.buscaTreinamentoPorFuncionarioId(id);
	}
}
