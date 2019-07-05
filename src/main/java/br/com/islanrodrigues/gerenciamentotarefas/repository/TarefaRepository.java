package br.com.islanrodrigues.gerenciamentotarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.islanrodrigues.gerenciamentotarefas.model.Tarefa;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
