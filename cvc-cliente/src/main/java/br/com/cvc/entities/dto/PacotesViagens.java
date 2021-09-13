package br.com.cvc.entities.dto;

import java.io.Serializable;


public class PacotesViagens implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idPacoteViagem;
	private Long idAvaliacao;
	
	public PacotesViagens() {}
	
	public PacotesViagens(Long idPacoteViagem, Long idAvaliacao) {
		super();
		this.idPacoteViagem = idPacoteViagem;
		this.idAvaliacao = idAvaliacao;
	}

	public Long getIdPacoteViagem() {
		return idPacoteViagem;
	}

	public void setIdPacoteViagem(Long idPacoteViagem) {
		this.idPacoteViagem = idPacoteViagem;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	
	
	
}
