package br.com.islanrodrigues.gerenciamentotarefas.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.islanrodrigues.gerenciamentotarefas.model.Tarefa;
import br.com.islanrodrigues.gerenciamentotarefas.repository.TarefaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaRepository repository;
	
	
	@GetMapping("/listar")
	public ModelAndView listarTarefas() {
		ModelAndView model = new ModelAndView();
		model.setViewName("tarefas/listar");
		model.addObject("tarefas", repository.findAll()); 
		
		return model;
	}
	
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView model = new ModelAndView();
		model.setViewName("tarefas/inserir");
		model.addObject("tarefa", new Tarefa());
		
		return model;
	}
	
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Tarefa tarefa, BindingResult result) {
		ModelAndView model = new ModelAndView();
		
		if (tarefa.getDataExpiracao() == null) {
			result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida", "A data de expiração é obrigatória");
		
		} else {
			if (tarefa.getDataExpiracao().before(new Date())) {
				result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida", "A data de expiração não pode ser anterior à data atual");
			}			
		}
				
		if (result.hasErrors()) {
			model.setViewName("tarefas/inserir");
			model.addObject(tarefa);
		
		} else {
			repository.save(tarefa);
			model.setViewName("redirect:/tarefas/listar");
		}
		
		return model;
	}
	
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView();
		
		Tarefa tarefa = repository.getOne(id);
		model.setViewName("tarefas/alterar");
		model.addObject("tarefa", tarefa);
		
		return model;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Tarefa tarefa, BindingResult result) {
		ModelAndView model = new ModelAndView();
		
		if (tarefa.getDataExpiracao() == null) {
			result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida", "A data de expiração é obrigatória");
		
		} else {
			if (tarefa.getDataExpiracao().before(new Date())) {
				result.rejectValue("dataExpiracao", "tarefa.dataExpiracaoInvalida", "A data de expiração não pode ser anterior à data atual");
			}			
		}
				
		if (result.hasErrors()) {
			model.setViewName("tarefas/alterar");
			model.addObject(tarefa);
		
		} else {
			repository.save(tarefa);
			model.setViewName("redirect:/tarefas/listar");
		}
		
		return model;
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		repository.deleteById(id);
		
		return "redirect:/tarefas/listar";
	}
	
	
	@GetMapping("/concluir/{id}")
	public String concluir(@PathVariable("id") Long id) {
		Tarefa tarefa = repository.getOne(id);
		tarefa.setConcluida(true);
		repository.save(tarefa);
		
		return "redirect:/tarefas/listar";
	}
	
}
