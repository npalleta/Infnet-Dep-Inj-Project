package br.com.infnet.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.project.model.domain.Usuario;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	/*
	 @Autowired
	 private UsuarioService usuarioService;
	*/
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader arquivo = new FileReader("dados/usuario.txt", StandardCharsets.UTF_8);
		BufferedReader leitura = new BufferedReader(arquivo);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";"); 
			
			Usuario usuario = new Usuario();
			usuario.setEmail(campos[0]);
			usuario.setNome(campos[1]);
			usuario.setSenha(campos[2]);

			// this.usuarioService.incluirMapaUsuario(usuario);
			
			linha = leitura.readLine();
		}

		leitura.close();			
	}
}