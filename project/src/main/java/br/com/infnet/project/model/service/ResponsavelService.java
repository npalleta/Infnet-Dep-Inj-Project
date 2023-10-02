package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.Responsavel;
import br.com.infnet.project.model.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository responsavelRepository;

	public ResponsavelService() {
	}

	public void incluir(Responsavel responsavel, Aluno aluno) {

		out.printf("%n[Responsável] Inclusão realizada com sucesso: %s%n", responsavel);
		out.printf("%n[Aluno] Dados de Aluno na Sessão: %s%n", aluno);

		responsavelRepository.save(responsavel);
	}

	public void excluir(Integer id) {
		responsavelRepository.deleteById(id);
	}

	public Collection<Responsavel> obterLista() {
		return (Collection<Responsavel>) responsavelRepository.findAll();
	}
}