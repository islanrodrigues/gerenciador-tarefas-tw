package br.com.islanrodrigues.gerenciamentotarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.islanrodrigues.gerenciamentotarefas.model.Tarefa;
import br.com.islanrodrigues.gerenciamentotarefas.repository.TarefaRepository;

import org.springframework.web.bind.annotation.GetMapping;


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
	
}
