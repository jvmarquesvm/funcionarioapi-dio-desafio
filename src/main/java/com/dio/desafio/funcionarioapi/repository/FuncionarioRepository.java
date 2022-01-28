package com.dio.desafio.funcionarioapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.entidade.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	@Query(	 nativeQuery = true)
	List<TreinamentoDto> findTreinametnoByFuncionarioId_Named(Long idFuncionario);

}
