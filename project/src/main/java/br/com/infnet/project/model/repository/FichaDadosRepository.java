package br.com.infnet.project.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.project.model.domain.FichaDados;

@Repository
public interface FichaDadosRepository extends CrudRepository<FichaDados, Integer> {

	@Query(value = "SELECT a.id_aluno, r.id_responsavel, p.id_professor FROM taluno a "
			+ "INNER JOIN tresponsavel r ON a.id_aluno = r.id_aluno "
			+ "INNER JOIN tprofessor p ON a.id_aluno = p.id_aluno "
			+ "ORDER BY a.id_aluno DESC LIMIT 1;", nativeQuery = true)
	List<Object[]> findAllIds();
}