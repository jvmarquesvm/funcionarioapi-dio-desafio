package com.dio.desafio.funcionarioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.desafio.funcionarioapi.entidade.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
