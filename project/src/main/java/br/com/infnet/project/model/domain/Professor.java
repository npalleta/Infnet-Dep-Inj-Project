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
@Table(name = "TProfessor")
public class Professor extends SalaAula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfessor;
	private String nomeProfessor;
	private String materia;
	private String diaAula;
	private Integer numSala;
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idAluno")
	private Aluno aluno;

	public Professor() {
		super();
	}

	public Professor(
		Integer numSala,
		// Integer idAluno,
		Integer idProfessor,
		String nomeProfessor,
		String materia,
		String diaAula,
		Aluno aluno
	) {
		super(numSala, aluno.getIdAluno());
		this.idProfessor = idProfessor;
		this.nomeProfessor = nomeProfessor;
		this.materia = materia;
		this.diaAula = diaAula;
		this.numSala = numSala;
		this.aluno = aluno;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
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

	public Integer getNumSala() {
		return numSala;
	}

	public void setNumSala(Integer numSala) {
		this.numSala = numSala;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return String.format(
			"{ %d;%s;%s;%s;%s }",
			this.idProfessor,
			this.nomeProfessor,
			this.materia,
			this.diaAula,
			super.toString()
		);
	}
}