package br.com.infnet.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.infnet.project.exception.EnumSalaAulaException;
import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.service.AlunoService;
import br.com.infnet.project.util.Funcoes;

@Controller
@SessionAttributes("aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	public AlunoController() {
	}

	@GetMapping(value = "/aluno/lista")
	public String lista(Model model) {
		model.addAttribute("listaAluno", alunoService.obterLista());
		return "aluno/lista";
	}

	@GetMapping(value = "/aluno/cadastro")
	public String cadastro(Model model, HttpSession session, SessionStatus status) {
		model.addAttribute("matricula", Funcoes.gerarMatricula());
		
		status.setComplete();
		session.removeAttribute("aluno");
		
		return "aluno/cadastro";
	}

	@PostMapping(value = "/aluno/incluir")
	public String incluir(
		Model model,
		Aluno aluno,
		@RequestParam(value = "ativo", required = false)
		Boolean ativo
	) throws EnumSalaAulaException {
		model.addAttribute("aluno", aluno);
		boolean verificador = (ativo != null) && ativo;
		aluno.setAtivo(verificador);
		alunoService.incluir(aluno);
		return "redirect:/responsavel/cadastro";
	}

	@GetMapping(value = "/aluno/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		this.alunoService.excluir(id);
		return "redirect:/aluno/lista";
	}

	@ExceptionHandler(EnumSalaAulaException.class)
	public String handleNumSalaAulaException(Model model, EnumSalaAulaException ex) {
		model.addAttribute("exception", ex);
		return "erro/erroSalaAula";
	}
}