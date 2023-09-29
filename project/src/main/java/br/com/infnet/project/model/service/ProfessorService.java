package br.com.infnet.project.model.service;

// import static java.lang.System.out;

import java.util.Collection;
// import java.util.HashMap;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.project.enums.EnumSalaAula;
import br.com.infnet.project.exception.EnumSalaAulaException;
import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.Professor;
import br.com.infnet.project.model.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	// private Map<Integer, Professor> mapaProfessor = new HashMap<>();

	// private Integer id;

	public ProfessorService() {
		// this.id = 0;
		// this.mapaProfessor = new HashMap<>();
	}

	public void incluir(Professor professor, Aluno aluno) {
		/*
			this.id++;
			professor.setIdProfessor(this.id);
			professor.setIdAluno(this.id);
		*/
		professor.setIdAluno(aluno.getIdAluno());
		professor.setNumSala(aluno.getNumSala());
		
		professor.setMateria(EnumSalaAula.devolverMateria(professor.getNumSala()));

		boolean enumSalaEncontrada = false;

		for (EnumSalaAula enumSalaAula : EnumSalaAula.values()) {
			if (enumSalaAula.numeroSala == professor.getNumSala()) {
				enumSalaEncontrada = true;
				break;
			}
		}

		if (!enumSalaEncontrada) {
			throw new EnumSalaAulaException();
		}

		// mapaProfessor.put(professor.getIdProfessor(), professor);
		// out.printf("[Professor] Inclusão realizada com sucesso: %s%n", professor);
		professorRepository.save(professor);
	}

	public void excluir(Integer id) {
		// mapaProfessor.remove(id);
		professorRepository.deleteById(id);
	}

	public Collection<Professor> obterLista() {
		// return mapaProfessor.values();
		return (Collection<Professor>) professorRepository.findAll();
	}
}