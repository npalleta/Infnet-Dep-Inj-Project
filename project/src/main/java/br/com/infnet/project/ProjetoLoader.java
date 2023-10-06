package br.com.infnet.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.project.controller.AppController;
import br.com.infnet.project.model.domain.app.Atributo;
import br.com.infnet.project.model.domain.app.Classe;
import br.com.infnet.project.model.domain.app.Projeto;

@Order(5)
@Component
public class ProjetoLoader implements ApplicationRunner {

	@Autowired
	private AppController appController;

	@SuppressWarnings("null")
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader arquivo = new FileReader("dados/projeto.txt", StandardCharsets.UTF_8);
		BufferedReader leitura = new BufferedReader(arquivo);

		String linha = leitura.readLine();

		String[] campos = null;
		Projeto projeto = null;
		Classe classe = null;

		while (linha != null) {
			campos = linha.split(";");

			switch (campos[0]) {
			case "P":
				projeto = new Projeto(campos[1], campos[2]);
				projeto.setClasses(new ArrayList<Classe>());
				break;
			case "C":
				classe = new Classe(campos[1]);
				classe.setAtributos(new ArrayList<Atributo>());
				projeto.getClasses().add(classe);
				break;
			case "A":
				classe.getAtributos().add(new Atributo(campos[1], campos[2], campos[3]));
				break;
			default:
				break;
			}

			linha = leitura.readLine();
		}

		appController.incluir(projeto);

		leitura.close();
	}
}