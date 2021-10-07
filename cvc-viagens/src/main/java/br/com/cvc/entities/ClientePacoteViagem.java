package br.com.cvc.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_pacote_viagem")
public class ClientePacoteViagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ClientePacoteViagemId id;
	

	public ClientePacoteViagem() {

	}

	public ClientePacoteViagem(ClientePacoteViagemId id) {
		super();
		this.id = id;
	}

	public ClientePacoteViagemId getId() {
		return id;
	}

	public void setId(ClientePacoteViagemId id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePacoteViagem other = (ClientePacoteViagem) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientePacoteViagem [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
