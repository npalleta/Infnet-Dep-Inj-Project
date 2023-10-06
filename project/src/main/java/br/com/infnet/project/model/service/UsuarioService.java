package br.com.infnet.project.model.service;

import static java.lang.System.out;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

	public Collection<Usuario> obterLista() {
		// return this.mapaUsuario.values();
		return (Collection<Usuario>) this.usuarioRepository.findAll();
	}

	public void incluirMapaUsuario(Usuario usuario) {
		this.mapaUsuario.put(usuario.getEmail(), usuario);
		out.println("[Usuário] Inclusão realizada com sucesso: " + usuario);
	}

	public void incluir(Usuario usuario) {
		this.usuarioRepository.save(usuario);
		out.println("[Usuário] Inclusão realizada com sucesso: " + usuario);
	}

	public void exclui(Integer id) {
		this.usuarioRepository.deleteById(id);
	}

	public void excluir(String email) {
		// this.usuarioRepository.delete(email);
	}

	public void excluirPorEmail(String email) {
		// this.usuarioRepository.deleteByEmail(email);
	}

	public Usuario validar(String email, String senha) {
		// Usuario usuario = this.mapaUsuario.get(email);
		List<Usuario> usuarioList = (List<Usuario>) this.usuarioRepository.findAll();
		if (usuarioList != null) {
			if (senha.equalsIgnoreCase(usuarioList.get(0).getSenha()))
				return usuarioList.get(0);
		}
		return null;
	}
}