package br.com.infnet.project.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.project.model.domain.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {}