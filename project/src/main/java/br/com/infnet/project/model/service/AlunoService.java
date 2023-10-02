package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.project.enums.EnumSalaAula;
import br.com.infnet.project.exception.EnumSalaAulaException;
import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	public AlunoService() {
	}

	public void incluir(Aluno aluno) throws EnumSalaAulaException {
	
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
		
        out.printf("%n[Aluno] Inclusão realizada com sucesso: %s%n", aluno);
		
		alunoRepository.save(aluno);
	}

	public void excluir(Integer id) {
		alunoRepository.deleteById(id);
	}

	public Collection<Aluno> obterLista() {
		return (Collection<Aluno>) alunoRepository.findAll();
	}
}