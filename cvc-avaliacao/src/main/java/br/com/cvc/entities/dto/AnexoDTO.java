package br.com.cvc.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AnexoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private Long IdCliente;

	@NotNull
	private Long idAvaliacao;
	
	@NotEmpty(message = "Arquivo não pode ser null ou vazio")
	private String arquivo;
	
	@NotEmpty(message = "Type não pode ser null ou vazio")
	private String type;

	public AnexoDTO(Long idCliente, Long idAvaliacao, String arquivo, String type) {
		super();
		IdCliente = idCliente;
		this.idAvaliacao = idAvaliacao;
		this.arquivo = arquivo;
		this.type = type;
	}
	
	public AnexoDTO() { }

	public Long getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Long idCliente) {
		IdCliente = idCliente;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
