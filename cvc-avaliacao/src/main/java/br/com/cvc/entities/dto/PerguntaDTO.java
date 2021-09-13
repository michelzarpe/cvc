package br.com.cvc.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class PerguntaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Descricao não pode ser null ou vazio")
	private String descricao;

	
	public PerguntaDTO() { }
	
	public PerguntaDTO(String descricao) {
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
