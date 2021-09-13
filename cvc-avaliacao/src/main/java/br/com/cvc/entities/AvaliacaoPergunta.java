package br.com.cvc.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "avaliacao_pergunta")
public class AvaliacaoPergunta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacaoPergunta;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pergunta")
	private Pergunta pergunta;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_avaliacao")
	private Avaliacao avaliacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "avaliacaoPergunta",fetch = FetchType.EAGER)
	List<Resposta> repostas;
	
	public AvaliacaoPergunta() {}

	public AvaliacaoPergunta(Long idAvaliacaoPergunta, Pergunta pergunta, Avaliacao avaliacao) {
		super();
		this.idAvaliacaoPergunta = idAvaliacaoPergunta;
		this.pergunta = pergunta;
		this.avaliacao = avaliacao;
	}

	public Long getIdAvaliacaoPergunta() {
		return idAvaliacaoPergunta;
	}

	public void setIdAvaliacaoPergunta(Long idAvaliacaoPergunta) {
		this.idAvaliacaoPergunta = idAvaliacaoPergunta;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avaliacao, idAvaliacaoPergunta, pergunta);
	}
	


	public List<Resposta> getRepostas() {
		return repostas;
	}

	public void setRepostas(List<Resposta> repostas) {
		this.repostas = repostas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoPergunta other = (AvaliacaoPergunta) obj;
		return Objects.equals(avaliacao, other.avaliacao)
				&& Objects.equals(idAvaliacaoPergunta, other.idAvaliacaoPergunta)
				&& Objects.equals(pergunta, other.pergunta);
	}
	
}
