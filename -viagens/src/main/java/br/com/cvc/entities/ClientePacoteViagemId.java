package br.com.cvc.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ClientePacoteViagemId implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private Long idCliente;
	
	
	@ManyToOne
	@JoinColumn(name = "idPacoteViagem")
	private PacoteViagem pacoteViagem;;
	
	public ClientePacoteViagemId() { }

	public ClientePacoteViagemId(Long idCliente, PacoteViagem pacoteViagem) {
		this.idCliente = idCliente;
		this.pacoteViagem = pacoteViagem;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public PacoteViagem getPacoteViagem() {
		return pacoteViagem;
	}

	public void setPacoteViagem(PacoteViagem pacoteViagem) {
		this.pacoteViagem = pacoteViagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente, pacoteViagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePacoteViagemId other = (ClientePacoteViagemId) obj;
		return Objects.equals(idCliente, other.idCliente) && Objects.equals(pacoteViagem, other.pacoteViagem);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientePacoteViagemId [idCliente=");
		builder.append(idCliente);
		builder.append(", pacoteViagem=");
		builder.append(pacoteViagem);
		builder.append("]");
		return builder.toString();
	}
	
	
}
