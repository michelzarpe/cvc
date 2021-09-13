package br.com.cvc.dto;

import java.io.Serializable;
import java.util.Objects;

public class EmailDTO implements Serializable{
	private static final long serialVersionUID = 1L;
    
	private Long idCliente;
	private Long idPacoteViagem;
	private Long idAvaliacao;
	private String email;
	private String nome;
	
	public EmailDTO() { }
	
	public EmailDTO(Long idCliente, Long idPacoteViagem, Long idAvaliacao, String email, String nome) {
		super();
		this.idCliente = idCliente;
		this.idPacoteViagem = idPacoteViagem;
		this.idAvaliacao = idAvaliacao;
		this.email = email;
		this.nome = nome;
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

	public Long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, idAvaliacao, idCliente, idPacoteViagem, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailDTO other = (EmailDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(idAvaliacao, other.idAvaliacao)
				&& Objects.equals(idCliente, other.idCliente) && Objects.equals(idPacoteViagem, other.idPacoteViagem)
				&& Objects.equals(nome, other.nome);
	}

}
