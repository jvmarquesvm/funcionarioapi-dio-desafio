package com.dio.desafio.funcionarioapi.entidade;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dio.desafio.funcionarioapi.enums.NomeTreinamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Treinamento")
@Data
@Table(name = "treinamento")
@AllArgsConstructor
@NoArgsConstructor
public class Treinamento {
	
	/**
	 * Criando uma Primary Key com stratégia de geração incremental e automatica
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "treinamento_id" )
	private Long treinamentoId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false )
	private NomeTreinamento nome;
	
	@Column(name = "data_inicio", nullable = false )
	private LocalDate dataInicio;
	
	@Column(name = "data_fim", nullable = false)
	private LocalDate dataFim;
	
	/**
	 * Criando um foreing key com campo funcionario_id da tabela funcionario
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

}
