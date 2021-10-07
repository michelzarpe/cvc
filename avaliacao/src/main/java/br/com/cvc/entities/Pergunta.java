package br.com.cvc.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pergunta")
public class Pergunta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPergunta;
	
	@NotEmpty(message = "Descrição não pode ser null ou vazio")
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pergunta",fetch = FetchType.EAGER)
	List<AvaliacaoPergunta> avaliacaoPerguntas;
	
	public Pergunta() { }
	
	public Pergunta(Long idPergunta, String nome) {
		super();
		this.idPergunta = idPergunta;
		this.descricao = nome;
	}
	
	public Long getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public List<AvaliacaoPergunta> getAvaliacaoPerguntas() {
		return avaliacaoPerguntas;
	}

	public void setAvaliacaoPerguntas(List<AvaliacaoPergunta> avaliacaoPerguntas) {
		this.avaliacaoPerguntas = avaliacaoPerguntas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, idPergunta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(idPergunta, other.idPergunta);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [idCliente=");
		builder.append(idPergunta);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
