package br.com.infnet.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import br.com.infnet.project.model.domain.Aluno;
import br.com.infnet.project.model.domain.Professor;
import br.com.infnet.project.model.domain.Responsavel;
import br.com.infnet.project.model.service.FichaDadosService;

@Controller
public class FichaDadosController {

	@Autowired
	private FichaDadosService fichaDadosService;

	// private List<String> fichaEfetiva;

	public FichaDadosController() {
		// this.fichaEfetiva = new ArrayList<>();
	}

	@GetMapping(value = "/ficha/lista")
	public String lista(Model model, HttpSession session, SessionStatus status) {
		/*
			List<Object[]> dados = (List<Object[]>) this.fichaDadosService.obterRegistroOficial();
	
			this.fichaEfetiva = dados.stream()
				.flatMap(Arrays::stream)
				.filter(dado -> dado != null && !dado.toString().isEmpty())
				.map(Object::toString)
				.collect(Collectors.toList());
				
			model.addAttribute("listaDados", this.fichaEfetiva);
			model.addAttribute("listaDados", this.fichaDadosService.obterRegistros());
		*/	
		model.addAttribute("listaDados", this.fichaDadosService.obterRegistrosOficial());
		
		status.setComplete();
		
		session.removeAttribute("aluno");
		session.removeAttribute("responsavel");
		session.removeAttribute("professor");
		
		return "ficha/lista";
	}

	@GetMapping(value = "/ficha/cadastro")
	public String cadastro() {
		return "ficha/cadastro";
	}

	@PostMapping(value = "/ficha/incluir")
	public String incluir(
		Aluno aluno,
		Responsavel responsavel,
		Professor professor,
		HttpSession session,
		SessionStatus status
	) {
		this.fichaDadosService.incluir(aluno, responsavel, professor);
		return "redirect:/ficha/lista";
	}
	
	@GetMapping(value = "/ficha/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		this.fichaDadosService.excluir(id);
		return "redirect:/ficha/lista";
	}
}