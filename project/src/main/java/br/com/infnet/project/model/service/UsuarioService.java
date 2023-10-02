package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.infnet.project.model.domain.Usuario;

@Service
public class UsuarioService {
	
	private Map<String, Usuario> mapaUsuario = new HashMap<>();

	public void incluir(Usuario usuario) {
		mapaUsuario.put(usuario.getEmail(), usuario);
		out.printf("%n[Usuário] Inclusão realizada com sucesso: %s%n", usuario);
	}

	public void excluir(String email) {
		mapaUsuario.remove(email);
	}

	public Usuario validar(String email, String senha) {
		Usuario usuario = mapaUsuario.get(email);
		if (usuario != null) {
			if (senha.equalsIgnoreCase(usuario.getSenha()))
				return usuario;
		}
		return null;
	}

	public Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}
}