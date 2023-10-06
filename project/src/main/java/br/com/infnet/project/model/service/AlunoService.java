package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.infnet.project.enums.EnumSalaAula;
import br.com.infnet.project.exception.EnumSalaAulaException;
import br.com.infnet.project.model.domain.Aluno;

@Service
public class AlunoService {

	private Map<Integer, Aluno> mapaAluno = new HashMap<>();
	private Integer id;

	public AlunoService() {
		this.id = 0;
		this.mapaAluno = new HashMap<>();
	}

	public void incluir(Aluno aluno) throws EnumSalaAulaException {
		id++;
		aluno.setIdAluno(this.id);

		boolean enumSalaEncontrada = false;

		for (EnumSalaAula enumSalaAula : EnumSalaAula.values()) {
			if (enumSalaAula.numeroSala == aluno.getNumSala()) {
				enumSalaEncontrada = true;
				break;
			}
		}

		if (!enumSalaEncontrada) {
			throw new EnumSalaAulaException();
		}

		this.mapaAluno.put(aluno.getIdAluno(), aluno);
		out.printf("%n[Aluno] Inclusão realizada com sucesso: %s%n", aluno);
	}

	public void excluir(Integer id) {
		this.mapaAluno.remove(id);
	}

	public Collection<Aluno> obterLista() {
		return this.mapaAluno.values();
	}
}