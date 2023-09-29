package br.com.infnet.project.controller;

import static java.lang.System.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.infnet.project.model.domain.Usuario;
import br.com.infnet.project.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/valida")
	public String validaLogin(Model model, @RequestParam String email, @RequestParam String senha) {
		Usuario user = usuarioService.validar(email, senha);
		out.printf("Credenciais: %s - %s", email, senha);
		if (user != null) {
			model.addAttribute("user", user);
			return "home";
		}
		return "redirect:/login";
	}

	@GetMapping(value = "/usuario/lista")
	public String lista(Model model) {
		model.addAttribute("listaUsuario", usuarioService.obterLista());
		return "usuario/lista";
	}

	@GetMapping(value = "/usuario/cadastro")
	public String cadastro() {
		return "usuario/cadastro";
	}

	@PostMapping(value = "/usuario/incluir")
	public String inclusao(Usuario usuario) {
		usuarioService.incluir(usuario);
		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{email}/excluir")
	public String exclusao(@PathVariable String email) {
		usuarioService.excluir(email);
		return "redirect:/usuario/lista";
	}
}