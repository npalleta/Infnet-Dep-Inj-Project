package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.project.model.domain.Usuario;
import br.com.infnet.project.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private Map<String, Usuario> mapaUsuario = new HashMap<>();

	public void incluir(Usuario usuario) {
		this.mapaUsuario.put(usuario.getEmail(), usuario);
		out.println("[Usuário] Inclusão realizada com sucesso: " + usuario);
	}

	public void excluir(String email) {
		// usuarioRepository.delete(email);
	}

	public Usuario validar(String email, String senha) {
		Usuario usuario = this.mapaUsuario.get(email);
		if (usuario != null) {
			if (senha.equalsIgnoreCase(usuario.getSenha()))
				return usuario;
		}
		return null;
	}

	public Collection<Usuario> obterLista() {
		return this.mapaUsuario.values();
	}
}