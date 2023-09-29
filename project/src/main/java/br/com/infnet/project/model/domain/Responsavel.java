package br.com.infnet.project.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TResponsavel")
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idResponsavel;
	
	private String nomeResponsavel;
	
	private Character parentesco;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAluno", referencedColumnName = "idAluno")
	private Aluno aluno;
	
	public Responsavel() {
	}

	public Responsavel(Integer idResponsavel, String nomeResponsavel, Aluno aluno, Character parentesco) {
		this.idResponsavel = idResponsavel;
		this.nomeResponsavel = nomeResponsavel;
		this.aluno = aluno;
		this.parentesco = parentesco;
	}

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	
	public Character getParentesco() {
		return parentesco;
	}

	public void setParentesco(Character parentesco) {
		this.parentesco = parentesco;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return String.format(
			"{ %d;%s;%s;%s }",
			this.idResponsavel,
			this.nomeResponsavel,
			this.aluno,
			this.parentesco
		);
	}
}