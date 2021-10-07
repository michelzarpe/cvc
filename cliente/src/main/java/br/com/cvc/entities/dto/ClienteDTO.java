package br.com.cvc.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Nome não pode ser null ou vazio")
	private String nome;
	
	@Email(message = "Email tem que ser válido")
	private String email;
	
	public ClienteDTO() { }
	
	public ClienteDTO(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
