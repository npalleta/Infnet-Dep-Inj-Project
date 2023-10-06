package br.com.infnet.project.model.domain.app;

import java.util.List;

public class Projeto {

	private String nome;
	private String descricao;
	private List<Classe> classes;

	public Projeto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %d", this.nome, this.descricao, this.classes.size());
	}
}