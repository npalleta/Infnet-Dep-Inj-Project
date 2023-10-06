package br.com.infnet.project.model.domain.app;

import java.util.List;

public class Classe {

	private String nome;
	private List<Atributo> atributos;

	public Classe(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	@Override
	public String toString() {
		return String.format("%s - %d", this.nome, this.atributos.size());
	}
}