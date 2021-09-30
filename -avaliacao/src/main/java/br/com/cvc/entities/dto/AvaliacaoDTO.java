package br.com.cvc.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AvaliacaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@NotNull
	private Long idPacoteViagem;
	
	@NotEmpty(message = "Status não pode ser null ou vazio")
	private String status;
	
	public AvaliacaoDTO() {}

	public AvaliacaoDTO(Long idPacoteViagem, String status) {
		super();
		this.idPacoteViagem = idPacoteViagem;
		this.status = status;
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
}
