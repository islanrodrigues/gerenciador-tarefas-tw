package br.com.islanrodrigues.gerenciamentotarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.islanrodrigues.gerenciamentotarefas.model.Usuario;
import br.com.islanrodrigues.gerenciamentotarefas.service.UsuarioService;

@Controller
public class ContaController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/login")
	public String login() {
		return "conta/login";
	}
	
	
	@GetMapping("/registration")
	public ModelAndView registrar() {
		ModelAndView model = new ModelAndView();
		model.setViewName("conta/registrar");
		model.addObject("usuario", new Usuario());
		
		return model;
	}
	
	
	@PostMapping("/registration")
	public ModelAndView registrar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView model = new ModelAndView();
		Usuario usuarioEncontrado = usuarioService.buscarPorEmail(usuario.getEmail());
		
		if (usuarioEncontrado != null) {
			result.rejectValue("email", "", "Usuário já cadastrado!");
		}
		
		if (result.hasErrors()) {
			model.setViewName("conta/registrar");
			model.addObject("usuario", usuario);
		
		} else {
			usuarioService.salvarUsuario(usuario);
			model.setViewName("redirect:/login");
		}
		
		return model;
	}
	
}
