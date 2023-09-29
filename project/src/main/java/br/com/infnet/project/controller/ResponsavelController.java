package br.com.infnet.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.Responsavel;
import br.com.infnet.project.model.service.ResponsavelService;

@Controller
@SessionAttributes({ "aluno", "responsavel" })
public class ResponsavelController {

	@Autowired
	private ResponsavelService responsavelService;

	public ResponsavelController() {
	}

	@GetMapping(value = "/responsavel/lista")
	public String lista(Model model, HttpSession session, SessionStatus status) {
		model.addAttribute("listaResponsavel", responsavelService.obterLista());
		status.setComplete();
		session.removeAttribute("responsavel");
		return "responsavel/lista";
	}

	@GetMapping(value = "/responsavel/cadastro")
	public String cadastro() {
		return "responsavel/cadastro";
	}

	@PostMapping(value = "/responsavel/incluir")
	public String incluir(Model model, Aluno aluno, Responsavel responsavel) {
		model.addAttribute("aluno", aluno);
		this.responsavelService.incluir(responsavel, aluno);
		return "redirect:/professor/cadastro";
	}

	@GetMapping(value = "/responsavel/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		this.responsavelService.excluir(id);
		return "redirect:/responsavel/lista";
	}
}