package br.com.cvc.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RespostaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long idCliente;
	
	@Min(0)
	@Max(10)
	private int nota;
	
	@NotNull
	private Long idAvaliacaoPergunta;
	
	public RespostaDTO() { }

	public RespostaDTO(Long idCliente, int nota, Long idAvaliacaoPergunta) {
		super();
		this.idCliente = idCliente;
		this.nota = nota;
		this.idAvaliacaoPergunta = idAvaliacaoPergunta;
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

	public Long getIdAvaliacaoPergunta() {
		return idAvaliacaoPergunta;
	}

	public void setIdAvaliacaoPergunta(Long idAvaliacaoPergunta) {
		this.idAvaliacaoPergunta = idAvaliacaoPergunta;
	}	
}
