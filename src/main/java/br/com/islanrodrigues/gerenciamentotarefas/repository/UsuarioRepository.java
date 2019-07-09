package br.com.islanrodrigues.gerenciamentotarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.islanrodrigues.gerenciamentotarefas.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	
}
