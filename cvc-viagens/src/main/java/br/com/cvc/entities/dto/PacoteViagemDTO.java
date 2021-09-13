package br.com.cvc.entities.dto;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PacoteViagemDTO {

	@NotNull
	private Long idViagem;
	
	private Long idAvaliacao;
	
	@NotEmpty(message = "Descrição não pode ser null ou vazio")
	private String descricao;
	
	private ZonedDateTime dataInicio;
	
	private ZonedDateTime dataFim;

	public PacoteViagemDTO(Long idViagem, 
			Long idAvaliacao,
			String descricao, 
			ZonedDateTime dataInicio,
			ZonedDateTime dataFim) {
		super();
		this.idViagem = idViagem;
		this.idAvaliacao = idAvaliacao;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	public PacoteViagemDTO() {}

	public Long getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(Long idViagem) {
		this.idViagem = idViagem;
	}

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ZonedDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(ZonedDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public ZonedDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(ZonedDateTime dataFim) {
		this.dataFim = dataFim;
	}
	
}
