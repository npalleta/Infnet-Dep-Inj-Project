package br.com.infnet.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.infnet.project.exception.EnumSalaAulaException;
import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.Professor;
import br.com.infnet.project.model.domain.Responsavel;
import br.com.infnet.project.model.service.ProfessorService;

@Controller
@SessionAttributes({ "aluno", "responsavel" })
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	public ProfessorController() {
	}

	@GetMapping(value = "/professor/lista")
	public String lista(Model model) {
		model.addAttribute("listaProfessor", professorService.obterLista());
		return "professor/lista";
	}

	@GetMapping(value = "/professor/cadastro")
	public String cadastro(Model model, Aluno aluno, Responsavel responsavel) {
		model.addAttribute("aluno", aluno);
		model.addAttribute("responsavel", responsavel);		
		return "professor/cadastro";
	}

	@PostMapping(value = "/professor/incluir")
	public String incluir(
		Model model,
		Aluno aluno,
		Professor professor,
		HttpSession session,
		SessionStatus status
	) {
		model.addAttribute("aluno", aluno);

		this.professorService.incluir(professor, aluno);
		
		status.setComplete();

		session.removeAttribute("responsavel");
		session.removeAttribute("aluno");
		
		return "redirect:/professor/lista";
	}

	@GetMapping(value = "/professor/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		this.professorService.excluir(id);
		return "redirect:/professor/lista";
	}

	@ExceptionHandler(EnumSalaAulaException.class)
	public String handleNumSalaAulaException(Model model, EnumSalaAulaException ex) {
		model.addAttribute("exception", ex);
		return "erro/erroSalaAula";
	}
}