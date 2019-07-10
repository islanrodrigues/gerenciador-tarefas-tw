package br.com.islanrodrigues.gerenciamentotarefas.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "usr_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private Long id;
	
	@NotNull(message = "O e-mail é obrigatório.")
	@Size(min = 5, max = 100, message = "O e-mail deve conter entre 5 e 100 caracteres.")
	@Column(name = "usr_email", nullable = false, length = 100)
	private String email;
	
	@NotNull(message = "A senha é obrigatória.")
	@Column(name = "usr_senha", nullable = false, length = 100)
	private String senha;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Tarefa> tarefas;
	
	
	//-- GETTERS AND SETTERS --
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}
	
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
}

