package br.com.infnet.project;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.Professor;

@Order(4)
@Component
public class ProfessorLoader implements ApplicationRunner {

	private Professor professor;

	private String[] campos;

	private Map<Integer, Professor> mapaProfessor;

	public ProfessorLoader() {
		this.campos = new String[0];
		this.mapaProfessor = new HashMap<>();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader arquivo = new FileReader("dados/professor.txt", StandardCharsets.UTF_8);
		BufferedReader leitura = new BufferedReader(arquivo);

		String linha = leitura.readLine();

		while (linha != null) {
			
			campos = linha.split(";");
			
			this.professor = new Professor(
				Integer.valueOf(campos[0]),
				Integer.valueOf(campos[1]),
				campos[2],
				campos[3],
				campos[4],
				new Aluno() // CRIAR ALUNO
			);
			
			this.mapaProfessor.put(professor.getIdProfessor(), professor);
			linha = leitura.readLine();
		}

		for (Professor professor : mapaProfessor.values()) {
			out.printf("[Professor] Inclusão realizada com sucesso: %s%n", professor);
		}

		leitura.close();
	}
}