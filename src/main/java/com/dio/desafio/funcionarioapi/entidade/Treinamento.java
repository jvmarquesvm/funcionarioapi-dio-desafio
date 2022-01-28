package com.dio.desafio.funcionarioapi.entidade;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Treinamento")
@Data
@Table(name = "treinamento")
@AllArgsConstructor
@NoArgsConstructor
public class Treinamento implements Serializable {
	
	private static final long serialVersionUID = -8427213146346497176L;

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
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "funcionario_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Funcionario funcionario;

	public Long getTreinamentoId() {
		return treinamentoId;
	}

	public void setTreinamentoId(Long treinamentoId) {
		this.treinamentoId = treinamentoId;
	}

	public NomeTreinamento getNome() {
		return nome;
	}

	public void setNome(NomeTreinamento nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((treinamentoId == null) ? 0 : treinamentoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treinamento other = (Treinamento) obj;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (treinamentoId == null) {
			if (other.treinamentoId != null)
				return false;
		} else if (!treinamentoId.equals(other.treinamentoId))
			return false;
		return true;
	}

	

}
