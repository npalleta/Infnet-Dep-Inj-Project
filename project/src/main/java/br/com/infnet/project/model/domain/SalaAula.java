package br.com.infnet.project.model.domain;

public abstract class SalaAula {

	private Integer numSala;
	private Integer idProfessor;
	private Integer idAluno;
	
	public SalaAula() {
	}

	public SalaAula(Integer numSala) {
		this.numSala = numSala;
	}

	public SalaAula(Integer numSala, Integer idProfessor) {
		this.numSala = numSala;
		this.idAluno = idProfessor;
	}

	public SalaAula(Integer numSala, Integer idProfessor, Integer idAluno) {
		this.numSala = numSala;
		this.idProfessor = idProfessor;
		this.idAluno = idAluno;
	}
	
	public Integer getNumSala() {
		return numSala;
	}

	public void setNumSala(Integer numSala) {
		this.numSala = numSala;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}
	
	@Override
	public String toString() {
		this.numSala = (this.numSala == null) ? 0 : this.numSala;
		this.idProfessor = (this.idProfessor == null) ? 0 : this.idProfessor;
		this.idAluno = (this.idAluno == null) ? 0 : this.idAluno;

		return String.format(
			"{ %d;%d;%d }",
			this.numSala,
			this.idProfessor,
			this.idAluno
		);
	}
}