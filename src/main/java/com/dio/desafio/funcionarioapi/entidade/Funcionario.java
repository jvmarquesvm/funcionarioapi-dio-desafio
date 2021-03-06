package com.dio.desafio.funcionarioapi.entidade;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;

import com.dio.desafio.funcionarioapi.dto.TreinamentoDto;
import com.dio.desafio.funcionarioapi.enums.TipoGenero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Funcionario")
@Table (name = "funcionario")
@AllArgsConstructor
@NoArgsConstructor

@NamedNativeQuery(name  = "Funcionario.findTreinametnoByFuncionarioId_Named",
                  query = "select t.treinamento_id as treinamentoId, t.data_inicio as dataInicio, "
						+ "t.data_fim as dataFim, f.funcionario_id as funcionarioId, "
						+ "t.nome "
						+ "from Funcionario f join Treinamento t on f.funcionario_id = t.funcionario_id "
						+ "where f.funcionario_id = :idFuncionario",
                  resultSetMapping = "Mapping.TreinamentoDto"
                  )

@SqlResultSetMapping(name    = "Mapping.TreinamentoDto",
                     classes = @ConstructorResult(targetClass = TreinamentoDto.class,
                     columns = { @ColumnResult(name = "treinamentoId"),
                                 @ColumnResult(name = "dataInicio"),
                                 @ColumnResult(name = "dataFim"),
                                 @ColumnResult(name = "funcionarioId"),
                                 @ColumnResult(name = "nome") 
                     }))
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = -9138336069164136867L;

	/**
	 * Criando uma Primary Key com stratégia de geração incremental e automatica
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Long funcionarioId;
	
	@Column(name = "primeiro_nome", nullable = false)
	private String primeiroNome;
	
	@Column(name = "ultimo_nome", nullable = false)
	private String ultimoNome;
	
	//@Column(nullable = false, unique = true)
	@Column(nullable = false, unique = false)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private TipoGenero genero;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "data_adimissao")
	private LocalDate dataAdimissao;

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataAdimissao() {
		return dataAdimissao;
	}

	public void setDataAdimissao(LocalDate dataAdimissao) {
		this.dataAdimissao = dataAdimissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((funcionarioId == null) ? 0 : funcionarioId.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (funcionarioId == null) {
			if (other.funcionarioId != null)
				return false;
		} else if (!funcionarioId.equals(other.funcionarioId))
			return false;
		return true;
	}
	
	
	

}
