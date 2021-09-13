package br.com.cvc.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResposta;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_avaliacao_pergunta")
	private AvaliacaoPergunta avaliacaoPergunta;
	
	private Long idCliente;
	
	private int nota;

	public Resposta() {
		
	}
	
	public Resposta(Long idResposta, AvaliacaoPergunta avaliacaoPergunta, Long idCliente, int nota) {
		super();
		this.idResposta = idResposta;
		this.avaliacaoPergunta = avaliacaoPergunta;
		this.idCliente = idCliente;
		this.nota = nota;
	}

	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}

	public AvaliacaoPergunta getAvaliacaoPergunta() {
		return avaliacaoPergunta;
	}

	public void setAvaliacaoPergunta(AvaliacaoPergunta avaliacaoPergunta) {
		this.avaliacaoPergunta = avaliacaoPergunta;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avaliacaoPergunta, idCliente, idResposta, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		return Objects.equals(avaliacaoPergunta, other.avaliacaoPergunta) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(idResposta, other.idResposta) && nota == other.nota;
	}
	
}
