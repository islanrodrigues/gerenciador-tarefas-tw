package br.com.islanrodrigues.gerenciamentotarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home/home");
		model.addObject("mensagem", "Mensagem da Controller 'Home'");
		
		return model;
	}

}
