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
@Table(name = "TFichaDados")
public class FichaDados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFicha;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idAluno")
	private Aluno aluno;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idResponsavel")
	private Responsavel responsavel;
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idProfessor")
	private Professor professor;

	public FichaDados() {
	}

	public FichaDados(
		Aluno aluno,
		Responsavel responsavel,
		Professor professor
	) {
		this.aluno = aluno;
		this.responsavel = responsavel;
		this.professor = professor;
	}
	
	public Integer getIdFicha() {
		return idFicha;
	}

	public void setIdFicha(Integer idFicha) {
		this.idFicha = idFicha;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return String.format(
			"{ %d;%s;%s;%s;%s;%s;%s;%s }",
			this.idFicha,
			this.aluno.getNomeAluno(),
			this.aluno.getMatricula(),
			this.aluno.getAtivo(),
			this.responsavel.getNomeResponsavel(),
			this.professor.getNomeProfessor(),
			this.professor.getMateria(),
			this.professor.getNumSala()
		);
	}
}