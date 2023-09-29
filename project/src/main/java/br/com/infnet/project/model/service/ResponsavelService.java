package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;
// import java.util.HashMap;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.Responsavel;
import br.com.infnet.project.model.repository.ResponsavelRepository;

@Service
public class ResponsavelService {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;

	// private Map<Integer, Responsavel> mapaResponsavel = new HashMap<>();
	// private Integer id;

	public ResponsavelService() {
		// this.id = 0;
		// this.mapaResponsavel = new HashMap<>();
	}

	public void incluir(Responsavel responsavel, Aluno aluno) {
		// this.id++;
		// responsavel.setAluno(aluno);
		// responsavel.setIdResponsavel(this.id);
		// mapaResponsavel.put(responsavel.getIdResponsavel(), responsavel);

		out.printf("%n[Responsável] Inclusão realizada com sucesso: %s%n", responsavel);
		out.printf("%n[Aluno] Dados de Aluno na Sessão: %s%n", aluno);
		
		responsavelRepository.save(responsavel);
	}

	public void excluir(Integer id) {
		responsavelRepository.deleteById(id);
		// mapaResponsavel.remove(id);
	}

	public Collection<Responsavel> obterLista() {
		// return mapaResponsavel.values();
		return (Collection<Responsavel>) responsavelRepository.findAll();
	}
}