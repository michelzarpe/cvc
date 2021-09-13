package br.com.cvc.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "viagem")
public class Viagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idViagem;
	
	@NotEmpty(message = "Descrição não pode ser null ou vazio")
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "viagem",fetch = FetchType.EAGER)
	private List<PacoteViagem> pacotesViagens;

	public Viagem() { }
	
	public Viagem(Long idViagem, String descricao) {
		this.idViagem = idViagem;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(Long idViagem) {
		this.idViagem = idViagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, idViagem);
	}

	public List<PacoteViagem> getPacotesViagens() {
		return pacotesViagens;
	}

	public void setPacotesViagens(List<PacoteViagem> pacotesViagens) {
		this.pacotesViagens = pacotesViagens;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(idViagem, other.idViagem);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Viagem [idViagem=");
		builder.append(idViagem);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append("]");
		return builder.toString();
	}
	
	
 
	
	
	
}
