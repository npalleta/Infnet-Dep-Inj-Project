package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.FichaDados;
import br.com.infnet.project.model.domain.FichaDadosResultado;
import br.com.infnet.project.model.domain.Professor;
import br.com.infnet.project.model.domain.Responsavel;
import br.com.infnet.project.model.repository.FichaDadosRepository;
import br.com.infnet.project.model.repository.FichaDadosResultadoRepository;

@Service
public class FichaDadosService {

	@Autowired
	private FichaDadosRepository fichaDadosRepository;

	@Autowired
	private FichaDadosResultadoRepository fichaDadosResultadoRepository;

	private FichaDados fichaDados;
	
	private FichaDadosResultado fichaDadosResultado;

	public FichaDadosService() {
	}

	public void incluir(Aluno aluno, Responsavel responsavel, Professor professor) {
		List<Object[]> idList = this.fichaDadosRepository.findAllIds();

		for (Object[] id : idList) {
			aluno.setIdAluno((Integer) id[0]);
			responsavel.setIdResponsavel((Integer) id[1]);
			professor.setIdProfessor((Integer) id[2]);
		}
		
		this.fichaDados = new FichaDados(aluno, responsavel, professor);
		out.printf("%n[Ficha de Dados] Inclusão realizada com sucesso: %s%n", this.fichaDados);
		this.fichaDadosRepository.save(this.fichaDados);
		
		this.fichaDadosResultado = new FichaDadosResultado();
		
		List<Object[]> fichaList = this.fichaDadosResultadoRepository.findAllRegisters();
		
		for (Object[] dados : fichaList) {
			this.fichaDadosResultado.setIdFicha((Integer) dados[0]);
			this.fichaDadosResultado.setNomeAluno(dados[1].toString());
			this.fichaDadosResultado.setMatricula(dados[2].toString());
			this.fichaDadosResultado.setAtivo((Boolean) dados[3]);
			this.fichaDadosResultado.setNomeResponsavel(dados[4].toString());
			this.fichaDadosResultado.setParentesco(dados[5].toString());
			this.fichaDadosResultado.setNomeProfessor(dados[6].toString());
			this.fichaDadosResultado.setMateria(dados[7].toString());
			this.fichaDadosResultado.setDiaAula(dados[8].toString());
			this.fichaDadosResultado.setNumSala(dados[9].toString());
		}
		
		out.printf("%n[Ficha Final] Inclusão realizada com sucesso: %s%n", this.fichaDadosResultado);
		this.fichaDadosResultadoRepository.save(this.fichaDadosResultado);
	}

	public Collection<FichaDados> obterRegistros() {
		return (Collection<FichaDados>) this.fichaDadosRepository.findAll();
	}

	public Collection<FichaDadosResultado> obterRegistrosOficial() {
		return (Collection<FichaDadosResultado>) this.fichaDadosResultadoRepository.findAll();
	}
	
	public void excluir(Integer id) {
		this.fichaDadosRepository.deleteById(id);
		this.fichaDadosResultadoRepository.deleteById(id);
	}
}