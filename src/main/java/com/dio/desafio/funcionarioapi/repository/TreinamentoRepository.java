package com.dio.desafio.funcionarioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.desafio.funcionarioapi.entidade.Treinamento;

public interface TreinamentoRepository extends JpaRepository<Treinamento, Long> {

}
