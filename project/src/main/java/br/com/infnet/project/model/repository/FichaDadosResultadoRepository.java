package br.com.infnet.project.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.project.model.domain.FichaDadosResultado;

@Repository
public interface FichaDadosResultadoRepository extends CrudRepository<FichaDadosResultado, Integer> {

	@Query(value = "SELECT f.id_ficha, a.nome_aluno, a.matricula, a.ativo, "
			+ "r.nome_responsavel, r.parentesco, p.nome_professor, "
			+ "p.materia, p.dia_aula, p.num_sala FROM tficha_dados f "
			+ "INNER JOIN taluno a ON f.id_aluno = a.id_aluno "
			+ "INNER JOIN tresponsavel r ON f.id_aluno = r.id_aluno "
			+ "INNER JOIN tprofessor p ON f.id_aluno = p.id_aluno "
			+ "ORDER BY f.id_ficha DESC LIMIT 1;", nativeQuery = true)
	List<Object[]> findAllRegisters();
}