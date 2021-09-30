package br.com.cvc.entities.dto;

import javax.validation.constraints.NotEmpty;

public class ViagemDTO {

	@NotEmpty(message = "Nome não pode ser null ou vazio")
	private String descricao;
	
	public ViagemDTO() {}

	public ViagemDTO(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
