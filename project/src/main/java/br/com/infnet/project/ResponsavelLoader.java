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
import br.com.infnet.project.model.domain.Responsavel;

@Order(2)
@Component
public class ResponsavelLoader implements ApplicationRunner {

	private Responsavel responsavel;

	private String[] campos;

	private Map<Integer, Responsavel> mapaResponsavel;

	public ResponsavelLoader() {
		this.campos = new String[0];
		this.mapaResponsavel = new HashMap<>();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader arquivo = new FileReader("dados/responsavel.txt", StandardCharsets.UTF_8);
		BufferedReader leitura = new BufferedReader(arquivo);

		String linha = leitura.readLine();

		while (linha != null) {
			
			campos = linha.split(";");
			
			this.responsavel = new Responsavel(
				Integer.valueOf(campos[0]),
				campos[1],
				new Aluno(
					Integer.valueOf(campos[2]),
					campos[3],
					campos[4],
					Boolean.valueOf(campos[5]),
					Integer.valueOf(campos[6])
				),
				campos[7].charAt(0)
			);
			
			this.mapaResponsavel.put(responsavel.getIdResponsavel(), responsavel);
			linha = leitura.readLine();
		}

		for (Responsavel responsavel : mapaResponsavel.values()) {
			out.printf("[Responsável] Inclusão realizada com sucesso: %s%n", responsavel);
		}

		leitura.close();
	}
}