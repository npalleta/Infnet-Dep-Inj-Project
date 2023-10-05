package br.com.infnet.project.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAluno")
public class Aluno extends SalaAula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAluno;
	private String nomeAluno;
	private String matricula;
	private Boolean ativo;
	private Integer numSala;
	
	public Aluno() {
		super();
	}

	public Aluno(Integer idAluno, String nomeAluno, String matricula, Boolean ativo, Integer numSala) {
		super(numSala);
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.matricula = matricula;
		this.ativo = ativo;
		this.numSala = numSala;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getNumSala() {
		return numSala;
	}

	public void setNumSala(Integer numSala) {
		this.numSala = numSala;
	}

	@Override
	public String toString() {
		return String.format(
			"{ %d;%s;%s;%s;%s;%d }",
			this.idAluno,
			this.nomeAluno,
			this.matricula,
			this.ativo,
			this.numSala,
			super.getNumSala()
		);
	}
}