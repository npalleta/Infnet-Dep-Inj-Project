package br.com.infnet.project;

// import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
// import java.util.HashMap;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.service.AlunoService;

@Order(1)
@Component
public class AlunoLoader implements ApplicationRunner {

	private Aluno aluno;

	private String[] campos;
	
	@Autowired
	private AlunoService alunoService;
	
	// private Map<Integer, Aluno> mapaAluno; 

	public AlunoLoader() {
		this.campos = new String[0];
		// this.mapaAluno = new HashMap<>();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		FileReader arquivo = new FileReader("dados/aluno.txt", StandardCharsets.UTF_8);
		BufferedReader leitura = new BufferedReader(arquivo);
		
		String linha = leitura.readLine();
		
		while (linha != null) {
			campos = linha.split(";");
			this.aluno = new Aluno(
				Integer.valueOf(campos[0]),
				campos[1],
				campos[2],
				Boolean.valueOf(campos[3]),
				Integer.valueOf(campos[4])
			);
			
			// this.mapaAluno.put(aluno.getIdAluno(), aluno);
			this.alunoService.incluir(this.aluno);
			
			linha = leitura.readLine();
		}
		
        /* for (Aluno aluno : mapaAluno.values()) {
        	out.printf("[Aluno] Inclusão realizada com sucesso: %s%n", aluno);
        } */

        leitura.close();
	}
}