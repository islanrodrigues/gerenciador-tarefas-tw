package br.com.islanrodrigues.gerenciamentotarefas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tar_tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tar_id")
	private Long id;
	
	@Column(name = "tar_descricao", length = 50, nullable = false)
	private String descricao;
	
	@Column(name = "tar_titulo", length = 100)
	private String titulo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "tar_data_expiracao", nullable = false)
	private Date dataExpiracao;
	
	@Column(name = "tar_concluida", nullable = false)
	private Boolean concluida = false;
	
	
	//--- GETTERS AND SETTERS ---
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	
	public Boolean getConcluida() {
		return concluida;
	}
	
	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}
	
	
	

}
