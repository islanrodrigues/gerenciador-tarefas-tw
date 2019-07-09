package br.com.islanrodrigues.gerenciamentotarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.islanrodrigues.gerenciamentotarefas.model.Usuario;
import br.com.islanrodrigues.gerenciamentotarefas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
	
	
	public void salvarUsuario(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));		
		repository.save(usuario);
	}
}
