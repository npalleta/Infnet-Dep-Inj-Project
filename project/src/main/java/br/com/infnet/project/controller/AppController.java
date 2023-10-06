package br.com.infnet.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.infnet.project.model.domain.app.Projeto;

@Controller
@SessionAttributes({ "aluno", "responsavel" })
public class AppController {

	private Projeto projeto;

	public void incluir(Projeto projeto) {
		this.projeto = projeto;
	}

	@GetMapping(value = "/")
	public String home() {
		return "home";
	}

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}

	@GetMapping(value = "/sobre")
	public String telaSobre(Model model) {
		model.addAttribute("projeto", this.projeto);
		return "sobre";
	}
}