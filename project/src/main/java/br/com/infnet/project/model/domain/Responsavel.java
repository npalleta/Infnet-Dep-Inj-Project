package br.com.infnet.project.model.domain;

public class Responsavel {

	private Integer idResponsavel;
	
	private String nomeResponsavel;
	
	private Character parentesco;
	
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