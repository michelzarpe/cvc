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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvaliacao;
	
	private Long idPacoteViagem;
	
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "avaliacao",fetch = FetchType.EAGER)
	List<AvaliacaoPergunta> avaliacaoPerguntas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "avaliacao",fetch = FetchType.LAZY)
	List<Anexo> anexos;
	
	
	public Avaliacao() {}

	public Avaliacao(Long idAvaliacao, Long idPacoteViagem, String status) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.idPacoteViagem = idPacoteViagem;
		this.status = status;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Long getIdPacoteViagem() {
		return idPacoteViagem;
	}

	public void setIdPacoteViagem(Long idPacoteViagem) {
		this.idPacoteViagem = idPacoteViagem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AvaliacaoPergunta> getAvaliacaoPerguntas() {
		return avaliacaoPerguntas;
	}

	public void setAvaliacaoPerguntas(List<AvaliacaoPergunta> avaliacaoPerguntas) {
		this.avaliacaoPerguntas = avaliacaoPerguntas;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAvaliacao, idPacoteViagem, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		return Objects.equals(idAvaliacao, other.idAvaliacao) && Objects.equals(idPacoteViagem, other.idPacoteViagem)
				&& status == other.status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avaliacao [idAvaliacao=");
		builder.append(idAvaliacao);
		builder.append(", idPacoteViagem=");
		builder.append(idPacoteViagem);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
}
