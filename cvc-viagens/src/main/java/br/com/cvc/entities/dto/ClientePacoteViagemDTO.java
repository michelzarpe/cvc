package br.com.cvc.entities.dto;

import javax.validation.constraints.NotNull;

public class ClientePacoteViagemDTO {
    
	@NotNull
	private Long idCliente;
	@NotNull
	private Long idPacoteViagem;

	public ClientePacoteViagemDTO() {}
	
	public ClientePacoteViagemDTO(Long idCliente, Long idPacoteViagem) {
		super();
		this.idCliente = idCliente;
		this.idPacoteViagem = idPacoteViagem;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdPacoteViagem() {
		return idPacoteViagem;
	}

	public void setIdPacoteViagem(Long idPacoteViagem) {
		this.idPacoteViagem = idPacoteViagem;
	}
	
}
