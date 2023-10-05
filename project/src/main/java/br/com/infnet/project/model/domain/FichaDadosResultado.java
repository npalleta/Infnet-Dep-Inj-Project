package br.com.infnet.project.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TFichaDadosResultado")
public class FichaDadosResultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFicha;
	private String nomeAluno;
	private String matricula;
	private Boolean ativo;
	private String nomeResponsavel;
	private String parentesco;
	private String nomeProfessor;
	private String materia;
	private String diaAula;
	private String numSala;
	
	public FichaDadosResultado() {
	}

	public FichaDadosResultado(
		Integer idFicha,
		String nomeAluno,
		String matricula,
		Boolean ativo,
		String nomeResponsavel,
		String parentesco,
		String nomeProfessor,
		String materia,
		String diaAula,
		String numSala
	) {
		this.idFicha = idFicha;
		this.nomeAluno = nomeAluno;
		this.matricula = matricula;
		this.ativo = ativo;
		this.nomeResponsavel = nomeResponsavel;
		this.parentesco = parentesco;
		this.nomeProfessor = nomeProfessor;
		this.materia = materia;
		this.diaAula = diaAula;
		this.numSala = numSala;
	}

	public Integer getIdFicha() {
		return idFicha;
	}

	public void setIdFicha(Integer idFicha) {
		this.idFicha = idFicha;
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

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDiaAula() {
		return diaAula;
	}

	public void setDiaAula(String diaAula) {
		this.diaAula = diaAula;
	}

	public String getNumSala() {
		return numSala;
	}

	public void setNumSala(String numSala) {
		this.numSala = numSala;
	}
	
	@Override
	public String toString() {
		return String.format(
			"{ %d;%s;%s;%s;%s;%s;%s;%s;%s;%s }",
			this.idFicha,
			this.nomeAluno,
			this.matricula,
			this.ativo,
			this.nomeResponsavel,
			this.parentesco,
			this.nomeProfessor,
			this.materia,
			this.diaAula,
			this.numSala
		);
	}
}