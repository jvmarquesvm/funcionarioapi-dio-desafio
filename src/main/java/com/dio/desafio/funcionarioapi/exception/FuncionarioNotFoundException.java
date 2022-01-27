package com.dio.desafio.funcionarioapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1372906448621127070L;

	public FuncionarioNotFoundException(Long id) {
		super("Funcionario nao encontrato, id " + id );
	}

}
