package com.dio.desafio.funcionarioapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/funcionarios")
public class FuncionarioController {
	
	@GetMapping
	public String getFuncionario() {
		return "Funcionário Controller return";
	}
}
