package br.com.cvc.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AvaliacaoPerguntaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long idPergunta;
	@NotNull
	private Long idAvaliacao;

	public AvaliacaoPerguntaDTO(Long idPergunta, Long idAvaliacao) {
		super();
		this.idPergunta = idPergunta;
		this.idAvaliacao = idAvaliacao;
	}
	
	public AvaliacaoPerguntaDTO() { }

	public Long getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}		
}
